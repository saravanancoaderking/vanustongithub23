/**
 * 
 */
package com.medeil.service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.rmi.RemoteException;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.medeil.repository.SmsRepository;

/**
 * @author Ajith Kumar
 *
 */
@Service
public class SmsService {

	@Autowired
	private SmsRepository smsRepository;

	private static Logger logger = LogManager.getLogger();

	public String SMSSender(String mobile, String message) throws Exception {
		String rsp1 = "";
		try {
			if (mobile.trim().length() <= 0) {
				System.out.println("Empty Mobile Number Exception");
			}
			String retval = "";
			String rsp = "";
			String retval1 = "";
			String mobilenum = mobile;
			String msg = message;
			String senderid = "";
			String username = "";
			String apikey = "";
			String urlenco = "http://trans.medeilplus.com/api/sendsms.php?user=" + URLEncoder.encode(username, "UTF8")
					+ "&apikey=" + URLEncoder.encode(apikey, "UTF8") + "&mobile=" + URLEncoder.encode(mobilenum, "UTF8")
					+ "&message=" + URLEncoder.encode(msg, "UTF8") + "&senderid=" + URLEncoder.encode(senderid, "UTF8")
					+ "&type=txt";
			URL url = new URL(urlenco);
			URLConnection conn = url.openConnection();
			BufferedReader connection = new BufferedReader(new InputStreamReader(conn.getInputStream()));
			String line;
			while ((line = connection.readLine()) != null) {
				retval += line;
				System.out.println("message confiramation");
				System.out.println(retval);
			}
			connection.close();
			rsp = retval;
			String urlresp = "http://smshorizon.co.in/api/status.php?user=" + URLEncoder.encode(username, "UTF8")
					+ "&apikey=" + URLEncoder.encode(apikey, "UTF8") + "&msgid=" + URLEncoder.encode(rsp, "UTF8");
			URL urlres = new URL(urlresp);
			URLConnection connres = urlres.openConnection();
			BufferedReader connection1 = new BufferedReader(new InputStreamReader(connres.getInputStream()));
			String lineRes;
			while ((lineRes = connection1.readLine()) != null) {
				retval1 += lineRes;
				System.out.println(retval1);
			}
			connection1.close();
			rsp1 = retval1;
		} catch (Exception e) {
			rsp1 = "connection exception";
			System.out.println("exception");
			System.out.println(e);
			throw new Exception(e);
		}
		return rsp1;
	}

	public void getEmail(String mail, Integer otpcode) throws RemoteException, Exception {
		Properties props = new Properties();
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.socketFactory.port", "465");
		props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.port", "465");
		Session session = Session.getDefaultInstance(props, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication("medeilstock@gmail.com", "32309105030");
			}
		});
		try {
			String str = "Verfication Code :  " + otpcode;
			MimeMessage message = new MimeMessage(session);
			message.addRecipient(Message.RecipientType.TO, new InternetAddress(mail));
			message.setSubject(" One-Time-Code for You ");
			message.setText(str);
			Transport.send(message);
		} catch (MessagingException e) {
			logger.error("Exception In Method : getEmail() : " + e);
			// throw new RuntimeException(e);
			throw new Exception(e);
		}
	}

	public boolean checkPhonenumber(Integer id, String uname, String phone) throws Exception {
		boolean reFlag = false;
		try {
			String reValue = smsRepository.checkPhonenumber(id, uname);
			if (phone.equalsIgnoreCase(reValue)) {
				reFlag = true;
			} else {
				reFlag = false;
			}
		} catch (Exception e) {
			logger.error("Exception in Method : checkPhonenumber() : " + e);
			throw new Exception(e);
		}
		return reFlag;
	}

	public boolean checkEmailaddress(Integer id, String uname, String email) throws Exception {
		boolean reFlag = false;
		try {
			String reValue = smsRepository.checkEmailaddress(id, uname);
			if (email.equalsIgnoreCase(reValue)) {
				reFlag = true;
			} else {
				reFlag = false;
			}
		} catch (Exception e) {
			logger.error("Exception in Method : checkEmailaddress() : " + e);
			throw new Exception(e);
		}
		return reFlag;
	}

	public boolean updatePassword(Integer cid, String uname, String password) throws Exception {
		boolean passFlag = false;
		try {
			Integer returnId = smsRepository.updatePassword(cid, uname, password);
			if (returnId == 1) {
				passFlag = true;
			}
		} catch (Exception e) {
			logger.error("Exception In Method : updatePassword() : " + e);
			throw new Exception(e);
		}
		return passFlag;
	}

}
