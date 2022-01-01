package com.medeil.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.medeil.domain.CashManage;
import com.medeil.domain.Closeregister;
import com.medeil.domain.Journal;
import com.medeil.domain.Openregister;
import com.medeil.domain.Salescounter;
import com.medeil.repository.CashManageRepository;
import com.medeil.repository.CloseRegisterRepository;
import com.medeil.repository.OpenRegisterRepository;
import com.medeil.repository.PJournalRepository;
import com.medeil.repository.SalescounterRepository;
import com.medeil.service.OpeanCloseRegisterService;
import com.medeil.util.AutoIncrement;

@Service
public class OpeanCloseRegisterServiceImpl implements OpeanCloseRegisterService {

	@Autowired
	private OpenRegisterRepository openRegisterRepository;

	@Autowired
	private CloseRegisterRepository closeRegisterRepository;

	@Autowired
	private SalescounterRepository salescounterRepository;

	@Autowired
	private PJournalRepository PjournalRepo;
	
	@Autowired
	private CashManageRepository cashmanagerepo;

	@Override
	public ResponseEntity<Boolean> Loginemployeeopenregister(Openregister openregister) throws Exception {
		// try {
		openRegisterRepository.save(openregister);
		return ResponseEntity.created(null).body(true);

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

	@Override
	public ResponseEntity<Boolean> Logoutemployeecloseregister(Closeregister closeregister) throws Exception {
		// try {
		closeRegisterRepository.save(closeregister);
		return ResponseEntity.created(null).body(true);

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

	@Override
	public ResponseEntity<Boolean> Salescountersave(Salescounter salescounter) throws Exception {
		// try {
		salescounterRepository.save(salescounter);
		return ResponseEntity.created(null).body(true);

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

	@Override
	public List employeedetails(Integer userid) throws Exception {
		// try {

		return salescounterRepository.employeedetails(userid);
		// } catch (Exception e) {
		// e.printStackTrace();
		// }
		// return null;
	}

	// puthiran
	@Override
	public List employeeopenregisterdetails(Integer userid,String logintime) throws Exception {
		// try {

		return salescounterRepository.employeeopenregisterdetails(userid,logintime);
		// } catch (Exception e) {
		// e.printStackTrace();
		// }
		// return null;
	}

	@Override
	public List employeetransdetails(Integer userid, String logintime) throws Exception {
		return salescounterRepository.employeetransdetails(userid, logintime);
	}

	@Override
	public List openregisterdetails(Integer compid, Integer branchid, Integer locname, Integer locrefid)
			throws Exception {
		// try {

		return salescounterRepository.openregisterdetails(compid, branchid, locname, locrefid);
		// } catch (Exception e) {
		// e.printStackTrace();
		// }
		// return null;
	}

	@Override
	public List closeregisterdetails(Integer compid, Integer branchid, Integer locname, Integer locrefid)
			throws Exception {
		return salescounterRepository.closeregisterdetails(compid, branchid, locname, locrefid);
	}
	
	@Override
	public List GetCashMovements(Integer userid,String logintime, String logouttime)
			throws Exception {
		return salescounterRepository.GetCashMovements(userid,logintime,logouttime);
	}
	
	@Override
	public List GetAddRemoveCashtotal(Integer userid,String logintime)
			throws Exception {
		return salescounterRepository.GetAddRemoveCashtotal(userid,logintime);
	}

	// Account Linking
	@Override
	public int saveOpenRegJournal(Journal jrnl) throws Exception {
		int saveflag = 0;
		System.out.println("entering" + jrnl.getLocname() + "++" + jrnl.getLocrefid());
		Double incid = openRegisterRepository.viewORJrnlId(jrnl.getLocname(), jrnl.getLocrefid());
		System.out.println("incid-ing:" + incid + "  sdadsas   ");
		String incno = openRegisterRepository.viewORJrnlIncNo(jrnl.getLocname(), jrnl.getLocrefid(), incid);
		System.out.println(incid + "------" + incno);
		if (incno == null) {
			incno = "0";
		}

		StringBuilder incr = new StringBuilder(AutoIncrement.getIncrement03("OR/JRNL/", jrnl.getLocname().toString(),
				jrnl.getLocrefid().toString(), incno));
		jrnl.setJournalno(incr.toString());
		PjournalRepo.save(jrnl);

		saveflag = 1;
		return saveflag;

	}

	@Override
	public int saveCloseJournal(Journal jrnl) throws Exception {
		int saveflag = 0;
		System.out.println("entering" + jrnl.getLocname() + "++" + jrnl.getLocrefid());
		Double incid = openRegisterRepository.viewCRJrnlId(jrnl.getLocname(), jrnl.getLocrefid());
		System.out.println("incid-ing:" + incid + "  sdadsas   ");
		String incno = openRegisterRepository.viewCRJrnlIncNo(jrnl.getLocname(), jrnl.getLocrefid(), incid);
		System.out.println(incid + "------" + incno);
		if (incno == null) {
			incno = "0";
		}

		StringBuilder incr = new StringBuilder(AutoIncrement.getIncrement03("CR/JRNL/", jrnl.getLocname().toString(),
				jrnl.getLocrefid().toString(), incno));
		jrnl.setJournalno(incr.toString());
		PjournalRepo.save(jrnl);

		saveflag = 1;
		return saveflag;

	}
	
	//Cash Manage Process
	@Override
	public ResponseEntity<Boolean> saveCashManage(CashManage cashmanage) throws Exception {
		cashmanagerepo.save(cashmanage);
		return ResponseEntity.created(null).body(true);
	}

}
