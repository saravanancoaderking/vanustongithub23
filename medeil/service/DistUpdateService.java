package com.medeil.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.medeil.domain.IndCompModel;
import com.medeil.domain.PriceEnquiry;
import com.medeil.repository.DistUpdateRepository;

@Service
public class DistUpdateService {

	private final DistUpdateRepository distupdaterepo;

	private final Logger log = LoggerFactory.getLogger(DistUpdateService.class);

	@Autowired
	DistUpdateService(DistUpdateRepository Distupdaterepo) {

		this.distupdaterepo = Distupdaterepo;

	}

	public List viewPriceEnquiry(IndCompModel loc) throws Exception {

		return distupdaterepo.viewPriceEnquiry(loc.getLocname(), loc.getLocrefid(), loc.getFrmint1(),
				loc.getCompanyid());

	}

	public int updatePriceEnquiry(List<PriceEnquiry> loc) throws Exception {
		int saveflag = 0;

		for (PriceEnquiry temp : loc) {

			if (temp.getDistfinalprice() == null) {
				temp.setDistfinalprice(0.0);

			}
			if (temp.getDistfinalprice() > 1.0 && temp.getDelflag() == true) {

				distupdaterepo.updatePriceEnquiry(temp.getLocname(), temp.getLocrefid(), temp.getId(),
						temp.getDistfinalprice(), temp.getDistremarks(), temp.getClientmdate());

			}

		}

		saveflag = 1;
		return saveflag;

	}

}
