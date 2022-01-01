/**
 * 
 */
package com.medeil.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.medeil.service.MacService;

/**
 * @author Ajith AK
 *
 */
@RestController
@RequestMapping("/api")
public class MacController {

	@Autowired
	private MacService mac;

	@SuppressWarnings("unused")
	@ResponseBody
	@RequestMapping(value = "/getclientmac")
	public String[] getMac(HttpServletRequest request) throws Exception {
		String ip = mac.getIpAddr(request);
		System.out.println("Client IP : " + ip);
		String macs = null;
		String macz[] = new String[2];
		if (ip != null || ip != "") {
			macs = mac.getMACAddress(ip);
			System.out.println("Client Mac Controller:" + macs);
			macz[0] = macs;
			macz[1] = ip;
		} else {
			System.out.println("Client Mac Error");
		}
		return macz;
	}

}
