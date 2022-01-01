package com.medeil.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.medeil.domain.EmpEval;
import com.medeil.service.EmpEvalService;

@SuppressWarnings("rawtypes")
@RestController
@RequestMapping("/api")
public class EmpEvalController {
	
	@Autowired
	private EmpEvalService empEvalService;
	
	private static Logger logger = LogManager.getLogger();

	
	@PostMapping(value = "/saveEmpEvaluation")
	public boolean saveEmpEval(@RequestBody EmpEval empEval) throws Exception {

		System.out.println(empEval);
		return empEvalService.saveEmpEval(empEval);
	}
}
