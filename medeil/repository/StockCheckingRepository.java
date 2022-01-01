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
public interface StockCheckingRepository extends JpaRepository<Branch, Serializable>{

	
	@Query(value = "SELECT cm.companyname,br.branchname,loc.locationname,concat(IFNULL(shp.shopname,''),IFNULL(whr.warehousename,''),IFNULL(hsp.hospitalname,''))AS name,pr.brandname,dm.batchno,st.qty,DATE_FORMAT(st.expirydate, '%Y-%m-%d') "
			+ "as exp FROM medc_stock.medc_mainstock  st left join  medc_productmaster.medc_custproductmaster pr  on st.drugproductid=pr.productdrugid left join medc_companyreg.medc_companyinfomation cm on cm.companyid=st.companyrefid "
			+ "left join medc_branchreg.medc_branchinfomation br on br.branchid=st.branchrefid left join medc_adminsecurity.medc_locationref loc on loc.id=st.locname left join medc_storereg.medc_shopinformation shp on shp.shopid=st.locrefid "
			+ "and loc.id=st.locname left join medc_warehousereg.medc_warehouseinfo whr on whr.warehouseid=st.locrefid and loc.id=st.locname left join medc_hospitalreg.hospitalregistration hsp on hsp.hospitalid=st.locrefid  and loc.id=st.locname "
			+ "left join medc_stock.medc_drugbatch dm ON dm.batchid=st.batchno", nativeQuery = true)
	 List superAdminStockInfo();
	
	
	//Raja 
	@Query(value = "SELECT cm.companyname,br.branchname,loc.locatiONname,CONCAT(IFNULL(shp.shopname,''),IFNULL(whr.warehousename,''),IFNULL(hsp.hospitalname,''))AS name,pr.brANDname,\r\n" + 
			"dm.batchno,st.qty,DATE_FORMAT(st.expirydate, '%Y-%m-%d') AS exp ,st.drugproductid FROM medc_stock.medc_mainstock  st\r\n" + 
			"LEFT JOIN  medc_productmASter.medc_custproductmASter pr  ON st.drugproductid=pr.productdrugid\r\n" + 
			"LEFT JOIN medc_companyreg.medc_companyinfomatiON cm ON cm.companyid=st.companyrefid\r\n" + 
			"LEFT JOIN medc_branchreg.medc_branchinfomatiON br ON br.branchid=st.branchrefid\r\n" + 
			"LEFT JOIN medc_adminsecurity.medc_locatiONref loc ON loc.id=st.locname\r\n" + 
			"LEFT JOIN medc_storereg.medc_shopinformatiON shp ON shp.shopid=st.locrefid AND loc.id=st.locname\r\n" + 
			"LEFT JOIN medc_warehousereg.medc_warehouseinfo whr ON whr.warehouseid=st.locrefid AND loc.id=st.locname\r\n" + 
			"LEFT JOIN medc_hospitalreg.hospitalregistratiON hsp ON hsp.hospitalid=st.locrefid  AND loc.id=st.locname\r\n" + 
			"LEFT JOIN medc_stock.medc_drugbatch dm ON dm.batchid=st.batchno\r\n" + 
			"WHERE st.companyrefid=:compid  AND st.branchrefid=:brnchid AND st.locrefid=:locrefid AND st.locname=:locname AND st.qty >= -10", nativeQuery = true)
	 List getStockInfo(@Param("compid") int compid,@Param("brnchid") int brnchid,@Param("locname") int locname,@Param("locrefid") int locrefid);
	

	@Query(value ="SELECT sp.id as priceupdateid,sp.createddate,sp.drugproductid,sp.brandname,sp.batchno,sp.expirydate, sp.mrp,sp.purchaseprice,sp.sellingprice,sp.manufacturer FROM emed_dummy.emed_stockpricing sp order by priceupdateid desc", nativeQuery = true)
	List getpriceupdatestock();
}
