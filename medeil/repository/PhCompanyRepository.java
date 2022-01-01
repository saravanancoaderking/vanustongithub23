
package com.medeil.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.medeil.domain.PharmaCompany;

@Transactional
@Repository
public interface PhCompanyRepository extends JpaRepository<PharmaCompany, Long> {

	PharmaCompany save(PharmaCompany phcom);

	PharmaCompany findById(int id);

	@Transactional
	@Modifying
	@Query(value = "insert into medc_pharmacompany.medc_companytypeset  ( LocName,LocRefID, PCompanyID,CompanyTypeID ) values ( ?1,?2,?3,?4 )", nativeQuery = true)
	int savecomptype(int lcrnm, int lcrid, int cust_code, int pcompnytype);

	@Transactional
	@Modifying
	@Query(value = "insert into  medc_pharmacompany.medc_divisionset  ( LocName,LocRefID, PCompanyID, PDivisionID  ) values ( ?1,?2,?3,?4 )", nativeQuery = true)
	int savedivision(int lcrnm, int lcrid, int cust_code, int divisioname);

	@Transactional
	@Modifying
	@Query(value = "insert into  medc_pharmacompany.medc_companytype  ( LocName,LocRefID, Companytype) values ( ?1,?2,?3 )", nativeQuery = true)
	int saveIndvComptype(int lcrnm, int lcrid, String pcompnytype);

	@Transactional
	@Modifying
	@Query(value = "insert into  medc_pharmacompany.medc_division  ( LocName,LocRefID,  DivisionName ) values ( ?1,?2,?3 )", nativeQuery = true)
	int saveIndvDivision(int lcrnm, int lcrid, String divisioname);

	@Query(value = "  SELECT * FROM medc_pharmacompany.medc_pharmacompanies     where  LocName=?1 and LocRefID=?2 and    Status!=5  ", nativeQuery = true)
	List viewPhCompanies(int lcrnm, int lcrid);

	@Query(value = "SELECT * FROM  medc_pharmacompany.medc_companytype      where  LocName=?1 and LocRefID=?2 ", nativeQuery = true)
	List viewPhCompany(int lcrnm, int lcrid, int ph);

	@Query(value = "SELECT * FROM  medc_pharmacompany.medc_companytype     where  LocName=?1 and LocRefID=?2 ", nativeQuery = true)
	List viewComptype(int lcrnm, int lcrid);

	@Query(value = "SELECT * FROM  medc_pharmacompany.medc_division      where  LocName=?1 and LocRefID=?2 ", nativeQuery = true)
	List viewDivision(int lcrnm, int lcrid);

	@Query(value = "SELECT * FROM  medc_pharmacompany.medc_companytypeset  where PCompanyID=?3  and   LocName=?1 and LocRefID=?2 ", nativeQuery = true)
	List viewCustComptype(int lcrnm, int lcrid, int pcompnytype);

	@Query(value = "SELECT * FROM  medc_pharmacompany.medc_divisionset  where PCompanyID=?3   and   LocName=?1 and LocRefID=?2  ", nativeQuery = true)
	List viewCustDivision(int lcrnm, int lcrid, int pcompnytype);

	@Query(value = "SELECT  IFNULL( MAX( PCompanyID ),0 ) FROM medc_pharmacompany.medc_pharmacompanies  where    LocName=?1 and LocRefID=?2 ", nativeQuery = true)
	int viewPhCompanyId(int lcrnm, int lcrid);

	@Query(value = "  SELECT   IFNULL( RIGHT( phcompanyno, 7 ),0 )  FROM   medc_pharmacompany.medc_pharmacompanies   where  PCompanyID=?3   and    LocName=?1 and LocRefID=?2", nativeQuery = true)
	String viewPhCompanyIncNo(int lcrnm, int lcrid, int id);

	@Modifying
	@Transactional
	@Query(value = "update medc_pharmacompany.medc_pharmacompanies   set   Status=5   where   PCompanyID=?3   and  LocName=?1 and LocRefID=?2  ", nativeQuery = true)
	int deletePhcompany(int lcrnm, int lcrid, int id);

	// selva
	@Query(value = "SELECT PCompanyID, PCompanyName FROM medc_pharmacompany.medc_pharmacompanies  WHERE PCompanyName LIKE  :value%", nativeQuery = true)
	List getPharmacompany(@Param("value") String value);

	/********* Edit State **************/
	// Boopalan 020419
	@Query(value = "SELECT stateid,statename FROM medc_fixedsettings.medc_state  where stateid = :id ", nativeQuery = true)
	public List editPCState(@Param("id") Integer id);

	/********* Edit City **************/
	// Boopalan 020419
	@Query(value = "SELECT m.CityID, m.CityName FROM medc_fixedsettings.medc_city m where m.CityID =:id ", nativeQuery = true)
	public List editPCCity(@Param("id") Integer id);

	@Query(value = "SELECT pm.PCompanyID,pm.PCompanyName FROM medc_pharmacompany.medc_pharmacompanies  pm INNER JOIN medc_storereg.medc_shopinformation sh ON sh.country=pm.CountryofOrigin AND sh.ShopID=pm.LocRefID WHERE sh.ShopID=?1 or pm.CompanyRefID=1 and pm.Status!=5 and pm.PCompanyName LIKE ?2%", nativeQuery = true)
	List<Object[]> getPharmacompanyList(Integer locrefid, String pharmaname);

}
