package com.medeil.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.medeil.domain.Company;
import com.medeil.domain.Shipping;
import com.medeil.domain.Warehouse;

@SuppressWarnings("rawtypes")
@Repository
public interface WarehouseRepository extends JpaRepository<Warehouse, Long> {

	// Warehouse findByid(int id);

	@Transactional
	@Modifying
	@Query(value = "insert into medc_warehousereg.medc_warehouseinfo (countryid,branchid,companyid,productid) select countryid,branchid,companyid,productdrugid from medc_productmaster.medc_custproductmaster where countryid=:id ", nativeQuery = true)
	int accessid(@Param("id") long id);

	
	
	Warehouse findById(int id);
	
	
	
	@Query(value = "SELECT * FROM medc_fixedsettings.medc_state WHERE  CountryID= :id ", nativeQuery = true)
	List geteditState(@Param("id") int id);
	
	
	
	

	@Query(value = "SELECT CityID,CityName FROM medc_fixedsettings.medc_city WHERE StateID= :id", nativeQuery = true)
	List geteditCity(@Param("id") int id);
	
	
	@Query(value = "SELECT * FROM medc_fixedsettings.medc_country ;", nativeQuery = true)
	List country();

	@Query(value = "SELECT * FROM medc_fixedsettings.medc_state  where CountryId=:id ", nativeQuery = true)
	List State(@Param("id") long id);

	@Query(value = "SELECT * FROM medc_fixedsettings.medc_city  where StateID=:id ", nativeQuery = true)
	List city(@Param("id") long id);

	@Query(value = "SELECT * FROM medc_warehousereg.medc_warehouseinfo  where companyrefid=:companyrefid and  branchrefid=:branchrefid and locname=:locname and locrefid=:locrefid", nativeQuery = true)
	List view(@Param("companyrefid") Integer companyrefid, @Param("branchrefid") Integer branchrefid,
			@Param("locname") Integer locname, @Param("locrefid") Integer locrefid);

	@Query(value = "select Warehousename, Warehousecode,Owner_name, Address1, Address2, Address3, City, State, Country,Pincode,"
			+ " Contact_no1,Mobile_no, Email_id, License_holder,TinNo,PanNo, GstNo, "
			+ "Coldstorage from  medc_warehousereg.medc_warehouseinfo "
			+ "where warehouseID= :id and CompanyRefID= :cid and BranchRefID= :bid and LocName= :locname and LocRefID= :locrefid ", nativeQuery = true)
	List editWarehouse(@Param("id") Integer id, @Param("cid") Integer cid, @Param("bid") Integer bid,
			@Param("locname") Integer locname, @Param("locrefid") Integer locrefid);

}
// SELECT * FROM medc_city  where StateID=:id
// insert into medc_warehouseinfo (countryid,branchid,companyid,productid) select countryid,branchid,companyid,productid from med_company where countryid=id
