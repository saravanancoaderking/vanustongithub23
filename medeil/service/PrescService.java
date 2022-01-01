package com.medeil.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.medeil.domain.IndCompModel;
import com.medeil.domain.PrescProd;
import com.medeil.domain.Prescription;
import com.medeil.repository.PrescProdRepository;
import com.medeil.repository.PrescRepository;
import com.medeil.util.AutoIncrement;

@Service
public class PrescService {

	private final Logger log = LoggerFactory.getLogger(PrescService.class);

	private final PrescRepository prescRepo;

	private final PrescProdRepository prcprodRepo;

	@Autowired
	PrescService(PrescRepository PrescRepo, PrescProdRepository PrcprodRepo) {

		this.prescRepo = PrescRepo;
		this.prcprodRepo = PrcprodRepo;

	}

	public int savePrescription(Prescription prc) throws Exception {
		int saveflag = 0;

		Double incid = prescRepo.viewPrescId(prc.getLocrefid(), prc.getLocname());

		String incno = prescRepo.viewPrescIncNo(incid, prc.getLocrefid(), prc.getLocname());
		if (incno == null) {

			incno = "0";
		}

		StringBuilder incr = new StringBuilder(AutoIncrement.getIncrement01(incno));

		incr.insert(0, "PRC");

		prc.setPrcno(incr.toString());
		prescRepo.save(prc);

		saveflag = 1;
		return saveflag;

	}

	public int savePrescProd(List<PrescProd> pres) throws Exception {
		int saveflag = 0;
		Double psid = 0.0;

		PrescProd psinc = pres.get(0);

		psid = prescRepo.viewPrescId(psinc.getLocrefid(), psinc.getLocname());
		for (PrescProd temp : pres) {

			temp.setPrsrefid(psid);

			prcprodRepo.save(temp);
		}

		saveflag = 1;
		return saveflag;

	}

	public int updatePrescription(Prescription prc) throws Exception {
		int saveflag = 0;
		prescRepo.save(prc);
		saveflag = 1;
		return saveflag;
	}

	public int updatePrescProd(List<PrescProd> pres) throws Exception {
		int saveflag = 0;
		PrescProd psinc = pres.get(0);

		for (PrescProd temp : pres) {

			temp.setPrsrefid(psinc.getPrsrefid());

			prcprodRepo.save(temp);
		}

		saveflag = 1;
		return saveflag;

	}

	public List viewCustomers(IndCompModel loc) throws Exception {

		return prescRepo.viewCustomers(loc.getLocrefid(), loc.getLocname());

	}

	public List viewDoctors(IndCompModel loc) throws Exception {

		return prescRepo.viewDoctors(loc.getLocrefid(), loc.getLocname());

	}

	public List viewPrescAll(IndCompModel loc) throws Exception {

		return prescRepo.viewPrescAll(loc.getLocrefid(), loc.getLocname());

	}

	public List viewPresc(IndCompModel loc) throws Exception {

		return prescRepo.viewPresc(loc.getFrmint1(), loc.getLocrefid(), loc.getLocname());

	}

	public List viewPrescProducts(IndCompModel loc) throws Exception {

		return prcprodRepo.viewPrescProducts(loc.getFrmint1(), loc.getLocrefid(), loc.getLocname());

	}

	public List viewProductNames(IndCompModel loc) throws Exception {

		return prescRepo.viewProductNames(loc.getFrmstr1(), loc.getLocrefid(), loc.getLocname());

	}

	public List viewProductName(IndCompModel loc) throws Exception {

		return prescRepo.viewProductName(loc.getFrmint1(), loc.getLocrefid(), loc.getLocname());

	}

	public List checkInteration(IndCompModel loc) throws Exception {

		return prescRepo.checkInteration(loc.getFrmint1(), loc.getFrmint2(), loc.getFrmstr1(), loc.getFrmstr2());

	}

	public int deletePrescription(IndCompModel loc) throws Exception {
		int saveflag = 0;
		prescRepo.deletePrescription(loc.getFrmint1(), loc.getLocrefid(), loc.getLocname());
		saveflag = 1;
		return saveflag;

	}

}
