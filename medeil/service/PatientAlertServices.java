package com.medeil.service;

import java.rmi.RemoteException;
import java.util.List;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.medeil.domain.PatientAlert;
import com.medeil.repository.PatientAlertRepository;

@SuppressWarnings("rawtypes")
@Service
public class PatientAlertServices {

	private static Logger logger = LogManager.getLogger();
	@Autowired
	PatientAlertRepository patientAlertRepository;
	List list = null;

	public List getCompanies() throws Exception {
		return patientAlertRepository.getCompanies();
	}

	public List getBranches(int compId) throws Exception {
		return patientAlertRepository.getBranches(compId);
	}

	public List getShops(int brnch) throws Exception {
		return patientAlertRepository.getShops(brnch);
	}

	public List getWarehouse(int brnch) throws Exception {
		return patientAlertRepository.getWareHouse(brnch);
	}

	public List getHospital(int brnch) throws Exception {
		return patientAlertRepository.getHospital(brnch);
	}

	public List getCompanyPatient(int compid) throws Exception {
		return patientAlertRepository.getCompanyPatient(compid);
	}

	public List getBranchPatient(int compid, int brncid) throws Exception {
		return patientAlertRepository.getBranchPatient(compid, brncid);
	}

	public List getFirmPatient(int compid, int brncid, int locid) throws Exception {
		return patientAlertRepository.getFirmPatient(compid, brncid, locid);
	}

	public List getPatientInfo(int empid) throws Exception {
		return patientAlertRepository.getPatientInfo(empid);
	}

	public boolean getEmail(String mail, String messsage) throws RemoteException, Exception {
		boolean flag = false;
		Properties props = new Properties();
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.socketFactory.port", "465");
		props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.port", "465");
		Session session = Session.getDefaultInstance(props, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication("manikandanrajendiran1991@gmail.com", "9944899168");
			}
		});
		try {
			String str = "Message :  " + messsage;
			MimeMessage message = new MimeMessage(session);
			message.addRecipient(Message.RecipientType.TO, new InternetAddress(mail));
			message.setSubject(" Welcome");
			message.setText(str);
			Transport.send(message);
			flag = true;
		} catch (Exception e) {
			flag = false;
			logger.error("Exception In Method : getEmail() : " + e);
			throw new Exception(e);
		}
		return flag;
	}

	public PatientAlert saveMessageAlert(PatientAlert patient) throws Exception {
		// PatientAlert br = null;
		// try {
		// br = patientAlertRepository.save(patient);
		// } catch (Exception e) {
		// logger.error("Exception in Method : SavePatientAlert() " + e);
		// }
		return patientAlertRepository.save(patient);
	}

	public List viewPatientAlert(int comp, int brnch, int loc, int locref) throws Exception {
		return patientAlertRepository.viewPatientAlert(comp, brnch, loc, locref);
	}

}
