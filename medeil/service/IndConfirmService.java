package com.medeil.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.medeil.domain.DistributortProd;
import com.medeil.domain.IndCompModel;
import com.medeil.domain.IndentConfirm;
import com.medeil.domain.IndentProducts;
import com.medeil.repository.IndtConfirmRepository;
import com.medeil.repository.PatientRepository;
import com.medeil.util.AutoIncrement;

@Service
public class IndConfirmService {

	private final IndtConfirmRepository indtConfirmrepo;

	private final PatientRepository patientRepo;

	private final Logger log = LoggerFactory.getLogger(PatientService.class);

	@Autowired
	IndConfirmService(IndtConfirmRepository IndtConfirmrepo, PatientRepository PatientRepo) {

		this.indtConfirmrepo = IndtConfirmrepo;
		this.patientRepo = PatientRepo;

	}

	public int saveIndentConfirm(IndentConfirm indt) throws Exception {
		int saveflag = 0;
		Double incid = indtConfirmrepo.viewIndentConfirmId(indt.getLocname(), indt.getLocrefid());

		String incno = indtConfirmrepo.viewIndentConfirmIncNo(indt.getLocname(), indt.getLocrefid(), incid);

		if (incno == null) {

			incno = "0";
		}
		try {

			// StringBuilder incr = new StringBuilder(
			// AutoIncrement.getIncrement01(incno));
			// incr.insert(0, "IND/CNF");

			StringBuilder incr = new StringBuilder(AutoIncrement.getIncrement03("IND/CNF", indt.getLocname().toString(),
					indt.getLocrefid().toString(), incno));

			indt.setIndapprno(incr.toString());

			indtConfirmrepo.save(indt);

		} catch (Exception e) {

			e.printStackTrace();
			log.error("Exception in Method : methodName : " + e);
		}
		saveflag = 1;
		return saveflag;
	}

	public int saveIndentConfirmProd(List<IndentProducts> indt) throws Exception {
		int saveflag = 0;
		try {
			for (IndentProducts temp : indt) {
				if (temp.getCalcflag() != 1) {

					indtConfirmrepo.updIntProdAvailqtySave(temp.getIndentrefid(), temp.getDrugprdrefid(),
							temp.getApprovedqty(), temp.getRemarksappr());
				}
			}

			IndentProducts temp1 = indt.get(0);

			indtConfirmrepo.updateIndApprFlag(temp1.getIndentrefid()

			);

		} catch (Exception e) {

			e.printStackTrace();
			log.error("Exception in Method : methodName : " + e);
			throw new Exception(e);
		}
		saveflag = 1;
		return saveflag;
	}

	public int updateIndentConfirm(List<IndentConfirm> indt) throws Exception {
		int saveflag = 0;
		saveflag = 1;
		return saveflag;
	}

	public List viewIndentreq(IndCompModel loc) throws Exception {

		return indtConfirmrepo.viewIndentreq(loc.getLocname(), loc.getLocrefid());
	}

	public List viewSelIndentproduct(IndCompModel loc) throws Exception {

		return indtConfirmrepo.viewSelIndentproduct(loc.getLocname(), loc.getLocrefid(), loc.getFrmint1(),
				loc.getCompanyid());
	}

	public List viewIndentConfirmAll(IndCompModel loc) throws Exception {

		return indtConfirmrepo.viewIndentConfirmAll(loc.getLocname(), loc.getLocrefid());
	}

	public List viewIndentConfirmNo(IndCompModel loc) throws Exception {

		return indtConfirmrepo.viewIndentConfirmNo(loc.getLocname(), loc.getLocrefid(), loc.getFrmint1());
	}

	public List viewLocName(IndCompModel loc) throws Exception {

		List locname = null;
		if (loc.getFrmint1() == 1) {

			locname = indtConfirmrepo.viewShopName(loc.getLocrefid());

		} else if (loc.getFrmint1() == 2) {

			locname = indtConfirmrepo.viewShopName(loc.getLocrefid());
		} else if (loc.getFrmint1() == 3) {

			locname = indtConfirmrepo.viewShopName(loc.getLocrefid());
		}

		else if (loc.getFrmint1() == 4) {

			locname = indtConfirmrepo.viewShopName(loc.getLocrefid());

		}

		else if (loc.getFrmint1() == 5) {

			locname = indtConfirmrepo.viewShopName(loc.getFrmint2());

		}

		return locname;

	}

	public List viewIndentReqSelect(IndCompModel loc) throws Exception {

		return indtConfirmrepo.viewIndentReqSelect(loc.getLocname(), loc.getLocrefid(), loc.getFrmint1(),
				loc.getFrmint2());
	}

}
