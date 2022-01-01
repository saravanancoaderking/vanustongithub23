package com.medeil.service;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.medeil.domain.Domain;
import com.medeil.repository.DomainRepository;

/**
 * @author VANUSTON ( AJITH AK )
 *
 */
@SuppressWarnings("rawtypes")
@Service
public class DomainService {

	@Autowired
	private DomainRepository repository;

	private static Logger logger = LogManager.getLogger();

	@SuppressWarnings("unchecked")
	public ResponseEntity<Domain> saveDomain(Domain domain) throws Exception {
		// try {
		repository.save(domain);
		return ResponseEntity.created(null).body(domain);
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
		return repository.getProduct(id);
	}

	public List domainList() throws Exception {
		return repository.domainList();
	}

//	public Integer checkProduct(Integer cid, Integer pid, String dname) {
//		Integer flag = 0;
//		try {
//			String val = repository.checkProduct(cid, pid, dname);
//			if (dname.equalsIgnoreCase(val)) {
//				flag = 1;
//			} else {
//				flag = 0;
//			}
//		} catch (Exception eP) {
//			logger.error("Exception In Method : checkProduct() : " + eP);
//		}
//		return flag;
//	}

	public List getDomainByCountryAndProduct(int countryid, int productid) throws Exception {
		return repository.getDomainByCountryAndProduct(countryid, productid);
	}

	public List domainCountryDropdown() throws Exception {
		// TODO Auto-generated method stub
		return repository.domainCountryDropdown();
	}
}
