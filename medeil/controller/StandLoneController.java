/**
 * 
 */
package com.medeil.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.medeil.service.StandLoneServices;

/**
 * @author Vanu
 *
 */
@SuppressWarnings("rawtypes")
@RestController
@RequestMapping("api")
public class StandLoneController {

	@Autowired
	StandLoneServices standLoneServices;

	@GetMapping(value = "standlonesuperadminview")
	public List SuperAdminView() throws Exception {
		return standLoneServices.SuperAdminView();
	}

	@GetMapping(value = "standloneview/{compid}/{brnchid}/{locrefid}")
	public List View(@PathVariable Integer compid, @PathVariable Integer brnchid, @PathVariable Integer locrefid)
			throws Exception {
		return standLoneServices.View(compid, brnchid, locrefid);
	}

}
