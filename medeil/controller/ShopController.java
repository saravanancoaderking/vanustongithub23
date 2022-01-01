/**
 * Ajith
 */
package com.medeil.controller;

import java.io.File;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Base64;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.medeil.domain.Shop;
import com.medeil.service.ShopServices;

/**
 * @author Ajith
 */
@SuppressWarnings("rawtypes")
@RestController
@RequestMapping("api")
public class ShopController {

	@Autowired
	private ShopServices shopServices;

	@PostMapping(value = "createshopRecord")
	public Shop shopInfo(@RequestBody Shop shop) throws Exception {
		return shopServices.createRecord(shop);
	}

	@PostMapping(value = "updateshopRecord")
	public Shop updateShop(@RequestBody Shop shop) throws Exception {
		return shopServices.updateShop(shop);
	}

//Raja
	@GetMapping(value = "viewshopRecord/{cid}/{bid}/{locname}/{locrefid}")
	public List viewshopInfo(@PathVariable Integer cid, @PathVariable Integer bid, @PathVariable Integer locname,
			@PathVariable Integer locrefid) throws Exception {
		List list=new ArrayList<>();
		Map<String, Object> lists = new HashMap<>();
		String path = shopServices.getImage(cid, bid);
		List printimagevalues = shopServices.getvalues(cid, bid);
		if (path.equals("No_Image")) {
			lists.put("imageurl", "No_Image");
			lists.put("imagevalues", printimagevalues);
			list.add(lists);
			return list;
		} else {
				File serverFile = new File(path);
				String encodeImage = Base64.getEncoder().withoutPadding()
						.encodeToString(Files.readAllBytes(serverFile.toPath()));
				lists.put("imageurl", encodeImage);
				lists.put("imagevalues", printimagevalues);
				list.add(lists);
				return list;
		}
	}

	@GetMapping(value = "shopid/{id}")
	public Map shopEdit(@PathVariable Integer id) throws Exception {
		Map<String, Object> list = new HashMap<String, Object>();
		String path = shopServices.getshopid(id);
		if (path.equals("No_Image")) {
			list.put("imageurl", "No_Image");
			list.put("imagevalues", shopServices.shopEdit(id));
		} else if (!path.equals("No_Image")) {
			File serverFile = new File(path);
			String encodeImage = Base64.getEncoder().withoutPadding()
					.encodeToString(Files.readAllBytes(serverFile.toPath()));
			list.put("imageurl", encodeImage);
			list.put("imagevalues", shopServices.shopEdit(id));
		}
		return list;
	}

	@GetMapping(value = "deleteshopRecord/{id}")
	public void deleteShop(@PathVariable Integer id) throws Exception {
		shopServices.shopDelete(id);
	}

	@GetMapping(value = "geteditshopState/{id}")
	public List editShopstate(@PathVariable Integer id) throws Exception {
		return shopServices.editShopstate(id);
	}

	@GetMapping(value = "geteditshopCity/{id}")
	public List editShopcity(@PathVariable Integer id) throws Exception {
		return shopServices.geteditshopCity(id);
	}

	@GetMapping(value = "geteditshopsState/{id}")
	public List editShopsstate(@PathVariable Integer id) throws Exception {
		return shopServices.editShopsstate(id);
	}

	@GetMapping(value = "geteditshopsCity/{id}")
	public List editShopscity(@PathVariable Integer id) throws Exception {
		return shopServices.geteditshopsCity(id);
	}

	@GetMapping(value = "geteditcompany1/{id}")
	public List editShopscompany(@PathVariable Integer id) throws Exception {
		return shopServices.editShopsCompany(id);
	}

	@GetMapping(value = "geteditbranch1/{id}")
	public List editShopsbranch(@PathVariable Integer id) throws Exception {
		return shopServices.geteditshopsBranch(id);
	}

	@GetMapping(value = "bank-details/{bankid}/{branchid}")
	public List getbankdetails(@PathVariable Integer bankid, @PathVariable Integer branchid) throws Exception {
		return shopServices.getbankdetails(bankid, branchid);
	}

	@GetMapping(value = "bank-id/{search}")
	public List getbankid(@PathVariable String search) throws Exception {
		return shopServices.getbankid(search);
	}

	@GetMapping(value = "bank-details/{bankid}/{search}")
	public List getbranchid(@PathVariable Integer bankid, @PathVariable String search) throws Exception {
		return shopServices.getbranchid(bankid, search);
	}

	@PostMapping(value = "/uploadshoplogophoto")
	public boolean shoplogo(@RequestPart("file") MultipartFile file) throws Exception {
		System.out.println("image testing..");
		// try {
		shopServices.shoplogo(file);
		System.out.println("return image..");
		return true;
		// } catch (Exception e){

		// return false;
		// }
	}

}