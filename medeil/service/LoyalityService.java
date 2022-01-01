package com.medeil.service;

/**
 * @author DesingRaja	
 */

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.medeil.domain.BonusLoyality;
import com.medeil.domain.BonusloyalityProduct;
import com.medeil.domain.CustomerType;
import com.medeil.domain.Giftproduct;
import com.medeil.domain.Loyality;
import com.medeil.domain.LoyalityGiftProduct;
import com.medeil.repository.BonusLoyalityProductRepository;
import com.medeil.repository.BonusLoyalityRepository;
import com.medeil.repository.CustomerTypeRepository;
import com.medeil.repository.GiftProductRepository;
import com.medeil.repository.LgiftProductRepository;
import com.medeil.repository.LoyalityRepository;

@SuppressWarnings("rewtypes")
@Service
public class LoyalityService {

	@Autowired
	private LoyalityRepository loyalityrepository;

	@Autowired
	private LgiftProductRepository lgifiprodrepository;

	@Autowired
	private CustomerTypeRepository customerTypeRepository;

	@Autowired
	private BonusLoyalityRepository bonusloyalityrepository;

	@Autowired
	private BonusLoyalityProductRepository bonusloyalityproductrepository;

	@Autowired
	private GiftProductRepository giftproductrepository;

	public int saveloy(Loyality loyality) throws Exception {
		Integer ldata = 0;
		try {
			Loyality ldatas = loyalityrepository.findByCompanyrefidAndBranchrefidAndLocnameAndLocarefidAndLoyalitytype(
					loyality.getCompanyrefid(), loyality.getBranchrefid(), loyality.getLocname(),
					loyality.getLocarefid(), loyality.getLoyalitytype());
			if (ldatas.getId() != null) {
				ldatas.setPrice_equivalentto_points(loyality.getPrice_equivalentto_points());
				ldatas.setEquivalent_points(loyality.getEquivalent_points());
				ldatas.setFrom_date(loyality.getFrom_date());
				ldatas.setTo_date(loyality.getTo_date());
				ldatas.setExp_status(loyality.getExp_status());
				ldatas.setMinimum_points(loyality.getMinimum_points());
				ldata = loyalityrepository.save(ldatas).getId();
			}
		} catch (Exception e) {
			ldata = loyalityrepository.save(loyality).getId();
		}
		return ldata;

	}

	public boolean savegiftprod(List<LoyalityGiftProduct> giftproduct) throws Exception {
		System.out.println("__________________________________________________prodservice1");
		boolean flag = false;
		if (flag == false) {
//		System.out.println("::::::::::::::::::::::::::::::::::::::::::::Ok"+giftproduct.getBranchrefid()+giftproduct.getGift_product_name()+giftproduct.getGift_Product_qty());
			lgifiprodrepository.saveAll(giftproduct);
			flag = true;
		} else {
			flag = false;
		}
		return flag;
	}

	public List getcurlogo(String countryid) {
		System.out.println("raja1");
		return loyalityrepository.countrycurlogo(countryid);
	}

	public List getgiftprod(Integer comid, Integer branchid, Integer locname, Integer locrefid) throws Exception {
		return lgifiprodrepository.getgiftproduct(comid, branchid, locname, locrefid);
	}

	public List getgiftcarddetails(String giftcode) throws Exception {
		return lgifiprodrepository.getgiftcarddetails(giftcode);
	}

	public boolean isexist(Integer comid, String gproductname) throws Exception {
		boolean flag = giftproductrepository.existsByCompanyrefidAndGiftproductname(comid, gproductname);

		return flag;
	}

	public boolean savegproduct(Giftproduct giftproduct) throws Exception {
		boolean flag = false;
		if (flag == false) {
			giftproductrepository.save(giftproduct);
			flag = true;
		}
		return flag;
	}

//Raja
	public List viewloyality(Integer comid, Integer branchid, Integer locname, Integer locrefid) throws Exception {

		return loyalityrepository.getloyality(comid, branchid, locname, locrefid);
	}

	public List viewloyalitygift(Integer comid, Integer branchid, Integer locname, Integer locrefid) {

		return loyalityrepository.getloyalitygiftprod(comid, branchid, locname, locrefid);
	}

//DesingRaja
	public List viewcustloyality(Integer comid, Integer branchid, Integer locname, Integer locrefid) throws Exception {

		return loyalityrepository.getcustloyality(comid, branchid, locname, locrefid);
	}

	public List getcusttype(Integer comid, Integer branchid, Integer locname, Integer locrefid) throws Exception {
		System.out.println("getcusttypeservice");
		return loyalityrepository.getcusttypelist(comid, branchid, locname, locrefid);

	}

	public boolean savectype(List<CustomerType> custtype) throws Exception {
		boolean flag = false;
		if (flag == false) {
			for (CustomerType ct : custtype) {
				System.out.println("++++++++++++++++++++++" + ct.getMin_amount());
				customerTypeRepository.save(ct);
			}
			return flag = true;
		} else {
			flag = false;
		}

		return flag;
	}

	public List getmainproduct(Integer comid, Integer branchid, Integer locname, Integer locrefid) throws Exception {
		return bonusloyalityproductrepository.getproducts(comid, branchid, locname, locrefid);
	}

	public boolean savebonusloyality(BonusLoyality bonusloyality) throws Exception {
		boolean flag = false;
		bonusloyalityrepository.save(bonusloyality);
		return flag = true;
	}

	public boolean savebonusproduct(List<BonusloyalityProduct> bonusloyalityProduct) throws Exception {
		boolean flag = false;
		if (flag == false) {
			for (BonusloyalityProduct blp : bonusloyalityProduct) {
				blp.setBlrefid(bonusloyalityrepository.getblid(blp.getCompanyrefid(), blp.getBranchrefid(),
						blp.getLocname(), blp.getLocrefid()));
				bonusloyalityproductrepository.save(blp);
			}
			flag = true;

		}
		return flag;
	}

	public List getbonusloyalitylist(Integer comid, Integer branchid, Integer locname, Integer locrefid)
			throws Exception {
		return bonusloyalityrepository.getbonuslist(comid, branchid, locname, locrefid);
	}

	public List getcuststype(Integer comid, Integer branchid, Integer locname, Integer locrefid) throws Exception {
		return bonusloyalityrepository.getloyalcusttype(comid, branchid, locname, locrefid);
	}

	public List getbonusproduct(Integer blid) throws Exception {
		return bonusloyalityproductrepository.getblproduct(blid);
	}

	// Puthiran Cust Loyalty
	public List getCustLoyaltyDetails(Integer custid) throws Exception {
		return bonusloyalityrepository.getCustLoyaltyDetails(custid);
	}

	public ResponseEntity<?> getLoyalityType(Loyality loyality) {
		Loyality ldatfgas = loyalityrepository.findByCompanyrefidAndBranchrefidAndLocnameAndLocarefidAndLoyalitytype(
				loyality.getCompanyrefid(), loyality.getBranchrefid(), loyality.getLocname(), loyality.getLocarefid(),
				loyality.getLoyalitytype());
		return ResponseEntity.created(null).body(ldatfgas);

	}

}
