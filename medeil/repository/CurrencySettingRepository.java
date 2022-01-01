package com.medeil.repository;

import java.util.List;
import java.util.Map;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.medeil.domain.CurrencySetting;

@SuppressWarnings("rawtypes")
@Repository
public interface CurrencySettingRepository extends JpaRepository<CurrencySetting, Long> {
	@Query(value = "SELECT symbol,country FROM medc_fixedsettings.medc_currencies where countryrefid= :cn", nativeQuery = true)
	public List getCountryname(@Param("cn") String cn);

	@Query(value = "SELECT id , CONCAT(country ,' ', symbol)as symbol FROM medc_fixedsettings.medc_currencies  WHERE countryrefid= :id", nativeQuery = true)
	List getCurrency(@Param("id") int id);

	@Query(value = "SELECT id,CONCAT(currency,' ',symbol) FROM medc_fixedsettings.medc_currencies where razorpaystatus = 1 group by currency", nativeQuery = true)
	public List getCurrencySts();

	@Query(value = "SELECT decimaltwo,decimalthree,roundedabove,roundedbelow,decimalid FROM medc_globalsettings.medc_decimalsettings where companyrefid =?1 and branchrefid =?2 and locname =?3 and locrefid =?4", nativeQuery = true)
	public List getDecimalSts(Integer compid, Integer brnchid, Integer lname, Integer lrefid);

	@Query(value ="SELECT currencyid,currencyrefid,currency FROM medc_globalsettings.medc_currencysettings curset\r\n" + 
			"inner join medc_fixedsettings.medc_currencies cur on cur.id = curset.currencyrefid where curset.companyrefid =?1 and curset.branchrefid =?2 and curset.shoprefid =?3", nativeQuery = true)
	public List fetchCurrsts(Integer compid, Integer brnchid, Integer lrefid);

//	@Query(value = "SELECT setupcostid as id,coalesce(opencashbalance,0),coalesce(buildingcost,0),coalesce(advleadsedeposit,0),coalesce(regfee,0),coalesce(electriclighting,0),coalescefurnishcarpentry,fridge,aircondition,displayboard,computerperipherals,\r\n" + 
//			"others1,others2,others3,others4,others5 FROM medc_globalsettings.medc_setupcostsettings where companyrefid =?1 and branchrefid =?2 and locname =?3 and locrefid =?4", nativeQuery = true)
//	public Map fetchsetupcost(Integer compid, Integer brnchid, Integer lname, Integer lrefid);

}
