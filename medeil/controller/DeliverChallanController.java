package com.medeil.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.medeil.domain.DeliverChallan;
import com.medeil.domain.DeliveryProduct;
import com.medeil.domain.IndCompModel;
import com.medeil.service.DeliveryChallanService;

@SuppressWarnings("rawtypes")
@RestController
@RequestMapping("/api")
public class DeliverChallanController {

	@Autowired
	DeliveryChallanService deliveryService;

	private final Logger log = LoggerFactory.getLogger(IndtReqController.class);

	// Search Number for transaction
	@GetMapping(value = "/getsuperadminstockno/{searchValue}")
	public List getSuperAdminStockNO(@PathVariable String searchValue) throws Exception {
		return deliveryService.getStranferAdminStockNO(searchValue);
	}

	@GetMapping(value = "/getsuperadminsalesno/{searchValue}")
	public List getDeliveryAdminSalesNO(@PathVariable String searchValue) throws Exception {
		return deliveryService.getDeliveryAdminSalesNO(searchValue);
	}

	@GetMapping(value = "/getsuperadminpurchaseno/{searchValue}")
	public List getDeliveryAdminPurchaseNO(@PathVariable String searchValue) throws Exception {
		return deliveryService.getDeliveryAdminPurchaseNO(searchValue);
	}

	@GetMapping(value = "/getstockno/{searchValue}/{compid}/{brnchid}/{loc}/{locref}")
	public List getStranferStockNO(@PathVariable String searchValue, @PathVariable Integer compid,
			@PathVariable Integer brnchid, @PathVariable Integer loc, @PathVariable Integer locref) throws Exception {
		return deliveryService.getStranferStockNO(searchValue, compid, brnchid, loc, locref);
	}

	@GetMapping(value = "/getsalesno/{searchValue}/{compid}/{brnchid}/{loc}/{locref}")
	public List getDeliverySalesNO(@PathVariable String searchValue, @PathVariable Integer compid,
			@PathVariable Integer brnchid, @PathVariable Integer loc, @PathVariable Integer locref) throws Exception {
		return deliveryService.getDeliverySalesNO(searchValue, compid, brnchid, loc, locref);
	}

	@GetMapping(value = "/getpurchaseno/{searchValue}/{compid}/{brnchid}/{loc}/{locref}")
	public List getDeliveryPurchaseNO(@PathVariable String searchValue, @PathVariable Integer compid,
			@PathVariable Integer brnchid, @PathVariable Integer loc, @PathVariable Integer locref) throws Exception {
		return deliveryService.getDeliveryPurchaseNO(searchValue, compid, brnchid, loc, locref);
	}

	@GetMapping(value = "/getsuperadminproduct/{searchValue}")
	public List getSuperAdminStockProduct(@PathVariable String searchValue) throws Exception {
		return deliveryService.getSuperAdminStockProduct(searchValue);
	}

	// purchase block
	@GetMapping(value = "/getsuperadminpurchaseinvoiceno/{searchValue}")
	public List getSuperPurchaseNO(@PathVariable String searchValue) throws Exception {
		return deliveryService.getDeliveryAdminPurchaseNO(searchValue);
	}

	@GetMapping(value = "/getpurchaseinvoiceno/{searchValue}/{compid}/{brnchid}/{loc}/{locref}")
	public List getPurchaseNO(@PathVariable String searchValue, @PathVariable Integer compid,
			@PathVariable Integer brnchid, @PathVariable Integer loc, @PathVariable Integer locref) throws Exception {
		return deliveryService.getDeliveryPurchaseNO(searchValue, compid, brnchid, loc, locref);
	}

	@GetMapping(value = "/getpurchaseinvoiceproduct/{searchValue}")
	public List getPurchaseInvoiceProduct(@PathVariable String searchValue) throws Exception {
		return deliveryService.getDeliveryPurchaseInvoiceProduct(searchValue);
	}
	// sales block

	@GetMapping(value = "/getsupersalesinvoiceno/{searchValue}")
	public List getSuperSalesNO(@PathVariable String searchValue) throws Exception {
		return deliveryService.getDeliveryAdminSalesNO(searchValue);
	}

	@GetMapping(value = "/getsalesinvoiceno/{searchValue}/{compid}/{brnchid}/{loc}/{locref}")
	public List getSalesNO(@PathVariable String searchValue, @PathVariable Integer compid,
			@PathVariable Integer brnchid, @PathVariable Integer loc, @PathVariable Integer locref) throws Exception {
		return deliveryService.getDeliverySalesNO(searchValue, compid, brnchid, loc, locref);
	}

	@GetMapping(value = "/getsalesinvoiceproduct/{searchValue}")
	public List getSalesInvoiceProduct(@PathVariable String searchValue) throws Exception {
		return deliveryService.getDeliverySalesInvoiceProduct(searchValue);
	}
	//

	@GetMapping(value = "/getPurquantity1/{id}")
	public List getQuantity1(@PathVariable Integer id) throws Exception {
		return deliveryService.getQuantity(id);
	}

	@GetMapping(value = "/getDelveryAutoIncrements/{compid}/{branchid}/{locname}/{locrefid}/{billtyperefid}")
	public List getAutoIncrments(@PathVariable Integer compid, @PathVariable Integer branchid,
			@PathVariable Integer locname, @PathVariable Integer locrefid, @PathVariable Integer billtyperefid)
			throws Exception {
		return deliveryService.getAutoincrement(compid, branchid, locname, locrefid, billtyperefid);
	}

	@GetMapping(value = "/getSalesDelveryAutoIncrements/{compid}/{branchid}/{locname}/{locrefid}/{billtyperefid}")
	public List getSalesSAutoIncrments(@PathVariable Integer compid, @PathVariable Integer branchid,
			@PathVariable Integer locname, @PathVariable Integer locrefid, @PathVariable Integer billtyperefid)
			throws Exception {
		return deliveryService.getSalesAutoincrement(compid, branchid, locname, locrefid, billtyperefid);
	}

	@GetMapping(value = "/getPurchaseDelveryAutoIncrements/{compid}/{branchid}/{locname}/{locrefid}/{billtyperefid}")
	public List getPurchaseAutoIncrments(@PathVariable Integer compid, @PathVariable Integer branchid,
			@PathVariable Integer locname, @PathVariable Integer locrefid, @PathVariable Integer billtyperefid)
			throws Exception {
		return deliveryService.getPurchaseAutoincrement(compid, branchid, locname, locrefid, billtyperefid);
	}

	@GetMapping(value = "getDeliveryShopUrl/{compid}/{locname}")
	public List getDeliveryShop(@PathVariable Integer compid, @PathVariable Integer locname) throws Exception {
		return deliveryService.getDeliveryShop(compid, locname);
	}

	@GetMapping(value = "/getstockproduct/{searchValue}/{compid}/{brnchid}/{loc}/{locref}")
	public List getStockOProduct(@PathVariable String searchValue, @PathVariable Integer compid,
			@PathVariable Integer brnchid, @PathVariable Integer loc, @PathVariable Integer locref) throws Exception {
		return deliveryService.getStockProduct(searchValue, compid, brnchid, loc, locref);
	}

	@PostMapping(value = "/saveDeliveryChallan")
	public Boolean saveDeliveryChallan(@RequestBody DeliverChallan dc) throws Exception {
		return deliveryService.saveDeliveryChallan(dc);
	}

	@GetMapping(value = "/getStockTranferNO")
	public List getStockTransNO() throws Exception {
		return deliveryService.getStockTransferNO();
	}

	@GetMapping(value = "/getStockTranferProduct")
	public List getStockTransProduct() throws Exception {
		return deliveryService.getStockTransProduct();
	}

	@PostMapping(value = "/saveDeliveryProducts")
	public boolean saveDeliveryProducts(@RequestBody List<DeliveryProduct> dp) throws Exception {
		System.out.println("SaveProducts");
		return deliveryService.saveDeliveryProducts(dp);
	}

	@PostMapping(value = "/updateDeliveryChallan")
	public int updateDeliveryChallan(@RequestBody DeliverChallan dc) throws Exception {
		return deliveryService.updateDeliveryChallan(dc);
	}

	@PostMapping(value = "/updateDeliveryProducts")
	public int updateDeliveryProducts(@RequestBody List<DeliveryProduct> ip) throws Exception {
		return deliveryService.updateDeliveryProducts(ip);
	}

	@PostMapping("/viewIndentRequests")
	public List viewIndentRequests(@RequestBody IndCompModel loc) throws Exception {
		return deliveryService.viewIndentRequests(loc);
	}

	@PostMapping("/viewIndentRequest")
	public List viewIndentRequest(@RequestBody IndCompModel loc) throws Exception {
		return deliveryService.viewIndentRequest(loc);
	}

	@PostMapping("/viewshopinformation")
	public List viewshopinformation(@RequestBody IndCompModel loc) throws Exception {
		return deliveryService.viewshopinformation(loc);
	}

	@PostMapping("/viewWareHouse")
	public List viewWareHouse(@RequestBody IndCompModel loc) throws Exception {
		return deliveryService.viewWareHouse(loc);
	}

	@PostMapping("/viewHospital")
	public List viewHospital(@RequestBody IndCompModel loc) throws Exception {
		return deliveryService.viewHospital(loc);
	}

	@PostMapping("/viewIrqCustProducts")
	public List viewWhCustProduct(@RequestBody IndCompModel loc) throws Exception {
		return deliveryService.viewWhCustProduct(loc);
	}

	@PostMapping("/viewIrqCustProduct")
	public List viewCustProduct(@RequestBody IndCompModel loc) throws Exception {
		return deliveryService.viewCustProduct(loc);
	}

	@PostMapping("/viewIndentProduct")
	public List viewIndentProduct(@RequestBody IndCompModel loc) throws Exception {
		return deliveryService.viewIndentProduct(loc);
	}

	@GetMapping("/viewdeliverychallan/{compid}/{branchid}/{locname}/{locrefid}")
	public List viewIndentRequestsAll(@PathVariable Integer compid, @PathVariable Integer branchid,
			@PathVariable Integer locname, @PathVariable Integer locrefid) throws Exception {
		System.out.println("calling");
		return deliveryService.viewDeliveryChalllan(compid, branchid, locname, locrefid);
	}

	@PostMapping("/viewIrqStkMinQtyAll")
	public List viewStkMinQtyAll(@RequestBody IndCompModel loc) throws Exception {
		return deliveryService.viewStkMinQtyAll(loc);
	}

	@PostMapping("/viewIrqStkMinQty")
	public List viewStkMinQty(@RequestBody IndCompModel loc) throws Exception {
		return deliveryService.viewStkMinQty(loc);
	}

	@PostMapping("/indentgetpurchaseorderno")
	public List getPuchaseOrderNO() throws Exception {
		return deliveryService.getPurchaseOrderNO();
	}

	@GetMapping(value = "/adminindentpurchaseorder/{pono}")
	public List purchaseOrder(@PathVariable String pono) throws Exception {
		System.out.println("indentrquestiscalled");
		return deliveryService.adminPurchaseOrder(pono);
	}

	@GetMapping("/indentpurchaseorder/{pono}/{compid}")
	public List purchaseOrder(@PathVariable String pono, @PathVariable Integer compid) throws Exception {
		System.out.println("indentrquestiscalled");
		return deliveryService.purchaseOrder(pono, compid);
	}

	@RequestMapping("/deleteIndReq")
	public int deleteIndReq(@RequestBody IndCompModel loc) throws Exception {
		return deliveryService.deleteIndReq(loc);
	}

	// Edit DeliveryChallan

	@GetMapping("/getEditDeliveryProduct/{compid}/{branchid}/{locname}/{locrefid}/{id}")
	public List<DeliveryProduct> EditDeliveryChallanProduct(@PathVariable Integer compid, @PathVariable Integer branchid,
			@PathVariable Integer locname, @PathVariable Integer locrefid, @PathVariable Integer id) throws Exception {
		return deliveryService.EditDeliveryChallanProduct(compid, branchid, locname, locrefid, id);
	}

	@GetMapping("/getEditDeliveryChallan/{compid}/{branchid}/{locname}/{locrefid}/{id}")
	public DeliverChallan EditDeliveryChallan(@PathVariable Integer compid, @PathVariable Integer branchid,@PathVariable Integer locname, @PathVariable Integer locrefid, @PathVariable Integer id) throws Exception {
		System.out.println("EditDelvery123");
		return deliveryService.EditDeliveryChallan(compid, branchid, locname, locrefid, id);
	}
	
	
	

	@GetMapping(value = "/geteditshopid/{id}")
	public List getEditShop(@PathVariable Integer id) throws Exception {
		return deliveryService.getEditShop(id);
	}

	@GetMapping(value = "/geteditwarehouseid/{id}")
	public List getEditWarehouse(@PathVariable Integer id) throws Exception {
		return deliveryService.getEditWarehouse(id);
	}

	@GetMapping(value = "/getedithospitalid/{id}")
	public List getEditHospital(@PathVariable Integer id) throws Exception {
		return deliveryService.getEditHospital(id);
	}

	@GetMapping(value = "/geteditstid/{id}")
	public List geteditstid(@PathVariable Integer id) throws Exception {
		return deliveryService.geteditstid(id);

	}

	// Raja GetSalesInvoiceNo

	@GetMapping(value = "/getsalesinno/{siid}")
	public List getsino(@PathVariable int siid) throws Exception {
		return deliveryService.getsidetail(siid);
	}

	// Purchase Delivery Challan
	// Raja Get Purchase Order id with Number
	@GetMapping(value = "/getpono/{comid}/{branchid}/{locname}/{locrefid}")
	public List getponumber(@PathVariable Integer comid, @PathVariable Integer branchid, @PathVariable Integer locname,
			@PathVariable Integer locrefid) throws Exception {
		return deliveryService.getpurchaseorderid(comid, branchid, locname, locrefid);
	}

	// Raja Get Distributor Id with Name
	@GetMapping(value = "/getdistname/{poid}")
	public List getdistdetails(@PathVariable Integer poid) throws Exception {
		return deliveryService.getdistributordetail(poid);
	}

	// Raja Get Po Product

	@GetMapping(value = "/getpoproduct/{poid}")
	public List getpodetails(@PathVariable Integer poid) throws Exception {
		return deliveryService.getpodata(poid);
	}

	@PostMapping(value = "/savepdc")
	public boolean savepdcform(@RequestBody DeliverChallan dchallan) throws Exception {
		return deliveryService.savepdcform(dchallan);
	}

	@PostMapping(value = "/savepdcproduct")
	public boolean savedcproduct(@RequestBody List<DeliveryProduct> dcproduct) throws Exception {
		System.out.println("SaveProducts");
		return deliveryService.saveDcproduct(dcproduct);
	}

	// View New Purchase Delivery Challan

	@GetMapping(value = "viewpdc/{comid}/{branchid}/{locname}/{locrefid}")
	public List getnpdc(@PathVariable Integer comid, @PathVariable Integer branchid, @PathVariable Integer locname,
			@PathVariable Integer locrefid) throws Exception {
		System.out.println("*****View Purchase Delivery Challan******");
		return deliveryService.viewnpdc(comid, branchid, locname, locrefid);

	}

	@GetMapping(value = "/getslinno/{comid}/{branchid}/{locname}/{locrefid}")
	public List getsinos(@PathVariable Integer comid, @PathVariable Integer branchid, @PathVariable Integer locname,
			@PathVariable Integer locrefid) throws Exception {
		return deliveryService.getsalesinno(comid, branchid, locname, locrefid);
	}

	@GetMapping(value = "/getcustname/{siid}")
	public List getcust(@PathVariable Integer siid) throws Exception {
		return deliveryService.getcustdetail(siid);
	}
	
	@GetMapping(value = "/getDcproducts/{id}")
	public List getdcProducts(@PathVariable Integer id) throws Exception {
		return deliveryService.getdcProducts(id);
	}

}
