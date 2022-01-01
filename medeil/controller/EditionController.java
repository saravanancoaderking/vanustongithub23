
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

import com.medeil.domain.Edition;
import com.medeil.domain.Role;
import com.medeil.service.EditionService;

@SuppressWarnings("rawtypes")
@RestController
@RequestMapping("api")
public class EditionController {

	@Autowired
	private EditionService editionService;

	/*** ADD EDITION ***/
	@GetMapping(value = "editionproduct/{id}")
	public List getProduct(@PathVariable Integer id)throws Exception  {
		return editionService.getProduct(id);
	}

	@GetMapping(value = "editiondomains/{cid}/{pid}")
	public List getDomainlist(@PathVariable("cid") Integer cid, @PathVariable("pid") Integer pid)throws Exception  {
		return editionService.getDomainlist(cid, pid);
	}

	@GetMapping(value = "editionsubdomain/{cid}/{pid}/{did}")
	public List getSubdomain(@PathVariable("cid") Integer cid, @PathVariable("pid") Integer pid,
			@PathVariable("did") Integer did)throws Exception  {
		return editionService.getsubdomain(cid, pid, did);
	}

	@GetMapping(value = "checkeditionname/{cid}/{pid}/{did}/{sdid}/{editionName}/{editionVersion:.*}") 
	public Integer getCheckEdition(@PathVariable("cid") Integer cid, @PathVariable("pid") Integer pid,@PathVariable("did") Integer did, @PathVariable("sdid") Integer sdid,@PathVariable("editionName") String editionName, @PathVariable("editionVersion") String editionVersion) throws Exception
			{
		return editionService.getCheckEdition(cid, pid, did, sdid, editionName, editionVersion);
	}

	@PostMapping(value = "saveEditiondata")
	public ResponseEntity<Boolean> createEdition(@RequestBody Edition edition)throws Exception {
		return editionService.createEdition(edition);
	}

	/*** VIEW EDITION ***/
	@GetMapping(value = "editionlist/{ety}/{storetype}")
	public List getAll(@PathVariable Integer ety, @PathVariable Integer storetype)throws Exception {
//		return editionService.getAll(ety);		
		return editionService.getAllEditionDetails(ety,storetype);
	}

	// Ajith
	// View Currency

	@GetMapping(value = "viewcurrency/{id}")
	public List Viewcurrency(@PathVariable Integer id)throws Exception {
		return editionService.Viewcurrency(id);
	}

	@GetMapping(value = "EditionModules/{cid}/{pid}/{did}/{sdid}/{ety}")
	public List getEditionModules(@PathVariable Integer cid, @PathVariable Integer pid, @PathVariable Integer did,
			@PathVariable Integer sdid, @PathVariable Integer ety)throws Exception {
		return editionService.getEditionModules(cid, pid, did, sdid, ety);
	}

	@GetMapping(value = "EditionDetails/{eid}")
	public Object getEditiondetails(@PathVariable Integer eid)throws Exception {
		return editionService.getEditiondetails(eid);
	}
	
	@GetMapping(value = "getRoleBasedModuledetails/{status}")
	public List getRoleBasedModuledetails(@PathVariable Integer status)throws Exception {
		return editionService.getRoleBasedModuledetails(status);
	}
	
	@GetMapping(value = "getRoleIdRoleName")
	public List getRoleIdRoleName()throws Exception {
		return editionService.getRoleIdRoleName();
	}
	
	
	
}
