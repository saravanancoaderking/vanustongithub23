
package com.medeil.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * Ajith
 */
import com.medeil.domain.Company;

@SuppressWarnings("rawtypes")
@Repository
public interface CompanyRepository extends JpaRepository<Company, Long> {

	@Query(value = "SELECT ProductName,ProductID FROM medc_adminsecurity.medc_cproductmaster WHERE CountryID=:id", nativeQuery = true)
	List productInfo(@Param("id") int id);

	@Query(value = "SELECT DomainID,DomainName FROM medc_adminsecurity.medc_domainmaster WHERE CountryID= :cid and ProductID= :pid", nativeQuery = true)
	List domainInfo(@Param("cid") int cid, @Param("pid") int pid);

	@Query(value = "SELECT SubDomainID,SubDomainName FROM medc_adminsecurity.medc_subdomainmaster WHERE CountryID= :cid and ProductID= :pid and DomainRefID= :did", nativeQuery = true)
	List subdomainInfo(@Param("cid") int cid, @Param("pid") int pid, @Param("did") int did);

	@Query(value = "SELECT EditionID,EditionName FROM medc_adminsecurity.medc_editionmaster WHERE CountryID= :cid and ProductID= :pid and DomainRefID= :did and SubDomainRefID= :sdid", nativeQuery = true)
	List getEdition(@Param("cid") int cid, @Param("pid") int pid, @Param("did") int did, @Param("sdid") int sdid);

	@Query(value = "SELECT c.CompanyName,c.Shortname,c.Email,CONCAT(c.Address1,',',c.Address2) as Address,co.CountryName,st.StateName ,c.GstNo,p.ProductName ,d.DomainName,sd.SubDomainName,e.EditionName,c.CompanyID FROM medc_companyreg.medc_companyinfomation c "
			+ "INNER JOIN medc_fixedsettings.medc_country co ON c.Country=co.CountryID "
			+ "INNER JOIN medc_fixedsettings.medc_state st ON c.state=st.stateID "
			+ "INNER JOIN medc_adminsecurity.medc_cproductmaster p ON c.ProductRefID=p.ProductID "
			+ "INNER JOIN medc_adminsecurity.medc_domainmaster d ON c.DomainRefID=d.DomainID "
			+ "INNER JOIN medc_adminsecurity.medc_subdomainmaster sd ON c.SubDomainRefID=sd.SubDomainID"
			+ " INNER JOIN medc_adminsecurity.medc_editionmaster e ON c.EditionRefID=e.EditionID WHERE c.Status=0 and p.Status=0 and d.Status=0 and e.Status=0 and sd.Status=0 order by c.CompanyID desc \n#page\n", countQuery="select count(c.companyid) FROM medc_companyreg.medc_companyinfomation c WHERE c.Status=0 order by c.CompanyID desc", nativeQuery = true)
		Page viewCompany(@Param("page") Pageable page);
	
//	\n#page\n", countQuery="select count(ProductDrugID) from medc_productmaster.medc_custproductmaster WHERE DrugStatus!=5 and companyid= :id ORDER BY productDrugID asc", nativeQuery = true)
//			Page viewDrugmasters(@Param("id") int id,@Param("page") Pageable page);
//	Page viewCompany(Pageable paging);

	Company findById(int id);

	@Query(value = "SELECT * FROM medc_fixedsettings.medc_state WHERE  CountryID= :id ", nativeQuery = true)
	List geteditState(@Param("id") int id);

	@Query(value = "SELECT DialingCode  FROM medc_fixedsettings.medc_country  WHERE CountryID= :id", nativeQuery = true)
	List geteditCcode(@Param("id") int id);

	@Query(value = "SELECT CityID,CityName FROM medc_fixedsettings.medc_city WHERE StateID= :id", nativeQuery = true)
	List geteditCity(@Param("id") int id);

	@Modifying
	@Transactional
	@Query(value = "UPDATE medc_companyreg.medc_companyinfomation set Status='2' WHERE CompanyID= :id", nativeQuery = true)
	public void deleteCompany(@Param("id") int id);

	default public void main() {
		System.out.println("Welcome To Interface Declare");
	}

	@Query(value = "SELECT count(CompanyName) as CompanyName  FROM medc_companyreg.medc_companyinfomation WHERE status=0", nativeQuery = true)
	Integer getComopcount();
	
	//selva
	 @Query(value = "select CompanyID FROM medc_companyreg.medc_companyinfomation where companyname= :companyname and shortname= :shortname and country= :country and email= :email and mobileno= :mobile", nativeQuery = true)
		Integer getcompid(@Param("companyname") String companyname, @Param("shortname") String shortname,
				@Param("country") Integer country,@Param("email") String email,@Param("mobile") String mobile);

		@Query(value = "select vat_gst FROM medc_fixedsettings.medc_taxtype where CountryRefID= :country", nativeQuery = true)
		Integer gettaxtype(@Param("country") Integer country);

}
