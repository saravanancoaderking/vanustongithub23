/**
 * 
 */
package com.medeil.repository;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.medeil.domain.Branch;



/**
 * @author Manikandan
 *
 */
@SuppressWarnings("rawtypes")
@Repository
public interface StandLoneRepository extends JpaRepository<Branch, Serializable>{

	
	@Query(value = "SELECT cm.companyname,br.branchname,loc.locationname,concat(IFNULL(shp.shopname,''))AS name,po.pur_order_no,po.pur_order_date,pr.brandname,po.qty FROM syn_table.purchase_order  po  left join  medc_productmaster.medc_custproductmaster pr  on po.item_code=pr.productdrugid left join medc_companyreg.medc_companyinfomation cm on cm.companyid=po.comp_id left join medc_branchreg.medc_branchinfomation br on br.branchid=po.branch_id   left join medc_adminsecurity.medc_locationref loc on loc.id='1' left join medc_storereg.medc_shopinformation shp on shp.shopid=po.shop_id", nativeQuery = true)
	 List SuperAdminView();
	
	
	
	@Query(value = "SELECT cm.companyname,br.branchname,loc.locationname,concat(IFNULL(shp.shopname,''))AS name,po.pur_order_no,po.pur_order_date,pr.brandname,po.qty FROM syn_table.purchase_order  po  left join  medc_productmaster.medc_custproductmaster pr  on po.item_code=pr.productdrugid left join medc_companyreg.medc_companyinfomation cm on cm.companyid=po.comp_id left join medc_branchreg.medc_branchinfomation br on br.branchid=po.branch_id   left join medc_adminsecurity.medc_locationref loc on loc.id='1' left join medc_storereg.medc_shopinformation shp on shp.shopid=po.shop_id where po.comp_id=:compid  and po.branch_id=:brnchid and po.shop_id=:locrefid", nativeQuery = true)
	 List View(@Param("compid") int compid,@Param("brnchid") int brnchid,@Param("locrefid") int locrefid);
	
}
