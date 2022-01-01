


















package com.medeil.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.medeil.domain.SDProducts;



@Repository
public interface SDProductsRepository extends JpaRepository<SDProducts, Long> {

	SDProducts save(  SDProducts cust  );

	@Query(  value = "SELECT   pm.BrandName, sd. salesprdtid, sd. salesrefid, sd. drugproductid,  sd. batchrefid,      sd. totalqty,sd. totalfreeqty, sd. unitprice, sd. mrp,  sd. expirydate,      sd. unitdiscount, sd. unitvat, sd. unitsgst, sd. unitcgst, sd. unitigst,      sd. discountamt, sd. vatamt, sd. sgstamt, sd. cgstamt, sd. igstamt,      sd. subtotal  ,sd.drgtyp  ,sd.gstflag  ,sd.frgstflag  ,sd.freeflag       ,sd.priceflag  ,sd.discautoflag ,sd.indvqty ,sd.indvfreeqty,sd.convfactor       ,sd.ClientCDate1  as  cldate     FROM medc_sales.medc_salesbill sd    left join  (  SELECT BrandName,ProductDrugID   from  medc_productmaster.medc_custproductmaster  where   ((LocName=?1 and  LocRefID=?2) || (companyID=?4))  )  pm  on  pm.ProductDrugID=sd.drugproductid    where   sd.SalesRefID=?3    and  sd.Status!=5  ", nativeQuery = true  )
	List viewSDProducts( int lcrnm ,int lcrid  ,     int name ,Integer  compid );

}




















