/**
 * 
 */
package com.medeil.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.medeil.domain.Submodules;
import com.medeil.repository.SubmodulesRepository;

/**
 * @author
 *
 */
@SuppressWarnings("rawtypes")
@Service
public class SubmodulesService {

	@Autowired
	SubmodulesRepository repository;

	public List<Submodules> getAll() {

		List<Submodules> list = new ArrayList<>();
		Iterable<Submodules> submodules = repository.findAll();

		submodules.forEach(list::add);
		return list;
	}

	@SuppressWarnings("unchecked")
	public ResponseEntity<Submodules> postsubmodule(Submodules submodules) throws Exception {
//		try {
		repository.save(submodules);
		return ResponseEntity.created(null).body(submodules);
//		} catch (DataIntegrityViolationException e) {
//			HashMap<String, String> errorMessage = new HashMap<String, String>();
//			errorMessage.put("message", e.getRootCause().getMessage());
//			return new ResponseEntity(errorMessage, HttpStatus.BAD_REQUEST);
//		} catch (Exception e) {
//			HashMap<String, String> errorMessage = new HashMap<String, String>();
//			errorMessage.put("message", e.toString());
//			return new ResponseEntity(errorMessage, HttpStatus.BAD_REQUEST);

//		}

	}

	public List SubModulelist() throws Exception {
		return repository.SubModulelist();
	}

	public List countryaccess() throws Exception {
		return repository.countryaccess();
	}

	public List Product(long id) throws Exception {
		return repository.Product(id);
	}

	public List domain(long id1, long id2) throws Exception {
		return repository.domain(id1, id2);
	}

	public List subdomain(long id1, long id2, long id3) throws Exception {
		return repository.subdomain(id1, id2, id3);
	}

	public List submodmodules(long id1, long id2, long id3, long id4) throws Exception {
		return repository.submodmodules(id1, id2, id3, id4);
	}

	public Submodules updateSubModules(Submodules submodules, long id) throws Exception {
		submodules.setSubmoduleid(id);
		System.out.println(submodules.getSubmoduleid());
		repository.save(submodules);
		return submodules;
	}

	public ResponseEntity<Boolean> delete(long id) throws Exception {
		// try {
		repository.deleteById(id);
		return new ResponseEntity<Boolean>(true, HttpStatus.ACCEPTED);
		// } catch (Exception e) {
		// e.printStackTrace();
		// return new ResponseEntity<Boolean>(false, HttpStatus.BAD_REQUEST);
		// }
	}

	public List getSubModulesNameDropdown(int countryid, int productid, int domainid, int subdomainid, int moduleid)
			throws Exception {
		// TODO Auto-generated method stub
		return repository.getSubModulesNameDropdown(countryid, productid, domainid, subdomainid, moduleid);

	}

}
