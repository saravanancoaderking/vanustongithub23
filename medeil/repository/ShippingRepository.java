package com.medeil.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.medeil.domain.Salesorder;
import com.medeil.domain.Shipping;

@SuppressWarnings("rawtypes")
@Repository

public interface ShippingRepository extends JpaRepository<Shipping, Long> {

	@Query(value = "SELECT packingautoid,packingno from medc_deliveryprocess.medc_packing where status=3  and shipflag=0 and companyrefid= :cid and  branchrefid= :bid and locname= :locid and locrefid= :locreid order by packingautoid desc", nativeQuery = true)
	public List getPackingno(@Param("cid") int cid, @Param("bid") int bid, @Param("locid") int locid,
			@Param("locreid") int locreid);

	@Query(value = "SELECT COALESCE(max(shipid),1) as id FROM medc_deliveryprocess.medc_shipping WHERE status=0 and CompanyRefID= :cid and  BranchRefID= :bid and  LocName= :locname and  LocRefID= :locrefid", nativeQuery = true)
	Integer getshipmentid(@Param("cid") int cid, @Param("bid") int bid, @Param("locrefid") int locrefid,
			@Param("locname") int locname);

	@Query(value = "SELECT pa.salesinvoiceno,cu.patientfirstname,date(pa.clientcdate),cu.address1,cu.address2,pa.custrefid,em.empfirstname,pa.salesorderrefid,cu.shipmentaddress from medc_deliveryprocess.medc_packing pa left join medc_employee.medc_employeedetails em on em.employeeid=pa.picklistemprefid left join medc_patientreg.medc_patientbasicinfo cu on cu.patientid=pa.custrefid where pa.status=3 and pa.companyrefid= :cid and  pa.branchrefid= :bid and pa.locname= :locid and pa.locrefid= :locreid  and pa.packingautoid= :packid", nativeQuery = true)
	public List viewPack(@Param("cid") int cid, @Param("bid") int bid, @Param("locid") int locid,
			@Param("locreid") int locreid, @Param("packid") int packid);

	@Query(value = "SELECT packageweight,1 as 'box',sm.grandtotal,em.empfirstname from medc_deliveryprocess.medc_packing pa inner join medc_sales.medc_salesmaintenance sm on sm .salesbillid=pa.salesinvoiceno left join medc_employee.medc_employeedetails em on em.employeeid=pa.picklistemprefid where pa.status=3 and pa.companyrefid= :cid and  pa.branchrefid= :bid and pa.locname= :locid and pa.locrefid= :locreid  and pa.packingautoid= :packid", nativeQuery = true)
	public List gettablevalue(@Param("cid") int cid, @Param("bid") int bid, @Param("locid") int locid,
			@Param("locreid") int locreid, @Param("packid") int packid);

	@Query(value = "SELECT MAX(shipid) FROM medc_deliveryprocess.medc_shipping     where companyrefid=?1 and branchrefid=?2 and  LocName=?3 and LocRefID=?4 ", nativeQuery = true)
	Integer selectmaaxshipid(Integer compid, Integer branchid, Integer locid, Integer locrefid);

	@Query(value = "select sp.Shipid,sp.Shippmentno,sm.Salesbillno,date(sp.ClientCDate),sp.TotalBox,sp.TotalWeight,sp.current_status,concat(em.`EmpFirstName`,'  -  ', em.`EmployeeCode`) from medc_deliveryprocess.medc_shipping sp\r\n" + 
			"LEFT JOIN medc_sales.medc_salesmaintenance sm ON sm.salesbillid = sp.salesinvoiceno\r\n" + 
			"LEFT JOIN medc_employee.medc_employeedetails em ON em.employeeid = sp.emprefid\r\n" + 
			"where  sp.companyrefid=:cid and  sp.branchrefid=:bid and sp.locname=:locid and sp.locrefid=:locreid order by Shipid desc", nativeQuery = true)
	public List viewShipp(@Param("cid") int cid, @Param("bid") int bid, @Param("locid") int locid,
			@Param("locreid") int locreid);

	// Boopalan 200919 - For saving data medc_status.medc_salesordertrack
	@Modifying
	@Transactional
	@Query(value = "INSERT INTO medc_status.medc_salesordertrack (salesorderrefid, statusid, statusdate)VALUES (?1, ?2, ?3);", nativeQuery = true)
	Integer save_medc_salesordertrack(@Param("salesorderrefid") int salesorderrefid, @Param("statusid") int statusid,
			@Param("medc_salesordertrack_statusdate") String medc_salesordertrack_statusdate);
	

	@Modifying
	@Transactional
	@Query(value = "update  medc_deliveryprocess.medc_packing  set  shipflag=1  where  Companyrefid=?1 and Branchrefid=?2 and LocName=?3 and LocRefID=?4 and salesinvoiceno=?5 ", nativeQuery = true)
	void updatepacstatus(int Companyrefid, int Branchrefid, int LocName, int LocRefID, int sino);
	
	@Query(value = "SELECT sm.stkminno,DATE_FORMAT(sm.clientcdate1,'%Y-%m-%d') AS stkmindate,lc.LocationName,sm.stkminid ,CONCAT(pr.BrandName,' ',pr.genericnamedosage) AS proname,0,1,2,sm.qty,(sm.drugproductid * 1) AS DrugProductRefID1,si.ShopName\r\n" + 
			"FROM medc_stock.medc_stockminqty sm\r\n" + 
			"LEFT JOIN medc_productmaster.medc_custproductmaster pr ON pr.ProductDrugID=sm.drugproductid\r\n" + 
			"LEFT JOIN medc_adminsecurity.medc_locationref lc ON lc.id=sm.LocName\r\n" + 
			"LEFT JOIN medc_storereg.medc_shopinformation si ON si.ShopID=sm.LocRefID\r\n" + 
			"WHERE sm.companyrefid = :companyrefid AND sm.branchrefid = :branchrefid AND sm.locname= :locname AND sm.locrefid= :id",nativeQuery = true)
	List getpurcSessionhqShopdata(@Param("id") int id,@Param("locname") int locname,@Param("companyrefid") int companyrefid,@Param("branchrefid") int branchrefid);

	@Query(value = "SELECT concat(m.`EmpFirstName`,'  -  ', m.`EmployeeCode`), m.`EmployeeID` FROM medc_employee.medc_employeedetails m "
			+ "where m.`CompanyID` =:cid and  m.`BranchID` =:bid and  m.`LocName` =:locid and m.`LocRefID` =:locreid", nativeQuery = true)
		public List getemp(@Param("cid") int cid, @Param("bid") int bid, @Param("locid") int locid,
				@Param("locreid") int locreid);

	
}
