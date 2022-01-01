
package com.medeil.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.medeil.domain.GateProduct;

public interface GatePassProductRepository extends JpaRepository<GateProduct, Long> {

	GateProduct save(GateProduct ip);

	@Query(value = " SELECT   ip. indentprdid ,  ip. indentrefid,  ip. drugprdrefid,  ip. boxqty,ip. stripqty,       ip. tabqty, ip.  qty ,ip. boxconvdrg ,ip.stripconvdrg ,ip.MinQty ,       ip.MaxQty ,cp.brandname   ,ip.ClientCDate1  as  cldate     FROM medc_indentmaster.medc_indentproduct ip    left	join   (SELECT BrandName,ProductDrugID   from  medc_productmaster.medc_custproductmaster  where   ((LocName=?1 and  LocRefID=?2) || (companyID=?4)))   cp  on  cp.ProductDrugID=ip.drugprdrefid   where  ip. indentrefid=?3    and   ip. LocName=?1 and  ip.LocRefID=?2  and ip.Status!=5 ", nativeQuery = true)
	List viewIndentProduct(int lcrnm, int lcrid, int ip ,int  compid);

}











