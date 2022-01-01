package com.medeil.controller;

/** **/

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.medeil.domain.Shipping;
import com.medeil.domain.ShippingDetail;
import com.medeil.service.ShippingService;

@SuppressWarnings("rawtypes")
@RestController
@RequestMapping("api/shi")
public class ShippingController {

	@Autowired
	private ShippingService shippingservice;

	@GetMapping(value = "getPackingno/{cid}/{bid}/{locid}/{locreid}")
	public List getPackingno(@PathVariable("cid") Integer cid, @PathVariable("bid") Integer bid,
			@PathVariable("locid") Integer locid, @PathVariable("locreid") Integer locreid) throws Exception {
		return shippingservice.getPackingno(cid, bid, locid, locreid);
	}

	@PostMapping(value = "gettablevalue")
	public List gettablevalue(@RequestBody Shipping shipping) throws Exception {

		return shippingservice.gettablevalue(shipping);
	}

	@PostMapping(value = "viewPack")
	public List viewPack(@RequestBody Shipping shipping) throws Exception {

		return shippingservice.viewPack(shipping);

	}

//saveShipping  saveShipping
	@ResponseBody
	@RequestMapping(value = "/saveShipping", method = RequestMethod.POST)

	public int saveShipping(@RequestBody Shipping shipping) throws Exception {

		System.out.println("inside controller");

		return shippingservice.saveShipping(shipping);
	}

	@ResponseBody
	@RequestMapping(value = "/saveShippingdetail", method = RequestMethod.POST)
	public int saveShippingdetail(@RequestBody List<ShippingDetail> sd) throws Exception {
		System.out.println("inside save pro");

		return shippingservice.saveShippingdetail(sd);

	}

	@PostMapping(value = "/viewShipp")
	public List viewShipp(@RequestBody Shipping shipping) throws Exception {

		return shippingservice.viewShipp(shipping);

	}

	@GetMapping(value = "/getemployee/{cid}/{bid}/{locid}/{locreid}")
	public List getemp(@PathVariable("cid") Integer cid, @PathVariable("bid") Integer bid,
			@PathVariable("locid") Integer locid, @PathVariable("locreid") Integer locreid) throws Exception {
		return shippingservice.getempdetail(cid, bid, locid, locreid);
	}

}
