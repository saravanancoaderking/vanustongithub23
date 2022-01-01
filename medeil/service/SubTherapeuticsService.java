package com.medeil.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.medeil.domain.SubTherapeutic;
import com.medeil.repository.SubTherapeuticsRepository;

@Service
public class SubTherapeuticsService {

	@Autowired
	SubTherapeuticsRepository subThrepeuticRepository;

	public SubTherapeutic saveTharapetics(SubTherapeutic thra) {
		return subThrepeuticRepository.save(thra);
	}

	public boolean isSubTherapeuticExist(int tname, String stname) throws Exception {
		boolean isExist = false;
//		try {
		String reVal = subThrepeuticRepository.isSubTherapeuticExist(tname, stname);
		System.out.println("reVal" + reVal);
		if (reVal != null) {
			isExist = true;
		} else {
			isExist = false;
		}

		// } catch (Exception e) {

		// }

		return isExist;
	}

	public List viewTherapeutic() throws Exception {
		return subThrepeuticRepository.viewTherapeutic();
	}

	public SubTherapeutic getSubTherapeutic(int id) throws Exception {
		return subThrepeuticRepository.findById(id);
	}

	public boolean isTherapeuticUpdateExist(int tid, String tname, int stid) throws Exception {
		boolean isExist = false;
		// try {
		Integer reVal = subThrepeuticRepository.isTherapeuticUpdateExist(tid, tname, stid);
		System.out.println("reVal" + reVal);
		if (reVal >= 1) {
			System.out.println("reval is exist");
			isExist = true;
		} else {
			System.out.println("reval is exist123");
			isExist = false;
		}

		// } catch (Exception e) {//

		// }

		return isExist;
	}

	public boolean deleteTherapeutic(int id) throws Exception {
		boolean flag = false;
		int i = (Integer) subThrepeuticRepository.deleteTherapeutic(id);
		System.out.println("return value" + i);
		if (i != 0) {
			flag = true;
		}
		return flag;
	}

	public List LoadTherapeutics() throws Exception {
		return subThrepeuticRepository.LoadTherapeutics();
	}

	public List viewIndentStatus() throws Exception {
		return subThrepeuticRepository.viewIndentStatus();
	}

}
