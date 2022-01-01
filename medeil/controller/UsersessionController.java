package com.medeil.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.medeil.domain.Usersession;
import com.medeil.service.UsersessionService;

@SuppressWarnings("reatypes")
@RestController
@RequestMapping("/api/userses")
public class UsersessionController {

	@Autowired
	private UsersessionService usersessionService;

	@PostMapping(value = "/saveUsertime")
	public boolean saveUsertime(@RequestBody Usersession sersession) throws Exception {
		return usersessionService.saveUsertime(sersession);
	}

}
