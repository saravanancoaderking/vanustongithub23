package com.medeil.controller;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.medeil.domain.MainGroup;
import com.medeil.service.MainGroupService;

@SuppressWarnings("rawtypes")
@RestController
@RequestMapping("/api")

public class MainGroupController {
	@Autowired
	MainGroupService mainGroupService;

	
	
	@PostMapping(value = "/savemaingroup")
	@Transactional
	public boolean savemaingroup(@RequestBody MainGroup maingroup) throws Exception {
	//	try {
	//	System.out.println("");
		return mainGroupService.savemaingroup(maingroup);
	//}catch(Exception e) {
	//	System.out.println("Exception :"+e);
	//}
	// return true;
	}
	
	@PostMapping(value = "/updatemaingroup")
	@Transactional
	public boolean updatemaingroup(@RequestBody MainGroup maingroup) throws Exception {
			return mainGroupService.updatemaingroup(maingroup);
	}
	
}
