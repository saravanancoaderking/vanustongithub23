package com.medeil.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.medeil.domain.PatientLoginSalesorderLead;

@SuppressWarnings("rawtypes")
@Repository
public interface PatientLoginSalesorderLeadRepository extends JpaRepository<PatientLoginSalesorderLead, Long>{
	@Query(value = "select sol.orderid ,sol.salesorderno, pb.patientfirstname,date(sol.createddate),sol.type,sol.onlineorderstatus,sol.prescription_order,sol.sostatus, pb.patientcode from medc_sales.medc_salesorderlead sol "
			+ "inner join medc_patientreg.medc_patientbasicinfo pb on sol.patientid = pb.patientid "
			+ "where sol.companyrefid = :compid and sol.branchrefid = :branchid and sol.locname = :lcnme and sol.locrefid = :lcrfid and sol.PatientID = :paitens order by sol.orderid desc", nativeQuery = true)
	List soleadlist(@Param("compid") int companyrefid, @Param("branchid") int branchrefid, @Param("lcnme") int locname,
			@Param("lcrfid") int locrefid, @Param("paitens")int paitens);
	
	@Query(value = "select sop.drugproductid, cpm.brandname, sop.totalqty, sop.salesorderrefid ,concat(patientfirstname,' ',patientlastname) patientname,so.orderdate,so.salesleadno,\r\n" + 
			"pt.patientcode from medc_sales.medc_salesordprd sop\r\n" + 
			"INNER JOIN medc_sales.medc_salesorder so ON so.OrderID=sop.SalesOrderRefID\r\n" + 
			"left join medc_productmaster.medc_custproductmaster cpm on sop.drugproductid = cpm.productdrugid\r\n" + 
			"INNER JOIN medc_patientreg.medc_patientbasicinfo pt ON pt.PatientID=so.PatientID\r\n" + 
			"where so.salesleadno =:soleadid group by sop.drugproductid", nativeQuery = true)
	List soleadprodlist(@Param("soleadid") int salesorderrefid);

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

	@Query(value = "SELECT Productimg from medc_sales.medc_salesorderlead WHERE OrderID=?1", nativeQuery = true)
	String getsendImage(Integer orderid);	
	
	@Modifying
	@Transactional
	@Query(value = "UPDATE medc_sales.medc_salesorderlead set PictureUrl=?1,Picturetype=?2,prescription_images=?3 ORDER BY OrderID DESC LIMIT 1", nativeQuery = true)
	void imageuplaod(String originalFilename, String contentType, byte[] compressBytes);
	
	@Query(value = "SELECT OrderID from medc_sales.medc_salesorderlead ORDER BY OrderID DESC LIMIT 1", nativeQuery = true)
	Integer getId();
}
