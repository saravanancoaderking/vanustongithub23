package com.medeil.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.medeil.domain.Hospital;
import com.medeil.service.HospitalService;

@SuppressWarnings("rawtypes")
@RestController
@RequestMapping("api")
public class HospitalController {

	@Autowired
	private HospitalService hospitalService;

	@GetMapping(value = "getspeciality")
	public List getSpecialitys() throws Exception {
		return hospitalService.getSpecialitys();
	}

	@GetMapping(value = "viewHospitaldetails/{cid}/{bid}")
	public List getAll(@PathVariable Integer cid, @PathVariable Integer bid) throws Exception {
		return hospitalService.getAll(cid, bid);
	}

	@GetMapping(value = "edithospitalinfo/{id}")
	public Hospital editHospital(@PathVariable Integer id) throws Exception {
		return hospitalService.editHospital(id);
	}

	/** EDIT HOSPITAL **/
	@GetMapping(value = "gethospeditState/{id}")
	public List hospeditState(@PathVariable Integer id) throws Exception {
		return hospitalService.editState(id);
	}

	@GetMapping(value = "gethospeditCcode/{id}")
	public List hospeditCcode(@PathVariable Integer id) throws Exception {
		return hospitalService.hospeditCcode(id);
	}

	@GetMapping(value = "gethospeditCity/{id}")
	public List hospeditCity(@PathVariable Integer id) throws Exception {
		return hospitalService.hospeditCity(id);
	}

	@PostMapping(value = "updateHospinfo")
	public boolean updateHospital(@RequestBody Hospital hospital) throws Exception {
		return hospitalService.updateHospital(hospital);
	}

	/** DELETE HOSPITAL **/
	@GetMapping(value = "deleteHospitaldetails/{id}")
	public Integer deleteHospital(@PathVariable Integer id) throws Exception {
		return hospitalService.deleteHospital(id);
	}

	@PostMapping(value = "/saveHospinfo")
	public boolean saveHospForm(@RequestBody Hospital hospital) throws Exception {
		return hospitalService.saveHospital(hospital);
	}

}
