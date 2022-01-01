









package com.medeil.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.medeil.domain.StockReceive;

public interface StkRecRepository extends JpaRepository<StockReceive, Long> {

	StockReceive save(StockReceive stk);

	@Query(value = " SELECT  IFNULL( max(StkRecID) ,0)   FROM   medc_stock.medc_stockreceive       where  LocName=?1 and LocRefID=?2 ", nativeQuery = true)
	Double viewStockReceiveId(   Double lcrnm ,Double lcrid   );
	
	@Query(value = " SELECT  IFNULL( max(StkRecID) ,0)   FROM   medc_stock.medc_stockreceive       where  LocName=?1 and LocRefID=?2 ", nativeQuery = true)
	Integer viewStockReceiveIdInt(   Double lcrnm ,Double lcrid   );
	
	
	@Query(value = "   SELECT   IFNULL(RIGHT(stkrecno, 7),0)   FROM   medc_stock.medc_stockreceive   where   StkRecID=?3   and    LocName=?1 and LocRefID=?2   ", nativeQuery = true)
	String viewStockReceiveIncNo(    Double lcrnm ,Double lcrid  , Double id );

	
	@Query(value = "  SELECT si.stkrecno from  medc_stock.medc_stockreceive  si  join ( SELECT  IFNULL( max(StkRecID) ,0)  as maxid FROM   medc_stock.medc_stockreceive  where         LocName=?1 and LocRefID=?2  )  sid  on  sid.maxid=si.StkRecID   ", nativeQuery = true)
	String  viewStockReceiveMaxNo(Double lcrnm, Double lcrid);
	
}




















