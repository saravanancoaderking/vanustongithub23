package com.medeil.controller;

/*************************************************************************
 * 
 * Vanuston CONFIDENTIAL
 * __________________
 * 
 *  [2009] - [2019] Vanuston Intelligence Pvt.Ltd  
 *  All Rights Reserved.
 * 
 * NOTICE:  All information contained herein is, and remains
 * the property of Vanuston Intelligence Pvt.Ltd and its suppliers,
 * if any.  The intellectual and technical concepts contained
 * herein are proprietary to Vanuston Intelligence Pvt.Ltd
 * and its suppliers and may be covered by Indian and Foreign Patents,
 * patents in process, and are protected by trade secret or copyright law.
 * Dissemination of this information or reproduction of this material
 * is strictly forbidden unless prior written permission is obtained
 * from Vanuston Intelligence Pvt.Ltd.
 */
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.medeil.domain.EnableOrDisableSms;
import com.medeil.domain.TwilioAccount;
import com.medeil.service.SMSSettingService;

/**
 * 
 * @author Boopalan Alagesan
 * @Date 09-03-2020
 *
 */

@RestController
@RequestMapping("api/twilio")
public class SMSSettingController {
	@Autowired
	SMSSettingService SMSSettingServices;

	/**
	 *
	 * This Api created for sending sms using twilio Account
	 * 
	 * @param ACCOUNT_SID
	 * @param AUTH_TOKEN
	 * @param Sender
	 * @param Receiver
	 * @param Messages
	 * @param compid
	 * @param branchid
	 * @param locname
	 * @param locrefid
	 * @param clientcdate
	 * @param twlid
	 * @param formid
	 * @return
	 */
	@GetMapping(value = "send-twilio-sms/{ACCOUNT_SID}/{AUTH_TOKEN}/{Sender}/{Receiver}/{Messages}/{compid}/{branchid}/{locname}/{locrefid}/{clientcdate}/{twlid}/{formid}")
	public boolean twilioSMS(@PathVariable String ACCOUNT_SID, @PathVariable String AUTH_TOKEN,
			@PathVariable String Sender, @PathVariable String Receiver, @PathVariable String Messages,
			@PathVariable int compid, @PathVariable int branchid, @PathVariable int locname, @PathVariable int locrefid,
			@PathVariable String clientcdate, @PathVariable int twlid, @PathVariable int formid) throws Exception {

		try {

			return SMSSettingServices.twilioSMS(ACCOUNT_SID, AUTH_TOKEN, Sender, Receiver, Messages, compid, branchid,
					locname, locrefid, clientcdate, twlid, formid);
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e);
		}
		// return false;

	}

	/**
	 * To get Twilio Sms Account Details of the Company
	 * 
	 * @param companyrefid
	 * @return
	 */
	@GetMapping(value = "/get-sms-account-details/{companyrefid}")
	public List getSMSAccountDetails(@PathVariable int companyrefid) throws Exception {
		return SMSSettingServices.getSMSAccountDetails(companyrefid);

	}

	/**
	 * To Save Twilio Sms Account Details of the company
	 * 
	 * @param twilioAccount
	 * @return
	 */
	@PostMapping(value = "save-twilio-sms-account")
	public boolean saveTwilioSmsAccount(@RequestBody TwilioAccount twilioAccount) throws Exception {
		return SMSSettingServices.saveTwilioSmsAccount(twilioAccount);

	}

	/**
	 * To view Sms Logs Of the company
	 * 
	 * @param companyrefid
	 * @return
	 */
	@GetMapping(value = "/view-sms-logs-companywise/{companyrefid}")
	public Map viewSMSLogscompanywise(@PathVariable int companyrefid) throws Exception {
		return SMSSettingServices.viewSMSLogscompanywise(companyrefid);

	}

	/**
	 * To view Sms logs of the shop
	 * 
	 * @param companyrefid
	 * @param branchid
	 * @param locname
	 * @param locrefid
	 * @return
	 */

	@GetMapping(value = "/view-sms-logs-shopwise/{companyrefid}/{branchid}/{locname}/{locrefid}")
	public Map viewSMSLogsshopwise(@PathVariable int companyrefid, @PathVariable Integer branchid,
			@PathVariable Integer locname, @PathVariable Integer locrefid) throws Exception {
		return SMSSettingServices.viewSMSLogsshopwise(companyrefid, branchid, locname, locrefid);

	}

	/**
	 * To enable or disable sms feature on form level
	 * 
	 * @param enableOrDisableSms
	 * @return
	 */
	@PostMapping(value = "save-enable-or-disable-sms")
	public boolean saveEnableOrDisable(@RequestBody List<EnableOrDisableSms> enableOrDisableSms) throws Exception {
		return SMSSettingServices.saveEnableOrDisable(enableOrDisableSms);

	}

	/**
	 * To view enable or disable status of company
	 * 
	 * @param companyrefid
	 * @return
	 */
	@GetMapping(value = "/view-enable-status/{companyrefid}")
	public List viewEnableStatus(@PathVariable int companyrefid) throws Exception {
		return SMSSettingServices.viewEnableStatus(companyrefid);

	}
	
	//puthiran view default sms Forms
	@GetMapping(value = "/view-sms-default-forms")
	public List viewDefaultSMSForms() throws Exception {
		return SMSSettingServices.viewDefaultSMSForms();

	}
	
	//Create Default Settings
	@PostMapping(value = "createdefaultsmssettings")
	public ResponseEntity<Boolean> CreateDefaultSmsSettings(@RequestBody List<EnableOrDisableSms> enableOrDisableSms) throws Exception {
		return SMSSettingServices.CreateDefaultSmsSettings(enableOrDisableSms);
	}		
		
	/**
	 * To get status of salesorder form, whether it is enabled or disabled
	 * 
	 * @param companyrefid
	 * @return
	 */
	@GetMapping(value = "/get-enable-status-salesorder/{companyrefid}")
	public boolean getEnableStatusSalesOrder(@PathVariable int companyrefid) throws Exception {
		return SMSSettingServices.getEnableStatusSalesOrder(companyrefid);

	}

	/**
	 * To get status of salesinvoice form, whether it is enabled or disabled
	 * 
	 * @param companyrefid
	 * @return
	 */
	@GetMapping(value = "/get-enable-status-salesinvoice/{companyrefid}")
	public boolean getEnableStatusSalesInvoice(@PathVariable int companyrefid) throws Exception {
		return SMSSettingServices.getEnableStatusSalesInvoice(companyrefid);

	}

	/**
	 * To get status of purchaseorder form, whether it is enabled or disabled
	 * 
	 * @param companyrefid
	 * @return
	 */
	@GetMapping(value = "/get-enable-status-purchaseorder/{companyrefid}")
	public boolean getEnableStatusPurchaseOrder(@PathVariable int companyrefid) throws Exception {
		return SMSSettingServices.getEnableStatusPurchaseOrder(companyrefid);

	}

	/**
	 * To get status of purchaseinvoice form, whether it is enabled or disabled
	 * 
	 * @param companyrefid
	 * @return
	 */
	@GetMapping(value = "/get-enable-status-purchaseinvoice/{companyrefid}")
	public boolean getEnableStatusPurchaseInvoice(@PathVariable int companyrefid) throws Exception {
		return SMSSettingServices.getEnableStatusPurchaseInvoice(companyrefid);

	}

	/**
	 * To get status of TwoFactorAuthentication form, whether it is enabled or
	 * disabled
	 * 
	 * @param companyrefid
	 * @return
	 */
	@GetMapping(value = "/get-enable-status-TwoFactorAuthentication/{companyrefid}")
	public boolean getEnableTwoFactorAuthentication(@PathVariable int companyrefid) throws Exception {
		return SMSSettingServices.getEnableTwoFactorAuthentication(companyrefid);

	}

	/**
	 * To get status of OTPVerification form, whether it is enabled or disabled
	 * 
	 * @param companyrefid
	 * @return
	 */
	@GetMapping(value = "/get-enable-status-OTPVerification/{companyrefid}")
	public boolean getEnableOTPVerification(@PathVariable int companyrefid) throws Exception {
		return SMSSettingServices.getEnableOTPVerification(companyrefid);

	}

	/**
	 * To get overall count of sent sms formwise
	 * 
	 * @param companyrefid
	 * @return
	 */
	@GetMapping(value = "/get-alltime-sms-pie-chart-formwise/{companyrefid}")
	public List getSmsPieChartFormwise(@PathVariable int companyrefid) throws Exception {
		return SMSSettingServices.getSmsPieChartFormwise(companyrefid);

	}

	/**
	 * To get overall count of sent sms formwise for particular form
	 * 
	 * @param companyrefid
	 * @param formid
	 * @return
	 */
	@GetMapping(value = "/get-alltime-sms-pie-chart-formwise/{companyrefid}/{formid}")
	public List getSmsLogsPieChartFormwise(@PathVariable int companyrefid, @PathVariable int formid) throws Exception {
		return SMSSettingServices.getSmsLogsPieChartFormwise(companyrefid, formid);

	}

	/**
	 * to get one month sms segments of company
	 * 
	 * @param companyrefid
	 * @return
	 */
//	@GetMapping(value = "/get-onemonth-sms-segments/{companyrefid}")
//	public List getOneMonthSmsSegments(@PathVariable int companyrefid) {
//		return SMSSettingServices.getOneMonthSmsSegments(companyrefid);
//
//	}

	/**
	 * to get overall sms segments of company all time, month and year wise
	 * 
	 * @param companyrefid
	 * @return
	 */
	@GetMapping(value = "/get-alltime-sms-segments/{companyrefid}")
	public List getAllTimeMonthSmsSegments(@PathVariable int companyrefid) throws Exception {
		return SMSSettingServices.getAllTimeMonthSmsSegments(companyrefid);

	}

	/**
	 * to get overall sum of sms segments of company all time
	 * 
	 * @param companyrefid
	 * @return
	 */

//	@GetMapping(value = "/get-overall-sms-segments/{companyrefid}")
//	public List getOverAllSmsSegments(@PathVariable int companyrefid) {
//		return SMSSettingServices.getOverAllSmsSegments(companyrefid);
//
//	}

}
