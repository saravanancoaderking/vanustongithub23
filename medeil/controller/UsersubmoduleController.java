package com.medeil.controller;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.medeil.domain.Usersubmodule;
import com.medeil.repository.UsersubmoduleRepository;

@SuppressWarnings("rawtypes")
@RestController
@RequestMapping("api")
public class UsersubmoduleController {

	@Autowired
	private UsersubmoduleRepository usersubmoduleRepository;
	private static Logger logger = LogManager.getLogger();

	@PostMapping(value = "/saveusersubmodule")
	public boolean userSubmodule(@RequestBody List<Usersubmodule> user) throws Exception{
		boolean reFlag = false;
		//try {
			for (int i = 0; i < user.size(); i++) {
				Usersubmodule um = user.get(i);
				Integer reVal = usersubmoduleRepository.isExistsubModule(um.getSuserrefid(), um.getSubmoduleid());
				if (reVal == null) {
					usersubmoduleRepository.save(user.get(i));
					reFlag = true;
				} else {
					usersubmoduleRepository.deleteSubModule(um.getSuserrefid(), um.getSubmoduleid());
					usersubmoduleRepository.save(user.get(i));
					reFlag = true;
				}
				if (um.getIs_approver() == false) {
					approval(um);
				}
			}
		//} catch (Exception r) {
		//	logger.error("Exception In Method : Usersubmodule() : " + r);
	//	}
		return reFlag;
	}

	private void approval(Usersubmodule um) throws Exception{
		// Approval Process procedure

	//	try {
			if (um.getIs_approver() == false) {

				Integer approver = usersubmoduleRepository.getapproverid(um.getModuleid(), um.getSubmoduleid(),
						um.getSuserrefid());
				if (approver != null) {
					usersubmoduleRepository.saveapproval(um.getSuserrefid(), um.getModuleid(), um.getSubmoduleid(),
							approver);
				}
			}
	//	} catch (Exception r) {
	//		logger.error("Exception In Method : Usersubmodule() : " + r);
	//	}

	}

	@GetMapping(value = "/usersubmodulelist/{mid}/{uid}")
	public List subModulelist(@PathVariable Integer mid, @PathVariable Integer uid)throws Exception {
		return usersubmoduleRepository.subModulelist(mid, uid);
	}

	// padmini
	@PostMapping(value = "/updateusermodulelable")
	public boolean updateusermodulelable(@RequestBody List<Usersubmodule> user) {
		System.out.println("inside update");
		boolean reFlag = false;
		//try {
			for (int i = 0; i < user.size(); i++) {
				System.out.println("inside update" + user.get(i).getSuserrefid());
				usersubmoduleRepository.updateusermodulelabel(user.get(i).getSuserrefid(), user.get(i).getRanking(),
						user.get(i).getLabel());
				reFlag = true;
			}

		//} catch (Exception r) {
		//	logger.error("Exception In Method : updateusermodulelable() : " + r);
		//}
		return reFlag;
	}

}
