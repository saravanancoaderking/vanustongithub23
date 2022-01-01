package com.medeil.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.medeil.service.tstserviceimpl53;

@Controller
public class tstcontroller24 {

	@Autowired
	tstserviceimpl53 patientService;

	@ResponseBody
	@RequestMapping("/foobar349")
	public List fooBar() throws Exception {

		return patientService.viewcustomer();
	}

	@ResponseBody
	@RequestMapping("/foobar367")
	public void saveCustomerList() throws Exception {

	}

	@ResponseBody
	@RequestMapping("/savePat")
	public void savePatient23() throws Exception {

		patientService.saveCustomer();

	}

}
