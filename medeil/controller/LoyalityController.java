package com.medeil.controller;

/**
 * @author DesingRaja
 */
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.medeil.domain.BonusLoyality;
import com.medeil.domain.BonusloyalityProduct;
import com.medeil.domain.CustomerType;
import com.medeil.domain.Giftproduct;
import com.medeil.domain.Loyality;
import com.medeil.domain.LoyalityGiftProduct;
import com.medeil.service.LoyalityService;

@RestController
@RequestMapping("api")
public class LoyalityController {
	@Autowired
	private LoyalityService loyalityservice;

	// Raja Save Loyality

	@PostMapping(value = "saveloyalitydata")
	public int saveloyality(@RequestBody Loyality loyality) throws Exception {
		return loyalityservice.saveloy(loyality);
	}

	// Get currency Logo

	@GetMapping(value = "/getcurrency/{countryid}")
	public List getcurrency(@PathVariable String countryid) {
		System.out.println("Raja");
		return loyalityservice.getcurlogo(countryid);
	}

	// Loyality Product
	@PostMapping(value = "giftproductsave")
	public boolean savegiftprod(@RequestBody List<LoyalityGiftProduct> giftproduct) throws Exception {
		System.out.println(":::::::::::::::::::::::::::::::::::+giftpro controller Raja");
		return loyalityservice.savegiftprod(giftproduct);
	}

	// Raja
	@GetMapping(value = "getviewpointscheme/{comid}/{branchid}/{locname}/{locrefid}")
	public List getdata(@PathVariable Integer comid, @PathVariable Integer branchid, @PathVariable Integer locname,
			@PathVariable Integer locrefid) throws Exception {
		System.out.println(":::::::::::::::::::::::::::::::::::+View Loyality controller Raja");
		return loyalityservice.viewloyality(comid, branchid, locname, locrefid);
	}

	// View Gift Products

	@GetMapping(value = "getgiftproducts/{comid}/{branchid}/{locname}/{locrefid}")
	public List getgiftdata(@PathVariable Integer comid, @PathVariable Integer branchid, @PathVariable Integer locname,
			@PathVariable Integer locrefid) {
		System.out.println(":::::::::::::::::::::::::::::::::::+View Loyality controller Raja");
		return loyalityservice.viewloyalitygift(comid, branchid, locname, locrefid);
	}

	// Get Customer Loyality Details #Raja
	@GetMapping(value = "getcustloyalitydetails/{comid}/{branchid}/{locname}/{locrefid}")
	public List getcustloyality(@PathVariable Integer comid, @PathVariable Integer branchid,
			@PathVariable Integer locname, @PathVariable Integer locrefid) throws Exception {
		System.out.println(":::::::::::::::::::::::::::::::::::+View Loyality controller Raja");
		return loyalityservice.viewcustloyality(comid, branchid, locname, locrefid);
	}

	// Save Customer Type #Raja
	@PostMapping(value = "savecusttypedata")
	public boolean savecusttype(@RequestBody List<CustomerType> custtype) throws Exception {
		System.out.println("!!!!Raja customer Type");
		return loyalityservice.savectype(custtype);
	}

	// Bonus Loyality Form Raja

	@GetMapping(value = "getcusttype/{comid}/{branchid}/{locname}/{locrefid}")
	public List getcusttype(@PathVariable Integer comid, @PathVariable Integer branchid, @PathVariable Integer locname,
			@PathVariable Integer locrefid) throws Exception {
		System.out.println("getcusttype");
		return loyalityservice.getcusttype(comid, branchid, locname, locrefid);
	}

	@GetMapping(value = "getmainproduct/{comid}/{branchid}/{locname}/{locrefid}")
	public List getproduct(@PathVariable Integer comid, @PathVariable Integer branchid, @PathVariable Integer locname,
			@PathVariable Integer locrefid) throws Exception {
		System.out.println("#####Raja#####");

		return loyalityservice.getmainproduct(comid, branchid, locname, locrefid);
	}

	@PostMapping(value = "savebonusdata")
	public boolean savebonus(@RequestBody BonusLoyality bonusloyality) throws Exception {
		System.out.println("####Desing bonus Controller");
		return loyalityservice.savebonusloyality(bonusloyality);
	}

	@PostMapping(value = "savebonusproduct")
	public boolean savebonusprod(@RequestBody List<BonusloyalityProduct> bonusproduct) throws Exception {
		System.out.println("####Desing bonus product Controller");
		return loyalityservice.savebonusproduct(bonusproduct);

	}

	// View Bonus Loyality
	@GetMapping(value = "getbonuslist/{comid}/{branchid}/{locname}/{locrefid}")
	public List getbons(@PathVariable Integer comid, @PathVariable Integer branchid, @PathVariable Integer locname,
			@PathVariable Integer locrefid) throws Exception {
		System.out.println("#####Raja View Bonus Lyality#####");
		return loyalityservice.getbonusloyalitylist(comid, branchid, locname, locrefid);

	}

	// Get Bonus products
	@GetMapping(value = "getblproduct/{blid}")
	public List getbonsprod(@PathVariable Integer blid) throws Exception {
		System.out.println("#####Raja View Bonus Lyality#####");
		return loyalityservice.getbonusproduct(blid);

	}

	@GetMapping(value = "getcustomtype/{comid}/{branchid}/{locname}/{locrefid}")
	public List getctype(@PathVariable Integer comid, @PathVariable Integer branchid, @PathVariable Integer locname,
			@PathVariable Integer locrefid) throws Exception {
		System.out.println("#####Raja View Bonus Lyality#####");
		return loyalityservice.getcuststype(comid, branchid, locname, locrefid);

	}

	// Get Gift Product for Add Gift form DesingRaja
	@GetMapping(value = "getgiftproduct/{comid}/{branchid}/{locname}/{locrefid}")
	public List getgproduct(@PathVariable Integer comid, @PathVariable Integer branchid, @PathVariable Integer locname,
			@PathVariable Integer locrefid) throws Exception {
		System.out.println("#####Raja View Bonus Lyality#####");
		return loyalityservice.getgiftprod(comid, branchid, locname, locrefid);

	}

	// Get Gift card Details Puthiran
	@GetMapping(value = "getgiftcarddetails/{giftcode}")
	public List getgiftcarddetails(@PathVariable String giftcode) throws Exception {
		System.out.println("#####Raja View Bonus Lyality#####");
		return loyalityservice.getgiftcarddetails(giftcode);

	}

	// Check Product is Exist
	@GetMapping(value = "isexist/{comid}/{gproductname}")
	public boolean checkexist(@PathVariable Integer comid, @PathVariable String gproductname) throws Exception {
		return loyalityservice.isexist(comid, gproductname);
	}

	// Add Gift Products

	@PostMapping(value = "addgiftproduct")
	public boolean addgpriduct(@RequestBody Giftproduct giftproduct) throws Exception {
		System.out.println("####Desing bonus Controller");
		return loyalityservice.savegproduct(giftproduct);
	}

	// Puthiran Get customer Loyalty Details
	@GetMapping(value = "getCustLoyaltyPoints/{custid}")
	public List getCustLoyaltyDetails(@PathVariable Integer custid) throws Exception {
		System.out.println("#####Raja View Cust Lyality#####");
		return loyalityservice.getCustLoyaltyDetails(custid);

	}

	@PostMapping(value = "getLoyalityType")
	public ResponseEntity<?> getLoyalityType(@RequestBody Loyality loyality) throws Exception {
		return loyalityservice.getLoyalityType(loyality);
	}

}
