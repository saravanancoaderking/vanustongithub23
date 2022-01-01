
package com.medeil.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.medeil.domain.StockRetProducts;

public interface StkRetnProdRepository extends JpaRepository<StockRetProducts, Long> {

	StockRetProducts save(StockRetProducts stk);

	@Transactional
	@Modifying
	@Query(value = " insert into  medc_stock.medc_mainstock( LocName,LocRefID, Itemcode, DrugProductID, Rackno, Shelfno, Coldstorage, Batchno, Qty,Packing, ExpiryDate, MRP, PurchasePrice, SellingPrice, Margin, MarginAmt, FormulationID, StockDate, MinQty, Status, BanflagID, Salesdiscount, WholeSellingprice, RetailerSellingPrice, FreeQty, StockLoc, CreatedBy, CreatedDate, ModifiedBy, ModifiedDate, CFSellingprice, ClientCDate, ClientMDate,  CompanyRefID, BranchRefID, ShopRefID, HospitalRefID, SellingPrice1, SellingPrice2, SellingPrice3,  SellingPrice4, BoxQty, StripQty, TabletQty, FreeBoxQty, FreeStripQty, FreeTabletQty, StockStatus,  InwardType, PurchInvRefID, DosageID, BoxPerStrip, StripPerTablet, FreeTotalQty, unitsgst, unitcgst, unitigst, unitutgst, unitgst, sgstamt, cgstamt, igstamt, utgstamt, gstamt, vat, vatamt, BrandName, LeadTime, clientcdate1, Calcflag, AegingTime, GenericName)    SELECT  ?3,?4, Itemcode, DrugProductID, Rackno, Shelfno, Coldstorage, Batchno, 0,Packing, ExpiryDate, MRP, PurchasePrice, SellingPrice, Margin, MarginAmt, FormulationID, StockDate, MinQty, Status, BanflagID, Salesdiscount, WholeSellingprice, RetailerSellingPrice, FreeQty, StockLoc, CreatedBy, CreatedDate, ModifiedBy, ModifiedDate, CFSellingprice, ClientCDate, ClientMDate, CompanyRefID, BranchRefID, ShopRefID, HospitalRefID, SellingPrice1, SellingPrice2, SellingPrice3,SellingPrice4, BoxQty, StripQty, TabletQty, FreeBoxQty, FreeStripQty, FreeTabletQty, StockStatus, InwardType, PurchInvRefID, DosageID, BoxPerStrip, StripPerTablet, FreeTotalQty, unitsgst, unitcgst, unitigst, unitutgst, unitgst, sgstamt, cgstamt, igstamt,utgstamt, gstamt, vat, vatamt, BrandName, LeadTime, clientcdate1, Calcflag, AegingTime, GenericName FROM medc_stock.medc_mainstock  where   drugproductid= ?5  and   Batchno=?6    and    LocName=?1   and  LocRefID=?2  limit  1", nativeQuery = true)
	Integer saveStock(Integer lcrnm1, Integer lcrid1, Integer lcrnm2, Integer lcrid2, Double drg, Double bth);

	@Query(value = " SELECT count(*)  FROM medc_stock.medc_mainstock     where   drugproductid= ?3  and   Batchno=?4    and    LocName=?1   and  LocRefID=?2", nativeQuery = true)
	Integer StockCount(Integer lcrnm, Integer lcrid, Double drg, Double bth);

	@Query(value = " SELECT    IFNULL( max(StkRetnProID) ,0)   FROM   medc_stock.medc_stkretnproduct       where  LocName=?1 and LocRefID=?2    limit 1  ", nativeQuery = true)
	Integer viewStockReturnId(Double lcrnm, Double lcrid);

	@Query(value = " SELECT    IFNULL( max(StkRetnID) ,0)   FROM   medc_stock.medc_stkretnproduct       where  LocName=?1 and LocRefID=?2   ", nativeQuery = true)
	Double viewStockReturnIdNU(Double lcrnm, Double lcrid);

	@Query(value = "  SELECT  IFNULL(RIGHT(stkretnno, 7),0)   FROM   medc_stock.medc_stkretnproduct    where   StkRetnProID=?3    and    LocName=?1 and LocRefID=?2   ", nativeQuery = true)
	String viewStockReturnIncNo(Double lcrnm, Double lcrid, Double id);

	@Query(value = " SELECT si.stkretnno from  medc_stock.medc_stkretnproduct  si  join ( SELECT  IFNULL( max(StkRetnID) ,0)  as maxid FROM   medc_stock.medc_stkretnproduct  where         LocName=?1 and LocRefID=?2  )  sid  on  sid.maxid=si.StkRetnID  limit 1  ", nativeQuery = true)
	String viewStockReturnMaxNo(Double lcrnm, Double lcrid);

	@Query(value = " SELECT  StkTrfID, StkTrfNo ,fromlocrefid,fromlocname ,tolocrefid,     tolocname ,IndrefId , namefromlocname, namefromlocrefid, nametolocname     , nametolocrefid   FROM medc_stock.medc_stocktransfer  where  fromLocRefID=?2 and  fromLocName=?1 and stkretflag=0 order by StkTrfID desc", nativeQuery = true)
	List viewStkTransfer(int lcrnm, int lcrid);

	@Query(value = "SELECT  drg.BrandName ,stk. stktrfrefid, stk.drugproductrefid, stk. batchrefid , IFNULL(stk. transfertotalqty,0) - IFNULL(returnqty,0)  as  remaintransqty   , stk.  boxconvdrg , stk. stripconvdrg, stk. ProdreqQty,stk. ApprTotalQty,stk. WaitingTotalQty     ,stk. RejectQty , stk.batchname, Date(stk.ExpiryDate) ,stk.stkmainrefid , stk.StkTrfProID   , stk.unitprice, stk.transferboxqty, stk.transferstripqty, stk.transfertabqty, stk.transfertotalqty,stk.packageunit  FROM medc_stock.medc_stktrfproduct  stk  left join 	(SELECT   sum(IFNULL(ReturnTotalQty,0))  as  returnqty  ,stktransprodrefid  FROM medc_stock.medc_stkretnproduct  where  LocName=?1 and LocRefID=?2   group by   stktransprodrefid )  str  on   stk.StkTrfProID = str.stktransprodrefid left join  (SELECT BrandName,ProductDrugID   from  medc_productmaster.medc_custproductmaster  where   ((LocName=?1 and  LocRefID=?2) || (companyID=?4)) )  	drg on    drg.ProductDrugID  = stk.DrugProductRefID    where     stk.StkTrfRefID =?3    ", nativeQuery = true)
	List viewStkTransfProducts(int lcrnm, int lcrid, int name, Integer compid);

	@Query(value = "SELECT  str.StkRetnID,str. StkRetnNo,DATE(str.ClientCDate1),str. IndRefId, str.namefromlocname,       str.namefromlocrefid, str.nametolocname, str.nametolocrefid, st.StkTrfNo ,DATE(st.ClientCDate1)   FROM medc_stock.medc_stkretnproduct  str  left join  medc_stock.medc_stocktransfer  st    on  st.StkTrfID= str.StkTrfRefID    where str.status = !5 and str.LocName=?1 and str.LocRefID=?2   group  by  str.StkRetnID  order by  str.StkRetnID desc", nativeQuery = true)
	List viewStkReturnAll(int lcrnm, int lcrid);

	@Query(value = "   	SELECT    stk. StkRetnNo,DATE(stk.ClientCDate1),  drg.BrandName ,stk. StkRetnID, stk.drugproductrefid,     stk. batchrefid , stk. transfertotalqty ,stk.  ReturnTotalQty,stk.  boxconvstk , stk. stripconvstk        ,stk.ClientCDate1  as  cldate, stk.retboxqty ,stk.retstripqty,stk.rettabqty ,stk.batchname     ,stk.remarks ,stk.stkmainrefid    FROM medc_stock.medc_stkretnproduct  stk 	left join  (SELECT BrandName,ProductDrugID   from  medc_productmaster.medc_custproductmaster  where   ((LocName=?1 and  LocRefID=?2) || (companyID=?4)))  drg on    drg.ProductDrugID  = stk.DrugProductRefID  where     stk.StkRetnID =?3    and    stk.LocName=?1 and stk.LocRefID=?2  ", nativeQuery = true)
	List viewStkReturnProds(int lcrnm, int lcrid, int name, Integer compid);

	@Modifying
	@Transactional
	@Query(value = " update  medc_stock.medc_mainstock   set qty=qty-?5  where   DrugProductID=?3  and   Batchno=?4     and    LocName=?1 and LocRefID=?2  ", nativeQuery = true)
	void updateMainstockFrom(Integer lcrnm, Integer lcrid, Double drg, Double bth, Double qty);

	@Modifying
	@Transactional
	@Query(value = " update  medc_stock.medc_mainstock   set qty=qty+?5  where   DrugProductID=?3  and   Batchno=?4     and    LocName=?1 and LocRefID=?2  ", nativeQuery = true)
	void updateMainstockTo(Integer lcrnm, Integer lcrid, Double drg, Double bth, Double qty);

	@Modifying
	@Transactional
	@Query(value = "update   medc_stock.medc_stkretnproduct   set   Status=5   where   StkRetnID=?3  and   LocName=?1 and LocRefID=?2  ", nativeQuery = true)
	int deleteStockReturn(int lcrnm, int lcrid, int id);

	@Modifying
	@Transactional
	@Query(value = " update  medc_stock.medc_stocktransfer   set stkretflag = 1  where    stktrfid=?1 ", nativeQuery = true)
	void updatesktrflag(Double stkrefid);

}
