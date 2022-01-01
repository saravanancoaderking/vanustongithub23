package com.medeil.controller;

import java.util.List;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.medeil.domain.IndCompModel;
import com.medeil.domain.Journal;
import com.medeil.service.PaymentService;

@RestController
@Transactional
@RequestMapping("api/payment")
public class PaymentController {

	@Autowired
	PaymentService paymentService;

	private final Logger log = LoggerFactory.getLogger(PaymentService.class);

	@PostMapping(value = "/savePayment")
	public int savePayment(@RequestBody List<Journal> pt) throws Exception {
		System.out.println("aaaaaa");
		return paymentService.savePayment(pt);
	}

	@PostMapping(value = "/savePaymentsingle")
	public int savePaymentsin(@RequestBody Journal pt) throws Exception {
		System.out.println("aaaaaa");
		return paymentService.savePaymentsin(pt);
	} 
	
	@PostMapping(value = "/savebankdeposit")
	public int saveBankdeposit(@RequestBody Journal bk) throws Exception {
		return paymentService.saveBankdeposit(bk);
	} 
	
	@PostMapping("/updatePayment")
	public int updatePayment(@RequestBody Journal pt) throws Exception {

		return paymentService.updatePayment(pt);

	}

	@PostMapping("/saveBulkPayment")
	public int saveBulkPayment(@RequestBody List<Journal> pt) throws Exception {

		return paymentService.saveBulkPayment(pt);

	}

	@PostMapping("/viewPurchaseInvoiceNo")
	public List viewPurchaseInvoiceNo(@RequestBody IndCompModel loc) throws Exception {

		return paymentService.viewPurchaseInvoiceNo(loc);

	}

	@PostMapping("/viewPurchaseInvoice")
	public List viewPurchaseInvoice(@RequestBody IndCompModel loc) throws Exception {

		return paymentService.viewPurchaseInvoice(loc);

	}

	@PostMapping("/viewVendorPurchaseInvoice")
	public List viewVendorPurchaseInvoice(@RequestBody IndCompModel loc) throws Exception {

		return paymentService.viewVendorPurchaseInvoice(loc);

	}
	
	@PostMapping("/viewCustsalesreturn")
	public List viewCustomersalesreturn(@RequestBody IndCompModel loc) throws Exception {

		return paymentService.viewCustomersalesreturn(loc);

	}

	@PostMapping("/viewSalesReturnNo")
	public List viewSalesReturnNo(@RequestBody IndCompModel loc) throws Exception {

		return paymentService.viewSalesReturnNo(loc);

	}

	@PostMapping("/viewSalesReturn")
	public List viewSalesReturn(@RequestBody IndCompModel loc) throws Exception {

		return paymentService.viewSalesReturn(loc);

	}

	@PostMapping("/viewPTAccounts")
	public List viewAccounts(@RequestBody IndCompModel loc) throws Exception {

		return paymentService.viewAccounts(loc);

	}

	@PostMapping("/viewPTAccount")
	public List viewAccount(@RequestBody IndCompModel loc) throws Exception {

		return paymentService.viewAccount(loc);

	}

	@PostMapping("/viewPTAccountsAll")
	public List viewAccountsAll(@RequestBody IndCompModel loc) throws Exception {

		return paymentService.viewAccountsAll(loc);

	}

	@PostMapping("/viewPaymentAll")
	public List viewPaymentAll(@RequestBody IndCompModel loc) throws Exception {

		return paymentService.viewPaymentAll(loc);

	}

	@PostMapping("/viewPayment")
	public List viewPayment(@RequestBody IndCompModel loc) throws Exception {

		return paymentService.viewPayment(loc);

	}

	@PostMapping("/viewDistributors")
	public List viewDistributors(@RequestBody IndCompModel loc) throws Exception {

		return paymentService.viewDistributors(loc);

	}

	@PostMapping("/viewDistOutstanding")
	public List viewDistOutstanding(@RequestBody IndCompModel loc) throws Exception {

		return paymentService.viewDistOutstanding(loc);

	}

	@PostMapping("/deletePayment")
	public int deletePayment(@RequestBody IndCompModel loc) throws Exception {
		return paymentService.deletePayment(loc);

	}

	@GetMapping("/viewpaymentoutstanding/{cid}/{bid}/{lname}/{lrefid}/{date}")
	public List Viewpaymentout(@PathVariable Integer cid, @PathVariable Integer bid, @PathVariable Integer lname,
			@PathVariable Integer lrefid,@PathVariable String date) throws Exception {
		return paymentService.Viewpaymentout(cid, bid, lname, lrefid,date);

	}
	
	//Puthiran View Credit Payments
	@GetMapping("/GetAllCreditAlerts/{cid}/{bid}/{lname}/{lrefid}")
	public List GetAllCreditAlerts(@PathVariable Integer cid, @PathVariable Integer bid, @PathVariable Integer lname,@PathVariable Integer lrefid) throws Exception {
		return paymentService.GetAllCreditAlerts(cid, bid, lname, lrefid);

	}
	
	//view employee list
		@GetMapping("/viewEmplist/{cid}/{bid}/{lname}/{lrefid}")
		public List Getemplists(@PathVariable Integer cid, @PathVariable Integer bid, @PathVariable Integer lname,@PathVariable Integer lrefid) throws Exception {
			return paymentService.Getemplists(cid, bid, lname, lrefid);

		}

}
