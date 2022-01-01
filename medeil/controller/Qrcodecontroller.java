package com.medeil.controller;

import java.io.IOException;
import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.medeil.domain.DeliverChallan;
import com.medeil.domain.GatePass;
import com.medeil.domain.Purchase;
import com.medeil.domain.PurchaseInvoice;
import com.medeil.domain.PurchaseOrder;
import com.medeil.domain.SalesDummy;
import com.medeil.domain.Salesorder;
import com.medeil.domain.Stocks;
import com.medeil.service.Qrcodeservice;

@SuppressWarnings("rawtypes")
@RestController
@RequestMapping("/api")
public class Qrcodecontroller {

	@Autowired
	Qrcodeservice qrcodeService;

	// generatestock barcode
	@PostMapping(value = "/GenerateStockQrcode")
	public boolean GenerateStockQrcode(@RequestBody Stocks Stocks) throws Exception {
		return qrcodeService.GenerateStockQrcode(Stocks);
	}

	// view stock qrcode image view
	@GetMapping(value = "/viewstockqrcodeimage/{stockid}")
	public Map<String, String> StockQrcodeImageView(@PathVariable Integer stockid) throws Exception {
		Map<String, String> jsonMap = new HashMap<>();
		// try {
		byte[] path = qrcodeService.getStockQrcodeImageView(stockid);
		String encodeImage = Base64.getEncoder().encodeToString(path);
		jsonMap.put("content", encodeImage);
		return jsonMap;
		// } catch (Exception e) {
		// e.printStackTrace();
		// jsonMap.put("content", "no image");
		// return jsonMap;
		// }
	}

	// generate salesinvocie qrcode
	@PostMapping(value = "/GenerateSalesinvoiceQrcode")
	public boolean GenerateSalesinvoiceQrcode(@RequestBody SalesDummy Sinvoice) throws Exception {
		return qrcodeService.GenerateSalesinvoiceQrcode(Sinvoice);
	}

	// view sales invoice barcodeimage view
	@GetMapping(value = "/viewsalesinvoiceqrcodeimage/{invoiceid}")
	public Map<String, String> SalesinvQrcodeImageView(@PathVariable Integer invoiceid) throws Exception {
		Map<String, String> jsonMap = new HashMap<>();
		// try {
		byte[] path = qrcodeService.getSalesinvQrcodeImage(invoiceid);
		String encodeImage = Base64.getEncoder().encodeToString(path);
		jsonMap.put("content", encodeImage);
		return jsonMap;
		// } catch (Exception e) {
		// e.printStackTrace();
		// jsonMap.put("content", "no image");
		// return jsonMap;
		// }
	}

	// generate purchaseinvocie qrcode
	@PostMapping(value = "/GeneratePurchaseinvoiceQrcode")
	public boolean GeneratePurchaseinvoiceQrcode(@RequestBody Purchase purchase) throws Exception {
		return qrcodeService.GeneratePurchaseinvoiceQrcode(purchase);
	}

	// view purchase invoice qrcode image
	@GetMapping(value = "/viewpurchaseinvoiceqrcodeimage/{invoiceid}")
	public Map<String, String> PurchaseinvQrcodeImageView(@PathVariable Integer invoiceid) throws Exception {
		Map<String, String> jsonMap = new HashMap<>();
		// try {
		byte[] path = qrcodeService.getPurchaseinvQrcodeImage(invoiceid);
		String encodeImage = Base64.getEncoder().encodeToString(path);
		jsonMap.put("content", encodeImage);
		return jsonMap;
		// } catch (Exception e) {
		// e.printStackTrace();
		// jsonMap.put("content", "no image");
		// return jsonMap;
		// }
	}

	// generate DeliverChallan qrcode
	@PostMapping(value = "/GenerateDeliverchallanQrcode")
	public boolean GenerateDeliverchallanQrcode(@RequestBody DeliverChallan delchallan) throws Exception {
		return qrcodeService.GenerateDeliverchallanQrcode(delchallan);
	}

	// view delivery challan qrcode image
	@GetMapping(value = "/viewdeliverychallanqrcodeimage/{invoiceid}")
	public Map<String, String> DeliveryChallanQrcodeImageView(@PathVariable Integer invoiceid) throws Exception {
		Map<String, String> jsonMap = new HashMap<>();
		// try {
		byte[] path = qrcodeService.getDeliveryChallanQrcodeImage(invoiceid);
		String encodeImage = Base64.getEncoder().encodeToString(path);
		jsonMap.put("content", encodeImage);
		return jsonMap;
		// } catch (Exception e) {
		// e.printStackTrace();
		// jsonMap.put("content", "no image");
		// return jsonMap;
		// }
	}

	// generate gatepass qrcode
	@PostMapping(value = "/GenerateGatePassQrcode")
	public boolean GenerateGatePassQrcode(@RequestBody GatePass gatepass) throws Exception {
		return qrcodeService.GenerateGatePassQrcode(gatepass);
	}

	// view Gate Pass qrcode image
	@GetMapping(value = "/viewgatepassqrcodeimage/{invoiceid}")
	public Map<String, String> GatePassQrcodeImageView(@PathVariable Integer invoiceid) throws Exception {
		Map<String, String> jsonMap = new HashMap<>();
		// try {
		byte[] path = qrcodeService.getGatePassQrcodeImageView(invoiceid);
		String encodeImage = Base64.getEncoder().encodeToString(path);
		jsonMap.put("content", encodeImage);
		return jsonMap;
		// } catch (Exception e) {
		// e.printStackTrace();
		// jsonMap.put("content", "no image");
		// return jsonMap;
		// }
	}

	// generate distributors purchase productsqrcode
	@PostMapping(value = "/GenerateDistPurchaseProductQrcode")
	public boolean GenerateDistPurchaseProductQrcode(@RequestBody PurchaseInvoice Purchaseproduct) throws Exception {
		return qrcodeService.GenerateDistPurchaseProductQrcode(Purchaseproduct);
	}

	// dist purchase product qrcode view
	@GetMapping(value = "/viewdistpurchaseproductqrcodeimage/{invoiceproductid}")
	public Map<String, String> PurchaseProductQrcodeImageView(@PathVariable Integer invoiceproductid)
			throws Exception {
		Map<String, String> jsonMap = new HashMap<>();
		// try {
		byte[] path = qrcodeService.getPurchaseProductQrcodeImageView(invoiceproductid);
		String encodeImage = Base64.getEncoder().encodeToString(path);
		jsonMap.put("content", encodeImage);
		return jsonMap;
		// } catch (Exception e) {
		// e.printStackTrace();
		// jsonMap.put("content", "no image");
		// return jsonMap;
		// }
	}

	// generate purchase order qrcode
	@PostMapping(value = "/GeneratePurchaseOrderQrcode")
	public boolean GeneratePurchaseOrderQrcode(@RequestBody PurchaseOrder purchaseorder) throws Exception {
		return qrcodeService.GeneratePurchaseOrderQrcode(purchaseorder);
	}

	// purchase order qrcode view
	@GetMapping(value = "/viewpurchaseorderqrcodeimage/{invoiceid}")
	public Map<String, String> PurchaseOrderQrcodeImageView(@PathVariable Integer invoiceid) throws Exception {
		Map<String, String> jsonMap = new HashMap<>();
		// try {
		byte[] path = qrcodeService.getPurchaseOrderQrcodeImageView(invoiceid);
		String encodeImage = Base64.getEncoder().encodeToString(path);
		jsonMap.put("content", encodeImage);
		return jsonMap;
		// } catch (Exception e) {
		// e.printStackTrace();
		// jsonMap.put("content", "no image");
		// return jsonMap;
		// }
	}

	// generate sales order qrcode
	@PostMapping(value = "/GenerateSalesOrderQrcode")
	public boolean GenerateSalesOrderQrcode(@RequestBody Salesorder salesorder) throws Exception {
		return qrcodeService.GenerateSalesOrderQrcode(salesorder);
	}

	// sales order qrcode view
	@GetMapping(value = "/viewsalesorderqrcodeimage/{invoiceid}")
	public Map<String, String> SalesOrderQrcodeImageView(@PathVariable Integer invoiceid) throws Exception {
		Map<String, String> jsonMap = new HashMap<>();
		// try {
		byte[] path = qrcodeService.getSalesOrderQrcodeImageView(invoiceid);
		String encodeImage = Base64.getEncoder().encodeToString(path);
		jsonMap.put("content", encodeImage);
		return jsonMap;
		// } catch (Exception e) {
		// e.printStackTrace();
		// jsonMap.put("content", "no image");
		// return jsonMap;
		// }
	}

}
