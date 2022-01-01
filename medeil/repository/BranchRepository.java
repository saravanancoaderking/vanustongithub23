/**
 * Manikandan
 */
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

import com.medeil.domain.Branch;

@SuppressWarnings("rawtypes")
@Repository
public interface BranchRepository extends JpaRepository<Branch, Long> {

	@Query(value = "SELECT  br.branchid,br.branchname,br.shortname,br.contactperson,br.desgination,br.mobileno,br.address1,br.address2,mct.countryname,msd.statename ,cty.cityname FROM medc_branchreg.medc_branchinfomation br "
			+ "left join medc_fixedsettings.medc_country  mct on mct.countryid=br.country left join medc_fixedsettings.medc_state  msd on msd.stateid=br.state "
			+ "left join medc_fixedsettings.medc_city  cty on cty.cityid=br.city WHERE br.status!=2 and br.companyrefid =?1 order by br.branchid desc", nativeQuery = true)
	List viewBranch(Integer cid);

	@Query(value = "SELECT * FROM medc_fixedsettings.medc_state WHERE StateId= :id ", nativeQuery = true)
	List branchEditState(@Param("id") int id);

	@Query(value = "SELECT DialingCode  FROM medc_fixedsettings.medc_country  WHERE CountryID= :id", nativeQuery = true)
	List branchEditCcode(@Param("id") int id);

	@Query(value = "SELECT CityID,CityName FROM medc_fixedsettings.medc_city WHERE CityID= :id", nativeQuery = true)
	List branchEditCity(@Param("id") int id);

	@Modifying
	@Transactional
	@Query(value = "UPDATE medc_branchreg.medc_branchinfomation set Status='2' WHERE BranchID= :id", nativeQuery = true)
	public Integer deleteBranch(@Param("id") int id);

	Branch findById(int id);

	@Query(value = "SELECT companyid,companyname FROM medc_companyreg.medc_companyinfomation WHERE companyid= :id", nativeQuery = true)
	List editCompanyName(@Param("id") int id);

	@Query(value = "SELECT  branchname FROM medc_branchreg.medc_branchinfomation where branchname=:brnch AND CompanyRefID=:compID", nativeQuery = true)
	String isExistBranch(@Param("brnch") String brnch, @Param("compID") String compID);

	@Query(value = "SELECT  branchname FROM medc_branchreg.medc_branchinfomation where branchname=:brnch and not branchid=:brnchid and companyRefID=:compID", nativeQuery = true)
	String isBranchUpdateExist(@Param("brnch") String brnch, @Param("brnchid") String brnchid,
			@Param("compID") String compID);

	@Query(value = "SELECT c.companyid,c.retailuc,c.distributoruc,c.hqusercount,c.warehouseuc,c.hospitaluc,c.usercount,\r\n"
			+ "(SELECT COALESCE(count(locname),0) FROM medc_branchreg.medc_branchinfomation  where companyrefid=:cid and  locname = 1 order by locname asc)  as retcuc,\r\n"
			+ "(SELECT COALESCE(count(locname),0) FROM medc_branchreg.medc_branchinfomation  where companyrefid=:cid and  locname = 2 order by locname asc)  as distcuc,\r\n"
			+ "(SELECT COALESCE(count(locname),0) FROM medc_branchreg.medc_branchinfomation  where companyrefid=:cid and  locname = 3 order by locname asc)  as hqcuc,\r\n"
			+ "(SELECT COALESCE(count(locname),0) FROM medc_branchreg.medc_branchinfomation  where companyrefid=:cid and  locname = 4 order by locname asc)  as warecuc,\r\n"
			+ "(SELECT COALESCE(count(locname),0) FROM medc_branchreg.medc_branchinfomation  where companyrefid=:cid and  locname = 5 order by locname asc)  as hoscuc,\r\n"
			+ "(SELECT COALESCE(count(locname),0) FROM medc_branchreg.medc_branchinfomation  where companyrefid=:cid  order by locname asc)  as totcuc\r\n"
			+ " FROM medc_companyreg.medc_companyinfomation c WHERE companyid=:cid", nativeQuery = true)
	List getusercounts(@Param("cid") int cid);

	@Query(value = "SELECT branchid,branchname from medc_branchreg.medc_branchinfomation WHERE companyrefid=?1 and locname=?2 ", nativeQuery = true)
	List getLocalnameBranch(Integer companyid,Integer locid);

	@Query(value = "SELECT shopid,shopname FROM medc_storereg.medc_shopinformation  where companyid=?1 and branchid=?2", nativeQuery = true)
	List getBranchShop(Integer companyid,Integer branchid);

	@Query(value = "SELECT shopid,shopname FROM medc_storereg.medc_shopinformation   where companyid=?1 and locname=?2", nativeQuery = true)
	List getLocalnameShop(Integer companyid,Integer locid);
}
