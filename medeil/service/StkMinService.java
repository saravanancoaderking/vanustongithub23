package com.medeil.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.medeil.domain.IndCompModel;
import com.medeil.domain.StkMinQty;
import com.medeil.repository.StkMinRepository;
import com.medeil.util.AutoIncrement;

@Service
public class StkMinService {

	@PersistenceContext
	EntityManager em;

	private final StkMinRepository stkminrepo;

	private final Logger log = LoggerFactory.getLogger(StkReturnService.class);

	@Autowired
	StkMinService(StkMinRepository Stkminrepo) {

		this.stkminrepo = Stkminrepo;

	}

	public int saveStkMinQty(List<StkMinQty> stk) throws Exception {
		int saveflag = 0;
		StkMinQty stkinc = stk.get(0);

		Double incid = stkminrepo.viewStkMinQtyId(stkinc.getLocname(), stkinc.getLocrefid());

		Double incidnu = stkminrepo.viewStkMinQtyIdNU(stkinc.getLocname(), stkinc.getLocrefid());

		String incno = stkminrepo.viewStkMinQtyIncNo(stkinc.getLocname(), stkinc.getLocrefid(), incid);

		if (incno == null) {

			incno = "0";

		}

		if (incidnu == null) {

			incidnu = 0.0;

		}

		incidnu += 1;

		for (StkMinQty temp : stk) {

			if (temp.getSelectflag() == true && temp.getCalcflag() != 1) {
				// StringBuilder incr = new StringBuilder(
				// AutoIncrement.getIncrement01(incno));
				// incr.insert(0, "STK/MIN");

				StringBuilder incr = new StringBuilder(AutoIncrement.getIncrement03("STK/MIN/",
						stkinc.getLocname().toString(), stkinc.getLocrefid().toString(), incno));

				temp.setStkminno(incr.toString());
				temp.setStkminid(incidnu);
				// Boopalan grid color
				stkminrepo.gridColorMinimumStock(temp.getCompanyrefid(), temp.getBranchrefid(), temp.getLocname(),
						temp.getLocrefid(), temp.getDrugproductid());

				// updatestkminrefid(stkinc.getCompanyrefid(),stkinc.getBranchrefid(),stkinc.getLocname(),
				// stkinc.getLocrefid(),stkinc.getDrugproductid());
				stkminrepo.save(temp);

			}

		}

		saveflag = 1;
		return saveflag;

	}

	// Boopalan 060519
	public List viewMinimumStock(IndCompModel loc) throws Exception {

		return stkminrepo.viewMinimumStock(loc.getCompanyrefid(), loc.getBranchrefid(), loc.getLocname(),
				loc.getLocrefid());

	}

	public List viewMinimumProdNew(IndCompModel loc) throws Exception {

		return stkminrepo.viewMinimumProdNew(loc.getCompanyrefid(), loc.getBranchrefid(), loc.getLocname(),
				loc.getLocrefid());

	}

	public List viewStkMinQtyAll(IndCompModel loc) throws Exception {

		return stkminrepo.viewStkMinQtyAll(loc.getCompanyrefid(), loc.getBranchrefid(), loc.getLocname(),
				loc.getLocrefid());

	}

	public List viewStk1MinQtyAll(IndCompModel loc) throws Exception {
		System.out.println("Inside service");
		System.out.println("Inside viewStk1MinQtyAll1" + loc.getCompanyrefid());
		System.out.println("Inside viewStk1MinQtyAll2" + loc.getBranchrefid());
		System.out.println("Inside viewStk1MinQtyAll3" + loc.getLocname());
		System.out.println("Inside viewStk1MinQtyAll4" + loc.getLocrefid());
		System.out.println("Inside viewStk1MinQtyAll5" + loc.getStkminid());
		return stkminrepo.viewStk1MinQtyAll(loc.getCompanyrefid(), loc.getBranchrefid(), loc.getLocname(),
				loc.getLocrefid(), loc.getStkminid());
	}

	// Boopalan 060519 added stm.Qty,stm.locname, stm.locrefid
	public List viewStkMinQty(IndCompModel loc) throws Exception {

		return stkminrepo.viewStkMinQty(loc.getCompanyrefid(), loc.getBranchrefid(), loc.getLocname(),
				loc.getLocrefid(), loc.getStkminid());

	}

	// StkMinService

	// Boopalan 190719
	public void updateMinimumStock() {
		try {
			String q = "Call medc_stock.medc_minimumstocks()";
			Query query = em.createNativeQuery(q);
			List list = query.getResultList();
		} catch (Exception e) {
			log.info("updateMinimumStock Scheduler is running ");

		}

	}

	public int updatestkproduct(List<StkMinQty> stkproduct) throws Exception {
		int updateflag = 1;
		System.out.println("inside service");
		stkminrepo.updatestkproduct(stkproduct.get(0).getCompanyrefid(), stkproduct.get(0).getBranchrefid(),
				stkproduct.get(0).getLocname(), stkproduct.get(0).getLocrefid(), stkproduct.get(0).getStkminid());

		System.out.println("inside service1");

		for (int i = 0; i < stkproduct.size(); i++) {

			stkproduct.get(i).setUpdateflag(1);

			// System.out.println("ipdte flag" + newproduct.get(i).getUpdateflag());

		}

		stkminrepo.saveAll(stkproduct);

		System.out.println("inside service2");

		updateflag = 1;
		return updateflag;
	}

}
