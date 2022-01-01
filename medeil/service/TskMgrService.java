package com.medeil.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.medeil.domain.IndCompModel;
import com.medeil.domain.TaskManager;
import com.medeil.repository.TskMgrRepository;
import com.medeil.util.AutoIncrement;

@Service
public class TskMgrService {

	private final TskMgrRepository tskmgrrepo;

	private final Logger log = LoggerFactory.getLogger(TskMgrService.class);

	@Autowired
	TskMgrService(TskMgrRepository Tskmgrrepo) {

		this.tskmgrrepo = Tskmgrrepo;

	}

	public int saveTskMgr(List<TaskManager> tm) throws Exception {
		int saveflag = 0;
		TaskManager tminc = tm.get(0);

		int incid = tskmgrrepo.viewTskMgrId(tminc.getLocname(), tminc.getLocrefid());

		Integer incidnu = tskmgrrepo.viewTskMgrIdNU(tminc.getLocname(), tminc.getLocrefid());
		String incno = tskmgrrepo.viewTskMgrIncNo(tminc.getLocname(), tminc.getLocrefid(), incid);
		if (incno == null) {

			incno = "0";
		}

		if (incidnu == null) {

			incidnu = 0;

		}

		incidnu += 1;

		for (TaskManager temp : tm) {

			if (temp.getCalcflag() != 1) {
				// StringBuilder incr = new StringBuilder(
				// AutoIncrement.getIncrement01(incno));
				// incr.insert(0, "TSK/MG");

				StringBuilder incr = new StringBuilder(AutoIncrement.getIncrement03("TSK/MG/",
						tminc.getLocname().toString(), tminc.getLocrefid().toString(), incno));

				temp.setTskmgno(incr.toString());
				temp.setTskmgid(incidnu);

				tskmgrrepo.save(temp);

			}

		}
		saveflag = 1;
		return saveflag;

	}

	public List viewTskMgrAll(IndCompModel loc) throws Exception {

		return tskmgrrepo.viewTskMgrAll(loc.getLocname(), loc.getLocrefid());

	}

	public List viewTskMgr(IndCompModel loc) throws Exception {

		return tskmgrrepo.viewTskMgr(loc.getLocname(), loc.getLocrefid(), loc.getFrmint1(), loc.getCompanyid());

	}

	public List viewEmployees(IndCompModel loc) throws Exception {

		return tskmgrrepo.viewEmployees(loc.getLocname(), loc.getLocrefid());

	}

	public int deleteTskMgr(IndCompModel loc) throws Exception {
		int saveflag = 0;
		tskmgrrepo.deleteTskMgr(loc.getLocname(), loc.getLocrefid(), loc.getFrmint1());
		saveflag = 1;
		return saveflag;

	}

}
