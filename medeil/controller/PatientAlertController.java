package com.medeil.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.medeil.domain.PatientAlert;
import com.medeil.service.PatientAlertServices;

@SuppressWarnings("rawtypes")
@RestController
@RequestMapping("api")
public class PatientAlertController {

	@Autowired
	PatientAlertServices patientAlertServices;

	// get Patient's Company
	@GetMapping(value = "/getpatientcompany")
	public List getCompany() throws Exception {
		return patientAlertServices.getCompanies();
	}

	// get Patient's Branch
	@GetMapping(value = "/getpatientbranch/{id}")
	public List getBranch(@PathVariable Integer id) throws Exception {
		return patientAlertServices.getBranches(id);
	}

	// get Patient's Shop
	@GetMapping(value = "/getpatientshop/{id}")
	public List getShops(@PathVariable Integer id) throws Exception {
		return patientAlertServices.getShops(id);
	}

	// get Patient's Warehouse
	@GetMapping(value = "/getpatientwarehouse/{id}")
	public List getWarehouse(@PathVariable Integer id) throws Exception {
		return patientAlertServices.getWarehouse(id);
	}

	// get Patient's Hospital
	@GetMapping(value = "/getpatienthospital/{id}")
	public List getHospital(@PathVariable Integer id) throws Exception {
		return patientAlertServices.getHospital(id);
	}

	// get Company Patient
	@GetMapping("/getcompanypatient/{compid}")
	public List getCompanyPatient(@PathVariable Integer compid) throws Exception {
		return patientAlertServices.getCompanyPatient(compid);
	}

	// get Branch Patient
	@GetMapping("/getbranchpatient/{compid}/{branchid}")
	public List getBranchPatient(@PathVariable Integer compid, @PathVariable Integer branchid) throws Exception {
		return patientAlertServices.getBranchPatient(compid, branchid);
	}

	// get Firm Patient
	@GetMapping("/getfirmpatient/{compid}/{branchid}/{locid}")
	public List getFirmPatient(@PathVariable Integer compid, @PathVariable Integer branchid,
			@PathVariable Integer locid) throws Exception {
		System.out.println("getFirmEmployee" + compid + "br" + branchid + "loc" + locid);
		return patientAlertServices.getFirmPatient(compid, branchid, locid);
	}

	@GetMapping("/sendmessagebymail/{mailid}/{message}")
	public boolean sendMessageByMail(@PathVariable String mailid, @PathVariable String message) throws Exception {
		boolean flag = false;
	//	try {
			System.out.println("mail" + mailid + "message" + message);
			flag = patientAlertServices.getEmail(mailid, message);
	//	} catch (Exception e) {
	//		System.out.println("Exception" + e);
	//		flag = false;
	//	}
		return flag;
	}

	// get PatientInfo
	@GetMapping("/getpatientinfo/{pid}")
	public List getPatientInfo(@PathVariable Integer pid) throws Exception {
		return patientAlertServices.getPatientInfo(pid);
	}

	@PostMapping(value = "/savePatient")
	public PatientAlert saveMessage(@RequestBody PatientAlert patient) throws Exception {
		System.out.println("saveMessageisCalling1234");
		System.out.println("saveMessageisCalling1234" + patient.getMessage());
		return patientAlertServices.saveMessageAlert(patient);
	}

	@GetMapping("/viewpatientalert/{comp}/{brnch}/{loc}/{locref}")
	public List viewPatientAlert(@PathVariable Integer comp, @PathVariable Integer brnch, @PathVariable Integer loc,
			@PathVariable Integer locref) throws Exception {
		return patientAlertServices.viewPatientAlert(comp, brnch, loc, locref);
	}

}
