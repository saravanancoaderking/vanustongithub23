package com.medeil.controller;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.medeil.domain.GenericMaster;
import com.medeil.service.GenericMasterService;

@SuppressWarnings("rawtypes")
@RestController
@RequestMapping("/api")
public class GenericMasterController {

	@Autowired
	GenericMasterService genericMasterService;

	@PostMapping(value = "/genericname")
	public boolean saveGenericName(@RequestBody GenericMaster genericname) throws Exception {
		System.out.println("");
		return genericMasterService.saveGenericName(genericname);
	}

}
