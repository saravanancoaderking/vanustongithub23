package com.medeil.service;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.medeil.domain.IndCompModel;
import com.medeil.domain.Patient;
import com.medeil.domain.PatientDetails;
import com.medeil.domain.PatientType;
import com.medeil.domain.PatientsRelatives;
import com.medeil.repository.PatientDetailRepository;
import com.medeil.repository.PatientRepository;
import com.medeil.repository.PatientTypeRepository;
import com.medeil.repository.PatientrelativesRepository;
import com.medeil.util.AutoIncrement;

@Service
public class PatientService {

	private final Logger log = LoggerFactory.getLogger(PatientService.class);

	private final PatientRepository patientRepo;

	private final PatientDetailRepository ptdetailRepo;

	private final PatientrelativesRepository patientrelatives;

	private PatientTypeRepository patientTypeRepository;

	@Autowired
	PatientService(PatientRepository custRepo, PatientDetailRepository patdetailRepo,
			PatientrelativesRepository patientrelatives, PatientTypeRepository patientTypeRepository) {

		this.patientRepo = custRepo;
		this.patientTypeRepository = patientTypeRepository;
		this.ptdetailRepo = patdetailRepo;
		this.patientrelatives = patientrelatives;
	}

	public int savePatient(Patient cust) throws Exception {
		int saveflag = 0;

		Double incid = patientRepo.viewPatientId(cust.getLocname(), cust.getLocrefid());

		String incno = patientRepo.viewPatientIncNo(cust.getLocname(), cust.getLocrefid(), incid);

		if (incno == null) {

			incno = "0";
		}

		// StringBuilder incr = new StringBuilder(
		// AutoIncrement.getIncrement01(incno));
		// incr.insert(0, "PT");

		StringBuilder incr = new StringBuilder(AutoIncrement.getIncrement03("PT/", cust.getLocname().toString(),
				cust.getLocrefid().toString(), incno));

		cust.setPatientno(incr.toString());

		// SIVAKUMAR PATIENT CODE

		String oldPatientCode = patientRepo.lastPatientCode(cust.getCompanyrefid(), cust.getBranchrefid(),
				cust.getLocname(), cust.getLocrefid());

		String oldInco = oldPatientCode.substring(oldPatientCode.length() - 9, oldPatientCode.length());
		Long newInco = Long.parseLong(oldInco) + 1;
		String newPatientCode = StringUtils.leftPad(newInco.toString(), 9, "0");

		cust.setPatientcode("CUST" + newPatientCode);

		patientRepo.save(cust);

		saveflag = 1;
		return saveflag;
	}

	public int updatePatient(Patient cust) throws Exception {
		int saveflag = 0;
		// try {

		patientRepo.save(cust);
		// } catch (Exception e) {

		// log.error("Exception in Method : methodName : " + e);
		// }

		saveflag = 1;
		return saveflag;
	}

	public int savehealthcds(List<IndCompModel> temp) throws Exception {
		int saveflag = 0;
		int i = 0;
		IndCompModel locnew = temp.get(0);
		i = patientRepo.viewPatientInOutId(locnew.getLocname(), locnew.getLocrefid());

		// try {
		for (IndCompModel loc : temp) {

			patientRepo.savehealthcds(loc.getLocname(), loc.getLocrefid(), i, loc.getFrmint1());

		}

		// } catch (Exception e) {

		// log.error("Exception in Method : methodName : " + e);
		// }
		saveflag = 1;
		return saveflag;
	}

	public int saveallergies(List<IndCompModel> temp) throws Exception {
		int saveflag = 0;
		int i = 0;
		IndCompModel locnew = temp.get(0);
		i = patientRepo.viewPatientInOutId(locnew.getLocname(), locnew.getLocrefid());

		// try {
		for (IndCompModel loc : temp) {

			patientRepo.saveallergies(loc.getLocname(), loc.getLocrefid(), i, loc.getFrmint1());

		}

		// } catch (Exception e) {

		// log.error("Exception in Method : methodName : " + e);
		// }
		saveflag = 1;
		return saveflag;
	}

	public int saveIndvAllergies(IndCompModel loc) throws Exception {
		int saveflag = 0;
		patientRepo.saveIndvAllergies(loc.getLocname(), loc.getLocrefid(), loc.getFrmstr1());
		saveflag = 1;
		return saveflag;
	}

	public int saveIndvHealthcds(IndCompModel loc) throws Exception {

		int saveflag = 0;
		patientRepo.saveIndvHealthcds(loc.getLocname(), loc.getLocrefid(), loc.getFrmstr1());
		saveflag = 1;
		return saveflag;
	}

	public int savePtdetails(PatientDetails pt) throws Exception {
		int saveflag = 0;
		IndCompModel loc = new IndCompModel();

		int a = 0;

		// try {

		ptdetailRepo.save(pt);

		a = patientRepo.viewPatientInOutId(loc.getLocname(), loc.getLocrefid());
		// } catch (Exception e) {

		// e.printStackTrace();
		// log.error("Exception in Method : methodName : " + e);
		// }

		saveflag = 1;
		return saveflag;
	}

	public List viewCountry(IndCompModel loc) throws Exception {

		return patientRepo.viewCountry();
	}

	public List viewState(IndCompModel loc) throws Exception {

		return patientRepo.viewState(loc.getFrmint1());

	}

	public List viewCity(IndCompModel loc) throws Exception {

		return patientRepo.viewCity(loc.getFrmint1());

	}

	public List viewPatients(IndCompModel loc) throws Exception {

		return patientRepo.viewPatients(loc.getLocname(), loc.getLocrefid());
	}

	public Patient viewPatientEdit(IndCompModel loc) throws Exception {

		return patientRepo.findById(loc.getFrmint1());
	}

	public List viewPatient(IndCompModel loc) throws Exception {

		return patientRepo.viewPatient(loc.getLocname(), loc.getLocrefid(), loc.getFrmint1());
	}

	public List viewDoctor(IndCompModel loc) throws Exception {

		return patientRepo.viewDoctor(loc.getLocname(), loc.getLocrefid());
	}

	public List viewDepartment(IndCompModel loc) throws Exception {

		return patientRepo.viewDepartment(loc.getLocname(), loc.getLocrefid());
	}

	public List viewAllergies(IndCompModel loc) throws Exception {

		return patientRepo.viewAllergies(loc.getLocname(), loc.getLocrefid());
	}

	public List viewHealthcds(IndCompModel loc) throws Exception {

		return patientRepo.viewHealthcds(loc.getLocname(), loc.getLocrefid());
	}

	public String viewCustcode(IndCompModel loc) throws Exception {

		return patientRepo.viewCustcode(loc.getLocname(), loc.getLocrefid(), loc.getFrmstr1());
	}

	public int deletePatient(IndCompModel loc) throws Exception {
		// int saveflag = 0;
		return patientRepo.deletePatient(loc.getLocname(), loc.getLocrefid(), loc.getFrmint1());

	}

	public int deletePtDetails(IndCompModel loc) throws Exception {
		int saveflag = 0;
		patientRepo.deletePtDetails(loc.getLocname(), loc.getLocrefid(), loc.getFrmint1());
		saveflag = 1;
		return saveflag;

	}

	// Selva
	// Reports
	public List getCustinfo(int compid, int branchid, int locname, int locrefid) throws Exception {
		return patientRepo.Customerinfo(compid, branchid, locname, locrefid);
	}

	public List getcustemail(int id) throws Exception {
		return patientRepo.getcustemail(id);
	}

	/********* Edit State **************/
	// Boopalan 020419
	public List editCusState(IndCompModel patientID) throws Exception {
		Patient ds = patientRepo.findById(patientID.getPatientid());
		System.out.println("Boopalan patient state" + ds.getState());
		return patientRepo.editCusState(ds.getState());
	}

	/********* Edit City **************/
	// Boopalan 020419
	public List editCusCity(IndCompModel patientID) throws Exception {
		Patient ds = patientRepo.findById(patientID.getPatientid());
		System.out.println("Boopalan patient city" + ds.getCity());
		return patientRepo.editCusCity(ds.getCity());
	}

	// public List getcustomer() {

	// return patientRepo.getcustdetail();
	// }

	public List getcustomer(int cid, int bid, int lcname, int lcrefid) throws Exception {

		return patientRepo.getcustdetail(cid, bid, lcname, lcrefid);
	}

	public List getcustcont(int patid) throws Exception {
		return patientRepo.getpatcontact(patid);
	}

//	
//	public boolean savePatrelative(PatientsRelatives prelative) {
//		patientRepo.save();
//		return 
//	}
//	

	public int savepatrelative(List<PatientsRelatives> prelat) throws Exception {
		System.out.println("testing");
		int saveflag = 0;
		// try {
		for (PatientsRelatives temp : prelat) {

			// PatientsRelatives pre:prelat;

			patientrelatives.save(temp);
			System.out.println("testing3");
		}
		// } catch (Exception e) {

		// log.error("Exception in Method : methodName : " + e);
		// }

		saveflag = 1;
		return saveflag;
	}

	public List RefillAlerts(int cid, int bid, int lname, int lid) {
		// TODO Auto-generated method stub
		return patientRepo.RefillAlerts(cid, bid, lname, lid);
	}

	public List GetAllRefillCustomers(int cid, int bid, int lname, int lid) {
		// TODO Auto-generated method stub
		return patientRepo.GetAllRefillCustomers(cid, bid, lname, lid);
	}

	public boolean membership(Patient pt) {
		boolean flag = true;

		if (flag == true) {
			patientRepo.findByIdAndCompanyrefidAndBranchrefidAndLocnameAndLocrefid(pt.getId(), pt.getCompanyrefid(),
					pt.getBranchrefid(), pt.getLocname(), pt.getLocrefid());
			pt.setCustmemberid(pt.getCustmemberid());
			patientRepo.save(pt);
		} else {
			flag = false;
		}
		return flag = true;

	}

	public List getCustomerCategory(Integer cid, Integer bid, Integer lname, Integer lrefid) {
		return patientRepo.getCustomerCategory(cid, bid, lname, lrefid);
	}

	public boolean saveCustomerCategory(PatientType patientType) throws Exception {
		patientTypeRepository.save(patientType);
		return true;
	}

}
