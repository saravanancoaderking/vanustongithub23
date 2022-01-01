package com.medeil.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.medeil.domain.IndCompModel;
import com.medeil.domain.PriceEnquiry;
import com.medeil.repository.PriceEnquiryRepository;
import com.medeil.util.AutoIncrement;

@Service
public class PrcEnqiryService {

	private final PriceEnquiryRepository priceenquiryrepo;

	private final Logger log = LoggerFactory.getLogger(DebitService.class);

	@Autowired
	PrcEnqiryService(PriceEnquiryRepository Priceenquiryrepo) {

		this.priceenquiryrepo = Priceenquiryrepo;

	}

	public int savePriceEnquiry(List<PriceEnquiry> prc) throws Exception {

		int saveflag = 0;
		PriceEnquiry prcinc = prc.get(0);

		Double incid = priceenquiryrepo.viewPrcEncId(prcinc.getLocname(), prcinc.getLocrefid());
		Double incidnu = priceenquiryrepo.viewPrcEncIdNU(prcinc.getLocname(), prcinc.getLocrefid());

		String incno = priceenquiryrepo.viewPrcEncIncNo(prcinc.getLocname(), prcinc.getLocrefid(), incid);

		if (incno == null) {

			incno = "0";
		}

		if (incidnu == null) {

			incidnu = 0.0;

		}

		incidnu += 1;

		for (PriceEnquiry temp : prc) {

			if (temp.getCalcflag() != 1) {
				// StringBuilder incr = new StringBuilder(
				// AutoIncrement.getIncrement01(incno));
				// incr.insert(0, "PRC/ENQ");
				StringBuilder incr = new StringBuilder(AutoIncrement.getIncrement03("PRC/ENQ/",
						prcinc.getLocname().toString(), prcinc.getLocrefid().toString(), incno));

				temp.setPrcencno(incr.toString());
				temp.setPrcencid(incidnu);

				priceenquiryrepo.save(temp);
				priceenquiryrepo.updatepsflag(prcinc.getCompanyrefid(), prcinc.getBranchrefid(), prcinc.getLocname(),
						prcinc.getLocrefid(), prcinc.getPurchsessionid(), prcinc.getDrugproductrefid());

			}

		}

		priceenquiryrepo.updatePurcSession(prcinc.getLocname(), prcinc.getLocrefid(), prcinc.getPurchsessionid());

		saveflag = 1;
		return saveflag;

	}

	public List viewPurchSession(IndCompModel loc) throws Exception {

		return priceenquiryrepo.viewPurchSession(loc.getLocname(), loc.getLocrefid());

	}

	public List viewPurchSessionProd(IndCompModel loc) throws Exception {

		return priceenquiryrepo.viewPurchSessionProd(loc.getLocname(), loc.getLocrefid(), loc.getFrmint1(),
				loc.getCompanyid());

	}

	// Boopalan 030719
	public List viewProdWiseDist(IndCompModel loc) throws Exception {

		return priceenquiryrepo.viewProdWiseDist(loc.getLocname(), loc.getLocrefid(), loc.getFrmint1());

	}

	public List viewPriceEnquiryAll(IndCompModel loc) throws Exception {

		return priceenquiryrepo.viewPriceEnquiryAll(loc.getLocname(), loc.getLocrefid());

	}

	public List viewPriceEnquiryNewAll(IndCompModel loc) throws Exception {

		return priceenquiryrepo.viewPriceEnquiryNewAll(loc.getLocname(), loc.getLocrefid(), loc.getCompanyid());

	}

	public List viewPriceEnquiryProd(IndCompModel loc) throws Exception {

		return priceenquiryrepo.viewPriceEnquiryProd(loc.getLocname(), loc.getLocrefid(), loc.getFrmint1(),
				loc.getCompanyid());

	}

	// selva

	public List getDisPriceEnq(int compid, int branchid, int locname, int locrefid) throws Exception {
		// System.out.println("Checkedddddddddddddd");
		return priceenquiryrepo.getDisPriceEnq(compid, branchid, locname, locrefid);
	}

	public List getDate(int compid, int branchid, int locname, int locrefid, int vendorid) throws Exception {

		return priceenquiryrepo.getDate(compid, branchid, locname, locrefid, vendorid);
	}

	public List getDistProd(int compid, int branchid, int locname, int locrefid, int vendorid, String cdate)
			throws Exception {

		return priceenquiryrepo.getDistProd(compid, branchid, locname, locrefid, vendorid, cdate);
	}

	public List viewDistPreviousPrice(IndCompModel loc) {
		return priceenquiryrepo.viewDistPreviousPrice(loc.getCompanyid(),loc.getLocname(), loc.getLocrefid(),loc.getDistributorid(),loc.getPrice());
	}

}
