package com.medeil.controller;

/*************************************************************************
 * 
 * Vanuston CONFIDENTIAL
 * __________________
 * 
 *  [2009] - [2019] Vanuston Intelligence Pvt.Ltd  
 *  All Rights Reserved.
 * 
 * NOTICE:  All information contained herein is, and remains
 * the property of Vanuston Intelligence Pvt.Ltd and its suppliers,
 * if any.  The intellectual and technical concepts contained
 * herein are proprietary to Vanuston Intelligence Pvt.Ltd
 * and its suppliers and may be covered by Indian and Foreign Patents,
 * patents in process, and are protected by trade secret or copyright law.
 * Dissemination of this information or reproduction of this material
 * is strictly forbidden unless prior written permission is obtained
 * from Vanuston Intelligence Pvt.Ltd.
 */

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.medeil.domain.Warehouse;
import com.medeil.service.WarehouseServices;

@SuppressWarnings("rawtypes")
@RestController
@RequestMapping("/api")
public class WarehouseController {

	@Autowired
	WarehouseServices warehouseservice;

	@GetMapping(value = "/geteditState1/{id}")
	public List compeditState(@PathVariable Integer id) throws Exception {
		return warehouseservice.editState(id);
	}

	@GetMapping(value = "/geteditCity1/{id}")
	public List compeditCity(@PathVariable Integer id) throws Exception {
		return warehouseservice.compeditCity(id);
	}

	// get
	@GetMapping(value = "/warehouseget", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Warehouse> getAll() throws Exception {

		return warehouseservice.getAll();
	}

	// post
	@PostMapping(value = "/postwarehouse")
	public Warehouse postWarehouse(@RequestBody Warehouse warehouse) throws Exception {
		System.out.println("inside controller");
		warehouseservice.postWarehouse(warehouse);
		return warehouse;
	}

	@ResponseBody
	@RequestMapping(value = "/savewarehouse", method = RequestMethod.POST)
	public boolean savewarehouse(@RequestBody Warehouse warehouse) throws Exception {
		boolean flag = false;
		// try {

		warehouseservice.savewarehous(warehouse);
		flag = true;

		// } catch (Exception e) throws Exception {
		// e.printStackTrace();
		// }

		return flag;
	}

	// access from Product table
	@GetMapping(value = "/accessbyid/{id}")
	public int accessid(@PathVariable long id) throws Exception {

		return warehouseservice.accessid(id);

	}

	// update
	@PutMapping(value = "/warehouseget/{id}")
	public Warehouse updateWarehouse(@RequestBody Warehouse warehouse, @PathVariable long id) throws Exception {

		return warehouseservice.postWarehouse(warehouse);
	}

	// Delete
	@DeleteMapping(value = "/warehouseget/{id}")
	public void deleteWarehouse(@PathVariable long id) throws Exception { // check

		warehouseservice.deleteWarehouse(id);
	}

	// get country
	@GetMapping(value = "/countrywarehouse", produces = MediaType.APPLICATION_JSON_VALUE)
	public List country() throws Exception {

		return warehouseservice.country();

	}

	// get state
	@GetMapping(value = "/statewarehouse/{id}")
	public List State(@PathVariable long id) throws Exception {

		return warehouseservice.State(id);

	}

	// get city
	@GetMapping(value = "/citywarehouse/{id}")
	public List city(@PathVariable long id) throws Exception {

		return warehouseservice.city(id);

	}

	@PostMapping(value = "/viewWarehouse")
	public List viewWarehouse(@RequestBody Warehouse warehouse) throws Exception {

		return warehouseservice.viewwarehouse(warehouse);
	}

	@GetMapping(value = "/editvalware/{id}/{cid}/{bid}/{locname}/{locrefid}")
	public List editWarehouse(@PathVariable Integer id, @PathVariable Integer cid, @PathVariable Integer bid,
			@PathVariable Integer locname, @PathVariable Integer locrefid) throws Exception {
		return warehouseservice.editWarehouse(id, cid, bid, locname, locrefid);

	}

}