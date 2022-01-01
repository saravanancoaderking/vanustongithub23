/**
 * 
 */
package com.medeil.controller;

import java.rmi.RemoteException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.medeil.service.SmsService;

/**
 * @author Ajith Kumar
 *
 */
@RestController
@RequestMapping("/api")
public class SmsController {

	@Autowired
	private SmsService smsService;

	@GetMapping(value = "/checkMobileno/{id}/{uname}/{phone}")
	public boolean checkPhonenumber(@PathVariable Integer id, @PathVariable String uname, @PathVariable String phone)
			throws Exception {
		return smsService.checkPhonenumber(id, uname, phone);
	}

	@GetMapping(value = "/checkEmailid/{id}/{uname}/{email:.*}")
	public boolean checkEmailaddress(@PathVariable Integer id, @PathVariable String uname, @PathVariable String email)
			throws Exception {
		return smsService.checkEmailaddress(id, uname, email);
	}

	@GetMapping(value = "/getForgetMail/{mail:.*}/{otp}")
	public void getForgotMail(@PathVariable String mail, @PathVariable Integer otp) throws RemoteException,Exception {
		smsService.getEmail(mail, otp);
	}

	@GetMapping(value = "/updateUserpassword/{comapnyid}/{uname}/{password}")
	public boolean updatePassword(@PathVariable(value = "comapnyid") Integer cid, @PathVariable String uname,
			@PathVariable String password) throws Exception {
		return smsService.updatePassword(cid, uname, password);
	}

	@GetMapping(value = "/getForgetphone/{phone}/{otp}")
	public String getForgotPhonenumber(@PathVariable String phone, @PathVariable Integer otp) throws Exception {
		System.out.println("phone  :" + phone);
		System.out.println("otp  :" + otp);
		return "";
	}
}
