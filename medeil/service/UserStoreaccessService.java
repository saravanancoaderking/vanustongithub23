package com.medeil.service;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.medeil.domain.UserStoreaccess;
import com.medeil.repository.UserStoreaccessRepository;

@SuppressWarnings("rawtypes")
@Service
public class UserStoreaccessService {

	@Autowired
	private UserStoreaccessRepository userStoreaccessRepository;

	private static Logger logger = LogManager.getLogger();

	public List userShoplist(Integer id) {
		return userStoreaccessRepository.userShoplist(id);
	}

	public boolean addUserShop(List<UserStoreaccess> useraccess) throws Exception {
		boolean reFlag = false;
		// try {
		for (int i = 0; i < useraccess.size(); i++) {
			UserStoreaccess us = useraccess.get(i);
			Integer reval = userStoreaccessRepository.isExistShop(us.getSuserrefid(), us.getStorerefid());
			if (reval == null) {
				userStoreaccessRepository.save(useraccess.get(i));
				reFlag = true;
			} else {
				userStoreaccessRepository.deleteShop(us.getSuserrefid(), us.getStorerefid());
				userStoreaccessRepository.save(useraccess.get(i));
				reFlag = true;
			}
		}
		// } catch (Exception e) {
		// logger.error("Exception In Method : addUserShop : " + e);
		// }
		return reFlag;
	}

}
