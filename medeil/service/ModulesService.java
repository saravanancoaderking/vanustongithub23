/**
 * 
 */
package com.medeil.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.medeil.domain.Modules;
import com.medeil.repository.ModulesRepository;
import com.medeil.repository.SubmodulesRepository;

/**
 * @author
 *
 */
@SuppressWarnings("rawtypes")
@Service
public class ModulesService {

	@Autowired
	ModulesRepository repository;
	@Autowired
	SubmodulesRepository submodulesRepository;

	public List<Modules> getAll() throws Exception {

		List<Modules> list = new ArrayList<>();
		Iterable<Modules> modules = repository.findAll();
		modules.forEach(list::add);
		return list;
	}

	public List modules() throws Exception {
		return repository.modules();
	}

	public List Modulelist() throws Exception {
		return repository.Modulelist();
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

	@SuppressWarnings("unchecked")
	public ResponseEntity<Modules> postModules(Modules modules) throws Exception {
		// try {
		repository.save(modules);
		return ResponseEntity.created(null).body(modules);
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

	public Modules updateModules(Modules modules, long id) throws Exception {
		modules.setModuleid(id);
		repository.save(modules);
		return modules;
	}

	public ResponseEntity<Boolean> delete(Long id) throws Exception {
		// try {
		submodulesRepository.deleteByModulerefid(id);
		repository.deleteById(id);

		return new ResponseEntity<Boolean>(true, HttpStatus.ACCEPTED);
		// } catch (Exception e) {
		// e.printStackTrace();
		// return new ResponseEntity<Boolean>(false, HttpStatus.BAD_REQUEST);
		// }
	}

	public List getModulesFolderDropdown(int countryid, int productid, int domainid, int subdomainid) throws Exception {
		// TODO Auto-generated method stub
		return repository.getModulesFolderDropdown(countryid, productid, domainid, subdomainid);
	}

	public List getModulesNameDropdown(int countryid, int productid, int domainid, int subdomainid, String foldername)
			throws Exception {
		// TODO Auto-generated method stub
		return repository.getModulesNameDropdown(countryid, productid, domainid, subdomainid, foldername);
	}

}
