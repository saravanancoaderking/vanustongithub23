package com.medeil.service;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.medeil.domain.Appointment;
import com.medeil.domain.DrAppointment;
import com.medeil.repository.AppointmentRepository;
import com.medeil.repository.DrAppointmentRepository;

/**
 * @author Ajith Kumar
 *
 */
@SuppressWarnings("rawtypes")
@Service
public class AppointmentService {

	@Autowired
	private AppointmentRepository appointmentRepository;
	private static Logger logger = LogManager.getLogger();

	@Autowired
	private DrAppointmentRepository darepository;

	public List getDoctor(Integer cid, Integer bid, Integer lname, Integer lref) throws Exception {
		System.out.println("Dr List1");
		return appointmentRepository.getDoctor(cid, bid, lname, lref);
	}

	public List getPatient(Integer cid, Integer bid, Integer lref, Integer lname) throws Exception {
		return appointmentRepository.getPatient(cid, bid, lref, lname);
	}

	public Boolean createAppointment(Appointment appointment) throws Exception {
		boolean flag = false;
		try {
			if (!appointment.equals("") || !appointment.equals(null)) {
				Appointment res = appointmentRepository.save(appointment);
				System.out.println(res);
				flag = true;
			} else {
				flag = false;
			}
		} catch (Exception e) {
			logger.error("Exception In Method : createAppointment() : " + e);
			throw new Exception(e);
		}
		return flag;
	}

	// ******Dr Appointment *********

	public boolean savedrapp(List<DrAppointment> da) {
		System.out.println("AppointmentServecie");
		darepository.saveAll(da);
		return true;
	}

	public List detdrappoint(Integer id, Integer cid, Integer bid, Integer lname, Integer lref) {

		return darepository.findByDoctorrefid(id);

	}

	public Boolean checkDocAvailability(Integer did, String frtime, String totime) throws Exception {
		boolean reValue = false;
		try {
			String val = appointmentRepository.checkDocAvailability(did, frtime, totime);
			System.out.println(val);
			if (val == null || val == "") {
				reValue = false;
			} else {
				reValue = true;
			}
		} catch (Exception e) {
			logger.error("Exception In Method : checkDocAvailability() : " + e);
			throw new Exception(e);
		}
		return reValue;
	}

	public Boolean checkAppointment(String date, Integer did, String frtime, String totime) throws Exception {
		boolean flag = false;
		try {
			String data = appointmentRepository.checkAppointment(date, did, frtime, totime);
			if (data == null || data == "") {
				flag = true;
			} else {
				flag = false;
			}
		} catch (Exception e) {
			logger.error("Exception In Method : checkAppointment() : " + e);
			throw new Exception(e);
		}
		return flag;
	}

	public List viewAppointment(Integer cid, Integer bid, Integer lref, Integer lname) throws Exception {
		return appointmentRepository.viewAppointment(cid, bid, lref, lname);
	}

	public List searchAppointment(String date, String frtime, String totime, Integer cid, Integer bid, Integer lref,
			Integer lname) throws Exception {
		return appointmentRepository.searchAppointment(date, frtime, totime, cid, bid, lref, lname);
	}

	public String getMaxApoointNo(String date, Integer id) throws Exception {
		return appointmentRepository.getMaxApoointNo(date, id);
	}

	/** MANAGE APPOINTMENT **/

	public List searchDoctor(String docname, Integer cid, Integer bid, Integer lref, Integer lname) throws Exception {
		return appointmentRepository.searchDoctor(docname, cid, bid, lref, lname);
	}

	public List searchPatient(String data, Integer cid, Integer bid, Integer lref, Integer lname) throws Exception {
		return appointmentRepository.searchPatient(data, cid, bid, lref, lname);
	}

	public List getDoctorWiseAppoint(Integer docID) throws Exception {
		return appointmentRepository.getDoctorWiseAppoint(docID);
	}

	public List getPatientWiseAppoint(Integer pid) throws Exception {
		return appointmentRepository.getPatientWiseAppoint(pid);
	}

	public List getDateWiseAppoint(String da, Integer cid, Integer bid, Integer lref, Integer lname) throws Exception {
		return appointmentRepository.getDateWiseAppoint(da, cid, bid, lref, lname);
	}

	public List manageAppoint(Integer cid, Integer bid, Integer lref, Integer lname) throws Exception {
		return appointmentRepository.manageAppoint(cid, bid, lref, lname);
	}

	public Appointment editAppointment(Integer id) throws Exception {
		return appointmentRepository.findById(id);
	}

	public String editFromtime(Integer id) throws Exception {
		Appointment ap = appointmentRepository.findById(id);
		return appointmentRepository.editFromtime(ap.getAppointfromtime());
	}
}
