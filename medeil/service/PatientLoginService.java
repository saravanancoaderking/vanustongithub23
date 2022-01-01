package com.medeil.service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.zip.Deflater;
import java.util.zip.Inflater;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.servlet.http.HttpSession;
import javax.transaction.Transactional;
import javax.xml.bind.DatatypeConverter;

import org.apache.commons.io.output.ByteArrayOutputStream;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;

import com.medeil.domain.CustomerDelivery;
import com.medeil.domain.Customerotp;
import com.medeil.domain.Customerpayment;
import com.medeil.domain.Customerpaymetstatus;
import com.medeil.domain.Diractcustomer;
import com.medeil.domain.Edition;
import com.medeil.domain.PaitentSalesorderRecord;
import com.medeil.domain.Patient;
import com.medeil.domain.PatientLogin;
import com.medeil.domain.PatientLoginProduct;
import com.medeil.domain.PatientLoginSalesorder;
import com.medeil.domain.PatientLoginSalesorderLead;
import com.medeil.domain.Patientdetail;
import com.medeil.domain.Paymentlink;
import com.medeil.domain.Paymentlinkres;
import com.medeil.domain.Performaprd;
import com.medeil.domain.Performinvoice;
import com.medeil.domain.Role;
import com.medeil.domain.User;
import com.medeil.domain.UserModule;
import com.medeil.domain.Userlogin;
import com.medeil.domain.Usersubmodule;
import com.medeil.repository.CustomerdeliveryRepositoy;
import com.medeil.repository.CustomerotpRepository;
import com.medeil.repository.CustomerpaymentsRepository;
import com.medeil.repository.DiractcustomerRepository;
import com.medeil.repository.EditionRepository;
import com.medeil.repository.PatientLoginProductrepostitory;
import com.medeil.repository.PatientLoginRepository;
import com.medeil.repository.PatientLoginSalesorderLeadRepository;
import com.medeil.repository.PatientLoginSalesorderRepository;
import com.medeil.repository.PatientRepository;
import com.medeil.repository.Performainvoicerepository;
import com.medeil.repository.Performaproductrepository;
import com.medeil.repository.PlanRepository;
import com.medeil.repository.RoleRepository;
import com.medeil.repository.UserModuleRepository;
import com.medeil.repository.UserRepository;
import com.medeil.repository.UserloginRepository;
import com.medeil.repository.UsersubmoduleRepository;
import com.medeil.repository.patientLoginSalesinvoice;
import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;

@SuppressWarnings("rawtypes")
@Service
public class PatientLoginService {
	@Autowired
	private PatientLoginRepository patientLoginRepository;
	@Autowired
	private PatientLoginProductrepostitory patientLoginProductrepostitory;
	@Autowired
	private PatientLoginSalesorderRepository patientLoginSalesorderRepository;
	@Autowired
	private PatientLoginSalesorderLeadRepository patientLoginSalesorderLeadRepository;
	@Autowired
	private DiractcustomerRepository diractcustomerRepository;
	@Autowired
	CustomerdeliveryRepositoy customerdeliveryRepositoy;
	@Autowired
	private patientLoginSalesinvoice pSalesinvoice;
	@Autowired
	private CustomerpaymentsRepository customerpaymentsRepository;
	@Autowired
	private PatientRepository patientRepository;
	@Autowired
	private Performainvoicerepository paitentProformainvoice;
	@Autowired
	private RoleRepository roleRepository;
	@Autowired
	private EditionRepository editionRepository;
	@Autowired
	private PlanRepository planRepository;
	@Autowired
	private UserloginRepository userloginrepository;
	@Autowired
	private CustomerotpRepository customerotpRepository;
	@Autowired
	private UserModuleRepository userModuleRepository;
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private UsersubmoduleRepository usersubmoduleRepository;
	@Autowired
	private Performaproductrepository paitentProformaproduct;
	@Autowired
	private HttpSession session;
	@Autowired
	private PasswordEncoder passwordEncoder;

	/******* Encrypting Password *******/
	@Bean
	public PasswordEncoder passwordEncode() {
		return new BCryptPasswordEncoder();
	}

	@PersistenceContext
	EntityManager em;
	Query query;
	private static Logger logger = (Logger) LogManager.getLogger();
	static PatientLogin prescrecord;
	static String medc_salesordertrack_statusdate;// Boopalan 210919

	public boolean createPrescriptionRecord(PatientLogin presc) throws Exception {
		// try {
		List empcode = this.getAutoincrement(presc.getCompanyrefid(), presc.getBranchrefid(), presc.getLocname(),
				presc.getLocrefid(), presc.getPatient_id());
		String str = (String) empcode.get(0);
		presc.setPresc_no(str);
		patientLoginRepository.save(presc);
		return true;
		// } catch (Exception cause)
		// {
		// System.out.println(cause);
		// }

		// return false;
	}

	// Boopalan 071119
	@Transactional
	public List getAutoincrement(int compid, int branchid, int locname, int locrefid, int patient_id) throws Exception {
		List ls = null;
		String a1 = "manualprescription";

		try {
			String q = "Call medc_prescription.pro_manualprescriptionautoincrement(?,?,?,?,?,?)";
			query = em.createNativeQuery(q);
			query.setParameter(1, a1);
			query.setParameter(2, compid);
			query.setParameter(3, branchid);
			query.setParameter(4, locname);
			query.setParameter(5, locrefid);
			query.setParameter(6, patient_id);
			ls = query.getResultList();
			System.out.println("SutoIncrement  :" + ls);
		} catch (Exception e) {
			System.out.println("getAutoincrements  :" + e);
			throw new Exception(e);
		}

		return ls;
	}

	public boolean saveprescprod(List<PatientLoginProduct> prescprod) throws Exception {
		// try {
		for (PatientLoginProduct temp : prescprod) {
			int prefid = patientLoginProductrepostitory.prefid(temp.getCompanyrefid(), temp.getBranchrefid(),
					temp.getLocname(), temp.getLocrefid(), temp.getPatient_id());
			temp.setPrescriptionrefid(prefid);
			patientLoginProductrepostitory.save(temp);
		}
		return true;
		// } catch (Exception cause) {
		// logger.error("Exception in (Prescproduct)methode : saveprescproduct()" +
		// cause);

		// }
		// return false;

	}

	public String saveprescriptionimage(MultipartFile file) throws Exception {
		String filepath = "Undefined Path";
		// Save the uploaded file to this folder
		String UPLOADED_FOLDER = "E://git//medeil//MedeilBoot//PrescriptionImage//";
		if (file.isEmpty()) {
			return filepath;
		}

		try {

			// Get the file and save it somewhere
			byte[] bytes = file.getBytes();
			Path path = Paths
					.get(UPLOADED_FOLDER + prescrecord.getLocrefid() + "_" + prescrecord.getPresc_no() + ".png");
			Files.write(path, bytes);
			System.out.println(path.toString());
			filepath = path.toString();

			patientLoginRepository.prescriptionpath(filepath, prescrecord.getCompanyrefid(),
					prescrecord.getBranchrefid(), prescrecord.getLocname(), prescrecord.getLocrefid(),
					prescrecord.getPresc_no());
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e);
		}

		return filepath;
	}

	public List viewpresc(Integer comid, Integer branchid, Integer locname, Integer locrefid, Integer patient_id)
			throws Exception {
		return patientLoginRepository.viewprescdetails(comid, branchid, locname, locrefid, patient_id);
	}

	public Boolean createSalesOrder(PatientLoginSalesorder salesorder) throws Exception {
		boolean flag = false;
		System.out.println("salesorder no");
		salesorder.setSalesorderno(getAutoIncrement(salesorder.getCompanyrefid(), salesorder.getBranchrefid(),
				salesorder.getLocrefid(), salesorder.getLocname(), salesorder.getPatientid()).get(0).toString());
		System.out
				.println("cbl" + salesorder.getCompanyrefid() + salesorder.getBranchrefid() + salesorder.getLocrefid());
		System.out.println("salesorder no" + salesorder.getSalesorderno());
		if (!salesorder.equals("") || !salesorder.equals(null)) {
			session.setAttribute("comp", salesorder.getCompanyrefid());
			session.setAttribute("branch", salesorder.getBranchrefid());
			session.setAttribute("lcrefid", salesorder.getLocrefid());
			session.setAttribute("lcname", salesorder.getLocname());
			medc_salesordertrack_statusdate = salesorder.getClientcdate();
			// Boopalan 200919 - For capturing date and time to
			// medc_status.medc_salesordertrack
			patientLoginSalesorderRepository.save(salesorder);
			flag = true;
		} else {
			flag = false;
		}
		return flag;
	}

	public List soleadlist(Integer companyrefid, Integer branchrefid, Integer locrefid, Integer locname,
			Integer paitens) throws Exception {
		return patientLoginSalesorderLeadRepository.soleadlist(companyrefid, branchrefid, locrefid, locname, paitens);
	}

	// get salesorder products
	public List soleadprodlist(Integer salesleadid) throws Exception {
		return patientLoginSalesorderLeadRepository.soleadprodlist(salesleadid);
	}

	public List soleadtypelist(Integer salesleadid) throws Exception {
		return patientLoginSalesorderLeadRepository.soleadtypelist(salesleadid);
	}

	public List soleadpatientlist(Integer salesleadid) throws Exception {
		return patientLoginSalesorderLeadRepository.soleadpatientlist(salesleadid);
	}

	public List soleadrecordlist(Integer salesleadid) throws Exception {
		return patientLoginSalesorderLeadRepository.soleadrecordlist(salesleadid);
	}

	public List getsolproducts(Integer cid, Integer bid, Integer locname, Integer locrefid, Integer soid)
			throws Exception {
		List val = null;
		try {
			String value = "CALL medc_sales.medc_addstocksol(?, ?, ?, ?, ?)";
			query = em.createNativeQuery(value);
			query.setParameter(1, cid);
			query.setParameter(2, bid);
			query.setParameter(3, locname);
			query.setParameter(4, locrefid);
			query.setParameter(5, soid);
			val = query.getResultList();
		} catch (Exception e) {
			logger.error("Exception in Method : getAutoIncrement() " + e);
			throw new Exception(e);
		}
		return val;
	}

	public List fetchsoleadlist(Integer companyrefid, Integer branchrefid, Integer locrefid, Integer locname,
			Integer soid) throws Exception {
		return patientLoginSalesorderLeadRepository.fetchsoleadlist(companyrefid, branchrefid, locrefid, locname, soid);
	}

	public List addsoproduct(Integer companyrefid, Integer branchrefid, Integer locrefid, Integer locname, Integer data)
			throws Exception {
		return patientLoginSalesorderLeadRepository.addsoproduct(companyrefid, data);
	}

	public List stockcheck(Integer companyrefid, Integer branchrefid, Integer locrefid, Integer locname, Integer data)
			throws Exception {
		return patientLoginSalesorderLeadRepository.stockcheck(companyrefid, data);
	}

	public List getAutoIncrement(Integer cid, Integer bid, Integer locrefid, Integer locname, Integer PatientID)
			throws Exception {
		List val = null;
		try {
			String value = "CALL medc_sales.pro_solautoincrement(?, ?, ?, ?, ?,?)";
			query = em.createNativeQuery(value);
			query.setParameter(1, "salesorder");
			query.setParameter(2, cid);
			query.setParameter(3, bid);
			query.setParameter(4, locrefid);
			query.setParameter(5, locname);
			query.setParameter(6, PatientID);
			val = query.getResultList();
		} catch (Exception e) {
			logger.error("Exception in Method : getAutoIncrement() " + e);
			throw new Exception(e);
		}
		return val;
	}

	public List searchProduct(String data, Integer cid, Integer bid, Integer locrefid, Integer locname)
			throws Exception {
		return patientLoginSalesorderRepository.searchProduct(data, cid);
	}

	public List getProductdata(Integer productid) throws Exception {
		return patientLoginSalesorderRepository.getProductdata(productid);
	}

	public List getAll(Integer cid, Integer bid, Integer locrefid, Integer locname, Integer PatientID)
			throws Exception {
		return patientLoginSalesorderRepository.getAll(cid, bid, locrefid, locname, PatientID);
	}

	/** EDIT SALES ORDER */
	public PatientLoginSalesorder editSalesOrder(Integer id) throws Exception {
		return patientLoginSalesorderRepository.findById(id);
	}

	public Boolean updateSalesorderData(PatientLoginSalesorder salesorder) throws Exception {
		boolean flag = false;
		// try {
		if (!salesorder.equals("") || !salesorder.equals(null)) {
			patientLoginSalesorderRepository.save(salesorder);
			flag = true;
		} else {
			flag = false;
		}
		// } catch (Exception e) {
		// logger.error("Exception in Method : updateSalesOrder() " + e);
		// }
		return flag;
	}

	// Kishore 140919
	public List getAllList(int cid, int bid, int locname, int locrefid, int PatientID) throws Exception {
		return patientLoginSalesorderRepository.getAllList(cid, bid, locname, locrefid, PatientID);
	}

	// getcust track details
	public List getCusttrack(Integer cid, Integer bid, Integer locname, Integer locrefid, Integer patientid,
			Integer orderid) throws Exception {

		return patientLoginSalesorderRepository.getCusttrack(cid, bid, locname, locrefid, patientid, orderid);
	}

	public List viewsalesorder(Integer cid, Integer bid, Integer locname, Integer locrefid, Integer patientid,
			Integer orderid) throws Exception {

		return patientLoginSalesorderRepository.viewsalesorder(cid, bid, locname, locrefid, patientid, orderid);
	}

	@Transactional
	public Boolean createSalesOrderRecord(List<PaitentSalesorderRecord> salesorder) throws Exception {
		boolean flag = false;
		try {

			int cid = (Integer) session.getAttribute("comp");
			int bid = (Integer) session.getAttribute("branch");
			int lid = (Integer) session.getAttribute("lcrefid");
			int lname = (Integer) session.getAttribute("lcname");
			Integer maxID = patientLoginSalesorderRepository.getMaID(cid, bid, lid, lname);
			for (int i = 0; i < salesorder.size(); i++) {
				PaitentSalesorderRecord so = salesorder.get(i);
				String value = "CALL medc_sales.medc_salesOrder(? , ? , ? , ? , ? , ? , ? ,? )";
				query = em.createNativeQuery(value);
				query.setParameter(1, maxID);
				query.setParameter(2, so.getDrugproductid());
				query.setParameter(3, so.getBoxqty());
				query.setParameter(4, so.getStripqty());
				query.setParameter(5, so.getTotalqty());
				query.setParameter(6, so.getTotalqty());
				query.setParameter(7, so.getProductimg());
				query.setParameter(8, "save");
				int reVal = query.executeUpdate();
				if (reVal == 1) {
					flag = true;
				} else {
					flag = false;
				}
			}
			patientLoginSalesorderRepository.save_medc_salesordertrack(maxID, 1, medc_salesordertrack_statusdate);
			// Boopalan 200919 - For saving data
			// medc_status.medc_salesordertrack
		} catch (Exception e) {
			System.out.println(e);
			logger.error("Exception in Method : createSalesOrderRecord() " + e);
		} finally {
			session.removeAttribute("comp");
			session.removeAttribute("branch");
			session.removeAttribute("lcrefid");
			session.removeAttribute("lcname");
		}
		return flag;
	}

	public String getsendImage(Integer orderid) throws Exception {
		return patientLoginSalesorderLeadRepository.getsendImage(orderid);
	}

	public List paitentviewSalesInvoice(Integer cid, Integer bid, Integer lname, Integer lrid, Integer csrefid)
			throws Exception {
		return pSalesinvoice.paitentviewSalesInvoice(cid, bid, lname, lrid, csrefid);

	}

	public List paitentdashinvoice(Integer cid, Integer bid, Integer lname, Integer lrid, Integer csrefid)
			throws Exception {
		return pSalesinvoice.paitentdashinvoice(cid, bid, lname, lrid, csrefid);

	}

	public Boolean saveSalesorderlead(PatientLoginSalesorderLead salesorder) throws Exception {
		boolean save;
		if (save = true) {
			// try {
			Integer lastid = patientLoginSalesorderLeadRepository.getId();
			lastid = lastid + 1;
			String solid = "SOL";
			String id = String.format("%07d", lastid);
			String salesorderid = solid + id;
			salesorder.setSalesorderno(salesorderid);
			patientLoginSalesorderLeadRepository.save(salesorder);
			// } catch (Exception e) {
			// // TODO: handle exception
			// }

		} else {
			save = false;
		}
		return save;
	}

	public boolean saveImageFile(MultipartFile file) throws IOException {
		boolean result = true;
		if (result == true) {
			System.out.println("Original Image Byte Size - " + file.getBytes().length);
			patientLoginSalesorderLeadRepository.imageuplaod(file.getOriginalFilename(), file.getContentType(),
					(file.getBytes()));
			result = true;
		} else {

			result = false;
		}
		return result;
	}

	public static byte[] compressBytes(byte[] data) throws Exception {
		Deflater deflater = new Deflater();
		deflater.setInput(data);
		deflater.finish();

		ByteArrayOutputStream outputStream = new ByteArrayOutputStream(data.length);
		byte[] buffer = new byte[1024];
		while (!deflater.finished()) {
			int count = deflater.deflate(buffer);
			outputStream.write(buffer, 0, count);
		}
		// try {
		outputStream.close();
		// } catch (IOException e) {
		// }
		System.out.println("Compressed Image Byte Size - " + outputStream.toByteArray().length);
		return outputStream.toByteArray();
	}

	// uncompress the image bytes before returning it to the angular application
	public static byte[] decompressBytes(byte[] data) throws Exception {
		Inflater inflater = new Inflater();
		inflater.setInput(data);
		ByteArrayOutputStream outputStream = new ByteArrayOutputStream(data.length);
		byte[] buffer = new byte[1024];
		// try {
		while (!inflater.finished()) {
			int count = inflater.inflate(buffer);
			outputStream.write(buffer, 0, count);
		}
		outputStream.close();
		// } catch (IOException ioe) {
		// } catch (DataFormatException e) {
		// }
		return outputStream.toByteArray();
	}

	public List paitentdetails(Integer cid, Integer bid, Integer locname, Integer locrefid, Integer patientid)
			throws Exception {
		return patientRepository.paitentdetails(cid, bid, locname, locrefid, patientid);
	}

	public Map paitentgrandtotal(Integer cid, Integer bid, Integer lname, Integer lrid, Integer csrefid)
			throws Exception {
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("YearTotal", pSalesinvoice.ViewoneYeartotal(cid, bid, lname, lrid, csrefid));
		map.put("MonthTotal", pSalesinvoice.ViewoneMonthtotal(cid, bid, lname, lrid, csrefid));
		map.put("GrandTotal", pSalesinvoice.ViewoneGrandtotal(cid, bid, lname, lrid, csrefid));
		return map;
	}

	// perform Invoice

	public List saveProformainvoice(Performinvoice proformainvoice) throws Exception {
		List Result = new ArrayList<>();

		Boolean save = true;
		String Id = "";
		if (save == true) {
			// try {
			Integer lastid = paitentProformainvoice.getId();
			lastid = lastid + 1;
			String solid = "QIV";
			String id = String.format("%07d", lastid);
			String salesorderid = solid + id;
			proformainvoice.setSalesbillno(salesorderid);
			paitentProformainvoice.save(proformainvoice);
//					for (int i = 0; i < proformainvoice.getPerforminvoice().size(); i++) {
//						paitentProformainvoice.updatesalesorderflag(proformainvoice.getPerforminvoice().get(i).getLocname(),
//								proformainvoice.getPerforminvoice().get(i).getLocrefid(), proformainvoice.getPerforminvoice().get(i).getSalesorderrefid(),
//								proformainvoice.getPerforminvoice().get(i).getDrugproductid());
//					}
			Id = salesorderid;
			Result.add(save);
			Result.add(Id);
			// } catch (Exception e) {
			// // TODO: handle exception
			// }
		} else {
			Result.add("Fasle");
		}
		return Result;
	}

	public boolean saveProformaproduct(List<Performaprd> proformaprd) throws Exception {
		boolean result = true;
		if (result == true) {
			int saveflag = 0;
			Performaprd sdinc = proformaprd.get(0);
			int id = paitentProformaproduct.viewSalesDummyId();
			System.out.println(id);
			for (Performaprd temp : proformaprd) {
				if (temp.getCalcflag() != 1) {
					temp.setSalesrefid(id);
					paitentProformaproduct.save(temp);

				}

			}
			result = true;

		} else {
			result = false;
		}
		return result;
	}

	public List paitentProformainvoiceView(Integer cid, Integer bid, Integer lname, Integer lrid, Integer patientid)
			throws Exception {
		return paitentProformainvoice.paitentviewPerformInvoice(cid, bid, lname, lrid, patientid);
	}

	public List viewperforminvoiceall(Integer cid, Integer bid, Integer lname, Integer lrid) throws Exception {
		return paitentProformainvoice.viewperforminvoiceall(cid, bid, lname, lrid);
	}
	
	public List ProformainvoiceViewProducts(Integer invid) {
		return paitentProformainvoice.ProformainvoiceViewProducts(invid);
	}

	// preinvoice model
	public Map viewperforminvoicemodel(int salesorderid) throws Exception {
		Map<String, Object> PerformInvoicedetails = new HashMap<String, Object>();

		Set perinvoicedetails = paitentProformainvoice.perinvoicedetails(salesorderid);
		PerformInvoicedetails.put("performinvdetails", perinvoicedetails);

		List perinvoiceproducts = paitentProformainvoice.perinvoiceproducts(salesorderid);
		PerformInvoicedetails.put("performinvproducts", perinvoiceproducts);
		return PerformInvoicedetails;
	}

	public List paitentProformaproductView(Integer cid, Integer bid, Integer lname, Integer lrid) throws Exception {

		return paitentProformaproduct.paitentProformaproductView(cid, bid, lname, lrid);
	}

	public ResponseEntity<Boolean> createnewpatientlogin(Patientdetail patientDetails) throws Exception {
		// try {
		boolean email = userloginrepository.existsByUsername(patientDetails.getEmail());
		if (email == true) {
			Userlogin userloginadd = userloginrepository.findByUsername(patientDetails.getEmail());
			userloginadd.setUsername(patientDetails.getEmail());
			userloginadd.setCompanyid(patientDetails.getCompanyrefid());
			userloginadd.setCompanyrefid(patientDetails.getCompanyrefid());
			userloginrepository.save(userloginadd);
			User adduser = userRepository.findByUsername(patientDetails.getEmail());
			adduser.setUsername(patientDetails.getEmail());
			adduser.setCompanyrefid(patientDetails.getCompanyrefid());
			userRepository.save(adduser);
			Patient patient = patientRepository.findByEmail(patientDetails.getEmail());
			patient.setEmail(patientDetails.getEmail());
			patient.setCompanyrefid(patientDetails.getCompanyrefid());
			patient.setBranchrefid(patientDetails.getBranchrefid());
			patient.setLocrefid(patientDetails.getLocrefid());
			patientRepository.save(patient);
			System.out.println("Company id Updated");
			return ResponseEntity.created(null).body(true);

		} else {
			Integer customerid = addCustomerdetails(patientDetails);
			Long freeperiodtime = addFreeperiodtime(patientDetails);
			Integer suserrefid = addUserlogin(patientDetails, freeperiodtime, customerid);
			addUser(patientDetails, suserrefid);
			addModulesubmodule(patientDetails, suserrefid);
			addCustomerdetails(patientDetails);
			sendOtp(patientDetails);
			return ResponseEntity.created(null).body(true);
		}

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

	private void sendOtp(Patientdetail patientDetails) throws Exception {
		Random random = new Random();
		int otp = 100000 + random.nextInt(900000);
		Twilio.init("ACd84b0291a3d0d25dfb3e5cd808cd5d9b", "2a1ce4900e57fb01b612273fba673b66");
		String Messages = "Dear Customer,\n Medil trial customer otp  " + otp + "  valid for 10 Minutes.";
		Message message = Message.creator(new PhoneNumber(patientDetails.getMobile()), // to
				new PhoneNumber("+17169162010"), // from
				Messages).create();
		Customerotp OtpMobiles = new Customerotp();
		OtpMobiles.setMobilenumber(patientDetails.getMobile());
		OtpMobiles.setOtp(otp);
		long expirytime = System.currentTimeMillis() + 600000;
		OtpMobiles.setExpirytime(expirytime);
		OtpMobiles.setIsexpired(false);
		customerotpRepository.save(OtpMobiles);

	}

	private Integer addCustomerdetails(Patientdetail patientDetails) throws Exception {
		Patient patient = new Patient();
		Integer lastid = patientLoginRepository.getId(patientDetails.getCompanyrefid());
		lastid = lastid + 1;
		String custid = "CUST";
		String id = String.format("%07d", lastid);
		String customerid = custid + id;
		String patientno = "PT/SH_" + patientDetails.getLocrefid() + "/";
		String patientid = patientno + id;
		patient.setPatientfirstname(patientDetails.getPatientfirstname());
		patient.setPatientlastname(patientDetails.getPatientlastname());
		patient.setGender(patientDetails.getGender());
		patient.setDob(patientDetails.getDob());
		patient.setAge(patientDetails.getAge());
		patient.setTinno(patientDetails.getTinno());
		patient.setVatno(patientDetails.getVatno());
		patient.setScitizenno(patientDetails.getScitizenno());
		patient.setPhycapno(patientDetails.getPhycapno());
		patient.setAddress1(patientDetails.getAddress1());
		patient.setCountry(patientDetails.getCountry());
		patient.setState(patientDetails.getState());
		patient.setCity(patientDetails.getCity());
		patient.setPincode(patientDetails.getPincode());
		patient.setMobile(patientDetails.getMobile());
		patient.setPhone(patientDetails.getPhone());
		patient.setEmail(patientDetails.getEmail());
		patient.setCompanyrefid(patientDetails.getCompanyrefid());
		patient.setBranchrefid(patientDetails.getBranchrefid());
		patient.setLocname(1.00);
		patient.setLocrefid(patientDetails.getLocrefid());
		patient.setPatientcode(customerid);
		patient.setPatientno(patientid);
		return patientRepository.save(patient).getId();

	}

	private Long addFreeperiodtime(Patientdetail patientdetail) throws Exception {
		String starttime = patientLoginRepository.getdate(patientdetail.getPlanid());
		Integer interval = patientLoginRepository.getinterval(patientdetail.getPlanid());
		Integer days;
		String plandays = patientLoginRepository.getplandays(patientdetail.getPlanid());
		if (plandays.equals("weekly")) {
			days = 7;
		} else if (plandays.equals("monthly")) {
			days = 30;
		} else if (plandays.equals("yearly")) {
			days = 364;
		} else {
			days = 0;
		}
		Integer todaldays = interval * days;
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Calendar c = Calendar.getInstance();
		c.setTime(new Date());
		c.add(Calendar.DATE, todaldays);
		starttime = sdf.format(c.getTime());
		Date date = sdf.parse(starttime);
		return date.getTime();
	}

	private Integer addUserlogin(Patientdetail patientdetail, Long freeperiodtime, Integer customerid)
			throws Exception {
		Userlogin userlogin = new Userlogin();
		String password = RandomStringUtils.randomAlphanumeric(8).toLowerCase();
//		Mail mail = new Mail(new Email("support@vanuston.com"), "Your Register Medeil Trial Customer ",
//				new Email(patientdetail.getEmail()),
//				new Content("text/plain",
//						"Dear Customer your loginto Medeil trial customer ,\r\n" + "\r\n" + "Your Username:" + "    "
//								+ patientdetail.getEmail() + "\r\n" + "\r\n" + " Your Password:" + "    " + password
//								+ "\r\n" + "\r\n" + "Welcome,\r\n" + "Medeil Team."));
//		mail.setReplyTo(new Email("vanuston.info@gmail.com"));
//		mail.from.setName("Medeil");
//		Request request = new Request();
//		// try {
//		request.setMethod(Method.POST);
//		request.setEndpoint("mail/send");
//		request.setBody(mail.build());
//		new SendGrid("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").api(request);
		// } catch (Exception e) {

		// }
		userlogin.setUsername(patientdetail.getEmail());
		String encodedPassword = "{bcrypt}" + passwordEncoder.encode(password);
		userlogin.setPassword(encodedPassword);
		Integer roleid = patientLoginRepository.getroleid(patientdetail.getPlanid());
		Role role = roleRepository.findById(Integer.valueOf(roleid));
		userlogin.setUsertype(role.getRolename());
		userlogin.setIsadmin("0");
		userlogin.setIsactive("0");
		userlogin.setRolerefid(roleid);
		userlogin.setCompanyid(patientdetail.getCompanyrefid());
		userlogin.setCompanyrefid(patientdetail.getCompanyrefid());
		userlogin.setAccountexpiry(freeperiodtime);
		userlogin.setIsaccountnonlocked(true);
		userlogin.setCustomerid(customerid);
		return userloginrepository.save(userlogin).getId();
	}

	private void addUser(Patientdetail patientdetail, Integer suserrefid) throws Exception {
		Edition edition = editionRepository.findById(Integer.valueOf(patientdetail.getEditionid()));
		int roleid = patientLoginRepository.getroleid(patientdetail.getPlanid());
		User user = new User();
		user.setCountryrefid(patientdetail.getCountry());
		user.setProductrefid(Integer.valueOf(edition.getProductid()));
		user.setDomainrefid(Integer.valueOf(edition.getDomainrefid()));
		user.setSubdomainrefid(Integer.valueOf(edition.getSubdomainrefid()));
		user.setCompanyrefid(patientdetail.getCompanyrefid());
		user.setEditionrefid(Long.valueOf(edition.getId()).intValue());
		user.setRolerefid(roleid);
		user.setSuserrefid(Long.valueOf(suserrefid).intValue());
		user.setUsername(patientdetail.getEmail());
		user.setEmailid(patientdetail.getEmail());
		user.setPhoneno(patientdetail.getMobile());
		user.setCustomername(patientdetail.getPatientfirstname());
		long cuserrefid = userRepository.save(user).getId();
		Userlogin userlogin = userloginrepository.findById(Integer.valueOf(suserrefid));
		userlogin.setCuserrefid(Long.valueOf(cuserrefid).intValue());
		userloginrepository.save(userlogin);
	}

	private void addModulesubmodule(Patientdetail patientdetail, Integer suserrefid) throws Exception {
		int roleid = patientLoginRepository.getroleid(patientdetail.getPlanid());
		int editionid = patientLoginRepository.geteditionid(patientdetail.getPlanid());
		List<?> getmodulelist = patientLoginRepository.getmodulelist(roleid);
		getmodulelist.forEach(p -> {
			UserModule module = new UserModule();
			module.setModuleid((Integer) p);
			module.setSuserrefid(suserrefid);
			module.setEditionid(editionid);
			userModuleRepository.save(module);
		});
		List<?> getsubmoduleref = patientLoginRepository.getsubmoduleref(roleid);
		getsubmoduleref.forEach(sm -> {
			Usersubmodule usersubmodule = new Usersubmodule();
			usersubmodule.setSubmoduleid((Integer) sm);
			usersubmodule.setModuleid(patientLoginRepository.getmoduleid(sm));
			usersubmodule.setSuserrefid(suserrefid);
			usersubmodule.setEditionid(editionid);
			usersubmoduleRepository.save(usersubmodule);
		});
	}

	public boolean getcustomerpaymet(Customerpayment customerpaymet) throws Exception {
		boolean result = true;
		if (result == true) {
			RestTemplate restTemplate = new RestTemplate();
			String url = "https://api.razorpay.com/v1/payment_links";
			String username = patientLoginRepository.getusername();
			String password = patientLoginRepository.getpassword();
			String authorizationHeader = "Basic "
					+ DatatypeConverter.printBase64Binary((username + ":" + password).getBytes());
			org.springframework.http.HttpHeaders requestHeaders = new org.springframework.http.HttpHeaders();
			requestHeaders.add("Authorization", authorizationHeader);
			requestHeaders.add("Accept", MediaType.APPLICATION_JSON_VALUE);
			HttpEntity<Customerpayment> httpentity = new HttpEntity<Customerpayment>(customerpaymet, requestHeaders);
			result = true;
		} else {

			result = false;
		}
		return result;
	}

	public boolean getcustomerpaymentlink(Paymentlink paymentlink) throws Exception {
		boolean result = true;
		if (result == true) {
			RestTemplate restTemplate = new RestTemplate();
			String url = "https://api.razorpay.com/v1/invoices";
			String username = patientLoginRepository.getusername();
			String password = patientLoginRepository.getpassword();
			String authorizationHeader = "Basic "
					+ DatatypeConverter.printBase64Binary((username + ":" + password).getBytes());
			org.springframework.http.HttpHeaders requestHeaders = new org.springframework.http.HttpHeaders();
			requestHeaders.add("Authorization", authorizationHeader);
			requestHeaders.add("Accept", MediaType.APPLICATION_JSON_VALUE);
			HttpEntity<Paymentlink> httpentity = new HttpEntity<Paymentlink>(paymentlink, requestHeaders);
			ResponseEntity<Paymentlinkres> responseEntity = restTemplate.exchange(url, HttpMethod.POST, httpentity,
					Paymentlinkres.class);
			Paymentlinkres response = responseEntity.getBody();
			String id = response.getId();
			String entity = response.getEntity();
			String receipt = response.getReceipt();
			String invoice_number = response.getInvoice_number();
			String custid = response.getCustomer_id();
			String custpayid = response.getCustomer_details().getId();
			String name = response.getCustomer_details().getName();
			String email = response.getCustomer_details().getEmail();
			String contact = response.getCustomer_details().getContact();
			String gstin = response.getCustomer_details().getGstin();
			String billing_address = response.getCustomer_details().getBilling_address();
			String shipping_address = response.getCustomer_details().getShipping_address();
			String customer_name = response.getCustomer_details().getCustomer_name();
			String customer_email = response.getCustomer_details().getCustomer_email();
			String customer_contact = response.getCustomer_details().getCustomer_contact();
			String order_id = response.getOrder_id();
			Integer payment_id = response.getPaid_at();
			String paystatus = response.getPaystatus();
			Integer expire_by = response.getExpire_by();
			Integer issued_at = response.getIssued_at();
			Integer paid_at = response.getPaid_at();
			Integer cancelled_at = response.getCancelled_at();
			String expired_at = response.getExpired_at();
			String sms_status = response.getSms_status();
			String email_status = response.getEmail_status();
			Integer date = response.getDate();
			String terms = response.getTerms();
			String partial_payment = response.getPartial_payment();
			Integer gross_amount = response.getGross_amount();
			Integer tax_amount = response.getTax_amount();
			Integer taxable_amount = response.getTaxable_amount();
			Integer amount = response.getAmount();
			Integer amount_paid = response.getAmount_paid();
			Integer amount_due = response.getAmount_due();
			String currency = response.getCurrency();
			String description = response.getDescription();
			String comment = response.getComment();
			String short_url = response.getShort_url();
			String view_less = response.getView_less();
			String billing_start = response.getBilling_start();
			String billing_end = response.getBilling_end();
			String type = response.getType();
			String group_taxes_discounts = response.getGroup_taxes_discounts();
			String created_at = response.getCreated_at();
			Integer companyid = patientLoginRepository.getcompanyid(email);
			Integer branchid = patientLoginRepository.getcompanyid(email);
			Integer locname = 1;
			Integer locrefid = patientLoginRepository.getcompanyid(email);
			Integer customerid = patientLoginRepository.getcustomerid(email);
			System.out.println("::" + id + entity + receipt + invoice_number + custid + name + email + contact + gstin
					+ billing_address + shipping_address + customer_name + customer_email + customer_contact + order_id
					+ payment_id + paystatus + expire_by + issued_at + paid_at + cancelled_at + expired_at + sms_status
					+ email_status + date + terms + partial_payment + gross_amount + tax_amount + taxable_amount
					+ amount + amount_paid + amount_due + currency + description + comment + short_url + view_less
					+ billing_start + billing_end + type + group_taxes_discounts + created_at + companyid + branchid
					+ locname + locrefid + customerid);
			patientLoginRepository.paymentlink(id, entity, receipt, invoice_number, custid, custpayid, name, email,
					contact, gstin, billing_address, shipping_address, customer_name, customer_email, customer_contact,
					order_id, payment_id, paystatus, expire_by, issued_at, paid_at, cancelled_at, expired_at,
					sms_status, email_status, date, terms, partial_payment, gross_amount, tax_amount, taxable_amount,
					amount, amount_paid, amount_due, currency, description, comment, short_url, view_less,
					billing_start, billing_end, type, group_taxes_discounts, created_at, companyid, branchid, locname,
					locrefid, customerid);
			PaymentCalculation(payment_id, custid, amount, paystatus, customerid, companyid, branchid, locname,
					locrefid);
			result = true;

		} else {
			result = false;
		}
		return result;
	}

	private void PaymentCalculation(Integer payment_id, String custid, Integer amount, String paystatus,
			Integer customerid, Integer companyid, Integer branchid, Integer locname, Integer locrefid)
			throws Exception {
		Double amounts = amount.doubleValue() / 100;
		Double razorpaycal = new Double(2);
		Double vanustoncal = new Double(2);
		Integer shopbalance = patientLoginRepository.getcriteamount(custid);
		razorpaycal = amounts / 100 * 2;
//			razorpaycal=(amount/100)/100*3;
		vanustoncal = amounts.doubleValue() / 100 * 1.75;
		Double vanusttax = vanustoncal / 100 * 18;
		Double shopamt = amounts.doubleValue() - razorpaycal.doubleValue() - vanustoncal.doubleValue();
		patientLoginRepository.updatecustomerpay(customerid, custid, payment_id, amounts, razorpaycal, vanustoncal,
				vanusttax, shopamt, shopbalance, paystatus, companyid, branchid, locname, locrefid);
	}

	public ResponseEntity<Boolean> customerdeliveryreport(CustomerDelivery customerdeliveryreport) throws Exception {
		// try {
		customerdeliveryRepositoy.save(customerdeliveryreport);
		return ResponseEntity.created(null).body(true);
		// }

		// catch (DataIntegrityViolationException e) {
		// HashMap<String, String> errorMessage = new HashMap<String, String>();
		// errorMessage.put("message", e.getRootCause().getMessage());
		// return new ResponseEntity(errorMessage, HttpStatus.BAD_REQUEST);
		// } catch (Exception e) {
		// HashMap<String, String> errorMessage = new HashMap<String, String>();
		// errorMessage.put("message", e.toString());
		// return new ResponseEntity(errorMessage, HttpStatus.BAD_REQUEST);
		// }

	}

	public ResponseEntity<Boolean> Directcustomersigup(Diractcustomer diractcustomer) throws Exception {
		// try {
		diractcustomerRepository.save(diractcustomer);
		return ResponseEntity.created(null).body(true);
		// }

		// catch (DataIntegrityViolationException e) {
		// HashMap<String, String> errorMessage = new HashMap<String, String>();
		// errorMessage.put("message", e.getRootCause().getMessage());
		// return new ResponseEntity(errorMessage, HttpStatus.BAD_REQUEST);
		// } catch (Exception e) {
		// HashMap<String, String> errorMessage = new HashMap<String, String>();
		// errorMessage.put("message", e.toString());
		// return new ResponseEntity(errorMessage, HttpStatus.BAD_REQUEST);
		// }
	}

	public List customerpaymentlink(Integer cusid) throws Exception {
		// List list = new ArrayList<>();
		// patientLoginRepository.getcustomerpaylink(cusid);
		return patientLoginRepository.getcustomerpaylink(cusid);
	}

	public boolean getcustomerpaymentstatus(Customerpaymetstatus customerpaymetstatus) throws Exception {
		System.out.println(":::::Webhook Event " + customerpaymetstatus.getAccount_id());
		return true;
	}

	
}
