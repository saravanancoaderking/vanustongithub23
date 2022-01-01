package com.medeil.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.medeil.domain.Role;
import com.medeil.repository.RoleRepository;

@SuppressWarnings("rawtypes")
@Service
public class RoleService {

	@Autowired
	private RoleRepository roleRepository;

	private static Logger logger = LogManager.getLogger();

	public List<Role> getAll() throws Exception {
		List<Role> list = new ArrayList<>();
		Iterable<Role> domain = roleRepository.findAll();
		domain.forEach(list::add);
		return list;
	}

	public List Rolelist() throws Exception {
		return roleRepository.Roleslist();
	}

	@Transactional
	public ResponseEntity<Boolean> createRole(Role role) throws Exception {
		// try {
		if (!role.equals("")) {
			roleRepository.save(role);
			String currentscopes = roleRepository.getCurrentScope();
			System.out.println(currentscopes);
			String updatedScope = currentscopes + "," + role.getRolename();
			System.out.println(updatedScope);
			roleRepository.updateCurrentScope(updatedScope);
			return ResponseEntity.created(null).body(true);
		}
		// } catch (DataIntegrityViolationException e) {
		// HashMap<String, String> errorMessage = new HashMap<String, String>();
		// errorMessage.put("message", e.getRootCause().getMessage());
		// return new ResponseEntity(errorMessage, HttpStatus.BAD_REQUEST);
		// } catch (Exception e) {
		// HashMap<String, String> errorMessage = new HashMap<String, String>();
		// errorMessage.put("message", e.toString());
		// return new ResponseEntity(errorMessage, HttpStatus.BAD_REQUEST);

		// }
		return ResponseEntity.created(null).body(false);
	}

	public boolean checkExistRole(Integer id, String name) throws Exception {
		boolean flag = false;
		// try {
		String reName = roleRepository.checkExistRole(id, name.trim());
		if (name.equalsIgnoreCase(reName)) {
			flag = true;
		} else {
			flag = false;
		}
		// } catch (Exception ex) {
		// logger.error("Exception in Method : checkExistRole : " + ex);
		// }
		return flag;
	}

	public List getCompanyName(Integer id) throws Exception {

		return roleRepository.getCompanyName(id);
	}
}
