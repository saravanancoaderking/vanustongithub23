package com.medeil.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.medeil.domain.DistributorSelect;
import com.medeil.domain.IndCompModel;
import com.medeil.repository.DistSelectRepository;
import com.medeil.util.AutoIncrement;

@Service
public class DistSelectService {

	private DistSelectRepository distSelectrepo;

	private final Logger log = LoggerFactory.getLogger(DistSelectService.class);

	@Autowired
	DistSelectService(DistSelectRepository DistSelectrepo) {

		this.distSelectrepo = DistSelectrepo;

	}

	public int savePriceEnqury(List<DistributorSelect> prc) throws Exception {
		int saveflag = 0;

		int dbsaveflag = 0;
		DistributorSelect prcinc = prc.get(0);

		Double incid = distSelectrepo.viewDistSelectId(prcinc.getLocname(), prcinc.getLocrefid());

		Double incidnu = distSelectrepo.viewDistSelectIdNU(prcinc.getLocname(), prcinc.getLocrefid());

		String incno = distSelectrepo.viewDistSelectIncNo(prcinc.getLocname(), prcinc.getLocrefid(), incid);

		if (incno == null) {

			incno = "0";
		}

		if (incidnu == null) {

			incidnu = 0.0;

		}

		incidnu += 1;

		/*
		 * StringBuilder incr = new StringBuilder( AutoIncrement.getIncrement01(incno));
		 * incr.insert(0, "DIST/SLCT");
		 */

		StringBuilder incr = new StringBuilder(AutoIncrement.getIncrement03("DIST/SLCT", prcinc.getLocname().toString(),
				prcinc.getLocrefid().toString(), incno));
		for (DistributorSelect temp : prc) {

			if (temp.getCalcflag() != 1 && temp.getVendorslctflag() == true) {

				temp.setDistslctno(incr.toString());
				temp.setDistslctid(incidnu);

				distSelectrepo.save(temp);

				dbsaveflag = 1;

			}

		}

		if (dbsaveflag == 1) {
			distSelectrepo.updatePriceEnquiry(prcinc.getLocname(), prcinc.getLocrefid(), prcinc.getPrcenqrefid());
			saveflag = 1;
		}

		return saveflag;

	}

	public int saveDistSelect(List<DistributorSelect> prc) throws Exception {
		int saveflag = 0;
		for (DistributorSelect temp : prc) {
			if (temp.getCalcflag() != 1) {
				distSelectrepo.save(temp);
			}

		}
		saveflag = 1;
		return saveflag;

	}

	public List viewPriceEnquiryNo(IndCompModel loc) throws Exception {

		return distSelectrepo.viewPriceEnquiryNo(loc.getLocname(), loc.getLocrefid());

	}

	public List viewDistSelectNo(IndCompModel loc) throws Exception {

		return distSelectrepo.viewDistSelectNo(loc.getLocname(), loc.getLocrefid());

	}

	public List viewPriceEnquiry(IndCompModel loc) throws Exception {

		return distSelectrepo.viewPriceEnquiry(loc.getLocname(), loc.getLocrefid(), loc.getFrmint1(),
				loc.getCompanyid());

	}

	public List viewDistSelectAll(IndCompModel loc) throws Exception {

		return distSelectrepo.viewDistSelectAll(loc.getLocname(), loc.getLocrefid());

	}

	public List viewDistSelectNewAll(IndCompModel loc) throws Exception {

		return distSelectrepo.viewDistSelectNewAll(loc.getLocname(), loc.getLocrefid(), loc.getCompanyid());

	}

	public List viewDistSelect(IndCompModel loc) throws Exception {

		return distSelectrepo.viewDistSelect(loc.getLocname(), loc.getLocrefid(), loc.getFrmint1(), loc.getCompanyid());

	}

}
