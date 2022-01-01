package com.medeil.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.medeil.domain.Therapeutic;
import com.medeil.repository.ThrepeuticRepository;
import com.medeil.service.TherapeuticService;

@RestController
@RequestMapping("/api")
public class TherapeuticController {

	@Autowired
	ThrepeuticRepository threpeuticRepository;

	@Autowired
	TherapeuticService therapeuticService;

	@PostMapping(value = "/savetherapeutic")
	public Therapeutic saveTherapeutics(@RequestBody Therapeutic thra) throws Exception {
		return therapeuticService.saveTharapetics(thra);
	}

	@PostMapping(value = "/updatetherapeutic")
	public Therapeutic updateTherapeutics(@RequestBody Therapeutic thra) throws Exception {
		System.out.println("therapeuticsupdate");
		return therapeuticService.saveTharapetics(thra);
	}

	@GetMapping(value = "/isexisttherapeutic/{tname}")
	public boolean isTherapeuticExist(@PathVariable String tname) throws Exception {
		return therapeuticService.isTherapeuticExist(tname);
	}

	@GetMapping(value = "/viewtherapeutic")
	public List viewThrepautic() throws Exception {
		return therapeuticService.viewTherapeutic();
	}

	@GetMapping(value = "/gettherabyid/{id}")
	public Therapeutic getTherapeutic(@PathVariable Integer id) throws Exception {
		return therapeuticService.getTherapeutic(id);
	}

	@GetMapping(value = "/isTherapeuticUpdateExist/{tname}/{tid}")
	public boolean isTherapeuticUpdateExist(@PathVariable String tname, @PathVariable Integer tid) throws Exception {
		System.out.println("therapeutic is calling" + tname + tid);
		return therapeuticService.isTherapeuticUpdateExist(tname, tid);
	}

	@GetMapping(value = "/deletetherapeutic/{id}")
	public boolean deleteTherapeutic(@PathVariable Integer id) throws Exception {
		return therapeuticService.deleteTherapeutic(id);
	}

}
