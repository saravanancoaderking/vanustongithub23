/**
 * 
 */
package com.medeil.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.medeil.domain.Shop;

/**
 * @author Ajith
 * 
 */
@SuppressWarnings("rawtypes")
@Repository
public interface ShopRepository extends JpaRepository<Shop, Long> {

	Shop findById(int id);
	Shop findBylocrefid(int id);
	boolean existsByShopname(String domainname);


	@Modifying
	@Transactional
	@Query(value = "UPDATE medc_storereg.medc_shopinformation set Status='2' WHERE ShopID= :id", nativeQuery = true)
	void deleteShop(@Param("id") int id);
//Raja
	@Query(value = "SELECT s.ShopName,s.OwnerName, s.Address1,co.CountryName,st.StateName,s.MobileNo,s.Emailid,s.DlNo,GstNo,s.ShopID,s.shoplogo FROM medc_storereg.medc_shopinformation s "
			+ "INNER JOIN medc_fixedsettings.medc_country co ON s.Country=co.CountryID "
			+ "INNER JOIN medc_fixedsettings.medc_state st ON s.state=st.stateID WHERE s.Status=0 and s.companyrefid= :cid and s.branchrefid= :bid  order  by s.ShopID desc", nativeQuery = true)
	public List viewShop(@Param("cid") int cid, @Param("bid") int bid);

	@Query(value = "SELECT * FROM medc_fixedsettings.medc_state WHERE  CountryID= :id ", nativeQuery = true)
	public List editShopstate(@Param("id") int id);

	@Query(value = "SELECT CityID,CityName FROM medc_fixedsettings.medc_city WHERE StateID= :id ", nativeQuery = true)
	public List geteditshopCity(@Param("id") int id);
	
	@Query(value = "SELECT CompanyID,CompanyName FROM medc_companyreg.medc_companyinfomation WHERE CompanyID= :id ", nativeQuery = true)
	public List geteditshopCompany(@Param("id") int id);
	
	@Query(value = "SELECT BranchID,BranchName FROM medc_branchreg.medc_branchinfomation WHERE Companyrefid= :id ", nativeQuery = true)
	public List editShopBranch(@Param("id") int id);
	
	@Query(value = "SELECT IFNULL(s.shoplogo,'No_Image')As String FROM medc_storereg.medc_shopinformation s  WHERE s.Status=0 and s.companyrefid= :cid and s.branchrefid= :bid  order  by s.ShopID desc", nativeQuery = true)
	String getImage(@Param("cid")Integer cid,  @Param("bid")Integer bid);
	
	@Query(value = "SELECT s.ShopName,s.OwnerName, s.Address1,co.CountryName,st.StateName,s.MobileNo,s.Emailid,s.DlNo,GstNo,s.ShopID,s.Country,s.state,s.city FROM medc_storereg.medc_shopinformation s " + 
			" INNER JOIN medc_fixedsettings.medc_country co ON s.Country=co.CountryID " + 
			" INNER JOIN medc_fixedsettings.medc_state st ON s.state=st.stateID WHERE s.Status=0 and s.companyrefid= :cid and s.branchrefid= :bid  order  by s.ShopID desc ", nativeQuery = true)
	List getvalues(@Param("cid")Integer cid,  @Param("bid")Integer bid);

	@Query(value = "SELECT branchname,bankifsccode,address,statename,cityname,districtname,phoneno from medc_banksetting.medc_branchname WHERE bankid=?1 and branchname=?2", nativeQuery = true)
	List getbankdetails(Integer bankid, Integer branchid);

	@Query(value = "SELECT bankid FROM medc_banksetting.medc_bankname WHERE bankname LIKE :search", nativeQuery = true)
	List getbankid(@Param("search")String search);

	@Query(value = "SELECT bankid,bankbranchid FROM medc_banksetting.medc_branchname WHERE bankid=:bankid and branchname LIKE :search", nativeQuery = true)
	List getbranchid(@Param("bankid")Integer bankid,@Param("search")String search);
	
	@Modifying
	@Transactional
	@Query(value = "update medc_storereg.medc_shopinformation set shoplogo=:filepath  where companyrefid =:companyid and branchrefid=:branchid and locname=:locname and locrefid =:locrefid", nativeQuery = true)
	void shoplogo(@Param("filepath") String filepath, @Param("companyid") int companyid, @Param("branchid") int branchid,
			@Param("locname") int locname, @Param("locrefid") int locrefid);
	
	@Query(value = "SELECT IFNULL(shoplogo,'No_Image')As String FROM medc_storereg.medc_shopinformation   WHERE shopid= :id ", nativeQuery = true)
	String getshopid(@Param("id")Integer id);
}