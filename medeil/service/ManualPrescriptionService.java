package com.medeil.service;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.medeil.domain.ManualPrescription;
import com.medeil.domain.ManualPrescriptionproduct;
import com.medeil.repository.ManualPrescProdRepository;
import com.medeil.repository.ManualPrescriptionRepository;

/**
 * 
 * @author Raja
 *
 */
@SuppressWarnings("rawtypes")
@Service
public class ManualPrescriptionService {
	@PersistenceContext
	EntityManager em;
	Query query;
	private static Logger logger = LogManager.getLogger();
	static ManualPrescription prescrecord;
	static ManualPrescription signimage;
	static ManualPrescriptionproduct prescproduct;
	@Autowired
	ManualPrescriptionRepository manualprescriptionrepository;

	@Autowired
	ManualPrescProdRepository manualPrescProdRepository;

	public List patientid(Integer comid, Integer branchid, Integer locname, Integer locrefid) throws Exception {
		return manualprescriptionrepository.getpatientid(comid, branchid, locname, locrefid);
	}

	public List patientdetails(Integer pid, Integer comid, Integer branchid, Integer locname, Integer locrefid)
			throws Exception {
		return manualprescriptionrepository.padetails(pid, comid, branchid, locname, locrefid);
	}

	public List doctorname(Integer comid, Integer branchid, Integer locname, Integer locrefid) throws Exception {
		return manualprescriptionrepository.doctorsname(comid, branchid, locname, locrefid);

	}

	public List employee(Integer comid, Integer branchid, Integer locname, Integer locrefid) throws Exception {
		return manualprescriptionrepository.employees(comid, branchid, locname, locrefid);

	}

	public List presproduct(Integer prodid) throws Exception {

		return manualprescriptionrepository.getprescprod(prodid);
	}

	public List getordertype() throws Exception {
		return manualprescriptionrepository.getordtype();
	}

	// Boopalan 071119
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

			manualprescriptionrepository.prescriptionpath(filepath, prescrecord.getCompanyrefid(),
					prescrecord.getBranchrefid(), prescrecord.getLocname(), prescrecord.getLocrefid(),
					prescrecord.getPresc_no());
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e);
		}

		return filepath;
	}

	// Save Signature Image

//	public String savesignatureimage(MultipartFile file) {
//		String filepath = "Undefined Path";
//		// Save the uploaded file to this folder
//		String UPLOADED_FOLDER = "E://git//medeil//MedeilBoot//SignatureImage//";
//		if (file.isEmpty()) {
//			return filepath;
//		}
//
//		try {
//
//			// Get the file and save it somewhere
//			byte[] bytes = file.getBytes();
//			Path path = Paths.get(UPLOADED_FOLDER + signimage.getLocrefid() + "_" + signimage.getPresc_no() + ".png");
//			Files.write(path, bytes);
//			System.out.println(path.toString());
//			filepath = path.toString();
//
//			manualprescriptionrepository.signimagepath(filepath, signimage.getCompanyrefid(),
//					signimage.getBranchrefid(), signimage.getLocname(), signimage.getLocrefid(),
//					signimage.getPresc_no());
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//
//		return filepath;
//	}

	// Boopalan 06112019
	public boolean createPrescriptionRecord(ManualPrescription presc) throws Exception {

		// try {
		prescrecord = presc;
		List empcode = this.getAutoincrement(presc.getCompanyrefid(), presc.getBranchrefid(), presc.getLocname(),
				presc.getLocrefid());
		String str = (String) empcode.get(0);
		presc.setPresc_no(str);

		manualprescriptionrepository.save(presc);
		return true;
		// } catch (Exception cause) {
		// logger.error("Exception in (prescupload)Method : createRecord() " + cause);
		// }

		// return false;

	}

	public boolean saveprescprod(List<ManualPrescriptionproduct> prescprod) throws Exception {
		// try {
		for (ManualPrescriptionproduct temp : prescprod) {
			int prefid = manualPrescProdRepository.prefid(temp.getCompanyrefid(), temp.getBranchrefid(),
					temp.getLocname(), temp.getLocrefid());
			temp.setPrescriptionrefid(prefid);
			manualPrescProdRepository.save(temp);
		}
		return true;
		// } catch (Exception cause) {
		// logger.error("Exception in (Prescproduct)methode : saveprescproduct()" +
		// cause);

		// }
		// return false;

	}

	// Boopalan 071119
	@Transactional
	public List getAutoincrement(int compid, int branchid, int locname, int locrefid) throws Exception {
		List ls = null;
		String a1 = "manualprescription";

		try {
			String q = "Call medc_prescription.pro_manualprescriptionautoincrement(?,?,?,?,?)";
			query = em.createNativeQuery(q);
			query.setParameter(1, a1);
			query.setParameter(2, compid);
			query.setParameter(3, branchid);
			query.setParameter(4, locname);
			query.setParameter(5, locrefid);

			ls = query.getResultList();
			System.out.println("SutoIncrement  :" + ls);
		} catch (Exception e) {
			System.out.println("getAutoincrements  :" + e);
			throw new Exception(e);
		}

		return ls;
	}

	public List viewpresc(Integer comid, Integer branchid, Integer locname, Integer locrefid) throws Exception {
		return manualprescriptionrepository.viewprescdetails(comid, branchid, locname, locrefid);
	}

}