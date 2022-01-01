package com.medeil.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.medeil.domain.Barcode;

@SuppressWarnings("rawtypes")
public interface QrcodeRepository extends JpaRepository<Barcode, Long> {
	
	//puthiran Generate Stock barcode
	@Modifying
	@Transactional
	@Query(value = "UPDATE medc_stock.medc_mainstock SET clientmdate = current_timestamp, qrcodeheight=:qrcodeheight,qrcodewidth=:qrcodewidth,qrcodelabel=:lable,qrcodeimage=:imageInByte"
			+ " where stockid=:id", nativeQuery = true)
	void GenerateStockQrcode(Integer qrcodeheight, Integer qrcodewidth, String lable, byte[] imageInByte, Integer id);
	
	//Stock qrcodeimage view
	@Query(value = "SELECT qrcodeimage from medc_stock.medc_mainstock WHERE StockID=?1", nativeQuery = true)
	byte[] getStockQrcodeImageView(Integer stockid);
	
	//puthiran Generate Sales invoice qrcode
	@Modifying
	@Transactional
	@Query(value = "UPDATE medc_sales.medc_salesmaintenance SET qrcodeheight=:qrcodeheight,qrcodewidth=:qrcodewidth,qrcodelabel=:lable,qrcodeimage=:qrimg,qrcodeposition=:qrcodeposition"
			+ " where salesbillid=:id", nativeQuery = true)
	void GenerateSalesinvoiceQrcode(Integer qrcodeheight, Integer qrcodewidth, String lable, byte[] qrimg, int id, Integer qrcodeposition);
	
	//view sales invoice barcode image
	@Query(value = "SELECT qrcodeimage from medc_sales.medc_salesmaintenance WHERE SalesBillID=?1", nativeQuery = true)
	byte[] getSalesinvQrcodeImage(Integer invoiceid);
		
	
	//puthiran Generate Purchase invoice qrcode
	@Modifying
	@Transactional
	@Query(value = "UPDATE medc_purchase.medc_purchaseinvoice SET qrcodeheight=:qrcodeheight,qrcodewidth=:qrcodewidth,qrcodelabel=:lable,qrcodeimage=:qrimg,qrcodeposition=:qrcodeposition"
			+ " where piid=:id", nativeQuery = true)
	void GeneratePurchaseinvoiceQrcode(Integer qrcodeheight, Integer qrcodewidth, String lable, byte[] qrimg, Integer id, int qrcodeposition);
	
	//view purchase invoice qrcode image
	@Query(value = "SELECT qrcodeimage from medc_purchase.medc_purchaseinvoice WHERE PIID=?1", nativeQuery = true)
	byte[] getPurchaseinvQrcodeImage(Integer invoiceid);


	//puthiran deliverychallan qrcode
	@Modifying
	@Transactional
	@Query(value = "UPDATE medc_stock.medc_deliverchallan SET qrcodeheight=:qrcodeheight,qrcodewidth=:qrcodewidth,qrcodelabel=:lable,qrcodeimage=:qrimg,qrcodeposition=:qrcodeposition"
			+ " where DcID=:id", nativeQuery = true)
	void GenerateDeliverchallanQrcode(Integer qrcodeheight, Integer qrcodewidth, String lable, byte[] qrimg, int id, int qrcodeposition);
	
	//view deliverychallan qrcode image
	@Query(value = "SELECT qrcodeimage from medc_stock.medc_deliverchallan WHERE DcID=?1", nativeQuery = true)
	byte[] getDeliveryChallanQrcodeImage(Integer invoiceid);
	
	//puthiran gatepass qrcode
	@Modifying
	@Transactional
	@Query(value = "UPDATE medc_stock.medc_gatepass SET qrcodeheight=:qrcodeheight,qrcodewidth=:qrcodewidth,qrcodelabel=:lable,qrcodeimage=:qrimg,qrcodeposition=:qrcodeposition"
			+ " where GpID=:id", nativeQuery = true)
	void GenerateGatePassQrcode(Integer qrcodeheight, Integer qrcodewidth, String lable, byte[] qrimg, int id, int qrcodeposition);
	
	//gatepass  qrcode image view
	@Query(value = "SELECT qrcodeimage from medc_stock.medc_gatepass WHERE GpID=?1", nativeQuery = true)
	byte[] getGatePassQrcodeImageView(Integer invoiceid);
	
	//generate qrcode for purchase products
	@Modifying
	@Transactional
	@Query(value = "UPDATE medc_purchase.medc_piproduct SET qrcodeheight=:qrcodeheight,qrcodewidth=:qrcodewidth,qrcodelabel=:lable,qrcodeimage=:qrimg"
			+ " where PIProductID=:id", nativeQuery = true)
	void GenerateDistPurchaseProductQrcode(Integer qrcodeheight, Integer qrcodewidth, String lable, byte[] qrimg, Integer id);
	
	//view Purchase order qrcode image
	@Query(value = "SELECT qrcodeimage from medc_purchase.medc_piproduct WHERE PIProductID=?1", nativeQuery = true)
	byte[] getPurchaseProductQrcodeImageView(Integer invoiceproductid);	
	
	//generate qrcode for purchase order
	@Modifying
	@Transactional
	@Query(value = "UPDATE medc_purchase.medc_purchaseorder SET qrcodeheight=:qrcodeheight,qrcodewidth=:qrcodewidth,qrcodelabel=:lable,qrcodeimage=:qrimg"
			+ " where POID=:id", nativeQuery = true)
	void GeneratePurchaseOrderQrcode(Integer qrcodeheight, Integer qrcodewidth, String lable, byte[] qrimg, Integer id);
	
	//view Purchase order qrcode image
	@Query(value = "SELECT qrcodeimage from medc_purchase.medc_purchaseorder WHERE POID=?1", nativeQuery = true)
	byte[] getPurchaseOrderQrcodeImageView(Integer invoicetid);	
	
	//generate qrcode for sales order
	@Modifying
	@Transactional
	@Query(value = "UPDATE medc_sales.medc_salesorder SET qrcodeheight=:qrcodeheight,qrcodewidth=:qrcodewidth,qrcodelabel=:lable,qrcodeimage=:qrimg"
			+ " where OrderID=:id", nativeQuery = true)
	void GenerateSalesOrderQrcode(Integer qrcodeheight, Integer qrcodewidth, String lable, byte[] qrimg, Integer id);
	
	//view Sales order qrcode image
	@Query(value = "SELECT qrcodeimage from medc_sales.medc_salesorder WHERE OrderID=?1", nativeQuery = true)
	byte[] getSalesOrderQrcodeImageView(Integer invoicetid);	
	

}
