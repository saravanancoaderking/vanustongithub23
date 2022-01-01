package com.medeil.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.medeil.domain.Submodules;

@SuppressWarnings("rawtypes")
public interface SubmodulesRepository extends JpaRepository<Submodules, Long> {
	void deleteByModulerefid(Long id);

	// get country id
	@Query(value = "SELECT  distinct  b.countryid ,a.countryname FROM medc_fixedsettings.medc_country a, medc_adminsecurity.medc_domainmaster b WHERE a.countryid = b.countryid ;", nativeQuery = true)
	List countryaccess();

	// get product id
	@Query(value = "SELECT   ProductID, ProductName  FROM medc_adminsecurity.medc_cproductmaster  where CountryId=:id ;", nativeQuery = true)
	List Product(@Param("id") long id);

	// get domain id
	@Query(value = "SELECT  DomainID, DomainName FROM medc_adminsecurity.medc_domainmaster where   CountryId=?1 and productid=?2", nativeQuery = true)
	List domain(long cty, long pdt);

	// get sub domain id
	@Query(value = "SELECT   SubDomainID,SubDomainName  FROM medc_adminsecurity.medc_subdomainmaster where   CountryId=?1 and productid=?2  and domainrefid=?3", nativeQuery = true)
	List subdomain(long cty, long pdt, long dmn);

	// get modules by id submodmodules

	@Query(value = "SELECT      ModuleID ,  ModuleName  FROM medc_adminsecurity.medc_modulesmaster where  CountryId=?1 and productid=?2  and domainrefid=?3  and subdomainrefid=?4", nativeQuery = true)
	List submodmodules(long cty, long pdt, long dmn, long sdmn);

	// sub module view SELECT
	// m.subdomainid,m.subdomaincode,m.subdomainname,v.countryname,r.productname,g.Domainname,s.ModuleName,p.SubModuleName
	// FROM medc_subdomainmaster m,medc_country v,medc_cproductmaster
	// r,medc_domainmaster g,medc_modulesmaster s,medc_submodulemaster p where
	// m.countryID=v.countryID && m.productID=r.productID &&
	// m.DomainRefID=g.DomainID && m.SubDomainID = s.SubDomainRefID && m.DomainRefID
	// = p.DomainRefID

	@Query(value = "SELECT smd.SubModuleID,sdm.subdomainid,sdm.subdomaincode,sdm.subdomainname,cty.countryname,pdt.productname,dm.Domainname,sdm.SubDomainName  as subdomain,md.ModuleName,smd.SubModuleName ,smd.status  FROM medc_adminsecurity.medc_submodulemaster  smd left join medc_adminsecurity.medc_modulesmaster  md  on  md.ModuleID=smd.ModuleRefID left join  medc_adminsecurity.medc_domainmaster  dm  on  dm.DomainID=smd.DomainRefID left join  medc_adminsecurity.medc_subdomainmaster  sdm  on  sdm.SubDomainID=smd.SubDomainRefID left join  medc_fixedsettings.medc_country  cty  on  cty.countryID=smd.CountryID left join  medc_adminsecurity.medc_cproductmaster  pdt  on  pdt.productID=smd.ProductID  group  by smd.SubModuleID  order  by smd.SubModuleID  desc", nativeQuery = true)
	List SubModulelist();

	@Query(value = "SELECT m.SubModuleID,  m.SubModuleName FROM medc_adminsecurity.medc_submodulemaster m where   m.CountryID=?1 and m.ProductID=?2 and m.DomainRefID=?3 and m.SubDomainRefID=?4 and m.ModuleRefID=?5", nativeQuery = true)
	List getSubModulesNameDropdown(int countryid, int productid, int domainid, int subdomainid, int moduleid);

}
