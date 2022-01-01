/**
 * 
 */
package com.medeil.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.medeil.domain.Gstsetting;
import com.medeil.domain.Taxsavetype;
import com.medeil.domain.Taxsettings;
import com.medeil.domain.Taxtype;
import com.medeil.service.TaxsettingsService;

/**
 * @author Sabarish
 *
 */
@SuppressWarnings("rawtypes")
@RestController
@RequestMapping("api")
public class TaxsettingsController {
	@Autowired
	private TaxsettingsService taxsettingsService;

	@GetMapping(value = "/getcompanytax/{id}")
	public List getCompanytax(@PathVariable Integer id) throws Exception {
		System.out.println();
		return taxsettingsService.getCompany(id);
	}

	@GetMapping(value = "/getbranchtax/{id}")
	public List getBranchtax(@PathVariable Integer id) throws Exception {
		return taxsettingsService.getBranch(id);
	}

	@GetMapping(value = "/getshoptax/{id}")
	public List getShoptax(@PathVariable Integer id) throws Exception {
		return taxsettingsService.getShop(id);
	}

	@GetMapping(value = "/getwarehousetax/{id}")
	public List getWarehousetax(@PathVariable Integer id) throws Exception {
		return taxsettingsService.getWarehouse(id);
	}

	@GetMapping(value = "/gethospitaltax/{id}")
	public List getHospitaltax(@PathVariable Integer id) throws Exception {
		return taxsettingsService.getHospital(id);
	}

	@GetMapping(value = "/gettaxtypetsetting/{id}")
	public List getTaxtype(@PathVariable Integer id) throws Exception {
		return taxsettingsService.gettaxtype(id);
	}

	// For Saving Gst Setting Table
	@PostMapping(value = "/savetaxationtype")
	public boolean saveTaxation(@RequestBody Gstsetting gst) throws Exception {
		System.out.println("Inside save Tax controller");

		return taxsettingsService.saveTaxation(gst);

	}

	// For Saving Tax Setting Table
	@PostMapping(value = "/savetaxvalue")
	public boolean saveTaxsetting(@RequestBody Taxsavetype taxtyp) throws Exception {
		System.out.println("Inside save Tax controller");
		System.out.println("sss" + taxtyp.getCompanyrefid());
		return taxsettingsService.saveTaxpercent(taxtyp);

	}

	// For Saving All Tax Percent Table savetaxvalue
	@PostMapping(value = "/savetaxvalueeeee")
	public boolean saveTax(@RequestBody Taxsettings tax) throws Exception {
		return taxsettingsService.saveTaxsetting(tax);

	}

	// For Saving in temp table
	@PostMapping(value = "/savetax")
	public boolean saveTaxtype(@RequestBody Taxtype tax) throws Exception {
		System.out.println("Inside save Tax controller");

		return taxsettingsService.saveTaxtype(tax);

	}

	// saving taxsetting for individual company and shop when user attempt first
	// time
	@PostMapping(value = "/savetaxsetting")
	public ResponseEntity<Boolean> saveTaxsetting(@RequestBody Taxsettings taxsetting) throws Exception {
		return taxsettingsService.saveTaxsettings(taxsetting);

	}

	@GetMapping(value = "/getsetupstatus/{cid}/{bid}/{lname}/{lrefid}")
	public List getTaxStatus(@PathVariable Integer cid, @PathVariable Integer bid, @PathVariable Integer lname,
			@PathVariable Integer lrefid) throws Exception {
		return taxsettingsService.getTaxStatus(cid, bid, lname, lrefid);
	}

	@GetMapping(value = "/gettaxContrystate/{cid}/{bid}/{lname}/{lrefid}")
	public List getTaxcountrystate(@PathVariable Integer cid, @PathVariable Integer bid, @PathVariable Integer lname,
			@PathVariable Integer lrefid) throws Exception {
		return taxsettingsService.getTaxcountrystate(lrefid);
	}

	@GetMapping(value = "/fetchtaxsettings/{cid}/{bid}/{lname}/{lrefid}")
	public List fetchTaxsettings(@PathVariable Integer cid, @PathVariable Integer bid, @PathVariable Integer lname,
			@PathVariable Integer lrefid) throws Exception {
		return taxsettingsService.fetchTaxsettings(lrefid);
	}
}
