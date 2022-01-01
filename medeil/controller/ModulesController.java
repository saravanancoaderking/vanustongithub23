/**
 * 
 */
package com.medeil.controller;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.medeil.domain.Modules;
import com.medeil.service.ModulesService;

/**
 * @author add modules *
 */

@SuppressWarnings("rawtypes")
@RestController
@RequestMapping("/api")
public class ModulesController {
	// get modules
	@Autowired
	ModulesService service;

	@GetMapping(value = "/addmodule", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Modules> getAll() throws Exception {

		return service.getAll();
	}

	// get country modulesid

	@GetMapping(value = "/modulesid", produces = MediaType.APPLICATION_JSON_VALUE)
	public List modules() throws Exception {

		return service.modules();

	}

	// view
	@GetMapping(value = "/moduledomainlist", produces = MediaType.APPLICATION_JSON_VALUE)
	public List Modulelist() throws Exception {

		System.out.println("hi module list");
		return service.Modulelist();
	}

	// get products by id
	@GetMapping(value = "/modulesubdomainproduct/{id}")
	public List Product(@PathVariable long id) throws Exception {
		System.out.println("product");
		return service.Product(id);

	}

	// get domain by id
	@GetMapping(value = "/domainbyid/{id1}/{id2}")
	public List domain(@PathVariable long id1, @PathVariable long id2) throws Exception {
		System.out.println("domain");
		return service.domain(id1, id2);

	}

	// get sub domain by id
	@GetMapping(value = "/subdomainid/{id1}/{id2}/{id3}")
	public List subdomain(@PathVariable long id1, @PathVariable long id2, @PathVariable long id3) throws Exception {
		System.out.println("domain");
		return service.subdomain(id1, id2, id3);

	}

	// post modules
	@PostMapping(value = "/postaddmodule")
	public ResponseEntity<Modules> postModules(@RequestBody Modules modules) throws Exception {

		return service.postModules(modules);

	}

	// update
	@PutMapping(value = "/addmodule/{id}")
	public Modules updateModules(@RequestBody Modules modules, @PathVariable long moduleID) throws Exception {

		return service.updateModules(modules, moduleID);
	}

	// Delete Module
	@GetMapping(value = "/delete-module/{id}")
	@Transactional
	public ResponseEntity<Boolean> deleteModules(@PathVariable Long id) throws Exception {

		return service.delete(id);
	}

	@GetMapping(value = "/modules-folder-dropdown/{countryid}/{productid}/{domainid}/{subdomainid}")
	public List getModulesFolderDropdown(@PathVariable int countryid, @PathVariable int productid,
			@PathVariable int domainid, @PathVariable int subdomainid) throws Exception {
		return service.getModulesFolderDropdown(countryid, productid, domainid, subdomainid);
	}

	@GetMapping(value = "/modules-names-dropdown/{countryid}/{productid}/{domainid}/{subdomainid}/{foldername}")
	public List getModulesNameDropdown(@PathVariable int countryid, @PathVariable int productid,
			@PathVariable int domainid, @PathVariable int subdomainid, @PathVariable String foldername)
			throws Exception {
		return service.getModulesNameDropdown(countryid, productid, domainid, subdomainid, foldername);
	}

}
