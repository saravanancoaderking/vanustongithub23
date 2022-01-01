package com.medeil.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.medeil.domain.DiscountSettings;
import com.medeil.domain.IndCompModel;
import com.medeil.service.DiscSettingsService;

@Controller
@RequestMapping("api/discsettings")
public class DiscSettingsController {

	@Autowired
	DiscSettingsService discsettingsService;

	private final Logger log = LoggerFactory.getLogger(DiscSettingsController.class);

	@ResponseBody
	@RequestMapping(value = "/saveDiscountSettings")
	public int saveDiscountSettings(@RequestBody List<DiscountSettings> disc) throws Exception {

		return discsettingsService.saveDiscountSettings(disc);

	}

	@ResponseBody
	@RequestMapping("/savePriceSettings")
	public int savePriceSettings(@RequestBody IndCompModel loc) throws Exception {

		return discsettingsService.savePriceSettings(loc);
	}

	@ResponseBody
	@RequestMapping("/viewPriceSettings")
	public List viewPriceSettings(@RequestBody IndCompModel loc) throws Exception {

		return discsettingsService.viewPriceSettings(loc);
	}

	@ResponseBody
	@RequestMapping("/viewDiscountSettings")
	public List viewDiscountSettings(@RequestBody IndCompModel loc) throws Exception {

		return discsettingsService.viewDiscountSettings(loc);
	}

}
