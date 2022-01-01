package com.medeil.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.medeil.domain.Setupcostsetting;


public interface SetupcostRepository extends JpaRepository<Setupcostsetting,Long>{

	Setupcostsetting findByCompanyrefidAndBranchrefidAndLocnameAndLocrefid(Integer compid, Integer brnchid, Integer lname,
			Integer lrefid);

	@Query( value = " SELECT    IFNULL(  max( JournalID ) ,0 )  FROM   medc_accounts.medc_journal    where  LocRefID=?2  and  LocName=?1  and JrnlType=11", nativeQuery = true )
	Double viewSCJrnlId(Double locname, Double locrefid);

	@Query( value = " SELECT    IFNULL( RIGHT( JournalNo, 7 ),0 )  FROM   medc_accounts.medc_journal  where  JournalID=?3    and  locrefid=?2  and  LocName=?1  and JrnlType=11", nativeQuery = true )
	String viewSCJrnlIncNo(Double locname, Double locrefid, Double incid);

}
