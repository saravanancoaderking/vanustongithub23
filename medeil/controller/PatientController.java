package com.medeil.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.medeil.domain.IndCompModel;
import com.medeil.domain.Patient;
import com.medeil.domain.PatientDetails;
import com.medeil.domain.PatientType;
import com.medeil.domain.PatientsRelatives;
import com.medeil.service.PatientService;

@RestController
@RequestMapping("api/patient")
public class PatientController {

	@Autowired
	PatientService patientService;

	private final Logger log = LoggerFactory.getLogger(PatientController.class);

	@ResponseBody
	@RequestMapping(value = "/savePatient")
	public int savePatient(@RequestBody Patient cust) throws Exception {

		return patientService.savePatient(cust);

	}

	@ResponseBody
	@RequestMapping("/updatePatient")
	public int updatePatient(@RequestBody Patient cust) throws Exception {

		return patientService.updatePatient(cust);

	}

	@ResponseBody
	@RequestMapping(value = "/savePtdetails", method = RequestMethod.POST)
	public int savePtdetails(@RequestBody PatientDetails pt) throws Exception {

		return patientService.savePtdetails(pt);

	}

	@ResponseBody
	@RequestMapping("/updatePtdetails")
	public void updatePtdetails(@RequestBody PatientDetails pt) throws Exception {

	}

	@ResponseBody
	@RequestMapping(value = "/savehealthcds")
	public int savehealthcds(@RequestBody List<IndCompModel> loc) throws Exception {

		return patientService.savehealthcds(loc);

	}

	@ResponseBody
	@RequestMapping(value = "/saveallergies")
	public int saveallergies(@RequestBody List<IndCompModel> loc) throws Exception {

		return patientService.saveallergies(loc);

	}

	@ResponseBody
	@RequestMapping(value = "/addptAllergies")
	public int saveIndvAllergies(@RequestBody IndCompModel loc) throws Exception {

		return patientService.saveIndvAllergies(loc);

	}

	@ResponseBody
	@RequestMapping(value = "/addptHealthcds")
	public int saveIndvHealthcds(@RequestBody IndCompModel loc) throws Exception {

		return patientService.saveIndvHealthcds(loc);

	}

	@ResponseBody
	@RequestMapping("/viewPatients")
	public List viewPatients(@RequestBody IndCompModel loc) throws Exception {

		return patientService.viewPatients(loc);
	}

	@ResponseBody
	@RequestMapping("/viewPatientEdit")
	public Patient viewPatientEdit(@RequestBody IndCompModel loc) throws Exception {

		return patientService.viewPatientEdit(loc);
	}

	@ResponseBody
	@RequestMapping("/viewPatient")
	public List viewPatient(@RequestBody IndCompModel loc) throws Exception {

		return patientService.viewPatient(loc);
	}

	@ResponseBody
	@RequestMapping("/viewCountry")
	public List viewCountry(@RequestBody IndCompModel loc) throws Exception {

		return patientService.viewCountry(loc);

	}

	@ResponseBody
	@RequestMapping("/viewState")
	public List viewState(@RequestBody IndCompModel loc) throws Exception {
		return patientService.viewState(loc);

	}

	@ResponseBody
	@RequestMapping("/viewCity")
	public List viewCity(@RequestBody IndCompModel loc) throws Exception {
		return patientService.viewCity(loc);

	}

	@ResponseBody
	@RequestMapping("/viewDoctor")
	public List viewDoctor(@RequestBody IndCompModel loc) throws Exception {

		return patientService.viewDoctor(loc);
	}

	@ResponseBody
	@RequestMapping("/viewDepartment")
	public List viewDepartment(@RequestBody IndCompModel loc) throws Exception {

		return patientService.viewDepartment(loc);
	}

	@ResponseBody
	@RequestMapping("/viewAllergies")
	public List viewAllergies(@RequestBody IndCompModel loc) throws Exception {

		return patientService.viewAllergies(loc);
	}

	@ResponseBody
	@RequestMapping("/viewHealthcds")
	public List viewHealthcds(@RequestBody IndCompModel loc) throws Exception {

		return patientService.viewHealthcds(loc);
	}

	@ResponseBody
	@RequestMapping("/viewCustcode")
	public String viewCustid(@RequestBody IndCompModel loc) throws Exception {

		return patientService.viewCustcode(loc);
	}

	@ResponseBody
	@RequestMapping("/deletePatient")
	public int deletePatient(@RequestBody IndCompModel loc) throws Exception {
		return patientService.deletePatient(loc);

	}

	@ResponseBody
	@RequestMapping("/deletePtdetails")
	public int deletePtdetails(@RequestBody IndCompModel loc) throws Exception {

		return patientService.deletePtDetails(loc);
	}

	/********* Edit State **************/
	@ResponseBody // Boopalan 020419
	@RequestMapping(value = "editCusState")
	public List editCusState(@RequestBody IndCompModel patientid) throws Exception {
		return patientService.editCusState(patientid);

	}

	/********* Edit City **************/
	@ResponseBody // Boopalan 020419
	@RequestMapping(value = "editCusCity")
	public List editCusCity(@RequestBody IndCompModel patientid) throws Exception {
		return patientService.editCusCity(patientid);

	}
	// Raja
	// @ResponseBody
	// @RequestMapping(value ="getcustdetails")
	// public List getcust() throws Exception {
	// return patientService.getcustomer();
	// }

	// Raja Add Patient relatives
	@ResponseBody
	@GetMapping(value = "getcustdetails/{cid}/{bid}/{lcname}/{lcrefid}")
	public List getcust(@PathVariable int cid, @PathVariable int bid, @PathVariable int lcname,
			@PathVariable int lcrefid) throws Exception {
		return patientService.getcustomer(cid, bid, lcname, lcrefid);
	}

	@ResponseBody
	@GetMapping(value = "custcontact/{patid}")
	public List getcont(@PathVariable int patid) throws Exception {
		return patientService.getcustcont(patid);
	}

	@PostMapping(value = "/savePrelatives")
	public int savePatient(@RequestBody List<PatientsRelatives> prelative) throws Exception {
		System.out.println("raja");
		return patientService.savepatrelative(prelative);

	}
	
	//Puthiran Refill Alert Process
	@ResponseBody
	@GetMapping(value = "refillalerts/{cid}/{bid}/{lname}/{lid}")
	public List RefillAlerts(@PathVariable int cid,@PathVariable int bid,@PathVariable int lname,@PathVariable int lid) throws Exception {
		return patientService.RefillAlerts(cid,bid,lname,lid);
	}
	
	@ResponseBody
	@GetMapping(value = "Viewallrefillcustomers/{cid}/{bid}/{lname}/{lid}")
	public List GetAllRefillCustomers(@PathVariable int cid,@PathVariable int bid,@PathVariable int lname,@PathVariable int lid) throws Exception {
		return patientService.GetAllRefillCustomers(cid,bid,lname,lid);
	}
	@PostMapping(value="/savemembership")
	public boolean creatmem(@RequestBody Patient pt) throws Exception{
		return patientService.membership(pt);
	}

	@ResponseBody
	@GetMapping(value = "getcustomercategory/{cid}/{bid}/{lname}/{lrefid}")
	public List getCustomerCategory(@PathVariable Integer cid,@PathVariable Integer bid,@PathVariable Integer lname,@PathVariable Integer lrefid) throws Exception {
		return patientService.getCustomerCategory(cid,bid,lname,lrefid);
	}
	
	@PostMapping(value="save-customer-category")
	public boolean saveCustomerCategory(@RequestBody PatientType patientType) throws Exception{
		return patientService.saveCustomerCategory(patientType);
	}



}
