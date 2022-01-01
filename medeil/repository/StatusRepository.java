package com.medeil.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.medeil.domain.Salesorder;


@SuppressWarnings("rawtypes")
@Repository
public interface StatusRepository extends JpaRepository<Salesorder, Long> {
	
	@Query(value = "select concat(pb.patientfirstname,' ',pb.patientlastname) as patientname,pb.mobile,pb.email,pb.address1 ,so.salesorderno,so.orderdate,so.totalitem,sot.sotypename "
			+ "from medc_patientreg.medc_patientbasicinfo pb inner join medc_sales.medc_salesorder so on so.patientid = pb.patientid "
			+ "inner join medc_sales.medc_saleordertype sot on so.sotype = sot.salesordertypeid "
			+ "where so.companyrefid =?1 and so.branchrefid = ?2 and so.locname =?3 and so.locrefid =?4 and so.orderid =?5", nativeQuery = true)
	List stsalesropo(int Companyrefid, int Branchrefid,int LocName, int LocRefID, int orderid);
	
	@Query(value = "select salesstatus from medc_sales.medc_salesorder where companyrefid =?1 and branchrefid =?2 and locname =?3 and locrefid =?4 and orderid =?5", nativeQuery = true)
	List salessatus(int Companyrefid, int Branchrefid,int LocName, int LocRefID, int orderid);
}
