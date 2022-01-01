package com.medeil.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.medeil.domain.IndCompModel;
import com.medeil.domain.PickList;
import com.medeil.repository.PickListRepository;
import com.medeil.util.AutoIncrement;

@Service
public class PickListService {

	private final PickListRepository picklistrepo;

	private final Logger log = LoggerFactory.getLogger(PickListRepository.class);

	@Autowired
	PickListService(PickListRepository Picklistrepo) {

		this.picklistrepo = Picklistrepo;

	}

	public int savePickList(List<PickList> pck) throws Exception {
		int saveflag = 0;
		PickList pckinc = pck.get(0);

		Integer incid = picklistrepo.viewPickListId(pckinc.getLocname(), pckinc.getLocrefid());

		Integer incidnu = picklistrepo.viewPickListIdNU(pckinc.getLocname(), pckinc.getLocrefid());
		String incno = picklistrepo.viewPickListIncNo(pckinc.getLocname(), pckinc.getLocrefid(), incid);
		if (incno == null) {

			incno = "0";
		}

		if (incidnu == null) {

			incidnu = 0;

		}

		incidnu += 1;

		for (PickList temp : pck) {

			if (temp.getCalcflag() != 1) {
				// StringBuilder incr = new StringBuilder(
				// AutoIncrement.getIncrement01(incno));
				// incr.insert(0, "PICK/LST");
				StringBuilder incr = new StringBuilder(AutoIncrement.getIncrement03("PICK/LST/",
						pckinc.getLocname().toString(), pckinc.getLocrefid().toString(), incno));

				temp.setPicklistno(incr.toString());
				temp.setPicklistid(incidnu);

				picklistrepo.save(temp);

			}

		}
		saveflag = 1;
		return saveflag;

	}

	public List viewPickListAll(IndCompModel loc) throws Exception {

		return picklistrepo.viewPickListAll(loc.getLocname(), loc.getLocrefid());

	}

	public List viewPickList(IndCompModel loc) throws Exception {

		return picklistrepo.viewPickList(loc.getLocname(), loc.getLocrefid(), loc.getFrmint1(), loc.getCompanyid());

	}

	public List viewCustProducts(IndCompModel loc) throws Exception {

		return picklistrepo.viewCustProducts(loc.getLocname(), loc.getLocrefid(), loc.getFrmstr1());

	}

	public List viewCustProduct(IndCompModel loc) throws Exception {

		return picklistrepo.viewCustProduct(loc.getLocname(), loc.getLocrefid(), loc.getFrmint1());

	}

	public List viewEmployees(IndCompModel loc) throws Exception {

		return picklistrepo.viewEmployees(loc.getLocname(), loc.getLocrefid());

	}

	public List viewCustomers(IndCompModel loc) throws Exception {

		return picklistrepo.viewCustomers(loc.getLocname(), loc.getLocrefid());

	}

	public int deletePickList(IndCompModel loc) throws Exception {
		int saveflag = 0;
		picklistrepo.deletePickList(loc.getLocname(), loc.getLocrefid(), loc.getFrmint1());
		saveflag = 1;
		return saveflag;

	}

}
