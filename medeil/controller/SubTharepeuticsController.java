package com.medeil.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.medeil.domain.SubTherapeutic;
import com.medeil.service.SubTherapeuticsService;

@RestController
@RequestMapping("/api")
public class SubTharepeuticsController {

	@Autowired
	SubTherapeuticsService subTherapeuticService;

	@GetMapping(value = "/loadtharapeutics")
	public List getTherapeutics() throws Exception {
		return subTherapeuticService.LoadTherapeutics();
	}

	@PostMapping(value = "/savesubtherapeutic")
	public SubTherapeutic saveTherapeutics(@RequestBody SubTherapeutic thra) throws Exception {
		return subTherapeuticService.saveTharapetics(thra);
	}

	@PostMapping(value = "/updatesubtherapeutic")
	public SubTherapeutic updateTherapeutics(@RequestBody SubTherapeutic thra) throws Exception {
		System.out.println("therapeuticsupdate");
		return subTherapeuticService.saveTharapetics(thra);
	}

	@GetMapping(value = "/issubtherapeuticsexist/{tname}/{stname}")
	public boolean isSubTherapeuticExist(@PathVariable Integer tname, @PathVariable String stname) throws Exception {
		System.out.println("Subthereapetics" + tname + stname);
		return subTherapeuticService.isSubTherapeuticExist(tname, stname);
	}

	@GetMapping(value = "/viewsubtherapeuticurl")
	public List viewThrepautic() throws Exception {
		System.out.println("viewiscalling");
		return subTherapeuticService.viewTherapeutic();
	}

	@GetMapping(value = "/getsubtherabyid/{id}")
	public SubTherapeutic getSubTherapeutic(@PathVariable Integer id) throws Exception {
		return subTherapeuticService.getSubTherapeutic(id);
	}

	@GetMapping(value = "/isSubTherapeuticUpdateExist/{tid}/{tname}/{stid}")
	public boolean isTherapeuticUpdateExist(@PathVariable Integer tid, @PathVariable String tname,
			@PathVariable Integer stid) throws Exception {
		System.out.println("therapeutic  uptads is calling" + tname + tid + stid);
		return subTherapeuticService.isTherapeuticUpdateExist(tid, tname, stid);
	}

	@GetMapping(value = "/deletesubtherapeutic/{id}")
	public boolean deleteTherapeutic(@PathVariable Integer id) throws Exception {
		return subTherapeuticService.deleteTherapeutic(id);
	}

	@GetMapping(value = "/viewindentstatusurl")
	public List viewIndentStatus() throws Exception {
		return subTherapeuticService.viewIndentStatus();
	}

}
