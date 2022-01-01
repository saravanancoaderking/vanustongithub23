package com.medeil.controller;

/**
 * @author Boopalan Alagesan
 * @date   27-08-2019
 */

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.medeil.domain.Picking;
import com.medeil.domain.PickingProduct;
import com.medeil.service.PickingService;

/**
 * CODE DESCRIPTION: THIS PICKING CONTROLLER CLASS, CREATED TO SAVE AND FETCH
 * DATAS FROM BACKEND DATABASE WITH SPRINGBOOT RESTAPI INTERACTION.
 * 
 * PREDEFINED .save() USED TO SAVE VALUES TO DATABASE.
 */

@SuppressWarnings("rawtypes")
@RestController
@RequestMapping("/api")
public class PickingController {
	@Autowired
	PickingService pickingService;

	/** METHOD FOR SAVE PICKING - MAIN TABLE **/
	@ResponseBody
	@RequestMapping(value = "/savePicking", method = RequestMethod.POST)
	public boolean savePicking(@RequestBody Picking pickingMain) throws Exception {

		return pickingService.savePicking(pickingMain);

	}

	/** METHOD FOR SAVE PICKING PRODUCTS - PRODUCTS DETAILS TABLE **/
	@ResponseBody
	@RequestMapping(value = "/savePickingProducts", method = RequestMethod.POST)
	public boolean savePickingProducts(@RequestBody List<PickingProduct> pickingMain) throws Exception {

		return pickingService.savePickingProducts(pickingMain);

	}

	/** METHOD FOR SALES ORDER NUMBER LIST **/
	@GetMapping(value = "getPLsalesorder/{cid}/{bid}/{locname}/{locrefid}")
	public List getPLsalesorder(@PathVariable Integer cid, @PathVariable Integer bid, @PathVariable Integer locname,
			@PathVariable Integer locrefid) throws Exception {
		return pickingService.getPLsalesorder(cid, bid, locname, locrefid);
	}

	/** METHOD FOR GETTING DETAILS OF SALES ORDER VALUES **/
	@GetMapping(value = "getPLSOdetails/{soid}")
	public List getPLSOdetails(@PathVariable Integer soid) throws Exception {
		return pickingService.getPLSOdetails(soid);
	}

	/** METHOD FOR GETTING LIST OF EMPLOYEES **/
	@GetMapping(value = "getPlEmpdetails/{cid}/{bid}/{locname}/{locrefid}")
	public List getPlEmpdetails(@PathVariable Integer cid, @PathVariable Integer bid, @PathVariable Integer locname,
			@PathVariable Integer locrefid) throws Exception {
		return pickingService.getPlEmpdetails(cid, bid, locname, locrefid);
	}

	/** METHOD FOR LOADING VALUES TO GRID FOR GIVEN SALES INVOICE NUMBER **/
	@GetMapping(value = "getPLSIproducts/{sid}")
	public List getPLSIproducts(@PathVariable Integer sid) throws Exception {
		return pickingService.getPLSIproducts(sid);
	}

	/** METHOD FOR LOADING VALUES ALL PICKLIST DETAILS **/
	@GetMapping(value = "getPickListAll/{cid}/{bid}/{locname}/{locrefid}")
	public List getPickListAll(@PathVariable Integer cid, @PathVariable Integer bid, @PathVariable Integer locname,
			@PathVariable Integer locrefid) throws Exception {
		return pickingService.getPickListAll(cid, bid, locname, locrefid);
	}

	@ResponseBody
	@RequestMapping(value = "/checksavePicking", method = RequestMethod.POST)
	public boolean checksavePicking(@RequestBody Picking pickingMain) throws Exception {

		return pickingService.checksavePicking(pickingMain);

	}

	@ResponseBody
	@RequestMapping(value = "/checksavePickingProducts", method = RequestMethod.POST)
	public boolean checksavePickingProducts(@RequestBody List<PickingProduct> pickingMain) throws Exception {

		return pickingService.checksavePickingProducts(pickingMain);

	}
}
