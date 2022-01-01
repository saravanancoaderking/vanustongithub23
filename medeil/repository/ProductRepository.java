package com.medeil.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.medeil.domain.Product;

@SuppressWarnings("rawtypes")
public interface ProductRepository extends JpaRepository<Product, Long> {

	@Query(value = "SELECT * FROM medc_fixedsettings.medc_country order by countryname asc", nativeQuery = true)
	List Country();

	@Query(value = "SELECT m.productid, m.productname, c.countryname,m.productcode,m.status FROM medc_adminsecurity.medc_cproductmaster m, medc_fixedsettings.medc_country c where m.countryid = c.countryid order by m.productid desc", nativeQuery = true)
	List Productlist();

//	@Query(value = "SELECT COUNT(ProductName) FROM medc_adminsecurity.medc_cproductmaster WHERE CountryID=:cid AND ProductName=:pname", nativeQuery = true)
//	Integer isProductExist(@Param("cid") int cid, @Param("pname") String pname);

	@Query(value = "SELECT sc.scheduleid,sc.schedulename FROM medc_productmaster.medc_schedule sc", nativeQuery = true)
	List schedule();

	// DesingRaja
	@Query(value = "SELECT sm.salesbillno,DATE(sm.clientcdate) billdate,dr.doctorname,pi.patientfirstname,CONCAT(cpm.brandname,' ',cpm.genericnamedosage) DrugNAme,sb.batchname,sb.expirydate, sb.indvqty,sc.schedulename  FROM medc_sales.medc_salesbill sb\r\n"
			+ "  INNER JOIN medc_sales.medc_salesmaintenance sm ON sm.salesbillid = sb.salesrefid\r\n"
			+ "  INNER JOIN medc_doctorreg.doctorregistration dr ON dr.doctorid = sm.doctorrefid\r\n"
			+ "  INNER JOIN medc_patientreg.medc_patientbasicinfo pi ON pi.patientid =sm.customerrefid\r\n"
			+ "  INNER JOIN medc_productmaster.medc_custproductmaster cpm ON cpm.productdrugid = sb.DrugProductID\r\n"
			+ "  INNER JOIN medc_productmaster.medc_schedule sc ON sc.scheduleid = cpm.schudletype\r\n"
			+ "   WHERE cpm.schudletype =:scheduleid AND DATE(sb.ClientCDate) BETWEEN :fromdate and :todate AND sb.Companyrefid =:companyid AND sb.Locrefid =:locrefid", nativeQuery = true)
	List scheduledata(@Param("scheduleid") Integer scheduleid, @Param("fromdate") String fromdate,
			@Param("todate") String todate, @Param("companyid") Integer companyid, @Param("locrefid") Integer locrefid);

	@Query(value = "SELECT sm.salesbillno,DATE(sm.clientcdate) billdate,dr.doctorname,pi.patientfirstname,"
			+ "CONCAT(cpm.brandname,' ',cpm.genericnamedosage) DrugNAme,sb.batchname,sb.expirydate, sb.indvqty,"
			+ "sc.schedulename  FROM medc_sales.medc_salesbill sb INNER JOIN medc_sales.medc_salesmaintenance sm ON "
			+ "sm.salesbillid = sb.salesrefid INNER JOIN medc_doctorreg.doctorregistration dr ON dr.doctorid = sm.doctorrefid "
			+ "INNER JOIN medc_patientreg.medc_patientbasicinfo pi ON pi.patientid =sm.customerrefid "
			+ "INNER JOIN medc_productmaster.medc_custproductmaster cpm ON cpm.productdrugid = sb.DrugProductID "
			+ "INNER JOIN medc_productmaster.medc_schedule sc ON sc.scheduleid = cpm.schudletype WHERE DATE(sb.ClientCDate) "
			+ "BETWEEN :fromdate and :todate AND sb.Companyrefid =:companyid AND sb.Locrefid =:locrefid", nativeQuery = true)
	List allschedule(@Param("fromdate") String fromdate, @Param("todate") String todate,@Param("companyid") int companyid, @Param("locrefid") int locrefid);

	
	@Query(value = "SELECT sm.salesbillno,DATE(sm.clientcdate) billdate,dr.doctorname,pi.patientfirstname,\r\n" + 
			"			CONCAT(cpm.brandname,' ',cpm.genericnamedosage) DrugNAme,sb.batchname,sb.expirydate, sb.indvqty,\r\n" + 
			"			sc.schedulename  FROM medc_sales.medc_salesbill sb INNER JOIN medc_sales.medc_salesmaintenance sm ON\r\n" + 
			"			sm.salesbillid = sb.salesrefid INNER JOIN medc_doctorreg.doctorregistration dr ON dr.doctorid = sm.doctorrefid\r\n" + 
			"			INNER JOIN medc_patientreg.medc_patientbasicinfo pi ON pi.patientid =sm.customerrefid\r\n" + 
			"			INNER JOIN medc_productmaster.medc_custproductmaster cpm ON cpm.productdrugid = sb.DrugProductID\r\n" + 
			"			INNER JOIN medc_productmaster.medc_schedule sc ON sc.scheduleid = cpm.schudletype\r\n" + 
			"      WHERE sb.Companyrefid =:companyid AND sb.branchrefid =:branchid AND sb.locname =:locname  AND sb.Locrefid =:locrefid" ,nativeQuery = true)
	List getshecdulelist(@Param("companyid") Integer companyid,@Param("branchid") Integer branchid, @Param("locname") Integer locname, @Param("locrefid") Integer locrefid);


}
