package com.medeil.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.medeil.domain.Therapeutic;
import com.medeil.repository.ThrepeuticRepository;

@Service
public class TherapeuticService {

	@Autowired
	ThrepeuticRepository threpeuticRepository;

	public Therapeutic saveTharapetics(Therapeutic thra) throws Exception {
		return threpeuticRepository.save(thra);
	}

	public boolean isTherapeuticExist(String tname) throws Exception {
		boolean isExist = false;
		// try {
		String reVal = threpeuticRepository.isExistTherapeutic(tname);
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
		return threpeuticRepository.viewTherapeutic();
	}

	public Therapeutic getTherapeutic(int id) throws Exception {
		return threpeuticRepository.findById(id);
	}

	public boolean isTherapeuticUpdateExist(String tname, int tid) throws Exception {
		boolean isExist = false;
		// try {
		String reVal = threpeuticRepository.isTherapeuticUpdateExist(tname, tid);
		System.out.println("reVal" + reVal);
		if (reVal != null) {
			System.out.println("reval is exist");
			isExist = true;
		} else {
			System.out.println("reval is exist123");
			isExist = false;
		}

		// } catch (Exception e) {

		// }

		return isExist;
	}

	public boolean deleteTherapeutic(int id) throws Exception {
		boolean flag = false;
		int i = (Integer) threpeuticRepository.deleteTherapeutic(id);
		System.out.println("return value" + i);
		if (i != 0) {
			flag = true;
		}
		return flag;
	}

}
