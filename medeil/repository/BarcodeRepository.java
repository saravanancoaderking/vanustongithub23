package com.medeil.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.medeil.domain.Barcode;


@SuppressWarnings("rawtypes")
public interface BarcodeRepository extends JpaRepository<Barcode, Long> {

	
	@Query(value= "SELECT drugProductid  FROM medc_productmaster.medc_barcodemapping where barcode=:barcode limit 1",nativeQuery =true)
	List getBarcode(@Param("barcode") String barcode);
	
	@Query(value= "SELECT productDrugID,BrandName FROM medc_productmaster.medc_custproductmaster WHERE brandname like :str%", nativeQuery = true)
	List getSuperProduct(@Param("str") String str);
	
	//Boopalan 300719
	@Query(value= "SELECT productDrugID,CONCAT(BrandName, '_', GenericNameDosage) as BrandNames FROM medc_productmaster.medc_custproductmaster WHERE brandname like :str% and companyID= :compid", nativeQuery = true)
	List getProduct(@Param("str") String str,@Param("compid") int compid);
	
	@Query(value= "SELECT  pro.productdrugid,pro.brandname,barcode,cmp.companyname,brn.branchname,loc.locationname,concat(IFNULL(shp.shopname,''),"
			+ "IFNULL(whr.warehousename,''),IFNULL(hsp.hospitalname,''))AS name   from medc_productmaster.medc_barcodemapping  bar "
			+ "left join medc_productmaster.medc_custproductmaster  pro on bar.drugproductid=pro.productdrugid  "
			+ "left join medc_adminsecurity.medc_locationref loc on loc.id=bar.locname "
			+ "left join medc_storereg.medc_shopinformation shp on shp.shopid=bar.locrefid "
			+ "and bar.locname='1' left join medc_warehousereg.medc_warehouseinfo "
			+ "whr on whr.warehouseid=bar.locrefid and bar.locname='2'  left join "
			+ "medc_hospitalreg.hospitalregistration hsp on hsp.hospitalid=bar.locrefid and bar.locname='3' "
			+ "left join medc_companyreg.medc_companyinfomation cmp on cmp.companyid=bar.companyrefid   "
			+ "left join medc_branchreg.medc_branchinfomation brn on brn.branchid=bar.branchrefid", nativeQuery = true)
	List getSuperViewBarcodeProduct();
	
	@Query(value= "SELECT  pro.productdrugid,pro.brandname,barcode,cmp.companyname,brn.branchname,loc.locationname,concat(IFNULL(shp.shopname,''),"
			+ "IFNULL(whr.warehousename,''),IFNULL(hsp.hospitalname,''))AS name   from medc_productmaster.medc_barcodemapping  bar "
			+ "left join medc_productmaster.medc_custproductmaster  pro on bar.drugproductid=pro.productdrugid  "
			+ "left join medc_adminsecurity.medc_locationref loc on loc.id=bar.locname "
			+ "left join medc_storereg.medc_shopinformation shp on shp.shopid=bar.locrefid "
			+ "and bar.locname='1' left join medc_warehousereg.medc_warehouseinfo "
			+ "whr on whr.warehouseid=bar.locrefid and bar.locname='2'  left join "
			+ "medc_hospitalreg.hospitalregistration hsp on hsp.hospitalid=bar.locrefid and bar.locname='3' "
			+ "left join medc_companyreg.medc_companyinfomation cmp on cmp.companyid=bar.companyrefid   "
			+ "left join medc_branchreg.medc_branchinfomation brn on brn.branchid=bar.branchrefid"
			+ " WHERE bar.companyrefid=:compid order by bar.barcodeid desc", nativeQuery = true)
	List getViewBarcodeProduct(@Param("compid") int compid);
	
	@Query(value = "SELECT m.productid, m.productname, c.countryname,m.productcode,m.status FROM medc_adminsecurity.medc_cproductmaster m, medc_fixedsettings.medc_country c where m.countryid = c.countryid", nativeQuery = true)
	List Productlist();
	
	@Query(value = "SELECT COUNT(ProductName) FROM medc_adminsecurity.medc_cproductmaster WHERE CountryID=:cid AND ProductName=:pname", nativeQuery = true)
	Integer isProductExist(@Param("cid") int cid,@Param("pname") String pname);
	
	//puthiran viewstocksearchitem
	@Query(value = "SELECT st.StockID,st.DrugProductID,pm.BrandName,st.mrp,st.dosageID,sh.shopname,st.barcodelabel,st.qrcodelabel,st.qty FROM medc_stock.medc_mainstock st\r\n" + 
			"inner join medc_storereg.medc_shopinformation sh on sh.ShopID=st.LocRefID\r\n" +
			"inner join medc_productmaster.medc_custproductmaster pm on pm.ProductDrugID=st.DrugProductID\r\n" +
			"WHERE st.Status=0 and st.CompanyRefID=?1 and st.branchrefid =?2 and st.LocName=?3 and st.LocRefID=?4\r\n" + 
			"and st.brandname like ?5% ORDER BY st.StockID asc", nativeQuery = true)
	List searchstockitembyvalue(@Param("cid") int cid,@Param("bid") int bid,@Param("locname") int locname,@Param("locrefid") int locrefid,@Param("searchvalue") String searchvalue);
	
	@Query(value = "SELECT st.StockID,st.DrugProductID,pm.BrandName,st.mrp,st.dosageID,sh.shopname,st.barcodelabel,st.qrcodelabel,st.qty FROM medc_stock.medc_mainstock st\r\n" + 
			"inner join medc_storereg.medc_shopinformation sh on sh.ShopID=st.LocRefID\r\n" + 
			"inner join medc_productmaster.medc_custproductmaster pm on pm.ProductDrugID=st.DrugProductID\r\n" + 
			"WHERE st.Status=0 and st.CompanyRefID=?1 and st.branchrefid =?2 and st.LocName=?3 and st.LocRefID=?4\r\n" + 
			"ORDER BY st.clientmdate desc", nativeQuery = true)
	List searchstockitemall(@Param("cid") int cid,@Param("bid") int bid,@Param("locname") int locname,@Param("locrefid") int locrefid);
	
	//date wise stock item
	@Query(value = "SELECT st.StockID,st.DrugProductID,pm.BrandName,st.mrp,st.dosageID,sh.shopname,st.barcodelabel,st.qrcodelabel FROM medc_stock.medc_mainstock st\r\n" + 
			"inner join medc_storereg.medc_shopinformation sh on sh.ShopID=st.LocRefID\r\n" +
			"inner join medc_productmaster.medc_custproductmaster pm on pm.ProductDrugID=st.DrugProductID\r\n" +
			"WHERE st.Status=0 and st.CompanyRefID=?1 and st.branchrefid =?2 and st.LocName=?3 and st.LocRefID=?4\r\n" + 
			"and DATE_FORMAT(st.createddate, '%Y-%m-%d')=?5\r\n" + 
			"ORDER BY st.StockID asc", nativeQuery = true)
	List datewisestockitem(@Param("cid") int cid,@Param("bid") int bid,@Param("locname") int locname,@Param("locrefid") int locrefid,@Param("date") String date);
	
	//puthiran Generate Stock barcode
	@Modifying
	@Transactional
	@Query(value = "UPDATE medc_stock.medc_mainstock SET clientmdate = current_timestamp, barcodeheight=:barcodeheight,barcodewidth=:barcodewidth,barcodelabel=:lable,barcodeimage=:imageInByte"
			+ " where stockid=:id", nativeQuery = true)
	void GenerateStockBarcode(@Param("barcodeheight")Integer barcodeheight,@Param("barcodewidth") Integer barcodewidth,@Param("lable") String lable,@Param("imageInByte") byte[] imageInByte,@Param("id") int id);
	
	//Stock barcodeimage view
	@Query(value = "SELECT barcodeimage from medc_stock.medc_mainstock WHERE StockID=?1", nativeQuery = true)
	byte[] getStockBarcodeImage(Integer stockid);
	
	//puthiran getsales invoice no
	@Query(value = "SELECT sm.SalesBillID, sm.SalesBillNo,sm.grandtotal,sm.customerrefid, sm.barcodelabel,sm.qrcodelabel,pi.patientfirstname FROM medc_sales.medc_salesmaintenance sm\r\n" + 
			"inner join medc_patientreg.medc_patientbasicinfo pi on pi.PatientID=sm.customerrefid\r\n" + 
			"where sm.SalesBillType=1 and sm.CompanyRefID=?1 and sm.BranchRefID=?2 and sm.LocName=?3 and sm.LocRefID=?4  and   sm.Status!=5 order  by  SalesBillID  desc", nativeQuery = true)
	List getsalesinvoiceno(int cid,int bid,int locname,int locrefid);
		
	//puthiran Generate Sales invoice barcode
	@Modifying
	@Transactional
	@Query(value = "UPDATE medc_sales.medc_salesmaintenance SET barcodeheight=:barcodeheight,barcodewidth=:barcodewidth,barcodelabel=:lable,barcodeimage=:barimg,barcodeposition=:barcodeposition"
			+ " where salesbillid=:id", nativeQuery = true)
	void GenerateSalesinvoiceBarcode(@Param("barcodeheight")Integer barcodeheight,@Param("barcodewidth") Integer barcodewidth,@Param("lable") String lable,@Param("barimg") byte[] barimg,
		@Param("id") int id, @Param("barcodeposition") Integer barcodeposition);
	
	//view sales invoice barcode image
	@Query(value = "SELECT barcodeimage from medc_sales.medc_salesmaintenance WHERE SalesBillID=?1", nativeQuery = true)
	byte[] getSalesinvBarcodeImage(Integer invoiceid);
		
	//puthiran getpurchase invoice no
	@Query(value = "SELECT pi.PIID, pi.PINO,pi.totaltaxamt,pi.vendorid,pi.barcodelabel, pi.qrcodelabel,di.distributorname FROM medc_purchase.medc_purchaseinvoice pi\r\n" + 
			"inner join medc_distributor.medc_distributorinformation di on di.DistributorID=pi.vendorid\r\n" + 
			"where pi.CompanyRefID=?1 and pi.BranchRefID=?2 and pi.LocName=?3 and pi.LocRefID=?4 order  by  PIID  desc", nativeQuery = true)
	List getpurchaseinvoiceno(int cid,int bid,int locname,int locrefid);
	
	//puthiran Generate Purchase invoice barcode
	@Modifying
	@Transactional
	@Query(value = "UPDATE medc_purchase.medc_purchaseinvoice SET barcodeheight=:barcodeheight,barcodewidth=:barcodewidth,barcodelabel=:lable,barcodeimage=:barimg,barcodeposition=:barcodeposition"
			+ " where piid=:id", nativeQuery = true)
	void GeneratePurchaseinvoiceBarcode(@Param("barcodeheight")Integer barcodeheight,@Param("barcodewidth") Integer barcodewidth,@Param("lable") String lable,@Param("barimg") byte[] barimg,
			@Param("id") int id,@Param("barcodeposition") Integer barcodeposition);
	
	//view purchase invoice barcode image
	@Query(value = "SELECT barcodeimage from medc_purchase.medc_purchaseinvoice WHERE PIID=?1", nativeQuery = true)
	byte[] getPurchaseinvBarcodeImage(Integer invoiceid);

		
	//puthiran get delivery challan no
	@Query(value = "SELECT DcID, DcNo, barcodelabel, qrcodelabel FROM medc_stock.medc_deliverchallan\r\n" + 
			"where CompanyRefID=?1 and BranchRefID=?2 and LocName=?3 and LocRefID=?4 order  by  DcID  desc", nativeQuery = true)
	List getdeliverychallanno(int cid,int bid,int locname,int locrefid);
	
	//puthiran deliverychallan barcode
	@Modifying
	@Transactional
	@Query(value = "UPDATE medc_stock.medc_deliverchallan SET barcodeheight=:barcodeheight,barcodewidth=:barcodewidth,barcodelabel=:lable,barcodeimage=:barimg,barcodeposition=:barcodeposition"
			+ " where DcID=:id", nativeQuery = true)
	void GenerateDeliverchallanBarcode(@Param("barcodeheight")Integer barcodeheight,@Param("barcodewidth") Integer barcodewidth,@Param("lable") String lable,@Param("barimg") byte[] barimg,
		@Param("id") int id,@Param("barcodeposition") Integer barcodeposition);
	
	//view deliverychallan barcode image
	@Query(value = "SELECT barcodeimage from medc_stock.medc_deliverchallan WHERE DcID=?1", nativeQuery = true)
	byte[] getDeliveryChallanBarcodeImage(Integer invoiceid);
	
	//puthiran get gatepass no
	@Query(value = "SELECT GpID, GpNo, barcodelabel, qrcodelabel FROM medc_stock.medc_gatepass\r\n" + 
			"where CompanyRefID=?1 and BranchRefID=?2 and LocName=?3 and LocRefID=?4 order  by  GpID  desc", nativeQuery = true)
	List getgatepassno(int cid,int bid,int locname,int locrefid);
	
	//puthiran gatepass barcode
	@Modifying
	@Transactional
	@Query(value = "UPDATE medc_stock.medc_gatepass SET barcodeheight=:barcodeheight,barcodewidth=:barcodewidth,barcodelabel=:lable,barcodeimage=:barimg,barcodeposition=:barcodeposition"
			+ " where GpID=:id", nativeQuery = true)
	void GenerateGatePassBarcode(@Param("barcodeheight")Integer barcodeheight,@Param("barcodewidth") Integer barcodewidth,@Param("lable") String lable,@Param("barimg") byte[] barimg,
		@Param("id") int id,@Param("barcodeposition") Integer barcodeposition);
	
	//view gatepass barcode image
	@Query(value = "SELECT barcodeimage from medc_stock.medc_gatepass WHERE GpID=?1", nativeQuery = true)
	byte[] getGatePassBarcodeImageView(Integer invoiceid);
	
	//get barcode distributors
	@Query(value = "SELECT DistributorID,DistributorName from medc_distributor.medc_distributorinformation WHERE companyrefid=?1 and branchrefid=?2 and locname=?3 and locrefid=?4 and status=0", nativeQuery = true)
	List getbarcodeDistributors(int cid, int bid, int locname, int locrefid);

	//puthiran get Distributor wise purchase invoice
	@Query(value = "SELECT pi.PIID, pi.PINO, pi.barcodelabel, pi.barcodeheight, pi.barcodewidth FROM medc_purchase.medc_purchaseinvoice pi\r\n" + 
			"where pi.CompanyRefID=?1 and pi.BranchRefID=?2 and pi.LocName=?3 and pi.LocRefID=?4 and pi.vendorid=?5 order  by  PIID  desc", nativeQuery = true)
	List getdistributorpurchaseinvoice(int cid, int bid, int locname, int locrefid, int distributorid);

	//puthiran get Distributor wise purchase invoice Products
	@Query(value = "SELECT pi.PIProductID, pi.DrugProductRefID, pm.BrandName, pi.PIRefID, pi.TotalQuantity FROM medc_purchase.medc_piproduct pi\r\n" + 
			"inner join medc_productmaster.medc_custproductmaster  pm on pi.drugproductrefid=pm.productdrugid\r\n" + 
			"where pi.PIRefID=?1 order  by  PIProductID  desc", nativeQuery = true)
	List getdistributorpurchaseinvoiceproducts(int purchaseinvocieid);
	
	//generate barcode for purchase products
	@Modifying
	@Transactional
	@Query(value = "UPDATE medc_purchase.medc_piproduct SET barcodeheight=:barcodeheight,barcodewidth=:barcodewidth,barcodelabel=:lable,barcodeimage=:barimg"
			+ " where PIProductID=:id", nativeQuery = true)
	void GenerateDistPurchaseProductBarcode(Integer barcodeheight, Integer barcodewidth, String lable, byte[] barimg, Integer id);
	
	//view Purchase product barcode image
	@Query(value = "SELECT barcodeimage from medc_purchase.medc_piproduct WHERE PIProductID=?1", nativeQuery = true)
	byte[] getPurchaseProductBarcodeImageView(Integer invoiceproductid);
	
	//puthiran get purchas eorder no
	@Query(value = "SELECT POID, PONo, barcodelabel, qrcodelabel FROM medc_purchase.medc_purchaseorder\r\n" + 
			"where CompanyRefID=?1 and BranchRefID=?2 and LocName=?3 and LocRefID=?4 order  by  POID  desc", nativeQuery = true)
	List getbarpurchaseorderdetails(int cid,int bid,int locname,int locrefid);
	
	//generate barcode for purchase orders
	@Modifying
	@Transactional
	@Query(value = "UPDATE medc_purchase.medc_purchaseorder SET barcodeheight=:barcodeheight,barcodewidth=:barcodewidth,barcodelabel=:lable,barcodeimage=:barimg"
			+ " where POID=:id", nativeQuery = true)
	void GeneratePurchseOrderBarcode(Integer barcodeheight, Integer barcodewidth, String lable, byte[] barimg, Integer id);
	
	//view Purchase Order barcode image
	@Query(value = "SELECT barcodeimage from medc_purchase.medc_purchaseorder WHERE POID=?1", nativeQuery = true)
	byte[] getPurchaseOrderBarcodeImageView(Integer invoiceid);
	
	//puthiran get sales order no
	@Query(value = "SELECT OrderID, SalesOrderNo, barcodelabel, qrcodelabel FROM medc_sales.medc_salesorder\r\n" + 
			"where CompanyRefID=?1 and BranchRefID=?2 and LocName=?3 and LocRefID=?4 order  by  OrderID  desc", nativeQuery = true)
	List getbarsalesorderdetails(int cid,int bid,int locname,int locrefid);
	
	//generate barcode for sales Orders
	@Modifying
	@Transactional
	@Query(value = "UPDATE medc_sales.medc_salesorder SET barcodeheight=:barcodeheight,barcodewidth=:barcodewidth,barcodelabel=:lable,barcodeimage=:barimg"
			+ " where OrderID=:id", nativeQuery = true)
	void GenerateSalesOrderBarcode(Integer barcodeheight, Integer barcodewidth, String lable, byte[] barimg, Integer id);
	
	//view Sales Order barcode image
	@Query(value = "SELECT barcodeimage from medc_sales.medc_salesorder WHERE OrderID=?1", nativeQuery = true)
	byte[] getSalesOrderBarcodeImageView(Integer invoiceid);
	
	
}
