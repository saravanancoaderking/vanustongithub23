package com.medeil.service;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Base64;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.servlet.http.HttpSession;
import javax.transaction.Transactional;

import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.medeil.domain.Drug;
import com.medeil.domain.GenericCombination;
import com.medeil.domain.IndCompModel;
import com.medeil.domain.Insurance;
import com.medeil.domain.QaProductMaster;
import com.medeil.domain.QcProductMaster;
import com.medeil.domain.VanustonProductMaster;
import com.medeil.domain.VanustonVerticals;
import com.medeil.repository.DrugRepository;
import com.medeil.repository.QaProductMasterRepository;
import com.medeil.repository.QcProductMasterRepository;
import com.medeil.repository.VanustonProductMasterRepository;
import com.medeil.repository.VanustonVerticalsRepository;

/**
 * @author Ajith Kumar
 *
 */
@SuppressWarnings("rawtypes")
@Service
public class DrugService {
	String[][] s = { { "0", "Drug Not Found" } };
	String[][] s1 = { { "0", "Drug Not Found" } };
	List list = null;
	List list1 = null;

	private int updateid;
	private String updateuniformcode;
	private String updatebrandname;

	Integer companyId = 0;
	Integer branchId = 0;
	Integer locName = 0;
	Integer locRefID = 0;
	private static Logger logger = LogManager.getLogger();
	@Autowired
	private DrugRepository drugRepository;
	@Autowired
	VanustonProductMasterRepository VanustonProductMasterRepository;
	@Autowired
	VanustonVerticalsRepository vanustonVerticalsRepository;
	@Autowired
	QcProductMasterRepository qcProductMasterRepository;
	@Autowired
	QaProductMasterRepository qaProductMasterRepository;
	@PersistenceContext
	private EntityManager em;

	private final Path rootLocation = Paths.get("drugPicture");
	@Autowired
	HttpSession session;

	Query query;

	public List getMain(Integer verticalid) throws Exception {
		return drugRepository.getMain(verticalid);
	}

	public List getsubgroup1(Integer verticalid, String value) throws Exception {

		boolean b = drugRepository.getsubgroup1(verticalid, value).isEmpty();
		if (b) {
			return list1 = Arrays.asList(s);
		}

		else {
			return drugRepository.getsubgroup1(verticalid, value);
		}
	}

	public List getsubgroup2(Integer verticalid, String value) throws Exception {

		boolean b = drugRepository.getsubgroup2(verticalid, value).isEmpty();
		if (b) {
			return list = Arrays.asList(s1);
		}

		else {
			return drugRepository.getsubgroup2(verticalid, value);
		}

	}

	public List getgeneric(String value) throws Exception {
		return drugRepository.getGeneric(value);
	}

	public List genericCombination(String value) throws Exception {
		return drugRepository.genericCombination(value);
	}

	public List getDosage() throws Exception {
		return drugRepository.getDosage();
	}

	public List getUom() throws Exception {
		return drugRepository.getUom();
	}

	public List getFormulation() throws Exception {
		return drugRepository.getFormulation();
	}

	public List getSchedule() throws Exception {
		return drugRepository.getSchedule();
	}

	public List getInsurance() throws Exception {
		return drugRepository.getInsurance();
	}

	/****** Create Record ******/
	public Drug createRecord(Drug dr) throws Exception {
		System.out.print("Enter equals");
		String genericName = drugRepository.getGenericName(dr.getGenericid());
		dr.setGeneric_name(genericName);
		companyId = dr.getCompanyid();
		branchId = dr.getBranchid();
		locName = dr.getLocname();
		locRefID = dr.getLocrefid();
		System.out.print("Enter Session" + companyId + "--" + branchId + "--" + locName + "--" + locRefID);
		String oldSON = drugRepository.UniformProductCode(dr.getCompanyid(), dr.getBranchid(), dr.getLocname(),
				dr.getLocrefid());
		System.out.print("Enter Oldson" + oldSON);
		String oldInco = oldSON.substring(oldSON.length() - 6, oldSON.length());
		Long newInco = Long.parseLong(oldInco) + 1;
		String newSoNo = StringUtils.leftPad(newInco.toString(), 6, "0");
		String checkuniformcode = "EMSPH" + newSoNo;
		dr.setUniformproductcode(checkuniformcode);
		System.out.print("Set Uniform" + checkuniformcode);
		Integer drugid = drugRepository.save(dr).getId();
		updateid = drugid;
		updateuniformcode = checkuniformcode;
		updatebrandname = dr.getBrandname();
		System.out.println("  " + updateid + "  " + updateuniformcode + "  " + updatebrandname);
	
		


		// skucode generate saravanan
		 String groupid = String.format("%02d", dr.getGroupid());
		 
		  String subgroupid = String.format("%02d", dr.getSubgroupid1());
		  Integer skuauto = drugRepository.skuauto(dr.getCompanyid(), dr.getBranchid(), dr.getLocname(), dr.getLocrefid(),
		    dr.getGroupid(), dr.getSubgroupid1());
		  String SKUcode = String.format("%04d", (skuauto + 1));
		  String SKU = "SKU" + groupid + subgroupid + SKUcode;
		  System.out.println("SKU___________ " + SKU);
		  dr.setSkucode(SKU);
		  
		  drugRepository.save(dr);
			return dr;
		
	     //
	}
		


	@Transactional
	public void saveInsurance(List<Insurance> insObj) throws Exception {
		// try {
		int comid = companyId;
		int brid = branchId;
		int locname = locName;
		int lrefID = locRefID;
		Integer did = drugRepository.maxInsurence(comid, brid, locname, lrefID);
		for (int i = 0; i < insObj.size(); i++) {
			Insurance io = insObj.get(i);
			int id = io.getId();
			String insuQuery = "INSERT INTO medc_productmaster.medc_insurancepdt (DrugProductRefID, InsRefID) VALUES ( ? , ?) ";
			query = em.createNativeQuery(insuQuery);
			query.setParameter(1, did);
			query.setParameter(2, id);
			query.executeUpdate();
		}
		// } catch (Exception e) {
		// logger.error("Exception in Method: saveInsurance : " + e);
		//
		// } finally {
		// session.invalidate();
		// }
	}

	/********* Drug Master View **************/
	// Boopalan 040619
	public Page viewDrugmasters(Integer id, Integer pageno, Integer size) throws Exception {
		// Page page = null;
		// try {
		Pageable paging = PageRequest.of(pageno, size);
		Page page = drugRepository.viewDrugmasters(id, paging);
		// } catch (Exception ex) {
		// logger.error("Exception in Method : viewDrugmasters : " + ex);
		// }
		return page;
	}

	public List viewDrugmastersAll(Integer cid) throws Exception {
		// List list = null;
		// try {
		// list = drugRepository.viewDrugmastersAll(cid, bid, lname, lrefid);
		/// } catch (Exception ex) {
		// logger.error("Exception In Method : getDrugedit : " + ex);
		// }
		return drugRepository.viewDrugmastersAll(cid);
	}

	public List viewSearchDrugmastersAll(Integer cid, String svalue) throws Exception {
		return drugRepository.viewSearchDrugmastersAll(cid, svalue);
	}

	public List viewCombGenericAll(Integer drugid) {
		List list = null;
		try {
			list = drugRepository.viewCombGenericAll(drugid);
		} catch (Exception ex) {
			logger.error("Exception In Method : getDrugedit : " + ex);
		}
		return list;
	}

	/********* Drug Product Search **************/
	// Puthiran 261219
	public Page searchdrugitem(Integer id, Integer searchindex, String searchvalue, Integer pageno, Integer size)
			throws Exception {
		Page page = null;

		if (searchindex == 1) {

			try {
				Pageable paging = PageRequest.of(pageno, size);
				page = drugRepository.searchdrugproduct(id, searchvalue, paging);
			} catch (Exception ex) {
				logger.error("Exception in Method : viewDrugmasters : " + ex);
				throw new Exception(ex);
			}

		}

		else if (searchindex == 2) {

			try {
				Pageable paging = PageRequest.of(pageno, size);
				page = drugRepository.searchdruggeneric(id, searchvalue, paging);
			} catch (Exception ex) {
				logger.error("Exception in Method : viewDrugmasters : " + ex);
				throw new Exception(ex);

			}

		}
		return page;

	}

	/********* Edit Record **************/ // Boopalan 170419
	public List getDrugedit(Integer id) throws Exception {
		// List list = null;
		// try {
		// list = drugRepository.drugEditvalues(id);
		// } catch (Exception ex) {
		// logger.error("Exception In Method : getDrugedit : " + ex);
		// }
		return drugRepository.drugEditvalues(id);
	}

	public Drug CustProductsID(Integer id) {
		return drugRepository.findById(id).get();
	}

	// Boopalan 300419
	public List geteditDistributorChannel(Integer id) throws Exception {
		// List list = null;
		// try {
		// list = drugRepository.geteditDistributorChannel(id);
		// } catch (Exception ex) {
		// logger.error("Exception In Method : getDrugedit : " + ex);
		// }
		return drugRepository.geteditDistributorChannel(id);
	}

	public List geteditFormulation(int id) throws Exception {
		return drugRepository.geteditFormulation(id);
	}

	public List editSchedule(int id) throws Exception {
		return drugRepository.editSchedule(id);
	}

	public List geteditManufacture(int id) throws Exception {
		return drugRepository.geteditManufacture(id);
	}

	public List editVat(int id) throws Exception {
		return drugRepository.editVat(id);
	}

	public List editGst(int id) throws Exception {
		return drugRepository.editGst(id);
	}

	public List editSgst(int id) throws Exception {
		return drugRepository.editSgst(id);
	}

	public List editCgst(int id) throws Exception {
		return drugRepository.editCgst(id);
	}

	public List editIgst(int id) throws Exception {
		return drugRepository.editIgst(id);
	}

	public List geteditInsurance(int id) throws Exception {
		return drugRepository.geteditInsurance(id);
	}

	/********* Update Record **************/
	@Transactional
	public Drug updateRecord(Drug dr) throws Exception {
		// boolean drugFlag = false;
		// try {
		if (!dr.equals("") || !dr.equals(null)) {
			String genericName = drugRepository.getGenericName(dr.getGenericid());
			dr.setGeneric_name(genericName);
			return drugRepository.save(dr);
		}
		// } catch (Exception ex) {
		// logger.error("Exception In Method : updateRecord : " + ex);
		// }
		return null;
	}

	/********* Delete Record **************/
	@Transactional
	public boolean deleteDrugdetails(int id) throws Exception {
		// try {
		drugRepository.deleteDruginfo(id);
		return true;
		// } catch (Exception ex) {
		// logger.error("Exception In Method : deleteDrugdetails : " + ex);
		// return false;
		// }
	}

	public List getATCode(Integer id) throws Exception {
		// List list = null;
		// try {
		// list = drugRepository.getATC(id);
		// } catch (Exception e) {
		// logger.error("Exception In Method : getATCode : " + e);
		// }
		return drugRepository.getATC(id);
	}

	@Transactional
	public Integer saveGenCombo(List<GenericCombination> genericcombo) throws Exception {
		int reFlag = 0;
		// try {
		Integer cid = drugRepository.maxComID();
		if (cid == null) {
			cid = 1;
		}
		for (int i = 0; i < genericcombo.size(); i++) {
			GenericCombination io = genericcombo.get(i);
			String insuQuery = "INSERT INTO medc_productmaster.medc_newcombinationtest (CombinationID, GenericID , Dosage, UOM) VALUES ( ? , ? ,? , ?)";
			query = em.createNativeQuery(insuQuery);
			query.setParameter(1, cid);
			query.setParameter(2, io.getGenericid());
			query.setParameter(3, io.getDosage());
			query.setParameter(4, io.getUom());
			int flag = query.executeUpdate();
			if (flag == 1) {
				reFlag = cid;
			}
		}
		// } catch (Exception e) {
		// logger.error("Exception In Method : saveGenCombo : " + e);
		// }
		return reFlag;
	}

	/***** Upload Files ****/
	@Transactional
	public String store(MultipartFile file) {
		int comid = companyId;
		int brid = branchId;
		int locname = locName;
		int lrefID = locRefID;
		String filepath = "Undefined Path";
		Integer productId = drugRepository.maxInsurence(comid, brid, locname, lrefID);
		try {
			String filename = updateuniformcode + "_" + updatebrandname + ".png";
			File UPLOADED_FOLDER = new File("//home//medeilpos//Desktop//images//drugimages//" + filename);
			UPLOADED_FOLDER.getParentFile().mkdirs();
			if (file.isEmpty()) {
				return filepath;
			}
			byte[] bytes = file.getBytes();
			Path path = Paths.get(UPLOADED_FOLDER.toString());
			Files.write(path, bytes);
			System.out.println(path.toString());
			filepath = path.toString();
			System.out.println("file path" + filepath);
			drugRepository.uploadDrugImagePath(filepath, updateid, filename);
			System.out.println("::::::::UpdateId" + updateid);

		} catch (Exception e) {
			// TODO: handle exception
		}
		return filepath;
	}
	
	public void storemultiphotos(MultipartFile[] file, Drug drug) throws Exception {
		try {
			int comid = drug.getCompanyid();
			int brid = drug.getBranchid();
			int locname = drug.getLocname();
			int lrefID = drug.getLocrefid();
			Integer productId = drugRepository.maxInsurence(comid, brid, locname, lrefID);
			int proId = productId;
			String pid = productId.toString() + "_";
			
			for (MultipartFile uploadedFile : file) {
				String insuQuery = "INSERT INTO medc_productmaster.medc_custprdphoto (DrugProductRefID, PhotoName) VALUES ( ? , ?)";
				query = em.createNativeQuery(insuQuery);
				query.setParameter(1, proId);
				query.setParameter(2, uploadedFile.getOriginalFilename());
				query.executeUpdate();
				if (!Files.exists(rootLocation)) {
					try {
						Files.createDirectories(rootLocation);
						Files.copy(uploadedFile.getInputStream(),
								this.rootLocation.resolve(pid.concat(uploadedFile.getOriginalFilename()).trim()));
					} catch (Exception e) {
						System.out.println("Exception in Create directories : " + e);
						logger.error("Exception in Create Directories : " + e);
						e.printStackTrace();
						throw new Exception(e);
					}
				} else {
					Files.copy(uploadedFile.getInputStream(),
							this.rootLocation.resolve(pid.concat(uploadedFile.getOriginalFilename()).trim()));
				}
			}
		} catch (Exception e) {
			logger.error("Exception in Method : store-->File Upload : " + e);
			// throw new RuntimeException("FAIL!");
			throw new Exception(e);
		}
	}


	/*************************************************************/
	@Transactional
	public void storeModify(MultipartFile[] file, Integer id) throws Exception {
		try {
			int proId = id;
			String pid = id.toString() + "_";
			for (MultipartFile uploadedFile : file) {
				String insuQuery = "INSERT INTO medc_productmaster.medc_custprdphoto (DrugProductRefID, PhotoName) VALUES ( ? , ?)";
				query = em.createNativeQuery(insuQuery);
				query.setParameter(1, proId);
				query.setParameter(2, uploadedFile.getOriginalFilename());
				query.executeUpdate();
				if (!Files.exists(rootLocation)) {
					try {
						Files.createDirectories(rootLocation);
						Files.copy(uploadedFile.getInputStream(),
								this.rootLocation.resolve(pid.concat(uploadedFile.getOriginalFilename()).trim()));
					} catch (Exception e) {
						logger.error("Exception in Create Directories : " + e);
						throw new Exception(e);
					}
				} else {
					Files.copy(uploadedFile.getInputStream(),
							this.rootLocation.resolve(pid.concat(uploadedFile.getOriginalFilename()).trim()));
				}
			}
		} catch (Exception e) {
			logger.error("Exception in Method : storeModify-->File Upload : " + e);
			// throw new RuntimeException("FAIL!");
			throw new Exception(e);
		}
	}

	/***** Get UploadedFiles ****/

	public Map<String, String> getuploadedImage(String id) throws Exception {
		Map<String, String> jsonMap = new HashMap<>();
		List fileName = null;
		// try {
		String reqId = id + "_";
		fileName = drugRepository.getFilename(id);
		for (int i = 0; i < fileName.size(); i++) {
			File file = new File(rootLocation + "/" + reqId.concat((String) fileName.get(i)));
			String encodeImage = Base64.getEncoder().withoutPadding().encodeToString(Files.readAllBytes(file.toPath()));
			jsonMap.put("content", encodeImage);
		}
		// } catch (Exception e) {
		// logger.error("Exception in Method: getImage : " + e);
		// }
		return jsonMap;
	}

	public List geteditGeneric(Integer id) throws Exception {
		return drugRepository.geteditGeneric(id);
	}

	/********* EDIT GENERIC ID **************/ // Boopalan 170419
	public List geteditGenericid(Integer drugid) throws Exception {
		return drugRepository.geteditGenericid(drugid);
	}

	public List getEMPSHAutoIncrements(Integer cid, Integer bid, Integer locname, Integer locrefid) throws Exception {
		// List val = null;
		// try {
		String value = "CALL medil.pro_empsh_AutoIncrement(?, ?, ?, ?, ?)";
		query = em.createNativeQuery(value);
		query.setParameter(1, "EMSPHNUMBER");
		query.setParameter(2, cid);
		query.setParameter(3, bid);
		query.setParameter(4, locname);
		query.setParameter(5, locrefid);
		// val = query.getResultList();
//		} catch (Exception e) {
		// logger.error("Exception in Method : getEMPSHAutoIncrements() " + e);
		// }
		return query.getResultList();
	}

	/**** EDIT MAIN GROUP ****/ // Boopalan 190419
	public List getEdtMain(Integer value) throws Exception {
		return drugRepository.getEdtMain(value);
	}

	/**** EDIT MAIN GROUP ****/ // Boopalan 190419
	public List subgroup1(Integer value) throws Exception {
		return drugRepository.subgroup1(value);
	}

	/**** EDIT MAIN GROUP ****/ // Boopalan 190419
	public List subgroup2(Integer value) throws Exception {
		return drugRepository.subgroup2(value);
	}

	// Boopalan 071119
	public boolean updateimgRecord(Drug drug) throws Exception {
		boolean drugFlag = false;
		// try {
		if (!drug.equals("") || !drug.equals(null)) {
			updateid = drug.getId();
			updateuniformcode = drug.getUniformproductcode();
			updatebrandname = drug.getBrandname();
			drugFlag = true;
		}

		// } catch (Exception ex) {
		// logger.error("Exception In Method : updateRecord : " + ex);
		// }

		return drugFlag;

	}

	public String updateDrugImage(MultipartFile file, Drug imagedrug) throws Exception {
		String filepath = "Undefined Path";
		String filename = updateuniformcode + "_" + updatebrandname + ".png";
		File UPLOADED_FOLDER = new File("//home//medeilpos//Desktop//images//drugimages//" + filename);
		UPLOADED_FOLDER.getParentFile().mkdirs();
		if (file.isEmpty()) {
			return filepath;
		}

		try {
			byte[] bytes = file.getBytes();
			Path path = Paths.get(UPLOADED_FOLDER.toString());
			Files.write(path, bytes);
			System.out.println(path.toString());
			filepath = path.toString();
			System.out.println("file path" + filepath);
			drugRepository.uploadDrugImagePath(filepath, updateid, filename);
			System.out.println("::::::::UpdateId" + updateid);
		} catch (IOException e) {
			throw new Exception(e);
		}

		return filepath;

	}

	public boolean updatevanustonimgRecord(Drug drug) throws Exception {
		boolean drugFlag = false;
		// try {
		if (!drug.equals("") || !drug.equals(null)) {
			updateid = drug.getId();
			updateuniformcode = drug.getUniformproductcode();
			updatebrandname = drug.getBrandname();
			drugFlag = true;
		}

		// } catch (Exception ex) {
		// logger.error("Exception In Method : updateRecord : " + ex);
		// }

		return drugFlag;

	}

	public String VanustonUpdateDrugImage(MultipartFile file, Drug imagedrug) throws Exception {
		String filepath = "Undefined Path";
		String filename = updateuniformcode + "_" + updatebrandname + ".png";
		System.out.println("::::::::::::::::::::::::StingUpdate" + filename);
		File UPLOADED_FOLDER = new File("//home//medeilpos//Desktop//images//drugimages//" + filename);
		UPLOADED_FOLDER.getParentFile().mkdirs();

		if (file.isEmpty()) {
			return filepath;
		}

		try {
			System.out.println("Pass try");

			byte[] bytes = file.getBytes();

			Path path = Paths.get(UPLOADED_FOLDER.toString());
			Files.write(path, bytes);
			System.out.println(path.toString());
			filepath = path.toString();
			System.out.println("file path" + filepath);
			drugRepository.VanustonDrugImagePath(filepath, updateid, filename);
			System.out.println("::::::::UpdateId" + updateid);
		} catch (IOException e) {
			// e.printStackTrace();
			throw new Exception(e);
		}

		return filepath;

	}

	// just not in use
	public String uploadDrugImage(MultipartFile file, Drug imagedrug) throws Exception {
//		System.out.println("uploadDrugImage Service");
//		System.out.println(imagedrug.getId());
//		String filepath = "Undefined Path";
//		String filename = imagedrug.getUniformproductcode() + "_" + imagedrug.getBrandname() + ".png";
//		File UPLOADED_FOLDER = new File("//home//medeilpos//Desktop//images//drugimages//" + filename);
//		UPLOADED_FOLDER.getParentFile().mkdirs();
//
//		if (file.isEmpty()) {
//			return filepath;
//		}
//
//		// try {
//		System.out.println("Pass try");
//
//		byte[] bytes = file.getBytes();
//
//		Path path = Paths.get(UPLOADED_FOLDER.toString());
//		Files.write(path, bytes);
//		System.out.println(path.toString());
//		filepath = path.toString();
//		System.out.println("file path" + filepath);
//		drugRepository.uploadDrugImagePath(filepath, imagedrug.getId(), filename);
//		// } catch (IOException e) {
//		// e.printStackTrace();
//		// }
//
//		return filepath;

		String filepath = "Undefined Path";

		String filename1 = file.getOriginalFilename();
		String filename = updateuniformcode + "_" + updatebrandname + ".png";
		File UPLOADED_FOLDER = new File("\\home\\medeilpos\\Desktop\\images\\drugimages\\" + filename1);

		// C:\\demo\\javaprogram.txt

		UPLOADED_FOLDER.getParentFile().mkdirs();
		if (file.isEmpty()) {
			return filepath;
		}

		// try {
		System.out.println("Pass try");

		try {
			byte[] bytes = file.getBytes();
			Path path = Paths.get(UPLOADED_FOLDER.getPath());
			Files.write(path, bytes);
			System.out.println(path.toString());
			filepath = path.toString();
			System.out.println("file path" + filepath);
			drugRepository.uploadDrugImagePath(filepath, updateid, filename);
			System.out.println("::::::::UploadId" + updateid);
		} catch (IOException e) {
			throw new Exception(e);
		}

		return filepath;

	}

	// Puthiran vanuston drugs get
	public List VanustonProducts(Integer countryid, String searchvalue) throws Exception {
		// try {

		return drugRepository.VanustonProducts(countryid, searchvalue);
		// } catch (Exception e) {
		// e.printStackTrace();
		// }
		// return null;
	}

	public VanustonProductMaster VanustonProductsID(Integer id) throws Exception {
		return VanustonProductMasterRepository.findByProductdrugid(id);
	}

	public List getSubstituteDrug(int generic, int formulation, String dosage, int cid, int bid, int locname,
			int locrefid) throws Exception {
		List val = null;
		// try {
		String value = "CALL medc_productmaster.medc_pro_substitute_drugs(?, ?, ?, ?, ?,?,?)";
		query = em.createNativeQuery(value);

		query.setParameter(1, cid);
		query.setParameter(2, bid);
		query.setParameter(3, locname);
		query.setParameter(4, locrefid);
		query.setParameter(5, formulation);
		query.setParameter(6, generic);
		query.setParameter(7, dosage);
		val = query.getResultList();
		// } catch (Exception e) {
		// logger.error("Exception in Method : getSubstituteDrug() " + e);
		// }
		return val;
	}

	public List<Object[]> getSubstituteDrugDetails(int drugid) throws Exception {
		return drugRepository.getSubstituteDrugDetails(drugid);
	}

	public List getbandrug(Integer countryid, Integer bannedstatus) throws Exception {
		return drugRepository.getbanneddrug(countryid, bannedstatus);
	}

	/****** Vanuston Create Record ******/
	@Transactional
	public VanustonProductMaster VanustonCreateRecord(VanustonProductMaster dr) throws Exception {

		boolean drugFlag = false;
		// try {
		if (!dr.equals("") || !dr.equals(null)) {
			String genericName = drugRepository.getGenericName(dr.getGenericid());
			dr.setGeneric_name(genericName);
			String oldSON = drugRepository.UniformProductCode();
			String oldInco = oldSON.substring(oldSON.length() - 6, oldSON.length());
			Long newInco = Long.parseLong(oldInco) + 1;
			String newSoNo = StringUtils.leftPad(newInco.toString(), 6, "0");
			String checkuniformcode = "VANPM" + newSoNo;

			dr.setUniformproductcode(checkuniformcode);
			return VanustonProductMasterRepository.save(dr);

		}
		// } catch (Exception ex) {
		// logger.error("Exception In Method : createRecord : " + ex);
		// }
		return null;

	}

	/********* Edit Record **************/ // Boopalan 170419
	public List getDrugedit1(Integer id) throws Exception {
		// List list = null;
		// try {
		// list = VanustonProductMasterRepository.drugEditvalues(id);
		// } catch (Exception ex) {
		// logger.error("Exception In Method : getDrugedit : " + ex);
		// }
		return VanustonProductMasterRepository.drugEditvalues(id);
	}

	// Boopalan 071119
	public String vanustonDploadDrugImage(MultipartFile file, VanustonProductMaster imagedrug) throws Exception {
		System.out.println("uploadDrugImage Service");
		System.out.println(imagedrug.getProductdrugid());
		String filepath = "Undefined Path";
		String filename = "IMG_" + imagedrug.getBrandname() + ".png";
		File UPLOADED_FOLDER = new File("//home//medeilpos//Desktop//images//drugimages//" + filename);
		UPLOADED_FOLDER.getParentFile().mkdirs();

		if (file.isEmpty()) {
			return filepath;
		}

		try {
			System.out.println("Pass try");

			byte[] bytes = file.getBytes();

			Path path = Paths.get(UPLOADED_FOLDER.toString());
			Files.write(path, bytes);
			System.out.println(path.toString());
			filepath = path.toString();
			System.out.println("file path" + filepath);
			VanustonProductMasterRepository.uploadDrugImagePath(filepath, imagedrug.getProductdrugid(), filename);
		} catch (IOException e) {
			// e.printStackTrace();
			throw new Exception(e);
		}

		return filepath;
	}// Boopalan 071119

	/********* Update Record **************/
	@Transactional
	public VanustonProductMaster vanustonUpdateRecord(VanustonProductMaster dr) throws Exception {
		boolean drugFlag = false;
		// try {
		if (!dr.equals("") || !dr.equals(null)) {
			System.out.println("genericName");
			String genericName = drugRepository.getGenericName(dr.getGenericid());
			System.out.println(genericName);
			dr.setGeneric_name(genericName);

			return VanustonProductMasterRepository.save(dr);
		}
		// } catch (Exception ex) {
		// logger.error("Exception In Method : updateRecord : " + ex);
		// }
		return null;
	}

	/******** View Record **************/ // Boopalan 170419
	public List viewVanustonDrugmasters() throws Exception {
		// List list = null;
		// try {
		// list = VanustonProductMasterRepository.viewVanustonDrugmasters();
		// } catch (Exception ex) {
		// logger.error("Exception In Method : getDrugedit : " + ex);
		// }
		return VanustonProductMasterRepository.viewVanustonDrugmasters();
	}

	/********* Delete Vanuston Record **************/
	@Transactional
	public boolean vanustonDeleteDrugdetails(int id) throws Exception {
		// try {
		VanustonProductMasterRepository.deleteDruginfo(id);
		return true;
		// } catch (Exception ex) {
		// logger.error("Exception In Method : deleteDrugdetails : " + ex);
		// return false;
		// }
	}

	public List vanustonVerticalID(int id) throws Exception {
		return VanustonProductMasterRepository.vanustonVerticalID(id);
	}

	public List GetTaxCountryWise(int id) throws Exception {
		return VanustonProductMasterRepository.GetTaxCountryWise(id);
	}

	public VanustonVerticals vanustonSaveVerticalID(VanustonVerticals vanustonVerticals) throws Exception {
		return vanustonVerticalsRepository.save(vanustonVerticals);
	}

	public List<VanustonProductMaster> searchProductInVanustonProductMaster(String productname) throws Exception {
		System.out.println("======================>>" + productname);
		return VanustonProductMasterRepository.findAllByBrandnameStartingWith(productname);
	}

	public boolean importProductFromVanustonToCustomer(Drug drug) throws Exception {
		boolean result = drugRepository
				.existsByBrandnameAndGenericnamedosageAndCompanyidAndBranchidAndLocnameAndLocrefid(drug.getBrandname(),
						drug.getGenericnamedosage(), drug.getCompanyid(), drug.getBranchid(), drug.getLocname(),
						drug.getLocrefid());
		System.out.print("results:" + result + ":::" + drug.getCompanyid() + ":::" + drug.getBrandname());
		if (result == true) {
			result = false;
		} else {
			drugRepository.save(drug);
			result = true;
		}
		return result;
	}

//	public void moveCustomerDrugToQcProcess() throws Exception {
//
//		// try {
//		String q = "Call medc_productmaster.medc_moveqcdrugs()";
//		query = em.createNativeQuery(q);
//		query.getResultList();
//
//		// } catch (Exception e) {
//		// }
//	}

//	public List<QcProductMaster> viewQcDrugBeforeProcessing() throws Exception {
//		return qcProductMasterRepository.findAllByQaflag(0);
//	}

//	public boolean updateQcDrugAfterProcessing(List<QcProductMaster> qcProductMaster) throws Exception {
//		// try {
//		qcProductMasterRepository.saveAll(qcProductMaster);
//		return true;
//		// } catch (Exception e) {
//
//		// e.printStackTrace();
//		// return false;
//		// }
//
//	}

//	public boolean saveQADrugAfterProcessingOfQC(QaProductMaster qaProductMaster) throws Exception {
//		// try {
//		qaProductMasterRepository.save(qaProductMaster);
//		return true;
//		// } catch (Exception e) {
//		// e.printStackTrace();
//		// return false;
//		// }
//	}

//	public boolean approveQaProcess(QaProductMaster qaProductMaster) throws Exception {
//		// try {
//		qaProductMasterRepository.save(qaProductMaster);
//		return true;
//		// } catch (Exception e) {
//		// e.printStackTrace();
//		// return false;
//		// }
//	}

	public List viewProductNames(IndCompModel loc) throws Exception {
		// List drugname = null;
		// try {
		return drugRepository.viewGenericNames(loc.getCountryrefid(), loc.getSearchvalue());
		// } catch (Exception ed) {

		// logger.error("Exception in (viewProductNames)Method : viewProductNames() " +
		// ed);
		// }
		// return drugname;
	}

	public List getproddata(Integer genericid, Integer countryid) throws Exception {
		System.out.println("Desing Service");
		return drugRepository.productdata(genericid, countryid);
	}

	public boolean banned(Integer genericid, Integer countryid, String bannedfrom, String reason) throws Exception {

		boolean flag = false;
		System.out.println("");

		// try {

		drugRepository.updatebanneddrug(genericid, countryid, bannedfrom, reason);

		return flag = true;

		// } catch (Exception e) {
		// logger.error("Exception in Method : banned() " + e);
		// e.printStackTrace();
		// }

		// return flag;

	}

	public List getbangendata(Integer countryid) throws Exception {
		return drugRepository.viewbangen(countryid);
	}

	public List searchmanufacture(Integer compid, Integer branchid, Integer locname, Integer locrefid,
			String searchkey) {
		return drugRepository.searchmanufacture(compid, branchid, locname, locrefid, searchkey);
	}
}
