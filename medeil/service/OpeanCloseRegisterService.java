package com.medeil.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.medeil.domain.CashManage;
import com.medeil.domain.Closeregister;
import com.medeil.domain.Journal;
import com.medeil.domain.Openregister;
import com.medeil.domain.Salescounter;

public interface OpeanCloseRegisterService {

	public ResponseEntity<Boolean> Loginemployeeopenregister(Openregister openregister) throws Exception;

	public ResponseEntity<Boolean> Logoutemployeecloseregister(Closeregister closeregister) throws Exception;

	public ResponseEntity<Boolean> Salescountersave(Salescounter salescounter) throws Exception;

	public List employeedetails(Integer userid) throws Exception;

	public List employeeopenregisterdetails(Integer userid,String logintime) throws Exception;

	public List employeetransdetails(Integer userid, String logintime) throws Exception;

	public List openregisterdetails(Integer compid, Integer branchid, Integer locname, Integer locrefid)
			throws Exception;

	public List closeregisterdetails(Integer compid, Integer branchid, Integer locname, Integer locrefid)
			throws Exception;
	
	public List GetCashMovements(Integer userid, String logintime, String logouttime)
			throws Exception;
	
	public List GetAddRemoveCashtotal(Integer userid, String logintime)
			throws Exception;
	
	public int saveOpenRegJournal(Journal jrnl) throws Exception;

	public int saveCloseJournal(Journal jrnl) throws Exception;

	public ResponseEntity<Boolean> saveCashManage(CashManage cashmanage) throws Exception;

	

	

}
