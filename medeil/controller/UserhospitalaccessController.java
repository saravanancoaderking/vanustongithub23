package com.medeil.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.medeil.domain.Userhospitalaccess;
import com.medeil.service.UserhospitalaccessService;

@SuppressWarnings("rawtypes")
@RestController
@RequestMapping("api")
public class UserhospitalaccessController {

	@Autowired
	private UserhospitalaccessService userhospitalaccessService;

	@GetMapping(value = "/userhospitallist/{id}")
	public List userHospital(@PathVariable Integer id) throws Exception {
		return userhospitalaccessService.userHospital(id);
	}

	@PostMapping(value = "/saveuserhospital")
	public boolean addHospital(@RequestBody List<Userhospitalaccess> useraccess) throws Exception {
		return userhospitalaccessService.addHospital(useraccess);

	}

}
