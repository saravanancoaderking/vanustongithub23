package com.medeil.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.medeil.domain.User;
import com.medeil.service.UserService;

@SuppressWarnings("rawtypes")
@RestController
@RequestMapping("api")
public class UserController {

	@Autowired
	private UserService userService;

	@GetMapping(value = "/companylist")
	public List companyList() throws Exception {
		return userService.companyList();
	}

	@GetMapping(value = "/getuserCountry/{id}")
	public List userconData(@PathVariable Integer id) throws Exception {
		return userService.userconData(id);
	}

	@GetMapping(value = "/getuserProduct/{id}")
	public List userproData(@PathVariable Integer id) throws Exception {
		return userService.userproData(id);
	}

	@GetMapping(value = "/getuserDomain/{id}")
	public List userdomData(@PathVariable Integer id) throws Exception {
		return userService.userdomData(id);
	}

	@GetMapping(value = "/getusersubDomain/{id}")
	public List usersdomData(@PathVariable Integer id) throws Exception {
		return userService.usersdomData(id);
	}

	@GetMapping(value = "/getuserEdition/{id}")
	public List userEditionData(@PathVariable Integer id) throws Exception {
		return userService.userEditionData(id);
	}

	@GetMapping(value = "/roleComplist/{id}")
	public List roleList(@PathVariable Integer id) throws Exception {
		return userService.roleList(id);
	}

	@GetMapping(value = "/userEmployeelist/{id}")
	public List employeeList(@PathVariable Integer id) throws Exception {
		return userService.employeeList(id);
	}

	@PostMapping(value = "/saveUsers")
	public boolean createUser(@RequestBody User user) throws Exception {
		return userService.createUser(user);
	}

	/*** VIEW USER DATA ***/
	@GetMapping(value = "/viewuserdata")
	public List viewUserList() throws Exception {
		return userService.viewUserList();
	}

	@GetMapping(value = "/viewuserModuledata")
	public List viewUserModulelist() throws Exception {
		return userService.viewUserModulelist();
	}

	@GetMapping(value = "viewuserAccessdata/{data}")
	public List viewUserAccess(@PathVariable String data) throws Exception {
		return userService.viewUserAccess(data);
	}

	@GetMapping(value = "deleteAssignuser/{id}")
	public void delAssignUser(@PathVariable Integer id) throws Exception {
		userService.delAssignUser(id);
	}
}
