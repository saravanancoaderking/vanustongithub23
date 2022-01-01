package com.medeil.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.medeil.domain.Taxsettings;

@SuppressWarnings("rawtypes")
@Repository
public interface TaxfixedsettingRepository extends JpaRepository<Taxsettings, Long> {

	@Query(value = "SELECT status FROM medc_globalsettings.medc_setupcostsettings where companyrefid =?1 and branchrefid =?2 and locname =?3 and locrefid =?4", nativeQuery = true)
	List getTaxStatus(Integer cid, Integer bid, Integer lname,Integer lrefid);

	@Query(value = "SELECT country,state FROM medc_storereg.medc_shopinformation where shopid =?1",nativeQuery = true)
	List getTaxcountrystate(Integer lrefid);
	
	@Query(value = "SELECT taxsetid,vat_gst FROM medc_fixedsettings.medc_taxsettings where companyrefid = 36 and branchrefid = 36 and shoprefid = 36",nativeQuery = true)
	List fetchTaxsettings(Integer lrefid);

}
