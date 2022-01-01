package com.medeil.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.medeil.domain.Schemes;



@Repository
public interface SchemeRepository  extends
JpaRepository<Schemes, Long> {
	
	Schemes save(Schemes  sch);
	
	Schemes findById( int id );
	
	@Query( value = " SELECT    IFNULL(  max( SchemeID  ) ,0  )  FROM    medc_patientreg.medc_schemesandrewards      where  LocName=?1 and LocRefID=?2   ", nativeQuery = true  )
	int viewSchemeId( Double lcrnm ,Double lcrid );
	


	@Query( value = "  SELECT    IFNULL( RIGHT( Schemeno, 7  ),0  )    FROM    medc_patientreg.medc_schemesandrewards   where  SchemeID=?3     and    LocName=?1 and LocRefID=?2 ", nativeQuery = true  )
	String viewSchemeIncNo(  Double lcrnm ,Double lcrid  ,  int  id );
	
	@Query( value = "SELECT  SchemeID,Schemeno ,DATE( ClientCDate1  ) FROM medc_patientreg.medc_schemesandrewards   where  LocName=?1 and LocRefID=?2  and   Status!=5       ", nativeQuery = true  )
	List viewSchemeAll(  int lcrnm ,int lcrid    );
	

	@Query( value = "  SELECT   SchemeID , scheme_name, scheme_start_date, scheme_end_date,min_amt_equivalent_point, equivalent_point, reward_type, cash_discount,min_reward_point, level1_reward_point, level1_gift_name,CreatedDate1 ,max(SchemeID)   FROM medc_patientreg.medc_schemesandrewards   where  SchemeID=?3     and    LocName=?1 and LocRefID=?2  and max(SchemeID) ", nativeQuery = true  )
	List viewScheme(   int lcrnm ,int lcrid  , int   id );
	
	
	@Modifying
	@Transactional
	@Query( value = "update   medc_patientreg.medc_schemesandrewards     set   Status=5   where   SchemeID=?3  and  LocName=?1 and LocRefID=?2  ", nativeQuery = true  )
	int deleteScheme(  int lcrnm ,int lcrid  ,  int id);
	
	
}
