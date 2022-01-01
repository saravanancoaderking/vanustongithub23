package com.medeil.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.medeil.domain.Userwarehouseaccess;
import com.medeil.service.UserwarehouseaccessService;

@SuppressWarnings("rawtypes")
@RestController
@RequestMapping("/api")
public class UserwarehouseaccessController {

	@Autowired
	private UserwarehouseaccessService userwarehouseaccessService;

	@GetMapping(value = "/userwarehouselist/{id}")
	public List userWarehouselist(@PathVariable Integer id) throws Exception {
		return userwarehouseaccessService.userWarehouselist(id);
	}

	@PostMapping(value = "/saveuserwarehouse")
	public boolean addWarehouse(@RequestBody List<Userwarehouseaccess> useraccess) throws Exception {
		return userwarehouseaccessService.addWarehouse(useraccess);
	}

}
