package com.medeil.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
//import org.springframework.data.repository.query.Param;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.medeil.domain.Modules;
@SuppressWarnings("rawtypes")
@Repository

public interface ModulesRepository extends JpaRepository<Modules, Long> {

	@Query(value = "SELECT distinct b.countryid ,a.countryname  FROM medc_fixedsettings.medc_country a, medc_adminsecurity.medc_domainmaster b WHERE a.countryid = b.countryid ;", nativeQuery = true)
	List modules();

	// get product by id
	@Query(value = "SELECT    ProductID, ProductName  FROM medc_adminsecurity.medc_cproductmaster  where CountryId=:id", nativeQuery = true)
	List Product(@Param("id") long id);

	// get domain by id
	@Query(value = "SELECT  DomainID, DomainName  FROM medc_adminsecurity.medc_domainmaster where CountryId=?1 and productid=?2", nativeQuery = true)
	List domain(long cty, long pdt);

	// get subdomain by id
	@Query(value = "SELECT  SubDomainID,SubDomainName   FROM medc_adminsecurity.medc_subdomainmaster where  CountryId=?1 and productid=?2  and domainrefid=?3", nativeQuery = true)
	List subdomain(long cty, long pdt, long dmn);

	@Query(value = "SELECT sdm.subdomainid,sdm.subdomaincode,sdm.subdomainname,cty.countryname   ,pdt.productname,dm.Domainname,md.ModuleName,md.status,md.ModuleID s from medc_adminsecurity.medc_modulesmaster  md  left join  medc_adminsecurity.medc_domainmaster  dm  on  dm.DomainID=md.DomainRefID left join  medc_adminsecurity.medc_subdomainmaster  sdm  on  sdm.SubDomainID=md.SubDomainRefID left join  medc_fixedsettings.medc_country  cty on cty.countryID=md.CountryID left join  medc_adminsecurity.medc_cproductmaster  pdt  on  pdt.productID=md.ProductID  group  by md.ModuleID ", nativeQuery = true)
	List Modulelist();

	// SELECT
	// m.subdomainid,m.subdomaincode,m.subdomainname,v.countryname,r.productname,g.Domainname,s.ModuleName
	// FROM medc_subdomainmaster m,medc_country v,medc_cproductmaster
	// r,medc_domainmaster g,medc_modulesmaster s where m.countryID=v.countryID &&
	// m.productID=r.productID && m.DomainRefID=g.DomainID && m.SubDomainID =
	// s.SubDomainRefID
	@Query(value = "SELECT m.ModuleID, m.label FROM medc_adminsecurity.medc_modulesmaster m where  m.CountryID=?1 and m.ProductID=?2 and m.DomainRefID=?3 and m.SubDomainRefID=?4 group by m.label order by m.label asc", nativeQuery = true)
	List getModulesFolderDropdown(int countryid, int productid, int domainid, int subdomainid);

	@Query(value = "SELECT m.ModuleID, m.ModuleName FROM medc_adminsecurity.medc_modulesmaster m where  m.CountryID=?1 and m.ProductID=?2 and m.DomainRefID=?3 and m.SubDomainRefID=?4 and m.label=?5 group by m.modulename order by m.modulename asc", nativeQuery = true)
	List getModulesNameDropdown(int countryid, int productid, int domainid, int subdomainid, String foldername);

	// SELECT
	// m.subdomainid,m.subdomaincode,m.subdomainname,v.countryname,r.productname,g.Domainname
	// FROM medc_subdomainmaster m, medc_country v, medc_cproductmaster r,
	// medc_domainmaster g where m.countryID=v.countryID && m.productID=r.productID
	// && m.DomainRefID=g.DomainID
}
