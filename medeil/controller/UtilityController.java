/**
 * 
 */
package com.medeil.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.medeil.service.UtilityService;

/**
 * @author Ajith
 *
 */
@SuppressWarnings("rawtypes")
@RestController
@RequestMapping("/api")
public class UtilityController {

	// return "redirect:/getUser"; its using spring mvc return one url into
	// another url methods
	@Autowired
	private UtilityService utilityService;

	private static Logger logger = LogManager.getLogger();
	List<String> files = new ArrayList<String>();

	@GetMapping(value = "/getCountry")
	public List getCountry() throws Exception {
		return utilityService.getCountry();
	}

	@GetMapping(value = "/getState/{countryid}")
	public List getState(@PathVariable Integer countryid) throws Exception {
		return utilityService.getState(countryid);
	}

	@GetMapping(value = "/getCountrycode/{countryid}")
	public List Countrycode(@PathVariable Integer countryid) throws Exception {
		return utilityService.getCountrycode(countryid);
	}

	@GetMapping(value = "/getCity/{sid}")
	public List getCity(@PathVariable Integer sid) throws Exception {
		return utilityService.getCity(sid);
	}

	@GetMapping("/getVat")
	public List getTax() throws Exception {
		return utilityService.getVat();
	}

	@GetMapping("/getGst")
	public List getGst() throws Exception {
		return utilityService.getGst();
	}

	@GetMapping("/getSgst")
	public List getSgst() throws Exception {
		return utilityService.getSgst();
	}

	@GetMapping("/getCgst")
	public List getCgst() throws Exception {
		return utilityService.getCgst();
	}

	@GetMapping("/getIgst")
	public List getIgst() throws Exception {
		return utilityService.getIgst();
	}

	// *****Upload Files****
	/*
	 * @PostMapping(value = "/uploadphoto") public String
	 * handleFileUpload1(@RequestPart("file") MultipartFile[] file) throws
	 * IOException { String message = ""; try { utilityService.store(file); message
	 * = "You successfully uploaded"; return message; } catch (Exception e) throws
	 * Exception { message = "FAIL to upload Images"; logger.error(message); return
	 * message; } }
	 * 
	 * @PostMapping(value = "/modifyuploadphoto/{id}") public String
	 * modifyFileUpload(@PathVariable Integer id, @RequestPart("file")
	 * MultipartFile[] file) throws IOException { String message = ""; try {
	 * utilityService.storeModify(file, id); message = "You successfully uploaded";
	 * return message; } catch (Exception e) throws Exception { message =
	 * "FAIL to upload Images"; logger.error(message); return message; } }
	 * 
	 * @GetMapping(value = "/getUploadfiles/{id}") public @ResponseBody Map<String,
	 * String> getImage(@PathVariable String id) throws IOException { return
	 * utilityService.getuploadedImage(id); }
	 */
	// *********************************************

	@ResponseBody
	@RequestMapping(value = "/getmac")
	public List getMac() throws Exception {
		return utilityService.getMacs();
	}

	@ResponseBody
	@RequestMapping(value = "/getClientmac")
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {

		// Get client's IP address
		String ipAddress = req.getRemoteAddr(); // ip
		System.out.println("ipAddress : " + ipAddress);
		// Get client's hostname
		String hostname = req.getRemoteHost(); // hostname
		System.out.println("hostname : " + hostname);
	}
	// mani
	/*
	 * @GetMapping(value = "/getAutoIncrements") public List getAutoIncrments1()
	 * throws Exception { return utilityService.getAutoincrement1(); }
	 */

	@GetMapping(value = "/getbranchCompanies")
	public List getCompany() throws Exception {
		return utilityService.getCompany();
	}

	// Mani
	@GetMapping(value = "/getCompanies/{comp}")
	public List getCompany(@PathVariable Integer comp) throws Exception {
		return utilityService.getCompany(comp);
	}

	@GetMapping(value = "/getCountryMap")
	public List getCountryMap() throws Exception {
		return utilityService.getCountryMap();
	}

	@GetMapping(value = "/getSample/{term}")
	public List getSample(@PathVariable String term) throws Exception {
		return utilityService.getSample(term);
	}

	// selva
	@GetMapping(value = "/getAllCompanies")
	public List getAllCompany() throws Exception {
		return utilityService.getAllCompany();
	}
	// mani
	/*
	 * @GetMapping(value = "/getPOAutoIncrements") public List getAutoIncrments()
	 * throws Exception { return utilityService.getAutoincrement(); }
	 */

}
