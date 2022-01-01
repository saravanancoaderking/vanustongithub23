package com.medeil.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.medeil.domain.Subdomain;

@SuppressWarnings("rawtypes")
public interface SubdomainRepository extends JpaRepository<Subdomain, Long> {

	@Query(value = "SELECT productid,productname FROM medc_adminsecurity.medc_cproductmaster  WHERE CountryId= :id and Status!=2", nativeQuery = true)
	List getProduct(@Param("id") int id);

	@Query(value = "SELECT DomainID,DomainName FROM medc_adminsecurity.medc_domainmaster WHERE productid= :id and Status!=2", nativeQuery = true)
	List getDomain(@Param("id") Integer id);

	@Query(value = "SELECT dom.DomainName,co.countryName,po.productName,sub.SubDomainCode,sub.SubDomainName,sub.status FROM medc_adminsecurity.medc_subdomainmaster sub "
			+ "INNER JOIN medc_adminsecurity.medc_domainmaster dom ON  sub.DomainRefID=dom.DomainID "
			+ "INNER JOIN medc_fixedsettings.medc_country co ON sub.CountryID=co.CountryID"
			+ " INNER JOIN medc_adminsecurity.medc_cproductmaster po ON sub.productID=po.ProductID  order  by dom.DomainID desc;", nativeQuery = true)
	List Subdomainlist();

	@Query(value = "SELECT sbid,subdomainfields FROM medc_adminsecurity.medc_subdomainfields", nativeQuery = true)
	List getSubdomainDropdown();

//	@Query(value = "SELECT SubDomainName FROM medc_adminsecurity.medc_subdomainmaster WHERE DomainRefID= :did and CountryID= :cid and ProductID= :pid and SubDomainName= :pName", nativeQuery = true)
//	public String checkSubProduct(@Param("did") Integer did, @Param("cid") Integer cid, @Param("pid") Integer pid,
//			@Param("pName") String pName);

}
