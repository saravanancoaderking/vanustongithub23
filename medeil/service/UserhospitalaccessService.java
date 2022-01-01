package com.medeil.service;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.medeil.domain.Userhospitalaccess;
import com.medeil.repository.UserhospitalaccessRepository;

@SuppressWarnings("rawtypes")
@Service
public class UserhospitalaccessService {

	@Autowired
	UserhospitalaccessRepository userhospitalaccessRepository;

	private static Logger logger = LogManager.getLogger();

	public List userHospital(Integer id) throws Exception {
		return userhospitalaccessRepository.userHospital(id);
	}

	public boolean addHospital(List<Userhospitalaccess> useraccess) throws Exception {
		boolean reFlag = false;
		// try {
		for (int i = 0; i < useraccess.size(); i++) {
			Userhospitalaccess uH = useraccess.get(i);
			Integer reVal = userhospitalaccessRepository.isExistHospital(uH.getSuserrefid(), uH.getHospitalrefid());
			if (reVal == null) {
				userhospitalaccessRepository.save(useraccess.get(i));
				reFlag = true;
			} else {
				userhospitalaccessRepository.deleteHospital(uH.getSuserrefid(), uH.getHospitalrefid());
				userhospitalaccessRepository.save(useraccess.get(i));
				reFlag = true;
			}
		}
		// } catch (Exception ex) {
		// logger.error("Exception In Method : adduserBranch : " + ex);
		// }

		return reFlag;
	}
}
