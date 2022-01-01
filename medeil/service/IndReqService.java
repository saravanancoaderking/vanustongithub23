package com.medeil.service;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.medeil.domain.IndCompModel;
import com.medeil.domain.IndentProducts;
import com.medeil.domain.IndentRequest;
import com.medeil.repository.IndtProdRepository;
import com.medeil.repository.IndtReqRepository;
import com.medeil.util.AutoIncrement;

@Service
public class IndReqService {
	// static List temp;
	// static IndentProducts temp1;
	private final IndtReqRepository indtreqrepo;
	static ArrayList<Integer> indp1 = new ArrayList<>();
	private final IndtProdRepository indtprodrepo;

	private final Logger log = LoggerFactory.getLogger(IndReqService.class);

	@PersistenceContext
	EntityManager em;
	Query query;

	@Autowired
	IndReqService(IndtReqRepository IndtReqrepo, IndtProdRepository IndtProdRepo) {

		this.indtreqrepo = IndtReqrepo;

		this.indtprodrepo = IndtProdRepo;

	}

	public int saveIndentRequest(IndentRequest ir) throws Exception {
		int saveflag = 0;

		int incid = indtreqrepo.viewIndentId(ir.getLocname(), ir.getLocrefid());
		String incno = indtreqrepo.viewIndReqIncNo(ir.getLocname(), ir.getLocrefid(), incid);

		if (incno == null) {

			incno = "0";
		}

		// StringBuilder incr = new StringBuilder(
		// AutoIncrement.getIncrement01(incno));

		// incr.insert(0, "IND/REQ");
		StringBuilder incr = new StringBuilder(AutoIncrement.getIncrement03("IND/REQ/", ir.getLocname().toString(),
				ir.getLocrefid().toString(), incno));

		ir.setIndentno(incr.toString());

		indtreqrepo.save(ir);
		indtreqrepo.updateIndReqFlag(ir.getLocname(), ir.getLocrefid(), ir.getStkminrefid());

		saveflag = 1;

		return saveflag;
	}

	public int saveIndentProducts(List<IndentProducts> ip) throws Exception {
		int saveflag = 0;
		IndentProducts ipinc = ip.get(0);
		int indp = 0;

		indp = indtreqrepo.viewIndentId(ipinc.getLocname(), ipinc.getLocrefid());
		for (IndentProducts temp : ip) {

			if (temp.getCalcflag() != 1) {
				temp.setIndentrefid(indp);

				indtprodrepo.save(temp);

			}
		}
		saveflag = 1;
		return saveflag;

	}

	public int updateIndentRequest(IndentRequest ir) throws Exception {
		int saveflag = 0;
		indtreqrepo.save(ir);

		saveflag = 1;
		return saveflag;
	}

	public int updateIndentProducts(List<IndentProducts> ip) throws Exception {
		int saveflag = 0;
		IndentProducts indp = ip.get(0);
		for (IndentProducts temp : ip) {

			if (temp.getCalcflag() != 1) {

				if (temp.getDelflag() == true) {
					temp.setStatus(5.0);

				} else {

					temp.setStatus(0.0);
				}

				temp.setIndentrefid(indp.getIndentrefid());

				indtprodrepo.save(temp);

			}
		}
		saveflag = 1;
		return saveflag;

	}

	public List viewIndentRequests(IndCompModel loc) throws Exception {

		return indtreqrepo.viewIndentRequests(loc.getLocname(), loc.getLocrefid());
	}

	/** Boopalan Edited **/ // 250419
	public List viewIndentRequest(IndCompModel loc) throws Exception {

		return indtreqrepo.viewIndentRequest(loc.getLocname(), loc.getLocrefid(), loc.getFrmint1());
	}

	public List viewshopinformation(IndCompModel loc) throws Exception {

		return indtreqrepo.viewshopinformation(loc.getCompanyid(), loc.getBranchrefid(), loc.getLocname(),
				loc.getLocrefid());
	}

	public List viewWareHouse(IndCompModel loc) throws Exception {

		return indtreqrepo.viewWareHouse(loc.getCompanyid());
	}

	public List viewHospital(IndCompModel loc) throws Exception {

		return indtreqrepo.viewHospital(loc.getCompanyid());
	}

	public List viewWhCustProduct(IndCompModel loc) throws Exception {

		return indtreqrepo.viewCustProducts(loc.getLocname(), loc.getLocrefid(), loc.getFrmstr1(), loc.getCompanyid());
	}

	public List viewCustProduct(IndCompModel loc) throws Exception {

		return indtreqrepo.viewCustProduct(loc.getLocname(), loc.getLocrefid(), loc.getFrmint1(), loc.getCompanyid());
	}

	public List viewIndentProduct(IndCompModel loc) throws Exception {

		return indtprodrepo.viewIndentProduct(loc.getLocname(), loc.getLocrefid(), loc.getFrmint1(),
				loc.getCompanyid());
	}

	public List viewIndentRequestsAll(IndCompModel loc) throws Exception {

		return indtreqrepo.viewIndentRequestsAll(loc.getLocname(), loc.getLocrefid());
	}

	public List viewStkMinQtyAll(IndCompModel loc) throws Exception {

		return indtreqrepo.viewStkMinQtyAll(loc.getLocname(), loc.getLocrefid());

	}

	public List viewStkMinQty(IndCompModel loc) throws Exception {

		return indtreqrepo.viewStkMinQty(loc.getLocname(), loc.getLocrefid(), loc.getFrmint1(), loc.getCompanyid());

	}

	public int deleteIndReq(IndCompModel loc) throws Exception {
		int saveflag = 0;
		indtreqrepo.deleteIndReq(loc.getLocname(), loc.getLocrefid(), loc.getFrmint1());

		saveflag = 1;
		return saveflag;
	}

	// sankar 100419
	public List editbusinameservice(IndCompModel indentreqid) throws Exception {
		IndentRequest ir = indtreqrepo.findById(indentreqid.getIndentreqid());
		System.out.println("Boopalan IndentreID");
		return indtreqrepo.editbussrepo(ir.getCompanyrefid());
	}

// stock checking padmini 110919
	public int saveIndentRequest1(List<IndentRequest> ip2) throws Exception {

		int saveflag = 0;
		System.out.println("inside indent req11s");

		for (IndentRequest temp : ip2) {
//			if (temp.getCheckbox() == true) {
//
//				List dcid = this.getAutoincrement(temp.getCompanyrefid(), temp.getBranchrefid(), temp.getLocname(),
//						temp.getLocrefid());
//
//				String str = (String) dcid.get(0);
//				
//				List count = indtreqrepo.viewIndentId1(temp.getLocname(), temp.getLocrefid());
//				if (count.get(0) == null) {
//					indp1.add(1);
//				} else {
//					int result = Integer.parseInt(count.get(0).toString());
//					indp1.add(result + 1);
//				}
//
//				System.out.println("Boopalan check");
//				temp.setIndentno(str);
//				indtreqrepo.save(temp);
//
//				System.out.println("save");
//
//			}
		}

		saveflag = 1;
		return saveflag;

	}

	// padmini
	public int saveIndentProducts1(List<IndentProducts> ip) throws Exception {
		int saveflag = 0;
		int count = 0;
		System.out.println(indp1 + "Boopalan Check123");
		for (IndentProducts temp : ip) {
//			if (temp.getCheckbox() == true) {
//				Integer m =  indp1.get(count);
//			//	int result = Integer.parseInt(indp1.get(count).toString());
//				temp.setIndentrefid(m);
//				indtprodrepo.save(temp);
//				count++;
//			}

			saveflag = 1;

		}
		count = 0;
		indp1 = new ArrayList();
		return saveflag;
	}

	public List getAutoincrement(Integer cid, Integer bid, Double locname, Double locrefid) throws Exception {
		List val = null;
		try {
			String value = "CALL medc_indentmaster.pro_auindreq(?, ?, ?, ?, ?)";
			query = em.createNativeQuery(value);
			query.setParameter(1, "Indentreq");
			query.setParameter(2, cid);
			query.setParameter(3, bid);
			query.setParameter(4, locname);
			query.setParameter(5, locrefid);
			val = query.getResultList();
		} catch (Exception e) {
			log.error("Exception in Method : getAutoIncrement() " + e);
		}

		return val;

	}

	public List getToRequsitionshop(Integer compid, Integer lname) {
		return indtreqrepo.getToRequsitionshop(compid,lname);
	}

	public List getMultistorereqproducts(Integer compid, Integer drug, Integer lrefid) {
		return indtreqrepo.getMultistorereqproducts(compid,drug,lrefid);
	}

}
