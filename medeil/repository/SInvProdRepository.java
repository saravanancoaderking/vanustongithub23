



 
 package com.medeil.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.medeil.domain.SDProducts;

@Transactional
@Repository
public interface SInvProdRepository   extends JpaRepository<SDProducts, Long>{
	

	SDProducts save( SDProducts cust );

	@Query( value = "  SELECT   stk.BrandName, sd. salesprdtid, sd. salesrefid, sd. drugproductid,  sd. batchrefid,    sd. totalqty,  sd. totalfreeqty , sd. unitprice , sd. mrp , sd. expirydate,    sd. unitdiscount, sd. unitvat, sd. unitsgst, sd. unitcgst, sd. unitigst,     sd.discountamt,  sd. vatamt, sd. sgstamt, sd. cgstamt, sd. igstamt,    sd. subtotal,sd.drgtyp  ,sd.gstflag  ,sd.frgstflag  ,sd.freeflag ,    sd.priceflag  ,sd.discautoflag  ,sd.indvqty ,sd.indvfreeqty,sd.convfactor     ,stk.qty as  'crntstkqty'    ,sd.ClientCDate1  as  cldate  , sd.batchname  ,sd.stkmainrefid   FROM medc_sales.medc_salesbill sd   left join  (  SELECT brandname, DrugProductID ,qty ,Batchno,stockid from medc_stock.medc_mainstock   where  LocName=?1 and  LocRefID=?2  )   stk  on  stk.stockid=sd.stkmainrefid  	where   sd.SalesRefID=?3   and  sd.Status!=5   ", nativeQuery = true )
	List viewSIProducts(  int lcrnm ,int lcrid  ,   int name );

	@Query( value = "SELECT sb.salesprdtid,cu.brandname,sb.drugproductid,sb.indvqty,sb.unitprice,sb.subtotal FROM medc_sales.medc_salesbill sb\r\n" + 
			"left join medc_productmaster.medc_custproductmaster cu on cu.productdrugid=sb.drugproductid\r\n" + 
			"where sb.SalesRefID=?3 and sb.locname=?1 and sb.locrefid=?2", nativeQuery = true )
	List GetSIProducts(int locname, int locrefid, int frmint1);
	
}
