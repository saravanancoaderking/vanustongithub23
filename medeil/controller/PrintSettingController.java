package com.medeil.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Base64;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

import com.medeil.domain.Printimages;
import com.medeil.domain.Printsetting;
import com.medeil.service.Printsettingservice;

@RestController
@RequestMapping("/api")
public class PrintSettingController {

	@Autowired
	Printsettingservice PrintSettingServices;

	// view default print forms
	@GetMapping(value = "/viewdefaultprintforms")
	public List viewDefaultforms() throws Exception {
		return PrintSettingServices.viewDefaultforms();
	}

	// view print settings shopwise
	@GetMapping(value = "/viewprintsettings/{companyid}/{branchid}/{locname}/{locrefid}")
	public List viewEnableStatus(@PathVariable int companyid, @PathVariable int branchid, @PathVariable int locname,
			@PathVariable int locrefid) throws Exception {
		return PrintSettingServices.viewprintsettings(companyid, branchid, locname, locrefid);
	}

	// view print Model on forms shopwise
	@GetMapping(value = "/viewformsprintmodel/{companyid}/{branchid}/{locname}/{locrefid}/{formid}")
	public List viewEnableStatus(@PathVariable int companyid, @PathVariable int branchid, @PathVariable int locname,
			@PathVariable int locrefid, @PathVariable int formid) throws Exception {
		return PrintSettingServices.viewformsprintmodel(companyid, branchid, locname, locrefid, formid);
	}

	// save/Update print forms
	@PostMapping(value = "saveprintsettings")
	public ResponseEntity<Boolean> saveprintsettings(@RequestBody List<Printsetting> savesettings) throws Exception {
		return PrintSettingServices.saveprintsettings(savesettings);
	}

	// in developer side save Print imageRecord
	@PostMapping(value = "saveprintimagerecord")
	public ResponseEntity<Printimages> saveprintimagerecord(@RequestBody Printimages printimage) throws Exception {
		return PrintSettingServices.saveprintimagerecord(printimage);
	}

	// save print image
	@PostMapping("saveprintimage")
	public boolean handleImagePost(@RequestParam("file") MultipartFile file) throws IOException, Exception {
		return PrintSettingServices.saveImageFile(file);
	}
	
	@PostMapping("updateprintimage/{imageid}")
	public boolean UpdateImagePost(@RequestParam("file") MultipartFile file,@PathVariable int imageid) throws IOException, Exception {
		return PrintSettingServices.UpdateImageFile(file,imageid);
	}

	// get view printed images
	@GetMapping(value = "printimageview/{formid}/{printtypeid}")
	public List printimageview(@PathVariable Integer formid, @PathVariable Integer printtypeid)
			throws IOException, Exception {
		List output = new ArrayList();
		// try {
		List<byte[]> path = PrintSettingServices.getsendImage(formid, printtypeid);
		System.out.println(">>>>>>>>>>>11111111");
		List printimagevalues = PrintSettingServices.getprintimagevalues(formid, printtypeid);
		path.forEach(p -> {
			Map<String, Object> list = new HashMap<String, Object>();
			String encodeImage = Base64.getEncoder().encodeToString(p);
			list.put("imageurl", encodeImage);
			list.put("imagevalues", printimagevalues);
			output.add(list);
		});
		return output;
		// } catch (Exception e) {
		// e.printStackTrace();
		// return output;
		// }
	}

}
