
package com.medeil.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.medeil.domain.StockTrnfrProd;

public interface StkTfrProdRepository extends JpaRepository<StockTrnfrProd, Long> {

	StockTrnfrProd save(StockTrnfrProd pr);

	@Query(value = "  SELECT IndentReqID , indentno,fromlocrefid,fromlocname ,tolocrefid,      tolocname ,ClientCDate1  as  cldate ,  namefromlocname, namefromlocrefid, nametolocname, nametolocrefid   FROM medc_indentmaster.medc_indentreq  irq  inner  join (SELECT IndentRefID  FROM medc_indentmaster.medc_indentproduct  where stktransflag!=1  group  by IndentRefID) ip on  irq.IndentReqID=ip.IndentRefID    where  irq.toLocRefID=?2  and   irq.toLocName=?1 and  irq.IndApprFlag=1 order by IndentReqID desc ", nativeQuery = true)
	List viewIndentRequests(int lcrnm, int lcrid);

	@Query(value = " SELECT  ip.DrugPrdRefID,ip.drugname, IFNULL(ip.ApprovedQty,0) - IFNULL(stk.stransapprqty,0) as 'reqqty',coalesce(s.stkqty,0) as 'availableqty',  ip.IndentRefID        ,ip.boxconvdrg,ip.stripconvdrg ,ip.ClientCDate1  as  cldate ,s.StockID ,ip.IndentPrdID,IFNULL(ip.boxqty,0) - IFNULL(stk.transferboxqty,0),ip.stripqty,ip.tabqty,ip.packageunit  FROM  medc_indentmaster.medc_indentproduct  ip  left join ( SELECT  DrugProductRefID ,sum(IFNULL(ApprTotalQty,0)) as stransapprqty,sum(IFNULL(RejectQty,0)) as stransrejqty,indentprodrefid,sum(transferboxqty) as transferboxqty  from medc_stock.medc_stktrfproduct   where LocName=?1 and  LocRefID=?2 and  uniqueflag=1  group by  indentprodrefid ) stk   on ip.IndentPrdID=stk.indentprodrefid  left  join( SELECT brandname, DrugProductID ,sum(IFNULL(qty,0))  as  stkqty,StockID from medc_stock.medc_mainstock    where  LocName=?1 and  LocRefID=?2  group  by  DrugProductID )s   on  ip.DrugPrdRefID=s.DrugProductID  where   ip .IndentRefID= ?3 and stktransflag!=1   group by  ip.IndentPrdID  ", nativeQuery = true)
	List viewIndentProduct(int lcrnm, int lcrid, int ip);

	@Query(value = "SELECT pdt.BrandName  ,stk.DrugProductID ,  stk.Batchno, stk.Qty ,stk. BoxPerStrip   *stk. StripPerTablet     ,stk. StripPerTablet,IFNULL(stk.batchname,\"No_Batch\") as batchname ,Date(stk.ExpiryDate),stk.StockID,stk.SellingPrice   FROM medc_stock.medc_mainstock  stk  	left join (SELECT BrandName,ProductDrugID,Stripperbox,Quantityperstrip          from  medc_productmaster.medc_custproductmaster  where ((LocName=?1 and  LocRefID=?2) || (companyID=?4)))  pdt on stk.DrugProductID=pdt.ProductDrugID    where    stk.status=0 and stk.drugproductid= ?3  and    stk.LocName=?1  and stk.LocRefID=?2     order by  stk.ExpiryDate  asc ", nativeQuery = true)
	List viewIndMainstock(int lcrnm, int lcrid, int drg, Integer compid);

	@Query(value = " SELECT   ws.BrandName ,ws.Batchno, ws.Qty ,ws.DrugProductID,ws.batchname , Date(ws.ExpiryDate)     ,ws.StockID      FROM       medc_stock.medc_mainstock  ws     where     ws.BrandName like  %?3%      and    ws.LocName=?1 and  ws.LocRefID=?2  ORDER BY     ws.BrandName  LIMIT 10 ", nativeQuery = true)
	List viewMainstocks(int lcrnm, int lcrid, String name);

	@Query(value = "SELECT pdt.BrandName  ,stk.DrugProductID , stk.Qty ,stk. BoxPerStrip,stk. StripPerTablet,IFNULL(stk.batchname,stk.StockID) as batchname,Date(stk.ExpiryDate),stk.StockID,stk.unitprice,stk.boxqty,stk.stripqty,stk.tabletqty   FROM medc_stock.medc_mainstock  stk  	left join (SELECT BrandName,ProductDrugID,Stripperbox,Quantityperstrip          from  medc_productmaster.medc_custproductmaster  where ((LocName=?1 and  LocRefID=?2) || (companyID=?4)))  pdt on stk.DrugProductID=pdt.ProductDrugID    where    stk.status=0 and stk.drugproductid= ?3  and    stk.LocName=?1  and stk.LocRefID=?2     order by  stk.ExpiryDate  asc  ", nativeQuery = true)
	List viewMainstock(int lcrnm, int lcrid, int drg, int batchno, Integer compid);

	// need to change

	@Query(value = " SELECT  str.StkTrfID,str. StkTrfNo,DATE(str.ClientCDate1) , str.namefromlocname, str.namefromlocrefid,    str. nametolocname, str.nametolocrefid,irq.indentno,DATE(irq.ClientCDate1) FROM medc_stock.medc_stocktransfer  str left join   medc_indentmaster.medc_indentreq  irq  on  irq.IndentReqID= str.IndrefID  where   str.LocRefID=?2  and   str.LocName=?1  order by str.StkTrfID desc", nativeQuery = true)
	List viewStkTrnfrAll(int lcrnm, int lcrid);

	@Query(value = " SELECT StkTrfID, StkTrfNo ,DATE(ClientCDate1)    FROM medc_stock.medc_stocktransfer stk   where  stk.StkTrfID=?3  and    stk.LocName=?1 and stk.LocRefID=?2   ", nativeQuery = true)
	List viewStkTransferNo(int lcrnm, int lcrid, int name);

	@Query(value = " SELECT  drg.BrandName ,stk. stktrfrefid, stk.drugproductrefid, stk. batchrefid , stk. transfertotalqty      , stk.  boxconvstk , stk. stripconvstk , stk.ClientCDate1   as  cldate ,DATE(stk.ClientCDate1) ,stk.prodreqqty     ,stk.prodavailqty  , stk. apprtotalqty  ,stk. waitingtotalqty , stk.rejectqty  ,stk.rejectreason      ,stk.BatchName, stk.stkmainrefid       FROM medc_stock.medc_stktrfproduct  stk 	left join  (SELECT BrandName,ProductDrugID   from  medc_productmaster.medc_custproductmaster  where  ((LocName=?1 and  LocRefID=?2) || (companyID=?4)))   drg on    drg.ProductDrugID  = stk.DrugProductRefID      where     stk.StkTrfRefID =?3    and    stk.LocName=?1 and stk.LocRefID=?2  ", nativeQuery = true)
	List viewStkTransfProducts(int lcrnm, int lcrid, int name, Integer compid);

	@Modifying
	@Transactional
	@Query(value = " update  medc_stock.medc_mainstock   set qty=ifnull(qty,0)-?5  where   DrugProductID=?3  and   Batchno=?4    and    LocName=?1 and LocRefID=?2  ", nativeQuery = true)
	void updateMainstockSave(Double lcrnm, Double lcrid, Double drg, Double bth, Double qty);

	@Modifying
	@Transactional
	@Query(value = "  update medc_indentmaster.medc_indentproduct  ind set ind.stktransflag=1      where     ind.IndentRefID=?1   and  ind.DrugPrdRefID=?2  ", nativeQuery = true)
	void updateStkTransFlag(Double ind, Double drg);

}
