/**
 * 
 */
package com.medeil.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.medeil.domain.Branch;
import com.medeil.service.BranchService;

/**
 * @author Manikandan
 *
 */
@SuppressWarnings("rawtypes")
@RestController
@RequestMapping("/api")
public class BranchController {

	@Autowired
	private BranchService branchService;

	@PostMapping(value = "/saveBranchUrl")
	public Branch saveBranch(@RequestBody Branch branch) throws Exception {
		System.out.println("saveBranchCalling" + branch.getCreatedby());
		return branchService.saveBranch(branch);
	}

	@PostMapping(value = "/updateBranchUrl")
	public Branch updateBranch(@RequestBody Branch branch) throws Exception {
		System.out.println("inside update Company : " + branch);
		return branchService.updateBranch(branch);
	}

	@GetMapping(value = "/viewBranchRecord/{cid}")
	public List viewbranchInfo(@PathVariable Integer cid) throws Exception {
		return branchService.viewBranch(cid);
	}

	@GetMapping(value = "/branchId/{id}")
	public Branch branchEdit(@PathVariable Integer id) throws Exception {
		return branchService.branchEdit(id);
	}

	// **** Branch Inforamtion Edit Form's Methods Calling(Controller)****//

	@GetMapping(value = "/geteditBranchState/{id}")
	public List branchEditState(@PathVariable Integer id) throws Exception {
		return branchService.branchEditState(id);
	}

	@GetMapping(value = "/geteditBranchCity/{id}")
	public List branchEditCity(@PathVariable Integer id) throws Exception {
		return branchService.branchEditCity(id);

	}

	@GetMapping(value = "/geteditBranchCcode/{id}")
	public List branchEditCcode(@PathVariable Integer id) throws Exception {
		return branchService.branchEditCcode(id);
	}

	@GetMapping(value = "/brnchId/{id}")
	public List editCompanyName(@PathVariable Integer id) throws Exception {
		return branchService.editCompanyName(id);
	}

	@GetMapping(value = "/isBranchExist/{brnch}/{compID}")
	public boolean isBranchExist(@PathVariable String brnch, @PathVariable String compID) throws Exception {
		return branchService.isBranchExist(brnch, compID);
	}

	@GetMapping(value = "/isBranchUpdateExist/{brnch}/{brnchid}/{compID}")
	public boolean isBranchUpdateExist(@PathVariable String brnch, @PathVariable String brnchid,
			@PathVariable String compID) throws Exception {
		System.out.println("braname " + brnch + "brnchid");
		return branchService.isBranchUpdateExist(brnch, brnchid, compID);
	}

	@GetMapping("/deletebranchRecord/{id}")
	public Integer deleteBranch(@PathVariable Integer id) throws Exception {
		System.out.println("deletecalling");
		return branchService.deleteBranch(id);
	}
	
	@GetMapping(value = "/Usercount/{cid}")
	public List getuscount(@PathVariable Integer cid) throws Exception {
		return branchService.getcount(cid);
	}
	
	@GetMapping(value = "getLocalnameBranch/{companyid}/{locid}")
	public List getLocalnameBranch(@PathVariable Integer locid,@PathVariable Integer companyid) throws Exception {
		return branchService.getLocalnameBranch(companyid,locid);
	}
	
	@GetMapping(value = "getBranchShop/{companyid}/{branchid}")
	public List getBranchShop(@PathVariable Integer branchid,@PathVariable Integer companyid) throws Exception {
		return branchService.getBranchShop(companyid,branchid);
	}
	
	@GetMapping(value = "getLocalnameShop/{companyid}/{locid}")
	public List getLocalnameShop(@PathVariable Integer locid,@PathVariable Integer companyid) throws Exception {
		return branchService.getLocalnameShop(companyid,locid);
	}
}
