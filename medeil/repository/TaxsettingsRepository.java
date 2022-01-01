/**
 * 
 */
package com.medeil.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.medeil.domain.Gstsetting;

/**
 * @author Sabarish
 *
 */
@SuppressWarnings("rawtypes")
@Repository
public interface TaxsettingsRepository extends JpaRepository<Gstsetting, Long> {

	@Query(value = "SELECT CompanyID,CompanyName FROM medc_companyreg.medc_companyinfomation WHERE billingCountry=:id", nativeQuery = true)
	List companyinfo(@Param("id") int id);

	@Query(value = "SELECT BranchID,Branchname FROM medc_branchreg.medc_branchinfomation WHERE CompanyRefID=:id", nativeQuery = true)
	List branchinfo(@Param("id") int id);

	@Query(value = "SELECT ShopID,ShopName FROM medc_storereg.medc_shopinformation WHERE branchID=:id", nativeQuery = true)
	List shopinfo(@Param("id") int id);

	@Query(value = "SELECT warehouseID,Warehousename FROM medc_warehousereg.medc_warehouseinfo WHERE BranchID=:id", nativeQuery = true)
	List warehouseinfo(@Param("id") int id);

	@Query(value = "SELECT HospitalID,Hospitalname FROM medc_hospitalreg.hospitalregistration WHERE BranchRefID=:id", nativeQuery = true)
	List hospitalinfo(@Param("id") int id);

	@Query(value = "SELECT vat_gst FROM medc_fixedsettings.medc_taxsettings  where CompanyRefID= :id", nativeQuery = true)
	List taxtype(@Param("id") int id);

}
