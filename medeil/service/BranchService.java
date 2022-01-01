/**
 * 
 */
package com.medeil.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


import com.medeil.domain.Branch;
import com.medeil.domain.Shop;
import com.medeil.repository.BranchRepository;
import com.medeil.repository.ShopRepository;

/**
 * @author Ajith
 *
 */
@SuppressWarnings("rawtypes")
@Service
public class BranchService {

	@Autowired
	private BranchRepository branchRepository;
	
	@Autowired
	private ShopRepository shopRepository;

	private static Logger logger = LogManager.getLogger();

	List list = null;

	public Branch saveBranch(Branch brnc)throws Exception {
		//Branch br = null;
		//try {
		//br = branchRepository.save(brnc);
		//} catch (Exception e) {
		//	logger.error("Exception in Method : saveBranch() " + e);
		//}
		Shop shop = new Shop();
		int bid = branchRepository.save(brnc).getId();
		shop.setCompanyrefid(brnc.getCompanyrefid());
		shop.setCompanyid(brnc.getCompanyrefid());
		shop.setBranchrefid(bid);
		shop.setBranchid(bid);
		shop.setLocname(brnc.getLocname());
		shop.setShopname(brnc.getBranchname());
		shop.setEmailid(brnc.getEmail());
		shop.setMobileno(brnc.getMobileno());
		shop.setCountry(brnc.getCountry());
		shop.setCity(brnc.getCity());
		shop.setState(brnc.getState());
		int sid = shopRepository.save(shop).getId();
		shop.setLocrefid(sid);
		shopRepository.save(shop);
		 return brnc;
	}

	
	public Branch updateBranch(Branch brnc)throws Exception {

	//	Branch br = null;
	//	try {
	//		br = branchRepository.save(brnc);
	//	} catch (Exception e) {
	//		logger.error("Exception in Method : updateBranch() " + e);
	//	}
		return branchRepository.save(brnc);
	}

//	public List viewBranch(Integer pageno, Integer size) {
//		list = null;
//		try {
//			list = branchRepository.viewBranch();
//		} catch (Exception e) {
//			logger.error("Exception in Method : viewBranch() " + e);
//		}
//		return list;
//	}
//	
public List viewBranch(Integer cid)throws Exception {
		
	//	Page page = null;
	//	try {
//			Pageable paging = PageRequest.of(pageno, size);	
//			Page page = branchRepository.viewBranch();
//			System.out.println(page.getTotalPages());
	//	}
	//	catch (Exception ex) {
	//		logger.error("Exception in Method : domainList() : " + ex);
	//	}
		
		return  branchRepository.viewBranch(cid);
		
	}

	
	
	
	
	
	
	
	

	public Branch branchEdit(int brncid)throws Exception {

	//	Branch br = null;
	//	try {
	//		br = branchRepository.findById(brncid);
	//	} catch (Exception e) {
	//		logger.error("Exception in Method : editValue() " + e);
	//	}
		return branchRepository.findById(brncid);
	}

	public Integer deleteBranch(int brncid)throws Exception {
	//	Integer ob = null;
	//	try {
	//		ob = branchRepository.deleteBranch(brncid);
	//	} catch (Exception e) {
	//		logger.error("Exception in Method : deleteBranch() " + e);
	//	}
		return branchRepository.deleteBranch(brncid);
	}

	// ****Company Inforamtion EditForm Methods Calling(Services) ****//

	public List branchEditState(int brncid)throws Exception{
		list = null;
		//try {
			Branch br = branchRepository.findById(brncid);
			list = branchRepository.branchEditState(br.getState());
	//	} catch (Exception e) {
	//		logger.error("Exception in Method : editState1() " + e);
	//	}
		return list;
	}

	public List branchEditCity(int brncid)throws Exception {
		list = null;
		//try {
			Branch br = branchRepository.findById(brncid);
			list = branchRepository.branchEditCity(br.getCity());
		//} catch (Exception e) {
		//	logger.error("Exception in Method : editState() " + e);
		//}

		return list;
	}

	public List branchEditCcode(int branchid)throws Exception {
		list = null;
	//	try {
			Branch br = branchRepository.findById(branchid);
			list = branchRepository.branchEditCcode(br.getCountry());
	//	} catch (Exception e) {
	//		logger.error("Exception in Method : editState() " + e);
	//	}

		return list;
	}

	public List editCompanyName(int id)throws Exception {
		list = null;
	//	try {
			Branch br = branchRepository.findById(id);
			list = branchRepository.editCompanyName(br.getCompanyrefid());
	//	} catch (Exception e) {
	//		logger.error("Exception in Method : editGetcompname() " + e);
	//	}

		return list;
	}

	public boolean isBranchExist(String brnch,String compID)throws Exception {
		boolean isExist = false;
	//	try {
			String reVal = branchRepository.isExistBranch(brnch,compID);
			System.out.println("reVal"+reVal);
			if (reVal != null) {
				isExist = true;
			} else {
				isExist = false;
			}

	//	} catch (Exception e) {
	//		logger.error("Exception in Method : isBracnExist() " + e);
	//	}

		return isExist;
	}
	
	public boolean isBranchUpdateExist(String brnch,String brnchid,String compID)throws Exception {
		boolean isExist = false;
	//	try {
			String reVal = branchRepository.isBranchUpdateExist(brnch,brnchid,compID);
			System.out.println("reVal"+reVal);
			if (reVal != null) {
				isExist = true;
			} else {
				isExist = false;
			}

	//	} catch (Exception e) {
	//		logger.error("Exception in Method : isBracnExist() " + e);
	//	}

		return isExist;
	}


	public List getcount(Integer cid) {
		return branchRepository.getusercounts(cid);
	}


	public List getLocalnameBranch(Integer companyid,Integer locid) {
		return branchRepository.getLocalnameBranch(companyid,locid);
	}


	public List getBranchShop(Integer companyid,Integer branchid) {
		return branchRepository.getBranchShop(companyid,branchid);
	}


	public List getLocalnameShop(Integer companyid,Integer locid) {
		return branchRepository.getLocalnameShop(companyid,locid);
	}
}
