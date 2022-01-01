package com.medeil.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.medeil.domain.IndCompModel;
import com.medeil.domain.StockAdjust;
import com.medeil.service.StkAdjService;

@Controller
@RequestMapping("api/stkadj")
public class StkAdjController {

	@Autowired
	StkAdjService stkadjService;

	private final Logger log = LoggerFactory.getLogger(StkAdjController.class);

	@ResponseBody
	@RequestMapping(value = "/saveStockAdjust")
	public int saveStockAdjust(@RequestBody List<StockAdjust> dist) throws Exception {

		return stkadjService.saveStockAdjust(dist);

	}

	@ResponseBody
	@RequestMapping(value = "/updateStockAdjust")
	public int updateStockAdjust(@RequestBody List<StockAdjust> dist) throws Exception {

		return stkadjService.updateStockAdjust(dist);

	}

	@ResponseBody
	@RequestMapping("/viewSADMainstocks")
	public List viewMainstocks(@RequestBody IndCompModel loc) throws Exception {
		return stkadjService.viewMainstocks(loc);

	}

	@ResponseBody
	@RequestMapping("/viewSADMainstock")
	public List viewMainstock(@RequestBody IndCompModel loc) throws Exception {

		return stkadjService.viewMainstock(loc);

	}

	@ResponseBody
	@RequestMapping("/viewStockAdjAll")
	public List viewStockAdjAll(@RequestBody IndCompModel loc) throws Exception {
		return stkadjService.viewStockAdjAll(loc);

	}

	@ResponseBody
	@RequestMapping("/viewStockAdjust")
	public List viewStockAdjust(@RequestBody IndCompModel loc) throws Exception {
		return stkadjService.viewStockAdjust(loc);

	}

	@ResponseBody
	@RequestMapping("/deleteStockAdj")
	public int deleteStockAdj(@RequestBody IndCompModel loc) throws Exception {
		return stkadjService.deleteStockAdj(loc);

	}

	@ResponseBody
	@RequestMapping("/viewmul75")
	public List deleteStockAdj(@RequestParam("file") MultipartFile file) throws Exception {
		return stkadjService.viewStockAdjAll57(file);

	}

}
