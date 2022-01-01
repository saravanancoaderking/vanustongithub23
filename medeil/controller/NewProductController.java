package com.medeil.controller;

/**
 * @author Mrs.Padmini
 * @author Boopalan Alagesan
 *
 */
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.medeil.domain.Drug;
import com.medeil.domain.NewProduct;
import com.medeil.domain.NewProductQty;
import com.medeil.service.NewProductService;

@RestController
@RequestMapping("api/slsinv")
public class NewProductController {

	@Autowired
	NewProductService newProductService;

	/** SALES INVOICE - NEW PRODUCT ENQUIRY **/
	// Boopalan 090719
	@ResponseBody
	@RequestMapping(value = "/savenewprod", method = RequestMethod.POST)
	public ResponseEntity<Boolean> saveNewProductEnq(@RequestBody List<NewProduct> newProducts)
			throws Exception {
		System.out.println("inside");

		return newProductService.saveNewProductEnq(newProducts);

	}

	/** Saving New Products for IndentRequest from ReOrder Form **/
	// Boopalan 220719
	@ResponseBody
	@RequestMapping(value = "/savenewprodminqty", method = RequestMethod.POST)
	public Integer saveNewProdMinqty(@RequestBody List<NewProductQty> newProductsIR) throws Exception {
		return newProductService.saveNewProdMinqty(newProductsIR);

	}

	// padmini
	@ResponseBody
	@RequestMapping(value = "/newprno", method = RequestMethod.POST)
	public List newprno(@RequestBody NewProductQty newproducrtno) throws Exception {
		return newProductService.newprno(newproducrtno);

	}

	@ResponseBody
	@RequestMapping(value = "/newprview", method = RequestMethod.POST)
	public List newprview(@RequestBody NewProductQty newproduct) throws Exception {

		return newProductService.newprview(newproduct);

	}

	// padmini
	@ResponseBody
	@RequestMapping(value = "/updatenewproduct", method = RequestMethod.POST)
	public int updatenewproduct(@RequestBody List<NewProductQty> newproduct) throws Exception {

		return newProductService.updatenewproduct(newproduct);

	}

	@ResponseBody
	@RequestMapping(value = "/viewStkNewQtyAll", method = RequestMethod.POST)
	public List viewStkNewQtyAll(@RequestBody NewProductQty viewproduct) throws Exception {

		return newProductService.viewStkNewQtyAll(viewproduct);
	}

	@ResponseBody
	@RequestMapping(value = "/viewStk1NewQtyAll", method = RequestMethod.POST)
	public List viewStk1MinQtyAll(@RequestBody NewProductQty loc) throws Exception {

		return newProductService.viewStk1NewQtyAll(loc);

	}

	@ResponseBody
	@RequestMapping(value = "/oneProduct", method = RequestMethod.POST)
	public boolean oneProduct(@RequestBody List<NewProduct> onepro) throws Exception {

		return newProductService.oneProduct(onepro);

	}

	
	@ResponseBody
	@RequestMapping(value = "/savenewcustprod", method = RequestMethod.POST)
	public ResponseEntity<List<Drug>> saveNewcustProductEnq(@RequestBody List<Drug> newProducts)
			throws Exception {
		System.out.println("inside");

		return newProductService.saveNewcustProductEnq(newProducts);

	}
}
