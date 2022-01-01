package com.medeil.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.medeil.domain.IndCompModel;
import com.medeil.domain.TaskManager;
import com.medeil.service.TskMgrService;

@Controller
@RequestMapping("api/tm")
public class TskMgrController {

	@Autowired
	TskMgrService tmService;

	private final Logger log = LoggerFactory.getLogger(TskMgrController.class);

	@ResponseBody
	@RequestMapping(value = "/saveTskMgr")
	public int saveTskMgr(@RequestBody List<TaskManager> tm) throws Exception {

		return tmService.saveTskMgr(tm);

	}

	@ResponseBody
	@RequestMapping("/viewTskMgrAll")
	public List viewTskMgrAll(@RequestBody IndCompModel loc) throws Exception {

		return tmService.viewTskMgrAll(loc);
	}

	@ResponseBody
	@RequestMapping("/viewTskMgr")
	public List viewTskMgr(@RequestBody IndCompModel loc) throws Exception {

		return tmService.viewTskMgr(loc);
	}

	@ResponseBody
	@RequestMapping("/viewTmEmployees")
	public List viewEmployees(@RequestBody IndCompModel loc) throws Exception {

		return tmService.viewEmployees(loc);
	}

	@ResponseBody
	@RequestMapping("/deleteTskMgr")
	public int deleteTskMgr(@RequestBody IndCompModel loc) throws Exception {

		return tmService.deleteTskMgr(loc);
	}

}
