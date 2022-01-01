package com.medeil.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.medeil.domain.Distributor;
import com.medeil.domain.IndCompModel;
import com.medeil.repository.DistributorRepository;
import com.medeil.repository.PatientRepository;
import com.medeil.util.AutoIncrement;

@Service
public class DistService {

	private final DistributorRepository distrepo;

	private final PatientRepository patientRepo;

	private final Logger log = LoggerFactory.getLogger(DistService.class);

	@Autowired
	DistService(DistributorRepository Distrepo, PatientRepository custRepo) {

		this.distrepo = Distrepo;
		this.patientRepo = custRepo;

	}

	public int saveDistributor(Distributor dist) throws Exception {
		int saveflag = 0;

		Integer incid = distrepo.viewDistributorId(dist.getLocname(), dist.getLocrefid());

		String incno = distrepo.viewDistributorIncNo(dist.getLocname(), dist.getLocrefid(), incid);

		if (incno == null) {

			incno = "0";
		}

		// StringBuilder incr = new StringBuilder(
		// AutoIncrement.getIncrement01(incno));
		// incr.insert(0, "DIST");
		StringBuilder incr = new StringBuilder(AutoIncrement.getIncrement03("DIST", dist.getLocname().toString(),
				dist.getLocrefid().toString(), incno));

		dist.setDistno(incr.toString());
		distrepo.save(dist);

		saveflag = 1;
		return saveflag;
	}

	public int saveDistPhcompany(List<IndCompModel> loc) throws Exception {
		int saveflag = 0;

		IndCompModel locinc = loc.get(0);
		Integer incid = distrepo.viewDistributorId(locinc.getLocname(), locinc.getLocrefid());

		for (IndCompModel temp : loc) {

			distrepo.saveDistPhcompany(temp.getLocname(), temp.getLocrefid(), temp.getFrmint1(), incid);

		}

		saveflag = 1;
		return saveflag;
	}

	public int updateDistributor(Distributor dist) throws Exception {
		int saveflag = 0;
		try {
			distrepo.save(dist);
			saveflag = 1;

		} catch (Exception e) {
			throw new Exception(e);
		}

		// saveflag = 1;
		return saveflag;
	}

	public int saveIndvDistType(IndCompModel loc) throws Exception {
		int saveflag = 0;
		try {
			distrepo.saveIndvDistType(loc.getLocname(), loc.getLocrefid(), loc.getFrmstr1());
			saveflag = 1;
		} catch (Exception e) {

			throw new Exception(e);
		}

		return saveflag;
	}

	public List viewDistributors(IndCompModel loc) throws Exception {

		return distrepo.viewDistributors(loc.getLocname(), loc.getLocrefid());
	}

	public Distributor viewDistributorEdit(IndCompModel loc) throws Exception {

		return distrepo.findById(loc.getFrmint1());
	}

	public List viewDistributor(IndCompModel loc) throws Exception {

		return distrepo.viewDistributor(loc.getLocname(), loc.getLocrefid(), loc.getFrmint1());
	}

	public Integer viewDistributorId(IndCompModel loc) throws Exception {

		return distrepo.viewDistributorId(loc.getLocname(), loc.getLocrefid());
	}

	public List viewDistType(IndCompModel loc) throws Exception {

		return distrepo.viewDistType(loc.getLocname(), loc.getLocrefid());
	}

	public List viewPhCompanies(IndCompModel loc) throws Exception {

		return distrepo.viewPhCompanies(loc.getLocrefid());
	}

	public List viewDistPhCompanies(IndCompModel loc) throws Exception {

		return distrepo.viewDistPhCompanies(loc.getLocname(), loc.getLocrefid(), loc.getFrmint1());
	}

	public int deleteDistributor(IndCompModel loc) throws Exception {
		int saveflag = 0;
		distrepo.deleteDistributor(loc.getLocname(), loc.getLocrefid(), loc.getFrmint1());
		saveflag = 1;
		return saveflag;

	}

	// Selva
	// Reports
//	public List getDistInfo() {
//		return distrepo.Distinfo();
//	}

	public List getDistInfo(int comid, int branchid, int locname, int locrefid) throws Exception {

		return distrepo.Distinfo1(comid, branchid, locname, locrefid);
	}

	// Desing 040419 Inventory Report/StkTrans by Product
	public List getstktrnsInfo(int cid, int bid, int lnid, int lrid) throws Exception {

		return distrepo.StktrnNo(cid, bid, lnid, lrid);
	}

	public List editDistsstate(IndCompModel distributorid) throws Exception {
		Distributor ds = distrepo.findById(distributorid.getDistributorid());
		System.out.println("Boopalan Country");
		return distrepo.editDistsstate(ds.getState());
	}

	public List editDistscity(IndCompModel distributorid) throws Exception {
		Distributor ds = distrepo.findById(distributorid.getDistributorid());
		System.out.println("Boopalan city");
		return distrepo.editDistscity(ds.getCity());
	}

	public List editDiststype(IndCompModel distributorid) throws Exception {
		Distributor ds = distrepo.findById(distributorid.getDistributorid());
		System.out.println("Boopalan city");
		return distrepo.editDiststype(ds.getDistributortypeid());
	}

	// Desing 120419 Purchase Report/BatchNamewise Purchase
	public List getBatchNameInfo(String str, int cid, int bid, int lnid, int lrid) throws Exception {

		return distrepo.BatchNo(str, cid, bid, lnid, lrid);
	}

	// Desing 040419 Inventory Report/Requisition No by Product
	public List getIndentReqInfo(int cid, int bid, int lnid, int lrid) throws Exception {

		return distrepo.IndReqNo(cid, bid, lnid, lrid);
	}

	// Desing 070519 Purchase Report/PurchaseInvoicewise
	public List getPurInvoiceInfo(int cid, int bid, int lnid, int lrid) throws Exception {
		return distrepo.PurInvoiceNo(cid, bid, lnid, lrid);
		
	}
	
	
	public List distlist(Integer cid, Integer bid, Integer lnid, Integer lrid,String searchkey) {
		System.out.println("Distsearch Service");
		
		return this.distrepo.getdistliost(cid, bid, lnid, lrid,searchkey);
	
	}

}
