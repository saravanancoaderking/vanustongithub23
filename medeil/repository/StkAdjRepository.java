













package com.medeil.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.medeil.domain.StockAdjust;

public interface StkAdjRepository extends JpaRepository<StockAdjust, Long> {

	StockAdjust save( StockAdjust stk  );

	@Query( value = " SELECT    IFNULL(  max( StkAdjAutID  ) ,0  )  FROM    medc_stock.medc_stockadjust     where  LocName=?1 and LocRefID=?2   ", nativeQuery = true  )
	int viewStockAdjId( Double lcrnm ,Double lcrid );
	
	@Query( value = " SELECT    IFNULL(  max( StkAdjID  ) ,0  )  FROM    medc_stock.medc_stockadjust     where  LocName=?1 and LocRefID=?2   ", nativeQuery = true  )
	int viewStockAdjIdNU(  Double lcrnm ,Double lcrid  );
	

	@Query( value = "  SELECT    IFNULL( RIGHT( stkadjno, 7  ),0  )    FROM    medc_stock.medc_stockadjust  where  StkAdjAutID=?3     and    LocName=?1 and LocRefID=?2 ", nativeQuery = true  )
	String viewStockAdjIncNo(  Double lcrnm ,Double lcrid  ,  int  id );

	@Query( value = "SELECT   ws.BrandName ,ws.Batchno, ws.Qty ,ws.DrugProductID   FROM       medc_stock.medc_mainstock  ws     where     ws.BrandName like  %?3%      and    LocName=?1 and LocRefID=?2  ORDER BY     ws.BrandName  LIMIT 10 ", nativeQuery = true  )
	List viewMainstocks(   int lcrnm ,int lcrid  , String name );

	@Query( value = " SELECT stk. brandname,stk.DrugProductID,stk.Batchno,stk.Qty,stk. MRP     , pdt. Stripperbox*pdt. Quantityperstrip ,pdt. Quantityperstrip   FROM medc_stock.medc_mainstock stk	left join ( SELECT BrandName,ProductDrugID ,Stripperbox,Quantityperstrip   from  medc_productmaster.medc_custproductmaster  where   ((LocName=?1 and  LocRefID=?2) || (companyID=?5))  )   pdt  on stk.DrugProductID=pdt.ProductDrugID    where    stk.DrugProductID=?3   and  stk.Batchno=?4    and  stk.LocName=?1   and  stk.LocRefID=?2  ", nativeQuery = true  )
	List viewMainstock(  int lcrnm ,int lcrid  ,  int drg, int batchno,Integer  compid  );
	
	
	
	
	@Query( value = "SELECT  StkAdjID,StkAdjNo ,DATE( ClientCDate1  ) FROM medc_stock.medc_stockadjust  where  LocName=?1 and LocRefID=?2  and   Status!=5  group  by   StkAdjID desc     ", nativeQuery = true  )
	List viewStockAdjAll(  int lcrnm ,int lcrid    );
	

	@Query( value = "SELECT  sta.StkAdjNo ,DATE(sta.ClientCDate1),cust.BrandName , sta. stkadjautid, sta. stkadjid,sta.drugproductid, sta. batchrefid,\r\n" + 
			"sta. actualstock,sta.physicalboxstock, sta.physicalstripstock,sta.physicaltabstock,sta. physicalstock, sta.adjustedstock,sta.actualstkvalue, sta. physicalstkvalue,\r\n" + 
			"sta.adjustedstkvalue , sta. remarks ,sta.stkadjno,sta.unitstkvalue,sta.boxconvstk,sta.stripconvstk,DATE(sta.ClientCDate1)  AS  cldate FROM   medc_stock.medc_stockadjust  sta\r\n" + 
			"LEFT JOIN medc_productmaster.medc_custproductmaster cust ON cust.ProductDrugID =sta.drugproductid\r\n" + 
			"WHERE   sta.StkAdjID=?3 AND sta.LocName=?1  AND  sta.LocRefID=?2  AND  sta.Status!=5", nativeQuery = true  )
	List viewStockAdjust(int lcrnm ,int lcrid  , int dst,Integer  compid  );
	
	
	
	@Modifying
	@Transactional
	@Query( value = " update  medc_stock.medc_mainstock   set qty=ifnull(qty,0)-?5  where   DrugProductID=?3  and   Batchno=?4  and LocName=?1 and LocRefID=?2 ", nativeQuery = true  )
	void updateMainstockSave(  Double lcrnm ,Double lcrid  ,  Double drg, Double bth, Double qty);

	@Modifying
	@Transactional
	@Query( value = " update  medc_stock.medc_mainstock   st,medc_stock.medc_stockadjust   sa  set st.qty= ifnull(st.qty,0)+ ifnull(sa.AdjustedStock,0)       where   st.DrugProductID=sa.DrugProductID  and st.Batchno=sa.BatchRefID and st.LocName=sa.LocName and st.LocRefID=sa.LocRefID   and    sa.StkAdjID =?3  and   sa. LocName=?1 and sa.LocRefID=?2   ", nativeQuery = true  )
	void updateMainstockEdit(  Double lcrnm ,Double lcrid  ,  int stk   );
	
	
	
	@Modifying
	@Transactional
	@Query( value = "update medc_stock.medc_stockadjust    set   Status=5   where   StkAdjID=?3  and  LocName=?1 and LocRefID=?2  ", nativeQuery = true  )
	int deleteStockAdj(  int lcrnm ,int lcrid  ,  int id);
	

}



