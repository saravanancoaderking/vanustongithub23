







package com.medeil.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.medeil.domain.StockTransfer;

public interface StkTransRepository extends JpaRepository<StockTransfer, Long> {

	StockTransfer save(StockTransfer stk);

	@Query(value = "SELECT   IFNULL(MAX(StkTrfID),0)    FROM medc_stock.medc_stocktransfer     where     LocName=?1 and LocRefID=?2    ", nativeQuery = true)
	int viewStkTransId( Double lcrnm ,Double lcrid    );

	
	@Query(value = "  SELECT   IFNULL(RIGHT(stktrfno, 7),0)   FROM   medc_stock.medc_stocktransfer   where  StkTrfID=?3     and    LocName=?1 and LocRefID=?2  ", nativeQuery = true)
	String viewStkTransIncNo(  Double lcrnm ,Double lcrid  ,int  id   );
	
	@Query(value = "SELECT si.SalesBillNo from medc_sales.medc_salesmaintenance  si  join ( SELECT   max( SalesBillID ) as maxid FROM   medc_sales.medc_salesmaintenance  where       SalesBillType=1 and  LocName=?1 and LocRefID=?2  )  sid  on  sid.maxid=si.SalesBillID  ", nativeQuery = true)
	String  viewStkTransMaxNo(Double lcrnm, Double lcrid);
	
	
	

}


