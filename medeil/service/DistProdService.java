package com.medeil.service;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.medeil.domain.DistributortProd;
import com.medeil.domain.IndCompModel;
import com.medeil.repository.DistProdRepository;
import com.medeil.repository.PatientDetailRepository;
import com.medeil.util.AutoIncrement;

@Service
public class DistProdService {

	private  DistProdRepository distProdRepo;

	private  PatientDetailRepository ptdetailRepo;

	private  Logger log = LoggerFactory.getLogger(PatientService.class);

	@Autowired
	DistProdService(DistProdRepository DistProdRepo, PatientDetailRepository patdetailRepo) {

		this.distProdRepo = DistProdRepo;

		this.ptdetailRepo = patdetailRepo;
	}

	public int saveDistProd(List<DistributortProd> dist) throws Exception {
		int saveflag = 0;
		DistributortProd stk = dist.get(0);

		Double incid = distProdRepo.viewDistProductId(stk.getLocname(), stk.getLocrefid());

		Double incidnu = distProdRepo.viewDistProductIdNU(stk.getLocname(), stk.getLocrefid());

		String incno = distProdRepo.viewDistProductIncNo(stk.getLocname(), stk.getLocrefid(), incid);

		if (incno == null) {

			incno = "0";
		}

		if (incidnu == null) {

			incidnu = 0.0;

		}

		incidnu += 1;

		for (DistributortProd temp : dist) {

			if (temp.getCalcflag() != 1) {

				// StringBuilder incr = new StringBuilder(
				// AutoIncrement.getIncrement03( incno));
				StringBuilder incr = new StringBuilder(AutoIncrement.getIncrement03("DST/PROD",
						stk.getLocname().toString(), stk.getLocrefid().toString(), incno));

				// incr.insert(0, "DST/PROD");

				temp.setDistprodno(incr.toString());

				temp.setDistprdlocid(incidnu);

				Integer chk = distProdRepo.checkDistProd(temp.getDistrefid(), temp.getDrugprdid());
				if (chk < 1) {
					distProdRepo.save(temp);
				}

			}

		}

		saveflag = 1;
		return saveflag;
	}

	public int updateDistProd(List<DistributortProd> dist) throws Exception {
		int saveflag = 0;
		for (DistributortProd temp : dist) {

			if (temp.getCalcflag() != 1) {

				if (temp.getDelflag() == true) {
					temp.setStatus(5.0);

				} else {

					temp.setStatus(0.0);
				}

				distProdRepo.save(temp);

			}

		}

		saveflag = 1;
		return saveflag;

	}

	public List viewDistProd() throws Exception {

		return distProdRepo.findAll();

	}

	// Boopalan 270619
	public List viewDistributors(IndCompModel loc) throws Exception {
		System.out.println("comp" + loc.getCompanyrefid());

		return distProdRepo.viewDistributors(loc.getCompanyrefid());

	}

	public List viewCustProducts(IndCompModel loc) throws Exception {

		return distProdRepo.viewCustProducts(loc.getLocname(), loc.getLocrefid(), loc.getFrmstr1(), loc.getCompanyid());

	}

	public List viewCustProduct(IndCompModel loc) throws Exception {

		return distProdRepo.viewCustProduct(loc.getFrmint1(), loc.getFrmint2(), loc.getCompanyid());

	}

	public List viewDistProdWhole(IndCompModel loc) throws Exception {

		return distProdRepo.viewDistProdWhole(loc.getCompanyid(), loc.getFrmint1());

	}

	public List viewDistProdAll(IndCompModel loc) throws Exception {

		return distProdRepo.viewDistProdAll(loc.getLocname(), loc.getLocrefid());

	}

	public List viewDistProd(IndCompModel loc) throws Exception {

		return distProdRepo.viewDistProd(loc.getLocname(), loc.getLocrefid(), loc.getFrmint1(), loc.getCompanyid());

	}

	public List viewPhCompanies(IndCompModel loc) throws Exception {

		return distProdRepo.viewPhCompanies(loc.getLocname(), loc.getLocrefid());

	}

	public List viewProductPhComp(IndCompModel loc) throws Exception {

		return distProdRepo.viewProductPhComp(loc.getLocname(), loc.getLocrefid(), loc.getFrmint1(),
				loc.getCompanyid());

	}

	public int deleteDistProd(IndCompModel loc) throws Exception {
		int saveflag = 0;
		distProdRepo.deleteDistProd(loc.getLocname(), loc.getLocrefid(), loc.getFrmint1());
		saveflag = 1;
		return saveflag;

	}

	public int updateDistProdDetails(DistributortProd distributortProds) {
		DistributortProd prod = distProdRepo.findById(distributortProds.getId()).get();
		prod.setDistprice(distributortProds.getDistprice());
		prod.setRemarks(distributortProds.getRemarks());
		distProdRepo.save(prod);
		return 1;
	}

}
