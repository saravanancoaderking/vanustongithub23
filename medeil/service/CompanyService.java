/**
 * 
 */
package com.medeil.service;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Service;

import com.medeil.domain.Company;
import com.medeil.domain.Gstsetting;
import com.medeil.domain.Taxsettings;
import com.medeil.repository.CompanyRepository;
import com.medeil.repository.TaxfixedsettingRepository;
import com.medeil.repository.TaxsettingsRepository;

/**
 * @author Ajith
 *
 */
@SuppressWarnings("rawtypes")
@Service
public class CompanyService {
	
	private static Logger logger = LogManager.getLogger();

	@Autowired
	private CompanyRepository companyRepository;
	
	//selva
	@Autowired
	private TaxfixedsettingRepository taxfixedsettingRepository;

	@Autowired
	private TaxsettingsRepository taxsettingsRepository;

	@PersistenceContext
	private EntityManager em;

	Query query;


	public List getProduct(int id)throws Exception {
		return companyRepository.productInfo(id);
	}

	public List getDomain(int cid, int pid)throws Exception {

		return companyRepository.domainInfo(cid, pid);
	}

	public List subDomain(int cid, int pid, int did)throws Exception {

		return companyRepository.subdomainInfo(cid, pid, did);
	}

	public List editionInfo(int cid, int pid, int did, int sdid)throws Exception {

		return companyRepository.getEdition(cid, pid, did, sdid);
	}
//selva
	public Company saveCompany(Company cmp)throws Exception {
		Company cm = companyRepository.save(cmp);
		Integer compid = companyRepository.getcompid(cmp.getCompanyname(), cmp.getShortname(), cmp.getCountry(),cmp.getEmail(),cmp.getMobileno());
		Integer contryid = cmp.getCountry();
		Integer tax_gst = companyRepository.gettaxtype(cmp.getCountry());
		settax(compid, contryid, tax_gst);
		setgst(compid, contryid, tax_gst);
		return cm;

	}
	
	@Modifying
	@Transactional
	public boolean settax(Integer compid, Integer contryid, Integer tax_gst) {
		System.out.println("Inside savetax" + compid + "country" + contryid + "tax" + tax_gst);
		boolean falg = false;
		try {
			Taxsettings tax = new Taxsettings();
			tax.setCompanyrefid(compid);
			tax.setBranchrefid(0);
			tax.setShoprefid(0);
			tax.setHospitalrefid(0);
			tax.setWarehouserefid(0);
			tax.setPurchasetax(1);
			tax.setSalestax(0);
			tax.setVat_gst(tax_gst);
			tax.setLocname(0);
			tax.setLocrefid(0);
			tax.setCountryrefid(contryid);
			tax.setAcompanyrefid(0);
			tax.setAbranchrefid(0);
			tax.setAlocname(0);
			tax.setAlocrefid(0);
			savetax(tax);

		} catch (Exception e) {
			logger.error("Exception in Method: settax : " + e);
			e.printStackTrace();
		}
		return falg;
	}

	public void savetax(Taxsettings tax) {
		try {
			// System.out.println("Inside save "); taxsettingsRepository
			taxfixedsettingRepository.save(tax);
		} catch (Exception ex) {
			logger.error("Exception in Method : savetax : " + ex);
		}

	}

	@Modifying
	@Transactional
	public boolean setgst(Integer compid, Integer contryid, Integer tax_gst) {
		System.out.println("Inside savegst" + compid + "country" + contryid + "tax" + tax_gst);
		boolean falg = false;
		try {
			Gstsetting gsttax = new Gstsetting();
			gsttax.setLocname(0);
			gsttax.setLocrefid(0);
			gsttax.setGstflag(tax_gst);
			gsttax.setFrgstflag(0);
			gsttax.setCountryrefid(contryid);
			gsttax.setCompanyrefid(compid);
			gsttax.setBranchrefid(0);
			savegst(gsttax);

		} catch (Exception e) {
			logger.error("Exception in Method: setgst : " + e);
			e.printStackTrace();
		}
		return falg;

	}

	public void savegst(Gstsetting gsttax) {
		try {
			// System.out.println("Inside save "); taxsettingsRepository
			taxsettingsRepository.save(gsttax);
		} catch (Exception ex) {
			logger.error("Exception in Method : savegst : " + ex);
		}

	}


	public Company updateCompany(Company cmp)throws Exception {
		return companyRepository.save(cmp);
	}


	public Page viewCompany(Integer pageno, Integer size)throws Exception {
		
		//Page page = null;
		//try {
			Pageable paging = PageRequest.of(pageno, size);	
			Page page = companyRepository.viewCompany(paging);
			System.out.println(page.getTotalPages());
		//}
		//catch (Exception ex) {
		//	logger.error("Exception in Method : domainList() : " + ex);
		//}
		
		return page;
		
	}


	public Company editValues(Integer id)throws Exception {
		return companyRepository.findById(id);
	}

	public void deleteCompany(Integer id)throws Exception {
		companyRepository.deleteCompany(id);
	}

	// ****Company Inforamtion EditForm Methods Calling(Services) ****//

	public List editState(int id)throws Exception {
		Company cmp = companyRepository.findById(id);
		return companyRepository.geteditState(cmp.getCountry());
	}

	public List compeditCcode(int id)throws Exception {
		Company cmp = companyRepository.findById(id);
		return companyRepository.geteditCcode(cmp.getCountry());
	}

	public List compeditCity(int id)throws Exception {
		Company cmp = companyRepository.findById(id);
		return companyRepository.geteditCity(cmp.getState());
	}

	public List geteditProduct(int id)throws Exception {
		Company cmp = companyRepository.findById(id);
		return companyRepository.productInfo(cmp.getCountry());
	}

	public List geteditDomain(int id)throws Exception {
		Company cmp = companyRepository.findById(id);
		return companyRepository.domainInfo(cmp.getCountry(), cmp.getProductrefid());
	}

	public List subeditDomain(int id)throws Exception {
		Company cmp = companyRepository.findById(id);
		return companyRepository.subdomainInfo(cmp.getCountry(), cmp.getProductrefid(), cmp.getDomainrefid());
	}

	public List editioneditInfo(int id)throws Exception {
		Company cmp = companyRepository.findById(id);
		return companyRepository.getEdition(cmp.getCountry(), cmp.getProductrefid(), cmp.getDomainrefid(),
				cmp.getSubdomainrefid());
	}

	public List main() throws Exception{
		List<Object> ls = new ArrayList<Object>();
	//	try {
			ls.add(1);
			ls.add(1);
			ls.add(1);
			ls.add(1);
	//	} catch (Exception e) {
	//		System.out.println("main :" + e);
	//	}
		return ls;
	}

	public Integer getComopcount()throws Exception {
		return companyRepository.getComopcount();
	}

}
