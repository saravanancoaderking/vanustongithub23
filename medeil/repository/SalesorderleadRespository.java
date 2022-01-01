package com.medeil.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.medeil.domain.SalesorderLead;

@SuppressWarnings("rawtypes")
@Repository
public interface SalesorderleadRespository extends JpaRepository<SalesorderLead, Long> {

	@Query(value = "select sol.orderid ,sol.soonlineno,pb.patientfirstname,date(sol.createddate),sol.type,sol.onlineorderstatus,sol.prescription_order,pb.patientcode from medc_sales.medc_salesorderlead sol "
			+ "inner join medc_patientreg.medc_patientbasicinfo pb on sol.patientid = pb.patientid "
			+ "where sol.companyrefid = :compid and sol.branchrefid = :branchid and sol.locname = :lcnme and sol.locrefid = :lcrfid  and sol.sotype=1  order by sol.orderid desc", nativeQuery = true)
	List soleadlist(@Param("compid") int companyrefid, @Param("branchid") int branchrefid, @Param("lcnme") int locname,
			@Param("lcrfid") int locrefid);

	@Query(value = "select sol.orderid ,sol.salesorderno, pb.patientfirstname,date(sol.createddate),sol.type,sol.onlineorderstatus,sol.prescription_order,pb.patientcode from medc_sales.medc_salesorderlead sol "
			+ "inner join medc_patientreg.medc_patientbasicinfo pb on sol.patientid = pb.patientid "
			+ "where sol.companyrefid = :compid and sol.branchrefid = :branchid and sol.locname = :lcnme and sol.locrefid = :lcrfid  and sol.sotype=2  order by sol.orderid desc", nativeQuery = true)
	List omnisoleadlist(@Param("compid") int companyrefid, @Param("branchid") int branchrefid, @Param("lcnme") int locname,
			@Param("lcrfid") int locrefid);

	@Query(value = "select salesordertypeid,sotypename from medc_sales.medc_saleordertype sot inner join medc_sales.medc_salesorderlead sol on sot.salesordertypeid= sol.sotype where orderid =:soleadid", nativeQuery = true)
	List soleadtypelist(@Param("soleadid") int salesorderrefid);

	@Query(value = "select pb.patientid,concat(patientfirstname,' ',patientlastname) from medc_patientreg.medc_patientbasicinfo pb inner join medc_sales.medc_salesorderlead sol on pb.patientid = sol.patientid where orderid =:soleadid", nativeQuery = true)
	List soleadpatientlist(@Param("soleadid") int salesorderrefid);

	@Query(value = "select solp.drugproductid, cpm.brandname, solp.totalqty, solp.salesorderrefid ,concat(patientfirstname,' ',patientlastname) patientname,sol.orderdate,pt.patientcode from medc_sales.medc_salesordleadprd solp "
			+ "INNER JOIN medc_sales.medc_salesorderlead sol ON sol.OrderID=solp.SalesOrderRefID "
			+ "left join medc_productmaster.medc_custproductmaster cpm on solp.drugproductid = cpm.productdrugid "
			+ "INNER JOIN medc_patientreg.medc_patientbasicinfo pt ON pt.PatientID=sol.PatientID "
			+ "where solp.salesorderrefid =:soleadid group by solp.drugproductid ", nativeQuery = true)
	List soleadrecordlist(@Param("soleadid") int salesorderrefid);

	@Query(value = "select pb.patientid,coalesce(pb.mobile,pb.phone) as contactno,sol.sotype,sol.deliverytype,sol.soonlineno,date(sol.orderdate),pb.patientcode from medc_sales.medc_salesorderlead sol "
			+ "inner join medc_patientreg.medc_patientbasicinfo pb on sol.patientid = pb.patientid where sol.companyrefid=:compid and sol.branchrefid=:branchid and sol.locname=:lcnme and sol.locrefid=:lcrfid and sol.orderid =:id", nativeQuery = true)
	List fetchsoleadlist(@Param("compid") int companyrefid, @Param("branchid") int branchrefid,
			@Param("lcnme") int locname, @Param("lcrfid") int locrefid, @Param("id") int soid);

	// Boopalan Alagesan 160919 04:55PM
	/**
	 * NOTE : TAKE CARE ON [fetchsoleadrecord] RESULT SET: [sp.flagid as flag] 0 for
	 * active product, 1 for active product but insufficient quantity, 2 for product
	 * not available.
	 */
	// Boopalan Alagesan 180919 10:24AM
	@Query(value = "SELECT pi.ProductDrugID,pi.BrandName,fr.FormulationName,CONCAT(pi.GenericNameDosage,coalesce(UOM,'')) as dosage,fr.FormulationID,0 FROM medc_productmaster.medc_custproductmaster pi "
			+ "INNER JOIN medc_productmaster.medc_formulation fr ON fr.FormulationID=pi.FormulationID "
			+ "WHERE pi.ProductDrugID= :productid and pi.DrugStatus=0 and fr.Status=0", nativeQuery = true)
	List getProductdata0(@Param("productid") int productid);

	// Boopalan Alagesan 180919 10:24AM
	@Query(value = "SELECT pi.ProductDrugID,pi.BrandName,fr.FormulationName,CONCAT(pi.GenericNameDosage,coalesce(UOM,'')) as dosage,fr.FormulationID,1 FROM medc_productmaster.medc_custproductmaster pi "
			+ "INNER JOIN medc_productmaster.medc_formulation fr ON fr.FormulationID=pi.FormulationID "
			+ "WHERE pi.ProductDrugID= :productid and pi.DrugStatus=0 and fr.Status=0", nativeQuery = true)
	List getProductdata1(@Param("productid") int productid);

	// Boopalan Alagesan 180919 10:24AM
	@Query(value = "SELECT pi.ProductDrugID,pi.BrandName,fr.FormulationName,CONCAT(pi.GenericNameDosage,coalesce(UOM,'')) as dosage,fr.FormulationID,2 FROM medc_productmaster.medc_custproductmaster pi "
			+ "INNER JOIN medc_productmaster.medc_formulation fr ON fr.FormulationID=pi.FormulationID "
			+ "WHERE pi.ProductDrugID= :productid and pi.DrugStatus=0 and fr.Status=0", nativeQuery = true)
	List getProductdata2(@Param("productid") int productid);

	// Boopalan Alagesan 180919 10:24AM
	@Query(value = "SELECT flagid FROM medc_sales.medc_sostockprd where drugproductid =?1", nativeQuery = true)
	int flagid(@Param("data") int productid);

//	@Query(value = "select solp.drugproductid,pr.brandname,CONCAT(pr.GenericNameDosage,coalesce(pr.UOM,''))as DosageValue,fr.formulationname,solp.totalqty from medc_sales.medc_salesordleadprd solp "
//			+ "inner join medc_productmaster.medc_custproductmaster pr on solp.drugproductid = pr.productdrugid inner join medc_productmaster.medc_formulation fr on pr.formulationid = fr.formulationid where solp.salesorderrefid =:soleadid", nativeQuery = true)
//	List fetchsoleadrecord(@Param("soleadid") int salesorderrefid);

	@Query(value = "SELECT pr.ProductDrugID,pr.BrandName,fr.FormulationName,CONCAT(pr.GenericNameDosage,coalesce(pr.UOM,''))as DosageValue "
			+ "FROM medc_productmaster.medc_custproductmaster pr,medc_productmaster.medc_formulation fr "
			+ "WHERE pr.DrugStatus=0 and companyid=:compid and pr.ProductDrugID=:id and pr.FormulationID=fr.FormulationID", nativeQuery = true)
	List addsoproduct(@Param("compid") int companyrefid, @Param("id") int data);
	
	@Query(value = "select sto.ageingtime,sto.qty,s.shopname,s.shopid from medc_stock.medc_mainstock sto\r\n" + 
			"inner join medc_storereg.medc_shopinformation s on s.shopid=sto.locrefid where sto.companyrefid=:compid and sto.drugproductid=:id group by s.shopname;", nativeQuery = true)
	List stockcheck(@Param("compid") int companyrefid, @Param("id") int data);

	@Query(value = "select solp.drugproductid,pr.brandname,CONCAT(pr.GenericNameDosage,coalesce(pr.UOM,''))as DosageValue,fr.formulationname,solp.totalqty,coalesce(msp.Qty,0)as currentqty,sp.flagid as flag from medc_sales.medc_salesordleadprd solp\r\n"
			+ " inner join medc_productmaster.medc_custproductmaster pr on solp.drugproductid = pr.productdrugid\r\n"
			+ " inner join medc_sales.medc_sostockprd sp on sp.drugproductid = solp.drugproductid\r\n"
			+ " Left join medc_sales.medc_mainstockprd msp on msp.drugproductid = solp.drugproductid\r\n"
			+ " inner join medc_productmaster.medc_formulation fr on pr.formulationid = fr.formulationid where solp.salesorderrefid =?1", nativeQuery = true)
	List fetchsoleadrecord(@Param("salesorderrefid") int salesorderrefid);

	@Query(value = "SELECT prescription_images from medc_sales.medc_salesorderlead WHERE OrderID=?1", nativeQuery = true)
	byte[] getsendImage(Integer orderid);
}
