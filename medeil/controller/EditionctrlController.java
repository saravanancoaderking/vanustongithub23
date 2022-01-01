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
import com.medeil.service.EditionctrlService;

@SuppressWarnings("rawtypes")
@RestController
@RequestMapping("/api")
public class EditionctrlController {

	@Autowired
	private EditionctrlService editionctrlService;

	@GetMapping(value = "/seteditionname/{id}")
	public List getEditionname(@PathVariable Integer id) throws Exception {
		return editionctrlService.getEditionname(id);
	}

	@GetMapping(value = "/setSubdomainname/{id}")
	public List subDomainname(@PathVariable Integer id) throws Exception {
		return editionctrlService.subDomainname(id);
	}

	@GetMapping(value = "/setModulelist/{id}")
	public List getModulelist(@PathVariable Integer id) throws Exception {
		return editionctrlService.getModulelist(id);
	}

	@GetMapping(value = "/setsubModulelist/{eid}/{id}")
	public List getsubModulelist(@PathVariable Integer eid, @PathVariable List<Integer> id) throws Exception {
		return editionctrlService.getsubModulelist(eid, id);
	}

//	@PostMapping(value = "/saveAssignmodule")
//	public boolean saveEditioncontrol(@RequestBody Object obj) throws Exception {
//		return editionctrlService.saveEditioncontrol(obj);
//	}

	@PostMapping(value = "/saveAssignmodule")
	public ResponseEntity<Boolean> saveEditioncontrol(@RequestBody List<Editionctrl> editionctrl) throws Exception {
		return editionctrlService.saveEditioncontrol(editionctrl);
	}

	// Boopalan 260619
	@GetMapping(value = "/getAssignModule/{id}")
	public List getModuleAssign(@PathVariable Integer id) throws Exception {
		return editionctrlService.getModuleAssign(id);
	}

	@GetMapping(value = "/checkEditionid/{id}")
	public boolean getEditionID(@PathVariable Integer id) throws Exception {
		return editionctrlService.getEditionID(id);
	}

	@GetMapping(value = "/getlablename/{eid}")
	public List getlablename(@PathVariable Integer eid) throws Exception {
		return editionctrlService.getlablename(eid);
	}

	@GetMapping(value = "/getmodulename/{eid}/{lname}")
	public List getmodulename(@PathVariable Integer eid,@PathVariable String lname) throws Exception {
		return editionctrlService.getmodulename(eid,lname);
	}

	@GetMapping(value = "/getsubmodulename/{eid}/{mid}")
	public List getsubmodulename(@PathVariable Integer eid, @PathVariable Integer mid) throws Exception {
		return editionctrlService.getsubmodulename(eid, mid);
	}
	
	@GetMapping(value = "/getselectedsubmodules/{eid}")
	public List getselectedsubmodulename(@PathVariable Integer eid) throws Exception {
		return editionctrlService.getselectedsubmodulename(eid);
	}

//	//edition process
	@GetMapping(value = "/geteditionwisemodulename/{editionid}")
	public List geteditionmodule(@PathVariable Integer editionid) throws Exception {
		return editionctrlService.geteditionmodule(editionid);
	}

}
