package com.medeil.securityconfig;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.authentication.OAuth2AuthenticationDetails;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.auth0.jwt.JWT;
import com.auth0.jwt.exceptions.JWTDecodeException;
import com.auth0.jwt.interfaces.Claim;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.medeil.domain.Medc_Userlogin;
import com.medeil.repository.Medc_UserLoginRepository;

@Component
public class Claims extends OncePerRequestFilter {
	@Autowired
	AuthenticationFacade authenticationFacade;
	@Autowired
	Medc_UserLoginRepository userloginRepository;

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		Map<String, Claim> claims = new HashMap<>();

		try {
			String tokenValue = ((OAuth2AuthenticationDetails) ((OAuth2Authentication) authenticationFacade
					.getAuthentication()).getDetails()).getTokenValue();
			DecodedJWT jwt = JWT.decode(tokenValue);
			claims = jwt.getClaims();
		} catch (JWTDecodeException ex) {
		} catch (Exception ex) {
			filterChain.doFilter(request, response);
		}
		Long IssuedAtTimeStamp = claims.get("IssuedAtTimeStamp").asLong();
		String username = claims.get("user_name").asString();
		Integer companyid = claims.get("companyid").asInt();

		System.out.println(IssuedAtTimeStamp + " " + username + " " + companyid);
		boolean existByUsernameAndLoginstatus = userloginRepository.existsByUsernameAndLoginstatus(username,
				IssuedAtTimeStamp);
		if (existByUsernameAndLoginstatus) {
			filterChain.doFilter(request, response);

		} else {
			Medc_Userlogin findByUsername = userloginRepository.findByUsername(username);
			//sendMailOtp(findByUsername.getUsername());
			((HttpServletResponse) response).sendError(HttpServletResponse.SC_UNAUTHORIZED, "USER_DETECTED");
		}

	}

//	/******* SendGrid Email to send OTP *******/
//	public boolean sendMailOtp(String email) throws IOException {
//		Mail mail = new Mail(new Email("support@vanuston.com"), "Security Alert", new Email(email),
//				new Content("text/plain", "Dear Customer,\r\n"
//						+ "              Someone Logged in to your account. If not by you, Change your credentials of your account. For More Details, Check Login Histroy.\r\n"
//						+ "\r\n" + "\r\n" + "regards,\r\n" + "Medeil Team"));
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
//		}
//		return false;
//	}

}