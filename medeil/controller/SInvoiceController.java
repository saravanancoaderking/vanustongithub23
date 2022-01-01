package com.medeil.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StreamUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.medeil.domain.HoldSalesInvoiceProducts;
import com.medeil.domain.Holdsalesinvoice;
import com.medeil.domain.IndCompModel;
import com.medeil.domain.Journal;
import com.medeil.domain.SDProducts;
import com.medeil.domain.SalesDummy;
import com.medeil.service.SInvoiceService;

@SuppressWarnings("rawtypes")
@RestController
@RequestMapping("api/slsinv")
public class SInvoiceController {

	@Autowired
	SInvoiceService sinvoiceService;

	// private static String prescImgPath =
	// "D://files2/customerscustomisation1/cust change1/saimed25/New folder (5)/";
	private static String prescImgPath = "C://Users/Administrator/Desktop/PrescriptionImages/";

	private final Logger log = LoggerFactory.getLogger(SInvoiceController.class);

	@PostMapping(value = "/saveSalesInvoice")
	public List SaveSalesInvoice(@RequestBody SalesDummy si) throws Exception {
		System.out.println("inside sav");
		return sinvoiceService.SaveSalesInvoice(si);

	}
	/*convertsalesidcustomer
	 * @PostMapping(value = "/saveSalesInvoice") public int
	 * saveSalesInvoice(@RequestBody SalesDummy si) throws Exception {
	 * 
	 * return sinvoiceService.saveSalesInvoice(si);
	 * 
	 * }
	 */

	@ResponseBody
	@RequestMapping(value = "/saveSIProduct")
	public List saveSIProduct(@RequestBody List<SDProducts> si) throws Exception {

		return sinvoiceService.saveSIProduct(si);

	}

	@ResponseBody
	@RequestMapping(value = "/saveSISalesJournal")
	public int saveSalesJournal(@RequestBody Journal jrnl) throws Exception {

		return sinvoiceService.saveSalesJournal(jrnl);

	}

	@ResponseBody
	@RequestMapping(value = "/saveSIReceipt")
	public int saveReceipt(@RequestBody Journal jrnl) throws Exception {
		return sinvoiceService.saveReceipt(jrnl);
	}

	@ResponseBody
	@RequestMapping(value = "/UpdatePaySIReceipt")
	public int UpdatePaySIReceipt(@RequestBody List<Journal> jrnl) throws Exception {

		return sinvoiceService.UpdatePaySIReceipt(jrnl);

	}

	@ResponseBody
	@RequestMapping("/saveTempStock")
	public Double saveTempStock(@RequestBody IndCompModel loc) throws Exception {

		return sinvoiceService.saveTempStock(loc);

	}

	@ResponseBody
	@RequestMapping("/saveSIPresImage")
	public String savePresImage(@RequestParam("file") MultipartFile file, @RequestParam("locrefid") Integer locrefid,
			@RequestParam("locrefid") Integer locname) throws Exception {

		return sinvoiceService.savePresImage(file, locrefid, locname, this.prescImgPath);

	}

	@ResponseBody
	@RequestMapping(value = "/updateSalesInvoice", method = RequestMethod.POST)
	public int updateSalesInvoice(@RequestBody SalesDummy si) throws Exception {

		return sinvoiceService.updateSalesInvoice(si);

	}

	@ResponseBody
	@RequestMapping(value = "/updateSIProduct")
	public int updateSIProduct(@RequestBody List<SDProducts> si) throws Exception {

		return sinvoiceService.updateSIProduct(si);

	}

	@ResponseBody
	@RequestMapping("/updateTempStockMain")
	public Double updateTempStockMain(@RequestBody IndCompModel loc) throws Exception {

		return sinvoiceService.updateTempStockMain(loc);

	}

	@ResponseBody
	@RequestMapping("/viewSICustomers")
	public List viewCustomers(@RequestBody IndCompModel loc) throws Exception {

		return sinvoiceService.viewCustomers(loc);

	}

	@ResponseBody
	@RequestMapping("/viewSICustomers1")
	public List viewsoCustomers(@RequestBody IndCompModel loc) throws Exception {

		return sinvoiceService.viewsoCustomers(loc);

	}

	@ResponseBody
	@RequestMapping("/viewallcustomer")
	public List viewallcustomer(@RequestBody IndCompModel loc) throws Exception {

		return sinvoiceService.viewallcustomer(loc);

	}

	@ResponseBody
	@RequestMapping("/viewSIDoctors")
	public List viewDoctors(@RequestBody IndCompModel loc) throws Exception {

		return sinvoiceService.viewDoctors(loc);

	}

	@PostMapping(value = "/viewSalesOrderCustomer")
	public List viewSalesOrderCustomer(@RequestBody IndCompModel loc) throws Exception {

		return sinvoiceService.viewSalesOrderCustomer(loc);

	}

	@PostMapping(value = "/viewSalesOrderProd")
	public List viewSalesOrderProd(@RequestBody IndCompModel loc) throws Exception {
		return sinvoiceService.viewSalesOrderProd(loc);

	}

	// View Refill Order Products
	@PostMapping(value = "/viewRefillProd")
	public List viewRefillProd(@RequestBody IndCompModel loc) throws Exception {
		return sinvoiceService.viewRefillProd(loc);

	}

	@GetMapping("/viewSalesInvoiceAll/{cid}/{bid}/{lname}/{lrid}")
	public List viewSalesInvoiceAll(@PathVariable Integer cid, @PathVariable Integer bid, @PathVariable Integer lname,
			@PathVariable Integer lrid) throws Exception {
		return sinvoiceService.viewSalesInvoiceAll(cid, bid, lname, lrid);
	}

	// Pagination View Sales Invoice
	@GetMapping(value = "/viewPagingSalesInvoiceAll/{cid}/{bid}/{lname}/{lrid}/{pageno}/{size}")
	public Page viewPagingSalesInvoiceAll(@PathVariable Integer cid, @PathVariable Integer bid,
			@PathVariable Integer lname, @PathVariable Integer lrid, @PathVariable Integer pageno,
			@PathVariable Integer size) throws Exception {

		return sinvoiceService.viewPagingSalesInvoiceAll(cid, bid, lname, lrid, pageno, size);
	}

	@GetMapping(value = "/deletesalesinvoiceid/{id}")
	public boolean deletesi(@PathVariable Integer id) throws Exception {
		return sinvoiceService.sinvoiceService(id);
	}

	@ResponseBody
	@RequestMapping("/viewSISalesInvoice")
	public List viewSalesInvoice(@RequestBody IndCompModel loc) throws Exception {
		return sinvoiceService.viewSalesInvoice(loc);

	}

	@ResponseBody
	@RequestMapping("/viewSIProducts")
	public List viewSIProducts(@RequestBody IndCompModel loc) throws Exception {
		return sinvoiceService.viewSIProducts(loc);

	}

	@ResponseBody
	@RequestMapping("/GetSIProducts")
	public List GetSIProducts(@RequestBody IndCompModel loc) throws Exception {
		return sinvoiceService.GetSIProducts(loc);
	}

	@ResponseBody
	@RequestMapping("/viewSIProductNames")
	public List viewProductNames(@RequestBody IndCompModel loc) throws Exception {
		return sinvoiceService.viewProductNames(loc);
	}

	@ResponseBody
	@RequestMapping("/viewSIPdtNamesGeneric")
	public List viewPdtNamesGeneric(@RequestBody IndCompModel loc) throws Exception {
		return sinvoiceService.viewPdtNamesGeneric(loc);

	}

	// Puthiran 21/09/2020
	@ResponseBody
	@RequestMapping("/viewProductNamesBarcode")
	public List viewProductNamesBarcode(@RequestBody IndCompModel loc) throws Exception {
		return sinvoiceService.viewProductNamesBarcode(loc);

	}

	@PostMapping("/viewSIProductName")
	public List viewProductName(@RequestBody IndCompModel loc) throws Exception {

		return sinvoiceService.viewProductName(loc);

	}

	@ResponseBody
	@RequestMapping("/viewSIBarCodeProd")
	public List viewBarCodeProd(@RequestBody IndCompModel loc) throws Exception {
		return sinvoiceService.viewBarCodeProd(loc);

	}

	@ResponseBody
	@RequestMapping("/viewSIPriceSettings")
	public List viewPriceSettings(@RequestBody IndCompModel loc) throws Exception {
		return sinvoiceService.viewPriceSettings(loc);

	}

	@ResponseBody
	@RequestMapping("/viewSIDiscountSettings")
	public List viewDiscountSettings(@RequestBody IndCompModel loc) throws Exception {
		return sinvoiceService.viewDiscountSettings(loc);

	}

	@ResponseBody
	@RequestMapping("/viewSITaxSettings")
	public List viewTaxSettings(@RequestBody IndCompModel loc) throws Exception {
		return sinvoiceService.viewTaxSettings(loc);

	}

	@ResponseBody
	@RequestMapping("/viewSalesInvCustAll")
	public List viewSalesInvCustAll(@RequestBody IndCompModel loc) throws Exception {
		return sinvoiceService.viewSalesInvCustAll(loc);

	}

	@ResponseBody
	@RequestMapping("/viewProductNameDrug")
	public List viewProductNameDrug(@RequestBody IndCompModel loc) throws Exception {
		return sinvoiceService.viewProductNameDrug(loc);

	}

	@RequestMapping(value = "/viewPresImage")
	public ResponseEntity<byte[]> viewPresImage(@RequestParam("search") String search) throws IOException {
		String imgpath = this.prescImgPath + search;
		FileInputStream img = new FileInputStream(new File(imgpath));

		byte[] bytes = StreamUtils.copyToByteArray(img);

		return ResponseEntity.ok().body(bytes);

	}

	@ResponseBody
	@RequestMapping("/viewSalesDumCustAll")
	public List viewSalesDumCustAll(@RequestBody IndCompModel loc) throws Exception {
		return sinvoiceService.viewSalesDumCustAll(loc);

	}

	@ResponseBody
	@RequestMapping("/viewCustOutstandingTot")
	public List viewCustOutstandingTot(@RequestBody IndCompModel loc) throws Exception {
		return sinvoiceService.viewCustOutstandingTot(loc);

	}

	@ResponseBody
	@RequestMapping("/viewScheme")
	public List viewScheme(@RequestBody IndCompModel loc) throws Exception {
		return sinvoiceService.viewScheme(loc);

	}

	@ResponseBody
	@RequestMapping("/viewCustAmt")
	public Double viewCustAmt(@RequestBody IndCompModel loc) throws Exception {
		return sinvoiceService.viewCustAmt(loc);

	}

	@ResponseBody
	@RequestMapping("/viewCustInvoiceNo")
	public StringBuilder viewCustInvoiceNo(@RequestBody IndCompModel loc) throws Exception {
		return sinvoiceService.viewCustInvoiceNo(loc);

	}

	@ResponseBody
	@RequestMapping("/deleteSalesInvoice")
	public int deleteSalesInvoice(@RequestBody IndCompModel loc) throws Exception {
		return sinvoiceService.deleteSalesInvoice(loc);

	}

	/** SALES INVOICE LIST **/
	// Boopalan 090419
	@ResponseBody
	@RequestMapping("/salesinvoicelist")
	public List getSalesInvoiceList(@RequestBody IndCompModel loc) throws Exception {
		return sinvoiceService.getSalesInvoiceList(loc);
	}

	@PostMapping(value = "viewCustSalesorders")
	public List viewcustsono(@RequestBody IndCompModel loc) throws Exception {
		return sinvoiceService.viewcustsono(loc);

	}

	@PostMapping(value = "viewAllSalesorders")
	public List viewAllSalesorders(@RequestBody IndCompModel loc) throws Exception {
		return sinvoiceService.viewAllSalesorders(loc);

	}

	@PostMapping(value = "viewparticularcustomer")
	public List getparticularcustomer(@RequestBody IndCompModel loc) throws Exception {
		return sinvoiceService.getparticularcustomer(loc);
	}

	@PostMapping(value = "soparticularcustomer")
	public List soparticularcustomer(@RequestBody IndCompModel loc) throws Exception {
		return sinvoiceService.soparticularcustomer(loc);
	}

	@GetMapping(value = "/viewsocustomerlist/{cid}/{bid}/{lname}/{lrid}/{soid}")
	public List viewsocustomerlist(@PathVariable Integer cid, @PathVariable Integer bid, @PathVariable Integer lname,
			@PathVariable Integer lrid, @PathVariable Integer soid) throws Exception {

		return sinvoiceService.viewsocustomerlist(cid, bid, lname, lrid, soid);

	}

	// Accounts SalesInvoice Credit Note Save
	@ResponseBody
	@RequestMapping(value = "/invoicesaveCreditNote")
	public int saveCreditNote(@RequestBody Journal jrnl) throws Exception {

		return sinvoiceService.saveCreditNote(jrnl);

	}

	// Fetch Pending Payments by Customer wise Credit notes
	@PostMapping(value = "/getpendingpaylist")
	public List viewCustomerSalesInvoice(@RequestBody IndCompModel loc) throws Exception {
		return sinvoiceService.GetPendingPaymentsList(loc);
	}

	@PostMapping(value = "/updatecustpreviousbal")
	public Boolean UpdateCustBalance(@RequestBody IndCompModel loc) throws Exception {
		return sinvoiceService.UpdateCustBalance(loc);
	}

	@GetMapping(value = "/getsreturnpaylist/{compid}/{custid}")
	public List GetSReturnPaymentsList(@PathVariable Integer compid, @PathVariable Integer custid) throws Exception {
		return sinvoiceService.GetSReturnPaymentsList(compid, custid);
	}

	// Puthiran Hols Sales Bills
	@PostMapping(value = "/holdsalesinvoice")
	public boolean holdsalesinvoice(@RequestBody Holdsalesinvoice holdsi) {
		return sinvoiceService.holssalesinvoice(holdsi);
	}

	@PostMapping(value = "/holdsalesproducts")
	public ResponseEntity<Boolean> holdsalesproducts(@RequestBody List<HoldSalesInvoiceProducts> holdproducts) {
		return sinvoiceService.holdsalesproducts(holdproducts);
	}

	// view hold bills list
	@GetMapping(value = "/viewholdbills/{cid}/{bid}/{lname}/{lrid}")
	public List viewsocustomerlist(@PathVariable Integer cid, @PathVariable Integer bid, @PathVariable Integer lname,
			@PathVariable Integer lrid) {
		return sinvoiceService.viewholdbillslist(cid, bid, lname, lrid);
	}

	// view hold bill details
	@GetMapping(value = "getholdbilldetails/{id}")
	public Holdsalesinvoice getholdbilldetails(@PathVariable Integer id) {
		return sinvoiceService.getholdbilldetails(id);
	}

	// view hold bills product details
	@GetMapping(value = "getholdbillproddetails/{id}")
	public List<HoldSalesInvoiceProducts> getholdbillproddetails(@PathVariable Integer id) {
		return sinvoiceService.getholdbillproddetails(id);
	}

	@GetMapping(value = "/getsalesinvoicecount/{cid}/{bid}/{lname}/{lrid}")
	public List GetSalesInvoicecount(@PathVariable Integer cid, @PathVariable Integer bid, @PathVariable Integer lname,
			@PathVariable Integer lrid) {
		return sinvoiceService.GetSalesInvoicecount(cid, bid, lname, lrid);
	}

	// SIVAKUMAR- For converting sales order customers
	@PostMapping(value = "/convertsalesidcustomer")
	public List covertsalescustomer(@RequestBody IndCompModel loc) throws Exception {

		return sinvoiceService.convertsalescustomer(loc);

	}

	// SIVAKUMAR -X-Reading Over view
	@PostMapping(value = "x_read_overview")
	public List xReadOverView(@RequestBody IndCompModel loc) throws Exception {
		return sinvoiceService.xReadOverView(loc);
	}

	// SIVAKUMAR -X-Reading sales bills details
	@PostMapping(value = "x_read_sales_bills_details")
	public List xReadSalesDetails(@RequestBody IndCompModel loc) throws Exception {
		return sinvoiceService.xReadSalesDetails(loc);
	}

	// SIVAKUMAR -Z-Reading Over view
	@PostMapping(value = "z_read_overview")
	public List yReadOverView(@RequestBody IndCompModel loc) throws Exception {
		return sinvoiceService.zReadOverView(loc);
	}

	// SIVAKUMAR -Z-Reading sales bills details
	@PostMapping(value = "z_read_sales_bills_details")
	public List yReadSalesDetails(@RequestBody IndCompModel loc) throws Exception {
		return sinvoiceService.zReadSalesDetails(loc);
	}

	// Ajith Label view

	@GetMapping(value = "generate-label-details/{salesinvid}")
	public ResponseEntity<?> generateLabelDetails(@PathVariable Integer salesinvid) {
		return sinvoiceService.generateLabelDetails(salesinvid);
	}

	// Ajith
	@GetMapping("/viewSalesInvoiceIdBased/{cid}/{bid}/{lname}/{lrid}/{sid}")
	public List viewSalesInvoiceIdBased(@PathVariable Integer sid, @PathVariable Integer cid, @PathVariable Integer bid,
			@PathVariable Integer lname, @PathVariable Integer lrid) throws Exception {
		return sinvoiceService.viewSalesInvoiceIdBased(cid, bid, lname, lrid,sid);
	}

}
