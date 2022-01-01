
package com.medeil.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.medeil.domain.StkMinQty;

public interface StkMinRepository extends JpaRepository<StkMinQty, Long> {

	// StkMinQty save(StkMinQty pr);

	/*
	 * // Boopalan 060519 stk.Qty
	 * 
	 * @Query(value =
	 * "   SELECT   stk.BrandName,stk.DrugProductID ,str.receivedqty,stk.MinQty ,stk.ageingtime,stk.Qty       FROM medc_stock.medc_mainstock  stk left join ( SELECT  DrugProductRefID, BatchRefID,sum(ReceiveTotalQty)  as  receivedqty ,max(ClientCDate) FROM medc_stock.medc_stkrecproduct   where   LocName =?1 and   LocRefID=?2   group  by DrugProductRefID)  str  on  str.DrugProductRefID=stk. DrugProductID   where  stk.Qty <stk.MinQty  and  stk. LocName =?1 and   stk.LocRefID=?2    group  by   stk.DrugProductID   limit 25  "
	 * , nativeQuery = true) List viewMinimumStock(int lcrnm, int lcrid);
	 */

	// Boopalan 060519 stk.Qty //Boopalan 270619 str.ReceiveTotalQty
	@Query(value = "SELECT  concat(stk.BrandName,' ',cu.genericnamedosage,' ',fu.formulationname) as BrandName,stk.DrugProductID ,coalesce(stk.lastreceivedqty,0),stk.MinQty ,sum(stk.Qty),stk.minstockid,stk.gridcolor,stk.ageingtime,stk.abc,stk.reqqty,mnstk.boxperstrip,mnstk.strippertablet,mnstk.boxqty,mnstk.stripqty,mnstk.tabletqty,mnstk.packageunit\r\n"
			+ "FROM medc_stock.medc_minimumstock  stk\r\n"
			+ "inner join  medc_productmaster.medc_custproductmaster cu on cu.productdrugid=stk.drugproductid\r\n"
			+ "inner join medc_productmaster.medc_formulation fu on fu.formulationid=cu.formulationid\r\n"
			+ "inner join medc_stock.medc_mainstock mnstk on mnstk.stockid = stk.stockid\r\n"
			+ "where  stk.CompanyRefID=?1 and stk.BranchRefID =?2 and    stk. LocName =?3 and   stk.LocRefID=?4 and stk.status=0  group  by   stk.DrugProductID HAVING SUM(stk.Qty) < stk.MinQty ORDER BY minstockid DESC", nativeQuery = true)
	List viewMinimumStock(int compid, int branch, int lcrnm, int lcrid);

	@Query(value = "SELECT  productid,newproductname, reqqty, remarks,gridcolor FROM medc_sales.medc_newproduct  where  companyrefid =?1 and branchrefid =?2 and locname =?3 and locrefid=?4    ", nativeQuery = true)
	List viewMinimumProdNew(Integer compid, Integer branch, int lcrnm, int lcrid);

	@Query(value = " SELECT      IFNULL( max(stkminautoid ) ,0 )   FROM    medc_stock.medc_stockminqty  where  LocRefID=?2  and  LocName=?1    ", nativeQuery = true)
	Double viewStkMinQtyId(Double lcrnm, Double lcrid);

	@Query(value = " SELECT      IFNULL( max(stkminid ) ,0 )   FROM     medc_stock.medc_stockminqty   where  LocRefID=?2  and  LocName=?1    ", nativeQuery = true)
	Double viewStkMinQtyIdNU(Double lcrnm, Double lcrid);

	@Query(value = "  SELECT  IFNULL(RIGHT(stkminno, 7 ),0 )   FROM      medc_stock.medc_stockminqty   where   stkminautoid=?3   and    LocName=?1 and LocRefID=?2 ", nativeQuery = true)
	String viewStkMinQtyIncNo(Double lcrnm, Double lcrid, Double id);

	/*
	 * @Query(value =
	 * "select st.stkminid ,st.stkminno,DATE(st.ClientCDate1 ),sv.totitems,st.IndReqflag,st.drugproductid,cu.brandname,st.abc from (select  count(*) as  totitems ,s.drugproductid,s.stkminno from medc_stock.medc_stockminqty s where s.companyrefid=?1 and s.branchrefid=?2 and s.locname=?3 and s.locrefid=?4  group by s.stkminid )sv,medc_stock.medc_stockminqty st   inner join medc_productmaster.medc_custproductmaster cu on cu.productdrugid=st.drugproductid  where st.companyrefid=?1 and st.branchrefid=?2 and st.LocName=?3 and st.LocRefID=?4   and st.Status!=5   and st.stkminid=st.stkminid and st.stkminno=sv.stkminno "
	 * , nativeQuery = true) List viewStkMinQtyAll(int comp,int branch,int lcrnm,
	 * int lcrid);
	 */

	@Query(value = " SELECT   stkminid ,stkminno,DATE(ClientCDate1 )  , count(*) as  totitems ,IndReqflag  FROM    medc_stock.medc_stockminqty     where companyrefid=?1 and branchrefid=?2 and LocName=?3 and LocRefID=?4   and Status!=5     group by   stkminid  order by stkminid desc", nativeQuery = true)
	List viewStkMinQtyAll(int comp, int branch, int lcrnm, int lcrid);

	@Query(value = "select st.stkminid ,st.stkminno,DATE(st.ClientCDate1 ),st.IndReqflag,st.drugproductid,cu.brandname,st.qty,st.receivedqty,st.minqty,st.minqty as receqty,st.abc,st.remarks from medc_stock.medc_stockminqty st inner join medc_productmaster.medc_custproductmaster cu on cu.productdrugid=st.drugproductid where st.companyrefid=?1 and st.branchrefid=?2 and st.LocName=?3 and st.LocRefID=?4   and st.Status!=5  and st.stkminid=?5", nativeQuery = true)
	List viewStk1MinQtyAll(int comp, int branch, int lcrnm, int lcrid, int stkminid);

	// Boopalan 060519 added stm.Qty,stm.locname, stm.locrefid
	@Query(value = " SELECT   stm. stkminno as stockminno ,DATE(ClientCDate1 ), cust.BrandName  ,stm.stkminautoid,stm. stkminid       ,stm. drugproductid ,stm. batchrefid ,stm. receivedqty,stm. minqty,stm. ClientCDate1       ,  cust.Stripperbox*cust.Quantityperstrip , cust.Quantityperstrip  , cust.MinQty, cust.MaxQty  ,stm.ageingtime ,stm.remarks,stm.qty     FROM   medc_stock.medc_stockminqty  stm	left join (SELECT BrandName,ProductDrugID,Stripperbox,Quantityperstrip,MinQty,MaxQty    from  medc_productmaster.medc_custproductmaster  where   ((LocName=?3 and  LocRefID=?4) || (companyid=?1)))  cust     on   cust.ProductDrugID = stm. drugproductid     where  stm.branchrefid=?2 and  stm.stkminid= ?5 and stm.locname = ?3 and stm.locrefid = ?4 ", nativeQuery = true)
	List viewStkMinQty(int comp, int branch, int locname, int locrefid, int stkid);

	// padmini 170719 added stm.Qty,stm.locname, stm.locrefid
	@Query(value = " update medc_stock.medc_mainstock set stockminrefid=1 where companyrefid=?1 and branchrefid=?2 and locname=?3 and locrefid=?4 and drugproductid=?5 ", nativeQuery = true)
	void updatestkminrefid(int compid, int branchid, double locid, double locrefid, double drgid);

	@Modifying
	@Transactional
	@Query(value = "delete from  medc_stock.medc_stockminqty  where   companyrefid = :comp and branchrefid= :branch and  locname= :locname and locrefid= :locrefid and stkminid= :stkminid", nativeQuery = true)
	void updatestkproduct(@Param("comp") int comp, @Param("branch") int branch, @Param("locname") Double locname,
			@Param("locrefid") Double locrefid, @Param("stkminid") Double stkminid);

	@Modifying
	@Transactional
	@Query(value = "update medc_stock.medc_minimumstock set gridcolor = 1 where CompanyRefID =?1 and  BranchRefID=?2 and  LocName =?3 and  LocRefID=?4 and DrugProductID =?5", nativeQuery = true)
	void gridColorMinimumStock(int compid, int branch, double lcrnm, double lcrid, double drgid);

}
