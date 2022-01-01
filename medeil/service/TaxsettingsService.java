/**
 * 
 */
package com.medeil.service;

import java.util.List;

import javax.transaction.Transactional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.medeil.domain.Gstsetting;
import com.medeil.domain.Shop;
import com.medeil.domain.TaxCgst;
import com.medeil.domain.TaxGst;
import com.medeil.domain.TaxIgst;
import com.medeil.domain.TaxSgst;
import com.medeil.domain.TaxUtgst;
import com.medeil.domain.TaxVat;
import com.medeil.domain.Taxsavetype;
import com.medeil.domain.Taxsettings;
import com.medeil.domain.Taxtype;
import com.medeil.repository.ShopRepository;
import com.medeil.repository.TaxcgstRepository;
import com.medeil.repository.TaxfixedsettingRepository;
import com.medeil.repository.TaxgstRepository;
import com.medeil.repository.TaxigstRepository;
import com.medeil.repository.TaxsettingsRepository;
import com.medeil.repository.TaxsgstRepository;
import com.medeil.repository.TaxtypeRepository;
import com.medeil.repository.TaxutgstRepository;
import com.medeil.repository.TaxvatRepository;

/**
 * @author Sabarish
 *
 */
@SuppressWarnings("rawtypes")
@Service
public class TaxsettingsService {

	private static Logger logger = LogManager.getLogger();

	@Autowired
	private TaxsettingsRepository taxsettingsRepository;

	@Autowired
	private TaxfixedsettingRepository taxfixedsettingRepository;

	@Autowired
	private TaxtypeRepository taxtypeRepository;

	@Autowired
	private TaxvatRepository taxvatRepository;

	@Autowired
	private TaxgstRepository taxgstRepository;

	@Autowired
	private TaxsgstRepository taxsgstRepository;

	@Autowired
	private TaxcgstRepository taxcgstRepository;

	@Autowired
	private TaxigstRepository taxigstRepository;

	@Autowired
	private TaxutgstRepository taxutgstRepository;

	@Autowired
	private ShopRepository shoprepo;

	public List getCompany(Integer id) throws Exception {
		return taxsettingsRepository.companyinfo(id);
	}

	public List gettaxtype(Integer id) throws Exception {
		return taxsettingsRepository.taxtype(id);
	}

	public List getBranch(Integer id) throws Exception {
		return taxsettingsRepository.branchinfo(id);
	}

	public List getShop(Integer id) throws Exception {
		return taxsettingsRepository.shopinfo(id);
	}

	public List getWarehouse(Integer id) throws Exception {
		return taxsettingsRepository.warehouseinfo(id);
	}

	public List getHospital(Integer id) throws Exception {
		return taxsettingsRepository.hospitalinfo(id);
	}

	public boolean saveTaxation(Gstsetting gst) throws Exception {
		boolean saveflag = false;
		// try {
		System.out.println("Inside save Tax service try");
		taxsettingsRepository.save(gst);
		// } catch (Exception E) {

		// }
		saveflag = true;
		return saveflag;
	}

	public boolean saveTaxsetting(Taxsettings tax) throws Exception {
		boolean saveflag = false;
		// try {
		System.out.println("Inside save Tax service try");
		taxfixedsettingRepository.save(tax);
		// } catch (Exception E) {

		// }
		saveflag = true;
		return saveflag;
	}

	public boolean saveTaxtype(Taxtype tax) throws Exception {
		boolean saveflag = false;
		// try {
		System.out.println("Inside save Tax service try");
		taxtypeRepository.save(tax);
		// } catch (Exception E) {

		// }
		saveflag = true;
		return saveflag;
	}

	public boolean saveTaxpercent(Taxsavetype taxtyp) throws Exception {
		boolean saveflag = false;
		try {
			System.out.println("Inside savetaxpercent");
			Integer countryid = taxtyp.getCountryid();
			Integer compid = taxtyp.getCompanyrefid();
			Integer brachid = taxtyp.getBranchrefid();
			Integer shpid = taxtyp.getShoprefid();
			Integer warid = taxtyp.getWarehouserefid();
			Integer hspid = taxtyp.getHospitalrefid();
			Double vat = taxtyp.getVat();
			Double gst = taxtyp.getGst();
			Double sgst = taxtyp.getSgst();
			Double cgst = taxtyp.getCgst();
			Double igst = taxtyp.getIgst();
			Double utgst = taxtyp.getUtgst();
			Integer locname = taxtyp.getLocname();
			Integer locrefid = taxtyp.getLocrefid();
			System.out.println("vat" + vat);
			System.out.println("gst" + gst);
			System.out.println("sgst" + sgst);
			System.out.println("cgst" + cgst);
			System.out.println("igst" + igst);
			System.out.println("utgst" + utgst);
			if (vat != 0.0) {
				System.out.println("vat" + vat);
				setvat(countryid, compid, brachid, shpid, warid, hspid, vat, locname, locrefid);

			} else if (gst != 0.0) {
				System.out.println("gst" + gst);
				setgst(countryid, compid, brachid, shpid, warid, hspid, gst, locname, locrefid);
			} else if (sgst != 0.0) {
				setsgst(countryid, compid, brachid, shpid, warid, hspid, sgst, locname, locrefid);
			} else if (cgst != 0.0) {
				setcgst(countryid, compid, brachid, shpid, warid, hspid, cgst, locname, locrefid);
			} else if (igst != 0.0) {
				setigst(countryid, compid, brachid, shpid, warid, hspid, igst, locname, locrefid);
			} else if (utgst != 0.0) {
				setutgst(countryid, compid, brachid, shpid, warid, hspid, utgst, locname, locrefid);
			} else {

			}

		} catch (Exception e) {
			logger.error("Exception in Method : savetaxpercent : " + e);
			throw new Exception(e);
		}
		saveflag = true;
		return saveflag;
	}

	@Modifying
	@Transactional
	public boolean setvat(Integer countryid, Integer compid, Integer brachid, Integer shpid, Integer warid,
			Integer hspid, Double vat, Integer locname, Integer locrefid) throws Exception {
		boolean falg = false;
		// try {
		TaxVat vattable = new TaxVat();
		vattable.setCountryid(countryid);
		vattable.setCompanyrefid(compid);
		vattable.setBranchrefid(brachid);
		vattable.setShoprefid(shpid);
		vattable.setWarehouserefid(warid);
		vattable.setHospitalrefid(hspid);
		vattable.setVat(vat);
		vattable.setLocname(locname);
		vattable.setLocrefid(locrefid);
		vattable.setStatus(0);
		savevat(vattable);

		// } catch (Exception e) {
		// logger.error("Exception in Method: setgst : " + e);
		// e.printStackTrace();
		// }
		return falg;
	}

	private void savevat(TaxVat vattable) throws Exception {
		// try {
		taxvatRepository.save(vattable);
		// } catch (Exception ex) {
		// logger.error("Exception in Method : savetax : " + ex);
		// }

	}

	@Modifying
	@Transactional
	public boolean setgst(Integer countryid, Integer compid, Integer brachid, Integer shpid, Integer warid,
			Integer hspid, Double gst, Integer locname, Integer locrefid) throws Exception {
		boolean falg = false;
		// try {
		System.out.println("inside sert");
		TaxGst gsttable = new TaxGst();
		gsttable.setCountryid(countryid);
		gsttable.setCompanyrefid(compid);
		gsttable.setBranchrefid(brachid);
		gsttable.setShoprefid(shpid);
		gsttable.setWarehouserefid(warid);
		gsttable.setHospitalrefid(hspid);
		gsttable.setGst(gst);
		gsttable.setLocname(locname);
		gsttable.setLocrefid(locrefid);
		gsttable.setStatus(0);
		savegst(gsttable);

		// } catch (Exception e) {
		// logger.error("Exception in Method: setgst : " + e);
		// e.printStackTrace();
		// }
		return falg;
	}

	private void savegst(TaxGst gsttable) throws Exception {
		// try {
		// System.out.println("inside save gst");
		taxgstRepository.save(gsttable);
		// } catch (Exception ex) {
		// logger.error("Exception in Method : savetax : " + ex);
		// }

	}

	@Modifying
	@Transactional
	public boolean setsgst(Integer countryid, Integer compid, Integer brachid, Integer shpid, Integer warid,
			Integer hspid, Double sgst, Integer locname, Integer locrefid) throws Exception {
		boolean falg = false;
		// try {
		TaxSgst sgsttable = new TaxSgst();
		sgsttable.setCountryid(countryid);
		sgsttable.setCompanyrefid(compid);
		sgsttable.setBranchrefid(brachid);
		sgsttable.setShoprefid(shpid);
		sgsttable.setWarehouserefid(warid);
		sgsttable.setHospitalrefid(hspid);
		sgsttable.setSgst(sgst);
		sgsttable.setLocname(locname);
		sgsttable.setLocrefid(locrefid);
		sgsttable.setStatus(0);
		savesgst(sgsttable);

		// } catch (Exception e) {
		// logger.error("Exception in Method: setgst : " + e);
		// e.printStackTrace();
		// }
		return falg;
	}

	private void savesgst(TaxSgst sgsttable) throws Exception {
		// try {
		taxsgstRepository.save(sgsttable);
		// } catch (Exception ex) {
		// logger.error("Exception in Method : savetax : " + ex);
		// }

	}

	@Modifying
	@Transactional
	public boolean setcgst(Integer countryid, Integer compid, Integer brachid, Integer shpid, Integer warid,
			Integer hspid, Double cgst, Integer locname, Integer locrefid) throws Exception {
		boolean falg = false;
		// try {
		TaxCgst cgsttable = new TaxCgst();
		cgsttable.setCountryid(countryid);
		cgsttable.setCompanyrefid(compid);
		cgsttable.setBranchrefid(brachid);
		cgsttable.setShoprefid(shpid);
		cgsttable.setWarehouserefid(warid);
		cgsttable.setHospitalrefid(hspid);
		cgsttable.setCgst(cgst);
		cgsttable.setLocname(locname);
		cgsttable.setLocrefid(locrefid);
		cgsttable.setStatus(0);
		savecgst(cgsttable);

		// } catch (Exception e) {
		// logger.error("Exception in Method: setgst : " + e);
		// e.printStackTrace();
		// }
		return falg;
	}

	private void savecgst(TaxCgst cgsttable) throws Exception {
		// try {
		taxcgstRepository.save(cgsttable);
		// } catch (Exception ex) {
		// logger.error("Exception in Method : savetax : " + ex);
		// }

	}

	@Modifying
	@Transactional
	public boolean setigst(Integer countryid, Integer compid, Integer brachid, Integer shpid, Integer warid,
			Integer hspid, Double igst, Integer locname, Integer locrefid) throws Exception {
		boolean falg = false;
		// try {
		TaxIgst igsttable = new TaxIgst();
		igsttable.setCountryid(countryid);
		igsttable.setCompanyrefid(compid);
		igsttable.setBranchrefid(brachid);
		igsttable.setShoprefid(shpid);
		igsttable.setWarehouserefid(warid);
		igsttable.setHospitalrefid(hspid);
		igsttable.setIgst(igst);
		igsttable.setLocname(locname);
		igsttable.setLocrefid(locrefid);
		igsttable.setStatus(0);
		saveigst(igsttable);

		// } catch (Exception e) {
		// logger.error("Exception in Method: setgst : " + e);
		// e.printStackTrace();
		// }
		return falg;
	}

	private void saveigst(TaxIgst igsttable) throws Exception {
		// try {
		taxigstRepository.save(igsttable);
		// } catch (Exception ex) {
		// logger.error("Exception in Method : savetax : " + ex);
		// }

	}

	@Modifying
	@Transactional
	public boolean setutgst(Integer countryid, Integer compid, Integer brachid, Integer shpid, Integer warid,
			Integer hspid, Double utgst, Integer locname, Integer locrefid) throws Exception {
		boolean falg = false;
		/// try {
		TaxUtgst utgsttable = new TaxUtgst();
		utgsttable.setCountryid(countryid);
		utgsttable.setCompanyrefid(compid);
		utgsttable.setBranchrefid(brachid);
		utgsttable.setShoprefid(shpid);
		utgsttable.setWarehouserefid(warid);
		utgsttable.setHospitalrefid(hspid);
		utgsttable.setUtgst(utgst);
		utgsttable.setLocname(locname);
		utgsttable.setLocrefid(locrefid);
		utgsttable.setStatus(0);
		saveutgst(utgsttable);

		// } catch (Exception e) {
		// logger.error("Exception in Method: setgst : " + e);
		// e.printStackTrace();
		// }
		return falg;

	}

	private void saveutgst(TaxUtgst utgsttable) throws Exception {
		// try {
		taxutgstRepository.save(utgsttable);
		// } catch (Exception ex) {
		// logger.error("Exception in Method : savetax : " + ex);
		// }
	}

	public ResponseEntity<Boolean> saveTaxsettings(Taxsettings taxsetting) throws Exception {
		// try {
		taxfixedsettingRepository.save(taxsetting);
		Shop shop = new Shop();
		shop = shoprepo.findById(taxsetting.getShoprefid());
		shop.setId(taxsetting.getShoprefid());
		shop.setCountry(taxsetting.getCountryrefid());
		shop.setState(taxsetting.getStateid());
		shoprepo.save(shop);
		return ResponseEntity.created(null).body(true);
		// } catch (DataIntegrityViolationException e) {
		// HashMap<String, String> errorMessage = new HashMap<String, String>();
		// errorMessage.put("message", e.getRootCause().getMessage());
		// return new ResponseEntity(errorMessage, HttpStatus.BAD_REQUEST);
		// } catch (Exception e) {
		// HashMap<String, String> errorMessage = new HashMap<String, String>();
		// errorMessage.put("message", e.toString());
		// return new ResponseEntity(errorMessage, HttpStatus.BAD_REQUEST);
		// }
	}

	public List getTaxStatus(Integer cid, Integer bid, Integer lname, Integer lrefid) throws Exception {
		return taxfixedsettingRepository.getTaxStatus(cid, bid, lname, lrefid);
	}

	public List getTaxcountrystate(Integer lrefid) throws Exception {
		return taxfixedsettingRepository.getTaxcountrystate(lrefid);
	}

	public List fetchTaxsettings(Integer lrefid) throws Exception {
		return taxfixedsettingRepository.fetchTaxsettings(lrefid);
	}

}
