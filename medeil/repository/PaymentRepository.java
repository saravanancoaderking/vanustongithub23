


















package com.medeil.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.medeil.domain.Journal;

@Repository
public interface PaymentRepository extends JpaRepository<Journal, Long> {

	Journal save( Journal pt);

	@Query( value = " SELECT PIID, PINO  FROM medc_purchase.medc_purchaseinvoice  where     PINO like  ?3%  and  LocName=?1 and   LocRefID=?2 ", nativeQuery = true  )
	List viewPurchaseInvoiceNo(  int lcrnm, int lcrid ,String name);

	
	@Query( value = "SELECT inv.PIID,  inv.PINO,  IFNULL( inv.grandtotal ,0  ) -  IFNULL( jr.paidinvamt ,0  )  as 'balamt' ,dist.DistributorName ,dist.DistributorID  FROM   medc_purchase.medc_purchaseinvoice   inv      left join  (  SELECT   InvoiceNo,sum( DebitAmount  ) as 'paidinvamt'  FROM medc_accounts.medc_journal   where JrnlType=4 and  InvoiceNo=?3  and invoicetype=3   group by  InvoiceNo   ) jr  on inv.PIID=jr.InvoiceNo  left join (  SELECT DistributorID,DistributorName FROM medc_distributor.medc_distributorinformation  where locrefid=?2  and  LocName=?1  ) dist  on inv.VendorID=dist.DistributorID   where   inv.PIID= ?3   ", nativeQuery = true  )
	List viewPurchaseInvoice( int lcrnm, int lcrid ,int name ) ;

	@Query( value = "SELECT inv.PIID,  inv.PINO,  IFNULL( inv.grandtotal ,0  ) -  IFNULL( jr.paidinvamt ,0  )  as 'balamt' ,dist.DistributorName ,dist.DistributorID,jr.journalid,jr.paidinvamt FROM   medc_purchase.medc_purchaseinvoice   inv left join  (  SELECT   InvoiceNo,sum( debitamount  ) as 'paidinvamt',journalid FROM medc_accounts.medc_journal   where JrnlType=4 and  personid=?3  and invoicetype=3   group by  InvoiceNo   ) jr  on inv.PIID=jr.InvoiceNo left join (  SELECT DistributorID,DistributorName FROM medc_distributor.medc_distributorinformation where locrefid=?2  and  LocName=?1  ) dist  on inv.VendorID=dist.DistributorID   where   inv.vendorid=?3 and IFNULL( inv.grandtotal ,0  ) != IFNULL( jr.paidinvamt ,0  )", nativeQuery = true  )
	List viewVendorPurchaseInvoice( int lcrnm, int lcrid ,int name ) ;
	
	@Query( value = "SELECT inv.srid,  inv.srno,  IFNULL( inv.GrandTotal ,0  ) -  IFNULL( jr.paidinvamt ,0  )  as 'balamt' ,dist.PatientFirstName ,dist.PatientID\r\n" + 
			"FROM   medc_salesreturn.medc_dirsalesreturn   inv\r\n" + 
			"left join  (  SELECT   InvoiceNo,sum( DebitAmount  ) as 'paidinvamt' FROM medc_accounts.medc_journal   where JrnlType=4 and  personid=?3  and invoicetype=2   group by  InvoiceNo   ) jr  on inv.SRID=jr.InvoiceNo\r\n" + 
			"left join (  SELECT  PatientID, PatientFirstName FROM medc_patientreg.medc_patientbasicinfo   where  locrefid=?2  and  LocName=?1  ) dist  on inv.CustomerRefID=dist.PatientID\r\n" + 
			"where   inv.customerrefid=?3 and IFNULL( inv.GrandTotal ,0  ) != IFNULL( jr.paidinvamt ,0  )", nativeQuery = true  )
	List viewCustomersalesreturn( int lcrnm, int lcrid ,int name ) ;

	@Query( value = "  SELECT SRID, SRNo   FROM medc_salesreturn.medc_dirsalesreturn   where     SRNo like  ?3% and  LocName=?1 and   LocRefID=?2", nativeQuery = true  )
	List viewSalesReturnNo( int lcrnm, int lcrid , String name);


	@Query( value = "   SELECT inv.SRID,inv.SRNo,   IFNULL( inv.GrandTotal ,0  ) -  IFNULL( jr.paidinvamt ,0  )  as 'balamt' ,cust.PatientFirstName ,cust.PatientID  FROM  medc_salesreturn.medc_dirsalesreturn  inv     left join  (  SELECT   InvoiceNo,sum( DebitAmount  ) as 'paidinvamt'  FROM medc_accounts.medc_journal   where JrnlType=4 and  InvoiceNo=?3 and invoicetype=2 group by  InvoiceNo   ) jr on inv.SRID=jr.InvoiceNo  left join  (  SELECT  PatientID, PatientFirstName FROM medc_patientreg.medc_patientbasicinfo   where  locrefid=?2  and  LocName=?1   ) cust	on  inv.CustomerRefID=cust.PatientID    where   inv.SRID= ?3    ", nativeQuery = true  )
	List viewSalesReturn(  int lcrnm, int lcrid ,int name);
	


	@Query( value = " SELECT     IFNULL(  max( JournalID  ) ,0  )   FROM   medc_accounts.medc_journal   where  LocRefID=?2  and  LocName=?1 and  JrnlType=4  ", nativeQuery = true  )
	Double viewPaymentId(  Double lcrnm, Double lcrid );
	
	

	

	@Query( value = " SELECT     IFNULL( RIGHT( JournalNo, 7),0  )   FROM    medc_accounts.medc_journal   where  JournalID=?3   and  locrefid=?2  and  LocName=?1 and  JrnlType=4  ", nativeQuery = true  )
	String  viewPaymentIncNo(  Double lcrnm, Double lcrid ,Double name );
	
	@Query( value = "      SELECT  AccountID,AccountName FROM medc_accounts.medc_acount   where   AccountName like  ?3%  and  LocName=?1 and   LocRefID=?2  ", nativeQuery = true  )
	List viewAccounts(  int lcrnm, int lcrid ,String name );

	@Query( value = " SELECT  AccountID, AccountNo, AccountName, AccountType, CreatedBy,  LocName, LocRefID  FROM medc_accounts.medc_acount   where  AccountID=?1  and   LocName=?3 and   LocRefID=?2   ", nativeQuery = true  )
	List viewAccount( int lcrnm, int lcrid , int name );
	
	@Query( value = "      SELECT  AccountID,AccountName FROM medc_accounts.medc_acount   where    LocName=?1 and   LocRefID=?2  ", nativeQuery = true  )
	List viewAccountsAll(  int lcrnm, int lcrid );
	
	
	@Query( value = "  SELECT JournalID,JournalNo,DATE( ClientCDate1  ) , DebitAmount, CreditAmount,      DrAccName, CrAccName,invoicename,personame,ptrefno  FROM medc_accounts.medc_journal    where  LocRefID=?2  and  LocName=?1  and  JrnlType=4   and    Status!=5 ", nativeQuery = true  )
	List viewPaymentAll(  int lcrnm, int lcrid  );
	


	@Query( value = "   SELECT   pt.JournalID,pt. JournalNo  , DATE( pt.ClientCDate1  ) ,pt. debitaccount,pt. creditaccount,      pt. debitamount,pt. creditamount,pt.draccname ,pt.craccname, pt. invoiceno,     pt. invoicebalamt   ,pt.ClientCDate1  as  cldate ,   pt.CashFlag, pt.JrnlName,pt. bulkflag,        pt.delflag, pt.personid, pt.persontype, pt.invoicetype , pt.paymenttype,     pt.ptrefno,pt.invoicename,pt.personame ,pt.jrnltype  FROM medc_accounts.medc_journal      pt    where   pt.JournalID=?3  and  locrefid=?2  and  LocName=?1  and  JrnlType=4   and status!=5  ", nativeQuery = true  )
	List viewPayment(  int lcrnm, int lcrid ,int id);
	
	
	
	
	@Query( value = "SELECT DistributorID,DistributorName  FROM medc_distributor.medc_distributorinformation    where  LocName=?1 and LocRefID=?2   ", nativeQuery = true  )
	List viewDistributors( int lcrnm, int lcrid );
	
	
	
	
	
	
	
	
	@Query( value = "  SELECT inv.PIID,  inv.PINO,  IFNULL( inv.GrandTotal ,0  ) -  IFNULL( jr.paidinvamt ,0  )  as 'balamt'  FROM   medc_purchase.medc_purchaseinvoice   inv     left join  (  SELECT   InvoiceNo,sum( DebitAmount  ) as 'paidinvamt'  FROM medc_accounts.medc_journal   where   JrnlType=4 and personid=?1 and  persontype =2    group by  InvoiceNo   ) jr  on inv.PIID=jr.InvoiceNo   where   inv.VendorID= ?1 ", nativeQuery = true  )
	List viewDistOutstanding( int id);

	@Modifying
	@Transactional
	@Query( value = "update medc_accounts.medc_journal   set  Status=5   where   JournalID=?3  and  LocName=?1 and LocRefID=?2  ", nativeQuery = true  )
	int deletePayment(  int lcrnm, int lcrid ,int id);

	@Query(value = "select pino,grandtotal,dist.distributorname,date(pidate),dist.creditdays,ADDDATE(pidate, INTERVAL dist.creditdays DAY) as creditenddate,CURDATE() from medc_purchase.medc_purchaseinvoice piv\r\n" + 
			"inner join medc_distributor.medc_distributorinformation dist on dist.distributorid = piv.vendorid where ?5 >= ADDDATE(pidate, INTERVAL dist.creditdays DAY) and  piv.companyrefid =?1 and piv.branchrefid =?2 and piv.locname =?3 and piv.locrefid =?4", nativeQuery = true)
	List Viewpaymentout(Integer cid, Integer bid, Integer lname, Integer lrefid,String date);

	@Query(value = "SELECT jr.journalid,jr.invoiceno,jr.creditamount,jr.invoicename,jr.journalno,jr.personid,jr.personame,DATE_FORMAT(jr.createddate,'%d/%m/%Y') FROM medc_accounts.medc_journal jr\r\n" + 
			"inner join medc_patientreg.medc_patientbasicinfo pr  on  jr.personid=pr.patientid\r\n" + 
			"where jr.companyrefid=?1 and jr.branchrefid=?2 and jr.locname=?3 and jr.locrefid=?4 and jr.jrnltype=6 and Date(ADDDATE(jr.createddate,INTERVAL pr.creditdays Day))<=CURDATE()", nativeQuery = true)
	List GetAllCreditAlerts(Integer cid, Integer bid, Integer lname, Integer lrefid);

	@Query(value = "SELECT employeeid,concat(empfirstname,' ',emplastname) FROM medc_employee.medc_employeedetails where companyid =?1 and branchid =?2 and locname =?3 and locrefid =?4", nativeQuery = true)
	List Getemplists(Integer cid, Integer bid, Integer lname, Integer lrefid);

	List<Journal> findByLocrefidAndJrnltype(Double locrefid, int i);

	@Query(value = "SELECT MAX(PIID) as PIID  FROM medc_purchase.medc_purchaseinvoice WHERE CompanyRefID= ?1 and BranchRefID=?2  and  LocName=?3  and LocRefID= ?4", nativeQuery = true)
	Integer getPIID(Integer companyrefid, Integer branchrefid, Double locname, Double locrefid);

	
	List<Journal> findByLocrefidAndJrnltypeAndInvoiceno(Double locrefid, int i, Integer invoiceno);

	@Query( value = " SELECT     IFNULL(  max( JournalID  ) ,0  )   FROM   medc_accounts.medc_journal   where  LocRefID=?2  and  LocName=?1 and  JrnlType=20  ", nativeQuery = true  )
	Double viewbdId(Double locname, Double locrefid);

	@Query( value = " SELECT     IFNULL( RIGHT( JournalNo, 7),0  )   FROM    medc_accounts.medc_journal   where  JournalID=?3   and  locrefid=?2  and  LocName=?1 and  JrnlType=20  ", nativeQuery = true  )
	String viewbdIncNo(Double locname, Double locrefid, Double incid);
	

}









