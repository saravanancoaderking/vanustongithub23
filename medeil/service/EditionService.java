package com.medeil.service;

import java.util.HashMap;
import java.util.List;

import javax.transaction.Transactional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.medeil.domain.Edition;
import com.medeil.domain.Role;
import com.medeil.repository.EditionRepository;
import com.medeil.repository.RoleRepository;

@SuppressWarnings("rawtypes")
@Service
public class EditionService {

	@Autowired
	private EditionRepository editionRepository;
	@Autowired
	private RoleRepository roleRepository;

	private static Logger logger = LogManager.getLogger();

	public List getProduct(Integer id) throws Exception {
		return editionRepository.editionProduct(id);
	}

	public List getDomainlist(Integer cid, Integer pid) throws Exception {
		return editionRepository.getDomainlist(cid, pid);
	}

	public List getsubdomain(Integer cid, Integer pid, Integer did) throws Exception {
		return editionRepository.getSubdomain(cid, pid, did);
	}

	public Integer getCheckEdition(Integer cid, Integer pid, Integer did, Integer sdid, String editionName,
			String editionVersion) throws Exception {
		Integer reFlag = 0;
	//	try {
			String value = editionRepository.getCheckEdition(cid, pid, did, sdid, editionName, editionVersion);
			if (editionName.equalsIgnoreCase(value)) {
				reFlag = 1;
			} else {
				reFlag = 0;
			}
	//	} catch (Exception eE) {
	//		logger.error("Exception In Method : getCheckEdition() : " + eE);
	//	}
		return reFlag;
	}

	@Transactional
	public ResponseEntity<Boolean> createEdition(Edition edition) throws Exception {
	//	try {
			int eid = editionRepository.save(edition).getId();
			Role role = new Role();
			role.setCountryid(Integer.valueOf(edition.getCountryid()));
			role.setProductid(Integer.valueOf(edition.getProductid()));
			role.setRolename(edition.getClientrole());
			role.setCompanyid(1);
			role.setShopid(1);
			role.setEditionrefid(eid);
			role.setStoretype(edition.getStoretype());
			roleRepository.save(role);
			String currentscopes = roleRepository.getCurrentScope();
			System.out.println(currentscopes);
			String updatedScope = currentscopes + "," + role.getRolename();
			System.out.println(updatedScope);
			roleRepository.updateCurrentScope(updatedScope);
			return ResponseEntity.created(null).body(true);

	//	} catch (DataIntegrityViolationException e) {
	//		HashMap<String, String> errorMessage = new HashMap<String, String>();
	//		errorMessage.put("message", e.getRootCause().getMessage());
	//		return new ResponseEntity(errorMessage, HttpStatus.BAD_REQUEST);
	//	} catch (Exception e) {
	//		HashMap<String, String> errorMessage = new HashMap<String, String>();
	//		errorMessage.put("message", e.toString());
	//		return new ResponseEntity(errorMessage, HttpStatus.BAD_REQUEST);

	//	}
	}

//	public List getAll(Integer ety) throws Exception {
//		return editionRepository.getEditionlist(ety);
//
//	}

	
	public List getAllEditionDetails(Integer ety,Integer storetype) throws Exception {
		return editionRepository.getAllEditionDetails(ety,storetype);

	}
	public List Viewcurrency(Integer id) throws Exception {
		return editionRepository.Viewcurrency(id);
	}

	public List getEditionModules(Integer cid, Integer pid, Integer did, Integer sdid, Integer ety) throws Exception {
		return editionRepository.getEditionModules(cid, pid, did, sdid, ety);
	}

	public Object getEditiondetails(Integer eid) throws Exception {
		return editionRepository.getEditiondetails(eid);
	}
	
	public List getRoleBasedModuledetails( Integer status) throws Exception {
		return editionRepository.getRoleBasedModuledetails(status);
	}

	
	public List getRoleIdRoleName() throws Exception {
		return editionRepository.getRoleIdRoleName();
	}
}
