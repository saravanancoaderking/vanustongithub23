



package com.medeil.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


import com.medeil.domain.SDProducts;

public interface PerInvProdRepository extends
		JpaRepository<SDProducts, Long> {

	SDProducts save( SDProducts cust );

	@Query( value = " SELECT   stk.BrandName, sd. salesprdtid, sd. salesrefid, sd. drugproductid,  sd. batchrefid,  sd. totalqty,  sd. totalfreeqty , sd. unitprice , sd. mrp , sd. expirydate, sd. unitdiscount, sd. unitvat, sd. unitsgst, sd. unitcgst, sd. unitigst,sd.discountamt,  sd. vatamt, sd. sgstamt, sd. cgstamt, sd. igstamt, sd. subtotal,sd.drgtyp  ,sd.gstflag  ,sd.frgstflag  ,sd.freeflag ,sd.priceflag  ,sd.discautoflag  ,sd.indvqty ,sd.indvfreeqty,sd.convfactor ,stk.qty as  'crntstkqty'    ,CAST( sd.ClientCDate1 AS CHAR )  as  cldate       FROM medc_sales.medc_salesbill sd 	left join   (  SELECT brandname, DrugProductID ,qty ,Batchno from medc_stock.medc_mainstock    where  LocName=?1 and  LocRefID=?2  )    stk  on  stk.DrugProductID=sd.drugproductid   and stk.Batchno=sd.batchrefid   where   sd.SalesRefID=?3      and    sd.LocName=?1 and  sd.LocRefID=?2  and  sd.Status!=5  ", nativeQuery = true )
	List viewSIProducts( int lcrnm ,int lcrid  ,  int name );
	
}