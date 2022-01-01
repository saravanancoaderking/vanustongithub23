package com.medeil.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.medeil.domain.IndCompModel;
import com.medeil.domain.Schemes;
import com.medeil.repository.SchemeRepository;
import com.medeil.util.AutoIncrement;

@Service
public class SchemeService {

	private final SchemeRepository schemerepo;

	private final Logger log = LoggerFactory.getLogger(SchemeService.class);

	@Autowired
	SchemeService(SchemeRepository Schemerepo) {

		this.schemerepo = Schemerepo;

	}

	public int saveScheme(Schemes sch) throws Exception {
		int saveflag = 0;

		int incid = schemerepo.viewSchemeId(sch.getLocname(), sch.getLocrefid());

		String incno = schemerepo.viewSchemeIncNo(sch.getLocname(), sch.getLocrefid(), incid);

		if (incno == null) {

			incno = "0";
		}

		// StringBuilder incr = new StringBuilder(
		// AutoIncrement.getIncrement01(incno));
		// incr.insert(0, "SCH");

		StringBuilder incr = new StringBuilder(
				AutoIncrement.getIncrement03("SCH/", sch.getLocname().toString(), sch.getLocrefid().toString(), incno));

		sch.setSchemeno(incr.toString());
		schemerepo.save(sch);

		saveflag = 1;
		return saveflag;
	}

	public int updateScheme(Schemes sch) throws Exception {
		int saveflag = 0;

		schemerepo.save(sch);

		saveflag = 1;
		return saveflag;
	}

	public List viewSchemeAll(IndCompModel loc) throws Exception {

		return schemerepo.viewSchemeAll(loc.getLocname(), loc.getLocrefid());
	}

	public List viewScheme(IndCompModel loc) throws Exception {

		return schemerepo.viewScheme(loc.getLocname(), loc.getLocrefid(), loc.getFrmint1());
	}

	public Schemes viewSchemeEdit(IndCompModel loc) throws Exception {

		return schemerepo.findById(loc.getFrmint1());
	}

	public int deleteScheme(IndCompModel loc) throws Exception {
		int saveflag = 0;
		schemerepo.deleteScheme(loc.getLocname(), loc.getLocrefid(), loc.getFrmint1());
		saveflag = 1;
		return saveflag;

	}

}
