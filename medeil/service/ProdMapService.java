package com.medeil.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.medeil.domain.IndCompModel;
import com.medeil.domain.ProductMap;
import com.medeil.repository.ProdMapRepository;
import com.medeil.util.AutoIncrement;

@Service
public class ProdMapService {

	private final ProdMapRepository prodmaprepo;

	private final Logger log = LoggerFactory.getLogger(ProdMapService.class);

	@Autowired
	ProdMapService(ProdMapRepository Prodmaprepo) {

		this.prodmaprepo = Prodmaprepo;

	}

	public int saveProdMap(List<ProductMap> prod) throws Exception {
		int saveflag = 0;
		ProductMap prodinc = prod.get(0);

		Double incid = prodmaprepo.viewProdMapId(prodinc.getLocrefid(), prodinc.getLocname());

		Double incidnu = prodmaprepo.viewProdMapIdNU(prodinc.getLocrefid(), prodinc.getLocname());

		String incno = prodmaprepo.viewProdMapIncNo(incid, prodinc.getLocrefid(), prodinc.getLocname());
		if (incno == null) {

			incno = "0";
		}

		if (incidnu == null) {

			incidnu = 0.0;

		}

		incidnu += 1;

		for (ProductMap temp : prod) {
			if (temp.getCalcflag() != 1) {
				// StringBuilder incr = new StringBuilder(
				// AutoIncrement.getIncrement01(incno));
				// incr.insert(0, "PROD/MAP");

				StringBuilder incr = new StringBuilder(AutoIncrement.getIncrement03("PROD/MAP/",
						prodinc.getLocname().toString(), prodinc.getLocrefid().toString(), incno));

				temp.setProdmapno(incr.toString());
				temp.setProdmapid(incidnu);

				prodmaprepo.save(temp);

			}

		}
		saveflag = 1;
		return saveflag;

	}

	public int updateProdMap(List<ProductMap> prod) throws Exception {

		int saveflag = 0;
		ProductMap prodinc = prod.get(0);

		for (ProductMap temp : prod) {
			if (temp.getCalcflag() != 1) {

				temp.setProdmapid(prodinc.getProdmapid());
				prodmaprepo.save(temp);

			}

		}
		saveflag = 1;
		return saveflag;

	}

	public List viewCustProducts(IndCompModel loc) throws Exception {

		return prodmaprepo.viewCustProducts(loc.getFrmstr1(), loc.getLocrefid(), loc.getLocname());

	}

	public List viewCustProduct(IndCompModel loc) throws Exception {

		return prodmaprepo.viewCustProduct(loc.getFrmint1(), loc.getLocrefid(), loc.getLocname());

	}

	public List viewCustProducts1(IndCompModel loc) throws Exception {

		return prodmaprepo.viewCustProducts(loc.getFrmstr1(), loc.getLocrefid(), loc.getLocname());

	}

	public List viewCustProduct1(IndCompModel loc) throws Exception {

		return prodmaprepo.viewCustProduct(loc.getFrmint1(), loc.getLocrefid(), loc.getLocname());

	}

	public List viewProdMapAll(IndCompModel loc) throws Exception {

		return prodmaprepo.viewProdMapAll(loc.getLocrefid(), loc.getLocname());

	}

	public List viewProdMap(IndCompModel loc) throws Exception {

		return prodmaprepo.viewProdMap(loc.getFrmint1(), loc.getLocrefid(), loc.getLocname());

	}

}
