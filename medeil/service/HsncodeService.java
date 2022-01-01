package com.medeil.service;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.medeil.bean.HsnBean;
import com.medeil.domain.Drug;
import com.medeil.domain.Hsn_id;
import com.medeil.domain.Hsn_md;
import com.medeil.domain.Hsncode;
import com.medeil.domain.Hsncodeproduct;
import com.medeil.domain.Shop;
import com.medeil.repository.DrugRepository;
import com.medeil.repository.HsncodeRepository;
import com.medeil.repository.HsnidRepository;
import com.medeil.repository.HsnmdRepository;

@SuppressWarnings("rawtypes")
@Service
public class HsncodeService {
	private final Logger log = LoggerFactory.getLogger(PatientService.class);

	@Autowired
	private HsncodeRepository hsncoderepository;

	@Autowired
	private HsnmdRepository hsnmdRepository;

	@Autowired
	private HsnidRepository hsnidrepository;

	@Autowired
	private DrugRepository drugRepository;

	@Autowired
	private HsncodeRepository hsncodeRepository;

	public List countrylist() {
		System.out.println("Raja Service");
		return hsncoderepository.getcountrys();

	}

//	public Boolean savehsncode(List<Hsncode> hsncode) {
//		Boolean flag = false;
//		try
//		{
//			for(int i =0;i < hsncode.size();i++)
//				
//			hsncoderepository.save(hsncode.get(i));
//		
//			System.out.println("Service success...");
//			flag = true;
//			
//		}catch(Exception e) {
//			
//			log.error("Exception in methode : " +e);
//		}
//		System.out.println(flag);
//		return flag;
//	}

	public boolean savemdes(List<Hsn_md> hsnmd) throws Exception {
		boolean flag = false;

		// try {
		System.out.println("AAAAAAAAAAAAAAA");
		for (int i = 0; i < hsnmd.size(); i++)
			hsnmdRepository.save(hsnmd.get(i));
		flag = true;
		System.out.println("Raja");

		// }
		// catch(Exception e) {
		// System.out.println("Error Occured in savemdes()"+e);
		// }
		return flag;
	}

	public boolean saveid(Hsn_id hsnid) throws Exception {
		boolean flag = false;
		// try {
		System.out.println("idService");
		int hsnrefid = hsnidrepository.gethsnrefid(hsnid.getcompanyrefid());
		hsnid.setmdref_id(hsnrefid);
		System.out.println(hsnrefid);
		hsnidrepository.save(hsnid);
		flag = true;
		System.out.println("post save");
		// }
		// catch(Exception e) {
		// System.out.println("Error Occured saveid()"+e);
		// }
		return flag;
	}

	public ResponseEntity<Boolean> Updatehsncodeproduct(Hsncodeproduct hsncode) throws Exception {
		// try {
		// hsncoderepository.save(hsncode);
		Drug drug = new Drug();
		drug = drugRepository.findById(hsncode.getDrugproductid()).get();
		drug.setGst(hsncode.getGst());
		drug.setCgst(hsncode.getCgst());
		drug.setSgst(hsncode.getSgst());
		drug.setUtgst(hsncode.getUgst());
		drug.setIgst(hsncode.getIgst());
		drug.setVat(hsncode.getVat());
		drug.setHsnid(hsncode.getId());
		drugRepository.save(drug);
		return ResponseEntity.created(null).body(true);
		// }
		// catch (DataIntegrityViolationException e) {
		// HashMap<String, String> errorMessage = new HashMap<String, String>();
		// errorMessage.put("message", e.getRootCause().getMessage());
		// return new ResponseEntity(errorMessage, HttpStatus.BAD_REQUEST);
		// }
		// catch(Exception e) {
		// HashMap<String, String> errorMessage = new HashMap<String, String>();
		// errorMessage.put("message", e.toString());
		// return new ResponseEntity(errorMessage, HttpStatus.BAD_REQUEST);
		// }
	}

	public ResponseEntity<Boolean> SaveHsncode(List<HsnBean> hsnBeanlist) throws Exception {
		Hsncode hsncode = new Hsncode();
		for (HsnBean hsnBeans : hsnBeanlist) {
			Optional<Hsn_md> hsn_md = hsnmdRepository.findById(hsnBeans.getMdescid());
			String cater = String.valueOf(hsnBeans.getHsncode());
			if (hsn_md.isPresent()) {
//				hsn_md.get().setMain_description(hsnBeans.getMain_description());
				hsn_md.get().setCountry_id(hsnBeans.getCountry_id());
				hsn_md.get().setChapter_id(Integer.valueOf((cater.substring(0, 2))));
				hsnmdRepository.save(hsn_md.get());
					} else {
				Hsn_md md = new Hsn_md();
				md.setMain_description(hsnBeans.getMain_description());
				md.setCountry_id(hsnBeans.getCountry_id());
				md.setChapter_id(Integer.valueOf((cater.substring(0, 2))));
				md.setCompanyrefid(hsnBeans.getCompanyrefid());
				hsnmdRepository.save(md);

			}

			hsncode.setChapter(Integer.valueOf((cater.substring(0, 2))));
			hsncode.setHsncode(hsnBeans.getHsncode());
			hsncode.setHsndescription(hsnBeans.getHsndescription());
			hsncode.setGst(hsnBeans.getGst());
			hsncode.setYear(hsnBeans.getYear());
			hsncodeRepository.save(hsncode);

		}

		return ResponseEntity.created(null).body(true);
	}

	public ResponseEntity<Boolean> savemdescrip(Hsn_md hsnmd) {
		System.out.println("Service Hsn");
		hsnmdRepository.save(hsnmd);
		return ResponseEntity.created(null).body(true);
	}

}
