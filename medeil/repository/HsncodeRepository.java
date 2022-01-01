package com.medeil.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.medeil.domain.Hsncode;

@SuppressWarnings("rawtypes")
@Repository
public interface HsncodeRepository extends JpaRepository<Hsncode,Integer>{

	@Query(value= "SELECT co.countryid ,co.countryname FROM medc_fixedsettings.medc_country co", nativeQuery=true)
	List getcountrys();
	
	@Query(value ="SELECT mdescid,main_description,chapter_id FROM medc_productmaster.medc_hsn_mdescription",nativeQuery = true)
	List getmdescription();
	
	@Query(value = "SELECT id.hsn_id,id.item_description,id.mdrefid FROM medc_productmaster.medc_hsn_idescription id WHERE mdref_id =:mdescid AND country_id =:countryid",nativeQuery = true)
	List getidesc(@Param("mdescid") int mdescid,@Param("countryid") int countryid);

	@Query(value = "SELECT hsnid,hsndescription,hsncode,gst FROM medc_productmaster.medc_hsncodemaster where  chapter = ?1", nativeQuery = true)
	List gethsndesc(Integer mdescid);

	
}
