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

import com.medeil.domain.IndCompModel;
import com.medeil.domain.MainPrescription;
import com.medeil.domain.PrescriptionProduct;
import com.medeil.service.PracticemgmtService;

@SuppressWarnings("rawtypes")
@RestController
@RequestMapping("/api")
public class PracticemgmtController {

	@Autowired
	PracticemgmtService practicemgmtService;

	@PostMapping(value = "/createPracticemgmt")
	public ResponseEntity<Boolean> savePracticeManagement(@RequestBody MainPrescription pres) throws Exception {
		return practicemgmtService.savePracticeManagement(pres);
	}

	@PostMapping(value = "/createPracticemgmtprod")
	public ResponseEntity<Boolean> savePracticeManagementprod(@RequestBody List<PrescriptionProduct> prespro)
			throws Exception {
		return practicemgmtService.savePracticeManagementprod(prespro);
	}

	// View Practisemanagement DesingRaja

	@GetMapping(value = "/Viewpractise/{comid}/{branchid}/{locname}/{locrefid}")
	public List getpractiseman(@PathVariable Integer comid, @PathVariable Integer branchid,
			@PathVariable Integer locname, @PathVariable Integer locrefid) throws Exception {
		return practicemgmtService.viewpractise(comid, branchid, locname, locrefid);
	}

	@GetMapping(value = "/deletepractise/{id}/{comid}/{locrefid}")
	public boolean deletepractise(@PathVariable Integer id, @PathVariable Integer comid, @PathVariable Integer locrefid)
			throws Exception {
		System.out.println("Raja View Controller");
		return practicemgmtService.deleteprac(id, comid, locrefid);
	}

	// Edit Practisemanaement DRaja

	@GetMapping(value = "/getpractisemng/{id}")
	public List getpractisemanag(@PathVariable Integer id) throws Exception {
		System.out.println("Practise Controller");
		return practicemgmtService.getpractisedetails(id);
	}

	@GetMapping(value = "/getpractisemngprod/{id}")
	public List getpractisemanagprod(@PathVariable Integer id) throws Exception {
		System.out.println("Practise Controller");
		return practicemgmtService.getpractiseproddetails(id);
	}

	@GetMapping(value = "/deleteproduct/{id}/{prodid}")
	public boolean delproduct(@PathVariable Integer id, @PathVariable Integer prodid) {
		return practicemgmtService.delprespro(id, prodid);
	}

//	Edit for Practise Management DesingRaja

	@PostMapping(value = "/updatepractse")
	public Boolean updatePracticeManagement(@RequestBody MainPrescription pres) throws Exception {
		System.out.println(pres.toString());
		return practicemgmtService.updatePrac(pres);
	}

//Update Product
	@PostMapping(value = "/updatepractseprod")
	public Boolean updatePracticeprod(@RequestBody List<PrescriptionProduct> prescprod) throws Exception {
		System.out.println(prescprod.toString());
		return practicemgmtService.updatePracprod(prescprod);
	}

	@GetMapping(value = "/ViewCustpractise/{comid}/{branchid}/{locname}/{locrefid}/{custid}")
	public List getcustpractiseman(@PathVariable Integer comid, @PathVariable Integer branchid,
			@PathVariable Integer locname, @PathVariable Integer locrefid, @PathVariable Integer custid)
			throws Exception {
		return practicemgmtService.viewcustpractise(comid, branchid, locname, locrefid, custid);
	}

	@PostMapping(value = "/ViewPractiseProduct")
	public List viewPractiseProd(@RequestBody IndCompModel loc) throws Exception {
		return practicemgmtService.viewPractiseProd(loc);
	}
}
