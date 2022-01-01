package com.medeil.repository;

import java.util.Collection;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.medeil.domain.Journal;

@Repository
public interface ReceiptRepository extends JpaRepository<Journal, Integer> {

	Journal save(Journal rc);

	@Query(value = "  SELECT SalesBillID, SalesBillNo  FROM medc_sales.medc_salesmaintenance   where     SalesBillNo like  ?3%  and SalesBillType =1 and  LocName=?1 and   LocRefID=?2", nativeQuery = true)
	List viewSalesInvoiceNo(int lcrnm, int lcrid, String name);

	//@Query(value = "  SELECT inv.SalesBillID,inv.SalesBillNo,   IFNULL( inv.GrandTotal ,0  ) -  IFNULL( jr.paidinvamt ,0  )  as 'balamt' ,cust.PatientFirstName,cust.PatientID  FROM medc_sales.medc_salesmaintenance   inv   left join  (  SELECT   InvoiceNo,sum( DebitAmount  ) as 'paidinvamt'  FROM medc_accounts.medc_journal   where   JrnlType=5 and  InvoiceNo=?3 and invoicetype=1 group by  InvoiceNo ) jr	on  inv.SalesBillID=jr.InvoiceNo   left join  (  SELECT  PatientID, PatientFirstName FROM medc_patientreg.medc_patientbasicinfo  where locrefid=?2  and  LocName=?1   ) cust	on  inv.CustomerRefID=cust.PatientID     where   inv.SalesBillID= ?3 ", nativeQuery = true)
	@Query(value = "SELECT inv.SalesBillID,inv.SalesBillNo,    IFNULL( jr.paidinvamt ,0  )  as 'balamt' ,cust.PatientFirstName,cust.PatientID\r\n" + 
			"FROM medc_sales.medc_salesmaintenance   inv\r\n" + 
			"left join  (  SELECT   InvoiceNo, creditamount   as 'paidinvamt'  FROM medc_accounts.medc_journal   where   JrnlType=6 and  InvoiceNo=?3 and invoicetype=2 group by  InvoiceNo ) jr	on  inv.SalesBillID=jr.InvoiceNo\r\n" + 
			"left join  (  SELECT  PatientID, PatientFirstName FROM medc_patientreg.medc_patientbasicinfo  where locrefid=?2  and  LocName=?1   ) cust  on  inv.CustomerRefID=cust.PatientID\r\n" + 
			"where   inv.SalesBillID=?3 and  IFNULL( jr.paidinvamt ,0  )!= 0", nativeQuery = true)
	List viewSalesInvoice(int lcrnm, int lcrid, int name);
	
	@Query(value = "  SELECT inv.SalesBillID,inv.SalesBillNo,   IFNULL( jr.paidinvamt ,0  ),cust.PatientFirstName,cust.PatientID  FROM medc_sales.medc_salesmaintenance   inv\r\n" + 
			"inner join  (  SELECT   InvoiceNo,sum( creditamount  ) as 'paidinvamt'  FROM medc_accounts.medc_journal   where   JrnlType=6 and  personid=?3 and invoicetype=2 group by  InvoiceNo ) jr	on  inv.SalesBillID=jr.InvoiceNo\r\n" + 
			"left join  (  SELECT  PatientID, PatientFirstName FROM medc_patientreg.medc_patientbasicinfo  where locrefid=?2  and  LocName=?1   ) cust	on  inv.CustomerRefID=cust.PatientID where   inv.customerrefid= ?3", nativeQuery = true)
	List viewCustomerSalesInvoice(int lcrnm, int lcrid, int name);

	@Query(value = "  SELECT PRID, PRNo FROM medc_purchasereturn.medc_dirpurchasereturn  where     PRNo like  ?3%  and  LocName=?1 and   LocRefID=?2 ", nativeQuery = true)
	List viewPurchaseReturnNo(int lcrnm, int lcrid, String name);

	@Query(value = "   SELECT inv.PRID, inv.PRNo,  IFNULL( inv.GrandTotal ,0  ) -  IFNULL( jr.paidinvamt ,0  )  as 'balamt' ,dist.DistributorName,dist.DistributorID   FROM   medc_purchasereturn.medc_dirpurchasereturn    inv     left join  (  SELECT   InvoiceNo,sum( DebitAmount  ) as 'paidinvamt'  FROM medc_accounts.medc_journal   where JrnlType=5 and  InvoiceNo=?3 and invoicetype=4 group by  InvoiceNo   ) jr  on inv.PRID=jr.InvoiceNo   left join  (  SELECT DistributorID,DistributorName FROM medc_distributor.medc_distributorinformation  where locrefid=?2  and  LocName=?1  ) dist  on inv.VendorID=dist.DistributorID     where   inv.PRID= ?3 ", nativeQuery = true)
	List viewPurchaseReturn(int lcrnm, int lcrid, int name);

	@Query(value = " SELECT    IFNULL(  max( JournalID  ) ,0  )   FROM   medc_accounts.medc_journal   where  LocRefID=?2  and  LocName=?1  and  JrnlType=5 ", nativeQuery = true)
	Double viewReceiptId(Double lcrnm, Double lcrid);

	@Query(value = "  SELECT    IFNULL( RIGHT( JournalNo, 7),0  )  FROM   medc_accounts.medc_journal   where  JournalID=?3    and  locrefid=?2  and  LocName=?1 and  JrnlType=5 ", nativeQuery = true)
	String viewReceiptIncNo(Double lcrnm, Double lcrid, Double id);

	@Query(value = "      SELECT  AccountID,AccountName FROM medc_accounts.medc_acount   where   AccountName like  ?3%  and  LocName=?1 and   LocRefID=?2  ", nativeQuery = true)
	List viewAccounts(int lcrnm, int lcrid, String name);

	@Query(value = " SELECT  AccountID, AccountNo, AccountName, AccountType, CreatedBy,  LocName, LocRefID  FROM medc_accounts.medc_acount   where  AccountID=?3  and   LocName=?1 and   LocRefID=?2   ", nativeQuery = true)
	List viewAccount(int lcrnm, int lcrid, int name);

	@Query(value = "  SELECT    JournalID, JournalNo,DATE( ClientCDate1  )  , DebitAmount, CreditAmount,     DrAccName, CrAccName,invoicename,personame,ptrefno    FROM medc_accounts.medc_journal   where  LocRefID=?2  and  LocName=?1 and  JrnlType=5  and   Status!=5 order by journalid desc", nativeQuery = true)
	List viewReceiptAll(int lcrnm, int lcrid);

	@Query(value = "    SELECT   pt.JournalID,pt. JournalNo , DATE( pt.ClientCDate1  )  ,pt. debitaccount,pt. creditaccount,      pt. debitamount,pt. creditamount,pt.draccname ,pt.craccname, pt. invoiceno,      pt. invoicebalamt ,pt.ClientCDate1  as  cldate,  pt.CashFlag, pt.JrnlName,pt. bulkflag,     pt.delflag, pt.personid, pt.persontype, pt.invoicetype , pt.paymenttype,      pt.ptrefno,pt.invoicename,pt.personame,pt.jrnltype     FROM medc_accounts.medc_journal  pt    where   pt.JournalID=?3   and  locrefid=?2  and  LocName=?1  and  JrnlType=5  and status!=5 ", nativeQuery = true)
	List viewReceipt(int lcrnm, int lcrid, int id);

	@Query(value = " SELECT   PatientID, PatientFirstName    FROM  medc_patientreg.medc_patientbasicinfo       where  LocName=?1 and LocRefID=?2     ", nativeQuery = true)
	List viewCustomers(int lcrnm, int lcrid);

	@Query(value = "   SELECT inv.SalesBillID,inv.SalesBillNo,   IFNULL( inv.GrandTotal ,0 ) -  IFNULL( jr.paidinvamt ,0 )  as 'balamt'  FROM medc_sales.medc_salesmaintenance   inv   left join  (  SELECT   InvoiceNo,sum( DebitAmount  ) as 'paidinvamt'  FROM medc_accounts.medc_journal   where    JrnlType=5 and personid=?1 and persontype =1 group by  InvoiceNo) jr	on  inv.SalesBillID=jr.InvoiceNo    where   inv.CustomerRefID= ?1   and SalesBillType =1   ", nativeQuery = true)
	List viewCustOutstanding( int id);

	@Modifying
	@Transactional
	@Query(value = "update medc_accounts.medc_journal    set   Status=5   where   JournalID=?3  and   LocName=?1 and LocRefID=?2  ", nativeQuery = true)
	int deleteReceipt(int lcrnm, int lcrid, int id);
	
	Journal findByCompanyrefidAndBranchrefidAndLocnameAndLocrefidAndJrnltypeAndInvoiceno(Integer companyId,Integer branchrefid, Double locname, Double locrefid, Integer jrnltype, Integer Invoiceno);
}












