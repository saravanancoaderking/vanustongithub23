package com.medeil.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//import org.apache.coyote.http2.ConnectionException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.medeil.domain.IneConnectionException;
import com.medeil.domain.IneInvalidPaymentOrderException;
import com.medeil.domain.InmPaymentOrder;
import com.medeil.domain.InmPaymentOrderFilter;
import com.medeil.domain.InrCreatePaymentOrderResponse;
import com.medeil.domain.InrPaymentOrderListResponse;
import com.medeil.util.PaytmConstants;
import com.paypal.api.payments.Amount;
import com.paypal.api.payments.Details;
import com.paypal.api.payments.Links;
import com.paypal.api.payments.Payer;
import com.paypal.api.payments.Payment;
import com.paypal.api.payments.RedirectUrls;
import com.paypal.api.payments.Transaction;
import com.paypal.base.rest.APIContext;
import com.paypal.base.rest.PayPalRESTException;
//   import   com.paytm.pg.merchant.CheckSumServiceHelper;

@Controller
@RequestMapping("api/paytm")
public class PayTmController {

	@ResponseBody
	@RequestMapping(value = "/pgrequest")
	public String saveSalesJournal(HttpServletRequest request) throws Exception {

		String checkSum = null;

	//	try {

			Enumeration<String> paramNames = request.getParameterNames();
			Map<String, String[]> mapData = request.getParameterMap();
			TreeMap<String, String> parameters = new TreeMap<String, String>();
			String paytmChecksum = "";
			while (paramNames.hasMoreElements()) {
				String paramName = (String) paramNames.nextElement();
				parameters.put(paramName, mapData.get(paramName)[0]);
			}

			parameters.put("MID", PaytmConstants.MID);
			parameters.put("CHANNEL_ID", PaytmConstants.CHANNEL_ID);
			parameters.put("INDUSTRY_TYPE_ID", PaytmConstants.INDUSTRY_TYPE_ID);
			parameters.put("WEBSITE", PaytmConstants.WEBSITE);
			parameters.put("MOBILE_NO", "9876543210");
			parameters.put("EMAIL", "test@gmail.com");
			parameters.put("CALLBACK_URL", "http://localhost:4200/api/paytm/pgResponse");

			// checkSum =
			// CheckSumServiceHelper.getCheckSumServiceHelper().genrateCheckSum(PaytmConstants.MERCHANT_KEY,
			// parameters);
	//	} catch (Exception e) {
	//		// TODO Auto-generated catch block
	//		e.printStackTrace();
	//	}

		return "hygytghgyhyggfhgfh";

	}

	@ResponseBody
	@RequestMapping(value = "/pgrequest47")
	public void saveSalesJournalnew() throws Exception {

		InmPaymentOrder order = new InmPaymentOrder();

		order.setName("John Smith");
		order.setEmail("prasad1058@gmail.com");

		order.setPhone("+91-9444092089");

		order.setCurrency("INR");
		order.setAmount(14D);
		order.setDescription("This is a test transaction.");
		order.setRedirectUrl("http://localhost:4200");
		order.setWebhookUrl("http://www.someurl.com/");
		order.setTransactionId("dxg69");

		Instamojo api = null;

	//	try {
			// gets the reference to the instamojo api
			api = InstamojoImpl.getApi("fy6BrZoXT94WUzMVyqzARoi6pTzkWvC9DD74ILSZ",
					"IgynFkLLiaPFvFQr5Iq85KCO9tT4DRmx3hl0agtgt00lMlX893vlffZF3xEyzs0Xdn9DzumncDpgSFvPNFznq2cPbxmu7osFSARI2ocETinlkCz8SoZ08kjTIWeD7mjJ",
					"https://www.instamojo.com/v2/", "https://www.instamojo.com/oauth2/token/");

			// "fy6BrZoXT94WUzMVyqzARoi6pTzkWvC9DD74ILSZ"

	//	} catch (IneConnectionException e) {

	//		e.printStackTrace();

	//	}

		boolean isOrderValid = order.validate();

		System.out.println("valid" + isOrderValid);
		if (isOrderValid) {
		//	try {
				InrCreatePaymentOrderResponse createPaymentOrderResponse = api.createNewPaymentOrder(order);
				// print the status of the payment order.
				System.out.println(createPaymentOrderResponse.getPaymentOrder().getStatus());
		//	} catch (IneInvalidPaymentOrderException e) {
		//		e.printStackTrace();

				if (order.isTransactionIdInvalid()) {
					System.out.println("Transaction id is invalid. This is mostly due to duplicate  transaction id.");
				}
				if (order.isCurrencyInvalid()) {
					System.out.println("Currency is invalid.");
				}
		//	} catch (IneConnectionException e) {

		//		e.printStackTrace();

		//	}
		} else {
			// inform validation errors to the user.
			if (order.isTransactionIdInvalid()) {
				System.out.println("Transaction id is invalid.");
			}
			if (order.isAmountInvalid()) {
				System.out.println("Amount can not be less than 9.00.");
			}
			if (order.isCurrencyInvalid()) {
				System.out.println("Please provide the currency.");
			}
			if (order.isDescriptionInvalid()) {
				System.out.println("Description can not be greater than 255 characters.");
			}
			if (order.isEmailInvalid()) {
				System.out.println("Please provide valid Email Address.");
			}
			if (order.isNameInvalid()) {
				System.out.println("Name can not be greater than 100 characters.");
			}
			if (order.isPhoneInvalid()) {
				System.out.println("Phone is invalid.");
			}
			if (order.isRedirectUrlInvalid()) {
				System.out.println("Please provide valid Redirect url.");
			}

			if (order.isWebhookInvalid()) {
				System.out.println("Provide a valid webhook url");
			}
		}
	}

	@ResponseBody
	@RequestMapping(value = "/pgrequest473")
	public InrPaymentOrderListResponse saveSales() throws Exception ,IneConnectionException{

		InrPaymentOrderListResponse paymentOrderListResponse = null;
	//	try {
			Instamojo api = InstamojoImpl.getApi("fy6BrZoXT94WUzMVyqzARoi6pTzkWvC9DD74ILSZ",
					"IgynFkLLiaPFvFQr5Iq85KCO9tT4DRmx3hl0agtgt00lMlX893vlffZF3xEyzs0Xdn9DzumncDpgSFvPNFznq2cPbxmu7osFSARI2ocETinlkCz8SoZ08kjTIWeD7mjJ",
					"https://www.instamojo.com/v2/", "https://www.instamojo.com/oauth2/token/");

			InmPaymentOrderFilter paymentOrderFilter = new InmPaymentOrderFilter();
			paymentOrderListResponse = api.getPaymentOrderList(paymentOrderFilter);

			// print the list of all payment orders.
			for (InmPaymentOrder paymentOrder : paymentOrderListResponse.getPaymentOrders()) {
				System.out.println("Result = " + paymentOrder.getStatus());
			}

	//	} catch (IneConnectionException e) {

	//		e.printStackTrace();

	//	}
		return paymentOrderListResponse;

	}

	private APIContext apiContext;

	public void PaymentService(String clientId, String clientSecret, String mode)throws Exception {
		apiContext = new APIContext(clientId, clientSecret, mode);
	}

	@CrossOrigin
	@ResponseBody
	@RequestMapping(value = "/saveSales79")
	public List proecssPayment(HttpServletRequest request, HttpServletResponse response) throws Exception {

		System.out.println("fgdddfgdgfddgfd");

		Payment createdPayment = null;

		this.PaymentService("AaHzJeCOvx1Vxcf8yBQ4lqZUL7rDy_yBxDKTJAb9E4L_sr7JTDW07hFy2e7vUU8GJNqWRU690Ud8PEpM",
				"ENgc13rhyaBbDVHsKzlfM4NOJIKI588-tsIAkd46ZBQAPvWPPQdCsrnmWJccgwHA_xo4LD39QfWHqfNV", "live");
		// Set payer details
		Payer payer = new Payer();
		payer.setPaymentMethod("paypal");

		// Set redirect URLs
		RedirectUrls redirectUrls = new RedirectUrls();
		redirectUrls.setCancelUrl("http://localhost:8080/paypalrestintegration/cancel");
		redirectUrls.setReturnUrl("http://localhost:8010");

		// Set payment details
		double shipping = Double.parseDouble("20");
		double cartTotal = Double.parseDouble("20");
		double tax = (cartTotal * 14) / 100;

		Details details = new Details();
		details.setShipping(shipping + "");
		details.setSubtotal(cartTotal + "");
		details.setTax(tax + "");

		System.out.println("fgdddfgdgfddgfd");

		double total = cartTotal + shipping + tax;

		// Payment amount
		Amount amount = new Amount();
		amount.setCurrency("USD");
		// Total must be equal to sum of shipping, tax and subtotal.
		amount.setTotal("" + total);
		amount.setDetails(details);

		// Transaction information
		Transaction transaction = new Transaction();
		transaction.setAmount(amount);
		transaction.setDescription("This is the payment transaction description.");

		// Add transaction to a list
		List<Transaction> transactions = new ArrayList<Transaction>();
		transactions.add(transaction);

		// Add payment details
		Payment payment = new Payment();
		payment.setIntent("sale");
		payment.setPayer(payer);
		payment.setRedirectUrls(redirectUrls);
		payment.setTransactions(transactions);

		// Create payment
		try {
			createdPayment = payment.create(apiContext);

			// System.out.println(createdPayment);

			Iterator<Links> links = createdPayment.getLinks().iterator();
			while (links.hasNext()) {
				Links link = links.next();
				if (link.getRel().equalsIgnoreCase("approval_url")) {
					// REDIRECT USER TO link.getHref()
					response.sendRedirect(link.getHref());
				}
			}
		} catch (PayPalRESTException e) {
			e.printStackTrace();
			throw new PayPalRESTException(e);

		} catch (IOException e) {
			e.printStackTrace();
			throw new IOException(e);
		}
		return createdPayment.getLinks();

	}

	@ResponseBody
	@RequestMapping(value = "/pgResponse")
	public int saveSalesJournalnew(HttpServletRequest request) throws Exception{

		Enumeration<String> paramNames = request.getParameterNames();

		Map<String, String[]> mapData = request.getParameterMap();
		TreeMap<String, String> parameters = new TreeMap<String, String>();
		String paytmChecksum = "";
		while (paramNames.hasMoreElements()) {
			String paramName = (String) paramNames.nextElement();
			if (paramName.equals("CHECKSUMHASH")) {
				paytmChecksum = mapData.get(paramName)[0];
			} else {
				parameters.put(paramName, mapData.get(paramName)[0]);
			}
		}

		System.out.println("bghgfggfgfgfd");
		boolean isValideChecksum = false;
		String outputHTML = "";
		try {
			// isValideChecksum =
			// CheckSumServiceHelper.getCheckSumServiceHelper().verifycheckSum(PaytmConstants.MERCHANT_KEY,parameters,paytmChecksum);
			if (isValideChecksum && parameters.containsKey("RESPCODE")) {
				if (parameters.get("RESPCODE").equals("01")) {
					outputHTML = parameters.toString();
				} else {
					outputHTML = "<b>Payment Failed.</b>";
				}
			} else {
				outputHTML = "<b>Checksum mismatched.</b>";
			}
		} catch (Exception e) {
			outputHTML = e.toString();
			throw new Exception(e);
		}

		return 1;

	}

}
