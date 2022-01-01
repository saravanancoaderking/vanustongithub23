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
import com.medeil.domain.IndentConfirm;
import com.medeil.domain.IndentProducts;
import com.medeil.service.IndConfirmService;
import com.medeil.service.PatientService;

@Controller
@RequestMapping("api/indappr")
public class IndtConfirmController {

	@Autowired
	IndConfirmService indConfirmService;

	private final Logger log = LoggerFactory.getLogger(PatientService.class);

	@ResponseBody
	@RequestMapping(value = "/saveIndentConfirm")
	public int saveIndentConfirm(@RequestBody IndentConfirm indt) throws Exception {

		return indConfirmService.saveIndentConfirm(indt);

	}

	@ResponseBody
	@RequestMapping(value = "/saveIndentConfirmProd")
	public int saveIndentConfirmProd(@RequestBody List<IndentProducts> indt) throws Exception {

		return indConfirmService.saveIndentConfirmProd(indt);

	}

	@ResponseBody
	@RequestMapping("/updateIndentConfirm")
	public int updateIndentConfirm(@RequestBody List<IndentConfirm> indt) throws Exception {

		return indConfirmService.updateIndentConfirm(indt);

	}

	@ResponseBody
	@RequestMapping("/viewIndentreq")
	public List viewIndentreq(@RequestBody IndCompModel loc) throws Exception {

		return indConfirmService.viewIndentreq(loc);
	}

	@ResponseBody
	@RequestMapping("/viewSelIndentproduct")
	public List viewSelIndentproduct(@RequestBody IndCompModel loc) throws Exception {

		return indConfirmService.viewSelIndentproduct(loc);
	}

	@ResponseBody
	@RequestMapping("/viewIndentConfirmAll")
	public List viewIndentConfirmAll(@RequestBody IndCompModel loc) throws Exception {

		return indConfirmService.viewIndentConfirmAll(loc);
	}

	@ResponseBody
	@RequestMapping("/viewIndentConfirmNo")
	public List viewIndentConfirmNo(@RequestBody IndCompModel loc) throws Exception {

		return indConfirmService.viewIndentConfirmNo(loc);
	}

	@ResponseBody
	@RequestMapping("/viewLocName")
	public List viewLocName(@RequestBody IndCompModel loc) throws Exception {

		return indConfirmService.viewLocName(loc);
	}

	@ResponseBody
	@RequestMapping("/viewIndentReqSelect")
	public List viewIndentReqSelect(@RequestBody IndCompModel loc) throws Exception {

		return indConfirmService.viewIndentReqSelect(loc);
	}

}
