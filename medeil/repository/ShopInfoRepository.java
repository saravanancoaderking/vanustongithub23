package com.medeil.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.medeil.domain.Shop;

@SuppressWarnings("rawtypes")
public interface ShopInfoRepository extends JpaRepository<Shop, Long> {
	List findById(Integer id);

	@Query(value = "SELECT sh.ShopID,sh.ShopName,ci.cityname FROM medc_storereg.medc_shopinformation sh\r\n" + 
			"Left Join medc_fixedsettings.medc_city ci on ci.cityid=sh.city WHERE sh.ShopID=:id and sh.status=0", nativeQuery = true)
	List Shopinfo(@Param("id") int id);
	
	@Query(value = "SELECT ShopID,ShopName FROM medc_storereg.medc_shopinformation WHERE branchId= :branchid and status=0", nativeQuery = true)
	List Shopinfo1(@Param("branchid") int branchid);
	
	@Query(value = "SELECT ShopID,ShopName FROM medc_storereg.medc_shopinformation WHERE companyId= :companyid  and status=0", nativeQuery = true)
	List Shopinfo2(@Param("companyid") int companyid);
	
	@Query(value = "SELECT Branchid,Branchname FROM medc_branchreg.medc_branchinfomation WHERE companyrefId=:companyid  and status=0;", nativeQuery = true)
	List distinfo(@Param("companyid") int companyid);
		
	
	@Query(value ="SELECT s.shopname,s.address1,s.pincode,s.emailid,s.mobileno,c.cityname ,st.statename,co.countryname FROM medc_storereg.medc_shopinformation s\r\n" + 
			"INNER JOIN medc_fixedsettings.medc_city c ON c.cityid = s.city\r\n" + 
			"INNER JOIN medc_fixedsettings.medc_state st ON st.stateid = s.state\r\n" + 
			"INNER JOIN medc_fixedsettings.medc_country co ON co.countryid = s.country\r\n" + 
			"WHERE s.companyrefid =:comid AND s.branchrefid =:branchid AND s.locname =:locname AND s.locrefid=:locrefid", nativeQuery = true)
	List shopdetail(@Param("comid") Integer comid,@Param("branchid") Integer branchid, @Param("locname") Integer locname, @Param("locrefid") Integer locrefid);
}
