package com.medeil.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.beust.jcommander.Parameter;
import com.medeil.domain.Loyality;

/**
 * 
 * @author DesingRaja
 *
 */
@SuppressWarnings("rawtype")
@Repository
public interface LoyalityRepository extends JpaRepository<Loyality, Integer> {

	@Query(value = "SELECT loyality_typeid FROM medc_loyality.medc_loyalitypoints WHERE companyrefid =:companyid AND branchrefid =:branchid AND locname =:locname AND locarefid =:locrefid order by loyality_typeid desc limit 1", nativeQuery = true)
	int getldataid(@Param("companyid") Integer companyid, @Param("branchid") Integer branchid,
			@Param("locname") Integer locname, @Param("locrefid") Integer locrefid);

	@Query(value = "SELECT lp.loyality_typeid,lp.loyalitytype,lp.price_equivalentto_points,lp.equivalent_points, DATE(lp.from_date) AS fromDate,DATE(lp.to_date) AS todate, lp.minimum_points FROM medc_loyality.medc_loyalitypoints lp WHERE lp.companyrefid=:comid AND lp.branchrefid=:branchid AND lp.locname=:locname AND lp.locarefid =:locrefid", nativeQuery = true)
	List getloyality(@Param("comid") Integer comid, @Param("branchid") Integer branchid,
			@Param("locname") Integer locname, @Param("locrefid") Integer locrefid);

	@Query(value = "SELECT lp.loyality_typeid,lp.loyalitytype, lp.from_date , lp.to_date,lgp.min_gift_point, lgp.gift_code ,lgp.gift_product_id,lgp.gift_product_qty , lgp.product_value FROM medc_loyality.medc_lgiftproduct lgp\r\n"
			+ "INNER JOIN medc_loyality.medc_loyalitypoints lp ON lp.loyality_typeid = lgp.loyality_typeid\r\n"
			+ "WHERE lgp.companyrefid =:comid AND lgp.branchrefid =:branchid AND lgp.locname =:locname AND lgp.locrefid =:locrefid ORDER BY lp.loyality_typeid and lgp.`status`=1 DESC", nativeQuery = true)
	List getloyalitygiftprod(@Param("comid") Integer comid, @Param("branchid") Integer branchid,
			@Param("locname") Integer locname, @Param("locrefid") Integer locrefid);

	@Query(value = "SELECT cu.countryrefid,cu.country,cu.symbol FROM medc_fixedsettings.medc_currencies cu WHERE cu.countryrefid =:countryid", nativeQuery = true)
	List countrycurlogo(@Param("countryid") String countryid);

	@Query(value = "SELECT DISTINCT pi.patientfirstname,lp.loyalitytype,clp.totalpurchaseprice,clp.totalloyalpoints,clp.availloyalpoints,\r\n"
			+ "(SELECT paidamount FROM medc_sales.medc_salesmaintenance WHERE companyrefid=:comid AND branchrefid =:branchid AND locrefid =:locrefid AND customerrefid =clp.custrefid ORDER BY salesbillid DESC LIMIT 1) paidamount,clp.custrefid FROM medc_loyality.medc_cust_loyalitypoints clp\r\n"
			+ "INNER JOIN medc_patientreg.medc_patientbasicinfo pi ON pi.patientid = clp.custrefid\r\n"
			+ "INNER JOIN medc_loyality.medc_loyalitypoints lp ON lp.loyality_typeid = clp.loyalitypointrefid\r\n"
			+ "INNER JOIN medc_sales.medc_salesmaintenance sm ON sm.customerrefid=clp.custrefid\r\n"
			+ "INNER JOIN medc_loyality.medc_lgiftproduct lps ON lps.loyality_typeid=lp.loyality_typeid\r\n" 
			+ "WHERE clp.companyrefid=:comid AND clp.branchrefid =:branchid AND clp.locname =:locname AND clp.locrefid =:locrefid and lps.`status`=2 ORDER BY sm.salesbillid DESC  ", nativeQuery = true)
	List getcustloyality(@Param("comid") Integer comid, @Param("branchid") Integer branchid,
			@Param("locname") Integer locname, @Param("locrefid") Integer locrefid);

	@Query(value = "SELECT ct.cust_type_id,ct.cust_type FROM medc_loyality.medc_cust_type ct WHERE ct.companyrefid=:comid AND ct.branchrefid=:branchid AND ct.locname=:locname AND ct.locrefid=:locrefid", nativeQuery = true)
	List getcusttypelist(@Param("comid") Integer comid, @Param("branchid") Integer branchid,
			@Param("locname") Integer locname, @Param("locrefid") Integer locrefid);

	Loyality findByCompanyrefidAndBranchrefidAndLocnameAndLocarefidAndLoyalitytype(Integer companyrefid,
			Integer branchrefid, Integer locname, Integer locarefid, String loyalitytype);

}
