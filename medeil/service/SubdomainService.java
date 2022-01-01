package com.medeil.service;

import java.util.HashMap;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.medeil.domain.Subdomain;
import com.medeil.repository.SubdomainRepository;

@SuppressWarnings("rawtypes")
@Service
public class SubdomainService {

	@Autowired
	private SubdomainRepository subdomainRepository;
	private static Logger logger = LogManager.getLogger();

	public List getAll() {
		return subdomainRepository.Subdomainlist();
	}

	@SuppressWarnings("unchecked")
	public ResponseEntity<Subdomain> createSubDomain(Subdomain subdomain) throws Exception {
		// try {
		subdomainRepository.save(subdomain);
		return ResponseEntity.created(null).body(subdomain);
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

	public List getProduct(Integer id) throws Exception {
		return subdomainRepository.getProduct(id);
	}

	public List getDomain(Integer id) throws Exception {
		return subdomainRepository.getDomain(id);
	}

	public List getSubdomainDropdown() throws Exception {
		// TODO Auto-generated method stub
		return subdomainRepository.getSubdomainDropdown();
	}

//	public Integer checkSubProduct(Integer did, Integer cid, Integer pid, String pName) {
//		Integer flag = 0;
//		try {
//			String reValue = subdomainRepository.checkSubProduct(did, cid, pid, pName);
//			if (pName.equalsIgnoreCase(reValue)) {
//				flag = 1;
//			} else {
//				flag = 0;
//			}
//		} catch (Exception eP) {
//			logger.error("Exception In Method : checkSubProduct() : " + eP);
//			eP.printStackTrace();
//		}
//		return flag;
//	}

}
