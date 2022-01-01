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

import com.medeil.domain.Domain;
import com.medeil.service.DomainService;

/**
 * @author VANUSTON ( AJITH AK )
 *
 */
@SuppressWarnings("rawtypes")
@RestController
@RequestMapping("/api")
public class DomainController {

	@Autowired
	private DomainService domainservice;

	@PostMapping(value = "/savedomains")
	public ResponseEntity<Domain> saveDomain(@RequestBody Domain domain) throws Exception {
		return domainservice.saveDomain(domain);
	}

	@GetMapping(value = "/get-domain-by-country-and-product/{countryid}/{productid}")
	public List getDomainByCountryAndProduct(@PathVariable int countryid, @PathVariable int productid)
			throws Exception {
		return domainservice.getDomainByCountryAndProduct(countryid, productid);
	}

	@GetMapping(value = "/domainProduct/{id}")
	public List getProduct(@PathVariable Integer id) throws Exception {
		return domainservice.getProduct(id);
	}

	@GetMapping(value = "/domainlists")
	public List domainList() throws Exception {
		return domainservice.domainList();
	}

	@GetMapping(value = "domain-country-dropdown")
	public List domainCountryDropdown() throws Exception {
		return domainservice.domainCountryDropdown();
	}

//	@GetMapping(value = "/checkExistproduct/{cid}/{pid}/{dname}")
//	public Integer checkProduct(@PathVariable("cid") Integer cid, @PathVariable("pid") Integer pid,
//			@PathVariable("dname") String dname) {
//		return domainservice.checkProduct(cid, pid, dname);
//	}
}