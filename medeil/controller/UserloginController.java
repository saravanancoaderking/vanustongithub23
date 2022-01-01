package com.medeil.controller;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.medeil.domain.UserReference;
import com.medeil.domain.Userlogin;
import com.medeil.service.UserloginService;

@SuppressWarnings("rawtypes")
@RestController
@RequestMapping("api")
public class UserloginController {

	@Autowired
	private UserloginService userloginService;

	String username = "";
	Integer companyId;
	String password = "";
	Integer userid = 0;

	@PostMapping(value = "loginModule")
	public List Login(@RequestBody Userlogin userlogin) throws Exception {
		username = userlogin.getUsername();
		password = userlogin.getPassword();
		companyId = userlogin.getCompanyid();
		int index = password.lastIndexOf("_");
		String pass = password.substring(2, index);
		return userloginService.Login(username.trim(), pass.replaceAll("_", "").trim(), companyId);
	}

	@PostMapping(value = "getModulelabel")
	public List getLabel(@RequestBody Userlogin userlogin) throws Exception {
		username = userlogin.getUsername();
		password = userlogin.getPassword();
		companyId = userlogin.getCompanyid();
		return userloginService.getLabel(username.trim(), password.trim(), companyId);
	}

	@PostMapping(value = "checkExistuser")
	public List existsUser(@RequestBody Userlogin userlogin) throws Exception {
		username = userlogin.getUsername();
		password = userlogin.getPassword();
		companyId = userlogin.getCompanyid();
		return userloginService.existsUser(username.trim(), password.trim(), companyId);
	}

	@PostMapping(value = "saveuserlogin")
	public ResponseEntity<Boolean> userLogin(@RequestBody Userlogin userlogin) throws Exception {
		return userloginService.userLogin(userlogin);
	}

	@GetMapping(value = "getloginBranchlist/{cid}/{uid}")
	public List getLoginBranch(@PathVariable Integer cid, @PathVariable Integer uid) throws Exception {
		return userloginService.getLoginBranch(cid, uid);
	}

	@GetMapping(value = "getloginShoplist/{cid}/{bid}/{uid}")
	public List getLoginShop(@PathVariable Integer cid, @PathVariable Integer bid, @PathVariable Integer uid)
			throws Exception {
		return userloginService.getLoginShop(cid, bid, uid);
	}

	@GetMapping(value = "getloginHospitallist/{cid}/{bid}/{uid}")
	public List getLoginhospital(@PathVariable Integer cid, @PathVariable Integer bid, @PathVariable Integer uid)
			throws Exception {
		return userloginService.getLoginhospital(cid, bid, uid);
	}

	@GetMapping(value = "getloginWarehouselist/{cid}/{bid}/{uid}")
	public List getLoginWarehouse(@PathVariable Integer cid, @PathVariable Integer bid, @PathVariable Integer uid)
			throws Exception {
		return userloginService.getLoginWarehouse(cid, bid, uid);
	}

	@PostMapping(value = "getLocalStorage")
	public List setLocalStorage(@RequestBody UserReference userReference) throws Exception {
		return userloginService.setLocalStorage(userReference);
	}

	@GetMapping(value = "getusercomp")
	public List getUserCompany() throws Exception {
		return userloginService.getuserCompany();
	}

	// padmini
	@GetMapping(value = "getloginuserlabel/{uid}")
	public List getloginuserlabel(@PathVariable Integer uid) throws Exception {
		return userloginService.getloginuserlabel(uid);
	}

	@PostMapping(value = "getModulelabels")
	public List getModulelabels(@RequestBody Userlogin userlogin) throws Exception {
		return userloginService.getModulelabels1(userlogin.getId());
	}

	@PostMapping(value = "getAuthorities")
	public Map getAuthorities(@RequestBody Userlogin userlogin) throws Exception {
		Map<String, Object> info = new LinkedHashMap<String, Object>();
		info.put("labels", userloginService.getLabel(userlogin.getUsername(), userlogin.getCompanyrefid()));
		info.put("modules", userloginService.getAuthorities(userlogin.getUsername(), userlogin.getCompanyrefid()));
		return info;
	}

	@PostMapping(value = "getpaitentauthorities")
	public Object getPaitentAuthorities(@RequestBody Userlogin userlogin) throws Exception {
		return userloginService.getPaitentAuthorities(userlogin.getUsername());
	}

	@GetMapping(value = "user-password-expiry-verification/{username}")
	public Map passwordExpiryVerification(@PathVariable String username) throws Exception {
		return userloginService.passwordExpiryVerification(username);
	}

	@GetMapping(value = "reset-user-password/{username}/{newpassword}/{currentpassword}")
	public Map resetUserPassword(@PathVariable String username, @PathVariable String newpassword,
			@PathVariable String currentpassword) throws Exception {
		return userloginService.resetUserPassword(username, newpassword, currentpassword);
	}

	@GetMapping(value = "last-visit-and-login-history/{userid}")
	public ResponseEntity<Map> lastVisitAndLoginHistory(@PathVariable int userid) throws Exception {
		return userloginService.lastVisitAndLoginHistory(userid);
	}

	// Desing Raja View User Lock and UnLock

	@GetMapping(value = "Viewuserlockdetails")
	public List userlock() throws Exception {
		System.out.println("*********");
		return userloginService.userlockdetails();
	}

	// Desing Raja User Lock to Unlock
	@GetMapping(value = "updatetounloc/{userid}")
	public boolean updatetounlock(@PathVariable Integer userid) throws Exception {
		System.out.println("****tounlock****");
		return userloginService.updateunlockdetails(userid);
	}

	// Desing Raja User Unlock to Lock
	@GetMapping(value = "updatetoloc/{userid}")
	public boolean updatetolock(@PathVariable Integer userid) throws Exception {
		System.out.println("**tolock**");
		return userloginService.updatelockdetails(userid);
	}

	// Desing Raja User Login History

	@GetMapping(value = "loginhistory")
	public List userloginhist() throws Exception {
		System.out.println("**Login History Controller**");
		return userloginService.loginhistory();
	}

}
