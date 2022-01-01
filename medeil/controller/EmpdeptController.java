package com.medeil.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.medeil.domain.Empdept;
import com.medeil.repository.EmpdeptRepository;
import org.springframework.stereotype.Service;

import com.medeil.service.EmpdeptService;

@SuppressWarnings("rawtypes")
@RestController
@RequestMapping("/api/dept")
public class EmpdeptController {

	@Autowired
	private EmpdeptRepository empdeptRepository;

	@Autowired
	private EmpdeptService empdeptService;

	@PostMapping(value = "/CreatedeptRec1")
	public void CreatedeptRec(@RequestBody Empdept empdept) throws Exception {
		empdeptService.CreatedeptRec(empdept);
	}

	@GetMapping(value = "/isExistdept1/{compid}/{branchid}/{locname}/{locrefid}/{name}")
	public boolean isExistdept(@PathVariable Integer compid, @PathVariable Integer branchid,
			@PathVariable Integer locname, @PathVariable Integer locrefid, @PathVariable String name) throws Exception {
		return empdeptService.isExistdept(compid, branchid, locname, locrefid, name);
	}
}