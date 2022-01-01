package com.medeil.service;

import java.io.BufferedInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import com.medeil.domain.EnableorDisableEmail;
import com.medeil.domain.IndCompModel;
import com.medeil.repository.EnableorDisableEmailRepository;

@Service
public class EmailService {
	@Autowired
	private JavaMailSender sender;
	
	@Autowired
	EnableorDisableEmailRepository enableOrDisableEmailRepository;

	public String sendMailPurchaseOrder(IndCompModel model) throws MessagingException, IOException {
		MimeMessage message = sender.createMimeMessage();
		MimeMessageHelper helper = new MimeMessageHelper(message, true);

		try {
			String url = model.getUrl();
			System.out.println("boopalan" + " " + url);
			BufferedInputStream in = null;
			FileOutputStream fout = null;
			try {
				in = new BufferedInputStream(new URL(url).openStream());

				fout = new FileOutputStream(
						"C:\\Users\\Administrator\\Desktop\\Final Project\\medeil\\BIRTREPORT\\Purchase_Order.pdf");
				byte data[] = new byte[1024];
				int count;
				while ((count = in.read(data, 0, 1024)) != -1) {
					fout.write(data, 0, count);
				}
			} finally {
				if (in != null)
					in.close();
				if (fout != null)
					fout.close();
			}

			helper.setTo(model.getEmail());
			helper.setText("Dear Distributor" + " ,\r\n" + "\r\n"
					+ "Greetings from Emedsure! This is an order for the merchandise. A copy of the purchase order details has been attached along with this email.\r\n"
					+ "\r\n" + "Sincerely,\r\n" + "Emedsure Pharmacy\r\n" + "4F, government Central Building\r\n"
					+ "Palayan - 103209\r\n" + "Contact: +63 24893974\r\n" + "E-mail : helpline@emedsure.com\r\n"
					+ "VAT REG TIN : TRA00125");
			helper.setSubject("Purchase Order from Emedsure Pharmacy");
			// ClassPathResource file = new ClassPathResource("invoice.pdf");
			// helper.addAttachment("invoice.pdf", file);
			String filename = "C:\\Users\\Administrator\\Desktop\\Final Project\\medeil\\BIRTREPORT\\Purchase_Order.pdf";
			DataSource source = new FileDataSource(filename);
			helper.addAttachment("Purchase_Order.pdf", source);
		} catch (MessagingException e) {
		//	e.printStackTrace();
		//	return "Error while sending mail ..";
			throw new MessagingException();
		}
		sender.send(message);
		return "Mail Sent Success!";
	}

	public String sendMailPriceEnquiry(IndCompModel model) throws MessagingException, IOException {
		MimeMessage message = sender.createMimeMessage();
		MimeMessageHelper helper = new MimeMessageHelper(message, true);

		try {

			String url = model.getUrl();
			System.out.println("boopalan" + " " + url);
			BufferedInputStream in = null;
			FileOutputStream fout = null;
			try {
				in = new BufferedInputStream(new URL(url).openStream());

				fout = new FileOutputStream(
						"C:\\Users\\Administrator\\Desktop\\Final Project\\medeil\\BIRTREPORT\\Purchase_Enquiry.pdf");
				byte data[] = new byte[1024];
				int count;
				while ((count = in.read(data, 0, 1024)) != -1) {
					fout.write(data, 0, count);
				}
			} finally {
				if (in != null)
					in.close();
				if (fout != null)
					fout.close();
			}

			helper.setTo(model.getEmail());
			helper.setText("Dear Distributor" + " ,\r\n" + "\r\n"
					+ "Greetings from Emedsure! This is an order for the merchandise. A copy of the Purchase Enquiry details has been attached along with this email.\r\n"
					+ "\r\n" + "Sincerely,\r\n" + "Emedsure Pharmacy\r\n" + "4F, government Central Building\r\n"
					+ "Palayan - 103209\r\n" + "Contact: +63 24893974\r\n" + "E-mail : helpline@emedsure.com\r\n"
					+ "VAT REG TIN : TRA00125");
			helper.setSubject("Purchase Enquiry from Emedsure Pharmacy");
			// ClassPathResource file = new ClassPathResource("invoice.pdf");
			// helper.addAttachment("invoice.pdf", file);
			String filename = "C:\\Users\\Administrator\\Desktop\\Final Project\\medeil\\BIRTREPORT\\Purchase_Enquiry.pdf";
			DataSource source = new FileDataSource(filename);
			helper.addAttachment("Purchase_Enquiry.pdf", source);
		} catch (MessagingException e) {
			// e.printStackTrace();
			// return "Error while sending mail ..";
			throw new MessagingException();
		}
		sender.send(message);
		return "Mail Sent Success!";
	}
	
	//email setting process
	public boolean saveEnableOrDisable(List<EnableorDisableEmail> enableOrDisableEmail) {
		try {
			enableOrDisableEmailRepository.saveAll(enableOrDisableEmail);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public ResponseEntity<Boolean> CreateDefaultEmailSettings(List<EnableorDisableEmail> enableOrDisableEmail) {
		try {
			enableOrDisableEmailRepository.saveAll(enableOrDisableEmail);
		return ResponseEntity.created(null).body(true);
		} catch (DataIntegrityViolationException e) {
		HashMap<String, String> errorMessage = new HashMap<String, String>();
		errorMessage.put("message", e.getRootCause().getMessage());
		return new ResponseEntity(errorMessage, HttpStatus.BAD_REQUEST);
		} catch (Exception e) {
		HashMap<String, String> errorMessage = new HashMap<String, String>();
		errorMessage.put("message", e.toString());
		return new ResponseEntity(errorMessage, HttpStatus.BAD_REQUEST);
		}
	}
	
	public List viewEmailEnableStatus(int companyrefid) {
		try {

			return enableOrDisableEmailRepository.viewEmailEnableStatus(companyrefid);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public boolean getEmailEnableStatusSalesInvoice(int companyrefid) {
		try {
			Object object = enableOrDisableEmailRepository.getEmailEnableStatusSalesInvoice(companyrefid).get(0);
			if (object.equals(1)) {
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
}
