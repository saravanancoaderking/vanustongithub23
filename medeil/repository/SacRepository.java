package com.medeil.repository;



import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.medeil.domain.SacCode;

@Repository
public interface SacRepository extends JpaRepository<SacCode, Integer>{
	
	@Query(value="SELECT ss.sacsectionid,ss.sectioncode,ss.sectionname FROM medc_productmaster.medc_sac_section ss",nativeQuery = true)
	List getssectiondetails();
	
	@Query(value="SELECT sg.sacgroupid,sg.groupcode,sg.groupname FROM medc_productmaster.medc_sac_group sg WHERE sg.sectionid=:sectionid",nativeQuery = true)
	List getgroupcode(@Param("sectionid") Integer sectionid);
	
	@Query(value="SELECT sm.saccode,sm.desc_ofservices FROM medc_productmaster.medc_saccode sm 	WHERE sm.grouprefid =:groupid",nativeQuery = true)
	List getsaccode(@Param("groupid") Integer groupid);
	
	@Query(value="SELECT sc.sacsubcode1,sc.sac_subcode1_des FROM medc_productmaster.medc_saccode sc\r\n" + 
			"WHERE sc.grouprefid =:groupid AND sc.saccode =:saccode AND sc.sacsubcode1>'0'",nativeQuery = true)
	List getsacsubcode1(@Param("groupid") Integer groupid,@Param("saccode") Integer saccode);
	
	@Query(value="SELECT sc.sac_subcode2,sc.sac_subcode2_desc FROM medc_productmaster.medc_saccode sc\r\n" + 
			"WHERE sc.grouprefid =:groupid AND sc.saccode =:saccode AND sc.sacsubcode1 =:sacsubcode1 AND sc.sac_subcode2>'0'",nativeQuery = true)
	List getsacsubcode2(@Param("groupid") Integer groupid,@Param("saccode") Integer saccode,@Param("sacsubcode1") String sacsubcode1  );

	Optional<SacCode> findBySectioncodeAndGroupcodeAndSaccode(Integer sectioncode, Integer groupcode, Integer saccode);

	

	
}
