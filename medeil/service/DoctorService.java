/**
 * 
 */
package com.medeil.service;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.medeil.domain.Doctor;
import com.medeil.repository.DoctorRepository;

/**
 * @author Ajith Kumar
 *
 */
@SuppressWarnings("rawtypes")
@Service
public class DoctorService {

	@Autowired
	private   DoctorRepository doctorRepository;

	private static Logger logger = LogManager.getLogger();

	@Transactional
	public boolean createDoctor(Doctor doctor) throws Exception {
		boolean flag = false;
		// try {
		if (!doctor.equals("")) {
			doctorRepository.save(doctor);
			flag = true;
		} else {
			flag = false;
		}
		// } catch (Exception ex) {
		// logger.error("Exception in Method : createDoctor : " + ex);
		// }
		return flag;
	}

	public List viewDoctors(Integer cid, Integer bid) throws Exception {
		return doctorRepository.viewDoctors(cid, bid);
	}

	public Doctor editDoctor(Integer id) throws Exception {
		return doctorRepository.findById(id);
	}

	public List editState(int id) throws Exception {
		Doctor doc = doctorRepository.findById(id);
		return doctorRepository.geteditState(doc.getCountry());
	}

	public List doceditCcode(int id) throws Exception {
		Doctor doc = doctorRepository.findById(id);
		return doctorRepository.geteditCcode(doc.getCountry());
	}

	public List doceditCity(int id) throws Exception {
		Doctor doc = doctorRepository.findById(id);
		return doctorRepository.geteditCity(doc.getState());
	}

	@Transactional
	public boolean modifyDoctor(Doctor doctor) throws Exception {
		boolean flag = false;
		// try {
		if (!doctor.equals("")) {
			doctorRepository.save(doctor);
			flag = true;
		} else {
			flag = false;
		}
		// } catch (Exception ex) {
		// logger.error("Exception in Method : modifyDoctor : " + ex);
		// }
		return flag;
	}

	public Integer deleteDoctors(Integer id) throws Exception {
		return doctorRepository.deleteDoctor(id);
	}

	/*** DOCTOR LIST ***/ // Boopalan 010519
	public List doctorlist(Integer compid, Integer branchid, Integer locname, Integer locrefid) throws Exception {
		return doctorRepository.doctorlist(compid, branchid, locname, locrefid);
	}
	
	public List searchdoctor(Integer compid, Integer branchid, Integer locname, Integer locrefid,String searchkey) throws Exception {
		return doctorRepository.searchdoctorlist(compid, branchid, locname, locrefid,searchkey);
	}
	
}
