package com.medeil.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.medeil.domain.DiscountSettings;

public interface DiscSettingsRepository extends
		JpaRepository<DiscountSettings, Long> {

	DiscountSettings save(DiscountSettings disc);

	
	
	@Query(value = "  SELECT * FROM medc_globalsettings.medc_pricemaster where  LocName=?1 and LocRefID=?2  ", nativeQuery = true)
	List viewPriceSettings(int lcrid, int lcrnm);
	
	
	@Query(value = " SELECT * FROM medc_globalsettings.medc_discountmaster  where  LocName=?1 and LocRefID=?2 ", nativeQuery = true)
	List viewDiscountSettings(int lcrid, int lcrnm);
	
	
	
	
	@Modifying
	@Transactional
	@Query(value = " update  medc_globalsettings.medc_pricemaster   set   PriceFlag=?1  where    LocName=?2 and LocRefID=?3 ", nativeQuery = true)
	void updatePriceSettings(int  id  ,int lcrid ,int lcrnm);
	
	
	
	@Query(value = " SELECT IFNULL( max(ProdMapAutoId) ,0)    FROM   medc_productmaster.medc_productmapping     where  LocName=?1 and LocRefID=?2  ", nativeQuery = true)
	int viewDiscountSettingsId(Double lcrid, Double lcrnm);

	@Query(value = "  SELECT     IFNULL(RIGHT(prodmapno, 7),0)    FROM    medc_productmaster.medc_productmapping   where  ProdMapAutoId=?1    and    LocName=?2 and LocRefID=?3 ", nativeQuery = true)
	String viewDiscountSettingsIncNo(int id, Double lcrid, Double lcrnm);
	
	
	

	@Query(value = "    SELECT * FROM medc_productmaster.medc_productmapping   where  LocName=?1 and LocRefID=?2  group  by   StkExpID ;  ", nativeQuery = true)
	List viewDiscountSettingsAll(int lcrid, int lcrnm);

	@Query(value = "   SELECT  StkExpID, prodmapno    FROM   medc_productmaster.medc_productmapping        where  LocName=?1 and LocRefID=?2   group  by  StkExpID    ", nativeQuery = true)
	List viewDiscountSettingsNo(int lcrid, int lcrnm);

	@Query(value = "  SELECT * FROM medc_productmaster.medc_productmapping   where  LocName=?1 and LocRefID=?2 ", nativeQuery = true)
	List viewDiscountSettings(int dst, int lcrid, int lcrnm);
}
