package com.medeil.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.medeil.domain.MainPrescription;

public interface PracticemanagementRepository extends JpaRepository<MainPrescription, Long> {

	@Query(value = "Select coalesce(MAX(mainpresno),'PRE000000000') from medc_practicemanagement.medc_mainprescription where companyrefid=?1 and branchrefid=?2 and locname=?3 and locrefid=?4", nativeQuery = true)
	String lastPurchaseOrder(Integer companyrefid, Integer branchrefid, Integer locname, Integer locrefid);

	@Query(value = "SELECT MAX(mainpresid) FROM medc_practicemanagement.medc_mainprescription", nativeQuery = true)
	Integer getpracticemgmtID();

	@Query(value = "SELECT mp.mainpresid,mp.mainpresno,dr.doctorname,pi.patientfirstname,mp.diagnosis,mp.weight,mp.remarks,date(mp.clientcdate),\r\n"
			+ "mp.consultationfee FROM medc_practicemanagement.medc_mainprescription mp\r\n"
			+ "INNER JOIN medc_doctorreg.doctorregistration dr ON dr.doctorid = mp.doctorid\r\n"
			+ "INNER JOIN medc_patientreg.medc_patientbasicinfo pi ON pi.patientid = mp.patientid\r\n"
			+ "WHERE  mp.status=0 AND mp.companyrefid =?1 AND mp.branchrefid =?2 AND mp.locname=?3 AND mp.locrefid =?4 order by mp.mainpresid desc", nativeQuery = true)
	List getpractisemanag(Integer comid, Integer branchid, Integer locname, Integer locrefid);

	@Transactional
	@Modifying
	@Query(value = "UPDATE medc_practicemanagement.medc_mainprescription  SET   Status= 1 WHERE  mainpresid=?1 AND companyrefid=?2 AND LocRefID=?3", nativeQuery = true)
	void deletepm(Integer id, Integer comid, Integer locrefid);

	List findById(Integer id);
	
	@Query(value="SELECT mp.mainpresid,mp.mainpresno,dr.doctorname,pi.patientfirstname,mp.diagnosis,mp.weight,mp.remarks,date(mp.clientcdate),\r\n" + 
			"mp.consultationfee FROM medc_practicemanagement.medc_mainprescription mp\r\n" + 
			"INNER JOIN medc_doctorreg.doctorregistration dr ON dr.doctorid = mp.doctorid\r\n" + 
			"INNER JOIN medc_patientreg.medc_patientbasicinfo pi ON pi.patientid = mp.patientid\r\n" + 
			"WHERE  mp.status=0 AND mp.companyrefid =?1 AND mp.branchrefid =?2 AND mp.locname=?3 AND mp.locrefid =?4  AND mp.patientid =?5 order by mp.mainpresid desc",nativeQuery = true)
	List getcustpractisemanag(Integer comid, Integer branchid, Integer locname, Integer locrefid, Integer custid);

	@Query(value = "SELECT  pm. brandname,stk.DrugProductID,stk.Batchno,stk.Qty,stk. SellingPrice,     stk. unitprice, stk.unitsgst, stk.unitcgst, stk.unitigst, stk.unitutgst,     stk.vat ,\r\n" + 
			"stk. BoxPerStrip   *stk. StripPerTablet ,stk. StripPerTablet,0  ,2,stk.sellingprice1 , stk.sellingprice2 , stk.sellingprice3 , stk.sellingprice4 ,sp.Totalmedicine       ,\r\n" + 
			"IFNULL(stk.consolQty,0)-IFNULL(stk.Qty,0)  as  sormainqty,stk.batchname ,Date(stk.ExpiryDate ),stk.FreeTotalQty,stk.StockID ,\r\n" + 
			"stk.RetailerSellingPrice ,stk.WholeSellingprice ,stk.unitgst,stk.marginamt,stk.margin,stk.ageingtime FROM medc_practicemanagement.medc_prescriptionproduct   sp\r\n" + 
			"left join (SELECT     brandname,DrugProductID,Batchno,max(Qty)  as  Qty,sum(IFNULL(Qty,0))  as  consolQty , SellingPrice, mrp, unitprice,\r\n" + 
			"unitsgst, unitcgst, unitigst, unitutgst,     vat ,  BoxPerStrip    , StripPerTablet,   sellingprice1 , sellingprice2 ,sellingprice3 , sellingprice4 ,\r\n" + 
			"LocName,LocRefID,batchname,ExpiryDate ,FreeTotalQty,StockID ,RetailerSellingPrice , WholeSellingprice,unitgst,marginamt,margin,ageingtime    from   medc_stock.medc_mainstock\r\n" + 
			"where  status =0 and LocName=?1 and  LocRefID=?2 group  by DrugProductID order by Qty asc  ) stk   on sp.DrugProductID=stk.DrugProductID\r\n" + 
			"left join medc_productmaster.medc_custproductmaster pm on pm.productdrugid=sp.drugproductid\r\n" + 
			"where sp.delstatus=0 and  sp.mainpresrefid=?3 and stk.qty>0", nativeQuery = true)
	List viewPractiseProd(int lcrnm, int lcrid, int orderid);

}