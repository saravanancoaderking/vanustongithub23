package com.medeil.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.medeil.domain.Shipping;
import com.medeil.domain.ShippingDetail;
import com.medeil.repository.ShippingDetailRepository;
import com.medeil.repository.ShippingRepository;

@Service
public class ShippingService {

	static List poautoincr;

	private static Logger logger = LogManager.getLogger();
	@PersistenceContext
	private EntityManager manager;

	@PersistenceContext
	EntityManager em;

	Query query;

	@Autowired
	ShippingRepository shippingrepository;

	@Autowired
	ShippingDetailRepository shippingDetailrepository;

	public List getPackingno(Integer cid, Integer bid, Integer locid, Integer locreid) throws Exception {
		// List list = null;
		// try {

		// list = shippingrepository.getPackingno(cid, bid, locid, locreid);

		// } catch (Exception eh) {
		// logger.error("Exception in Method : getPackingno() " + eh);
		// }
		return shippingrepository.getPackingno(cid, bid, locid, locreid);
	}

	public List gettablevalue(Shipping shipping) throws Exception {

		return shippingrepository.gettablevalue(shipping.getCompanyrefid(), shipping.getBranchrefid(),
				shipping.getLocname(), shipping.getLocrefid(), shipping.getPackagerefid());

	}

	public List viewPack(Shipping shipping) throws Exception {

		return shippingrepository.viewPack(shipping.getCompanyrefid(), shipping.getBranchrefid(), shipping.getLocname(),
				shipping.getLocrefid(), shipping.getPackagerefid());

	}

	public List getAutoincrement(Integer cid, Integer bid, Integer locname, Integer locrefid) throws Exception {
		List val = null;
		try {
			String value = "CALL medc_deliveryprocess.pro_shippingautoincrement(?, ?, ?, ?, ?)";
			query = em.createNativeQuery(value);
			query.setParameter(1, "Shipping");
			query.setParameter(2, cid);
			query.setParameter(3, bid);
			query.setParameter(4, locname);
			query.setParameter(5, locrefid);
			val = query.getResultList();
		} catch (Exception e) {
			logger.error("Exception in Method : getAutoIncrement() " + e);
			throw new Exception(e);
		}

		return val;

	}

	/*
	 * public int saveShipping(Shipping shipping) {
	 * 
	 * int saveflag = 0;
	 * 
	 * List dcid = this.getAutoincrement(shipping.getCompanyrefid(),
	 * shipping.getBranchrefid(), shipping.getLocname(), shipping.getLocrefid());
	 * 
	 * String str = (String) dcid.get(0);
	 * 
	 * shipping.setShippmentno(str);
	 * 
	 * System.out.println(shipping.getCompanyrefid() + "" +
	 * shipping.getBranchrefid() + "" + shipping.getLocname() + "" +
	 * shipping.getLocrefid());
	 * 
	 * System.out.println(str);
	 * 
	 * if (shipping.getSamebilling() == 1) {
	 * shipping.setShippingaddress(shipping.getBillingaddress());
	 * shipping.setShstreet(shipping.getBstreet());
	 * shipping.setSlocation(shipping.getBlocation());
	 * shipping.setShcountry(shipping.getBcountry());
	 * shipping.setShstate(shipping.getBstate());
	 * shipping.setShcity(shipping.getBcity());
	 * shipping.setShcontactperson(shipping.getBcontactperson());
	 * shipping.setShmobile(shipping.getBmobile());
	 * shipping.setShemail(shipping.getBemail());
	 * 
	 * }
	 * 
	 * shippingrepository.save(shipping);
	 * 
	 * saveflag = 1;
	 * shippingrepository.save_medc_salesordertrack(shipping.getSalesorderrefid(),
	 * 6, shipping.getClientcdate()); // Boopalan 200919 - For saving data //
	 * medc_status.medc_salesordertrack return saveflag; }
	 */// server file

	// padmini file
	public int saveShipping(Shipping shipping) throws Exception {

		int saveflag = 0;

		List dcid = this.getAutoincrement(shipping.getCompanyrefid(), shipping.getBranchrefid(), shipping.getLocname(),
				shipping.getLocrefid());

		String str = (String) dcid.get(0);

		shipping.setShippmentno(str);

		System.out.println(shipping.getCompanyrefid() + "" + shipping.getBranchrefid() + "" + shipping.getLocname() + ""
				+ shipping.getLocrefid());

		System.out.println(str);

		System.out.println("same" + shipping.getSamebilling());
		if (shipping.getSamebilling() == 1) {
			// shipping.setShippingaddress(shipping.getBillingaddress());
			shipping.setShstreet(shipping.getBstreet());
			shipping.setSlocation(shipping.getBlocation());
			shipping.setShcountry(shipping.getBcountry());
			shipping.setShstate(shipping.getBstate());
			shipping.setShcity(shipping.getBcity());
			// shipping.setShcontactperson(shipping.getBcontactperson());
			shipping.setShmobile(shipping.getBmobile());
			// shipping.setShemail(shipping.getBemail());

		}

		shippingrepository.save(shipping);

		saveflag = 1;
		shippingrepository.save_medc_salesordertrack(shipping.getSalesorderrefid(), 6, shipping.getClientcdate());
		// Boopalan 200919 - For saving data
		// medc_status.medc_salesordertrack
		shippingrepository.updatepacstatus(shipping.getCompanyrefid(), shipping.getBranchrefid(), shipping.getLocname(),
				shipping.getLocrefid(), shipping.getSalesinvoiceno());
		return saveflag;
	}

	/*
	 * public int saveShippingdetail(List<ShippingDetail> sd) { int saveflag = 0;
	 * 
	 * ShippingDetail shi = sd.get(0);
	 * 
	 * int shid = shippingrepository.selectmaaxshipid(shi.getCompanyrefid(),
	 * shi.getBranchrefid(), shi.getLocname(), shi.getLocrefid());
	 * 
	 * for (ShippingDetail temp : sd) {
	 * 
	 * System.out.println("inside save ser" + shid);
	 * 
	 * temp.setShiprefid(shid);
	 * 
	 * shippingDetailrepository.save(temp);
	 * 
	 * } saveflag = 1; return saveflag;
	 * 
	 * }
	 */// sever old file

	// padmini current file
	public int saveShippingdetail(List<ShippingDetail> sd) throws Exception {
		int saveflag = 0;

		ShippingDetail shi = sd.get(0);

		int shid = shippingrepository.selectmaaxshipid(shi.getCompanyrefid(), shi.getBranchrefid(), shi.getLocname(),
				shi.getLocrefid());

		for (ShippingDetail temp : sd) {

			System.out.println("inside save ser" + shid);

			temp.setShiprefid(shid);

			shippingDetailrepository.save(temp);

		}
		saveflag = 1;
		return saveflag;

	}

	public List viewShipp(Shipping shipping) throws Exception {
		// System.out.println(shipping.getCompanyrefid() + ""+shipping.getBranchrefid()
		// +" "+ shipping.getLocname() + "" + shipping.getLocrefid() + ""+
		// shipping.getPackagerefid());
		return shippingrepository.viewShipp(shipping.getCompanyrefid(), shipping.getBranchrefid(),
				shipping.getLocname(), shipping.getLocrefid());

	}

	public List getempdetail(Integer cid, Integer bid, Integer locname, Integer locreid) throws Exception {

		return shippingrepository.getemp(cid, bid, locname, locreid);

	}

}
