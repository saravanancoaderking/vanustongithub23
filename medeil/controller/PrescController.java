package com.medeil.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.medeil.domain.IndCompModel;
import com.medeil.domain.PrescProd;
import com.medeil.domain.Prescription;
import com.medeil.service.PrescService;

@Controller
@RequestMapping("api/presc")
public class PrescController {

	@Autowired
	PrescService prescService;

	private final Logger log = LoggerFactory.getLogger(PrescController.class);

	@ResponseBody
	@RequestMapping(value = "/savePrescription")
	public int savePrescription(@RequestBody Prescription prc) throws Exception {

		return prescService.savePrescription(prc);

	}

	@ResponseBody
	@RequestMapping(value = "/savePrescProd")
	public int savePrescProd(@RequestBody List<PrescProd> pres) throws Exception {

		return prescService.savePrescProd(pres);

	}

	@ResponseBody
	@RequestMapping(value = "/updatePrescription")
	public int updatePrescription(@RequestBody Prescription prc) throws Exception {

		return prescService.updatePrescription(prc);

	}

	@ResponseBody
	@RequestMapping(value = "/updatePrescProd")
	public int updatePrescProd(@RequestBody List<PrescProd> pres) throws Exception {

		return prescService.updatePrescProd(pres);

	}

	@ResponseBody
	@RequestMapping("/viewPRCCustomers")
	public List viewCustomers(@RequestBody IndCompModel loc) throws Exception {

		return prescService.viewCustomers(loc);

	}

	@ResponseBody
	@RequestMapping("/viewPRCDoctors")
	public List viewDoctors(@RequestBody IndCompModel loc) throws Exception {

		return prescService.viewDoctors(loc);

	}

	@ResponseBody
	@RequestMapping("/viewPrescAll")
	public List viewPrescAll(@RequestBody IndCompModel loc) throws Exception {

		return prescService.viewPrescAll(loc);

	}

	@ResponseBody
	@RequestMapping("/viewPresc")
	public List viewPresc(@RequestBody IndCompModel loc) throws Exception {

		return prescService.viewPresc(loc);

	}

	@ResponseBody
	@RequestMapping("/viewPrescProducts")
	public List viewPrescProducts(@RequestBody IndCompModel loc) throws Exception {

		return prescService.viewPrescProducts(loc);

	}

	@ResponseBody
	@RequestMapping("/viewPRCProductNames")
	public List viewProductNames(@RequestBody IndCompModel loc) throws Exception {

		return prescService.viewProductNames(loc);

	}

	@ResponseBody
	@RequestMapping("/viewPRCProductName")
	public List viewProductName(@RequestBody IndCompModel loc) throws Exception {

		return prescService.viewProductName(loc);

	}

	@ResponseBody
	@RequestMapping("/checkInteration")
	public List checkInteration(@RequestBody IndCompModel loc) throws Exception {

		return prescService.checkInteration(loc);

	}

	@ResponseBody
	@RequestMapping("/deletePrescription")
	public int deletePrescription(@RequestBody IndCompModel loc) throws Exception {

		return prescService.deletePrescription(loc);

	}

}
