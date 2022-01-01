package com.medeil.controller;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Base64;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.medeil.domain.ManualPrescription;
import com.medeil.domain.ManualPrescriptionproduct;
import com.medeil.repository.ManualPrescriptionRepository;
import com.medeil.service.ManualPrescriptionService;

/**
 * 
 * @author Raja
 *
 */
@SuppressWarnings("rawtypes")
@RestController
@RequestMapping("api")
public class ManualPrescriptionContoller {

	@Autowired
	ManualPrescriptionService manualprescriptionservice;

	@Autowired
	ManualPrescriptionRepository manualprescriptionrepository;

	@GetMapping(value = "/getpatientid/{comid}/{branchid}/{locname}/{locrefid}")
	public List patientid(@PathVariable Integer comid, @PathVariable Integer branchid, @PathVariable Integer locname,
			@PathVariable Integer locrefid) throws Exception {
		return manualprescriptionservice.patientid(comid, branchid, locname, locrefid);
	}

	@GetMapping(value = "/patientdetails/{pid}/{comid}/{branchid}/{locname}/{locrefid}")
	public List patientdetails(@PathVariable Integer pid, @PathVariable Integer comid, @PathVariable Integer branchid,
			@PathVariable Integer locname, @PathVariable Integer locrefid) throws Exception {
		return manualprescriptionservice.patientdetails(pid, comid, branchid, locname, locrefid);
	}

	@GetMapping(value = "/doctordetail/{comid}/{branchid}/{locname}/{locrefid}")
	public List doctor(@PathVariable Integer comid, @PathVariable Integer branchid, @PathVariable Integer locname,
			@PathVariable Integer locrefid) throws Exception {
		return manualprescriptionservice.doctorname(comid, branchid, locname, locrefid);
	}

	@GetMapping(value = "/getemployees/{comid}/{branchid}/{locname}/{locrefid}")
	public List employee(@PathVariable Integer comid, @PathVariable Integer branchid, @PathVariable Integer locname,
			@PathVariable Integer locrefid) throws Exception {
		return manualprescriptionservice.employee(comid, branchid, locname, locrefid);
	}

	@GetMapping(value = "/getpresproducts/{prodid}")
	public List getproduct(@PathVariable Integer prodid) throws Exception {
		return manualprescriptionservice.presproduct(prodid);
	}

	@GetMapping(value = "/getordertype")
	public List ordertype() throws Exception {
		return manualprescriptionservice.getordertype();
	}

	/*********** Save Prescription image 
	 * @throws Exception ***************/
	// Boopalan 071119
	@PostMapping(value = "/saveprescriptionimage")
	public boolean saveprescriptionimage(@RequestPart("file") MultipartFile file) throws Exception {
	//	try {
			manualprescriptionservice.saveprescriptionimage(file);
			return true;
	//	} catch (Exception e) {

	//		return false;
	//	}
	}

	/*********** View Prescription image ***************/
	// Boopalan 071119
	@GetMapping(value = "/getsendprescriptionImage/{id}")
	public Map<String, String> getsendImage(@PathVariable Integer id) throws IOException {
		Map<String, String> jsonMap = new HashMap<>();
		String path = manualprescriptionrepository.getsendImage(id);
		System.out.println(id);
		File serverFile = new File(path);
		String encodeImage = Base64.getEncoder().withoutPadding()
				.encodeToString(Files.readAllBytes(serverFile.toPath()));
		jsonMap.put("content", encodeImage);
		return jsonMap;

	}

	// View Sign Image
	// Boopalan 071119
	@GetMapping(value = "/getempsignImage/{id}")
	public Map<String, String> getsignImage(@PathVariable Integer id) throws IOException {
		Map<String, String> jsonMap = new HashMap<>();
		String path = manualprescriptionrepository.getempsignImage(id);
		System.out.println(id);
		File serverFile = new File(path);
		String encodeImage = Base64.getEncoder().withoutPadding()
				.encodeToString(Files.readAllBytes(serverFile.toPath()));
		jsonMap.put("content", encodeImage);
		return jsonMap;

	}

	// Save Signature Image

	// Raja1112
	// @PostMapping(value = "/savesignimage")
	// public boolean savesignimage(@RequestPart("file") MultipartFile file) throws
	// IOException {
	// try {
	// System.out.println("Testing Signature");
	// manualprescriptionservice.savesignatureimage(file);

	// return true;
	// } catch (Exception e) throws Exception {

	// return false;
	// }
	// }

	/*********** Save Prescription Record ***************/
	// Boopalan 071119
	@PostMapping(value = "/createPrescriptionRecord")
	public boolean createPrescriptionRecord(@RequestBody ManualPrescription presc) throws Exception {
		return manualprescriptionservice.createPrescriptionRecord(presc);
	}

	@PostMapping(value = "/savepresproduct")
	public Boolean savepresprod(@RequestBody List<ManualPrescriptionproduct> prescprod) throws Exception {
		return manualprescriptionservice.saveprescprod(prescprod);
	}

	// View Prescription Update

	@GetMapping(value = "/getprescview/{comid}/{branchid}/{locname}/{locrefid}")
	public List getprescdetails(@PathVariable Integer comid, @PathVariable Integer branchid,
			@PathVariable Integer locname, @PathVariable Integer locrefid) throws Exception {
		return manualprescriptionservice.viewpresc(comid, branchid, locname, locrefid);
	}
}