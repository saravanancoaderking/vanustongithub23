package com.medeil.controller;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.medeil.domain.CashManage;
import com.medeil.domain.Closeregister;
import com.medeil.domain.Journal;
import com.medeil.domain.Openregister;
import com.medeil.domain.Salescounter;
import com.medeil.service.OpeanCloseRegisterService;

@RestController
@RequestMapping("api")
public class OpenCloseRegisterController {

	@Autowired
	OpeanCloseRegisterService opeanCloseRegisterService;

	@PostMapping(value = "login-employee-openregister-save")
	public ResponseEntity<Boolean> Loginemployeeopenregister(@RequestBody Openregister openregister) throws Exception {
		return opeanCloseRegisterService.Loginemployeeopenregister(openregister);
	}

	@PostMapping(value = "logout-employee-closeregister-save")
	public ResponseEntity<Boolean> Logoutemployeecloseregister(@RequestBody Closeregister closeregister)
			throws Exception {
		return opeanCloseRegisterService.Logoutemployeecloseregister(closeregister);
	}

	@PostMapping(value = "sales-counter-save")
	public ResponseEntity<Boolean> Salescountersave(@RequestBody Salescounter salescounter) throws Exception {
		return opeanCloseRegisterService.Salescountersave(salescounter);
	}

	@GetMapping(value = "get-employee-details/{userid}")
	public List employeedetails(@PathVariable Integer userid) throws Exception {
		return opeanCloseRegisterService.employeedetails(userid);
	}

	@GetMapping(value = "get-employee-openregister-details/{userid}/{logintime}")
	public List employeeopenregisterdetails(@PathVariable Integer userid,@PathVariable String logintime) throws Exception {
		return opeanCloseRegisterService.employeeopenregisterdetails(userid,logintime);
	}

	@GetMapping(value = "get-employee-transaction-details/{userid}/{logintime}")
	public List employeetransdetails(@PathVariable Integer userid, @PathVariable String logintime) throws Exception {
		return opeanCloseRegisterService.employeetransdetails(userid, logintime);
	}

	// Puthiran View Open Close Register History
	@GetMapping(value = "view-open-register-details/{compid}/{branchid}/{locname}/{locrefid}")
	public List openregisterdetails(@PathVariable Integer compid, @PathVariable Integer branchid,
			@PathVariable Integer locname, @PathVariable Integer locrefid) throws Exception {
		return opeanCloseRegisterService.openregisterdetails(compid, branchid, locname, locrefid);
	}

	@GetMapping(value = "view-close-register-details/{compid}/{branchid}/{locname}/{locrefid}")
	public List closeregisterdetails(@PathVariable Integer compid, @PathVariable Integer branchid,
			@PathVariable Integer locname, @PathVariable Integer locrefid) throws Exception {
		return opeanCloseRegisterService.closeregisterdetails(compid, branchid, locname, locrefid);
	}
	
	@GetMapping(value = "cash-movementdetails/{userid}/{logintime}/{logouttime}")
	public List GetCashMovements(@PathVariable Integer userid, @PathVariable String logintime, @PathVariable String logouttime) throws Exception {
		return opeanCloseRegisterService.GetCashMovements(userid, logintime, logouttime);
	}
	
	@GetMapping(value = "addremovecash-total/{userid}/{logintime}")
	public List GetAddRemoveCashtotal(@PathVariable Integer userid, @PathVariable String logintime) throws Exception {
		return opeanCloseRegisterService.GetAddRemoveCashtotal(userid, logintime);
	}
	
	// Accounts Linking
	@PostMapping(value = "login-employee-openregjournal-save")
	@Transactional
	public int saveOpenJournal(@RequestBody Journal jrnl) throws Exception {
		return opeanCloseRegisterService.saveOpenRegJournal(jrnl);
	}

	@PostMapping(value = "login-employee-closeregjournal-save")
	@Transactional
	public int saveCloseJournal(@RequestBody Journal jrnl) throws Exception {
		return opeanCloseRegisterService.saveCloseJournal(jrnl);
	}
	
	//Cash Manage Process
	@PostMapping(value = "cashmanage-save")
	public ResponseEntity<Boolean> saveCashManage(@RequestBody CashManage cashmanage) throws Exception {
		return opeanCloseRegisterService.saveCashManage(cashmanage);
	}
	
	

}
