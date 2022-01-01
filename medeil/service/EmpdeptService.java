package com.medeil.service;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.medeil.domain.Empdept;
import com.medeil.repository.EmpdeptRepository;

@Service
public class EmpdeptService {
	
	private static Logger logger = LogManager.getLogger();
	
	@Autowired
	private EmpdeptRepository empdeptRepository;
	List list = null;
	
	
	public void CreatedeptRec(Empdept empdept)throws Exception {
	//	try {
			empdeptRepository.save(empdept);
	//		}catch (Exception exp) {
	//		logger.error("Exception In Method : CreatedeptRec() : " + exp);
	//		}
	
	}
	public boolean isExistdept(Integer compid,Integer branchid,Integer locname,Integer locrefid,String name)throws Exception {
		boolean flag = false;
	//	try {
			String reName = empdeptRepository.checkExistdept(compid,branchid,locname,locrefid, name.trim());
			if (name.equalsIgnoreCase(reName)) {
				flag = true;
			} else {
				flag = false;
			}
	//	} catch (Exception ex) {
	//		logger.error("Exception in Method : checkExistRole : " + ex);
	//	}
		return flag;
	}
}
