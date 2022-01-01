package com.medeil.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.medeil.domain.Account;
import com.medeil.domain.AccountBalance;
import com.medeil.domain.BankDetails;
import com.medeil.domain.Cheque;
import com.medeil.domain.IndCompModel;
import com.medeil.service.AccountService;

@RestController
@RequestMapping("api/accounts")
public class AccountController {

	@Autowired
	AccountService accountService;
	//
	private final Logger log = LoggerFactory.getLogger(AccountController.class);

	@ResponseBody
	@RequestMapping(value = "/saveAccount")
	public int saveAccount(@RequestBody List<Account> ac) throws Exception {

		return accountService.saveAccount(ac);

	}

	@ResponseBody
	@RequestMapping(value = "/saveAccBalance")
	public int saveAccBalance(@RequestBody List<AccountBalance> loc) throws Exception {

		return accountService.saveAccBalance(loc);

	}

	@ResponseBody
	@RequestMapping(value = "/saveTempAccTrnsfer")
	public int saveTempAccTrnsfer(@RequestBody IndCompModel loc) throws Exception {

		return accountService.saveTempAccTrnsfer(loc);

	}

	@ResponseBody
	@RequestMapping(value = "/viewBalanceSheet")
	public List viewBalanceSheet(@RequestBody IndCompModel loc) throws Exception {

		return accountService.viewBalanceSheet(loc);

	}

	@ResponseBody
	@RequestMapping("/viewCashFlowStmt")
	public List viewCashFlowStmt(@RequestBody IndCompModel loc) throws Exception {

		return accountService.viewCashFlowStmt(loc);
	}

	@ResponseBody
	@RequestMapping(value = "/viewTrialBalance")
	public List viewTrialBalance(@RequestBody IndCompModel loc) throws Exception {

		return accountService.viewTrialBalance(loc);

	}

	@ResponseBody
	@RequestMapping("/viewPLAccount")
	public List viewPLAccount(@RequestBody IndCompModel loc) throws Exception {

		return accountService.viewPLAccount(loc);
	}

	@ResponseBody
	@RequestMapping("/viewdayBook")
	public List viewdayBook(@RequestBody IndCompModel loc) throws Exception {

		return accountService.viewdayBook(loc);
	}

	@ResponseBody
	@RequestMapping("/viewAccountsAll")
	public List viewAccountsAll(@RequestBody IndCompModel loc) throws Exception {

		return accountService.viewAccountsAll(loc);
	}

	@ResponseBody
	@RequestMapping("/viewAccountType")
	public List viewAccountType(@RequestBody IndCompModel loc) throws Exception {

		return accountService.viewAccountType(loc);
	}

	// view account type lists
	@GetMapping(value = "/GetAccTypeLists/{cid}/{bid}/{lname}/{lrid}/{accid}")
	public List AccTypeLists(@PathVariable Integer cid, @PathVariable Integer bid, @PathVariable Integer lname,
			@PathVariable Integer lrid, @PathVariable Integer accid) throws Exception {
		return accountService.AccTypeLists(cid, bid, lname, lrid, accid);

	}

	// Update AccBalance
	@ResponseBody
	@RequestMapping("/UpdateAccBalance")
	public int UpdateAccBalance(@RequestBody Account acc) throws Exception {
		return accountService.UpdateAccBalance(acc);
	}

	@ResponseBody
	@RequestMapping("/viewGenLedger")
	public List viewGenLedger(@RequestBody IndCompModel loc) throws Exception {

		return accountService.viewGenLedger(loc);
	}

	/*
	 * @ResponseBody
	 * 
	 * @RequestMapping(value = "/viewGenLedger") public List viewGenLedger() {
	 * 
	 * return accountService.viewGenLedger();
	 * 
	 * }
	 */

	// @ResponseBody
	// @RequestMapping("/viewAccountSales")
	// public List viewAccountSales() {

	// return accountService.viewAccountSales();
	// }

	/* New Account Balance Sheet for new Customer */
	@GetMapping(value = "/Viewnewbalancesheet/{cid}/{bid}/{lname}/{lrid}/{enddate}")
	public List Newbalancesheet(@PathVariable Integer cid, @PathVariable Integer bid, @PathVariable Integer lname,
			@PathVariable Integer lrid, @PathVariable String enddate) throws Exception {
		return accountService.Newbalancesheet(cid, bid, lname, lrid, enddate);

	}

	/* New Account Ledger */
	@GetMapping(value = "/Viewledgerdetails/{cid}/{bid}/{lname}/{lrid}/{enddate}/{personid}/{status}/{persontype}")
	public List Newledgerall(@PathVariable Integer cid, @PathVariable Integer bid, @PathVariable Integer lname,
			@PathVariable Integer lrid, @PathVariable String enddate, @PathVariable Integer personid,
			@PathVariable Integer status, @PathVariable Integer persontype) throws Exception {
		return accountService.Newledgerall(cid, bid, lname, lrid, enddate, personid, status, persontype);
	}
	
	@GetMapping(value = "/ViewBankledgerdetails/{cid}/{bid}/{lname}/{lrid}/{bankid}")
	public List ViewBankledgerall(@PathVariable Integer cid, @PathVariable Integer bid, @PathVariable Integer lname,
			@PathVariable Integer lrid,  @PathVariable Integer bankid) throws Exception {
		return accountService.ViewBankledgerall(cid, bid, lname, lrid, bankid);
	}

	/* Customer List */
	@GetMapping(value = "/ViewCustlist/{cid}/{bid}/{lname}/{lrid}")
	public List Custlist(@PathVariable Integer cid, @PathVariable Integer bid, @PathVariable Integer lname,
			@PathVariable Integer lrid) throws Exception {
		return accountService.Custlist(cid, bid, lname, lrid);

	}

	@PostMapping(value = "/saveBankdetails")
	public ResponseEntity<Boolean> saveBank(@RequestBody BankDetails bank) throws Exception {

		return accountService.saveBank(bank);

	}

	/* Bank List */
	@GetMapping(value = "/ViewBanklist/{cid}/{bid}/{lname}/{lrid}")
	public List Banklist(@PathVariable Integer cid, @PathVariable Integer bid, @PathVariable Integer lname,
			@PathVariable Integer lrid) throws Exception {
		return accountService.Banklist(cid, bid, lname, lrid);

	}

	@GetMapping(value = "/bankid/{id}")
	public BankDetails bankEdit(@PathVariable Integer id) throws Exception {
		return accountService.bankEdit(id);
	}

	@GetMapping(value = "/getBankaccno/{cid}/{bid}/{sid}")
	public List bankAccountno(@PathVariable Integer cid, @PathVariable Integer bid, @PathVariable Integer sid)
			throws Exception {
		return accountService.bankAccountno(cid, bid, sid);
	}

	/* cheque List */
	@GetMapping(value = "/ViewChequelist/{cid}/{bid}/{shid}")
	public List Chequelist(@PathVariable Integer cid, @PathVariable Integer bid, @PathVariable Integer shid)
			throws Exception {
		return accountService.Chequelist(cid, bid, shid);

	}

	@PostMapping(value = "/saveChequedetails")
	public ResponseEntity<Boolean> saveCheque(@RequestBody Cheque cheque) throws Exception {

		return accountService.saveCheque(cheque);

	}

	/* Total Purchase Account */
	@GetMapping(value = "/Viewtotalpurchase/{cid}/{bid}/{lname}/{lrid}/{enddate}")
	public List Viewtotalpurchase(@PathVariable Integer cid, @PathVariable Integer bid, @PathVariable Integer lname,
			@PathVariable Integer lrid, @PathVariable String enddate) throws Exception {
		return accountService.Viewtotalpurchase(cid, bid, lname, lrid, enddate);

	}

	/* Total Sales Account */
	@GetMapping(value = "/Viewtotalsales/{cid}/{bid}/{lname}/{lrid}/{enddate}")
	public List Viewtotalsales(@PathVariable Integer cid, @PathVariable Integer bid, @PathVariable Integer lname,
			@PathVariable Integer lrid, @PathVariable String enddate) throws Exception {
		return accountService.Viewtotalsales(cid, bid, lname, lrid, enddate);

	}

	/* Opening stock Amount */
	@GetMapping(value = "/openstkamount/{cid}/{bid}/{lname}/{lrid}/{enddate}")
	public List Openingstkamnt(@PathVariable Integer cid, @PathVariable Integer bid, @PathVariable Integer lname,
			@PathVariable Integer lrid, @PathVariable String enddate) throws Exception {
		return accountService.Openingstkamnt(cid, bid, lname, lrid, enddate);

	}

	/* Closing stock Amount */
	@GetMapping(value = "/closestkamount/{cid}/{bid}/{lname}/{lrid}/{enddate}")
	public List Closingstkamnt(@PathVariable Integer cid, @PathVariable Integer bid, @PathVariable Integer lname,
			@PathVariable Integer lrid, @PathVariable String enddate) throws Exception {
		return accountService.Closingstkamnt(cid, bid, lname, lrid, enddate);

	}

	/* opening balt */
	@GetMapping(value = "/Openingbal/{cid}/{bid}/{lname}/{lrid}/{enddate}")
	public List openingbal(@PathVariable Integer cid, @PathVariable Integer bid, @PathVariable Integer lname,
			@PathVariable Integer lrid, @PathVariable String enddate) throws Exception {
		return accountService.openingbal(cid, bid, lname, lrid, enddate);

	}

	@GetMapping(value = "/ViewDepitamt/{locrefid}/{persionid}")
	public ResponseEntity<?> Depitamt(@PathVariable Integer locrefid, @PathVariable Integer persionid)
			throws Exception {
		return accountService.Depitamt(locrefid, persionid);
	}

	@GetMapping(value = "/ViewCreditamt/{locrefid}/{persionid}")
	public ResponseEntity<?> Creditamt(@PathVariable Integer locrefid, @PathVariable Integer persionid)
			throws Exception {
		return accountService.Creditamt(locrefid, persionid);
	}

	@GetMapping(value = "/view-account-balance-details/{actid}/{lname}/{lrid}")
	public ResponseEntity<?> viewAccountBalanceDetails(@PathVariable Integer actid, @PathVariable Integer lname,
			@PathVariable Integer lrid) throws Exception {
		return accountService.viewAccountBalanceDetails(actid, lname, lrid);

	}

}
