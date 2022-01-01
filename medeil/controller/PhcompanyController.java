package com.medeil.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.medeil.domain.IndCompModel;
import com.medeil.domain.PharmaCompany;
import com.medeil.service.PhcompanyService;

@Controller
@RestController
@RequestMapping("api/phcompany")
public class PhcompanyController {

	@Autowired
	PhcompanyService phcomService;

	private final Logger log = LoggerFactory.getLogger(PhcompanyController.class);

	@ResponseBody
	@RequestMapping(value = "/savePhCompany")
	public int savePhCompany(@RequestBody PharmaCompany phcomp) throws Exception {
		System.out.println(phcomp.getDlno() + " " + phcomp.getPcompnaytype() + " " + phcomp.getPhdivision());// Boopalan
																												// 120419
		return phcomService.savePhCompany(phcomp);

	}

	@ResponseBody
	@RequestMapping("/updatePhCompany")
	public int updatePhCompany(@RequestBody PharmaCompany phcomp) throws Exception {

		return phcomService.updatePhCompany(phcomp);

	}

	@ResponseBody
	@RequestMapping(value = "/savecomptype")
	public int savecomptype(@RequestBody List<IndCompModel> loc) throws Exception {

		return phcomService.savecomptype(loc);

	}

	@ResponseBody
	@RequestMapping(value = "/savedivision")
	public int savedivision(@RequestBody List<IndCompModel> loc) throws Exception {

		return phcomService.savedivision(loc);

	}

	@ResponseBody
	@RequestMapping(value = "/updateComptype")
	public int updateComptype(@RequestBody List<IndCompModel> loc) throws Exception {

		return phcomService.updateComptype(loc);

	}

	@ResponseBody
	@RequestMapping(value = "/updateDivision")
	public int updateDivision(@RequestBody List<IndCompModel> loc) throws Exception {

		return phcomService.updateDivision(loc);

	}

	@ResponseBody
	@RequestMapping(value = "/addcomptype")
	public int saveIndvComptype(@RequestBody IndCompModel loc) throws Exception {

		return phcomService.saveIndvComptype(loc);

	}

	@ResponseBody
	@RequestMapping(value = "/adddivision")
	public int saveIndvDivision(@RequestBody IndCompModel loc) throws Exception {

		return phcomService.saveIndvDivision(loc);

	}

	@ResponseBody
	@RequestMapping("/viewPhCompanies")
	public List viewPhCompanies(@RequestBody IndCompModel loc) throws Exception {

		return phcomService.viewPhCompanies(loc);
	}

	@ResponseBody
	@RequestMapping("/viewPhCompanyEdit")
	public PharmaCompany viewPhCompanyEdit(@RequestBody IndCompModel loc) throws Exception {

		return phcomService.viewPhCompanyEdit(loc);
	}

	@ResponseBody
	@RequestMapping("/viewPhCompany")
	public List viewPhCompany(@RequestBody IndCompModel loc) throws Exception {

		return phcomService.viewPhCompany(loc);
	}

	@ResponseBody
	@RequestMapping("/viewComptype")
	public List viewComptype(@RequestBody IndCompModel loc) throws Exception {

		return phcomService.viewComptype(loc);

	}

	@ResponseBody
	@RequestMapping("/viewDivision")
	public List viewDivision(@RequestBody IndCompModel loc) throws Exception {

		return phcomService.viewDivision(loc);

	}

	@ResponseBody
	@RequestMapping("/viewCustComptype")
	public List viewCustComptype(@RequestBody IndCompModel loc) throws Exception {
		return phcomService.viewCustComptype(loc);

	}

	@ResponseBody
	@RequestMapping("/viewCustDivision")
	public List viewCustDivision(@RequestBody IndCompModel loc) throws Exception {
		return phcomService.viewCustDivision(loc);

	}

//Boopalan 150519
	@ResponseBody
	@RequestMapping("/deletePhCompany")
	public int deletePhCompany(@RequestBody IndCompModel loc) throws Exception {
		return phcomService.deletePhCompany(loc);

	}

	/********* Edit State **************/
	@ResponseBody // Boopalan 020419
	@RequestMapping(value = "editPCState")
	public List editPCState(@RequestBody IndCompModel pcompanyid) throws Exception {
		return phcomService.editPCState(pcompanyid);

	}

	/********* Edit City **************/
	@ResponseBody // Boopalan 020419
	@RequestMapping(value = "editPCCity")
	public List editPCCity(@RequestBody IndCompModel pcompanyid) throws Exception {
		return phcomService.editPCCity(pcompanyid);
	}
	
}
