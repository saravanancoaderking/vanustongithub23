package com.medeil.repository;

import java.util.List;
import java.util.Map;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.medeil.domain.Edition;
import com.medeil.domain.Role;

@SuppressWarnings("rawtypes")
@Repository

public interface EditionRepository extends JpaRepository<Edition, Long> {

	Edition findById(Integer valueOf);


	@Query(value = "SELECT productid,productname FROM medc_adminsecurity.medc_cproductmaster  where CountryId= :id and status!=2", nativeQuery = true)
	List editionProduct(@Param("id") int id);

	@Query(value = "SELECT DomainID,DomainName FROM medc_adminsecurity.medc_domainmaster WHERE ProductID= :pid and CountryId= :cid and status!=2", nativeQuery = true)
	List getDomainlist(@Param("cid") int cid, @Param("pid") int pid);

	@Query(value = "SELECT SubDomainID,SubDomainName FROM medc_adminsecurity.medc_subdomainmaster WHERE CountryID= :cid and ProductID= :pid and DomainRefID= :did and Status!=2", nativeQuery = true)
	List getSubdomain(@Param("cid") int cid, @Param("pid") int pid, @Param("did") int did);

	@Query(value = "SELECT EditionName FROM medc_adminsecurity.medc_editionmaster WHERE countryID= :cid and ProductID= :pid and DomainRefID= :did and SubDomainrefID= :sdid and EditionName= :editionName and Version= :editionVersion and status!=2", nativeQuery = true)
	public String getCheckEdition(@Param("cid") int cid, @Param("pid") int pid, @Param("did") int did,
			@Param("sdid") int sdid, @Param("editionName") String editionName,
			@Param("editionVersion") String editionVersion);

//	@Query(value = "SELECT c.CountryName,p.ProductName,d.DomainName,sd.SubDomainName,e.EditionName,e.Version,e.status,e.EditionID,e.amount,e.currency,sd.SubDomainID FROM medc_adminsecurity.medc_editionmaster e "
//			+ "INNER JOIN medc_fixedsettings.medc_country c ON e.countryID=c.countryID "
//			+ "INNER JOIN medc_adminsecurity.medc_cproductmaster p ON e.ProductID=p.ProductID "
//			+ "INNER JOIN medc_adminsecurity.medc_domainmaster d ON e.DomainRefID=d.DomainID "
//			+ "INNER JOIN medc_adminsecurity.medc_subdomainmaster sd ON e.SubDomainRefID=sd.SubDomainID where e.editiontype=:ety order by e.EditionID desc", nativeQuery = true)
//	List getEditionlist(@Param("ety") int ety);
	
	
	
	@Query(value = "SELECT c.CountryName,p.ProductName,d.DomainName,sd.SubDomainName,e.EditionName,e.Version,e.status,e.EditionID,e.amount,e.currency,sd.SubDomainID FROM medc_adminsecurity.medc_editionmaster e "
			+ "INNER JOIN medc_fixedsettings.medc_country c ON e.countryID=c.countryID "
			+ "INNER JOIN medc_adminsecurity.medc_cproductmaster p ON e.ProductID=p.ProductID "
			+ "INNER JOIN medc_adminsecurity.medc_domainmaster d ON e.DomainRefID=d.DomainID "
			+ "INNER JOIN medc_adminsecurity.medc_subdomainmaster sd ON e.SubDomainRefID=sd.SubDomainID where e.editiontype=:ety and e.storetype=:storetype order by e.EditionID desc", nativeQuery = true)
	List getAllEditionDetails(@Param("ety") int ety,@Param ("storetype") int storetype );
	
	@Query(value = "SELECT cr.`code` from medc_fixedsettings.medc_currencies cr "
			+ "INNER JOIN medc_adminsecurity.medc_editionmaster em ON em.countryID=cr.countryrefid"
			+ " WHERE em.countryID=?1 group by em.countryid", nativeQuery = true)
	List Viewcurrency(Integer id);
	
	@Query(value = "select EditionID,EditionName,ranking FROM medc_adminsecurity.medc_editionmaster "
			+ "WHERE countryID=?1 and ProductID=?2 and DomainRefID =?3 and SubDomainRefID=?4 and Editiontype=?5", nativeQuery = true)
	List getEditionModules(Integer cid, Integer pid, Integer did, Integer sdid,Integer ety);

	@Query(value = "SELECT EditionID,amount,currency,description FROM medc_adminsecurity.medc_editionmaster WHERE EditionID=?1", nativeQuery = true)
	Map getEditiondetails(Integer eid);
	
	@Query(value = "select cid.CountryID,cna.CountryName,cna.DialingCode from medc_adminsecurity.medc_editionmaster cid   INNER JOIN medc_fixedsettings.medc_country cna on cna.CountryID =cid.countryID GROUP  BY cid.ProductID ", nativeQuery = true)
	List getcountryid();

	@Query(value = "SELECT rc.ModuleID,rc.SubModuleID FROM medc_adminsecurity.medc_role ro INNER JOIN medc_adminsecurity.medc_rolectrl rc on ro.RoleID=rc.RoleID WHERE ro.UserID=0 and ro.Status=:status", nativeQuery = true)
	List getRoleBasedModuledetails(Integer status);
	
	@Query(value = "SELECT ro.RoleID,ro.RoleName FROM medc_adminsecurity.medc_role ro WHERE ro.UserID=0 ", nativeQuery = true)
	List getRoleIdRoleName();
}
