package com.medeil.service;

import java.util.HashMap;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.medeil.domain.Account;
import com.medeil.domain.AccountBalance;
import com.medeil.domain.AccountName;
import com.medeil.domain.BankDetails;
import com.medeil.domain.Cheque;
import com.medeil.domain.IndCompModel;
import com.medeil.repository.AccountRepository;
import com.medeil.repository.AccountnameRepository;
import com.medeil.repository.BankdetailsRepository;
import com.medeil.repository.ChequeRepository;

@Service
public class AccountService {

	private final AccountRepository accountRepo;

	private final AccountnameRepository accountnameRepository;

	private final BankdetailsRepository bankdetailsRepository;

	private final ChequeRepository chequeRepository;

	private final Logger log = LoggerFactory.getLogger(AccountService.class);

	@Autowired
	AccountService(AccountRepository AccountRepo, AccountnameRepository AccountnameRepository,
			BankdetailsRepository BankRepository, ChequeRepository ChequeRepository) {
		this.accountnameRepository = AccountnameRepository;
		this.accountRepo = AccountRepo;
		this.bankdetailsRepository = BankRepository;
		this.chequeRepository = ChequeRepository;
	}

	public int saveAccount(List<Account> ac) throws Exception {

		int saveflag = 0;
		for (Account account : ac) {
			Integer isexist = accountRepo.isexist(account.getAccountno(), account.getAccounttype(),
					account.getAccountname());
			System.out.print("Exists:" + isexist);

			if (isexist != 0) {
				saveflag = 0;
			} else {
				AccountName accountName = new AccountName();
				boolean result = accountnameRepository.existsByAccountname(account.getAccountname());
				if (result == true) {
					System.out.println("::::::::Ok");
					AccountName acid = accountnameRepository.findByAccountname(account.getAccountname());
					System.out.println("NewOk:" + acid);
					account.setAccountid(acid.getId());
				} else {
					accountName.setAccountname(account.getAccountname());
					accountName.setAcctyperefid(account.getAccounttypeno());
					Integer id = accountnameRepository.save(accountName).getId();
					accountName.setAccstandardid(id);
					accountnameRepository.save(accountName);
					System.out.println("OkElse::::" + id);
					account.setAccountid(id);

				}

				accountRepo.save(account);
				// accountRepo.updateAccountId(temp.getId());

				saveflag = 1;
			}

		}
		return saveflag;

	}

	public int saveAccBalance(List<AccountBalance> locall) throws Exception {
		int saveflag = 0;
		AccountBalance bal = locall.get(0);

		String fromdate = accountRepo.viewOpeningDate(bal.getLocname(), bal.getLocrefid());

		for (AccountBalance loc : locall) {

			accountRepo.saveAccBalance(loc.getLocname(), loc.getLocrefid(), loc.getAccid(), loc.getOpeningbal(),
					loc.getClosingbal(), fromdate, loc.getTodate(), loc.getCreatedby());
			accountRepo.saveAccBalance_01(loc.getLocname(), loc.getLocrefid(), loc.getAccid(), loc.getOpeningbal(),
					loc.getClosingbal(), fromdate, loc.getTodate(), loc.getCreatedby());

			accountRepo.updateAccBalMain(loc.getLocname(), loc.getLocrefid(), loc.getAccid(), loc.getClosingbal());
		}
		accountRepo.saveTempAccTrnsfer_02(bal.getLocname(), bal.getLocrefid(), fromdate, bal.getTodate(),
				bal.getCreatedby());

		saveflag = 1;
		return saveflag;

	}

	public int saveTempAccTrnsfer(IndCompModel loc) throws Exception {
		int saveflag = 0;
		String fromdate = accountRepo.viewOpeningDate(loc.getLocname(), loc.getLocrefid());
		/*
		 * accountRepo.saveTempAccTrnsfer(loc.getLocname(), loc.getLocrefid(),
		 * loc.getFrmdbl1(), loc.getFrmdbl1(), fromdate, loc.getFrmstr2(),
		 * loc.getFrmstr2(), loc.getFrmstr3(), loc.getCreatedby());
		 */

		saveflag = 1;
		return saveflag;

	}

	public List viewBalanceSheet(IndCompModel loc) throws Exception {

		String fromdate = accountRepo.viewOpeningDate(loc.getLocname(), loc.getLocrefid());
		return accountRepo.viewBalanceSheet(loc.getLocname(), loc.getLocrefid(), fromdate, loc.getFrmstr2());

	}

	public List viewCashFlowStmt(IndCompModel loc) throws Exception {

		String fromdate = accountRepo.viewOpeningDate(loc.getLocname(), loc.getLocrefid());
		return accountRepo.viewCashFlowStmt(loc.getLocname(), loc.getLocrefid(), fromdate, loc.getFrmstr2());

	}

	public List viewTrialBalance(IndCompModel loc) throws Exception {
		String fromdate = accountRepo.viewOpeningDate(loc.getLocname(), loc.getLocrefid());

		return accountRepo.viewTrialBalance(loc.getLocname(), loc.getLocrefid(), fromdate, loc.getFrmstr2());

	}

	public List viewPLAccount(IndCompModel loc) throws Exception {

		String fromdate = accountRepo.viewOpeningDate(loc.getLocname(), loc.getLocrefid());
		return accountRepo.viewPLAccount(loc.getLocname(), loc.getLocrefid(), fromdate, loc.getFrmstr2());

	}

	public List viewdayBook(IndCompModel loc) throws Exception {

		return accountRepo.viewdayBook(loc.getLocname(), loc.getLocrefid(), loc.getFrmstr1());

	}

	public List viewGenLedger(IndCompModel loc) throws Exception {

		String fromdate = accountRepo.viewOpeningDate(loc.getLocname(), loc.getLocrefid());
		return accountRepo.viewGenLedger(loc.getLocname(), loc.getLocrefid(), fromdate, loc.getFrmstr2(),
				loc.getFrmint1());

	}

	public List viewAccountsAll(IndCompModel loc) throws Exception {

		return accountRepo.viewAccountsAll(loc.getLocname(), loc.getLocrefid());

	}

	public List viewAccountType(IndCompModel loc) throws Exception {

		return accountRepo.viewAccountType();

	}

	public List AccTypeLists(Integer cid, Integer bid, Integer lname, Integer lrid, Integer accid) throws Exception {
		return accountRepo.AccTypeLists(cid, bid, lname, lrid, accid);
	}

	// Update Accbalance
	public int UpdateAccBalance(Account acc) throws Exception {
		Integer prevbal = accountRepo.getprevaccbalance(acc.getId());
		String updatebal = String.valueOf((prevbal + (Integer.valueOf(acc.getAccbalance()))));
		accountRepo.setNewAccBalance(acc.getId(), updatebal);
		return 1;
	}

	/* New Account Balance Sheet for new Customer */
	public List Newbalancesheet(Integer cid, Integer bid, Integer lname, Integer lrid, String enddate)
			throws Exception {
		String startdate = accountRepo.viewOpeningDate(lname, lrid);
		return accountRepo.Newbalancesheet(lname, lrid, startdate, enddate);
	}

	public List Newledgerall(Integer cid, Integer bid, Integer lname, Integer lrid, String enddate, Integer personid,
			Integer status, Integer persontype) throws Exception {
		String startdate = accountRepo.viewOpeningDate(lname, lrid);
		if (status == 0) {
			return accountRepo.Newledgerall(lname, lrid, startdate, enddate);
		} else {
			return accountRepo.customerledger(lname, lrid, startdate, enddate, personid, persontype);
		}

	}
	
	public List ViewBankledgerall(Integer cid, Integer bid, Integer lname, Integer lrid, Integer bankid) {
		return accountRepo.ViewBankledgerall(lname, lrid, bankid);
	}


	public List Custlist(Integer cid, Integer bid, Integer lname, Integer lrid) throws Exception {
		return accountRepo.Custlist(lrid);
	}

	public ResponseEntity<Boolean> saveBank(BankDetails bank) throws Exception {
		bankdetailsRepository.save(bank);
		return ResponseEntity.created(null).body(true);
	}

	public List Banklist(Integer cid, Integer bid, Integer lname, Integer lrid) throws Exception {
		return accountRepo.Banklist(lrid);
	}

	public BankDetails bankEdit(Integer id) throws Exception {
		return bankdetailsRepository.findById(id);
	}

	public List bankAccountno(Integer cid, Integer bid, Integer sid) {
		return bankdetailsRepository.bankAccountno(cid, bid, sid);
	}

	public List Chequelist(Integer cid, Integer bid, Integer shid) {
		return accountRepo.Chequelist(cid, bid, shid);
	}

	public ResponseEntity<Boolean> saveCheque(Cheque cheque) {
		chequeRepository.save(cheque);
		return ResponseEntity.created(null).body(true);
	}

	public List Viewtotalpurchase(Integer cid, Integer bid, Integer lname, Integer lrid, String enddate) {
		String startdate = accountRepo.viewOpeningDate(lname, lrid);
		return accountRepo.Viewtotalpurchase(lname, lrid, startdate, enddate);
	}

	public List Viewtotalsales(Integer cid, Integer bid, Integer lname, Integer lrid, String enddate) {
		String startdate = accountRepo.viewOpeningDate(lname, lrid);
		return accountRepo.Viewtotalsales(lname, lrid, startdate, enddate);
	}

	public List Openingstkamnt(Integer cid, Integer bid, Integer lname, Integer lrid, String enddate) {
		String startdate = accountRepo.viewOpeningDate(lname, lrid);
		return accountRepo.Openingstkamnt(lname, lrid, startdate, enddate);
	}

	public List Closingstkamnt(Integer cid, Integer bid, Integer lname, Integer lrid, String enddate) {
		String startdate = accountRepo.viewOpeningDate(lname, lrid);
		return accountRepo.Closingstkamnt(lname, lrid, startdate, enddate);
	}

	public List openingbal(Integer cid, Integer bid, Integer lname, Integer lrid, String enddate) {
		String startdate = accountRepo.viewOpeningDate(lname, lrid);
		return accountRepo.openingbal(lname, lrid, startdate, enddate);
	}

	public ResponseEntity<?> Depitamt(Integer locrefid, Integer persionid) {
		String Depitamt = accountRepo.Depitamt(locrefid, persionid);

		return ResponseEntity.created(null).body(Depitamt);
	}

	public ResponseEntity<?> Creditamt(Integer locrefid, Integer persionid) {
		String Creditamt = accountRepo.Creditamt(locrefid, persionid);
		return ResponseEntity.created(null).body(Creditamt);
	}

	public ResponseEntity<?> viewAccountBalanceDetails(Integer actid, Integer lname, Integer lrid) {
		String viewAccountBalanceDetails = accountRepo.viewAccountBalanceDetails(lname, lrid);
		return ResponseEntity.created(null).body(viewAccountBalanceDetails);
	}


	// public List viewAccountSalesReturn() {

	// return accountRepo.viewAccountSalesReturn("2001-01-02", "2029-01-02", 0,
	// 0);

	// }

	/*
	 * public List viewGenLedger() {
	 * 
	 * return accountRepo.viewGenLedger("2001-01-02", "2029-01-02", 0, 0, 2);
	 * 
	 * }
	 */

}
