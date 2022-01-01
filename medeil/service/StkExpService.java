package com.medeil.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.medeil.domain.IndCompModel;
import com.medeil.domain.Shortexpirysettings;
import com.medeil.domain.StockExpiry;
import com.medeil.repository.StkExpRepository;
import com.medeil.repository.StockexpirySettingsRepository;
import com.medeil.util.AutoIncrement;

@Service
public class StkExpService {
	private int locid;
	private int days;
	private int month;
	private int years;
	private int exstatus;
	private int getday;
	private int getmonth;
	private int getyear;
	private final StkExpRepository stkexprepo;

	private final Logger log = LoggerFactory.getLogger(StkExpService.class);
	@Autowired
	StockexpirySettingsRepository expirysettindRep;

	@Autowired
	StkExpService(StkExpRepository Stkexprepo) {

		this.stkexprepo = Stkexprepo;

	}

	public int saveStockExpiry(List<StockExpiry> stexp) throws Exception {

		int saveflag = 0;
		try {

			StockExpiry stkinc = stexp.get(0);
			Double incid = stkexprepo.viewStockExpId(stkinc.getLocname(), stkinc.getLocrefid());
			Double incidnu = stkexprepo.viewStockExpIdNU(stkinc.getLocname(), stkinc.getLocrefid());
			String incno = stkexprepo.viewStockExpIncNo(stkinc.getLocname(), stkinc.getLocrefid(), incid);
			if (incno == null) {
				incno = "0";
			}

			if (incidnu == null) {
				incidnu = 0.0;
			}
			incidnu += 1;
			for (StockExpiry temp : stexp) {

				if (temp.getDelflag() == true) {

					StringBuilder incr = new StringBuilder(AutoIncrement.getIncrement01(incno));
					incr.insert(0, "STK/EXP");
					temp.setStkexpno(incr.toString());
					temp.setStkexpid(incidnu);
					stkexprepo.updateMainstockSave(temp.getLocname(), temp.getLocrefid(), temp.getDrugproductid(),
							temp.getBatchrefid(), temp.getExpstockqty());
					System.out.println("amount" + temp.getTotalamt());
					System.out.println("@@@@@@@@@@" + temp.getExpirydate());
					stkexprepo.save(temp);

					saveflag = 1;

				}

			}

		} catch (Exception e) {
			log.error("Exception in Method : getAutoIncrement() " + e);
			throw new Exception(e);
		}

		return saveflag;
	}

	public int updateStockExpiry(List<StockExpiry> prc) throws Exception {
		int saveflag = 0;
		StockExpiry st = prc.get(0);
		stkexprepo.updateMainstockEdit(st.getLocname(), st.getLocrefid(), st.getStkexpid());

		for (StockExpiry temp : prc) {
			if (temp.getCalcflag() != 1) {
				if (temp.getDelflag() == true) {
					temp.setStatus(5.0);

				} else {

					temp.setStatus(0.0);
				}

				stkexprepo.updateMainstockSave(temp.getLocname(), temp.getLocrefid(), temp.getDrugproductid(),
						temp.getBatchrefid(), temp.getExpstockqty());

				stkexprepo.save(temp);

			}

		}

		saveflag = 1;
		return saveflag;

	}

	public List viewMainstocks(IndCompModel loc) throws Exception {

		return stkexprepo.viewMainstocks(loc.getLocname(), loc.getLocrefid(), loc.getFrmstr1());
	}

	public List viewMainstock(IndCompModel loc) throws Exception {

		return stkexprepo.viewMainstock(loc.getLocname(), loc.getLocrefid(), loc.getFrmint1(), loc.getFrmint2(),
				loc.getCompanyid());
	}

	public List viewMainstockExpiry(IndCompModel loc) throws Exception {

		return stkexprepo.viewMainstockExpiry(loc.getLocname(), loc.getLocrefid(), loc.getCompanyrefid(),
				loc.getBranchrefid());
	}

	public List viewStockExpAll(IndCompModel loc) throws Exception {

		return stkexprepo.viewStockExpAll(loc.getLocname(), loc.getLocrefid());

	}

	public List viewStockExpiry(IndCompModel loc) throws Exception {

		return stkexprepo.viewStockExpiry(loc.getLocname(), loc.getLocrefid(), loc.getFrmint1(), loc.getCompanyid());

	}

	public int deleteStockExpiry(IndCompModel loc) throws Exception {
		int saveflag = 0;
		stkexprepo.deleteStockExpiry(loc.getLocname(), loc.getLocrefid(), loc.getFrmint1());
		saveflag = 1;
		return saveflag;
	}

	public int minimumstkexp(Shortexpirysettings ses) throws Exception {
		Integer lastid;

		System.out.println("SE Service Raja");
		System.out.println(ses.getNo_month());
		System.out.println(ses.getNo_year());
		int flag = 1;
		locid = ses.getLocrefid();
		days = ses.getNo_days();
		month = ses.getNo_month();
		years = ses.getNo_year();
		Integer shortes = expirysettindRep.checkvalue(locid);
		if(flag ==1) {
		   System.out.println(shortes);
			       if( shortes ==0 ) {
			    	   expirysettindRep.save(ses);
						     flag=1;
						     }
						     
			             else if(shortes==1){
									          
			        	 Shortexpirysettings updtae=expirysettindRep.findByUserid(Long.valueOf(ses.getUserid()).intValue());
			        	 updtae.setNo_days(ses.getNo_days());
			        	 updtae.setNo_month(ses.getNo_month());
			        	 updtae.setNo_year(ses.getNo_year());
			        	 updtae.setExpiryflag(ses.getExpiryflag());
			        	 expirysettindRep.save(updtae);
			        	 flag=1;
				          
			              }
			             else {
			            	 flag=0;
			             }
		      }
		   else {
		       	flag = 0;
	             	}
		return flag;

	}

	public List getsedata(Integer comid, Integer branchid, Integer locname, Integer locrefid) throws Exception {

		getday = expirysettindRep.getnoofdays(comid, branchid, locname, locrefid);
		getmonth = expirysettindRep.getnoofmonth(comid, branchid, locname, locrefid);
		getyear = expirysettindRep.getnoofyear(comid, branchid, locname, locrefid);
		System.out.println("shortExp Service");

		if (getday != 0) {
			return expirysettindRep.getexpdataday(comid, branchid, locname, locrefid);
		} else if (getmonth != 0) {
			return expirysettindRep.getexpdatamonth(comid, branchid, locname, locrefid);

		}

		else {
			return expirysettindRep.getexpdatayear(comid, branchid, locname, locrefid);
		}
	}

	public boolean dest(Integer stockid, Integer prodid, Integer compid, Integer branchid, Integer locname,
			Integer locrefid) throws Exception {
		boolean flag = true;
		if (flag == true) {
			stkexprepo.updatedestroy(stockid, prodid, compid, branchid, locname, locrefid);
			return flag;
		} else {
			return flag = false;

		}

	}

	public List shortexp(Integer compid, Integer branchid, Integer locname, Integer locrefid) throws Exception {
		return stkexprepo.shortstatus(compid, branchid, locname, locrefid);

	}
}
