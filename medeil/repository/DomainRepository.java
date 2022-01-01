package com.medeil.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.medeil.domain.Domain;

/**
 * @author VANUSTON ( AJITH AK )
 *
 */
@SuppressWarnings("rawtypes")
@Repository
public interface DomainRepository extends JpaRepository<Domain, Long> {

	@Query(value = "SELECT productid,productname FROM medc_adminsecurity.medc_cproductmaster  where CountryId= :id and status!=2", nativeQuery = true)
	List getProduct(@Param("id") int id);

	@Query(value = "SELECT d.domainid,c.countryname,p.productname,d.domaincode,d.Domainname,d.status FROM medc_adminsecurity.medc_domainmaster d"
			+ " INNER JOIN medc_fixedsettings.medc_country c on d.CountryID=c.CountryID"
			+ " INNER JOIN medc_adminsecurity.medc_cproductmaster p ON d.ProductID=p.ProductID", nativeQuery = true)
	List domainList();

//	@Query(value = "SELECT DomainName FROM medc_adminsecurity.medc_domainmaster WHERE CountryID= :cid and ProductID= :pid and DomainName= :dname", nativeQuery = true)
//	public String checkProduct(@Param("cid") int cid, @Param("pid") int pid, @Param("dname") String dname);

	@Query(value = "SELECT m.domainid,m.DomainName FROM medc_adminsecurity.medc_domainmaster m where countryid=?1 and productid=?2 order by domainname asc", nativeQuery = true)
	List getDomainByCountryAndProduct(int countryid, int productid);

	@Query(value = "SELECT cn.countryid,cn.countryname FROM medc_adminsecurity.medc_cproductmaster m inner join medc_fixedsettings.medc_country cn on cn.countryid=m.countryid group by m.countryid", nativeQuery = true)
	List domainCountryDropdown();
}
