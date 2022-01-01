/**
 * 
 */
package com.medeil.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.medeil.service.PatientService;

/**
 * @author Vanuston
 *
 */
@CrossOrigin
@SuppressWarnings("rawtypes")
@RestController
@RequestMapping("api")
public class CustomerinfoController {
	
	@Autowired
	PatientService customerinfoService;
	
	@GetMapping(value = "/getcustinfo/{compid}/{branchid}/{locname}/{locrefid}")
	public List getCustinfo(@PathVariable Integer compid,
			@PathVariable Integer branchid, @PathVariable Integer locname,
			@PathVariable Integer locrefid) throws Exception{
		return customerinfoService.getCustinfo(compid, branchid, locname,
				locrefid);
	}
	/*//selva
	@GetMapping(value = "/getcustinfo")
	public List getCustinfo1() {
		return customerinfoService.getCustinfo1();
	}*/
	@GetMapping(value = "/getcustemail/{id}")
	public List getcustemail(@PathVariable Integer id)throws Exception {
		return customerinfoService.getcustemail(id);
	}
}
