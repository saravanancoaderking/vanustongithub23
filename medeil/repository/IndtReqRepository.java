
package com.medeil.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.medeil.domain.IndentRequest;

public interface IndtReqRepository extends JpaRepository<IndentRequest, Long> {

	IndentRequest findById(int id);

	IndentRequest save(IndentRequest ip);

	@Query(value = "  SELECT IndentReqID ,indentno,fromlocrefid,fromlocname ,tolocrefid,    tolocname,DATE(ClientCDate1)  FROM medc_indentmaster.medc_indentreq       where  LocName=?1 and LocRefID=?2  ", nativeQuery = true)
	List viewIndentRequests(int lcrnm, int lcrid);

	/** Boopalan Edited **/ // 250419
	@Query(value = "SELECT indentreqid,indentno,DATE(ClientCDate1),tolocrefid,tolocname,date(clientcdate),IndApprFlag,fromlocname ,fromlocrefid, namefromlocname, namefromlocrefid,nametolocname, nametolocrefid,StkMinRefId    FROM medc_indentmaster.medc_indentreq iq  left join  ( SELECT stkminid ,stkminno,DATE(ClientCDate1) stdate FROM medc_stock.medc_stockminqty   where  LocName=?1 and LocRefID=?2   group by   stkminid )stm on  iq.StkMinRefId  = stm.stkminid       where  iq.LocName=?1 and iq.LocRefID=?2 and iq.indentreqid =?3   and  iq.Status!=5", nativeQuery = true)
	List viewIndentRequest(int lcrnm, int lcrid, int ind);

	@Query(value = " SELECT ShopID,ShopName FROM medc_storereg.medc_shopinformation where  CompanyRefID !=?1 or BranchRefID !=?2 or LocName !=?3 or LocRefID !=?4   ", nativeQuery = true)
	List viewshopinformation(int cid, int bid, int locid, int locrefid);

	@Query(value = " SELECT warehouseID,Warehousename  FROM medc_warehousereg.medc_warehouseinfo       where  CompanyRefID=?1   ", nativeQuery = true)
	List viewWareHouse(int cid);

	@Query(value = "   SELECT HospitalID , HospitalName  FROM medc_hospitalreg.hospitalregistration       where     CompanyRefID=?1 ", nativeQuery = true)
	List viewHospital(int cid);

	@Query(value = "  SELECT IFNULL(MAX(indentreqid),0)   FROM medc_indentmaster.medc_indentreq        where  LocName=?1 and LocRefID=?2  ", nativeQuery = true)
	int viewIndentId(Double lcrnm, Double lcrid);

	@Query(value = "  SELECT   IFNULL(RIGHT(indentno, 7),0)   FROM   medc_indentmaster.medc_indentreq   where  indentreqid=?3     and    LocName=?1 and LocRefID=?2 ", nativeQuery = true)
	String viewIndReqIncNo(Double lcrnm, Double lcrid, int id);

	@Query(value = "select ProductDrugID, CONCAT(ifnull(BrandName,'Sample'), '  ', ifnull(genericnamedosage,'1mg')) AS BrandName   from medc_productmaster.medc_custproductmaster	where   BrandName like  ?3%    and    ((LocName=?1 and  LocRefID=?2) || (companyID=?4))   ORDER BY BrandName LIMIT 10", nativeQuery = true)
	List viewCustProducts(int lcrnm, int lcrid, String name, int compid);

	@Query(value = "SELECT cst.BrandName ,  cst.ProductDrugID  ,  (cst.Stripperbox * cst.Quantityperstrip), cst.Quantityperstrip  ,coalesce(cst.MinQty,0),      coalesce(cst.MaxQty,0)     FROM  medc_productmaster.medc_custproductmaster  cst  where    cst.ProductDrugID = ?3    and   ((LocName=?1 and  LocRefID=?2) || (companyID=?4)) ", nativeQuery = true)
	List viewCustProduct(int lcrnm, int lcrid, int name, int compid);

	@Query(value = " SELECT indentreqid,indentno,DATE(ClientCDate1), namefromlocname, namefromlocrefid,      nametolocname, nametolocrefid ,stm.stkminno,stm.stdate    FROM medc_indentmaster.medc_indentreq iq  left join  ( SELECT stkminid ,stkminno,DATE(ClientCDate1) stdate FROM medc_stock.medc_stockminqty   where  LocName=?1 and LocRefID=?2   group by   stkminid )stm on  iq.StkMinRefId  = stm.stkminid       where  iq.LocName=?1 and iq.LocRefID=?2   and  iq.Status!=5  order by indentreqid desc", nativeQuery = true)
	List viewIndentRequestsAll(int lcrnm, int lcrid);

	@Query(value = "  SELECT   stkminid ,stkminno,DATE(ClientCDate1)   FROM    medc_stock.medc_stockminqty     where LocName=?1 and LocRefID=?2   and Status!=5 and IndReqflag=0    group by   stkminid order by stkminid desc   ", nativeQuery = true)
	List viewStkMinQtyAll(int lcrnm, int lcrid);

	@Query(value = "SELECT   stm. stkminno as stockminno ,DATE(ClientCDate1), cust.BrandName  ,stm.stkminautoid,stm. stkminid ,stm. drugproductid ,stm. batchrefid ,stm. receivedqty,stm. minqty,stm. ClientCDate1 ,stm.remarks,stm.boxperstrip,stm.strippertablet,stm.boxqty,stm.stripqty,stm.tabletqty,stm.reqqty,stm.packageunit\r\n" + 
			"FROM   medc_stock.medc_stockminqty  stm\r\n" + 
			"left join (SELECT BrandName,ProductDrugID,Stripperbox,Quantityperstrip,MinQty,MaxQty from  medc_productmaster.medc_custproductmaster where  ((LocName=?1 and  LocRefID=?2) || (companyID=?4)))  cust on cust.ProductDrugID = stm. drugproductid  where stm.stkminid=?3  and stm.locrefid=?2", nativeQuery = true)
	List viewStkMinQty(int lcrnm, int lcrid, int id, int compid);

	@Modifying
	@Transactional
	@Query(value = "update    medc_indentmaster.medc_indentreq  set   Status=5  where  indentreqid=?3 and  LocName=?1 and LocRefID=?2  ", nativeQuery = true)
	int deleteIndReq(int lcrnm, int lcrid, int id);

	@Modifying
	@Transactional
	@Query(value = "  update medc_stock.medc_stockminqty  stk set stk.IndReqflag=1      where     stk.stkminid=?3   and  stk.LocName=?1 and stk.LocRefID=?2   ", nativeQuery = true)
	void updateIndReqFlag(double lcrnm, double lcrid, int ind);

	// sankar 100419
	@Query(value = " SELECT ShopID,ShopName  FROM medc_storereg.medc_shopinformation        where  CompanyRefID=?1  ", nativeQuery = true)
	List editbussrepo(int cid);

	@Query(value = "  SELECT MAX(indentreqid)  FROM medc_indentmaster.medc_indentreq        where  LocName=?1 and LocRefID=?2  ", nativeQuery = true)
	List viewIndentId1(Double lcrnm, Double lcrid);

	@Query(value = "SELECT shopid,shopname FROM medc_storereg.medc_shopinformation where companyrefid =?1 and locname =?2", nativeQuery = true)
	List getToRequsitionshop(Integer compid, Integer lname);

	@Query(value = "SELECT sum(qty),drugproductid,lref.locationname,shopname,stk.locrefid,stk.locname FROM medc_stock.medc_mainstock stk\r\n" + 
			"inner join medc_adminsecurity.medc_locationref lref on lref.id = stk.locname\r\n" + 
			"inner join medc_storereg.medc_shopinformation sh on sh.shopid=stk.locrefid where stk.companyrefid =?1 and stk.drugproductid =?2 and stk.locrefid !=?3 group by stk.locrefid", nativeQuery = true)
	List getMultistorereqproducts(Integer compid, Integer drug, Integer lrefid);
}
