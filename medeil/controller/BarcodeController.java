package com.medeil.controller;

import java.io.IOException;
import java.util.Base64;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.medeil.domain.Barcode;
import com.medeil.domain.DeliverChallan;
import com.medeil.domain.GatePass;
import com.medeil.domain.Purchase;
import com.medeil.domain.PurchaseInvoice;
import com.medeil.domain.PurchaseOrder;
import com.medeil.domain.SalesDummy;
import com.medeil.domain.Salesorder;
import com.medeil.domain.Stocks;
import com.medeil.service.BarcodeService;

@SuppressWarnings("rawtypes")
@RestController
@RequestMapping("/api")
public class BarcodeController {

	@Autowired
	BarcodeService barcodeService;

	@Transactional
	@PostMapping(value = "/savebarcode")
	public boolean saveBarcode(@RequestBody Barcode barcode) throws Exception {
		return barcodeService.saveBarcode(barcode);
	}

	@GetMapping(value = "/barcodeurl/{barcode}")
	public List getBarcode(@PathVariable String barcode) throws Exception {
		return barcodeService.getBarcode(barcode);
	}

	@GetMapping(value = "/loadsuperproduct/{searchValue}")
	public List getSuperProduct(@PathVariable String searchValue) throws Exception {
		System.out.print("values" + searchValue);
		return barcodeService.getSuperProduct(searchValue);
	}

	@GetMapping(value = "/superviewbarcodeproduct")
	public List getSuperViewBarcodeProduct() throws Exception {
		return barcodeService.getSuperViewBarcodeProduct();
	}

	@GetMapping(value = "/viewbarcodeproduct/{compid}/{branchid}/{locname}/{locrefid}")
	public List getViewBarcodeProduct(@PathVariable Integer compid, @PathVariable Integer branchid,
			@PathVariable Integer locname, @PathVariable Integer locrefid) throws Exception {
		return barcodeService.getViewBarcodeProduct(compid, branchid, locname, locrefid);
	}

	@GetMapping(value = "/loadproduct/{searchValue}/{compid}/{branchid}/{locname}/{locrefid}")
	public List getAll(@PathVariable String searchValue, @PathVariable Integer compid, @PathVariable Integer branchid,
			@PathVariable Integer locname, @PathVariable Integer locrefid) throws Exception {
		System.out.println("user");
		return barcodeService.getProduct(searchValue, compid, branchid, locname, locrefid);
	}

	/*
	 * @GetMapping(value = "/productexist/{cid}/{pname}") public boolean
	 * isProductExist(@PathVariable int cid, @PathVariable String pname) {
	 * System.out.println("cid"+cid+"\t"+pname); return
	 * barcodeService.isProductExist(cid, pname); }
	 */

	// Boopalan
//	@PostMapping(value = "/GenBarcode")
//	public List GenBarcode(@RequestBody Barcode barcode) throws Exception {
//		System.out.println(barcode.getProduct() + " " + barcode.getCompanyid() + " " + barcode.getLocrefid());
//		return barcodeService.GenBarcode(barcode);
//	}

	// puthiran get stock details 14/07/2020
	@GetMapping(value = "searchstockdata/{cid}/{bid}/{locname}/{locrefid}/{searchvalue}")
	public List searchstockproductbyvalue(@PathVariable Integer cid, @PathVariable Integer bid,
			@PathVariable Integer locname, @PathVariable Integer locrefid, @PathVariable String searchvalue)
			throws Exception {
		return barcodeService.searchstockitembyvalue(cid, bid, locname, locrefid, searchvalue);
	}

	@GetMapping(value = "searchstockdataall/{cid}/{bid}/{locname}/{locrefid}")
	public List searchstockproductall(@PathVariable Integer cid, @PathVariable Integer bid,
			@PathVariable Integer locname, @PathVariable Integer locrefid) throws Exception {
		return barcodeService.searchstockitemall(cid, bid, locname, locrefid);
	}

	// date wise search stock
	@GetMapping(value = "datewisestockdata/{cid}/{bid}/{locname}/{locrefid}/{date}")
	public List datewisestockproduct(@PathVariable Integer cid, @PathVariable Integer bid,
			@PathVariable Integer locname, @PathVariable Integer locrefid, @PathVariable String date) throws Exception {
		return barcodeService.datewisestockitem(cid, bid, locname, locrefid, date);
	}

	// generatestock barcode
	@PostMapping(value = "/GenerateStockBarcode")
	public boolean GenerateStockBarcode(@RequestBody Stocks Stocks) throws Exception {
		return barcodeService.GenerateStockBarcode(Stocks);
	}

	// view stock barcode image view
	@GetMapping(value = "/viewstockbarcodeimage/{stockid}")
	public Map<String, String> StockBarcodeImageView(@PathVariable Integer stockid) throws Exception {//IOException 
		Map<String, String> jsonMap = new HashMap<>();
		try {
			byte[] path = barcodeService.getStockBarcodeImage(stockid);
			String encodeImage = Base64.getEncoder().encodeToString(path);
			jsonMap.put("content", encodeImage);
			return jsonMap;
		} catch (Exception e) {
			e.printStackTrace();
			jsonMap.put("content", "no image");
			return jsonMap;
		}
	}

	// get salesinvoice Details
	@GetMapping(value = "viewsalesinvoiceno/{cid}/{bid}/{locname}/{locrefid}")
	public List getsalesinvoiceno(@PathVariable Integer cid, @PathVariable Integer bid, @PathVariable Integer locname,
			@PathVariable Integer locrefid) throws Exception {
		return barcodeService.getsalesinvoiceno(cid, bid, locname, locrefid);
	}

	// generate salesinvocie barcode
	@PostMapping(value = "/GenerateSalesinvoiceBarcode")
	public boolean GenerateSalesinvoiceBarcode(@RequestBody SalesDummy Sinvoice) throws Exception {
		return barcodeService.GenerateSalesinvoiceBarcode(Sinvoice);
	}

	// view sales invoice barcodeimage view
	@GetMapping(value = "/viewsalesinvoicebarcodeimage/{invoiceid}")
	public Map<String, String> SalesinvBarcodeImageView(@PathVariable Integer invoiceid) throws IOException {
		Map<String, String> jsonMap = new HashMap<>();
		try {
			byte[] path = barcodeService.getSalesinvBarcodeImage(invoiceid);
			String encodeImage = Base64.getEncoder().encodeToString(path);
			jsonMap.put("content", encodeImage);
			return jsonMap;
		} catch (Exception e) {
			e.printStackTrace();
			jsonMap.put("content", "no image");
			return jsonMap;
		}
	}

	// get purchaseinvoice Details
	@GetMapping(value = "viewpurchaseinvoiceno/{cid}/{bid}/{locname}/{locrefid}")
	public List getpurchaseinvoiceno(@PathVariable Integer cid, @PathVariable Integer bid,
			@PathVariable Integer locname, @PathVariable Integer locrefid) throws Exception {
		return barcodeService.getpurchaseinvoiceno(cid, bid, locname, locrefid);
	}

	// generate purchaseinvocie barcode
	@PostMapping(value = "/GeneratePurchaseinvoiceBarcode")
	public boolean GeneratePurchaseinvoiceBarcode(@RequestBody Purchase purchase) throws Exception {
		return barcodeService.GeneratePurchaseinvoiceBarcode(purchase);
	}

	// view purchase invoice barcode image
	@GetMapping(value = "/viewpurchaseinvoicebarcodeimage/{invoiceid}")
	public Map<String, String> PurchaseinvBarcodeImageView(@PathVariable Integer invoiceid) throws Exception {
		Map<String, String> jsonMap = new HashMap<>();
	//	try {
			byte[] path = barcodeService.getPurchaseinvBarcodeImage(invoiceid);
			String encodeImage = Base64.getEncoder().encodeToString(path);
			if(!encodeImage.isEmpty()) {
				jsonMap.put("content", encodeImage);
			}else {
				jsonMap.put("content", "no image");
			}
			return jsonMap;
	//	} catch (Exception e) {
	//		e.printStackTrace();
	//		jsonMap.put("content", "no image");
	//		return jsonMap;
	//	}
	}

	// view DeliverChallan barcode details
	@GetMapping(value = "viewdeliverychallanno/{cid}/{bid}/{locname}/{locrefid}")
	public List getdeliverychallanno(@PathVariable Integer cid, @PathVariable Integer bid,
			@PathVariable Integer locname, @PathVariable Integer locrefid) throws Exception {
		return barcodeService.getdeliverychallanno(cid, bid, locname, locrefid);
	}

	// generate deliverychallan barcode
	@PostMapping(value = "/GenerateDeliverchallanBarcode")
	public boolean GenerateDeliverchallanBarcode(@RequestBody DeliverChallan delchallan) throws Exception {
		return barcodeService.GenerateDeliverchallanBarcode(delchallan);
	}

	// view delivery challan barcode image
	@GetMapping(value = "/viewdeliverychallanbarcodeimage/{invoiceid}")
	public Map<String, String> DeliveryChallanBarcodeImageView(@PathVariable Integer invoiceid) throws Exception {
		Map<String, String> jsonMap = new HashMap<>();
		//try {
			byte[] path = barcodeService.getDeliveryChallanBarcodeImage(invoiceid);
			String encodeImage = Base64.getEncoder().encodeToString(path);
			jsonMap.put("content", encodeImage);
			if(!encodeImage.isEmpty()) {
				jsonMap.put("content", encodeImage);
			}else {
				jsonMap.put("content", "no image");
			}
			return jsonMap;
	//	} catch (Exception e) {
	//		e.printStackTrace();
	//		jsonMap.put("content", "no image");
	//		return jsonMap;
	//	}
	}

	// view gatepass no
	@GetMapping(value = "viewgatepassno/{cid}/{bid}/{locname}/{locrefid}")
	public List getgatepassno(@PathVariable Integer cid, @PathVariable Integer bid, @PathVariable Integer locname,
			@PathVariable Integer locrefid) throws Exception {
		return barcodeService.getgatepassno(cid, bid, locname, locrefid);
	}

	// generate gatepass barcode
	@PostMapping(value = "/GenerateGatePassBarcode")
	public boolean GenerateGatePassBarcode(@RequestBody GatePass gatepass) throws Exception {
		return barcodeService.GenerateGatePassBarcode(gatepass);
	}

	// view gate pass barcode image
	@GetMapping(value = "/viewgatepassbarcodeimage/{invoiceid}")
	public Map<String, String> GatePassBarcodeImageView(@PathVariable Integer invoiceid) throws Exception {
		Map<String, String> jsonMap = new HashMap<>();
	//	try {
			byte[] path = barcodeService.getGatePassBarcodeImageView(invoiceid);
			String encodeImage = Base64.getEncoder().encodeToString(path);
			jsonMap.put("content", encodeImage);
			if(!encodeImage.isEmpty()) {
				jsonMap.put("content", encodeImage);
			}else {
				jsonMap.put("content", "no image");
			}
			return jsonMap;
	//	} catch (Exception e) {
	//		e.printStackTrace();
	//		jsonMap.put("content", "no image");
	//		return jsonMap;
	//	}
	}

	// get distributors
	@GetMapping(value = "/getbarqrDistributors/{compid}/{brnchid}/{loc}/{locref}")
	public List getbarcodeDistributors(@PathVariable Integer compid, @PathVariable Integer brnchid,
			@PathVariable Integer loc, @PathVariable Integer locref) throws Exception {
		return barcodeService.getbarcodeDistributors(compid, brnchid, loc, locref);
	}

	// distributor wise purchase invocie
	@GetMapping(value = "viewdistributorpurchaseinvoice/{cid}/{bid}/{locname}/{locrefid}/{distributorid}")
	public List getdistributorpurchaseinvoice(@PathVariable Integer cid, @PathVariable Integer bid,
			@PathVariable Integer locname, @PathVariable Integer locrefid, @PathVariable Integer distributorid)
			throws Exception {
		return barcodeService.getdistributorpurchaseinvoice(cid, bid, locname, locrefid, distributorid);
	}

	// distributor wise purchase invocie Products
	@GetMapping(value = "viewdistributorpurchaseinvoiceproducts/{purchaseinvocieid}")
	public List getdistributorpurchaseinvoiceproducts(@PathVariable Integer purchaseinvocieid) throws Exception {
		return barcodeService.getdistributorpurchaseinvoiceproducts(purchaseinvocieid);
	}

	// generate distributors purchase productsbarcode
	@PostMapping(value = "/GenerateDistPurchaseProductBarcode")
	public boolean GenerateDistPurchaseProductBarcode(@RequestBody PurchaseInvoice Purchaseproduct) throws Exception {
		return barcodeService.GenerateDistPurchaseProductBarcode(Purchaseproduct);
	}

	// dist purchase product barcode view
	@GetMapping(value = "/viewdistpurchaseproductbarcodeimage/{invoiceproductid}")
	public Map<String, String> PurchaseProductBarcodeImageView(@PathVariable Integer invoiceproductid)
			throws Exception {
		Map<String, String> jsonMap = new HashMap<>();
	//	try {
			byte[] path = barcodeService.getPurchaseProductBarcodeImageView(invoiceproductid);
			String encodeImage = Base64.getEncoder().encodeToString(path);
			jsonMap.put("content", encodeImage);
			if(!encodeImage.isEmpty()) {
				jsonMap.put("content", encodeImage);
			}else {
				jsonMap.put("content", "no image");
			}
			return jsonMap;
	//		return jsonMap;
	//	} catch (Exception e) {
	//		e.printStackTrace();
	//		jsonMap.put("content", "no image");
	//		return jsonMap;
	//	}
	}

	// get Purchase Order Details
	@GetMapping(value = "viewbarpurchaseorderdetails/{cid}/{bid}/{locname}/{locrefid}")
	public List getbarpurchaseorderdetails(@PathVariable Integer cid, @PathVariable Integer bid,
			@PathVariable Integer locname, @PathVariable Integer locrefid) throws Exception {
		return barcodeService.getbarpurchaseorderdetails(cid, bid, locname, locrefid);
	}

	// generate purchase order barcode
	@PostMapping(value = "/GeneratePurchaseOrderBarcode")
	public boolean GeneratePurchaseOrderBarcode(@RequestBody PurchaseOrder purchaseorder) throws Exception {
		return barcodeService.GeneratePurchaseOrderBarcode(purchaseorder);
	}

	// purchase order barcode view
	@GetMapping(value = "/viewpurchaseorderbarcodeimage/{invoiceid}")
	public Map<String, String> PurchaseOrderBarcodeImageView(@PathVariable Integer invoiceid) throws Exception {
		Map<String, String> jsonMap = new HashMap<>();
	//	try {
			byte[] path = barcodeService.getPurchaseOrderBarcodeImageView(invoiceid);
			String encodeImage = Base64.getEncoder().encodeToString(path);
			jsonMap.put("content", encodeImage);
			if(!encodeImage.isEmpty()) {
				jsonMap.put("content", encodeImage);
			}else {
				jsonMap.put("content", "no image");
			}
			return jsonMap;
	//		return jsonMap;
	//	} catch (Exception e) {
	//		e.printStackTrace();
	//		jsonMap.put("content", "no image");
	//		return jsonMap;
	//	}
	}

	// get Sales Order Details
	@GetMapping(value = "viewbarsalesorderdetails/{cid}/{bid}/{locname}/{locrefid}")
	public List getbarsalesorderdetails(@PathVariable Integer cid, @PathVariable Integer bid,
			@PathVariable Integer locname, @PathVariable Integer locrefid) throws Exception {
		return barcodeService.getbarsalesorderdetails(cid, bid, locname, locrefid);
	}

	// generate sales order barcode
	@PostMapping(value = "/GenerateSalesOrderBarcode")
	public boolean GenerateSalesOrderBarcode(@RequestBody Salesorder salesorder) throws Exception {
		return barcodeService.GenerateSalesOrderBarcode(salesorder);
	}

	// sales order barcode view
	@GetMapping(value = "/viewsalesorderbarcodeimage/{invoiceid}")
	public Map<String, String> SalesOrderBarcodeImageView(@PathVariable Integer invoiceid) throws IOException {
		Map<String, String> jsonMap = new HashMap<>();
	//	try {
			byte[] path = barcodeService.getSalesOrderBarcodeImageView(invoiceid);
			String encodeImage = Base64.getEncoder().encodeToString(path);
			jsonMap.put("content", encodeImage);
			if(!encodeImage.isEmpty()) {
				jsonMap.put("content", encodeImage);
			}else {
				jsonMap.put("content", "no image");
			}
			return jsonMap;
	//		return jsonMap;
	//	} catch (Exception e) {
	//		e.printStackTrace();
	//		jsonMap.put("content", "no image");
	//		return jsonMap;
	//	}
	}

}
