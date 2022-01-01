/**
 * 
 */
package com.medeil.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.medeil.domain.Sample;

/**
 * @author Ajith
 *
 */
@SuppressWarnings("rawtypes")
@Repository
public interface UtilityRepository extends JpaRepository<Sample, Long> {

	@Query(value = "SELECT * FROM medc_fixedsettings.medc_country order by countryname asc", nativeQuery = true)
	List getCountry();

	@Query(value = "SELECT * FROM medc_fixedsettings.medc_state WHERE  CountryID= :countryid ", nativeQuery = true)
	List getState(@Param("countryid") int countryid);

	@Query(value = "SELECT DialingCode  FROM medc_fixedsettings.medc_country  WHERE CountryID= :countryid", nativeQuery = true)
	List getCountrycode(@Param("countryid") int countryid);

	@Query(value = "SELECT CityID,CityName FROM medc_fixedsettings.medc_city WHERE StateID= :sid", nativeQuery = true)
	List getCity(@Param("sid") int sid);

	@Query(value = "SELECT VatTaxID,VAT FROM medc_globalsettings.medc_taxvatmaster", nativeQuery = true)
	List getVat();

	@Query(value = "SELECT GstTaxID,GST FROM medc_globalsettings.medc_taxgstmaster", nativeQuery = true)
	List getGst();

	@Query(value = "SELECT SgstTaxID,SGST FROM medc_globalsettings.medc_taxsgstmaster", nativeQuery = true)
	List getSgst();

	@Query(value = "SELECT CgstTaxID,CGST FROM medc_globalsettings.medc_taxcgstmaster", nativeQuery = true)
	List getCgst();

	@Query(value = "SELECT IgstTaxID,IGST FROM medc_globalsettings.medc_taxigstmaster", nativeQuery = true)
	List getIgst();

	public static final String view = "SELECT * FROM sample";

	@Query(value = view, nativeQuery = true)
	public List<Sample> getSample();

	@Query(value = "SELECT PhotoName FROM medc_productmaster.medc_custprdphoto WHERE DrugProductRefID= :id", nativeQuery = true)
	List getFilename(@Param("id") String id);
	
	//Mani
	@Query(value = "SELECT companyid,companyname FROM medc_companyreg.medc_companyinfomation", nativeQuery = true)
	List getCompany();
	
	@Query(value = "SELECT companyid,companyname FROM medc_companyreg.medc_companyinfomation WHERE CompanyID= :comp", nativeQuery = true)
	List getCompany(@Param("comp") int comp);
	
	@Query(value = "select c.countrycode,count(p.countryid) from medc_fixedsettings.medc_country c left join medc_adminsecurity.medc_cproductmaster p on c.countryid=p.countryid group by p.countryid", nativeQuery = true)
	List getCountryMap();
	
	@Query(value = "SELECT CountryName FROM medc_fixedsettings.medc_country WHERE CountryName like %:term%", nativeQuery = true)
	List getSample(@Param("term") String term);
	
	@Query(value = "SELECT companyid,companyname FROM medc_companyreg.medc_companyinfomation WHERE Status=0", nativeQuery = true)
	List getAllCompany();

}
