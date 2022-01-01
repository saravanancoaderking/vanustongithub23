package com.medeil.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.medeil.domain.Doctor;
import com.medeil.service.DoctorService;

/** @Author Ajith Kumar **/
@SuppressWarnings("rawtypes")
@RestController
@RequestMapping("api")
public class DoctorController {

	@Autowired
	private DoctorService doctorService;

	@PostMapping(value = "/saveDoctor")
	public boolean createDoctor(@RequestBody Doctor doctor) throws Exception {
		return doctorService.createDoctor(doctor);
	}

	@GetMapping(value = "/viewDoctor/{cid}/{bid}")
	public List viewDoctors(@PathVariable Integer cid, @PathVariable Integer bid) throws Exception {
		return doctorService.viewDoctors(cid, bid);
	}

	@GetMapping(value = "/editDoctorinfo/{id}")
	public Doctor editDoctor(@PathVariable Integer id) throws Exception {
		return doctorService.editDoctor(id);
	}

	@GetMapping(value = "/editDoctorstate/{id}")
	public List doceditState(@PathVariable Integer id) throws Exception {
		return doctorService.editState(id);
	}

	@GetMapping(value = "/editDoctorcode/{id}")
	public List doceditCcode(@PathVariable Integer id) throws Exception {
		return doctorService.doceditCcode(id);
	}

	@GetMapping(value = "/editDoctorcity/{id}")
	public List doceditCity(@PathVariable Integer id) throws Exception {
		return doctorService.doceditCity(id);
	}

	@PostMapping(value = "/updateDoctor")
	public boolean modifyDoctor(@RequestBody Doctor doctor) throws Exception {
		return doctorService.modifyDoctor(doctor);
	}

	/** DELETE DOCTOR **/
	@GetMapping(value = "/deleteDoctor/{id}")
	public Integer deleteDoctors(@PathVariable Integer id) throws Exception {
		return doctorService.deleteDoctors(id);
	}

	/*** DOCTOR LIST ***/ // Boopalan 010519
	@GetMapping(value = "/doctorlist/{compid}/{branchid}/{locname}/{locrefid}")
	public List doctorlist(@PathVariable Integer compid, @PathVariable Integer branchid, @PathVariable Integer locname,
			@PathVariable Integer locrefid) throws Exception {
		return doctorService.doctorlist(compid, branchid, locname, locrefid);
	}
	
	@GetMapping(value="/searchdoct/{compid}/{branchid}/{locname}/{locrefid}/{searchkey}")
	public List searchdoct(@PathVariable Integer compid, @PathVariable Integer branchid, @PathVariable Integer locname,@PathVariable Integer locrefid,@PathVariable String searchkey) throws Exception  {
		System.out.println("RajaC");
		return doctorService.searchdoctor(compid, branchid, locname, locrefid,searchkey);
	}
}
