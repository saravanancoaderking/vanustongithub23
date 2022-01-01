package com.medeil.repository;

import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.medeil.domain.Account;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {

	Account save(Account pt);

	@Transactional
	@Modifying
	@Query(value = "insert into medc_accounts.medc_balperiod  (  LocName, LocRefID, accid,  openingbal, closingbal,    Fromdate,   Todate  , CreatedBy ) values ( ?1,?2,?3,?4 ,?5,?6,?7,?8 )", nativeQuery = true)
	int saveAccBalance(int lcrnm, int lcrid, Double id6, Double id1, Double id2, String id4, Date id5,
			Double createdby);

	@Transactional
	@Modifying
	@Query(value = "insert into medc_accounts.medc_balperiod_01  (  LocName, LocRefID, accid,  openingbal, closingbal,    Fromdate,   Todate  , CreatedBy ) values ( ?1,?2,?3,?4 ,?5,?6,?7,?8 )", nativeQuery = true)
	int saveAccBalance_01(int lcrnm, int lcrid, Double id6, Double id1, Double id2, String id4, Date id5,
			Double createdby);

	@Transactional
	@Modifying
	@Query(value = "insert into medc_accounts.medc_tempacctrnsfer(  LocName, LocRefID, DebitAmount, CreditAmount, Fromdate    , Todate , NextFrom,NextTo, CreatedBy )  values( ?1,?2,?3,?4,  ?5,?6,?7,?8,  ?9  )", nativeQuery = true)
	int saveTempAccTrnsfer(int lcrnm, int lcrid, Double id1, Double id2, String id3, String id4, String id5, String id6,
			int createdby);

	@Transactional
	@Modifying
	@Query(value = "update medc_accounts.medc_tempacctrnsfer  set   Fromdate=?3 , Todate=?4 , CreatedBy=?5  where  LocName=?1 and LocRefID=?2  ", nativeQuery = true)
	int saveTempAccTrnsfer_02(int lcrnm, int lcrid, String id3, Date id4, Double createdby);

	@Modifying
	@Transactional
	@Query(value = " update  medc_accounts.medc_acount   set AccBalance=?4  where    AccountID=?3 and  LocName=?1 and LocRefID=?2    ", nativeQuery = true)
	void updateAccBalMain(Integer lcrnm, Integer lcrid, Double accid, Double bal);

	@Modifying
	@Transactional
	@Query(value = " update  medc_accounts.medc_acount   set AccBalance=0  where   ( AccountType=4 ||  AccountType=5  )  and  LocName=?1 and LocRefID=?2  and Status!=5  ", nativeQuery = true)
	void updateAccBalZero(Double lcrnm, Double lcrid);

	@Query(value = "  SELECT  dr21.accountid  , dr9.AccTypeName , dr21.AccountName,  dr21.AccBalance +( ( dr21.BalCalcFlag )*((IFNULL( dr2.dramt1,0 ))- (IFNULL( dr1.cramt1,0 ) )   ) )   as  'curbalance' , dr21.AccBalFlag ,      dr21.AccBalance ,dr21.accountno  FROM medc_accounts.medc_acount  dr21 left  join  ( select  sum( creditamount ) as 'cramt1' , creditaccount from  medc_accounts.medc_journal   where  date(clientcdate)>=?3  and date(clientcdate)<=?4  and LocName=?1 and LocRefID=?2  and Status!=5   and  creditcalcflag!=1  group by creditaccount ) dr1 on     dr21.accountid=dr1.creditaccount left  join  ( select  sum( debitamount ) as 'dramt1' ,debitaccount  from  medc_accounts.medc_journal      where  date(clientcdate)>=?3  and date(clientcdate)<=?4  and LocName=?1 and LocRefID=?2  and Status!=5 and  debitcalcflag!=1 group by debitaccount ) dr2 on    dr21.accountid=dr2.debitaccount    left  join  ( select AccTypeNo,AccTypeName from  medc_accounts.medc_acounttype  ) dr9   on  dr21.AccountType=dr9.AccTypeNo  where    dr21.LocName=?1 and  dr21.LocRefID=?2   ", nativeQuery = true)
	List viewBalanceSheet(Integer lcrnm, Integer lcrid, String from, String to);

	@Query(value = "  SELECT  dr21.accountid  , dr9.AccTypeName , dr21.AccountName, IFNULL( dr2.dramt1,0 ),IFNULL( dr1.cramt1,0 ),IFNULL(dr21.accbalance,0) , dr21.AccBalFlag ,      dr21.AccBalance  FROM medc_accounts.medc_acount  dr21 left  join  ( select  sum( creditamount ) as 'cramt1' , creditaccount from  medc_accounts.medc_journal   where  date(clientcdate)>=?3  and date(clientcdate)<=?4  and LocName=?1 and LocRefID=?2  and Status!=5  and  creditcalcflag!=1 group by creditaccount ) dr1 on     dr21.accountid=dr1.creditaccount left  join  ( select  sum( debitamount ) as 'dramt1' ,debitaccount  from  medc_accounts.medc_journal      where  date(clientcdate)>=?3  and date(clientcdate)<=?4  and LocName=?1 and LocRefID=?2  and Status!=5 and  debitcalcflag!=1 group by debitaccount ) dr2 on    dr21.accountid=dr2.debitaccount    left  join  ( select AccTypeNo,AccTypeName,BalCalcFlag from  medc_accounts.medc_acounttype    ) dr9   on  dr21.AccountType=dr9.AccTypeNo  where    dr21.LocName=?1 and  dr21.LocRefID=?2    and ( dr21.AccountType=4  or  dr21.AccountType=5 ) ", nativeQuery = true)
	List viewPLAccount(Integer lcrnm, Integer lcrid, String from, String to);

	@Query(value = " SELECT  dr21.accountid  , dr9.AccTypeName , dr21.AccountName,  dr21.AccBalance +( ( dr21.BalCalcFlag )*((IFNULL( dr2.dramt1,0 ))- (IFNULL( dr1.cramt1,0 ) )   ) )   as  'curbalance' , dr21.AccBalFlag ,      dr21.AccBalance  FROM medc_accounts.medc_acount  dr21 left  join  ( select  sum( creditamount ) as 'cramt1' , creditaccount from  medc_accounts.medc_journal   where  date(clientcdate)>=?3  and date(clientcdate)<=?4  and LocName=?1 and LocRefID=?2  and Status!=5   and  creditcalcflag!=1  group by creditaccount ) dr1 on     dr21.accountid=dr1.creditaccount left  join  ( select  sum( debitamount ) as 'dramt1' ,debitaccount  from  medc_accounts.medc_journal      where  date(clientcdate)>=?3  and date(clientcdate)<=?4  and LocName=?1 and LocRefID=?2  and Status!=5 and  debitcalcflag!=1 group by debitaccount ) dr2 on    dr21.accountid=dr2.debitaccount    left  join  ( select AccTypeNo,AccTypeName from  medc_accounts.medc_acounttype    ) dr9   on  dr21.AccountType=dr9.AccTypeNo  where    dr21.LocName=?1 and  dr21.LocRefID=?2    and ( dr21.AccountType=4  or  dr21.AccountType=5 ) ", nativeQuery = true)
	Double viewPLAccountClose(Integer lcrnm, Integer lcrid, String from, String to);

	@Query(value = "SELECT  debitaccount,creditaccount,coalesce(debitamount,0),coalesce(creditamount,0),draccname,craccname , JrnlName as'journalname' FROM medc_accounts.medc_journal\r\n" + 
			"where (date(clientcdate)=?3  and LocName=?1 and LocRefID=?2 and Status!=5 and debitamount>0) or (date(clientcdate)=?3  and LocName=?1 and LocRefID=?2 and Status!=5 and creditamount>0) order by journalid desc", nativeQuery = true)
	List viewdayBook(int lcrnm, int lcrid, String id);

	//@Query(value = "   SELECT  dr21.accountid  , dr9.AccTypeName , dr21.AccountName,  IFNULL(dr21.accbalance,0) +( ( dr9.BalCalcFlag )*((IFNULL( dr2.dramt1,0 ))- (IFNULL( dr1.cramt1,0 ) )   ) )   as  'curbalance' , dr21.AccBalFlag ,      dr21.AccBalance  FROM medc_accounts.medc_acount  dr21 left  join  ( select  sum( creditamount ) as 'cramt1' , creditaccount from  medc_accounts.medc_journal   where  date(clientcdate)>=?3  and date(clientcdate)<=?4  and LocName=?1 and LocRefID=?2  and Status!=5   and  creditcalcflag!=1  group by creditaccount ) dr1 on     dr21.accountid=dr1.creditaccount left  join  ( select  sum( debitamount ) as 'dramt1' ,debitaccount  from  medc_accounts.medc_journal      where  date(clientcdate)>=?3  and date(clientcdate)<=?4  and LocName=?1 and LocRefID=?2  and Status!=5 and  debitcalcflag!=1 group by debitaccount ) dr2 on    dr21.accountid=dr2.debitaccount    left  join  ( select AccTypeNo,AccTypeName,BalCalcFlag from  medc_accounts.medc_acounttype     ) dr9   on  dr21.AccountType=dr9.AccTypeNo  where    dr21.LocName=?1 and  dr21.LocRefID=?2    ", nativeQuery = true)
	@Query(value = " SELECT  dr21.accountid  , dr9.AccTypeName , dr21.AccountName,  IFNULL(dr21.accbalance,0),IFNULL( dr2.dramt1,0 ),IFNULL( dr1.cramt1,0 ) , dr21.AccBalFlag ,      dr21.AccBalance  FROM medc_accounts.medc_acount  dr21 left  join  ( select  sum( creditamount ) as 'cramt1' , creditaccount from  medc_accounts.medc_journal   where  date(clientcdate)>=?3  and date(clientcdate)<=?4  and LocName=?1 and LocRefID=?2  and Status!=5   and  creditcalcflag!=1  group by creditaccount ) dr1 on     dr21.accountid=dr1.creditaccount left  join  ( select  sum( debitamount ) as 'dramt1' ,debitaccount  from  medc_accounts.medc_journal      where  date(clientcdate)>=?3  and date(clientcdate)<=?4  and LocName=?1 and LocRefID=?2  and Status!=5 and  debitcalcflag!=1 group by debitaccount ) dr2 on    dr21.accountid=dr2.debitaccount    left  join  ( select AccTypeNo,AccTypeName,BalCalcFlag from  medc_accounts.medc_acounttype     ) dr9   on  dr21.AccountType=dr9.AccTypeNo  where    dr21.LocName=?1 and  dr21.LocRefID=?2    ", nativeQuery = true)
	List viewTrialBalance(int lcrnm, int lcrid, String from, String to);

	@Query(value = "SELECT   dr21.accountid  , dr9.AccTypeName , dr21.AccountName  ,IFNULL( dr1.dramt1,0 )- IFNULL( dr2.cramt1,0 ) as  'flowamt'  FROM medc_accounts.medc_acount  dr21 left  join  ( select sum( DebitAmount ) as 'dramt1' , DebitAccount     from  medc_accounts.medc_journal  where  date(clientcdate)>=?3  and date(clientcdate)<=?4  and LocName=?1 and LocRefID=?2  and Status!=5  and  debitcalcflag!=1 and   CreditAccount in (SELECT AccountID FROM medc_accounts.medc_acount  where  LocName=?1 and  LocRefID=?2 and cashflag=1) group by DebitAccount ) dr1 on     dr21.accountid=dr1.DebitAccount  left  join  ( select  sum( CreditAmount ) as 'cramt1' ,CreditAccount   from  medc_accounts.medc_journal      where  date(clientcdate)>=?3  and date(clientcdate)<=?4  and LocName=?1 and LocRefID=?2  and Status!=5 and  creditcalcflag!=1  and  DebitAccount in (SELECT AccountID FROM medc_accounts.medc_acount  where  LocName=?1 and  LocRefID=?2 and cashflag=1)  group by CreditAccount ) dr2 on    dr21.accountid=dr2.CreditAccount   left  join  ( select AccTypeNo,AccTypeName from  medc_accounts.medc_acounttype ) dr9   on  dr21.AccountType=dr9.AccTypeNo  where   dr21.LocName=?1 and  dr21.LocRefID=?2  and  (IFNULL( dr1.dramt1,0 )- IFNULL( dr2.cramt1,0 ))!=0 ", nativeQuery = true)
	List viewCashFlowStmt(int lcrnm, int lcrid, String from, String to);

	@Query(value = "  SELECT   dr1.journalname, dr1.debitaccount  , dr1.creditaccount,dr1.debitamount ,dr1.creditamount ,      dr21.AccountName as 'draccname', dr3.AccountName as 'craccname', dr21.accountid  'dracc' ,dr3.accountid  as 'cracc'   FROM medc_accounts.medc_acount  dr21   join  ( SELECT  debitaccount,creditaccount,debitamount,creditamount, 'receipt' as'journalname'  FROM medc_accounts.medc_journal   where  date(clientcdate)>=?3  and date(clientcdate)<=?4  and  ( creditaccount=?5  ||  debitaccount=?5  )  ) dr1 on     dr21.accountid=dr1.debitaccount    join  (  SELECT    accountid ,AccountName FROM medc_accounts.medc_acount   where  LocName=?1 and LocRefID=?2   ) dr3   on    dr3.accountid=dr1.creditaccount  where  dr21.LocName=?1 and dr21.LocRefID=?2   ", nativeQuery = true)
	List viewGenLedger(int lcrnm, int lcrid, String from, String to, int id);

	@Query(value = " SELECT  *  FROM medc_accounts.medc_acount   where   LocName=?1 and   LocRefID=?2   ", nativeQuery = true)
	List viewAccountsAll(int lcrnm, int lcrid);

	@Query(value = "SELECT   AccTypeID, AccTypeNo, AccTypeName, BalCalcFlag, AccBalFlag  FROM medc_accounts.medc_acounttype     ", nativeQuery = true)
	List viewAccountType();
	
	@Query(value = "SELECT AccID,AccountName,AccBalance FROM medc_accounts.medc_acount where companyrefid=?1 and branchrefid=?2 and locname=?3 and locrefid=?4 and accounttype=?5", nativeQuery=true)
	List AccTypeLists(Integer cid,Integer bid,Integer lname,Integer lrid,Integer accid);
	
	@Query(value = "SELECT ifnull(accbalance,0) FROM medc_accounts.medc_acount where AccID=?1", nativeQuery=true)
	Integer getprevaccbalance(Integer accid);
	
	@Modifying
	@Transactional
	@Query(value = "update medc_accounts.medc_acount set accbalance=?2 where AccID=?1", nativeQuery=true)
	Integer setNewAccBalance(Integer accid,String accbalance);

	@Query(value = " SELECT  max( Todate  )   FROM medc_accounts.medc_tempacctrnsfer   where  LocName=?1 and LocRefID=?2  ", nativeQuery = true)
	String viewOpeningDate(int lcrnm, int lcrid);

	@Modifying
	@Transactional
	@Query(value = "update medc_accounts.medc_acount  set AccountID=?1  where  AccID=?1  ", nativeQuery = true)
	void updateAccountId(int accid);

	// sabarish accounts validation

	@Query(value = "select count(*) from medc_accounts.medc_acount where accountno=?1 and accounttype=?2  and accountname=?3", nativeQuery = true)
	Integer isexist(String accountno, double accounttype, String accountname);

	/* New Account Balance Sheet for new Customer*/
	@Query(value ="SELECT acname.accstandardid,actype.acctypename,acname.accountname,IFNULL(jr.debit,0),IFNULL(jr1.credit,0),actype.accbalflag,IFNULL(ac.accbalance,0),ac.accountno,actype.acctypeno,actype.BalCalcFlag,ac.accid,IFNULL(jr.debit,0)+IFNULL(ac.accbalance,0) as totaldebitbalance,IFNULL(jr1.credit,0)+IFNULL(ac.accbalance,0) as totalcreditbalance FROM medc_accounts.medc_accountname acname\r\n" + 
			"inner join medc_accounts.medc_acounttype actype on actype.acctypeno = acname.acctyperefid\r\n" + 
			"left join (select accountid,accountno,accbalance,accbalflag,BalCalcFlag,accid,status from medc_accounts.medc_acount where locname =?1 and locrefid =?2) ac on ac.accountid = acname.accstandardid\r\n" + 
			"left join  (select sum(invoicebalamt) as debit,debitaccount from medc_accounts.medc_journal where date(clientcdate)>=?3  and date(clientcdate)<=?4 and locname =?1 and locrefid =?2 group by debitaccount) jr on jr.debitaccount = ac.accountid\r\n" + 
			"left join  (select sum(invoicebalamt) as credit,creditaccount from medc_accounts.medc_journal where date(clientcdate)>=?3  and date(clientcdate)<=?4 and locname =?1 and locrefid =?2 group by creditaccount) jr1 on jr1.creditaccount = ac.accountid where acname.defaultaccount = 1 or ac.status =1 group by accountname", nativeQuery = true)
	List Newbalancesheet(Integer lname, Integer lrid, String startdate, String enddate);

	@Query(value = "SELECT jrnlname,debitaccount,creditaccount,coalesce(debitamount,0),coalesce(creditamount,0),draccname,craccname,coalesce(ptrefno,'NA'),date(clientcdate),personame,invoicename,coalesce(invoicebalamt,0) FROM medc_accounts.medc_journal jr where date(clientcdate)>=?3  and date(clientcdate)<=?4 and jr.locname=?1 and jr.locrefid =?2 order by journalid desc", nativeQuery = true)
	List Newledgerall(Integer lname, Integer lrid, String startdate, String enddate);
	
	@Query(value = "SELECT jrnlname,debitaccount,creditaccount,coalesce(debitamount,0),coalesce(creditamount,0),draccname,craccname,coalesce(ptrefno,'NA'),date(clientcdate),personame,invoicename,coalesce(invoicebalamt,0) FROM medc_accounts.medc_journal where date(clientcdate)>=?3  and date(clientcdate)<=?4 and locname=?1 and locrefid =?2 and personid =?5 and persontype=?6 order by journalid desc", nativeQuery = true)
	List customerledger(Integer lname, Integer lrid, String startdate, String enddate, Integer personid, Integer persontype);
	
	@Query(value = "SELECT jrnlname,debitaccount,creditaccount,coalesce(debitamount,0),coalesce(creditamount,0),draccname,craccname,\r\n" + 
			"coalesce(ptrefno,'NA'),date(clientcdate),personame,invoicename,coalesce(invoicebalamt,0)\r\n" + 
			"FROM medc_accounts.medc_journal where locname=?1 and locrefid =?2 and bankname=?3 order by journalid desc", nativeQuery = true)
	List ViewBankledgerall(Integer lname, Integer lrid, Integer bankid);

	@Query(value = "SELECT patientid,CONCAT(patientfirstname,' ',patientlastname) FROM medc_patientreg.medc_patientbasicinfo where locrefid =?1", nativeQuery=true)
	List Custlist(Integer lrid);

	@Query(value = "SELECT * FROM medc_bank.medc_bankdetails where shoprefid =?1", nativeQuery = true)
	List Banklist(Integer lrid);

	@Query(value = "SELECT * FROM medc_bank.medc_chequebook where companyrefid = ?1 and branchrefid = ?2 and shoprefid =?3", nativeQuery = true)
	List Chequelist(Integer cid, Integer bid, Integer shid);

	@Query(value = "SELECT sum(creditamount) FROM medc_accounts.medc_journal where jrnltype= 2 and date(clientcdate)>=?3  and date(clientcdate)<=?4 and locname=?1 and locrefid =?2", nativeQuery = true)
	List Viewtotalpurchase(Integer lname, Integer lrid, String startdate, String enddate);

	@Query(value = "SELECT sum(si.grandtotal-si.TotalTaxAmt) FROM medc_sales.medc_salesmaintenance si\r\n" + 
			"Inner Join medc_accounts.medc_journal jl on jl.invoiceno=si.salesbillid\r\n" + 
			"where jl.jrnltype= 3 and date(jl.clientcdate)>=?3  and date(jl.clientcdate)<=?4 and jl.locname=?1 and jl.locrefid =?2", nativeQuery = true)
	List Viewtotalsales(Integer lname, Integer lrid, String startdate, String enddate);

	@Query(value = "SELECT COALESCE(sum(closingstock),0) FROM medc_stock.medc_mainstock where locname =?1 and locrefid =?2 and date(CreatedDate)>=?3  and date(CreatedDate)<=?4", nativeQuery = true)
	List Openingstkamnt(Integer lname, Integer lrid, String startdate, String enddate);

	@Query(value = "SELECT COALESCE(sum(qty*unitprice),0) FROM medc_stock.medc_mainstock where locname =?1 and locrefid =?2 and date(CreatedDate)>=?3  and date(CreatedDate)<=?4", nativeQuery = true)
	List Closingstkamnt(Integer lname, Integer lrid, String startdate, String enddate);

	@Query(value = "SELECT coalesce(sum(creditamount)-sum(debitamount),0) FROM medc_accounts.medc_journal where locname=?1 and locrefid =?2 and date(clientcdate)>=?3  and date(clientcdate)<=DATE_SUB(?4, INTERVAL 1 DAY)", nativeQuery = true)
	List openingbal(Integer lname, Integer lrid, String startdate, String enddate);

	@Query(value = "SELECT sum(ifnull(debitamount,0)) FROM medc_accounts.medc_journal m where jrnltype=7 and locrefid=?1 and personid=?2", nativeQuery = true)
	String Depitamt(Integer locrefid, Integer persionid);

	@Query(value = "SELECT sum(ifnull(creditamount,0)) FROM medc_accounts.medc_journal m where jrnltype=6 and locrefid=?1 and personid=?2", nativeQuery = true)
	String Creditamt(Integer locrefid, Integer persionid);

	@Query(value = "SELECT  (SUM(CreditAmount)-SUM(DebitAmount)) as tot from medc_accounts.medc_journal WHERE DebitAccount=60 or CreditAccount=60 and LocName=?1 and LocRefID=?2", nativeQuery = true)
	String viewAccountBalanceDetails(Integer lname, Integer lrid);

	
	
}
