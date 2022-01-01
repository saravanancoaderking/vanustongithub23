/**
 * 
 */
package com.medeil.service;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.medeil.domain.Hospital;
import com.medeil.repository.HospitalRepository;

/**
 * @author
 *
 */
@SuppressWarnings("rawtypes")
@Service
public class HospitalService {

	@Autowired
	private HospitalRepository hospitalRepository;

	private static Logger logger = LogManager.getLogger();

	public List getSpecialitys() throws Exception {
		return hospitalRepository.getSpecialitys();
	}

	public boolean saveHospital(Hospital hospital) throws Exception {
		boolean flag = false;
		// try {
		if (!hospital.equals("") || !hospital.equals(null)) {
			hospitalRepository.save(hospital);
			flag = true;
		} else {
			flag = false;
		}
		// } catch (Exception ex) {
		// logger.error("Exception In Method : saveHospital : " + ex);
		// }
		return flag;
	}

	public List getAll(Integer cid, Integer bid) throws Exception {
		return hospitalRepository.getAll(cid, bid);
	}

	public Hospital editHospital(Integer id) throws Exception {
		return hospitalRepository.findByid(id);
	}

	/** Edit Hospital **/
	public List editState(int id) throws Exception {
		Hospital hos = hospitalRepository.findByid(id);
		return hospitalRepository.geteditState(hos.getCountryid());
	}

	public List hospeditCcode(int id) throws Exception {
		Hospital hos = hospitalRepository.findByid(id);
		return hospitalRepository.geteditCcode(hos.getCountryid());
	}

	public List hospeditCity(int id) throws Exception {
		Hospital hos = hospitalRepository.findByid(id);
		return hospitalRepository.geteditCity(hos.getStateid());
	}

	public boolean updateHospital(Hospital hospital) throws Exception {
		boolean flag = false;
		// try {
		if (!hospital.equals("")) {
			hospitalRepository.save(hospital);
			flag = true;
		} else {
			flag = false;
		}
		// } catch (Exception ex) {
		// logger.error("Exception In Method : updateHospital : " + ex);
		// }
		return flag;
	}

	public Integer deleteHospital(Integer id) throws Exception {
		return hospitalRepository.deleteHospital(id);
	}
}
