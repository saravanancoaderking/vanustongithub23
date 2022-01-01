 package com.medeil.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.medeil.domain.Openregister;

@SuppressWarnings("rawtypes")
@Repository
public interface OpenRegisterRepository extends  JpaRepository<Openregister, Long> {
	
	@Query( value = " SELECT    IFNULL(  max( JournalID ) ,0 )  FROM   medc_accounts.medc_journal    where  LocRefID=?2  and  LocName=?1  and JrnlType=9", nativeQuery = true )
	Double viewORJrnlId(Double lcrnm, Double lcrid  );
	
	@Query( value = " SELECT    IFNULL( RIGHT( JournalNo, 7 ),0 )  FROM   medc_accounts.medc_journal  where  JournalID=?3    and  locrefid=?2  and  LocName=?1  and JrnlType=9", nativeQuery = true )
	String viewORJrnlIncNo(Double lcrnm, Double lcrid , Double id);
	
	@Query( value = " SELECT    IFNULL(  max( JournalID ) ,0 )  FROM   medc_accounts.medc_journal    where  LocRefID=?2  and  LocName=?1  and JrnlType=10", nativeQuery = true )
	Double viewCRJrnlId(Double lcrnm, Double lcrid  );
	
	@Query( value = " SELECT    IFNULL( RIGHT( JournalNo, 7 ),0 )  FROM   medc_accounts.medc_journal  where  JournalID=?3    and  locrefid=?2  and  LocName=?1  and JrnlType=10", nativeQuery = true )
	String viewCRJrnlIncNo(Double lcrnm, Double lcrid , Double id);



}


