package com.medeil.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.medeil.domain.generalAssert;
import com.medeil.service.AssertService;

@SuppressWarnings("rawtypes")
@RestController
@RequestMapping("api")
public class AssertController {
	@Autowired
	private AssertService assertSer;


	@ResponseBody
	@RequestMapping(value = "/saveassert", method = RequestMethod.POST)
	public boolean saveAssert(@RequestBody generalAssert gnrlassert) throws Exception {
		return assertSer.saveAssert(gnrlassert);
	}
}
