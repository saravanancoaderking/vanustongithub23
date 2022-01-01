package com.medeil.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.medeil.domain.IndCompModel;
import com.medeil.domain.PharmaCompany;
import com.medeil.repository.PatientRepository;
import com.medeil.repository.PhCompanyRepository;
import com.medeil.util.AutoIncrement;

@Service
public class PhcompanyService {

	private final PhCompanyRepository phcompany;

	private final PatientRepository patientRepo;

	private final Logger log = LoggerFactory.getLogger(PhcompanyService.class);

	@Autowired
	PhcompanyService(PhCompanyRepository phmcompany, PatientRepository custRepo) {

		this.phcompany = phmcompany;
		this.patientRepo = custRepo;

	}

	public int savePhCompany(PharmaCompany phcomp) throws Exception {
		int saveflag = 0;
		int incid = phcompany.viewPhCompanyId(phcomp.getLocname(), phcomp.getLocrefid());

		String incno = phcompany.viewPhCompanyIncNo(phcomp.getLocname(), phcomp.getLocrefid(), incid);

		if (incno == null) {

			incno = "0";
		}

		// StringBuilder incr = new StringBuilder(
		// AutoIncrement.getIncrement01(incno));
		// incr.insert(0, "PHC");
		StringBuilder incr = new StringBuilder(
				AutoIncrement.getIncrement03("PHC/", phcomp.getLocname() + "", phcomp.getLocrefid() + "", incno));

		phcomp.setPhcompanyno(incr.toString());

		phcompany.save(phcomp);

		saveflag = 1;
		return saveflag;
	}

	public int updatePhCompany(PharmaCompany phcomp) throws Exception {
		int saveflag = 0;

		phcompany.save(phcomp);

		saveflag = 1;
		return saveflag;
	}

	public int savecomptype(List<IndCompModel> temp) throws Exception {
		int saveflag = 0;
		int i = 0;
		IndCompModel locnew = temp.get(0);
		i = phcompany.viewPhCompanyId(locnew.getLocname(), locnew.getLocrefid());

		for (IndCompModel loc : temp) {

			phcompany.savecomptype(loc.getLocname(), loc.getLocrefid(), i, loc.getFrmint1());

		}

		saveflag = 1;
		return saveflag;
	}

	public int savedivision(List<IndCompModel> temp) throws Exception {
		int saveflag = 0;
		int i = 0;

		IndCompModel locnew = temp.get(0);
		i = phcompany.viewPhCompanyId(locnew.getLocname(), locnew.getLocrefid());

		for (IndCompModel loc : temp) {

			phcompany.savedivision(loc.getLocname(), loc.getLocrefid(), i, loc.getFrmint1());

		}

		saveflag = 1;
		return saveflag;
	}

	public int updateComptype(List<IndCompModel> temp) throws Exception {
		int saveflag = 0;

		for (IndCompModel loc : temp) {

			phcompany.savecomptype(loc.getLocname(), loc.getLocrefid(), loc.getFrmint1(), loc.getFrmint2());

		}

		saveflag = 1;
		return saveflag;
	}

	public int updateDivision(List<IndCompModel> temp) throws Exception {
		int saveflag = 0;

		for (IndCompModel loc : temp) {

			phcompany.savedivision(loc.getLocname(), loc.getLocrefid(), loc.getFrmint1(), loc.getFrmint2());

		}

		saveflag = 1;
		return saveflag;
	}

	public int saveIndvComptype(IndCompModel loc) throws Exception {
		int saveflag = 0;

		phcompany.saveIndvComptype(loc.getLocname(), loc.getLocrefid(), loc.getFrmstr1());

		saveflag = 1;
		return saveflag;
	}

	public int saveIndvDivision(IndCompModel loc) throws Exception {
		int saveflag = 0;

		// try {
		phcompany.saveIndvDivision(loc.getLocname(), loc.getLocrefid(), loc.getFrmstr1());

		// } catch (Exception e) {

		// log.error("Exception in Method : methodName : " + e);
		// }
		saveflag = 1;
		return saveflag;

	}

	public List viewPhCompanies(IndCompModel loc) throws Exception {

		return phcompany.viewPhCompanies(loc.getLocname(), loc.getLocrefid());

	}

	public PharmaCompany viewPhCompanyEdit(IndCompModel loc) throws Exception {

		return phcompany.findById(loc.getFrmint1());

	}

	public List viewPhCompany(IndCompModel loc) throws Exception {

		return phcompany.viewPhCompany(loc.getLocname(), loc.getLocrefid(), loc.getFrmint1());

	}

	public List viewComptype(IndCompModel loc) throws Exception {

		return phcompany.viewComptype(loc.getLocname(), loc.getLocrefid());

	}

	public List viewDivision(IndCompModel loc) throws Exception {

		return phcompany.viewDivision(loc.getLocname(), loc.getLocrefid());

	}

	public List viewCustComptype(IndCompModel loc) throws Exception {

		return phcompany.viewCustComptype(loc.getLocname(), loc.getLocrefid(), loc.getFrmint1());
	}

	public List viewCustDivision(IndCompModel loc) throws Exception {

		return phcompany.viewCustDivision(loc.getLocname(), loc.getLocrefid(), loc.getFrmint1());

	}

	public int viewPhCompanyId(IndCompModel loc) throws Exception {

		return phcompany.viewPhCompanyId(loc.getLocname(), loc.getLocrefid());

	}

	public int deletePhCompany(IndCompModel loc) throws Exception {
		int saveflag = 0;
		phcompany.deletePhcompany(loc.getLocname(), loc.getLocrefid(), loc.getFrmint1());
		saveflag = 1;
		return saveflag;

	}

	// selva

	public List getPharmacompany(String value) throws Exception {
		return phcompany.getPharmacompany(value);
	}

	/********* Edit State **************/
	// Boopalan 020419
	public List editPCState(IndCompModel pcompanyid) throws Exception {
		PharmaCompany ds = phcompany.findById(pcompanyid.getPcompanyid());
		System.out.println("Boopalan pcompanyid state" + ds.getPstate());
		return phcompany.editPCState(ds.getPstate());
	}

	/********* Edit City **************/
// Boopalan 020419
	public List editPCCity(IndCompModel pcompanyid) throws Exception {
		PharmaCompany ds = phcompany.findById(pcompanyid.getPcompanyid());
		System.out.println("Boopalan pcompanyid city" + ds.getPcity());
		return phcompany.editPCCity(ds.getPcity());
	}

	public ResponseEntity<?> getPharmacompanyList(Integer locrefid, String pharmaname) {
		List list = new ArrayList<>();
		list.add(phcompany.getPharmacompanyList(locrefid, pharmaname));
		return ResponseEntity.created(null).body(list);
	}

}
