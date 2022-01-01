package com.medeil.service;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.medeil.domain.Rolectrl;
import com.medeil.domain.UserModule;
import com.medeil.domain.Userlogin;
import com.medeil.domain.Usersubmodule;
import com.medeil.repository.RolectrlRepository;
import com.medeil.repository.UserModuleRepository;
import com.medeil.repository.UserloginRepository;
import com.medeil.repository.UsersubmoduleRepository;

@SuppressWarnings("rawtypes")
@Service
public class RolectrlService {

	@Autowired
	private RolectrlRepository rolectrlRepository;
	@Autowired
	private UserModuleRepository userModuleRepository;
	@Autowired
	private UsersubmoduleRepository usersubmoduleRepository;
	@Autowired
	UserloginRepository userloginRepository;
	private static Logger logger = LogManager.getLogger();

	public List listModule(Integer id) throws Exception {
		return rolectrlRepository.moduleList(id);
	}

	public List subModule(Integer id) throws Exception {
		return rolectrlRepository.submoduleList(id);
	}

	public String setRole(Integer id) throws Exception {
		return rolectrlRepository.setRole(id);
	}

	public void ctrlRole(List<Rolectrl> rolectrl) throws Exception {
		for (int i = 0; i < rolectrl.size(); i++) {
			rolectrlRepository.save(rolectrl.get(i));
		}
	}

	public Boolean isExistRole(Integer rid, Integer mid) throws Exception {
		boolean reFlag = false;
		// try {
		Integer reVal = rolectrlRepository.isExistRole(rid, mid);
		if (reVal == 0) {
			reFlag = true;
		} else {
			rolectrlRepository.delisExistRole(rid, mid);
			reFlag = true;
		}
		// } catch (Exception e) {
		// logger.error("Exception in Method : isExistRole : " + e);
		// }
		return reFlag;
	}

	public List getAssignRole(Integer id) throws Exception {
		return rolectrlRepository.getAssignRole(id);
	}

	public void delAssignRole(Integer id) throws Exception {
		rolectrlRepository.delAssignRole(id);
	}

	public ResponseEntity<Boolean> saveRolectrl(List<Rolectrl> rolectrls) throws Exception {
		// try {
		for (Rolectrl rolectrl : rolectrls) {
			boolean existsuser = rolectrlRepository.existsByRoleidAndModuleidAndSubmoduleid(rolectrl.getRoleid(),
					rolectrl.getModuleid(), rolectrl.getSubmoduleid());
			if (existsuser == true) {
			} else {
				rolectrlRepository.save(rolectrl);
			}
		}
		List<Userlogin> existingUserByRole = userloginRepository.findByRolerefid(rolectrls.get(0).getRoleid());
		boolean isempty = existingUserByRole.isEmpty();
		if (isempty) {
			return ResponseEntity.created(null).body(true);
		} else {
			updateUserSubmoduleByRoleID(rolectrls, existingUserByRole);
			updateUserModuleByRoleID(rolectrls, existingUserByRole);
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
	}

	private void updateUserSubmoduleByRoleID(List<Rolectrl> rolectrls, List<Userlogin> existingUserByRole)
			throws Exception {
		existingUserByRole.forEach(p -> {
			rolectrls.forEach(q -> {
				boolean existsuser = usersubmoduleRepository.existsBySuserrefidAndSubmoduleid(p.getId(),
						q.getSubmoduleid());
				if (existsuser == true) {
				} else {
					Usersubmodule usersubmodule = new Usersubmodule();
					usersubmodule.setSuserrefid(p.getId());
					usersubmodule.setModuleid(q.getModuleid());
					usersubmodule.setSubmoduleid(q.getSubmoduleid());
					usersubmodule.setEditionid(rolectrls.get(0).getEditionid());
//					usersubmodule.setRanking(rolectrls.indexOf(p));
					usersubmoduleRepository.save(usersubmodule);
				}
			});

		});
	}

	private void updateUserModuleByRoleID(List<Rolectrl> rolectrls, List<Userlogin> existingUserByRole)
			throws Exception {
		existingUserByRole.forEach(p -> {
			rolectrls.forEach(q -> {
				boolean existsuser = userModuleRepository.existsBySuserrefidAndModuleid(p.getId(), q.getModuleid());
				if (existsuser == true) {
				} else {
					UserModule usermodule = new UserModule();
					usermodule.setSuserrefid(p.getId());
					usermodule.setModuleid(q.getModuleid());
					usermodule.setEditionid(rolectrls.get(0).getEditionid());
					userModuleRepository.save(usermodule);
				}

			});

		});
	}
}
