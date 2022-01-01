package com.medeil.controller;

import java.util.List;

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

import com.medeil.domain.Submodules;
import com.medeil.service.SubmodulesService;

@SuppressWarnings("rawtypes")
@RestController
@RequestMapping("/api")
public class SubmodulesController {
	// get Sub modules
	@Autowired
	SubmodulesService service;

	@GetMapping(value = "/addsubmodule", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Submodules> getAll() throws Exception {

		return service.getAll();
	}

	// post sub modules

	@PostMapping(value = "/postsubmodule")
	public ResponseEntity<Submodules> postsubmodule(@RequestBody Submodules modules) throws Exception {

		return service.postsubmodule(modules);

	}

	// view
	@GetMapping(value = "/submoduleslist", produces = MediaType.APPLICATION_JSON_VALUE)
	public List SubModulelist() throws Exception {

		return service.SubModulelist();
	}

	// get country
	@GetMapping(value = "/submoduleid", produces = MediaType.APPLICATION_JSON_VALUE)
	public List countryaccess() throws Exception {

		return service.countryaccess();

	}
	// get product byid

	@GetMapping(value = "/domainlistsub/{id}")
	public List Product(@PathVariable long id) throws Exception {

		return service.Product(id);

	}

	// get domain name

	@GetMapping(value = "/domainnamesub/{ct}/{pdt}")
	public List domain(@PathVariable long ct, @PathVariable long pdt) throws Exception {

		System.out.println("domainnamesub");
		return service.domain(ct, pdt);

	}

	// get subdomain name
	@GetMapping(value = "/subdomainname/{ct}/{pdt}/{dm}")
	public List subdomain(@PathVariable long ct, @PathVariable long pdt, @PathVariable long dm) throws Exception {

		return service.subdomain(ct, pdt, dm);

	}
	// get modules

	@GetMapping(value = "/submodulesname/{ct}/{pdt}/{dm}/{sm}")
	public List submodmodules(@PathVariable long ct, @PathVariable long pdt, @PathVariable long dm,
			@PathVariable long sm) throws Exception {

		return service.submodmodules(ct, pdt, dm, sm);

	}

	// update
	@PutMapping(value = "/addsubmodules/{id}")
	public ResponseEntity<Submodules> updateSubModules(@RequestBody Submodules submodules,
			@PathVariable long SubModuleID) throws Exception {

		return service.postsubmodule(submodules);
	}

	// Delete subModule
	@GetMapping(value = "/delete-submodule/{id}")
	public ResponseEntity<Boolean> deletesubModules(@PathVariable long id) throws Exception {

		return service.delete(id);
	}

	@GetMapping(value = "/submodules-names-dropdown/{countryid}/{productid}/{domainid}/{subdomainid}/{moduleid}")
	public List getSubModulesNameDropdown(@PathVariable int countryid, @PathVariable int productid,
			@PathVariable int domainid, @PathVariable int subdomainid, @PathVariable int moduleid) throws Exception {
		return service.getSubModulesNameDropdown(countryid, productid, domainid, subdomainid, moduleid);
	}
}
