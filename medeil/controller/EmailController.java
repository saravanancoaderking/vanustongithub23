package com.medeil.controller;

import java.io.BufferedInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.medeil.domain.EnableorDisableEmail;
import com.medeil.domain.IndCompModel;
import com.medeil.service.EmailService;

@RestController
@RequestMapping("/api")
public class EmailController {

	@Autowired
	private JavaMailSender sender;
	@Autowired
	private EmailService emailService;

	@ResponseBody
	@RequestMapping(value = "/sendMailAttachment", method = RequestMethod.POST)
	public String sendMailAttachment(@RequestBody IndCompModel model) throws Exception {
		MimeMessage message = sender.createMimeMessage();
		MimeMessageHelper helper = new MimeMessageHelper(message, true);

		DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
		Date dateobj = new Date();
		System.out.println(df.format(dateobj));

		try {

			String url = model.getUrl();
			// String url =
			// "http://3.6.8.66/birt/frameset?__report=MedeilReports/Bill_CashPrint123/Cash_Bill.rptdesign&salesrefid=1&__format=PDF";
			System.out.println("boopalan" + " " + url);
			BufferedInputStream in = null;
			FileOutputStream fout = null;
			try {
				in = new BufferedInputStream(new URL(url).openStream());

				fout = new FileOutputStream(
						"C:\\Users\\Administrator\\Desktop\\Final Project\\medeil\\BIRTREPORT\\invoice.jpeg");
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
			helper.setText("Dear " + model.getCustomername() + " ,\r\n" + "\r\n"
					+ "Greetings from Emedsure! Thanks for Purchasing with Us. We appreciate your payment. A copy of the invoice has been attached along with this email.\r\n"
					+ "\r\n" + "Invoice Number :" + model.getCustinvoiceno() + " \r\n" + "Invoice Date : " + dateobj
					+ "\r\n" + "Amount :" + model.getGrandtotal() + " \r\n" + "\r\n" + "Sincerely,\r\n"
					+ "Emedsure Pharmacy\r\n" + "4F, government Central Building\r\n" + "Palayan - 103209\r\n"
					+ "Contact: +63 24893974\r\n" + "E-mail : helpline@emedsure.com\r\n" + "VAT REG TIN : TRA00125");
			helper.setSubject("Invoice #" + model.getCustinvoiceno() + " from Emedsure Pharmacy");
			helper.setSubject("Invoice #" + model.getCustinvoiceno() + " from Emedsure Pharmacy");
			// ClassPathResource file = new ClassPathResource("invoice.pdf");
			// helper.addAttachment("invoice.pdf", file);
			String filename = "C:\\Users\\Administrator\\Desktop\\Final Project\\medeil\\BIRTREPORT\\invoice.pdf";
			DataSource source = new FileDataSource(filename);
			helper.addAttachment("invoice.pdf", source);
		} catch (MessagingException e) {
		//	e.printStackTrace();
		//	return "Error while sending mail ..";
			throw new Exception(e);
		}
		sender.send(message);
		return "Mail Sent Success!";
	}

	@ResponseBody
	@RequestMapping(value = "/sendMailPurchaseOrder", method = RequestMethod.POST)
	public String sendMailPurchaseOrder(@RequestBody IndCompModel model) throws MessagingException, IOException {
		return emailService.sendMailPurchaseOrder(model);
	}
	

	//Puthiran Email settings process
	@PostMapping(value = "save-enable-or-disable-email")
	public boolean saveEnableOrDisable(@RequestBody List<EnableorDisableEmail> enableOrDisableEmail) {
		return emailService.saveEnableOrDisable(enableOrDisableEmail);

	}
	
	//Create Default Settings
	@PostMapping(value = "createdefaultemailsettings")
	public ResponseEntity<Boolean> CreateDefaultSmsSettings(@RequestBody List<EnableorDisableEmail> enableOrDisableEmail) {
		return emailService.CreateDefaultEmailSettings(enableOrDisableEmail);
	}
	
	//View Enable disbale status
	@GetMapping(value = "/view-emailenable-status/{companyrefid}")
	public List viewEmailEnableStatus(@PathVariable int companyrefid) {
		return emailService.viewEmailEnableStatus(companyrefid);

	}
	
	@GetMapping(value = "/get-emailenable-status-salesinvoice/{companyrefid}")
	public boolean getEmailEnableStatusSalesInvoice(@PathVariable int companyrefid) {
		return emailService.getEmailEnableStatusSalesInvoice(companyrefid);
	}
}
