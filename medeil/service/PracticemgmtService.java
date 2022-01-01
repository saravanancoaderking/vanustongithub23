package com.medeil.service;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.medeil.domain.IndCompModel;
import com.medeil.domain.MainPrescription;
import com.medeil.domain.PrescriptionProduct;
import com.medeil.repository.PracticemanagementRepository;
import com.medeil.repository.PrescriptionproductRepository;

@SuppressWarnings("rawtypes")
@Service
public class PracticemgmtService {

	@Autowired
	PracticemanagementRepository practicemgmtRepository;

	@Autowired
	PrescriptionproductRepository prescriptionproRepository;

	public ResponseEntity<Boolean> savePracticeManagement(MainPrescription pres) {
		String lastid = practicemgmtRepository.lastPurchaseOrder(pres.getCompanyrefid(), pres.getBranchrefid(),
				pres.getLocname(), pres.getLocrefid());
		String oldInco = lastid.substring(lastid.length() - 9, lastid.length());
		Long newInco = Long.parseLong(oldInco) + 1;
		String newid = StringUtils.leftPad(newInco.toString(), 9, "0");
		pres.setMainpresno("PRE" + newid);
		practicemgmtRepository.save(pres);
		return ResponseEntity.created(null).body(true);
	}

	public ResponseEntity<Boolean> savePracticeManagementprod(List<PrescriptionProduct> prespro) {
		for (PrescriptionProduct prescriptionProduct : prespro) {
			prescriptionProduct.setMainpresrefid(practicemgmtRepository.getpracticemgmtID());
			prescriptionproRepository.save(prescriptionProduct);
		}
		return ResponseEntity.created(null).body(true);
	}

	public List viewpractise(Integer comid, Integer branchid, Integer locname, Integer locrefid) {
		return practicemgmtRepository.getpractisemanag(comid, branchid, locname, locrefid);
	}

	public boolean deleteprac(Integer id, Integer comid, Integer locrefid) {
		System.out.println("Raja View service");
		boolean del = false;
		practicemgmtRepository.deletepm(id, comid, locrefid);
		return del = true;

	}

	public List getpractisedetails(Integer id) {
		return practicemgmtRepository.findById(id);
	}

	public List getpractiseproddetails(Integer id) {
		return prescriptionproRepository.getprespro(id);
	}

	public boolean delprespro(Integer id, Integer Prodid) {
		boolean del = false;
		prescriptionproRepository.delupdate(id, Prodid);
		return del = true;
	}

	public Boolean updatePrac(MainPrescription pres) throws Exception {

		practicemgmtRepository.save(pres);
		System.out.println("Service Practise");
		return true;
	}

	public Boolean updatePracprod(List<PrescriptionProduct> updatePracprod) {
		prescriptionproRepository.saveAll(updatePracprod);
		return true;

	}
	
	public List viewcustpractise(Integer comid, Integer branchid, Integer locname, Integer locrefid, Integer custid) {
		return practicemgmtRepository.getcustpractisemanag(comid, branchid, locname, locrefid, custid);
	}

	public List viewPractiseProd(IndCompModel loc) throws Exception {
		return practicemgmtRepository.viewPractiseProd(loc.getLocname(), loc.getLocrefid(), loc.getSorderid());
	}

}
