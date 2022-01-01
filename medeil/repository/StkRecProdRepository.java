
package com.medeil.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.medeil.domain.StockRecProd;

public interface StkRecProdRepository extends JpaRepository<StockRecProd, Long> {

	StockRecProd save(StockRecProd stk);

	// Boopalan added branchrefid
	@Transactional
	@Modifying
	@Query(value = " insert into  medc_stock.medc_mainstock( LocName,LocRefID,lastreceivedqty, Itemcode, DrugProductID, Rackno, Shelfno, Coldstorage, Batchno, Qty,Packing, ExpiryDate, MRP, PurchasePrice, SellingPrice, Margin, MarginAmt, FormulationID, StockDate, MinQty, Status, BanflagID, Salesdiscount, WholeSellingprice, RetailerSellingPrice, FreeQty, StockLoc, CreatedBy, CreatedDate, ModifiedBy, ModifiedDate, CFSellingprice, ClientCDate, ClientMDate,  CompanyRefID, BranchRefID, ShopRefID, HospitalRefID, SellingPrice1, SellingPrice2, SellingPrice3,  SellingPrice4, BoxQty, StripQty, TabletQty, FreeBoxQty, FreeStripQty, FreeTabletQty, StockStatus,  InwardType, PurchInvRefID, DosageID, BoxPerStrip, StripPerTablet, FreeTotalQty, unitsgst, unitcgst, unitigst, unitutgst, unitgst, sgstamt, cgstamt, igstamt, utgstamt, gstamt, vat, vatamt, BrandName, LeadTime, clientcdate1, Calcflag, AgeingTime, GenericName,BatchName,packageunit,unitprice)    SELECT  ?3,?4,?8, Itemcode, DrugProductID, Rackno, Shelfno, Coldstorage, Batchno, 0,Packing, ExpiryDate, MRP, PurchasePrice, SellingPrice, Margin, MarginAmt, FormulationID, StockDate, MinQty, 0, BanflagID, Salesdiscount, WholeSellingprice, RetailerSellingPrice, FreeQty, StockLoc, CreatedBy, CreatedDate, ModifiedBy, ModifiedDate, CFSellingprice, ClientCDate, ClientMDate, CompanyRefID,?7, ShopRefID, HospitalRefID, SellingPrice1, SellingPrice2, SellingPrice3,SellingPrice4, BoxQty, StripQty, TabletQty, FreeBoxQty, FreeStripQty, FreeTabletQty, StockStatus, InwardType, PurchInvRefID, DosageID, BoxPerStrip, StripPerTablet, FreeTotalQty, unitsgst, unitcgst, unitigst, unitutgst, unitgst, sgstamt, cgstamt, igstamt,utgstamt, gstamt, vat, vatamt, BrandName, LeadTime, clientcdate1, Calcflag, AgeingTime, GenericName,BatchName,?9,unitprice  FROM medc_stock.medc_mainstock  where   drugproductid= ?5  and   Batchno=?6    and    LocName=?1   and  LocRefID=?2  limit  1", nativeQuery = true)
	Integer saveStock(Integer lcrnm1, Integer lcrid1, Integer lcrnm2, Integer lcrid2, Double drg, Double bth,
			Integer branchids, Integer lastreceivedqty, String packageunit);

	@Query(value = " SELECT count(*)  FROM medc_stock.medc_mainstock     where   drugproductid= ?3  and   Batchname=?4    and    LocName=?1   and  LocRefID=?2", nativeQuery = true)
	Integer StockCount(Integer lcrnm, Integer lcrid, Double drg, String bth);

	@Query(value = "SELECT  StkTrfID, StkTrfNo ,fromlocrefid,fromlocname ,tolocrefid,     tolocname ,IndrefId , namefromlocname, namefromlocrefid, nametolocname,       nametolocrefid  FROM medc_stock.medc_stocktransfer  str   inner join (SELECT StkTrfRefID  FROM medc_stock.medc_stktrfproduct  where stkrecflag!=1  group  by StkTrfRefID)  sp  on  str.StkTrfID=sp.StkTrfRefID   where  str.fromLocRefID=?2 and  str.fromLocName=?1 ", nativeQuery = true)
	List viewStkTransfer(int lcrnm, int lcrid);

	@Query(value = " SELECT   drg.BrandName ,stk. stktrfrefid, stk.drugproductrefid, stk. batchrefid , IFNULL(stk. transfertotalqty,0)-IFNULL(str.recqty,0) as receivedqty ,      stk.  boxconvstk , stk. stripconvstk , stk. ProdreqQty,stk. ApprTotalQty,stk. WaitingTotalQty      ,stk. RejectQty,stk.batchname, Date(stk.ExpiryDate), stk.stkmainrefid  , stk.StkTrfProID    , stk.unitprice,stk.packageunit    FROM medc_stock.medc_stktrfproduct  stk   left join 	(SELECT      DrugProductRefID, BatchRefID,sum(IFNULL(ReceiveTotalQty,0))  as  recqty  ,stktransprodrefid  FROM medc_stock.medc_stkrecproduct  where  LocName=?1 and LocRefID=?2   group by   stktransprodrefid )  str  on   stk.StkTrfProID = str.stktransprodrefid   left join  (SELECT BrandName,ProductDrugID    from  medc_productmaster.medc_custproductmaster  where  companyID=?4)   drg on     stk.DrugProductRefID= drg.ProductDrugID    where     stk.StkTrfRefID =?3  and  stk.stkrecflag !=1 ", nativeQuery = true)
	List viewStkTransfProducts(int lcrnm, int lcrid, int name, Integer compid);

	@Query(value = "  SELECT  str.StkRecID,str. StkRecNo,DATE(str.ClientCDate1) , str. namefromlocname, str. namefromlocrefid,      str.  nametolocname, str. nametolocrefid, st.StkTrfNo ,DATE(st.ClientCDate1)  FROM medc_stock.medc_stockreceive str  left join  medc_stock.medc_stocktransfer  st    on  st.StkTrfID= str.StkTransRefID  where  str. LocName=?1 and str. LocRefID=?2  order by str.StkRecID desc", nativeQuery = true)
	List viewStkReceiveAll(int lcrnm, int lcrid);

	@Query(value = " SELECT  StkRecID, StkRecNo,DATE(ClientCDate1)   FROM medc_stock.medc_stockreceive     where     StkRecID =?3    and    LocName=?1 and LocRefID=?2 ", nativeQuery = true)
	List viewStkReceiveNo(int lcrnm, int lcrid, int id);

	@Query(value = "  SELECT      drg.BrandName ,stk. StkRecRefID, stk.drugproductrefid, stk. batchrefid , stk. transfertotalqty      ,stk. ReceiveTotalQty, stk.  boxconvstk , stk. stripconvstk ,  stk.ClientCDate1  as  cldate , stk.prodreqqty      , stk.apprtotalqty  , stk.waitingtotalqty ,stk. rejectqty ,stk. BatchName ,stk.remarks ,stk.stkmainrefid,date(stk.ExpiryDate)    FROM medc_stock.medc_stkrecproduct  stk  left join  (SELECT BrandName,ProductDrugID   from  medc_productmaster.medc_custproductmaster  where  ((LocName=?1 and  LocRefID=?2) || (companyID=?4)))   drg on    drg.ProductDrugID  = stk.DrugProductRefID  where     stk.StkRecRefID =?3  ", nativeQuery = true)
	List viewStkReceiveProds(int lcrnm, int lcrid, int name, Integer compid);

	// Boopalan added branchrefid
	@Modifying
	@Transactional
	@Query(value = " update  medc_stock.medc_mainstock   set qty=ifnull(qty,0) +?5 ,lastreceivedqty=?7   where   DrugProductID=?3  and      Batchno=?4     and    LocName=?1 and LocRefID=?2 and branchrefid=?6 ", nativeQuery = true)
	void updateMainstockSave(Double lcrnm, Double lcrid, Double drg, Double bth, Integer qty, Integer branchids,
			Integer lastreceivedqty);

	@Modifying
	@Transactional
	@Query(value = " update  medc_stock.medc_stocktransfer   set StkRecFlag=1  where   StkTrfID=?1 ", nativeQuery = true)
	void updateStockTransfer(Double id);

	@Modifying
	@Transactional
	@Query(value = " update  medc_stock.medc_stktrfproduct    set StkRecFlag=1  where   StkTrfRefID=?1  and   DrugProductRefID=?2 and BatchRefID=?3  ", nativeQuery = true)
	void updateStkRecFlag(Double str, Double drg, Double bth);

	// Boopalan
	@Query(value = "select coalesce(sum(m.ReceiveTotalQty),0) FROM medc_stock.medc_stkrecproduct m inner join (select max(clientcdate)lastdate,DrugProductRefID,locname,locrefid FROM medc_stock.medc_stkrecproduct  where DrugProductRefID =?5 and CompanyRefID=?1 and BranchRefID =?2 and locname =?3 and locrefid =?4 )mn on mn.lastdate = m.clientcdate where  m.CompanyRefID=?1 and m.BranchRefID =?2 and m.locname =?3 and m.locrefid =?4 and m.DrugProductRefID =?5 ", nativeQuery = true)
	Integer getLastReceivedQty(Integer compid, Integer branchid, Double locname, Double locrefid,
			Double drugproductrefid);

	// Boopalan added branchrefid
	@Modifying
	@Transactional
	@Query(value = "update medc_stock.medc_minimumstock set status = 5 where CompanyRefID=?1 and BranchRefID=?2 and LocName=?3 and LocRefID =?4  and drugproductid =?5 ", nativeQuery = true)
	void updateMinimumStock(Integer compid, Integer branchid, Double locname, Double locrefid, Double drugproductrefid);

}
