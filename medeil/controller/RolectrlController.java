package com.medeil.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.medeil.domain.Editionctrl;
import com.medeil.domain.Rolectrl;
import com.medeil.service.RolectrlService;

@SuppressWarnings("rawtypes")
@RestController
@RequestMapping("api")
public class RolectrlController {

	@Autowired
	private RolectrlService rolectrlService;

	@PostMapping(value = "ctrldata")
	public void ctrlRole(@RequestBody List<Rolectrl> rolectrl) throws Exception {
		rolectrlService.ctrlRole(rolectrl);
	}

	@GetMapping(value = "getRolename/{id}")
	public String setRole(@PathVariable Integer id) throws Exception {
		return rolectrlService.setRole(id);
	}

	@GetMapping(value = "roleModulelist/{id}")
	public List listModule(@PathVariable Integer id) throws Exception {
		return rolectrlService.listModule(id);
	}

	@GetMapping(value = "roleSubmoduleList/{id}")
	public List submodule(@PathVariable Integer id) throws Exception {
		return rolectrlService.subModule(id);
	}

	@GetMapping(value = "isRoleExist/{rid}/{mid}")
	public Boolean isExistRole(@PathVariable Integer rid, @PathVariable Integer mid) throws Exception {
		return rolectrlService.isExistRole(rid, mid);
	}

	@GetMapping(value = "viewAssignRole/{id}")
	public List getAssignRole(@PathVariable Integer id) throws Exception {
		return rolectrlService.getAssignRole(id);
	}

	@GetMapping(value = "deleteAssignRole/{id}")
	public void delAssignRole(@PathVariable Integer id) throws Exception {
		rolectrlService.delAssignRole(id);
	}

	@PostMapping(value = "/saverolectrl")
	public ResponseEntity<Boolean> saveRolectrl(@RequestBody List<Rolectrl> rolectrls) throws Exception {
		return rolectrlService.saveRolectrl(rolectrls);
	}
}
