
package com.medeil.repository;

import java.util.List;
import javax.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.medeil.domain.Shortexpirysettings;
import com.medeil.domain.StockExpiry;

@SuppressWarnings("rawtypes")
@Repository

public interface StkExpRepository extends JpaRepository<StockExpiry, Long> {
	

	@Query(value = " SELECT IFNULL(  max( StkExpAutID  ) ,0  )      FROM   medc_stock.medc_stockexpiry      where  LocName=?1 and LocRefID=?2  ", nativeQuery = true)
	Double viewStockExpId(Double lcrnm, Double lcrid);

	@Query(value = " SELECT IFNULL(  max( StkExpID  ) ,0  )      FROM   medc_stock.medc_stockexpiry      where  LocName=?1 and LocRefID=?2  ", nativeQuery = true)
	Double viewStockExpIdNU(Double lcrnm, Double lcrid);

	@Query(value = "  SELECT     IFNULL( RIGHT( stkexpno, 7  ),0  )    FROM    medc_stock.medc_stockexpiry  where  StkExpAutID=?3    and    LocName=?1 and LocRefID=?2 ", nativeQuery = true)
	String viewStockExpIncNo(Double lcrnm, Double lcrid, Double id);

	@Query(value = " SELECT   ws.BrandName ,ws.Batchno, ws.Qty ,ws.DrugProductID   FROM       medc_stock.medc_mainstock  ws     where     ws.BrandName like  %?3%      and    ws.LocName=?1 and ws.LocRefID=?2   and  Date(ExpiryDate)< Date(now())  ORDER BY     ws.BrandName  LIMIT 10 ", nativeQuery = true)
	List viewMainstocks(int lcrnm, int lcrid, String name);

	@Query(value = " SELECT stk. brandname,stk.DrugProductID,stk.Batchno,stk.Qty,stk. MRP    , pdt. Stripperbox*pdt. Quantityperstrip ,pdt. Quantityperstrip   FROM medc_stock.medc_mainstock stk 	left join ( SELECT BrandName,ProductDrugID,Stripperbox ,Quantityperstrip  from  medc_productmaster.medc_custproductmaster  where  ((LocName=?1 and  LocRefID=?2) || (companyID=?5)))   pdt  on stk.DrugProductID=pdt.ProductDrugID     where    stk.DrugProductID=?3   and  stk.Batchno=?4    and  stk.LocName=?1   and  stk.LocRefID=?2   ", nativeQuery = true)
	List viewMainstock(int lcrnm, int lcrid, int drg, int batchno, Integer compid);

	@Query(value = " SELECT   stk. brandname,stk.DrugProductID,m.Batchno,stk.Qty,stk. MRP    , stk. BoxPerStrip*stk. StripPerTablet ,stk. StripPerTablet,stk.ExpiryDate,m.BatchID,stk.unitprice,stk.stockid FROM  medc_stock.medc_mainstock  stk left join medc_stock.medc_drugbatch m on stk.Batchno=m.BatchID     where      stk.LocName=?1 and stk.LocRefID=?2 and stk.companyrefid=?3 and stk.branchrefid=?4   and destroystatus =0 and  Date(ExpiryDate)< Date(now()) and Qty>0      LIMIT 100 ", nativeQuery = true)
	List viewMainstockExpiry(int lcrnm, int lcrid, int comp, int branch);

	@Query(value = "    SELECT StkExpID, StkExpNo ,DATE( ClientCDate1  ) FROM medc_stock.medc_stockexpiry   where  LocName=?1 and LocRefID=?2  and   Status!=5   group  by   StkExpID  order by StkExpID desc  ", nativeQuery = true)
	List viewStockExpAll(int lcrnm, int lcrid);

	@Query(value = "SELECT stp.StkExpNo ,DATE( stp.ClientCDate1), cust.BrandName  , stp.stkexpautid, stp.stkexpid,\r\n" + 
			"stp.drugproductid, drg.batchno,date(stp.expirydate), stp.actualstockqty ,stp.expboxqty, stp.expstripqty,stp.exptabqty ,\r\n" + 
			"stp.expstockqty, stp.stkexpno  , stp.boxconvstk, stp.stripconvstk , stp.ClientCDate1  AS  cldate FROM  medc_stock.medc_stockexpiry  stp\r\n" + 
			"INNER JOIN medc_stock.medc_drugbatch drg on drg.batchid=stp.batchrefid\r\n" + 
			"INNER JOIN medc_productmaster.medc_custproductmaster cust on cust.productdrugid = stp.drugproductid\r\n" + 
			"WHERE stp.StkExpID=?3 AND stp.companyrefid=?4 AND stp.LocName=?1 AND  stp.LocRefID=?2 AND stp.Status!=5", nativeQuery = true)
	List viewStockExpiry(int lcrnm, int lcrid, int stk, Integer compid);

	@Modifying
	@Transactional
	@Query(value = " update  medc_stock.medc_mainstock   set qty=ifnull(?5,0)  where   DrugProductID=?3  and   Batchno=?4     and    LocName=?1 and LocRefID=?2  ", nativeQuery = true)
	void updateMainstockSave(Double lcrnm, Double lcrid, Double drg, Double bth, Double qty);

	@Modifying
	@Transactional
	@Query(value = "   update  medc_stock.medc_mainstock   st,medc_stock.medc_stockexpiry  sp  set st.qty= ifnull(st.qty,0)+ifnull(sp.ExpStockQty,0)        where   st.DrugProductID=sp.DrugProductID  and st.Batchno=sp.BatchRefID  and st.LocName=sp.LocName and st.LocRefID=sp.LocRefID   and   sp.StkExpID =?3   and  sp.LocName=?1 and sp.LocRefID=?2    ", nativeQuery = true)
	void updateMainstockEdit(Double lcrnm, Double lcrid, Double id);

	@Modifying
	@Transactional
	@Query(value = "update   medc_stock.medc_stockexpiry   set   Status=5   where   StkExpID=?3  and   LocName=?1 and LocRefID=?2  ", nativeQuery = true)
	int deleteStockExpiry(int lcrnm, int lcrid, int id);
	
	//Destroyed Product DesingRaja
	@Modifying
	@Transactional
	@Query(value="UPDATE medc_stock.medc_mainstock SET destroystatus=1 WHERE stockid=:stockid AND Drugproductid=:prodid AND companyrefid =:compid AND branchrefid=:branchid AND locname=:locname AND Locrefid =:locrefid ",nativeQuery = true)
	void updatedestroy(@Param("stockid")Integer stockid,@Param("prodid") Integer prodid,@Param("compid") Integer compid,@Param("branchid") Integer branchid,@Param("locname") Integer locname,@Param("locrefid") Integer locrefid);
	
	@Query(value="SELECT se.no_days, se.no_month, se.no_year, se.expiryflag FROM medc_stock.medc_shortexpsettings se WHERE se.companyrefid =:compid AND se.branchrefid =:branchid AND se.locname =:locname AND se.locrefid =:locrefid ",nativeQuery = true)
	List shortstatus(@Param("compid") Integer compid,@Param("branchid") Integer branchid,@Param("locname") Integer locname,@Param("locrefid") Integer locrefid);
	

}
