/**
 * 
 */
package com.medeil.service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.medeil.domain.Shop;
import com.medeil.repository.ShopRepository;

/**
 * @author Ajith
 *
 */
@SuppressWarnings("rawtypes")
@Service
public class ShopServices {
	static Shop shoprecord;
	@Autowired
	private ShopRepository shopRepository;

//Raja
	public List shopView(Integer cid, Integer bid) throws Exception {
		return shopRepository.viewShop(cid, bid);
	}

	public void shopDelete(int shopid) throws Exception {
		shopRepository.deleteShop(shopid);
	}

	public List editShopstate(int id) throws Exception {
		Shop sh = shopRepository.findById(id);
		return shopRepository.editShopstate(sh.getCountry());
	}

	public List geteditshopCity(int id) throws Exception {
		Shop sh = shopRepository.findById(id);
		return shopRepository.geteditshopCity(sh.getState());
	}

	public List editShopsstate(int id) throws Exception {
		Shop sh = shopRepository.findById(id);
		return shopRepository.editShopstate(sh.getPhar_country());
	}

	public List editShopsCompany(int id) throws Exception {
		Shop sh = shopRepository.findById(id);
		return shopRepository.geteditshopCompany(sh.getCompanyid());
	}

	public List geteditshopsBranch(int id) throws Exception {
		Shop sh = shopRepository.findById(id);
		return shopRepository.editShopBranch(sh.getCompanyid());
	}

	public List geteditshopsCity(int id) throws Exception {
		Shop sh = shopRepository.findById(id);
		return shopRepository.geteditshopCity(sh.getPhar_state());
	}

	public Shop createRecord(Shop shop) throws Exception {
		return shopRepository.save(shop);
	}

	public Shop updateShop(Shop shop) throws Exception {
		shoprecord = shop;
		// Shop sh = shopRepository.findById(shop.getId());
		return shopRepository.save(shop);
	}

	public Shop shopEdit(Integer id) throws Exception {
		return shopRepository.findBylocrefid(id);
	}

	public List getbankid(String search) throws Exception {
		return shopRepository.getbankid(search);
	}

	public List getbranchid(Integer bankid, String search) throws Exception {
		return shopRepository.getbranchid(bankid, search);
	}

	public String getImage(Integer cid, Integer bid) throws Exception {
		return shopRepository.getImage(cid, bid);
	}

	public List getvalues(Integer cid, Integer bid) throws Exception {
		return shopRepository.getvalues(cid, bid);
	}

	public List getbankdetails(Integer bankid, Integer branchid) throws Exception {
		return shopRepository.getbankdetails(bankid, branchid);
	}

	public String shoplogo(MultipartFile file) throws Exception {
		String filepath = "Undefined Path";
		// Save the uploaded file to this folder
//		String UPLOADED_FOLDER = "E://git//medeil//MedeilBoot//PrescriptionImage//";
		String UPLOADED_FOLDER = "//home//medeilpos//Desktop//images//employeeimages//";
		System.out.println("Save path" + UPLOADED_FOLDER);
//		UPLOADED_FOLDER.getParentFile().mkdirs();
		// Server Path
		// C://Users//Administrator//git//medeil//MedeilBoot//EmployeePhoto//
		if (file.isEmpty()) {
			return filepath;
		}

		try {
			System.out.println("Pass try");

			byte[] bytes = file.getBytes();
			Path path = Paths.get(UPLOADED_FOLDER + shoprecord.getShopname() + "_" + shoprecord.getLocrefid() + ".png");
			Files.write(path, bytes);
			System.out.println("path" + path.toString());
			filepath = path.toString();
			System.out.println("file path" + filepath);
//			System.out.println("company" +employeeRecord.getCompanyid()+"Branch"+employeeRecord.getBranchid()
//			+"Locname"+employeeRecord.getLocname()+"locrefid"+employeeRecord.getLocrefid()+"employecode"+ employeeRecord.getEmployeecode());
			shopRepository.shoplogo(filepath, shoprecord.getCompanyrefid(), shoprecord.getBranchrefid(),
					shoprecord.getLocname(), shoprecord.getLocrefid());
		} catch (IOException e) {
			e.printStackTrace();
			throw new Exception(e);
		}

		return filepath;

	}

	public String getshopid(Integer id) throws Exception {
		return shopRepository.getshopid(id);
	}
}
