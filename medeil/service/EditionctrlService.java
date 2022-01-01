package com.medeil.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.medeil.domain.Editionctrl;
import com.medeil.repository.EditionctrlRepository;
import com.medeil.repository.RolectrlRepository;

@SuppressWarnings("rawtypes")
@Service
public class EditionctrlService {

	@Autowired
	private EditionctrlRepository editionctrlRepository;
	@Autowired
	private RolectrlRepository rolectrlRepository;

	private static Logger logger = LogManager.getLogger();

	@PersistenceContext
	EntityManager em;

	Query query;

	public List getEditionname(Integer id) throws Exception {
		return editionctrlRepository.getEditionname(id);
	}

	public List subDomainname(Integer id) throws Exception {
		return editionctrlRepository.subDomainname(id);
	}

	public List getModulelist(Integer id) throws Exception {
		return editionctrlRepository.getModulelist(id);
	}

	public List getsubModulelist(Integer eid, List<Integer> id) throws Exception {
		List list = null;
	//	try {
			for (int index = 0; index < id.size(); index++)  {
				int mid = id.get(index);
				list = editionctrlRepository.getsubModulelist(eid, mid);
			}
	//	} catch (Exception ex) {
	//		logger.error("Exception In Method : getsubModulelist() : " + ex);
	//	}
		return list;
	}

//	@SuppressWarnings("unchecked")
//	@Transactional
//	public boolean saveEditioncontrol(Object obj) throws Exception {
//		ObjectMapper mapper = new ObjectMapper();
//		boolean flag = false;
//		try {
//			HashMap<Integer, Object> hm = (HashMap<Integer, Object>) obj;
//			List subModule = (List) hm.get("submoduleid");
//			Integer eID = (Integer) hm.get("editionid");
//			int editionID = eID;
////			int roleid=;
//			for (int j = 0; j < subModule.size(); j++) throws Exception {
//				/**
//				 * Below Insurence Entity(Model) is Same for
//				 * DrugMaster(Insurance Type) and This one(Edition Module
//				 * Assign) please Dont confuse,both are same variable's so i
//				 * have taken,If you have any doubt refer Your Document
//				 **/
//				Insurance pojo = mapper.convertValue(subModule.get(j), Insurance.class);
//				Integer moduleID = editionctrlRepository.getModuleID(pojo.getId());
//				String sqlString = "INSERT INTO medc_adminsecurity.medc_editionctrl(ModuleRefID, SubModuleRefID, EditionRefID) VALUES(? , ? , ?)";
//				query = em.createNativeQuery(sqlString);
//				query.setParameter(1, moduleID);
//				query.setParameter(2, pojo.getId());
//				query.setParameter(3, editionID);
//				int reVal = query.executeUpdate();
//				
//				if (reVal == 1) throws Exception {
//					flag = true;
//				}
//			}
//		} catch (Exception e) throws Exception {
//			logger.error("Exception In Method : saveEditioncontrol() : " + e);
//		}
//		return flag;
//	}

	// Boopalan 260619
	public List getModuleAssign(Integer id) throws Exception {
		return editionctrlRepository.getModuleAssign(id);
	}

	public boolean getEditionID(Integer id) throws Exception {
		boolean flag = false;
	//	try {
			Integer reID = editionctrlRepository.getEditionID(id);
			if (id == reID) {
				flag = true;
			} else {
				flag = false;
			}
	//	} catch (Exception ex){
	//		logger.error("Exception In Method : getEditionID() : " + ex);
	//	}
		return flag;
	}

	public List getlablename(Integer eid) throws Exception {
		return editionctrlRepository.getlablename(eid);
	}
	
	public List getmodulename(Integer eid, String lname) throws Exception {
		return editionctrlRepository.getModulename(eid,lname);
	}

	public List getsubmodulename(Integer eid, Integer mid) throws Exception {
		return editionctrlRepository.getsubModulename(eid, mid);
	}
	
	public List getselectedsubmodulename(Integer eid) throws Exception {
		return editionctrlRepository.getselectedsubmodulename(eid);
	}

	public List geteditionmodule(Integer editionid) throws Exception {
		return editionctrlRepository.geteditionmodule(editionid);
	}

	public ResponseEntity<Boolean> saveEditioncontrol(List<Editionctrl> editionctrl) throws Exception {
	//	try {
		for (Editionctrl editionctrl2 : editionctrl) {
			boolean existsByeditionid = editionctrlRepository.existsByEditionidAndModuleidAndSubmoduleid(editionctrl2.getEditionid(),editionctrl2.getModuleid(),editionctrl2.getSubmoduleid());
			if (existsByeditionid==true) {				
			}
			else {
				editionctrlRepository.save(editionctrl2);
		}
		}		
		return ResponseEntity.created(null).body(true);
	
	//	} catch (DataIntegrityViolationException e)  {
	//		HashMap<String, String> errorMessage = new HashMap<String, String>();
	//		errorMessage.put("message", e.getRootCause().getMessage());
	//		return new ResponseEntity(errorMessage, HttpStatus.BAD_REQUEST);
	//	} catch (Exception e)  {
	//		HashMap<String, String> errorMessage = new HashMap<String, String>();
	//		errorMessage.put("message", e.toString());
	//		return new ResponseEntity(errorMessage, HttpStatus.BAD_REQUEST);

	//	}
	}

}
