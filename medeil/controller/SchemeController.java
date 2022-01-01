package com.medeil.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.medeil.domain.IndCompModel;
import com.medeil.domain.Schemes;
import com.medeil.service.SchemeService;

@Controller
@RequestMapping("api/scheme")
public class SchemeController {

	@Autowired
	SchemeService schemeService;

	@ResponseBody
	@RequestMapping(value = "/saveScheme")
	public int saveScheme(@RequestBody Schemes sch) throws Exception {

		return schemeService.saveScheme(sch);

	}

	@ResponseBody
	@RequestMapping(value = "/updateScheme")
	public int updateScheme(@RequestBody Schemes sch) throws Exception {

		return schemeService.updateScheme(sch);

	}

	@ResponseBody
	@RequestMapping("/viewSchemeAll")
	public List viewSchemeAll(@RequestBody IndCompModel loc) throws Exception {

		return schemeService.viewSchemeAll(loc);
	}

	@ResponseBody
	@RequestMapping("/viewScheme")
	public List viewScheme(@RequestBody IndCompModel loc) throws Exception {

		return schemeService.viewScheme(loc);
	}

	@ResponseBody
	@RequestMapping("/viewSchemeEdit")
	public Schemes viewSchemeEdit(@RequestBody IndCompModel loc) throws Exception {

		return schemeService.viewSchemeEdit(loc);
	}

	@ResponseBody
	@RequestMapping("/deleteScheme")
	public int deleteScheme(@RequestBody IndCompModel loc) throws Exception {

		return schemeService.deleteScheme(loc);
	}

}
