package com.medeil.controller;

/**
 * @DesingRaja
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

import com.medeil.domain.Insurance;
import com.medeil.domain.SacCode;
import com.medeil.domain.SacGroup;
import com.medeil.domain.SacSectionCode;
import com.medeil.domain.Sacode;
import com.medeil.domain.ServiceProductmaster;
import com.medeil.repository.SacRepository;
import com.medeil.service.SacService;

@SuppressWarnings("rawtypes")
@RestController
@RequestMapping("api")
public class SacController {

	private SacService sacservice;

	@Autowired
	public SacController(SacService sacservice) {
		super();
		this.sacservice = sacservice;

	}

	@GetMapping(value = "/getsectiondetails")
	public List getsection() {
		System.out.println("Section Raja");
		return sacservice.getsectionlist();
	}

	@GetMapping(value = "/getgroup/{sectioncode}")
	public List getgroup(@PathVariable Integer sectioncode) {
		return sacservice.getgrouplist(sectioncode);
	}

	@GetMapping(value = "/getsac/{groupcode}")
	public List getsac(@PathVariable Integer groupcode) {
		return sacservice.getsaclist(groupcode);
	}

	@GetMapping(value = "/getsacsub1/{sectioncode}/{groupcode}/{saccode}")
	public List getsacsubcode1(@PathVariable Integer groupcode, @PathVariable Integer saccode) {
		return sacservice.getsacsubcodelist1(groupcode, saccode);
	}

	@GetMapping(value = "/getsacsub2/{sectioncode}/{groupcode}/{saccode}/{sacsubcode1}")
	public List getsacsubcodelist2(@PathVariable Integer groupcode, @PathVariable Integer saccode,
			@PathVariable String sacsubcode1) {
		return sacservice.getsacsubcodelist2(groupcode, saccode, sacsubcode1);
	}

//	=====Save SoaForm =====
	@PostMapping(value = "/savesoa")
	public boolean savesac(@RequestBody SacCode saccode) throws Exception {
		return sacservice.savesaccode(saccode);
	}

//	====Save Section Code ====
	@PostMapping(value = "/savesectioncode")
	public boolean savesection(@RequestBody SacSectionCode sc) throws Exception {
		return sacservice.savesc(sc);
	}

//	====Save Group Code ====
	@PostMapping(value = "/savegroupcode")
	public boolean savegroup(@RequestBody SacGroup gc) throws Exception {
		return sacservice.savegc(gc);
	}

//	====Save SAC Code ====
	@PostMapping(value = "/savesaccode")
	public boolean savesac(@RequestBody Sacode sac) throws Exception {
		return sacservice.savesaccode(sac);
	}

//	====Save SAC Code ====
	@PostMapping(value = "/update-saccode-subcode1")
	public boolean Sacsubcode1(@RequestBody Sacode sac) throws Exception {
		return sacservice.Sacsubcode1(sac);
	}

	@PostMapping(value = "/update-saccode-subcode2")
	public boolean Sacsubcode2(@RequestBody Sacode sac) throws Exception {
		return sacservice.Sacsubcode2(sac);
	}

	@PostMapping(value = "saveSericeProduct")
	public ResponseEntity<Boolean> saveSericeProduct(@RequestBody ServiceProductmaster serviceProductmaster)
			throws Exception {
		return sacservice.saveSericeProduct(serviceProductmaster);
	}

	@GetMapping(value = "getsaveSericeProduct/{countryid}/{companyid}/{branchid}/{locname}/{locrefid}")
	public ResponseEntity<?> getsaveSericeProduct(@PathVariable Integer countryid, @PathVariable Integer companyid,
			@PathVariable Integer branchid, @PathVariable Integer locname, @PathVariable Integer locrefid)
			throws Exception {
		return sacservice.getsaveSericeProduct(countryid, companyid, branchid, locname, locrefid);
	}

	@PostMapping(value = "updateSericeProduct")
	public ResponseEntity<Boolean> updateSericeProduct(@RequestBody ServiceProductmaster serviceProductmaster)
			throws Exception {
		return sacservice.updateSericeProduct(serviceProductmaster);
	}

	@GetMapping(value = "deleteSericeProduct/{id}")
	public ResponseEntity<Boolean> deleteSericeProduct(@PathVariable Integer id) throws Exception {
		return sacservice.deleteSericeProduct(id);
	}

	@GetMapping(value = "getsaveSericeProducts/{id}")
	public ResponseEntity<?> getsaveSericeProducts(@PathVariable Integer id) throws Exception {
		return sacservice.getsaveSericeProducts(id);
	}

}
