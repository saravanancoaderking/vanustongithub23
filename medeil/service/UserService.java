package com.medeil.service;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.medeil.domain.User;
import com.medeil.repository.UserRepository;

@SuppressWarnings("rawtypes")
@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;

	private static Logger logger = LogManager.getLogger();

	public List companyList() throws Exception {
		return userRepository.companyList();
	}

	public List userconData(Integer id) throws Exception {
		return userRepository.userconData(id);
	}

	public List userproData(Integer id) throws Exception {
		return userRepository.userproData(id);
	}

	public List userdomData(Integer id) throws Exception {
		return userRepository.userdomData(id);
	}

	public List usersdomData(Integer id) throws Exception {
		return userRepository.usersdomData(id);
	}

	public List userEditionData(Integer id) throws Exception {
		return userRepository.userEditionData(id);
	}

	public List roleList(Integer id) throws Exception {
		return userRepository.roleList(id);
	}

	public List employeeList(Integer id) throws Exception {
		return userRepository.employeeList(id);
	}

	@Transactional
	public boolean createUser(User user) throws Exception {
		boolean flag = false;
		// try {
		if (!user.equals("")) {
			userRepository.save(user);
			flag = true;
		} else {
			flag = false;
		}
		// } catch (Exception e) {
		// logger.error("Exception In Method : createUser : " + e);
		// }
		return flag;
	}

	public List viewUserList() throws Exception {
		return userRepository.viewUserList();
	}

	public List viewUserModulelist() throws Exception {
		return userRepository.viewUserModulelist();
	}

	public List viewUserAccess(String data) throws Exception {
		List list = null;
		// try {
		if (data.equalsIgnoreCase("branch")) {
			list = userRepository.viewBrancAccess();
		} else if (data.equalsIgnoreCase("shop")) {
			list = userRepository.viewShopAccess();
		} else if (data.equalsIgnoreCase("ware")) {
			list = userRepository.viewWareAccess();
		} else if (data.equalsIgnoreCase("hospital")) {
			list = userRepository.viewHospitalAccess();
		}
		// } catch (Exception e) {
		// logger.error("Exception In Method : viewUserAccess : " + e);
		// }
		return list;
	}

	public void delAssignUser(Integer id) throws Exception {
		int moduleno = userRepository.getmoduleno(id);
		int userid = userRepository.getuserno(id);
		int modulecount = userRepository.getmodulecount(moduleno, userid);
		if (modulecount == 1) {
			userRepository.delAssignUser(id);
			userRepository.deleteAssignmodule(moduleno, userid);
		} else {
			userRepository.delAssignUser(id);
		}

	}
}
