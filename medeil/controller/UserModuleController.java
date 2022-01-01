package com.medeil.controller;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.medeil.domain.UserModule;
import com.medeil.repository.UserModuleRepository;

@SuppressWarnings("rawtypes")
@RestController
@RequestMapping("api")
public class UserModuleController {

	@Autowired
	private UserModuleRepository userModuleRepository;

	private static Logger logger = LogManager.getLogger();

	@GetMapping(value = "/moduleUserlist/{id}")
	public List userList(@PathVariable Integer id) throws Exception {
		return userModuleRepository.userList(id);
	}

	@GetMapping(value = "/usermodulelist/{id}")
	public List moduleList(@PathVariable Integer id) throws Exception {
		return userModuleRepository.moduleList(id);
	}

	@Transactional
//	@PostMapping(value = "saveusermodule")
//	public boolean userModule(@RequestBody UserModule user) throws Exception {
//		boolean reFlag = false;
//		try {
//			Integer reVal = userModuleRepository.isExistModule(user.getSuserrefid(), user.getModuleid());
//			if (reVal == null) throws Exception {
//				userModuleRepository.save(user);
//				reFlag = true;
//			} else {
//				userModuleRepository.deleteModule(user.getSuserrefid(), user.getModuleid());
//				userModuleRepository.save(user);
//				reFlag = true;
//			}
//		} catch (Exception e) throws Exception {
//			logger.error("Exception In Method : userModule() : " + e);
//		}
//		return reFlag;
//	}

////	// @Transactional
//	@PostMapping(value = "/saveusermodule")
//	public boolean userModule(@RequestBody List<UserModule> user) throws Exception {
//		System.out.println("inside save");
//		boolean reFlag = false;
//		try {
//			for (int i = 0; i < user.size(); i++) throws Exception {
//				// List reVal = userModuleRepository.isExistModule(user.getSuserrefid().get,
//				// user.getModuleid());
//				List reVal = userModuleRepository.isExistModule(user.get(i).getSuserrefid(), user.get(i).getModuleid());
//				if (reVal == null) throws Exception {
//					// padmini
//					userModuleRepository.updatelabel(user.get(i).getSuserrefid(), user.get(i).getModuleid());
//					userModuleRepository.save(user);
//					reFlag = true;
//				} else {
//					userModuleRepository.deleteModule(user.get(i).getSuserrefid(), user.get(i).getModuleid());
//					userModuleRepository.save(user);
//					reFlag = true;
//				}
//			}
//		} catch (Exception e) throws Exception {
//			logger.error("Exception In Method : userModule() : " + e);
//		}
//		return reFlag;
//	}

	// padminni091219
	@GetMapping(value = "/selectmodulenames/{id}/{label}")
	public List selectmodulenames(@PathVariable Integer id, @PathVariable String label) throws Exception {
		return userModuleRepository.selectmodulenames(id, label);
	}

	// Boopalan 041219
	@Transactional
	@PostMapping(value = "saveusermodule")
	public boolean userModule(@RequestBody List<UserModule> users) throws Exception {
		boolean reFlag = false;
		for (UserModule user : users) {
			// try {
			Integer reVal = userModuleRepository.isExistModule(user.getSuserrefid(), user.getModuleid());
			if (reVal == null) {
				System.out.println("Checking321");
				userModuleRepository.updatelabel(user.getSuserrefid(), user.getModuleid());
				System.out.println("Checking321");
				userModuleRepository.save(user);
				reFlag = true;
			} else {
				System.out.println("Checking123");
				userModuleRepository.deleteModule(user.getSuserrefid(), user.getModuleid());
				System.out.println("Checking123");
				userModuleRepository.save(user);
				reFlag = true;
			}
			// } catch (Exception e) {
			// logger.error("Exception In Method : userModule() : " + e);
			// }
		}
		return reFlag;
	}
	// padmini091219

	@PostMapping(value = "/updateuserlabelmoduleranking")
	public boolean updateuserlabelmoduleranking(@RequestBody List<UserModule> user) throws Exception {
		System.out.println("inside update");
		boolean reFlag = false;
		// try {
		for (int i = 0; i < user.size(); i++) {
			userModuleRepository.updateuserlabelmoduleranking(user.get(i).getSuserrefid(), user.get(i).getRanking(),
					user.get(i).getModuleid());
			reFlag = true;
		}

		// } catch (Exception r) {
		// logger.error("Exception In Method : updateusermodulelable() : " + r);
		// }
		return reFlag;
	}

}
