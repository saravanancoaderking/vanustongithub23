




package com.medeil.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.medeil.domain.Journal;

public interface SJournalRepository extends JpaRepository<Journal, Long> {

	Journal save( Journal sj );




	
	@Query( value = " SELECT   coalesce(  max( JournalID ) ,0 )   FROM   medc_accounts.medc_journal   where  LocRefID=?2  and  LocName=?1   and JrnlType=3  ", nativeQuery = true )
	Double viewSjournalId(Double lcrnm, Double lcrid );

	@Query( value = "   SELECT    coalesce( RIGHT( JournalNo, 7 ),0 )   FROM   medc_accounts.medc_journal   where  JournalID=?3    and  locrefid=?2  and  LocName=?1  and JrnlType=3   ", nativeQuery = true )
	String viewSjournalIncNo(Double lcrnm, Double lcrid ,  Double id );
	

	
		
	
	@Query( value = "    SELECT  JournalID,JournalNo,DATE( ClientCDate1 ) , DebitAmount, CreditAmount,     DrAccName, CrAccName,invoicename,personame   FROM medc_accounts.medc_journal    where  LocRefID=?2  and  LocName=?1   and JrnlType=3  and  Status!=5   ", nativeQuery = true )
	List viewSjournalAll(int lcrnm, int lcrid );


	@Query( value = "   SELECT   pt.JournalID,pt. JournalNo  , DATE( pt.ClientCDate1 ) ,pt. debitaccount,pt. creditaccount,       pt. debitamount,pt. creditamount,pt.draccname ,pt.craccname, pt. invoiceno       ,pt. invoicebalamt   ,pt.ClientCDate1  as  cldate  ,   pt.CashFlag, pt.JrnlName,pt. bulkflag,       pt.delflag, pt.personid, pt.persontype, pt.invoicetype , pt.paymenttype,    pt.ptrefno,pt.invoicename,pt.personame ,pt.jrnltype    FROM medc_accounts.medc_journal  pt    where   pt.JournalID=?3   and  locrefid=?2  and  LocName=?1  and JrnlType=3 and status!=5    ", nativeQuery = true )
	List viewSjournal( int lcrnm, int lcrid ,int id);
	
	
	

	
	@Modifying
	@Transactional
	@Query( value = "update  medc_accounts.medc_journal   set   Status=5   where   JournalID=?3  and  LocName=?1 and LocRefID=?2  ", nativeQuery = true )
	int deleteSjournal( int lcrnm, int lcrid ,int id);
}















