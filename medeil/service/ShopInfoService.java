package com.medeil.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.medeil.repository.ShopInfoRepository;

@SuppressWarnings("rawtypes")
@Service
public class ShopInfoService {

	@Autowired
	ShopInfoRepository shopInfoRepository;

	public List getShopinfo(Integer id) throws Exception {

		return shopInfoRepository.Shopinfo(id);
	}

	public List getShopinfo1(Integer branchid) throws Exception {

		return shopInfoRepository.Shopinfo1(branchid);
	}

	public List getShopinfo2(Integer companyid) throws Exception {

		return shopInfoRepository.Shopinfo2(companyid);
	}
	
	
	public List getdistinfo(Integer companyid) throws Exception {

		return shopInfoRepository.distinfo(companyid);
	}
	
	
	public List getcompanydetails(Integer comid,Integer branchid ,Integer locaname , Integer locrefid)throws Exception {
		System.out.println("Companydetails Service");
		return shopInfoRepository.shopdetail(comid,branchid,locaname,locrefid);
	}
}
