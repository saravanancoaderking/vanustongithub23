
package com.medeil.repository;

import java.util.Date;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.medeil.domain.Journal;

@Transactional
@Repository
public interface DebitRepository extends JpaRepository<Journal, Long> {

	Journal save(Journal sj);

	@Query(value = " SELECT  IFNULL(  max( JournalID ) ,0 )  FROM   medc_accounts.medc_journal    where  LocRefID=?2  and  LocName=?1 and JrnlType=7  ", nativeQuery = true)
	Double viewDebitNoteId(Double lcrnm, Double lcrid);

	@Query(value = "  SELECT    IFNULL( RIGHT( JournalNo, 7 ),0 )  FROM   medc_accounts.medc_journal   where  JournalID=?3    and  locrefid=?2  and  LocName=?1  and JrnlType=7 ", nativeQuery = true)
	String viewDebitNoteIncNo(Double lcrnm, Double lcrid, Double id);

	@Query(value = "   SELECT    JournalID,JournalNo,DATE( ClientCDate1 ) , DebitAmount, CreditAmount,     DrAccName, CrAccName,invoicename,personame  FROM medc_accounts.medc_journal    where  LocRefID=?2  and  LocName=?1 and  companyrefid=?3 and branchrefid=?4   and JrnlType=7 and Status!=5 ", nativeQuery = true)
	List viewDebitNoteAll(int lcrnm, int lcrid, Integer comp, Integer brnch);

	@Query(value = "     SELECT   pt.JournalID,pt. JournalNo , DATE( pt.ClientCDate1 )  ,pt. debitaccount,pt. creditaccount,    pt. debitamount,pt. creditamount,pt.draccname ,pt.craccname, pt. invoiceno,    pt. invoicebalamt   ,pt.ClientCDate1  as cldate ,   pt.CashFlag, pt.JrnlName,pt. bulkflag,     pt.delflag, pt.personid, pt.persontype, pt.invoicetype, pt.paymenttype,     pt.ptrefno,pt.invoicename,pt.personame,pt.jrnltype  , pt.remarks  FROM medc_accounts.medc_journal  pt    where   pt.JournalID=?3   and  locrefid=?2  and  LocName=?1 and  companyrefid=?4 and branchrefid=?5  and JrnlType=7  and status!=5  ", nativeQuery = true)
	List viewDebitNote(int lcrnm, int lcrid, int id, Integer comp, Integer brnch);

	@Modifying
	@Transactional
	@Query(value = "update    medc_accounts.medc_journal  set   Status=5  where  JournalID=?3 and  LocName=?1 and LocRefID=?2 and  companyrefid=?4 and branchrefid=?5  ", nativeQuery = true)
	int deleteDebitNote(int lcrnm, int lcrid, int id, Integer comp, Integer brnch);

	@Query(value = " SELECT DamageStkID,Damagestockno FROM medc_purchasereturn.medc_damagestocks where CompanyRefID=?1 and BranchRefID=?2 and LocName=?3 and LocRefID=?4 and  status=0 ", nativeQuery = true)
	List getDamageStock(int cid, int bid, int locname, int locrefid);

	@Query(value = "  SELECT stkexpautid,stkexpno FROM medc_stock.medc_stockexpiry where CompanyRefID=?1 and BranchRefID=?2 and LocName=?3 and LocRefID=?4 and status1 =0", nativeQuery = true)
	List getExpiryStock(int cid, int bid, int locname, int locrefid);

	@Query(value = "select d.DistributorName , p.totalAmount , p.damagestockno , p.vendorid FROM medc_purchasereturn.medc_damagestocks p left join medc_distributor.medc_distributorinformation d on d.distributorid=p.vendorid where p.CompanyRefID=?1 and p.BranchRefID=?2 and p.LocName=?3 and p.LocRefID=?4 and p.damagestkid=?5", nativeQuery = true)
	List getDamageStockdetails(int cid, int bid, int locname, int locrefid, int id);

	@Query(value = "SELECT di.DistributorName , stk.totalamt , stk.stkexpno , stk.vendorid FROM medc_stock.medc_stockexpiry stk left join medc_distributor.medc_distributorinformation di on di.distributorid=stk.vendorid where stk.CompanyRefID=?1 and stk.BranchRefID=?2 and stk.LocName=?3 and stk.LocRefID=?4 and stkexpautid=?5", nativeQuery = true)
	List getExpiryStockdetails(int cid, int bid, int locname, int locrefid, int id);

	@Query(value = "SELECT sum(invoicebalamt) FROM medc_accounts.medc_journal m where persontype=2 and invoicetype=3 and personid=?1 and invoiceno=?2 and locrefid=?3", nativeQuery = true)
	Double getinvoiceAmt(Integer personid, Integer invoiceno, Double locrefid);


}
