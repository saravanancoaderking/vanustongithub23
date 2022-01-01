package com.medeil.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.medeil.domain.CurrencySetting;
import com.medeil.domain.Decimalsettings;
import com.medeil.domain.FinacialSetting;
import com.medeil.domain.Journal;
import com.medeil.domain.Setupcostsetting;
import com.medeil.repository.CurrencySettingRepository;
import com.medeil.repository.DecimalsettingRepository;
import com.medeil.repository.FinacialsettingRepository;
import com.medeil.repository.PJournalRepository;
import com.medeil.repository.SetupcostRepository;
import com.medeil.util.AutoIncrement;

@SuppressWarnings("rawtypes")
@Service
public class CurrencySettingService {

	@Autowired
	private CurrencySettingRepository currencysettingrepository;
	
	@Autowired
	private DecimalsettingRepository decimalsettingrepo; 
	
	@Autowired
	private SetupcostRepository setupcostrepo; 
	
	@Autowired
	private FinacialsettingRepository finacialrepo; 
	
	@Autowired
	private PJournalRepository PjournalRepo;


	public List getCountryname(String cn)throws Exception {
		return currencysettingrepository.getCountryname(cn);
	}

	public List getCurrency(Integer id)throws Exception {
		return currencysettingrepository.getCurrency(id);
	}

	public ResponseEntity<Boolean> createCurrency(CurrencySetting currency)throws Exception {
	//	try {
			currencysettingrepository.save(currency);
			return ResponseEntity.created(null).body(true);
	//	} catch (DataIntegrityViolationException e) {
	//		HashMap<String, String> errorMessage = new HashMap<String, String>();
	//		errorMessage.put("message", e.getRootCause().getMessage());
	//		return new ResponseEntity(errorMessage, HttpStatus.BAD_REQUEST);
	//	}
	//	catch(Exception e) {
	//		HashMap<String, String> errorMessage = new HashMap<String, String>();
	//		errorMessage.put("message", e.toString());
	//		return new ResponseEntity(errorMessage, HttpStatus.BAD_REQUEST);
	//	}
	}

	public List getCurrencySts() {
		return currencysettingrepository.getCurrencySts();
	}

	public ResponseEntity<Boolean> createDecimal(Decimalsettings decimalsetting) throws Exception{
	//	try {
			decimalsettingrepo.save(decimalsetting);
			return ResponseEntity.created(null).body(true);
	//	} catch (DataIntegrityViolationException e) {
	//		HashMap<String, String> errorMessage = new HashMap<String, String>();
	//		errorMessage.put("message", e.getRootCause().getMessage());
	//		return new ResponseEntity(errorMessage, HttpStatus.BAD_REQUEST);
	//	}
	//	catch(Exception e) {
	//		HashMap<String, String> errorMessage = new HashMap<String, String>();
	//		errorMessage.put("message", e.toString());
	//		return new ResponseEntity(errorMessage, HttpStatus.BAD_REQUEST);
	//	}
	}

	public ResponseEntity<Boolean> createSetup(Setupcostsetting setupcostsetting) throws Exception{
	//	try {
			setupcostrepo.save(setupcostsetting);
			return ResponseEntity.created(null).body(true);
	//	} catch (DataIntegrityViolationException e) {
	//		HashMap<String, String> errorMessage = new HashMap<String, String>();
	//		errorMessage.put("message", e.getRootCause().getMessage());
	//		return new ResponseEntity(errorMessage, HttpStatus.BAD_REQUEST);
	//	}
	//	catch(Exception e) {
	//		HashMap<String, String> errorMessage = new HashMap<String, String>();
	//		errorMessage.put("message", e.toString());
	//		return new ResponseEntity(errorMessage, HttpStatus.BAD_REQUEST);
	//	}
	}

	public List getDecimalSts(Integer compid, Integer brnchid, Integer lname, Integer lrefid) throws Exception{
		return currencysettingrepository.getDecimalSts(compid,brnchid,lname,lrefid);
	}
	
	public List fetchCurrsts(Integer compid, Integer brnchid, Integer lrefid)throws Exception {
		return currencysettingrepository.fetchCurrsts(compid,brnchid,lrefid);
	}
	
	public Setupcostsetting fetchsetupcost(Integer compid, Integer brnchid, Integer lname, Integer lrefid) throws Exception{
		return setupcostrepo.findByCompanyrefidAndBranchrefidAndLocnameAndLocrefid(compid,brnchid,lname,lrefid);
		//return currencysettingrepository.fetchsetupcost(compid,brnchid,lname,lrefid);
	}
	
	public ResponseEntity<Boolean> createFinacialyr(FinacialSetting finacial)throws Exception {
	//	try {
			finacialrepo.save(finacial);
			return ResponseEntity.created(null).body(true);
	//	} catch (DataIntegrityViolationException e) {
	//		HashMap<String, String> errorMessage = new HashMap<String, String>();
	//		errorMessage.put("message", e.getRootCause().getMessage());
	//		return new ResponseEntity(errorMessage, HttpStatus.BAD_REQUEST);
	//	}
	//	catch(Exception e) {
	//		HashMap<String, String> errorMessage = new HashMap<String, String>();
	//		errorMessage.put("message", e.toString());
	//		return new ResponseEntity(errorMessage, HttpStatus.BAD_REQUEST);
	//	}
	}
	
	public Journal fetchsetupcostjrnl(Integer compid, Integer brnchid, Double lname, Double lrefid) {
		return PjournalRepo.findByCompanyrefidAndBranchrefidAndLocnameAndLocrefidAndJrnltype(compid,brnchid,lname,lrefid,11);
	}

	public ResponseEntity<Boolean> saveSetupcostjournal(Journal jrnl) {
		boolean saveflag = false;
		System.out.println("entering" + jrnl.getLocname() + "++" + jrnl.getLocrefid());
		Double incid = setupcostrepo.viewSCJrnlId(jrnl.getLocname(), jrnl.getLocrefid());
		System.out.println("incid-ing:" + incid + "  sdadsas   ");
		String incno = setupcostrepo.viewSCJrnlIncNo(jrnl.getLocname(), jrnl.getLocrefid(), incid);
		System.out.println(incid + "------" + incno);
		if (incno == null) {
			incno = "0";
		}

		StringBuilder incr = new StringBuilder(AutoIncrement.getIncrement03("ST/JRNL/", jrnl.getLocname().toString(),
				jrnl.getLocrefid().toString(), incno));
		jrnl.setJournalno(incr.toString());
		PjournalRepo.save(jrnl);

		saveflag = true;
		return ResponseEntity.ok(saveflag);
	}


}
