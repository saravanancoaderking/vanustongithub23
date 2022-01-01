package com.medeil.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.medeil.domain.SubGroup1;
import com.medeil.domain.SubGroup2;
import com.medeil.service.SubGroup2Service;

@SuppressWarnings("rawtypes")
@RestController
@RequestMapping("/api")
public class SubGroup2Controller {
	@Autowired
	SubGroup2Service subGroup2Service;

	@PostMapping(value = "/savesubgroup2")
	public boolean saveSubGroup1(@RequestBody SubGroup2 subgroup2) throws Exception {
		System.out.println("");
		return subGroup2Service.saveSubGroup2(subgroup2);
	}
	
	@PostMapping(value = "/updatesubgroup2")
	public boolean updatesubgroup2(@RequestBody SubGroup2 subgroup2) throws Exception {
			return subGroup2Service.updatesubgroup2(subgroup2);
	}
	
}
