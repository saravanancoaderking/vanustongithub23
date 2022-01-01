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

import com.medeil.domain.GatePass;
import com.medeil.domain.GateProduct;
import com.medeil.domain.IndCompModel;
import com.medeil.service.GatePassService;

@SuppressWarnings("rawtypes")
@RestController
@RequestMapping("/api")
public class GatePassController {

	@Autowired
	GatePassService gatePassService;

	private final Logger log = LoggerFactory.getLogger(IndtReqController.class);

	@GetMapping(value = "/getproductquantity/{id}")
	public List getQuantity(@PathVariable Integer id) throws Exception {
		return gatePassService.getQuantity(id);
	}

	@GetMapping(value = "/getGatePassAutoIncrements/{compid}/{branchid}/{locname}/{locrefid}")
	public List getAutoIncrments(@PathVariable Integer compid, @PathVariable Integer branchid,
			@PathVariable Integer locname, @PathVariable Integer locrefid) throws Exception {
		return gatePassService.getGatePassAutoincrement(compid, branchid, locname, locrefid);
	}

	@GetMapping(value = "getgatepassShopUrl/{compid}/{locname}")
	public List getDeliveryShop(@PathVariable Integer compid, @PathVariable Integer locname) throws Exception {
		return gatePassService.getGatePassShop(compid, locname);
	}

	@GetMapping(value = "/getgatepassadminstockno/{searchValue}")
	public List getSuperAdminStockNO(@PathVariable String searchValue) throws Exception {
		return gatePassService.getSuperAdminStockNO(searchValue);
	}

	@GetMapping(value = "/getgatepassstockno/{searchValue}/{compid}/{brnchid}/{loc}/{locref}")
	public List getStockNO(@PathVariable String searchValue, @PathVariable Integer compid,
			@PathVariable Integer brnchid, @PathVariable Integer loc, @PathVariable Integer locref) throws Exception {
		return gatePassService.getStockNO(searchValue, compid, brnchid, loc, locref);
	}

	@GetMapping(value = "/getsupergatepassproduct/{searchValue}")
	public List getSuperAdminStockProduct(@PathVariable String searchValue) throws Exception {
		return gatePassService.getSuperAdminStockProduct(searchValue);
	}

	@GetMapping(value = "/getgatepassstockproduct/{searchValue}/{compid}/{brnchid}/{loc}/{locref}")
	public List getStockOProduct(@PathVariable String searchValue, @PathVariable Integer compid,
			@PathVariable Integer brnchid, @PathVariable Integer loc, @PathVariable Integer locref) throws Exception {
		return gatePassService.getStockProduct(searchValue, compid, brnchid, loc, locref);
	}

	@PostMapping(value = "/savegatepass")
	public Boolean saveGatePass(@RequestBody GatePass dc) throws Exception {

		return gatePassService.saveGatePass(dc);
	}

	@GetMapping(value = "/getGateStockTranferNO")
	public List getStockTransNO() throws Exception {
		return gatePassService.getStockTransferNO();
	}

	@GetMapping(value = "/getGateStockTranferProduct")
	public List getStockTransProduct() throws Exception {
		return gatePassService.getStockTransProduct();
	}

	@PostMapping(value = "/savegatepassproduct")
	public Boolean saveGatePassProducts(@RequestBody List<GateProduct> dp) throws Exception {
		System.out.println("SaveProducts");
		return gatePassService.saveGatePassProducts(dp);
	}

	@PostMapping(value = "/updateGatePass")
	public int updateDeliveryChallan(@RequestBody GatePass dc) throws Exception {
		return gatePassService.updateDeliveryChallan(dc);
	}

	@PostMapping(value = "/updateGatePassProducts")
	public int updateDeliveryProducts(@RequestBody List<GateProduct> ip) throws Exception {
		return gatePassService.updateDeliveryProducts(ip);
	}

	/*
	 * @PostMapping("/viewIndentRequests") public List
	 * viewIndentRequests(@RequestBody IndCompModel loc) throws Exception { return
	 * gatePassService.viewIndentRequests(loc); }
	 * 
	 * 
	 * @PostMapping("/viewshopinformation") public List
	 * viewshopinformation(@RequestBody IndCompModel loc) throws Exception { return
	 * gatePassService.viewshopinformation(loc); }
	 * 
	 * @PostMapping("/viewWareHouse") public List viewWareHouse(@RequestBody
	 * IndCompModel loc) throws Exception { return
	 * gatePassService.viewWareHouse(loc); }
	 * 
	 * @PostMapping("/viewGatePassHospital") public List viewHospital(@RequestBody
	 * IndCompModel loc) throws Exception { return
	 * gatePassService.viewHospital(loc); }
	 */

	@GetMapping(value = "/viewgatepasses/{compid}/{branchid}/{locname}/{locrefid}/{billtyperefid}")
	public List viewIndentRequestsAll(@PathVariable Integer compid, @PathVariable Integer branchid,
			@PathVariable Integer locname, @PathVariable Integer locrefid, @PathVariable Integer billtyperefid)
			throws Exception {
		System.out.println("inside gatpass ");
		return gatePassService.viewGatePass(compid, branchid, locname, locrefid, billtyperefid);
	}

	/*
	 * @PostMapping("/viewIrqStkMinQtyAll") public List
	 * viewStkMinQtyAll(@RequestBody IndCompModel loc) throws Exception { return
	 * gatePassService.viewStkMinQtyAll(loc); }
	 * 
	 * 
	 * @PostMapping("/viewIrqStkMinQty") public List viewStkMinQty(@RequestBody
	 * IndCompModel loc) throws Exception { return
	 * gatePassService.viewStkMinQty(loc); }
	 */

	@RequestMapping("/deleteGatePass")
	public int deleteIndReq(@RequestBody IndCompModel loc) throws Exception {
		return gatePassService.deleteIndReq(loc);
	}

	// padmini
	@GetMapping(value = "/getGatePassNo/{searchValue}/{compid}/{branchid}/{locname}/{locrefid}/{billtyperefid}")
	public List getGatePassNo(@PathVariable String searchValue, @PathVariable Integer compid,
			@PathVariable Integer branchid, @PathVariable Integer locname, @PathVariable Integer locrefid,
			@PathVariable Integer billtyperefid) throws Exception {
		return gatePassService.getGatePassNo(searchValue, compid, branchid, locname, locrefid, billtyperefid);
	}

	@GetMapping(value = "/getGatePassProduct/{dcid}/{compid}/{branchid}/{locname}/{locrefid}")
	public List getGatePassProduct(@PathVariable Integer dcid, @PathVariable Integer compid,
			@PathVariable Integer branchid, @PathVariable Integer locname, @PathVariable Integer locrefid)
			throws Exception {
		return gatePassService.getGatePassProduct(dcid, compid, branchid, locname, locrefid);
	}

	// Raja
	@GetMapping(value = "/getdelchallno/{dcid}")
	public List getdcid(@PathVariable Integer dcid) throws Exception {

		System.out.println("Raja");
		return gatePassService.getdelchal(dcid);
	}

	@GetMapping(value = "/getcustnames/{dcid}")
	public List getcustnames(@PathVariable Integer dcid) throws Exception {
		return gatePassService.getcustomerdetail(dcid);
	}

}
