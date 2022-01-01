package com.medeil.controller;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.medeil.domain.MainGroup;
import com.medeil.domain.SubGroup1;
import com.medeil.service.SubGroup1Service;

@SuppressWarnings("rawtypes")
@RestController
@RequestMapping("/api")
public class SubGroup1Controller {
	@Autowired
	SubGroup1Service subGroup1Service;

	@PostMapping(value = "/savesubgroup1")
	public boolean saveSubGroup1(@RequestBody SubGroup1 subgroup1) throws Exception {
		System.out.println("");
		return subGroup1Service.saveSubGroup1(subgroup1);
	}
	
	@PostMapping(value = "/updatesubgroup1")
	public boolean updatesubgroup1(@RequestBody SubGroup1 SubGroup1) throws Exception {
			return subGroup1Service.updatesubgroup1(SubGroup1);
	}
}
