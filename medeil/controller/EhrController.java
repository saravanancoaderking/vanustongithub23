package com.medeil.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.medeil.domain.Ehr;
import com.medeil.domain.Ehrmaster;
import com.medeil.service.EhrService;

@RestController
@RequestMapping("api")
public class EhrController {

	@Autowired
	private EhrService ehrService; 
	
	@PostMapping("ehrReportSave")
	public ResponseEntity<Boolean> ehrReportSave(@RequestBody Ehr ehr) throws Exception {
		return ehrService.ehrReportSave(ehr);
	}
	
	@GetMapping(value = "ehrReportlist")
	public ResponseEntity<?> ehrReportlist() throws Exception {
		return ehrService.ehrReportlist();
	}

	
	@PostMapping("ehrMasterSave")
	public ResponseEntity<Boolean> ehrMasterSave(@RequestBody Ehrmaster ehrmaster) throws Exception {
		return ehrService.ehrMasterSave(ehrmaster);
	}

	@GetMapping(value = "ehrMasterlist")
	public ResponseEntity<?> ehrMasterlist() throws Exception {
		return ehrService.ehrMasterlist();
	}

	@PostMapping("ehrMasterDocumentSave")
	public ResponseEntity<Boolean> ehrMasterDocumentSave(@RequestParam("file") MultipartFile file) throws Exception {
		return ehrService.ehrMasterDocumentSave(file);
	}
	
	@GetMapping(value = "viewehrMasterlist/{cid}/{bid}/{locname}/{locrefid}")
	public List ViewMasterList(@PathVariable Integer cid, @PathVariable Integer bid, @PathVariable Integer locname,
			@PathVariable Integer locrefid) throws Exception {
		return ehrService.ViewMasterList(cid, bid, locname, locrefid);
	}

}
