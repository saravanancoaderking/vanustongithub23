package com.medeil.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.transaction.Transactional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.medeil.domain.MedcAdduser;
import com.medeil.domain.UserPasswordHistory;
import com.medeil.domain.UserReference;
import com.medeil.domain.Userlogin;
import com.medeil.repository.MedcAdduserRepository;
import com.medeil.repository.UserLoginHistoryRepository;
import com.medeil.repository.UserPasswordHistoryRepository;
import com.medeil.repository.UserloginRepository;

@SuppressWarnings("rawtypes")
@Service
public class UserloginService {
	@Autowired
	private PasswordEncoder passwordEncoder;
	@Autowired
	private UserloginRepository userloginRepository;
	@Autowired
	UserPasswordHistoryRepository userPasswordHistoryRepository;
	@Autowired
	MedcAdduserRepository medcAdduserRepository;
	@Autowired
	UserLoginHistoryRepository userLoginHistoryRepository;
	List list = null;
	private static Logger logger = LogManager.getLogger();

	@SuppressWarnings("unchecked")
	public List Login(String username, String password, Integer companyId) throws Exception {

		List submodule = null;
		List lastList = new ArrayList();
		try {
			int activeuser = userloginRepository.activeuser(username, password, companyId);
			System.out.println(activeuser);
			if (activeuser == 0) { // 1
				System.out.println("activeuser" + activeuser);
				List modules = userloginRepository.modules(username, password, companyId);
				List moduleLabel = null;
				List addList = new ArrayList();
				List sublist = new ArrayList();
				List list = new ArrayList();
				for (int i = 0; i < modules.size(); i++) {
					submodule = userloginRepository.submodules(username, password, modules.get(i));
					moduleLabel = userloginRepository.getModulelabel(username, password, modules.get(i), companyId);
					addList.add(modules.get(i));
					addList.add(submodule);
					addList.add(moduleLabel);
				}
				for (int start = 0; start < addList.size(); start += 3) {
					int end = Math.min(start + 3, addList.size());
					sublist = addList.subList(start, end);
					list.add(sublist);
				}
				lastList.addAll(list);
				System.out.println("Final Module:" + lastList);
			} else {
				lastList = null;
			}
		} catch (Exception e) {
			System.out.println("Exception user login :" + e);
			throw new Exception(e);
		}
		return lastList;
	}

	/*
	 * //padmini public boolean usersecondprocess() { boolean flag=false;
	 * 
	 * 
	 * 
	 * }
	 */

	public List getLabel(String username, String password, Integer companyId) throws Exception {
		// list = null;
		// try {
		int index = password.lastIndexOf("_");
		String pass = password.substring(2, index);
		return userloginRepository.getModulelabels(username, pass.replaceAll("_", "").trim(), companyId);
		// } catch (Exception e) {
		// System.out.println("Exception user getLabel :" + e);
		// }
		// return list;
	}

	public List existsUser(String username, String password, Integer companyId) throws Exception {
		// list = null;
		// try {
		int index = password.lastIndexOf("_");
		String pass = password.substring(2, index);
		return userloginRepository.existsUser(username, pass.replaceAll("_", "").trim(), companyId);
		// } catch (Exception e) {
		// System.out.println("Exception existsUser:" + e);
		// }
		// return list;
	}

	@Transactional
	public ResponseEntity<Boolean> userLogin(Userlogin userlogin) throws Exception {
		Integer reVal = userloginRepository.userId();
		String uType = userloginRepository.getUserType(userlogin.getRolerefid());
		// try {
		userlogin.setCuserrefid(reVal);
		userlogin.setUsertype(uType);
		if (!userlogin.equals("") || !userlogin.equals(null)) {
			userloginRepository.save(userlogin);
			return ResponseEntity.created(null).body(true);
		} else {
			return ResponseEntity.created(null).body(false);
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

	public List getLoginBranch(Integer cid, Integer uid) throws Exception {
		// list = null;
		// try {
		return userloginRepository.getLoginBranch(cid, uid);
		// } catch (Exception e) {
		// System.out.println("Exception getLoginBranch:" + e);
		// }
		// return list;
	}

	public List getLoginShop(Integer cid, Integer bid, Integer uid) throws Exception {
		// list = null;
		// try {
		return userloginRepository.getLoginShop(cid, bid, uid);
		// } catch (Exception e) {
		// System.out.println("Exception getLoginShop:" + e);
		// }
		// return list;
	}

	public List getLoginhospital(Integer cid, Integer bid, Integer uid) throws Exception {
		// list = null;
		// try {
		return userloginRepository.getLoginhospital(cid, bid, uid);
		// } catch (Exception e) {
		// System.out.println("Exception getLoginhospital:" + e);
		// }
		// return list;
	}

	public List getLoginWarehouse(Integer cid, Integer bid, Integer uid) throws Exception {
		// list = null;
		// try {
		return userloginRepository.getLoginWarehouse(cid, bid, uid);
		// } catch (Exception e) {
		// System.out.println("Exception getLoginWarehouse:" + e);
		// }
		// return list;
	}

	public List setLocalStorage(UserReference userReference) throws Exception {
		List<Object> ls = new ArrayList<Object>();
		try {
			String locRef = "";
			
				locRef = userloginRepository.getLocRef(userReference.getLocname());
				String[] locRefVal = locRef.split(",");
				userReference.setLocationid(Integer.parseInt(locRefVal[0]));
				userReference.setLocname(locRefVal[1]);
		
			ls.add(userReference.getUserid());
			ls.add(userReference.getCompanyid());
			ls.add(userReference.getBranchid());
			ls.add(userReference.getShopid());
			ls.add(userReference.getHospitalid());
			ls.add(userReference.getWarehouseid());
			ls.add(userReference.getLocationid());
			ls.add(userReference.getLocname());
			ls.add(userReference.getDistributorid());
			ls.add(userReference.getUsertype());
			ls.add(userReference.getCountryid());
		} catch (Exception e) {
			System.out.println("setLocalStorage :" + e);
			throw new Exception(e);
		}
		return ls;
	}

	public List getuserCompany() throws Exception {
		// TODO Auto-generated method stub
		return userloginRepository.getuserCompany();
	}

	// padmini
	public List getloginuserlabel(Integer uid) throws Exception {
		// list = null;
		// try {
		return userloginRepository.getloginuserlabel(uid);
		// } catch (Exception e) {
		// System.out.println("Exception getloginuserlabel:" + e);
		// }
		// return list;
	}

	public List getModulelabels1(Integer id) throws Exception {
		// list = null;
		// try {
		return userloginRepository.getModulelabels1(id);
		// } catch (Exception e) {
		// System.out.println("Exception user getLabel :" + e);
		// }
		// return list;
	}

	@SuppressWarnings({ "unchecked" })
	public List getAuthorities(String username, Integer companyrefid) throws Exception {
		Set submodule = null;
		List lastList = new ArrayList();
		try {
			int activeuser = userloginRepository.activeuser(username, companyrefid);
			if (activeuser == 1) { // 1 Active User
				List modules = userloginRepository.modules(username, companyrefid);
				List moduleLabel = null;
				List addList = new ArrayList();
				List sublist = new ArrayList();
				List list = new ArrayList();
				for (int i = 0; i < modules.size(); i++) {
					submodule = userloginRepository.submodules(username, modules.get(i));
					moduleLabel = userloginRepository.getModulelabel(username, modules.get(i), companyrefid);
					addList.add(modules.get(i));
					addList.add(submodule);
					addList.add(moduleLabel);
				}
				for (int start = 0; start < addList.size(); start += 3) {
					int end = Math.min(start + 3, addList.size());
					sublist = addList.subList(start, end);
					list.add(sublist);
				}
				lastList.addAll(list);
				System.out.println("Final Module:" + lastList);
			} else {
				lastList = null;
			}
		} catch (Exception e) {
			System.out.println("Exception user login :" + e);
			throw new Exception(e);
		}
		return lastList;
	}

	// patinet login authorities

	// just reference
	public Map getPaitent(String username, Integer count) throws Exception {
		Map<String, Object> info = new HashMap<String, Object>();
		info.put("", userloginRepository.getPaient(username, count));
		int modelueid = userloginRepository.getmoduleid(username, count);
		int submodulecount = userloginRepository.getSubCount(username);
		for (int subcount = 0; subcount < submodulecount; subcount++) {
			info.put((String.valueOf(subcount)), userloginRepository.getSubmodule(username, modelueid, subcount));
		}

		return info;
	}

	// currently work
	@SuppressWarnings({ "unchecked" })
	public List getPaitentAuthorities(String username) throws Exception {
		List submodule = null;

		List lastList = new ArrayList();
		try {
			int activeuser = userloginRepository.user(username);
			if (activeuser == 0) {

				List modules = userloginRepository.getModules(username);

				List moduleLabel = null;
				List addList = new ArrayList();
				List sublist = new ArrayList();
				List list = new ArrayList();
				for (int i = 0; i < modules.size(); i++) {

					submodule = userloginRepository.getsubmodules(username, userloginRepository.getLables(username, i));
					addList.add(modules.get(i));
					addList.add(submodule);
					addList.add(moduleLabel);
				}
				for (int start = 0; start < addList.size(); start += 3) {
					int end = Math.min(start + 3, addList.size());
					sublist = addList.subList(start, end);
					list.add(sublist);
				}
				lastList.addAll(list);
			} else {
				lastList = null;
			}
		} catch (Exception e) {
			throw new Exception(e);
		}
		return lastList;
	}

	public List getLabel(String username, Integer companyId) throws Exception {
		// list = null;

		// try {

		return userloginRepository.getModulelabels(username, companyId);
		// } catch (Exception e) {
		// System.out.println("Exception user getLabel :" + e);
		// }
		// return list;
	}

	public Map passwordExpiryVerification(String username) throws Exception {
		HashMap<String, String> result = new HashMap<String, String>();
		Userlogin findByUsername = userloginRepository.findByUsername(username);
		if (findByUsername.getPasswordvalidity() < System.currentTimeMillis()) {
			result.put("message", "Password Expired");
			result.put("code", "true");
			return result;
		} else {
			result.put("message", "Password Not Expired");
			result.put("code", "false");
			return result;
		}
	}

	public Map resetUserPassword(String username, String password, String currentpassword) throws Exception {
		HashMap<String, String> result = new HashMap<String, String>();
		UserPasswordHistory user = new UserPasswordHistory();
		try {
			Userlogin findByUsername = userloginRepository.findByUsername(username);
			MedcAdduser findByUsername2 = medcAdduserRepository.findByUsername(username);
			String substring = findByUsername.getPassword().substring(8);
			boolean matches = passwordEncoder.matches(currentpassword, substring);
			if (matches) {
				boolean existsByUserAndHist = userPasswordHistoryRepository
						.existsByPatronAndHist(findByUsername.getId(), password);
				System.out.println(">>>>>>>>>>>" + existsByUserAndHist);
				if (existsByUserAndHist) {

					String response = "Do not use old passwords or current password!";
					result.put("message", response);
					result.put("code", "false");
					return result;

				} else {
					String encodedPassword = "{bcrypt}" + passwordEncoder.encode(password);
					findByUsername.setPassword(encodedPassword);
					findByUsername.setIsaccountnonlocked(true);
					findByUsername.setUserloginattempt(0);
					long expirytime = System.currentTimeMillis() + 15552000000l;
					findByUsername.setPasswordvalidity(expirytime);
					userloginRepository.save(findByUsername);
					user.setPatron(findByUsername.getId());
					user.setHist(password);
					System.out.println("Boopalan");
					userPasswordHistoryRepository.save(user);
					result.put("message", "Password Reset successful");
					result.put("code", "true");
					//sendMailPasswordAcknowledgment(findByUsername2.getEmailid());
					return result;
				}
			} else {
				result.put("message", "Wrong Current Password!");
				result.put("code", "false");
				return result;
			}
		} catch (Exception e) {
			result.put("message", e.getMessage());
			result.put("code", "false");
			// return result;
			throw new Exception(e);
		}

	}
//
//	/******* SendGrid Email to send USER Password Changed Acknowledgement *******/
//	public boolean sendMailPasswordAcknowledgment(String email) throws IOException {
//		Mail mail = new Mail(new Email("support@vanuston.com"), "Security alert,Your password was changed!",
//				new Email(email),
//				new Content("text/plain",
//						"Dear Customer,\r\n" + "The password for your account was changed recently.\r\n"
//								+ "If you didn't change it, you should contact our Customer Support Team.\r\n" + "\r\n"
//								+ "regards,\r\n" + "Medeil Team"));
//
//		mail.setReplyTo(new Email("vanuston.info@gmail.com"));
//		mail.from.setName("Medeil");
//
//		Request request = new Request();
//		try {
//			request.setMethod(Method.POST);
//			request.setEndpoint("mail/send");
//			request.setBody(mail.build());
//			new SendGrid("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").api(request);
//			return true;
//		} catch (IOException ex) {
//			System.out.println(ex.getMessage());
//			throw new IOException(ex);
//		}
//		// return false;
//	}

	public ResponseEntity<Map> lastVisitAndLoginHistory(int userid) throws Exception {
		Map<String, Object> lastVisitAndLoginHistory = new HashMap<String, Object>();
		String lastVisit = userLoginHistoryRepository.lastVisit(userid);

		if (lastVisit == null) {
			lastVisitAndLoginHistory.put("lastVisit", "New Login");
		} else {
			lastVisitAndLoginHistory.put("lastVisit", lastVisit);
		}
		Pageable paging = PageRequest.of(0, 10);
		List loginHistory = userLoginHistoryRepository.loginHistory(userid, paging);

		lastVisitAndLoginHistory.put("loginHistory", loginHistory);
		return new ResponseEntity<Map>(lastVisitAndLoginHistory, HttpStatus.OK);
	}

	// Get User Lock Details
	public List userlockdetails() throws Exception {
		System.out.println("userlock*****");

		return userloginRepository.getuserlockdetails();
	}

	// Update User lock to Unlock
	public boolean updateunlockdetails(Integer userid) throws Exception {
		boolean flag = false;
		System.out.println("tounlock*****");

		// try {
		userloginRepository.updateunlock(userid);
		return flag = true;
		// } catch (Exception e) {

		// }
		// return flag;
	}

	// Update User Unlock to Lock
	public boolean updatelockdetails(Integer userid) throws Exception {
		boolean flag = false;
		System.out.println("tolock*****");

		// try {
		userloginRepository.updatelock(userid);
		return flag = true;
		// } catch (Exception e) {

		// }
		// return flag;
	}

	public List loginhistory() throws Exception {
		System.out.println("Login History Service");

		return userloginRepository.getloginhistory();
	}

}
