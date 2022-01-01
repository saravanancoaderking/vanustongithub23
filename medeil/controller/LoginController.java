package com.medeil.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.medeil.service.LoginService;

@RestController
@RequestMapping("/medauth")
public class LoginController {
	@Autowired
	LoginService loginService;

	@GetMapping(value = "user-attempts-count/{username}")
	public Map userAttemptCount(@PathVariable String username) throws Exception {
		return loginService.userAttemptCount(username);
	}

	@GetMapping(value = "user-mobile-number-identification/{username}")
	public Map mobileNumberCheck(@PathVariable String username) throws Exception {
		return loginService.mobileNumberCheck(username);
	}

	@GetMapping(value = "user-mobile-number-verification/{username}/{mobileno}")
	public Map mobileNumberVerification(@PathVariable String username, @PathVariable String mobileno) throws Exception {
		return loginService.mobileNumberVerification(username, mobileno);
	}

	@GetMapping(value = "user-otp-request/{username}/{mobileno}")
	public Map forgotPassword(@PathVariable String username, @PathVariable String mobileno) throws Exception {
		return loginService.forgotPassword(username, mobileno);
	}

	@GetMapping(value = "save-new-password/{username}/{mobileno}/{password}/{otp}")
	public Map saveNewPassword(@PathVariable String username, @PathVariable String mobileno,
			@PathVariable String password, @PathVariable int otp) throws Exception {
		return loginService.saveNewPassword(username, mobileno, password, otp);
	}

	@GetMapping(value = "otp-validation/{username}/{mobileno}/{otp}")
	public Map otpValidation(@PathVariable String username, @PathVariable String mobileno, @PathVariable int otp)
			throws Exception {
		return loginService.otpValidation(username, mobileno, otp);
	}

	// Ajith

	@GetMapping(value = "getcountryid")
	public List getcountryid() throws Exception {
		return loginService.getcountryid();
	}

	@GetMapping(value = "user-new-password-create/{username}/{password}")
	public ResponseEntity<Boolean> createNewPassword(@PathVariable String username, @PathVariable String password) throws Exception {
		return loginService.createNewPassword(username, password);
	}

	@GetMapping(value = "check-existing-domain/{domainname}")
	public boolean Checkdomain(@PathVariable String domainname) throws Exception {
		return loginService.CheckDomain(domainname);
	}

	@GetMapping(value = "vertical-name-list")
	public List Verticallist() throws Exception {
		return loginService.Verticallist();
	}

}
