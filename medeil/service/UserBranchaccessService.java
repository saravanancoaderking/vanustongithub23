package com.medeil.service;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.medeil.domain.UserBranchaccess;
import com.medeil.repository.UserBranchaccessRepository;

@SuppressWarnings("rawtypes")
@Service
public class UserBranchaccessService {

	@Autowired
	private UserBranchaccessRepository userBranchaccessRepository;

	private static Logger logger = LogManager.getLogger();

	public List userBranch(Integer id) throws Exception {
		return userBranchaccessRepository.userBranch(id);
	}

	public boolean adduserBranch(List<UserBranchaccess> useraccess) throws Exception {
		boolean reFlag = false;
		// try {
		for (int i = 0; i < useraccess.size(); i++) {
			UserBranchaccess ub = useraccess.get(i);
			Integer val = userBranchaccessRepository.isExistBranch(ub.getSuserrefid(), ub.getBranchrefid());
			if (val == null) {
				userBranchaccessRepository.save(useraccess.get(i));
				reFlag = true;
			} else {
				userBranchaccessRepository.deleteBranch(ub.getSuserrefid(), ub.getBranchrefid());
				userBranchaccessRepository.save(useraccess.get(i));
				reFlag = true;
			}
		}
		// } catch (Exception ex) {
		// logger.error("Exception In Method : adduserBranch : " + ex);
		// }
		return reFlag;
	}
}
