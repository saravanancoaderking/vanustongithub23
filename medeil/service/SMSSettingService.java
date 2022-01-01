package com.medeil.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.medeil.domain.EnableOrDisableSms;
import com.medeil.domain.TwilioAccount;
import com.medeil.domain.TwilioSMSlogs;
import com.medeil.repository.EnableOrDisableSmsRepository;
import com.medeil.repository.TwilioAccountRepository;
import com.medeil.repository.TwilioSMSlogsRepository;
import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;

@Service
public class SMSSettingService {
	@Autowired
	TwilioSMSlogsRepository TwilioSMSlogsRepositorys;
	@Autowired
	TwilioAccountRepository twilioAccountRepository;
	@Autowired
	EnableOrDisableSmsRepository enableOrDisableSmsRepository;

	public boolean twilioSMS(String ACCOUNT_SID, String AUTH_TOKEN, String Sender, String Receiver, String Messages,
			Integer compid, Integer branchid, Integer locname, Integer locrefid, String clientcdate, int twlid,
			int formid) throws Exception {

		try {
			Twilio.init(ACCOUNT_SID, AUTH_TOKEN);

			Message message = Message.creator(new PhoneNumber(Receiver), // to
					new PhoneNumber(Sender), // from
					Messages).create();
			System.out.println(message.getSid());
			Thread.sleep(15000);
			message = Message.fetcher(message.getSid()).fetch();
			TwilioSMSlogs TwilioSMSlogss = new TwilioSMSlogs();
			TwilioSMSlogss.setAccount_sid(message.getAccountSid());
			TwilioSMSlogss.setApi_version(message.getApiVersion());
			TwilioSMSlogss.setBody(message.getBody());
			TwilioSMSlogss.setDirection(message.getDirection().toString());
			TwilioSMSlogss.setFromnumber(message.getFrom().toString());
			TwilioSMSlogss.setSid(message.getSid());
			TwilioSMSlogss.setStatus(message.getStatus().toString());
			TwilioSMSlogss.setTonumber(message.getTo().toString());
			TwilioSMSlogss.setCompanyrefid(compid);
			TwilioSMSlogss.setBranchrefid(branchid);
			TwilioSMSlogss.setLocname(locname);
			TwilioSMSlogss.setLocrefid(locrefid);
			TwilioSMSlogss.setClientcdate(clientcdate);
			TwilioSMSlogss.setMessagesegments(message.getNumSegments());
			TwilioSMSlogss.setTwlid(twlid);
			TwilioSMSlogss.setFormid(formid);
			TwilioSMSlogsRepositorys.save(TwilioSMSlogss);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e);

		}
		// return false;
	}

	public List getSMSAccountDetails(int companyrefid) throws Exception {
		return TwilioSMSlogsRepositorys.getSMSAccountDetails(companyrefid);
	}

	public Map viewSMSLogscompanywise(int companyrefid) throws Exception {
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("SMSLogs", TwilioSMSlogsRepositorys.viewSMSLogscompanywise(companyrefid));
		map.put("SMSCurrentMonthCount", TwilioSMSlogsRepositorys.getOneMonthSmsSegments(companyrefid));
		map.put("OverAllSmsSegments", TwilioSMSlogsRepositorys.getOverAllSmsSegments(companyrefid));
		return map;
	}

	public Map viewSMSLogsshopwise(int companyrefid, Integer branchid, Integer locname, Integer locrefid)
			throws Exception {
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("SMSLogs", TwilioSMSlogsRepositorys.viewSMSLogsshopwise(companyrefid, branchid, locname, locrefid));
		map.put("SMSCurrentMonthCount",
				TwilioSMSlogsRepositorys.getshopOneMonthSmsSegments(companyrefid, branchid, locname, locrefid));
		map.put("OverAllSmsSegments",
				TwilioSMSlogsRepositorys.getshopOverAllSmsSegments(companyrefid, branchid, locname, locrefid));
		return map;
	}

	public boolean saveTwilioSmsAccount(TwilioAccount twilioAccount) throws Exception {
		// try {
		twilioAccount.setSmsproid(1);
		twilioAccountRepository.save(twilioAccount);
		return true;
		// } catch (Exception e) {
		// e.printStackTrace();
		// }
		// return false;
	}

	public boolean saveEnableOrDisable(List<EnableOrDisableSms> enableOrDisableSms) throws Exception {
		// try {
		enableOrDisableSmsRepository.saveAll(enableOrDisableSms);
		return true;
		// } catch (Exception e) {
		// e.printStackTrace();
		// }
		// return false;
	}

	public boolean getEnableStatusSalesOrder(int companyrefid) throws Exception {
		// try {
		Object object = enableOrDisableSmsRepository.getEnableStatusSalesOrder(companyrefid).get(0);
		if (object.equals(1)) {
			return true;
		}
		// } catch (Exception e) {
		// e.printStackTrace();
		// throw new Exception(e);
		// }
		return false;
	}

	public boolean getEnableStatusSalesInvoice(int companyrefid) throws Exception {
		// try {
		Object object = enableOrDisableSmsRepository.getEnableStatusSalesInvoice(companyrefid).get(0);
		if (object.equals(1)) {
			return true;
		}
		// } catch (Exception e) {
		// e.printStackTrace();
		// throw new Exception(e);
		// }
		return false;
	}

	public boolean getEnableStatusPurchaseOrder(int companyrefid) throws Exception {
		// try {
		Object object = enableOrDisableSmsRepository.getEnableStatusPurchaseOrder(companyrefid).get(0);
		if (object.equals(1)) {
			return true;
		}
		// } catch (Exception e) {
		// e.printStackTrace();
		// throw new Exception(e);
		// }
		return false;
	}

	public boolean getEnableStatusPurchaseInvoice(int companyrefid) throws Exception {
		// try {
		Object object = enableOrDisableSmsRepository.getEnableStatusPurchaseInvoice(companyrefid).get(0);
		if (object.equals(1)) {
			return true;
		}
		// } catch (Exception e) {
		// e.printStackTrace();
		// }
		return false;
	}

//	public List viewEnableStatus(int companyrefid) throws Exception {
//		// try {
//
//		return enableOrDisableSmsRepository.viewEnableStatus(companyrefid);
//		// } catch (Exception e) {
//		// e.printStackTrace();
//		// }
//		// return null;
//	}

//	public boolean getEnableTwoFactorAuthentication(int companyrefid) throws Exception {
//		// try {
//		Object object = enableOrDisableSmsRepository.getEnableTwoFactorAuthentication(companyrefid).get(0);
//		if (object.equals(1)) {
//			return true;
//		}
//		// } catch (Exception e) {
//		// e.printStackTrace();
//		// }
//		return false;
//	}

//	public boolean getEnableOTPVerification(int companyrefid) throws Exception {
//		// try {
//		Object object = enableOrDisableSmsRepository.getEnableOTPVerification(companyrefid).get(0);
//		if (object.equals(1)) {
//			return true;
//		}
//		// } catch (Exception e) {
//		// e.printStackTrace();
//		// }
//		return false;
//	}


	public List viewEnableStatus(int companyrefid) throws Exception{
		try {

			return enableOrDisableSmsRepository.viewEnableStatus(companyrefid);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public List viewDefaultSMSForms()throws Exception {
		try {
			return enableOrDisableSmsRepository.viewDefaultSMSForms();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public ResponseEntity<Boolean> CreateDefaultSmsSettings(List<EnableOrDisableSms> enableOrDisableSms)throws Exception {
//		try {
			enableOrDisableSmsRepository.saveAll(enableOrDisableSms);
		return ResponseEntity.created(null).body(true);
//		} catch (DataIntegrityViolationException e) {
//		HashMap<String, String> errorMessage = new HashMap<String, String>();
//		errorMessage.put("message", e.getRootCause().getMessage());
//		return new ResponseEntity(errorMessage, HttpStatus.BAD_REQUEST);
//		} catch (Exception e) {
//		HashMap<String, String> errorMessage = new HashMap<String, String>();
//		errorMessage.put("message", e.toString());
//		return new ResponseEntity(errorMessage, HttpStatus.BAD_REQUEST);
//	}
	}

	public boolean getEnableTwoFactorAuthentication(int companyrefid) throws Exception{
		try {
			Object object = enableOrDisableSmsRepository.getEnableTwoFactorAuthentication(companyrefid).get(0);
			if (object.equals(1)) {
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	public boolean getEnableOTPVerification(int companyrefid)throws Exception {
		try {
			Object object = enableOrDisableSmsRepository.getEnableOTPVerification(companyrefid).get(0);
			if (object.equals(1)) {
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	public List getSmsPieChartFormwise(int companyrefid) throws Exception{
		return TwilioSMSlogsRepositorys.getSmsPieChartFormwise(companyrefid);
	}

	public List getSmsLogsPieChartFormwise(int companyrefid, int formid) throws Exception {
		// TODO Auto-generated method stub
		return TwilioSMSlogsRepositorys.getSmsLogsPieChartFormwise(companyrefid, formid);
	}

//	public List getOneMonthSmsSegments(int companyrefid) {
//		return TwilioSMSlogsRepositorys.getOneMonthSmsSegments(companyrefid);
//	}

	public List getAllTimeMonthSmsSegments(int companyrefid) throws Exception {
		return TwilioSMSlogsRepositorys.getAllTimeMonthSmsSegments(companyrefid);
	}

//	public List getOverAllSmsSegments(int companyrefid) {
//		return TwilioSMSlogsRepositorys.getOverAllSmsSegments(companyrefid);
//	}

}
