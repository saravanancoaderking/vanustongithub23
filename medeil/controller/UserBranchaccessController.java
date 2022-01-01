package com.medeil.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.medeil.domain.UserBranchaccess;
import com.medeil.service.UserBranchaccessService;

@SuppressWarnings("rawtypes")
@RestController
@RequestMapping("api")
public class UserBranchaccessController {

	@Autowired
	UserBranchaccessService userBranchaccessService;

	@GetMapping(value = "/userbranchlist/{id}")
	public List userBranch(@PathVariable Integer id) throws Exception {
		return userBranchaccessService.userBranch(id);
	}

	@Transactional
	@PostMapping(value = "/saveuserbranch")
	public boolean adduserBranch(@RequestBody List<UserBranchaccess> useraccess) throws Exception {
		return userBranchaccessService.adduserBranch(useraccess);
	}

}
