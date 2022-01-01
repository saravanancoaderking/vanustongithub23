package com.medeil.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.medeil.domain.CustomerDelivery;
import com.medeil.domain.Customerpayment;
import com.medeil.domain.Customerpaymetstatus;
import com.medeil.domain.Diractcustomer;
import com.medeil.domain.PaitentSalesorderRecord;
import com.medeil.domain.PatientLogin;
import com.medeil.domain.PatientLoginProduct;
import com.medeil.domain.PatientLoginSalesorder;
import com.medeil.domain.PatientLoginSalesorderLead;
import com.medeil.domain.Patientdetail;
import com.medeil.domain.Paymentlink;
import com.medeil.domain.Performaprd;
import com.medeil.domain.Performinvoice;
import com.medeil.service.PatientLoginService;

@SuppressWarnings("rawtypes")
@RestController
@RequestMapping("api")

public class PatientLoginController {
	@Autowired
	private PatientLoginService patientLoginService;

	// Patient Login

	@PostMapping(value = "create-new-patient-login")
	public ResponseEntity<Boolean> createnewpatientlogin(@RequestBody Patientdetail patientdetail) throws Exception {
		return patientLoginService.createnewpatientlogin(patientdetail);
	}

	@PostMapping(value = "direct-customer-signup")
	public ResponseEntity<Boolean> Directcustomersigup(@RequestBody Diractcustomer diractcustomer) throws Exception {
		return patientLoginService.Directcustomersigup(diractcustomer);
	}

	// Payment

	@PostMapping("checkmy-medicine-customer-payment")
	public boolean getcustomerpaymet(@RequestBody Customerpayment customerpaymet) throws Exception {
		return patientLoginService.getcustomerpaymet(customerpaymet);
	}

	@PostMapping("checkmy-medicine-customer-payment-link")
	public boolean getcustomerpaymentlink(@RequestBody Paymentlink paymentlink) throws Exception {
		return patientLoginService.getcustomerpaymentlink(paymentlink);
	}

	@GetMapping(value = "customer-payment-link/cusid")
	public List customerpaymentlink(@PathVariable Integer cusid) throws Exception {
		return patientLoginService.customerpaymentlink(cusid);

	}

	@PostMapping("checkmy-medicine-customer-payment-status")
	public boolean getcustomerpaymentstatus(@RequestBody Customerpaymetstatus customerpaymetstatus) throws Exception {
		return patientLoginService.getcustomerpaymentstatus(customerpaymetstatus);
	}

	// Delivery Report

	@PostMapping(value = "customer-delivery-report")
	public ResponseEntity<Boolean> customerdeliveryreport(@RequestBody CustomerDelivery customerdeliveryreport)
			throws Exception {
		return patientLoginService.customerdeliveryreport(customerdeliveryreport);
	}

	// Patient details

	@GetMapping(value = "paitentdetails/{cid}/{bid}/{locname}/{locrefid}/{patientid}")
	public List paitentdetails(@PathVariable Integer cid, @PathVariable Integer bid, @PathVariable Integer locname,
			@PathVariable Integer locrefid, @PathVariable Integer patientid) throws Exception {
		return patientLoginService.paitentdetails(cid, bid, locname, locrefid, patientid);
	}

	// Prescription

	@PostMapping(value = "/createpatientPrescriptionRecord")
	public boolean createPrescriptionRecord(@RequestBody PatientLogin presc) throws Exception {
		return patientLoginService.createPrescriptionRecord(presc);
	}

	@PostMapping(value = "/patientsavepresproduct")
	public Boolean savepresprod(@RequestBody List<PatientLoginProduct> prescprod) throws Exception {
		return patientLoginService.saveprescprod(prescprod);
	}

	// new 3
	@GetMapping(value = "/paitentgetprescview/{comid}/{branchid}/{locname}/{locrefid}/{patient_id}")
	public List getprescdetails(@PathVariable Integer comid, @PathVariable Integer branchid,
			@PathVariable Integer locname, @PathVariable Integer locrefid, @PathVariable Integer patient_id)
			throws Exception {
		return patientLoginService.viewpresc(comid, branchid, locname, locrefid, patient_id);
	}

	// SalesOrder

	@GetMapping(value = "paitentsalesOrderIncrement/{cid}/{bid}/{locrefid}/{locname}/{PatientID}")
	public List getAutoIncrement(@PathVariable Integer cid, @PathVariable Integer bid, @PathVariable Integer locrefid,
			@PathVariable Integer locname, @PathVariable Integer PatientID) throws Exception {
		return patientLoginService.getAutoIncrement(cid, bid, locrefid, locname, PatientID);
	}

	@GetMapping(value = "paitentsearchSalesorderproduct/{data}/{cid}/{bid}/{locrefid}/{locname}")
	public List searchProduct(@PathVariable String data, @PathVariable Integer cid, @PathVariable Integer bid,
			@PathVariable Integer locrefid, @PathVariable Integer locname) throws Exception {
		return patientLoginService.searchProduct(data, cid, bid, locrefid, locname);
	}

	@GetMapping(value = "paitentgetsalesProduct/{productid}")
	public List getProductdata(@PathVariable Integer productid) throws Exception {
		return patientLoginService.getProductdata(productid);
	}

	@GetMapping(value = "paitentgetallSalesorderview/{cid}/{bid}/{locrefid}/{locname}/{PatientID}")
	public List getAll(@PathVariable Integer cid, @PathVariable Integer bid, @PathVariable Integer locrefid,
			@PathVariable Integer locname, @PathVariable Integer PatientID) throws Exception {
		return patientLoginService.getAll(cid, bid, locrefid, locname, PatientID);
	}

	@GetMapping(value = "/Paientdproductimage/{orderid}")
	public Map<String, String> getsendImage(@PathVariable Integer orderid) throws IOException, Exception {
		Map<String, String> jsonMap = new HashMap<>();
		// try {
		String path = patientLoginService.getsendImage(orderid);
		System.out.println(orderid);
		byte[] im = path.getBytes();
		byte[] img = com.paypal.base.codec.binary.Base64.encodeBase64(im);
		jsonMap.put("content", "" + img);
		return jsonMap;
		// } catch (Exception e) {
		// e.printStackTrace();
		// jsonMap.put("content", "no image");
		// return jsonMap;

		// }

	}

	@GetMapping(value = "paitentgetAllList/{cid}/{bid}/{locrefid}/{locname}/{PatientID}")
	public List getAllList(@PathVariable Integer cid, @PathVariable Integer bid, @PathVariable Integer locrefid,
			@PathVariable Integer locname, @PathVariable Integer PatientID) throws Exception {
		return patientLoginService.getAllList(cid, bid, locrefid, locname, PatientID);
	}

	@GetMapping(value = "paitentcusttracking/{cid}/{bid}/{locname}/{locrefid}/{patientid}/{orderid}")
	public List getCusttrack(@PathVariable Integer cid, @PathVariable Integer bid, @PathVariable Integer locname,
			@PathVariable Integer locrefid, @PathVariable Integer patientid, @PathVariable Integer orderid)
			throws Exception {
		return patientLoginService.getCusttrack(cid, bid, locname, locrefid, patientid, orderid);
	}

	@GetMapping(value = "paitentviewtracksalesorder/{cid}/{bid}/{locname}/{locrefid}/{patientid}/{orderid}")
	public List viewsalesorder(@PathVariable Integer cid, @PathVariable Integer bid, @PathVariable Integer locname,
			@PathVariable Integer locrefid, @PathVariable Integer patientid, @PathVariable Integer orderid)
			throws Exception {
		return patientLoginService.viewsalesorder(cid, bid, locname, locrefid, patientid, orderid);
	}

	@PostMapping(value = "paitentsaveSalesorder")
	public Boolean createSalesOrder(@RequestBody PatientLoginSalesorder salesorder) throws Exception {
		return patientLoginService.createSalesOrder(salesorder);
	}

	@PostMapping(value = "paitentsaveSalesorderRecord")
	public Boolean createSalesOrderRecord(@RequestBody List<PaitentSalesorderRecord> salesorder) throws Exception {

		return patientLoginService.createSalesOrderRecord(salesorder);
	}

	/** EDIT SALES ORDER */
	@GetMapping(value = "paitenteditSalesorderdata/{id}")
	public PatientLoginSalesorder editSalesOrder(@PathVariable Integer id) throws Exception {
		return patientLoginService.editSalesOrder(id);
	}

	@PostMapping(value = "paitentupdateSalesorder")
	public Boolean updateSalesorderData(@RequestBody PatientLoginSalesorder salesorder) throws Exception {
		return patientLoginService.updateSalesorderData(salesorder);
	}

	// SalesOrderLeaD

	// new 4
	@PostMapping(value = "paitentsaveSalesorderlead")
	public Boolean saveSalesorderlead(@RequestBody PatientLoginSalesorderLead salesorder) throws Exception {
		return patientLoginService.saveSalesorderlead(salesorder);
	}

	// new 5
	@PostMapping("paitentsaveSalesorderleadimage")
	public boolean handleImagePost(@RequestParam("file") MultipartFile file) throws IOException {
		return patientLoginService.saveImageFile(file);
	}

	@GetMapping(value = "paitentsalesOrderlead/{cid}/{bid}/{locrefid}/{locname}/{paitens}")
	public List getSalesorderlead(@PathVariable Integer cid, @PathVariable Integer bid, @PathVariable Integer locrefid,
			@PathVariable Integer locname, @PathVariable Integer paitens) throws Exception {
		return patientLoginService.soleadlist(cid, bid, locrefid, locname, paitens);
	}

	// puthiran 08/07/2020
	// patient slaeorder products direct salesorder convert
	@GetMapping(value = "paitentsalesOrderProducts/{salesleadid}")
	public List getSalesorderproducts(@PathVariable Integer salesleadid) throws Exception {
		return patientLoginService.soleadprodlist(salesleadid);
	}

	@GetMapping(value = "paitentsotypelist/{id}")
	public List getSotypelist(@PathVariable Integer id) throws Exception {
		return patientLoginService.soleadtypelist(id);
	}

	@GetMapping(value = "paitentsopatientlist/{id}")
	public List getSopatientlist(@PathVariable Integer id) throws Exception {
		return patientLoginService.soleadpatientlist(id);
	}

	@GetMapping(value = "paitentsoleadrecord/{id}")
	public List getSoleadrecord(@PathVariable Integer id) throws Exception {
		return patientLoginService.soleadrecordlist(id);
	}

	@GetMapping(value = "paitentsolproducts/{cid}/{bid}/{locname}/{locrefid}/{soid}")
	public List getsolproducts(@PathVariable Integer cid, @PathVariable Integer bid, @PathVariable Integer locname,
			@PathVariable Integer locrefid, @PathVariable Integer soid) throws Exception {
		return patientLoginService.getsolproducts(cid, bid, locname, locrefid, soid);
	}

	@GetMapping(value = "paitentaddsolproduct/{cid}/{bid}/{locrefid}/{locname}/{data}")
	public List addsoproduct(@PathVariable Integer cid, @PathVariable Integer bid, @PathVariable Integer locrefid,
			@PathVariable Integer locname, @PathVariable Integer data) throws Exception {
		return patientLoginService.addsoproduct(cid, bid, locrefid, locname, data);
	}

	@GetMapping(value = "paitentgetstockcheck/{cid}/{bid}/{locrefid}/{locname}/{data}")
	public List stockcheck(@PathVariable Integer cid, @PathVariable Integer bid, @PathVariable Integer locrefid,
			@PathVariable Integer locname, @PathVariable Integer data) throws Exception {
		return patientLoginService.stockcheck(cid, bid, locrefid, locname, data);
	}

	// Sales Invoice

	// new 2

	@GetMapping(value = "/paitentviewSalesInvoice/{cid}/{bid}/{lname}/{lrid}/{csrefid}")
	public List paitentviewSalesInvoice(@PathVariable Integer cid, @PathVariable Integer bid,
			@PathVariable Integer lname, @PathVariable Integer lrid, @PathVariable Integer csrefid) throws Exception {
		return patientLoginService.paitentviewSalesInvoice(cid, bid, lname, lrid, csrefid);

	}

	@GetMapping(value = "/paitentdashinvoice/{cid}/{bid}/{lname}/{lrid}/{csrefid}")
	public List paitentdashinvoice(@PathVariable Integer cid, @PathVariable Integer bid, @PathVariable Integer lname,
			@PathVariable Integer lrid, @PathVariable Integer csrefid) throws Exception {
		return patientLoginService.paitentdashinvoice(cid, bid, lname, lrid, csrefid);

	}

	@GetMapping(value = "/paitentgrandtotal/{cid}/{bid}/{lname}/{lrid}/{csrefid}")
	public Map paitentgrandtotal(@PathVariable Integer cid, @PathVariable Integer bid, @PathVariable Integer lname,
			@PathVariable Integer lrid, @PathVariable Integer csrefid) throws Exception {
		return patientLoginService.paitentgrandtotal(cid, bid, lname, lrid, csrefid);
	}

	// Proforma Invoice

	@PostMapping(value = "paitentsavePerformainvoice")
	public List saveProformainvoice(@RequestBody Performinvoice Proformainvoice) throws Exception {
		return patientLoginService.saveProformainvoice(Proformainvoice);
	}

	// patient wise
	@GetMapping(value = "/paitentviewPerformainvoice/{cid}/{bid}/{lname}/{lrid}/{patientid}")
	public List paitentProformainvoiceView(@PathVariable Integer cid, @PathVariable Integer bid,
			@PathVariable Integer lname, @PathVariable Integer lrid, @PathVariable Integer patientid) throws Exception {
		return patientLoginService.paitentProformainvoiceView(cid, bid, lname, lrid, patientid);
	}

	// shopw wise
	@GetMapping(value = "/viewPerformainvoiceall/{cid}/{bid}/{lname}/{lrid}")
	public List paitentProformainvoiceView(@PathVariable Integer cid, @PathVariable Integer bid,
			@PathVariable Integer lname, @PathVariable Integer lrid) throws Exception {
		return patientLoginService.viewperforminvoiceall(cid, bid, lname, lrid);
	}

	@GetMapping(value = "/viewPerformainvoiceProducts/{invid}")
	public List ProformainvoiceViewProducts(@PathVariable Integer invid) throws Exception {
		return patientLoginService.ProformainvoiceViewProducts(invid);
	}

	// pre(performinvoice)invoice model
	@GetMapping(value = "viewperforminvoicemodel/{salesorderid}")
	public Map viewPerformInvoicedetails(@PathVariable int salesorderid) throws Exception {
		return patientLoginService.viewperforminvoicemodel(salesorderid);
	}

	@PostMapping(value = "paitentsavePerformaproduct")
	public boolean saveProformaproduct(@RequestBody List<Performaprd> Proformaprd) throws Exception {
		return patientLoginService.saveProformaproduct(Proformaprd);
	}

	@GetMapping(value = "/paitentviewPerformaproduct/{cid}/{bid}/{lname}/{lrid}}")
	public List paitentProformaproductView(@PathVariable Integer cid, @PathVariable Integer bid,
			@PathVariable Integer lname, @PathVariable Integer lrid) throws Exception {
		return patientLoginService.paitentProformaproductView(cid, bid, lname, lrid);

	}

}
