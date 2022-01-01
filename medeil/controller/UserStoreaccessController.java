package com.medeil.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.medeil.domain.UserStoreaccess;
import com.medeil.service.UserStoreaccessService;

@SuppressWarnings("rawtypes")
@RestController
@RequestMapping("/api")
public class UserStoreaccessController {

	@Autowired
	private UserStoreaccessService userStoreaccessService;

	@GetMapping(value = "/usershoplist/{id}")
	public List userShoplist(@PathVariable Integer id)throws Exception {
		return userStoreaccessService.userShoplist(id);
	}

	@PostMapping(value = "/saveusershop")
	public boolean addUserShop(@RequestBody List<UserStoreaccess> useraccess)throws Exception {
		return userStoreaccessService.addUserShop(useraccess);
	}
}
