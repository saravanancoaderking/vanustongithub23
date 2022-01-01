/**
 * 
 */
package com.medeil.controller;

import java.io.File;
import java.math.BigInteger;
import java.nio.file.Files;
import java.util.Arrays;
import java.util.Base64;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.medeil.domain.Drug;
import com.medeil.domain.GenericCombination;
import com.medeil.domain.IndCompModel;
import com.medeil.domain.Insurance;
import com.medeil.domain.VanustonProductMaster;
import com.medeil.domain.VanustonVerticals;
import com.medeil.repository.DrugRepository;
import com.medeil.repository.VanustonProductMasterRepository;
import com.medeil.service.DrugService;

/**
 * @author Ajith Kumar
 *
 */
@RestController
@RequestMapping("api")
public class DrugController {
	static Drug imagedrug;
	static VanustonProductMaster imagedrug1;
	@Autowired
	private DrugService drugService;
	@Autowired
	private DrugRepository drugRepository;

	@Autowired
	private VanustonProductMasterRepository vanustondrugRepository;

	private static Logger logger = LogManager.getLogger();

	@GetMapping(value = "/getEMPSHAutoIncrements/{cid}/{bid}/{locname}/{locrefid}")
	public List getEMPSHAutoIncrements(@PathVariable Integer cid, @PathVariable Integer bid,
			@PathVariable Integer locname, @PathVariable Integer locrefid) throws Exception {
		return drugService.getEMPSHAutoIncrements(cid, bid, locname, locrefid);
	}

	
	@GetMapping("getmain/{verticalid}")
	public List getMain(@PathVariable Integer verticalid) throws Exception {
		return drugService.getMain(verticalid);
	}

	
	
	
	
	@GetMapping("getsubgroup1/{verticalid}/{value}")
	public List getsubgroup1(@PathVariable Integer verticalid, @PathVariable String value) throws Exception {
		return drugService.getsubgroup1(verticalid, value);
	}

	@GetMapping("getsubgroup2/{verticalid}/{value}")
	public List getsubgroup2(@PathVariable Integer verticalid, @PathVariable String value) throws Exception {
		return drugService.getsubgroup2(verticalid, value);
	}

	@GetMapping("getGeneric/{value}")
	public List getGeneric(@PathVariable String value) throws Exception {
		return drugService.getgeneric(value);
	}

	@GetMapping("getgenericCombination/{value}")
	public List genericCombination(@PathVariable String value) throws Exception {
		return drugService.genericCombination(value);
	}

	@GetMapping("getDosage")
	public List getDosage() throws Exception {
		return drugService.getDosage();
	}

	@GetMapping("getUom")
	public List getUom() throws Exception {
		return drugService.getUom();
	}

	@GetMapping("getFormulation")
	public List getFormulation() throws Exception {
		return drugService.getFormulation();
	}

	@GetMapping("getSchedule")
	public List getSchedule() throws Exception {
		return drugService.getSchedule();
	}

	@GetMapping("getInsurance")
	public List getInsurance() throws Exception {
		return drugService.getInsurance();
	}

	/********* Create Record **************/
	@PostMapping(value = "drugcreateRecord")
	public boolean createRecord(@RequestBody Drug drug) throws Exception {
		imagedrug = drugService.createRecord(drug);
		return true;
	}

	@PostMapping("savedrugInsurance")
	public void saveInsurance(@RequestBody List<Insurance> insObj) throws Exception {
		drugService.saveInsurance(insObj);
	}

	// Boopalan 040619
	/********* Drug View **************/
	@GetMapping(value = "viewDruginfo/{id}/{pageno}/{size}")
	public Page viewDrugmasters(@PathVariable Integer id, @PathVariable Integer pageno, @PathVariable Integer size)
			throws Exception {
		System.out.println("Inside drug" + id + "-" + pageno + "-" + size);
		return drugService.viewDrugmasters(id, pageno, size);
	}

	@GetMapping(value = "viewDruginfoAll/{cid}")
	public List viewVanustonDrugmastersAll(@PathVariable Integer cid) throws Exception {
		return drugService.viewDrugmastersAll(cid);
	}

	@GetMapping(value = "viewSearchDrugmastersAll/{cid}/{svalue}")
	public List viewSearchDrugmastersAll(@PathVariable Integer cid, @PathVariable String svalue) throws Exception {
		return drugService.viewSearchDrugmastersAll(cid, svalue);
	}

	@GetMapping(value = "viewCombGenericAll/{drugid}")
	public List viewCombGenericAll(@PathVariable Integer drugid) {
		return drugService.viewCombGenericAll(drugid);
	}

	// Puthiran 261219
	/********* Drug Product Search **************/
	@GetMapping(value = "searchdrugitems/{id}/{searchindex}/{searchvalue}/{pageno}/{size}")
	public Page searchdrugproduct(@PathVariable Integer id, @PathVariable Integer searchindex,
			@PathVariable String searchvalue, @PathVariable Integer pageno, @PathVariable Integer size)
			throws Exception {
		return drugService.searchdrugitem(id, searchindex, searchvalue, pageno, size);
	}

	/********* Edit Record **************/ // Boopalan 170419
	@GetMapping(value = "getdrugeditval/{id}")
	public List getDrugedit(@PathVariable Integer id) throws Exception {
		return drugService.getDrugedit(id);
	}

	@GetMapping(value = "getCustDrugsID/{id}")
	public Drug CustProductsID(@PathVariable Integer id) {
		return drugService.CustProductsID(id);
	}

	@GetMapping(value = "geteditDistributorChannel/{id}") // Boopalan 300419
	public List geteditDistributorChannel(@PathVariable Integer id) throws Exception {
		return drugService.geteditDistributorChannel(id);
	}

	@GetMapping(value = "geteditformulation/{id}")
	public List editFormulation(@PathVariable Integer id) throws Exception {
		return drugService.geteditFormulation(id);
	}

	@GetMapping(value = "geteditschedule/{id}")
	public List editSchedule(@PathVariable Integer id) throws Exception {
		return drugService.editSchedule(id);
	}

	@GetMapping(value = "geteditmanufacture/{id}")
	public List geteditManufacture(@PathVariable Integer id) throws Exception {
		return drugService.geteditManufacture(id);
	}

	@GetMapping(value = "geteditvat/{id}")
	public List editVat(@PathVariable Integer id) throws Exception {
		return drugService.editVat(id);
	}

	@GetMapping(value = "geteditgst/{id}")
	public List editGst(@PathVariable Integer id) throws Exception {
		return drugService.editGst(id);
	}

	@GetMapping(value = "geteditsgst/{id}")
	public List editSgst(@PathVariable Integer id) throws Exception {
		return drugService.editSgst(id);
	}

	@GetMapping(value = "geteditcgst/{id}")
	public List editCgst(@PathVariable Integer id) throws Exception {
		return drugService.editCgst(id);
	}

	@GetMapping(value = "geteditigst/{id}")
	public List editIgst(@PathVariable Integer id) throws Exception {
		return drugService.editIgst(id);
	}

	@GetMapping(value = "getEditinsurance/{id}")
	public List geteditInsurance(@PathVariable Integer id) throws Exception {
		return drugService.geteditInsurance(id);
	}

	@GetMapping("geteditgeneric/{id}")
	public List geteditGen(@PathVariable Integer id) throws Exception {
		return drugService.geteditGeneric(id);
	}

	/********* EDIT GENERIC ID **************/ // Boopalan 170419
	@GetMapping("geteditgenericid/{drugid}")
	public List geteditGenid(@PathVariable Integer drugid) throws Exception {
		return drugService.geteditGenericid(drugid);
	}

	
	/********* Update Record **************/
	@PostMapping("drugupdateRecord")
	public Boolean updateRecord(@RequestBody Drug drug) throws Exception {
		// try {
		imagedrug = drugService.updateRecord(drug);
		return true;
		// } catch (Exception e) {
		// // TODO Auto-generated catch block
		// e.printStackTrace();
		// }
		// return false;
	}

	/********* Delete Record **************/
	@GetMapping(value = "deleteDrugdetails/{id}")
	public boolean deleteDrugdetails(@PathVariable Integer id) throws Exception {
		return drugService.deleteDrugdetails(id);
	}

	/*********** Photo Upload ***************/

	@PostMapping(value = "uploadphoto")
	public boolean handleFileUpload1(@RequestPart("file") MultipartFile file) throws Exception {
		String message = "";
		// try {
		drugService.store(file);
		message = "You successfully uploaded";
		return true;
		// } catch (Exception e) {
		// message = "FAIL to upload Images";
		// logger.error(message);
		// return message;
		// }
	}

	
	@PostMapping(value = "uploadmultiphoto")
	public String uploadmultiphoto(@RequestPart("file") MultipartFile[] file, Drug drug) throws Exception {
		String message = "";
		// try {
		drugService.storemultiphotos(file,drug);
		message = "You successfully uploaded";
		return message;
		// } catch (Exception e) {
		// message = "FAIL to upload Images";
		// logger.error(message);
		// return message;
		// }
	}
	@PostMapping(value = "modifyuploadphoto/{id}")
	public String modifyFileUpload(@PathVariable Integer id, @RequestPart("file") MultipartFile[] file)
			throws Exception {
		String message = "";
		// try {
		drugService.storeModify(file, id);
		message = "You successfully uploaded";
		return message;
		// } catch (Exception e) {
		// message = "FAIL to upload Images";
		// logger.error(message);
		// return message;
		// }
	}

	@GetMapping(value = "getUploadfiles/{id}")
	public @ResponseBody Map<String, String> getImage(@PathVariable String id) throws Exception {
		return drugService.getuploadedImage(id);
	}

	/********* ATC CODE **************/

	@GetMapping(value = "getATC/{id}")
	public List getATCode(@PathVariable Integer id) throws Exception {
		return drugService.getATCode(id);
	}

	@PostMapping(value = "savecombination")
	public Integer saveGenCombo(@RequestBody List<GenericCombination> genericcombo) throws Exception {
		return drugService.saveGenCombo(genericcombo);
	}

	/**** EDIT MAIN GROUP ****/ // Boopalan 190419
	@GetMapping("editmain/{value}")
	public List getEdtMain(@PathVariable Integer value) throws Exception {
		return drugService.getEdtMain(value);
	}

	/**** EDIT SUBGROUP1 ****/ // Boopalan 190419
	@GetMapping("editsubgroup1/{value}")
	public List subgroup1(@PathVariable Integer value) throws Exception {
		return drugService.subgroup1(value);
	}

	/**** EDIT SUBGROUP2 ****/ // Boopalan 190419
	@GetMapping("editsubgroup2/{value}")
	public List subgroup2(@PathVariable Integer value) throws Exception {
		return drugService.subgroup2(value);
	}

	/*********** Drug Photo Upload ***************/
	// Boopalan 071119
	@PostMapping(value = "/upload-drug-image")
	public boolean uploadDrugImage(@RequestPart("file") MultipartFile file) throws Exception {
		drugService.uploadDrugImage(file, imagedrug);
		System.out.println("return image..");
		return true;
		// } catch (Exception e) {

		// return false;
		// }
	}
	
//
	// https://www.bezkoder.com/spring-boot-upload-multiple-files/ sound
	@PostMapping("/uploadmultifiles")
	public boolean uploadFiles(@RequestParam("files") MultipartFile[] files) {
		Drug imagedrug = new Drug();
		try {
			Arrays.asList(files).stream().forEach(file -> {
				try {
					drugService.uploadDrugImage(file, imagedrug);
					System.out.println("upload-multidrug-image-testing");
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			});
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	/********* Update Record **************/
	@PostMapping("set-image-values")
	public Boolean updateimgRecord(@RequestBody Drug drug) throws Exception {

		// try {
		drugService.updateimgRecord(drug);
		return true;
		// } catch (Exception e) {
		// // TODO Auto-generated catch block
		// e.printStackTrace();
		// }
		// return false;
	}

	@PostMapping(value = "/update-drug-image")
	public boolean updateDrugImage(@RequestPart("file") MultipartFile file) throws Exception {
		Drug imagedrug = new Drug();
		System.out.println("upload-drug-image-testing");
		// try {
		drugService.updateDrugImage(file, imagedrug);
		System.out.println("return image..");
		return true;
		// } catch (Exception e) {

		// return false;
		// }
	}

	/**** get-substitute-drug ****/
	@GetMapping("get-substitute-drug/{drugid}/{cid}/{bid}/{locname}/{locrefid}")
	public List getSubstituteDrug(@PathVariable Integer drugid, @PathVariable Integer cid, @PathVariable Integer bid,
			@PathVariable Integer locname, @PathVariable Integer locrefid) throws Exception {

		int generic = 0;
		int formulation = 0;
		String dosage = "";
		List<Object[]> pro = drugService.getSubstituteDrugDetails(drugid);
		for (Object[] x : pro) {
			BigInteger bi1 = new BigInteger(x[0].toString());
			generic = bi1.intValue();
			System.out.println("b1" + bi1);
			BigInteger bi2 = new BigInteger(x[1].toString());
			formulation = bi2.intValue();
			System.out.println("bi2" + bi2);
			dosage = (String) x[2];

		}
		return drugService.getSubstituteDrug(generic, formulation, dosage, cid, bid, locname, locrefid);
	}

	/*********** View Drug Photo ***************/
	// Boopalan 071119
	@GetMapping(value = "/get-drug-image/{drugid}")
	public Map<String, String> getsendImage(@PathVariable Integer drugid) throws Exception {
		Map<String, String> jsonMap = new HashMap<>();
		// try {
		String path = drugRepository.getsendImage(drugid);
		System.out.println(drugid);
		File serverFile = new File(path);
		String encodeImage = Base64.getEncoder().withoutPadding()
				.encodeToString(Files.readAllBytes(serverFile.toPath()));
		jsonMap.put("content", encodeImage);
		return jsonMap;
		// } catch (Exception e) {
		// e.printStackTrace();
		// jsonMap.put("content", "no image");
		// return jsonMap;

		// }

	}

	// Desing Raja
	// View Banned Drug
	@GetMapping(value = "getbanneddrug/{countryid}/{bannedstatus}")
	public List bandruglist(@PathVariable Integer countryid, @PathVariable Integer bannedstatus) throws Exception {
		return drugService.getbandrug(countryid, bannedstatus);
	}

	/********* Create Vanuston Record **************/
	@PostMapping("vanuston-drugcreateRecord")
	public boolean vanustonCreateRecord(@RequestBody VanustonProductMaster drug) throws Exception {
		// try {
		imagedrug1 = drugService.VanustonCreateRecord(drug);
		// System.out.println(imagedrug.getId());
		return true;
		// } catch (Exception e) {
		// TODO Auto-generated catch block
		// e.printStackTrace();
		// }
		// return false;
	}

	/********* Edit Vanuston Record **************/ // Boopalan 170419
	@GetMapping(value = "vanuston-getdrugeditval/{id}")
	public List getDrugedit1(@PathVariable Integer id) throws Exception {
		return drugService.getDrugedit1(id);
	}

	/*********** Drug Photo Upload ***************/
	// Boopalan 071119
	@PostMapping(value = "/vanuston-upload-drug-image")
	public boolean vanustonDploadDrugImage(@RequestPart("file") MultipartFile file) throws Exception {
		System.out.println("vanustonDploadDrugImage-testing");
		// try {
		drugService.vanustonDploadDrugImage(file, imagedrug1);
		System.out.println("return image..");
		return true;
		// } catch (Exception e) {

//			return false;
		// }
	}

	@PostMapping("set-vanustonimage-values")
	public Boolean updatevanustonimgRecord(@RequestBody Drug drug) throws Exception {
		// try {
		drugService.updatevanustonimgRecord(drug);
		return true;
		// } catch (Exception e) {
		// TODO Auto-generated catch block
		// e.printStackTrace();
		// }
		// return false;
	}

	@PostMapping(value = "/vanuston-update-drug-image")
	public boolean VanustonupdateDrugImage(@RequestPart("file") MultipartFile file) throws Exception {
		Drug imagedrug = new Drug();
		System.out.println("upload-drug-image-testing");
		// try {
		drugService.VanustonUpdateDrugImage(file, imagedrug);
		System.out.println("return image..");
		return true;
		// } catch (Exception e) {

		// return false;
		// }
	}

	/*********** Drug Photo view ***************/
	@GetMapping(value = "/get-vanuston-drug-image/{drugid}")
	public Map<String, String> getsendVanustonImage(@PathVariable Integer drugid) throws Exception {
		Map<String, String> jsonMap = new HashMap<>();
		// try {
		String path = vanustondrugRepository.getsendVanustonImage(drugid);
		System.out.println(drugid);
		File serverFile = new File(path);
		String encodeImage = Base64.getEncoder().withoutPadding()
				.encodeToString(Files.readAllBytes(serverFile.toPath()));
		jsonMap.put("content", encodeImage);
		return jsonMap;
		// } catch (Exception e) {
		// e.printStackTrace();
		// jsonMap.put("content", "no image");
		// return jsonMap;

		// }

	}

	/********* Update vanuston Record **************/
	@PostMapping("vanuston-drugupdateRecord")
	public Boolean vanustonUpdateRecord(@RequestBody VanustonProductMaster drug) throws Exception {
		// try {
		imagedrug1 = drugService.vanustonUpdateRecord(drug);
		return true;
		// } catch (Exception e) {
		// // TODO Auto-generated catch block
		// e.printStackTrace();
		// }
		// return false;
	}

	/********* View vanuston Record **************/
	@GetMapping(value = "viewVanustonDruginfo")
	public List viewVanustonDrugmasters() throws Exception {
		return drugService.viewVanustonDrugmasters();
	}

	/********* Delete vanuston Record **************/
	@GetMapping(value = "vanuston-deleteDrugdetails/{id}")
	public boolean vanustonDeleteDrugdetails(@PathVariable Integer id) throws Exception {
		return drugService.vanustonDeleteDrugdetails(id);

	}

	// get vanuston drugs by serach
	@GetMapping(value = "getVanustonDrugsSearch/{countryid}/{searchvalue}")
	public List VanustonProducts(@PathVariable Integer countryid, @PathVariable String searchvalue) throws Exception {
		return drugService.VanustonProducts(countryid, searchvalue);
	}

	@GetMapping(value = "getVanustonDrugsID/{id}")
	public VanustonProductMaster VanustonProductsID(@PathVariable Integer id) throws Exception {
		return drugService.VanustonProductsID(id);
	}

	/********* Save Vertical ID Drop Down **************/
	@PostMapping(value = "vanuston-save-vertical-drop-down")
	public VanustonVerticals vanustonSaveVerticalID(@RequestBody VanustonVerticals vanustonVerticals) throws Exception {
		return drugService.vanustonSaveVerticalID(vanustonVerticals);
	}

	/********* Vertical ID Drop Down **************/
	@GetMapping(value = "vanuston-vertical-drop-down/{id}")
	public List vanustonVerticalID(@PathVariable int id) throws Exception {
		return drugService.vanustonVerticalID(id);
	}

	@GetMapping(value = "gettaxcountrywise/{id}")
	public List GetTaxCountryWise(@PathVariable int id) throws Exception {
		return drugService.GetTaxCountryWise(id);
	}

	/*********
	 * Vanuston Drug Product Search In Customer Product Master Form
	 **************/
	@GetMapping(value = "search-product-in-vanuston-productmaster/{productname}")
	public List<VanustonProductMaster> searchProductInVanustonProductMaster(@PathVariable String productname)
			throws Exception {
		return drugService.searchProductInVanustonProductMaster(productname);
	}

	/*********
	 * Import Vanuston Drug Product into Customer Product Master
	 **************/
	@PostMapping(value = "import-product-from-vanuston-to-customer")
	public boolean importProductFromVanustonToCustomer(@RequestBody Drug drug) throws Exception {
		return drugService.importProductFromVanustonToCustomer(drug);
	}

	/***** QC PROCESS ****/

//	/*********
//	 * Moving Drug Product from Customer Product Master for QC Process
//	 **************/							
//	@Scheduled(cron = "0 0 0 * * *")
//	@GetMapping(value = "move-customer-drug-to-qc-process")
//	public void moveCustomerDrugToQcProcess() throws Exception {
//		drugService.moveCustomerDrugToQcProcess();
//	}

//	/*********
//	 * View QC Drug Product Before Processing
//	 **************/
//	@GetMapping(value = "view-qc-drug-before-processing")
//	public List<QcProductMaster> viewQcDrugBeforeProcessing() throws Exception {
//		return drugService.viewQcDrugBeforeProcessing();
//	}

//	/*********
//	 * update QC Drug Product after Processing
//	 **************/
//	@PostMapping(value = "update-qc-drug-after-processing")
//	public boolean updateQcDrugAfterProcessing(@RequestBody List<QcProductMaster> qcProductMaster) throws Exception {
//		return drugService.updateQcDrugAfterProcessing(qcProductMaster);
//	}

//	/***** QA PROCESS ****/
//	/*********
//	 * Save QA Drug Product after Processing of QC
//	 **************/
//	@PostMapping(value = "save-qa-drug-after-processing-of-qc")
//	public boolean saveQADrugAfterProcessingOfQC(@RequestBody QaProductMaster qaProductMaster) throws Exception {
//		return drugService.saveQADrugAfterProcessingOfQC(qaProductMaster);
//	}

//	/*********
//	 * Approve QA Drug Product after Processing of QC
//	 **************/
//	@PostMapping(value = "approve-qa-drug-after-processing")
//	public boolean approveQaProcess(@RequestBody QaProductMaster qaProductMaster) throws Exception {
//		return drugService.approveQaProcess(qaProductMaster);
//	}

	// DesingRaja
	// Add Banned Drug
	@ResponseBody
	@RequestMapping("/viewBannedProductNames")
	public List viewProductNames(@RequestBody IndCompModel loc) throws Exception {
		return drugService.viewProductNames(loc);

	}

	// DesingRaja

	@GetMapping(value = "/getproductdata/{genericid}/{countryid}")
	public List getprod(@PathVariable Integer genericid, @PathVariable Integer countryid) throws Exception {
		System.out.println("Desing Controller");
		return drugService.getproddata(genericid, countryid);
	}
	// DesingRaja

	@GetMapping(value = "/updatebanned/{genericid}/{countryid}/{bannedfrom}/{reason}")
	public boolean banneddrug(@PathVariable Integer genericid, @PathVariable Integer countryid,
			@PathVariable String bannedfrom, @PathVariable String reason) throws Exception {
		System.out.println(genericid + " " + countryid + " " + bannedfrom + " " + reason);
		return drugService.banned(genericid, countryid, bannedfrom, reason);

	}

	// Desingraja

	@RequestMapping(value = "/getbangenr/{countryid}")
	public List getprod(@PathVariable Integer countryid) throws Exception {
		System.out.println("Desing Controller");
		return drugService.getbangendata(countryid);
	}

//Pharma Company
	@GetMapping(value = "searchmanufacture/{compid}/{branchid}/{locname}/{locrefid}/{searchkey}")
	public List searchmanuf(@PathVariable Integer compid, @PathVariable Integer branchid, @PathVariable Integer locname,
			@PathVariable Integer locrefid, @PathVariable String searchkey) throws Exception {
		return drugService.searchmanufacture(compid, branchid, locname, locrefid, searchkey);
	}
}
