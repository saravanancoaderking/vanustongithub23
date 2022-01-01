package com.medeil.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.medeil.domain.Journal;

@Repository
public interface BalAdjRepository extends JpaRepository<Journal, Long> {
	Journal save(Journal sj);

	@Query(value = " SELECT  IFNULL(  max( JournalID ) ,0 )  FROM   medc_accounts.medc_journal    where  LocRefID=?2  and  LocName=?1 and JrnlType=1  ", nativeQuery = true)
	Double viewJournalId(Double lcrnm, Double lcrid);

	@Query(value = "  SELECT    IFNULL( RIGHT( JournalNo, 7 ),0 )  FROM   medc_accounts.medc_journal   where  JournalID=?3    and  locrefid=?2  and  LocName=?1  and JrnlType=1 ", nativeQuery = true)
	String viewJournalIncNo(Double lcrnm, Double lcrid, Double id);

	@Query(value = " SELECT  IFNULL(  max( JournalID ) ,0 )  FROM   medc_accounts.medc_journal    where  LocRefID=?2  and  LocName=?1 and JrnlType=1  ", nativeQuery = true)
	Double viewGenJournalId(Double lcrnm, Double lcrid);

	@Query(value = "  SELECT    IFNULL( RIGHT( JournalNo, 7 ),0 )  FROM   medc_accounts.medc_journal   where  JournalID=?3    and  locrefid=?2  and  LocName=?1  and JrnlType=1 ", nativeQuery = true)
	String viewGenJournalIncNo(Double lcrnm, Double lcrid, Double id);

	@Query(value = "   SELECT    JournalID,JournalNo,DATE( ClientCDate1 ) , DebitAmount, CreditAmount,     DrAccName, CrAccName,invoicename,personame  FROM medc_accounts.medc_journal    where  LocRefID=?2  and  LocName=?1  and JrnlType=1  and Status!=5 ", nativeQuery = true)
	List viewGenJournalAll(int lcrnm, int lcrid);

	@Query(value = "     SELECT   pt.JournalID,pt. JournalNo , DATE( pt.ClientCDate1 )  ,pt. debitaccount,pt. creditaccount,    pt. debitamount,pt. creditamount,pt.draccname ,pt.craccname, pt. invoiceno,    pt. invoicebalamt   ,pt.ClientCDate1  as cldate ,   pt.CashFlag, pt.JrnlName,pt. bulkflag,     pt.delflag, pt.personid, pt.persontype, pt.invoicetype, pt.paymenttype,     pt.ptrefno,pt.invoicename,pt.personame,pt.jrnltype  FROM medc_accounts.medc_journal  pt    where   pt.JournalID=?3   and  locrefid=?2  and  LocName=?1  and JrnlType=1  ", nativeQuery = true)
	List viewGenJournal(int lcrnm, int lcrid, int id);

	@Modifying
	@Transactional
	@Query(value = "update    medc_accounts.medc_journal  set   Status=5  where  JournalID=?3 and  LocName=?1 and LocRefID=?2  ", nativeQuery = true)
	int deleteGenJournal(int lcrnm, int lcrid, int id);

}
