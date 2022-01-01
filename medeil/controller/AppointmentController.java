/**
 * 
 */
package com.medeil.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.medeil.domain.Appointment;
import com.medeil.domain.DrAppointment;
import com.medeil.service.AppointmentService;

/**
 * @author Ajith Kumar
 *
 */
@SuppressWarnings("rawtypes")
@RestController
@RequestMapping("api")
public class AppointmentController {

	@Autowired
	private AppointmentService appointmentService;

//Raja
	@GetMapping(value = "getdoctorlist/{cid}/{bid}/{lname}/{lref}")
	public List getDoctor(@PathVariable Integer cid, @PathVariable Integer bid, @PathVariable Integer lname,
			@PathVariable Integer lref) throws Exception {
		System.out.println("Dr List");
		return appointmentService.getDoctor(cid, bid, lname, lref);
	}

//Raja
	@GetMapping(value = "getAppointpatientlist/{cid}/{bid}/{lref}/{lname}")
	public List getPatient(@PathVariable Integer cid, @PathVariable Integer bid, @PathVariable Integer lref,
			@PathVariable Integer lname) throws Exception {
		return appointmentService.getPatient(cid, bid, lref, lname);
	}

	@GetMapping(value = "doctorAvailability/{did}/{frtime}/{totime}")
	public Boolean checkDocAvailability(@PathVariable Integer did, @PathVariable String frtime,
			@PathVariable String totime) throws Exception {
		return appointmentService.checkDocAvailability(did, frtime, totime);
	}

	@GetMapping(value = "checkdoctorAppointment/{date}/{did}/{frtime}/{totime}")
	public Boolean checkAppointment(@PathVariable String date, @PathVariable Integer did, @PathVariable String frtime,
			@PathVariable String totime) throws Exception {
		return appointmentService.checkAppointment(date, did, frtime, totime);
	}

	@PostMapping(value = "saveAppointment")
	public boolean createAppointment(@RequestBody Appointment appointment) throws Exception {
		return appointmentService.createAppointment(appointment);
	}

	@PostMapping(value = "savedrappoint")
	public boolean adddrappointment(@RequestBody List<DrAppointment> da) throws Exception {
		System.out.println("AppointmentController");
		return appointmentService.savedrapp(da);
	}

	@GetMapping(value = "getdrapp/{drid}/{cid}/{bid}/{lname}/{lref}")
	public List getdrapp(@PathVariable Integer drid, @PathVariable Integer cid, @PathVariable Integer bid,
			@PathVariable Integer lname, @PathVariable Integer lref) {
		System.out.println("DrAppointment");
		return appointmentService.detdrappoint(drid, cid, bid, lname, lref);
	}

	@GetMapping(value = "viewdoctorAppointment/{cid}/{bid}/{lref}/{lname}")
	public List viewAppointment(@PathVariable Integer cid, @PathVariable Integer bid, @PathVariable Integer lref,
			@PathVariable Integer lname) throws Exception {
		return appointmentService.viewAppointment(cid, bid, lref, lname);
	}

	@GetMapping(value = "searchdoctorAppointment/{date}/{frtime}/{totime}/{cid}/{bid}/{lref}/{lname}")
	public List searchAppointment(@PathVariable String date, @PathVariable String frtime, @PathVariable String totime,
			@PathVariable Integer cid, @PathVariable Integer bid, @PathVariable Integer lref,
			@PathVariable Integer lname) throws Exception {
		return appointmentService.searchAppointment(date, frtime, totime, cid, bid, lref, lname);
	}

	@GetMapping(value = "maxAppointnumber/{date}/{id}")
	public String getMaxApoointNo(@PathVariable String date, @PathVariable Integer id) throws Exception {
		return appointmentService.getMaxApoointNo(date, id);
	}

	/** MANAGE APPOINTMENT **/
	@GetMapping(value = "searchAppointdoctor/{docname}/{cid}/{bid}/{lref}/{lname}")
	public List searchDoctor(@PathVariable String docname, @PathVariable Integer cid, @PathVariable Integer bid,
			@PathVariable Integer lref, @PathVariable Integer lname) throws Exception {
		return appointmentService.searchDoctor(docname, cid, bid, lref, lname);
	}

	@GetMapping(value = "searchAppointpatient/{data}/{cid}/{bid}/{lref}/{lname}")
	public List searchPatient(@PathVariable String data, @PathVariable Integer cid, @PathVariable Integer bid,
			@PathVariable Integer lref, @PathVariable Integer lname) throws Exception {
		return appointmentService.searchPatient(data, cid, bid, lref, lname);
	}

	@GetMapping(value = "doctorWiseappointment/{docID}")
	public List getDoctorWiseAppoint(@PathVariable Integer docID) throws Exception {
		return appointmentService.getDoctorWiseAppoint(docID);
	}

	@GetMapping(value = "patientWiseappointment/{pid}")
	public List getpatientWiseAppoint(@PathVariable Integer pid) throws Exception {
		return appointmentService.getPatientWiseAppoint(pid);
	}

	@GetMapping(value = "dateWiseappointment/{da}/{cid}/{bid}/{lref}/{lname}")
	public List getdateWiseAppoint(@PathVariable String da, @PathVariable Integer cid, @PathVariable Integer bid,
			@PathVariable Integer lref, @PathVariable Integer lname) throws Exception {
		return appointmentService.getDateWiseAppoint(da, cid, bid, lref, lname);
	}

	@GetMapping(value = "listManageappoint/{cid}/{bid}/{lref}/{lname}")
	public List manageAppoint(@PathVariable Integer cid, @PathVariable Integer bid, @PathVariable Integer lref,
			@PathVariable Integer lname) throws Exception {
		return appointmentService.manageAppoint(cid, bid, lref, lname);
	}

	@GetMapping(value = "geteditAppointment/{id}")
	public Appointment editAppointment(@PathVariable Integer id) throws Exception {
		return appointmentService.editAppointment(id);
	}

	@GetMapping(value = "geteditFromtime/{id}")
	public String editFromtime(@PathVariable Integer id) throws Exception {
		return appointmentService.editFromtime(id);
	}

}
