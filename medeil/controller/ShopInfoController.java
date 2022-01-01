package com.medeil.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.medeil.service.ShopInfoService;

@SuppressWarnings("rawtypes")
@RestController
@RequestMapping("/api")
public class ShopInfoController {

	@Autowired
	ShopInfoService shopInfoService;

	@GetMapping(value = "getshopinfo/{id}")
	public List getShopInfo(@PathVariable Integer id) throws Exception {
		return shopInfoService.getShopinfo(id);
	}

	@GetMapping(value = "getshopname/{branchid}")
	public List getShopInfo1(@PathVariable Integer branchid) throws Exception {
		return shopInfoService.getShopinfo1(branchid);
	}

	@GetMapping(value = "getshopname1/{companyid}")
	public List getShopInfo2(@PathVariable Integer companyid) throws Exception {
		return shopInfoService.getShopinfo2(companyid);
	}
	
	@GetMapping(value = "getdistr/{companyid}")
	public List getdist(@PathVariable Integer companyid) throws Exception {
		return shopInfoService.getdistinfo(companyid);
	}
	
	@GetMapping(value = "/getcomdetails/{comid}/{branchid}/{locname}/{locrefid}")
	public List getcom(@PathVariable Integer comid, @PathVariable Integer branchid, @PathVariable Integer locname, @PathVariable Integer locrefid		)throws Exception {
		System.out.println("companyDetails");
		return shopInfoService.getcompanydetails(comid,branchid,locname,locrefid);
	}
}
