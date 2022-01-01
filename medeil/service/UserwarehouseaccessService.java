package com.medeil.service;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.medeil.domain.Userwarehouseaccess;
import com.medeil.repository.UserwarehouseaccessRepository;

@SuppressWarnings("rawtypes")
@Service
public class UserwarehouseaccessService {

	@Autowired
	private UserwarehouseaccessRepository userwarehouseaccessRepository;

	private static Logger logger = LogManager.getLogger();

	public List userWarehouselist(Integer id) {
		return userwarehouseaccessRepository.userWarehouselist(id);
	}

	public boolean addWarehouse(List<Userwarehouseaccess> useraccess) throws Exception {
		boolean reFlag = false;
		// try {
		for (int i = 0; i < useraccess.size(); i++) {
			Userwarehouseaccess uw = useraccess.get(i);
			Integer reVal = userwarehouseaccessRepository.isExistWarehouse(uw.getSuserrefid(), uw.getWarehouserefid());
			if (reVal == null) {
				userwarehouseaccessRepository.save(useraccess.get(i));
				reFlag = true;
			} else {
				userwarehouseaccessRepository.deleteWarehouse(uw.getSuserrefid(), uw.getWarehouserefid());
				userwarehouseaccessRepository.save(useraccess.get(i));
				reFlag = true;
			}
		}
		// } catch (Exception e) {
		// logger.error("Exception In Method : addWarehouse : " + e);
		// }
		return reFlag;
	}

}
