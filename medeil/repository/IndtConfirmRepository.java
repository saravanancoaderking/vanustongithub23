package com.medeil.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.medeil.domain.IndentConfirm;

@Repository
public interface IndtConfirmRepository extends JpaRepository<IndentConfirm, Long> {

	IndentConfirm save(IndentConfirm indt);

	@Query(value = "SELECT IndentReqID, IndentNo,fromlocrefid,fromlocname ,tolocrefid,       tolocname, namefromlocname, namefromlocrefid, nametolocname, nametolocrefid     FROM medc_indentmaster.medc_indentreq     where    toLocRefID=?2 and toLocName=?1  and  IndApprFlag=0  and Status!=5  order by IndentReqID desc", nativeQuery = true)
	List viewIndentreq(int lcrnm, int lcrid);

	@Query(value = "SELECT   ip. indentprdid , ip. indentrefid, ip. drugprdrefid, ip. boxqty, ip. stripqty,       ip. tabqty, ip. qty ,ip. boxconvdrg ,ip.stripconvdrg ,ip.minqty ,ip.maxqty ,cp.brandname,ip.remarks ,ip.ApprovedQty,ip.packageunit\r\n"
			+ "FROM medc_indentmaster.medc_indentproduct ip\r\n"
			+ "left join  (SELECT BrandName,ProductDrugID   from  medc_productmaster.medc_custproductmaster where ((LocName=?1 and  LocRefID=?2) || (companyID=?4)) )   cp  on  cp.ProductDrugID=ip.drugprdrefid   where  ip. indentrefid=?3", nativeQuery = true)
	List viewSelIndentproduct(int lcrnm, int lcrid, int ip, Integer compid); // lcrnm removed because of variable names

	@Query(value = "  SELECT IFNULL(MAX(IndentReqPID),0)  FROM medc_indentmaster.medc_indentreqperm      where  LocName=?1 and LocRefID=?2  ", nativeQuery = true)
	Double viewIndentConfirmId(Double lcrnm, Double lcrid);

	@Query(value = "  SELECT   IFNULL(RIGHT(IndApprNo, 7),0)   FROM medc_indentmaster.medc_indentreqperm    where  IndentReqPID=?3    and    LocName=?1 and LocRefID=?2  ", nativeQuery = true)
	String viewIndentConfirmIncNo(Double lcrnm, Double lcrid, Double id);

	@Query(value = " SELECT  ira.IndentReqPID,ira.IndApprNo,DATE(ira.ClientCDate1),ira.IndRefID , ira.namefromlocname,       ira. namefromlocrefid, ira.nametolocname, ira.nametolocrefid,irq.indentno,DATE(irq.ClientCDate1)   FROM medc_indentmaster.medc_indentreqperm  ira    left join   medc_indentmaster.medc_indentreq  irq  on  irq.IndentReqID= ira.IndRefID     where  ira.LocName=?1 and ira.LocRefID=?2 order by ira.IndentReqPID desc ", nativeQuery = true)
	List viewIndentConfirmAll(int lcrnm, int lcrid);

	@Query(value = "  SELECT  IndApprNo   FROM medc_indentmaster.medc_indentreqperm    where  IndRefID=?3     and    LocName=?1 and LocRefID=?2  ", nativeQuery = true)
	List viewIndentConfirmNo(Integer lcrnm, Integer lcrid, Integer id);

	@Query(value = " SELECT ShopID,ShopName  FROM medc_storereg.medc_shopinformation        where ShopID=?1    ", nativeQuery = true)
	List viewShopName(int id);

	@Query(value = " SELECT warehouseID,Warehousename  FROM medc_warehousereg.medc_warehouseinfo       where  warehouseID=?1     ", nativeQuery = true)
	List viewWareHouseName(int id);

	@Query(value = "   SELECT HospitalID , HospitalName  FROM medc_hospitalreg.hospitalregistration       where HospitalID=?1    ", nativeQuery = true)
	List viewHospitalName(int id);

	@Query(value = "SELECT  IndentReqID, IndentNo,FromLocRefID,FromLocName ,tolocrefid     ,tolocname  ,Date(ClientCDate1)   FROM medc_indentmaster.medc_indentreq     where    toLocName=?1  and  toLocRefID=?2    and FromLocName=?3 and FromLocRefID=?4  and  IndApprFlag=0  and Status!=5", nativeQuery = true)
	List viewIndentReqSelect(int lcrnm, int lcrid, int id1, int id2);

	@Modifying
	@Transactional
	@Query(value = "  update medc_indentmaster.medc_indentproduct  ind set ind.ApprovedQty=?3 ,remarksappr=?4     where     ind.IndentRefID=?1  and ind.DrugPrdRefID = ?2  ", nativeQuery = true)
	void updIntProdAvailqtySave(int ind, int drg, Double apprqty, String remarksappr);

	@Modifying
	@Transactional
	@Query(value = "  update medc_indentmaster.medc_indentreq  ind set ind.IndApprFlag=1      where     ind.IndentReqID=?1  ", nativeQuery = true)
	void updateIndApprFlag(int ind);

}
