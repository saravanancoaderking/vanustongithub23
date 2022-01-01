/**
 * 
 */
package com.medeil.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.medeil.domain.Company;
import com.medeil.service.CompanyService;
import com.medeil.service.PhcompanyService;

/**
 * @author Ajith
 *
 */
@SuppressWarnings("rawtypes")
@RestController
@RequestMapping("api")
public class CompanyController {

	@Autowired
	private CompanyService companyService;

	@Autowired
	PhcompanyService phcomService;

	@GetMapping(value = "/getPharmacompany/{value}")
	public List getPharmacompany(@PathVariable String value)throws Exception {
		return phcomService.getPharmacompany(value);
	}

	@GetMapping(value = "/getproductinfo/{id}")
	public List getProductInfo(@PathVariable Integer id)throws Exception {
		return companyService.getProduct(id);
	}

	@GetMapping(value = "/getDomain/{cid}/{pid}")
	public List getDomain(@PathVariable Integer cid, @PathVariable Integer pid)throws Exception {
		return companyService.getDomain(cid, pid);
	}

	@GetMapping(value = "/getsubDomain/{cid}/{pid}/{did}")
	public List subDomain(@PathVariable Integer cid, @PathVariable Integer pid, @PathVariable Integer did)throws Exception {
		return companyService.subDomain(cid, pid, did);
	}

	@GetMapping(value = "/getEdition/{cid}/{pid}/{did}/{sdid}")
	public List getEdition(@PathVariable Integer cid, @PathVariable Integer pid, @PathVariable Integer did,
			@PathVariable Integer sdid)throws Exception {
		return companyService.editionInfo(cid, pid, did, sdid);
	}

	@PostMapping(value = "/saveCompanyinfo")
	public Company saveCompany(@RequestBody Company company)throws Exception {
		return companyService.saveCompany(company);
	}

	@PostMapping(value = "/updateCompanyinfo")
	public Company updateCompany(@RequestBody Company company)throws Exception {
		return companyService.updateCompany(company);
	}

	@GetMapping(value = "/viewcompanypRecord/{pageno}/{size}")
	public Page viewcompInfo(@PathVariable Integer pageno, @PathVariable Integer size)throws Exception {
		return companyService.viewCompany(pageno, size);
	}

	@GetMapping(value = "/deletecompRecord/{id}")
	public void deleteCompany(@PathVariable Integer id)throws Exception {
		companyService.deleteCompany(id);
	}

	@GetMapping(value = "/compid/{id}")
	public Company compEdit(@PathVariable Integer id)throws Exception {
		return companyService.editValues(id);
	}

	// **** Company Inforamtion Edit Form's Methods Calling(Controller)****//

	@GetMapping(value = "/geteditState/{id}")
	public List compeditState(@PathVariable Integer id)throws Exception {
		return companyService.editState(id);
	}

	@GetMapping(value = "/geteditCcode/{id}")
	public List compeditCcode(@PathVariable Integer id)throws Exception {
		return companyService.compeditCcode(id);
	}

	@GetMapping(value = "/geteditCity/{id}")
	public List compeditCity(@PathVariable Integer id)throws Exception {
		return companyService.compeditCity(id);
	}

	@GetMapping(value = "/geteditproductinfo/{id}")
	public List geteditProductInfo(@PathVariable Integer id)throws Exception {
		return companyService.geteditProduct(id);
	}

	@GetMapping(value = "/geteditDomain/{id}")
	public List geteditDomain(@PathVariable Integer id)throws Exception {
		return companyService.geteditDomain(id);
	}

	@GetMapping(value = "/geteditsubDomain/{id}")
	public List subeditDomain(@PathVariable Integer id)throws Exception {
		return companyService.subeditDomain(id);
	}

	@GetMapping(value = "/geteditEdition/{id}")
	public List geteditEdition(@PathVariable Integer id)throws Exception {
		return companyService.editioneditInfo(id);
	}

	@GetMapping(value = "/getMain")
	public List mains()throws Exception {
		return companyService.main();
	}

	@GetMapping(value = "/getComopcounts")
	public Integer getComopcount()throws Exception {
		return companyService.getComopcount();
	}

	@GetMapping(value = "/catalogs")
	public String login()throws Exception {
		String jwtToken = "Cata Log";
		return jwtToken;
	}
	
	@GetMapping(value = "/get-pharmacompany-list/{locrefid}/{pharmaname}")
	public ResponseEntity<?> getPharmacompanyList(@PathVariable Integer locrefid, @PathVariable String pharmaname)
			throws Exception {
		return phcomService.getPharmacompanyList(locrefid, pharmaname);
	}


}
