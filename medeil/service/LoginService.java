package com.medeil.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.medeil.bean.ForgotPasswordBean;
import com.medeil.bean.MailRequestBean;
import com.medeil.bean.MailStatusBean;
import com.medeil.bean.MessageStatusBean;
import com.medeil.bean.MobileRequestBean;
import com.medeil.domain.MedcAdduser;
import com.medeil.domain.Medc_Userlogin;
import com.medeil.domain.OtpMobile;
import com.medeil.domain.UserPasswordHistory;
import com.medeil.domain.Userlogin;
import com.medeil.repository.EditionRepository;
import com.medeil.repository.MedcAdduserRepository;
import com.medeil.repository.Medc_UserLoginRepository;
import com.medeil.repository.OtpMobileRepository;
import com.medeil.repository.ShopRepository;
import com.medeil.repository.UserPasswordHistoryRepository;
import com.medeil.repository.UserloginRepository;

@Service
public class LoginService {
	@Autowired
	Medc_UserLoginRepository userloginRepository;
	@Autowired
	MedcAdduserRepository medcAdduserRepository;
	@Autowired
	OtpMobileRepository OtpMobilesRepository;
	@Autowired
	private PasswordEncoder passwordEncoder;
	@Autowired
	UserPasswordHistoryRepository userPasswordHistoryRepository;
	@Autowired
	private EditionRepository editionRepository;
	@Autowired
	private UserloginRepository userloginRepo;
	@Autowired
	private Environment env;

	public Map forgotPassword(String username, String mobileno) throws Exception {
		HashMap<String, String> result = new HashMap<String, String>();
		oldOtpInvalidate(username);
		// try {
		MedcAdduser medcAdduser = medcAdduserRepository.findByUsername(username);

		if (medcAdduserRepository.existsByUsername(username)) {
			int otp = otpGenerator();
			if (mobileno.equals(medcAdduser.getPhoneno())) {
				sendMailOtp(medcAdduser.getEmailid(), otp);
				twilioSms(medcAdduser.getPhoneno(), otp, "reset");

			} else {
				String response = "Username & Mobile Number does not Matched!";
				result.put("message", response);
				result.put("code", "false");
				return result;
			}
			saveMobileOtp(username, medcAdduser, otp);
			return response(username, result, medcAdduser);
		} else {
			String response = "Username does not exists!" + mobileno;
			result.put("code", "false");
			result.put("message", response);
			return result;
		}
		// } catch (Exception e) {
		// e.printStackTrace();
		// }
		// return null;

	}

	/**
	 * @param phoneno
	 * @param otp
	 */
	private void twilioSms(String phoneno, int otp, String flag) throws Exception {
		// entity
		MobileRequestBean bean = new MobileRequestBean();
		bean.setMobileNo(phoneno);
		bean.setOtp(otp);
		bean.setFlag(flag);

		RestTemplate restTemplate = new RestTemplate();
		HttpHeaders headers = new HttpHeaders();
		headers.add("Content-Type", MediaType.APPLICATION_JSON_VALUE);

		String url = env.getProperty("third.party.api.otp.url");
		HttpEntity<MobileRequestBean> httpentity = new HttpEntity<MobileRequestBean>(bean, headers);
		ResponseEntity<MessageStatusBean> response = restTemplate.exchange(url, HttpMethod.POST, httpentity,
				MessageStatusBean.class);

	}

	/**
	 * @param emailid
	 * @param otp
	 * @throws Exception
	 */
	private void sendMailOtp(String emailid, int otp) throws Exception {
		// set mail entity class
		ForgotPasswordBean bean = new ForgotPasswordBean();
		bean.setEmailId(emailid);
		bean.setOtp(otp);

		RestTemplate restTemplate = new RestTemplate();
		HttpHeaders headers = new HttpHeaders();
		headers.add("Content-Type", MediaType.APPLICATION_JSON_VALUE);

		String url = env.getProperty("third.party.api.forgetpassword.url");
		HttpEntity<ForgotPasswordBean> httpentity = new HttpEntity<ForgotPasswordBean>(bean, headers);
		ResponseEntity<MailStatusBean> response = restTemplate.exchange(url, HttpMethod.POST, httpentity,
				MailStatusBean.class);

	}

	/******* Make Old OTP Invalidate *******/
	private void oldOtpInvalidate(String username) throws Exception {
		boolean existsByUsername = OtpMobilesRepository.existsByUsername(username);
		if (existsByUsername) {
			List<OtpMobile> findByUsername = OtpMobilesRepository.findByUsername(username);
			findByUsername.forEach(p -> {
				p.setIsexpired(true);
			});
			OtpMobilesRepository.saveAll(findByUsername);
		}
	}

	/******* Response For Forget Password *******/
	private Map response(String username, HashMap<String, String> result, MedcAdduser medcAdduser) throws Exception {
		String mobile = medcAdduser.getPhoneno().substring(medcAdduser.getPhoneno().length() - 4);
		String emailBegin = medcAdduser.getEmailid().substring(0, 3);
		String emailEnd = medcAdduser.getEmailid().substring(medcAdduser.getEmailid().length() - 10);
		String response = "Otp has been sent to your registered Mobile Number : ******" + mobile + " and email : "
				+ emailBegin + "***" + emailEnd + ", is valid for 10 Minutes.";
		result.put("message", response);
		result.put("mobile", medcAdduser.getPhoneno());
		result.put("username", username);
		result.put("code", "true");
		return result;
	}

	/******* OTP Mobile Database *******/
	private void saveMobileOtp(String username, MedcAdduser medcAdduser, int otp) throws Exception {
		OtpMobile OtpMobiles = new OtpMobile();
		OtpMobiles.setUsername(username);
		OtpMobiles.setMobilenumber(medcAdduser.getPhoneno());
		OtpMobiles.setOtp(otp);
		long expirytime = System.currentTimeMillis() + 600000;
		OtpMobiles.setExpirytime(expirytime);
		OtpMobiles.setIsexpired(false);
		OtpMobiles.setEmail(medcAdduser.getEmailid());
		OtpMobilesRepository.save(OtpMobiles);
	}

	/******* Twilio For Sending OTP *******/
//	private void twilioSms(MedcAdduser medcAdduser, int otp) throws Exception {
//		Twilio.init("ACd84b0291a3d0d25dfb3e5cd808cd5d9b", "2a1ce4900e57fb01b612273fba673b66");
//		String Messages = "Dear Patron,\nYour request for Password Reset has been initiated. Your One Time Password is "
//				+ otp + " valid for 10 Minutes.";
//		Message message = Message.creator(new PhoneNumber(medcAdduser.getPhoneno()), // to
//				new PhoneNumber("+17169162010"), // from
//				Messages).create();
//	}

	/******* OTP Generation *******/
	private int otpGenerator() throws Exception {
		Random random = new Random();
		int otp = 100000 + random.nextInt(900000);
		return otp;
	}

	/******* Encrypting Password *******/
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	/*******
	 * Saving OTP and Password in Database
	 * 
	 * @throws Exception
	 *******/
	public Map saveNewPassword(String username, String mobileno, String password, int otp) throws Exception {
		HashMap<String, String> result = new HashMap<String, String>();
		boolean existsByUsernameAndMobilenumberAndOtp = OtpMobilesRepository
				.existsByUsernameAndMobilenumberAndOtp(username, mobileno, otp);
		if (existsByUsernameAndMobilenumberAndOtp) {
			OtpMobile findByUsernameAndMobilenumberAndOtp = OtpMobilesRepository
					.findByUsernameAndMobilenumberAndOtp(username, mobileno, otp);
			if (!findByUsernameAndMobilenumberAndOtp.isIsexpired()) {
				if (findByUsernameAndMobilenumberAndOtp.getExpirytime() > System.currentTimeMillis()) {
					if (createPassword(username, password)) {
						findByUsernameAndMobilenumberAndOtp.setIsexpired(true);
						OtpMobilesRepository.save(findByUsernameAndMobilenumberAndOtp);
						// sendMailPasswordAcknowledgment(findByUsernameAndMobilenumberAndOtp.getEmail());
						sendMailPasswordAcknowledgment(findByUsernameAndMobilenumberAndOtp.getEmail(), username);
					} else {
						String response = "Do not use old passwords or current password!";
						result.put("message", response);
						result.put("code", "false");
						return result;
					}
					;

				} else {
					String response = "OTP Expired";
					result.put("message", response);
					result.put("code", "false");
					return result;
				}
			} else {
				String response = "OTP Expired";
				result.put("message", response);
				result.put("code", "false");
				return result;
			}
		} else {

			String response = "Invalid OTP";
			result.put("message", response);
			result.put("code", "false");
			return result;
		}
		String response = "Your Password Has Been changed Successfully!";
		result.put("message", response);
		result.put("code", "true");

		return result;
	}

	private void sendMailPasswordAcknowledgment(String email, String username) {
		MailRequestBean logDetails = new MailRequestBean();
		logDetails.setEmailId(email);
		logDetails.setUserName(username);
		RestTemplate restTemplate = new RestTemplate();
		HttpHeaders headers = new HttpHeaders();
		headers.add("Content-Type", MediaType.APPLICATION_JSON_VALUE);
		HttpEntity<MailRequestBean> httpentity = new HttpEntity<MailRequestBean>(logDetails, headers);
		String url = env.getProperty("third.party.api.acknowledgement.url");
		ResponseEntity<MailStatusBean> response = restTemplate.exchange(url, HttpMethod.POST, httpentity,
				MailStatusBean.class);

	}

	/******* Creating Password *******/
	private boolean createPassword(String username, String password) throws Exception {
		HashMap<String, String> result = new HashMap<String, String>();
		UserPasswordHistory user = new UserPasswordHistory();
		Medc_Userlogin findByUsername = userloginRepository.findByUsername(username);
		boolean existsByUserAndHist = userPasswordHistoryRepository.existsByPatronAndHist(findByUsername.getId(),
				password);
		System.out.println(">>>>>>>>>>>" + existsByUserAndHist);
		if (existsByUserAndHist) {

			return false;

		} else {
			String encodedPassword = "{bcrypt}" + passwordEncoder.encode(password);
			findByUsername.setPassword(encodedPassword);
			findByUsername.setAccountNonLocked(true);
			findByUsername.setUserloginattempt(0);
			long expirytime = System.currentTimeMillis() + 15552000000l;
			findByUsername.setPasswordvalidity(expirytime);
			userloginRepository.save(findByUsername);
			user.setPatron(findByUsername.getId());
			user.setHist(password);
			System.out.println("Boopalan");
			userPasswordHistoryRepository.save(user);

			return true;
		}

	}

	/******* Identify Username and Mobile Number *******/
	public Map mobileNumberCheck(String username) throws Exception {
		HashMap<String, String> result = new HashMap<String, String>();
		if (medcAdduserRepository.existsByUsername(username)) {
			MedcAdduser medcAdduser = medcAdduserRepository.findByUsername(username);
			String mobile = medcAdduser.getPhoneno().substring(medcAdduser.getPhoneno().length() - 4);
			String response = "Enter your complete registered Mobile Number - ******" + mobile;
			result.put("message", response);
			result.put("username", username);
			result.put("countrycode", String.valueOf(medcAdduser.getCountryrefid()));
			result.put("code", "true");
			return result;
		} else {
			String response = "Username does not exists!";
			result.put("message", response);
			result.put("code", "false");
			return result;
		}
	}

	/******* Authenticate Username and Mobile Number *******/
	public Map mobileNumberVerification(String username, String mobileno) throws Exception {
		HashMap<String, String> result = new HashMap<String, String>();
		if (medcAdduserRepository.existsByUsernameAndPhoneno(username, mobileno)) {
			result.put("username", username);
			result.put("mobile", mobileno);
			result.put("code", "true");
			return result;
		} else {
			String response = "Username & Mobile Number does not Matched!";
			result.put("message", response);
			result.put("code", "false");
			return result;
		}
	}

//	/******* SendGrid Email to send OTP *******/
//	public boolean sendMailOtp(String email, int otp) throws IOException {
//
//		Email from = new Email("support@vanuston.com");
//		String subject = "One Time Password (OTP) has been sent to your registered mobile number";
//		Email to = new Email(email);
//		Content content = new Content("text/plain", "Dear Customer,\r\n" + "\r\n"
//				+ "As per your request , the One Time Password (OTP) " + otp
//				+ " for your account has been generated and sent to your registered mobile number.\r\n" + "\r\n"
//				+ "We would request you to register/update your mobile number with us in case of any change or if you haven't done so already.\r\n"
//				+ "\r\n" + "Warm regards,\r\n" + "Medeil Team.");
//
//		Mail mail = new Mail(from, subject, to, content);
//		SendGrid sg = new SendGrid("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");
//		Request request = new Request();
//		try {
//			request.setMethod(Method.POST);
//			request.setEndpoint("mail/send");
//			request.setBody(mail.build());
//			Response response = sg.api(request);
//			System.out.println(response.getStatusCode());
//			System.out.println(response.getBody());
//			System.out.println(response.getHeaders());
//		} catch (IOException ex) {
//			System.out.println(ex.getMessage());
//			throw new IOException(ex);
//		}
//		return false;
//	}

	public Map userAttemptCount(String username) throws Exception {
		HashMap<String, String> result = new HashMap<String, String>();
		if (userloginRepository.existsByUsername(username)) {
			Medc_Userlogin medcAdduser = userloginRepository.findByUsername(username);
			int attempt = 3 - medcAdduser.getUserloginattempt();
			String response = "";
			if (attempt == 1) {
				response = "You have" + attempt
						+ " more attempt, After Unsuccessful Attempt Your Account Will Be Locked!";
			} else {
				response = "You have " + attempt + " more attempts";
			}
			result.put("message", response);
			result.put("username", username);
			result.put("code", "true");
			return result;
		} else {
			String response = "Username does not exists!";
			result.put("message", response);
			result.put("code", "false");
			return result;
		}
	}
//
//	/******* SendGrid Email to send USER Password Changed Acknowledgement *******/
//	public boolean sendMailPasswordAcknowledgment(String email) throws IOException {
//		Email from = new Email("support@vanuston.com");
//		String subject = "Security alert,Your password was changed!";
//		Email to = new Email(email);
//		Content content = new Content("text/plain",
//				"Dear Customer,\r\n" + "The password for your account was changed recently.\r\n"
//						+ "If you didn't change it, you should contact our Customer Support Team.\r\n" + "\r\n"
//						+ "regards,\r\n" + "Medeil Team");
//		Mail mail = new Mail(from, subject, to, content);
//		SendGrid sg = new SendGrid("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");
//		Request request = new Request();
//		try {
//			request.setMethod(Method.POST);
//			request.setEndpoint("mail/send");
//			request.setBody(mail.build());
//			Response response = sg.api(request);
//			System.out.println(response.getStatusCode());
//			System.out.println(response.getBody());
//			System.out.println(response.getHeaders());
//		} catch (IOException ex) {
//			System.out.println(ex.getMessage());
//			throw new IOException(ex);
//		}
//
//		return false;
//	}

	public Map otpValidation(String username, String mobileno, int otp) throws Exception {
		HashMap<String, String> result = new HashMap<String, String>();
		boolean existsByUsernameAndMobilenumberAndOtp = OtpMobilesRepository
				.existsByUsernameAndMobilenumberAndOtp(username, mobileno, otp);
		if (existsByUsernameAndMobilenumberAndOtp) {
			OtpMobile findByUsernameAndMobilenumberAndOtp = OtpMobilesRepository
					.findByUsernameAndMobilenumberAndOtp(username, mobileno, otp);
			if (!findByUsernameAndMobilenumberAndOtp.isIsexpired()) {
				if (findByUsernameAndMobilenumberAndOtp.getExpirytime() > System.currentTimeMillis()) {
					String response = "Valid OTP";
					result.put("message", response);
					result.put("code", "true");
					return result;
				} else {
					String response = "OTP Expired";
					result.put("message", response);
					result.put("code", "false");
					return result;
				}
			} else {
				String response = "OTP Expired";
				result.put("message", response);
				result.put("code", "false");
				return result;
			}
		} else {

			String response = "Invalid OTP";
			result.put("message", response);
			result.put("code", "false");
			return result;
		}
	}

	public List getcountryid() throws Exception {
		return editionRepository.getcountryid();
	}

	public ResponseEntity<Boolean> createNewPassword(String username, String password) throws Exception {
		// try {
		Medc_Userlogin existingUserByRole = userloginRepository.findByUsername(username);
		UserPasswordHistory user = new UserPasswordHistory();
		System.out.println(":::::::::++++Ok" + existingUserByRole.getId());
		String encodedPassword = "{bcrypt}" + passwordEncoder.encode(password);
		existingUserByRole.setPassword(encodedPassword);
		userloginRepository.save(existingUserByRole);
		user.setPatron(existingUserByRole.getId());
		user.setHist(password);
		System.out.println("Ok");
		userPasswordHistoryRepository.save(user);

		return new ResponseEntity(true, HttpStatus.OK);
		// }

		// catch (Exception e) {
		// return new ResponseEntity(e, HttpStatus.BAD_REQUEST);
		// }
	}

	public boolean CheckDomain(String domainname) throws Exception {
		Optional<Userlogin> checkname = userloginRepo.findByDomainname(domainname);
		if (checkname.isPresent()) {
			return false;
		}
		return true;
	}

	public List Verticallist() throws Exception {
		return medcAdduserRepository.Verticallist();
	}

}
