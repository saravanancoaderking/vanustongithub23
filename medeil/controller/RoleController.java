package com.medeil.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.medeil.domain.Role;
import com.medeil.service.RoleService;

@SuppressWarnings("rawtypes")
@RestController
@RequestMapping("api")
public class RoleController {

	@Autowired
	private RoleService roleService;

	@GetMapping(value = "rolelist")
	public List<Role> getAll() throws Exception {
		return roleService.getAll();
	}

	@PostMapping(value = "saveRole")
	public ResponseEntity<Boolean> createRole(@RequestBody Role role) throws Exception {
		return roleService.createRole(role);
	}

	@GetMapping(value = "getRoleList")
	public List Rolelist() throws Exception {
		return roleService.Rolelist();
	}

	@GetMapping(value = "isExistrole/{id}/{name}")
	public boolean checkExistRole(@PathVariable Integer id, @PathVariable String name) throws Exception {
		return roleService.checkExistRole(id, name);
	}

	@GetMapping(value = "rolecompanyname/{id}")
	public List getCompanyName(@PathVariable Integer id) throws Exception {
		return roleService.getCompanyName(id);
	}
}
