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

import com.medeil.domain.Subdomain;
import com.medeil.service.SubdomainService;

@SuppressWarnings("rawtypes")
@RestController
@RequestMapping("api")
public class SubdomainController {

	@Autowired
	private SubdomainService subdomainService;

	@GetMapping(value = "/subDomainlist")
	public List getAll() throws Exception {
		return subdomainService.getAll();
	}

	@PostMapping(value = "/saveSubdomain")
	public ResponseEntity<Subdomain> createSubDomain(@RequestBody Subdomain subdomain) throws Exception {
		return subdomainService.createSubDomain(subdomain);
	}

	@GetMapping(value = "/subdomainproduct/{id}")
	public List getProduct(@PathVariable("id") Integer id) throws Exception {
		return subdomainService.getProduct(id);
	}

	@GetMapping(value = "/getdomains/{id}")
	public List getDomain(@PathVariable("id") Integer id) throws Exception {
		return subdomainService.getDomain(id);
	}
//
//	@GetMapping(value = "/checkSubdomainproduct/{did}/{cid}/{pid}/{sdName}")
//	public Integer checkSubProduct(@PathVariable("did") Integer did, @PathVariable("cid") Integer cid,
//			@PathVariable("pid") Integer pid, @PathVariable("sdName") String pName) throws Exception {
//		return subdomainService.checkSubProduct(did, cid, pid, pName);
//	}

	@GetMapping(value = "/subdomain-dropdown")
	public List getSubdomainDropdown() throws Exception {
		return subdomainService.getSubdomainDropdown();
	}

}
