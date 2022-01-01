package com.medeil.controller;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.medeil.domain.Product;
import com.medeil.service.ProductService;

@SuppressWarnings("rawtypes")
@RestController
@RequestMapping("/api")
public class ProductController {

	@Autowired
	ProductService service;

	@PostMapping(value = "/saveproduct")
	public ResponseEntity<Product> postProduct(@RequestBody Product product) throws Exception {
		return service.postProduct(product);
	}

	@GetMapping(value = "/product")
	public List getAll() throws Exception {
		return service.productlist();
	}

	@GetMapping(value = "/product-dropdown")
	public Set<String> productDropdown() throws Exception {
		return service.productDropdown();
	}

//	@GetMapping(value = "/productexist/{cid}/{pname}")
//	public boolean isProductExist(@PathVariable int cid, @PathVariable String pname) throws Exception {
//		System.out.println("cid" + cid + "\t" + pname);
//		return service.isProductExist(cid, pname);
//	}

	// Pharmacist Register (Schedule)
	// Raja
	@GetMapping(value = "/getschedules")
	public List getschedul() throws Exception {
		System.out.println("Schedule Testing Controller");
		return service.getprodschedule();
	}

	@GetMapping(value = "/getscheduledata/{scheduleid}/{fromdate}/{todate}/{companyid}/{locrefid}")
	public List getschdata(@PathVariable Integer scheduleid,@PathVariable String fromdate, @PathVariable String todate, @PathVariable Integer companyid, @PathVariable Integer locrefid) throws Exception {
		System.out.println("***********PharaReg Raja");
		return service.getsched(scheduleid,fromdate,todate,companyid,locrefid);
	}

	@GetMapping(value = "/getallscheduledata/{companyid}/{branchid}/{locname}/{locrefid}")
	public List getschdata(@PathVariable Integer companyid,@PathVariable Integer branchid,@PathVariable Integer locname, @PathVariable Integer locrefid) throws Exception {
		System.out.println("***********PharaReg Raja");
		return service.getallsched(companyid,branchid,locname,locrefid);
		
	}
	
}
