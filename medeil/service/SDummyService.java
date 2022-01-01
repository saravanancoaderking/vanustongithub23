package com.medeil.service;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.medeil.domain.IndCompModel;
import com.medeil.domain.Journal;
import com.medeil.domain.SDProducts;
import com.medeil.domain.SalesDummy;
import com.medeil.repository.SDProductsRepository;
import com.medeil.repository.SDummyRepository;
import com.medeil.repository.SJournalRepository;
import com.medeil.util.AutoIncrement;

@Service
public class SDummyService {

	private final SDummyRepository sdummyRepo;

	private final SDProductsRepository sdproductRepo;

	private final SJournalRepository sjournalRepo;

	private final Logger log = LoggerFactory.getLogger(SDummyService.class);

	@Autowired
	SDummyService(SDummyRepository SdummyRepo, SDProductsRepository SdproductRepo, SJournalRepository SjournalRepo) {

		this.sdummyRepo = SdummyRepo;

		this.sdproductRepo = SdproductRepo;

		this.sjournalRepo = SjournalRepo;

	}

	public int saveSalesDummy(SalesDummy sd) throws Exception {
		int saveflag = 0;
		Integer incid = sdummyRepo.viewSalesDummyId(sd.getLocname(), sd.getLocrefid());

		String incno = sdummyRepo.viewSalesDummyIncNo(sd.getLocname(), sd.getLocrefid(), incid);

		if (incno == null) {

			incno = "0";
		}

		// StringBuilder incr = new StringBuilder(
		// AutoIncrement.getIncrement01(incno));
		// incr.insert(0, "SLS/DUM");

		StringBuilder incr = new StringBuilder(AutoIncrement.getIncrement03("SLS/DUM/", sd.getLocname().toString(),
				sd.getLocrefid().toString(), incno));

		sd.setSalesbillno(incr.toString());
		sd.setSalesbilltype("2");
		sdummyRepo.save(sd);

		saveflag = 1;
		return saveflag;

	}

	public int saveSDProduct(List<SDProducts> sd) throws Exception {
		int saveflag = 0;
		SDProducts sdinc = sd.get(0);

		int id = sdummyRepo.viewSalesDummyId(sdinc.getLocname(), sdinc.getLocrefid());

		for (SDProducts temp : sd) {

			if (temp.getCalcflag() != 1) {
				temp.setSalesrefid(id);

				sdproductRepo.save(temp);

			}

		}
		saveflag = 1;
		return saveflag;

	}

	public int saveSalesJournal(Journal jrnl) throws Exception {
		int saveflag = 0;
		Double incid = sjournalRepo.viewSjournalId(jrnl.getLocname(), jrnl.getLocrefid());

		String incno = sjournalRepo.viewSjournalIncNo(jrnl.getLocname(), jrnl.getLocrefid(), incid);

		// StringBuilder incr = new StringBuilder(
		// AutoIncrement.getIncrement01(incno));

		// incr.insert(0, "SLS/JRNL");
		StringBuilder incr = new StringBuilder(AutoIncrement.getIncrement03("SLS/JRNL/", jrnl.getLocname().toString(),
				jrnl.getLocrefid().toString(), incno));

		jrnl.setCreditamount(jrnl.getDebitamount());
		jrnl.setJournalno(incr.toString());
		sjournalRepo.save(jrnl);

		saveflag = 1;
		return saveflag;

	}

	public String savePresImage(MultipartFile file, double locrefid, double locname) throws Exception {
		int saveflag = 0;

		String path;

		String path1 = null;

		try {

			byte[] bytes = file.getBytes();

			Integer i = sdummyRepo.viewSalesDummyId(locrefid, locname);
			if (i == null || i == 0) {
				path = "D://files2/customerscustomisation1/cust  change1/saimed25/" + "s" + (int) locrefid + "_"
						+ (int) locname + "_" + file.getOriginalFilename();

				path1 = "s" + (int) locrefid + "_" + (int) locname + "_" + file.getOriginalFilename();
			} else {
				path = "D://files2/customerscustomisation1/cust  change1/saimed25/" + i + "_"
						+ file.getOriginalFilename();

				path1 = i + "_" + file.getOriginalFilename();

			}

			File serverFile = new File(path);
			BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(serverFile));

			stream.write(bytes);
			stream.close();

		} catch (FileNotFoundException e) {
			e.printStackTrace();
			throw new Exception(e);
		} catch (IOException e) {
			e.printStackTrace();
			throw new Exception(e);
		}

		return path1;
	}

	public int updateSalesDummy(SalesDummy sd) throws Exception {
		int saveflag = 0;
		sdummyRepo.save(sd);
		saveflag = 1;
		return saveflag;

	}

	public int updateSDProduct(List<SDProducts> sd) throws Exception {
		int saveflag = 0;
		try {

			SDProducts sdp = sd.get(0);
			for (SDProducts temp : sd) {

				if (temp.getCalcflag() != 1) {
					if (temp.getDelflag() == true) {
						temp.setStatus(5.0);

					} else {

						temp.setStatus(0.0);
					}

					// temp.setSalesrefid(sdp.getSalesrefid());
					sdproductRepo.save(temp);

				}

			}

		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e);
		}
		saveflag = 1;
		return saveflag;

	}

	public List viewCustomers(IndCompModel loc) throws Exception {

		return sdummyRepo.viewCustomers(loc.getLocname(), loc.getLocrefid());

	}

	public List viewDoctors(IndCompModel loc) throws Exception {

		return sdummyRepo.viewDoctors(loc.getLocname(), loc.getLocrefid());

	}

	public List viewSalesDummyAll(IndCompModel loc) throws Exception {

		return sdummyRepo.viewSalesDummyAll(loc.getLocname(), loc.getLocrefid());

	}

	public List viewSalesDummy(IndCompModel loc) throws Exception {

		return sdummyRepo.viewSalesDummy(loc.getLocname(), loc.getLocrefid(), loc.getFrmint1());

	}

	public List viewSDProducts(IndCompModel loc) throws Exception {

		return sdproductRepo.viewSDProducts(loc.getLocname(), loc.getLocrefid(), loc.getFrmint1(), loc.getCompanyid());

	}

	public List viewProductNames(IndCompModel loc) throws Exception {

		return sdummyRepo.viewProductNames(loc.getLocname(), loc.getLocrefid(), loc.getFrmstr1(), loc.getCompanyid());

	}

	public List viewProductName(IndCompModel loc) throws Exception {

		return sdummyRepo.viewProductName(loc.getLocname(), loc.getLocrefid(), loc.getFrmint1(), loc.getCompanyid());

	}

	public List viewBarCodeProd(IndCompModel loc) throws Exception {

		return sdummyRepo.viewBarCodeProd(loc.getLocname(), loc.getLocrefid(), loc.getFrmstr1(), loc.getCompanyid());

	}

	public List viewPriceSettings(IndCompModel loc) throws Exception {

		return sdummyRepo.viewPriceSettings(loc.getLocname(), loc.getLocrefid());

	}

	public List viewDiscountSettings(IndCompModel loc) throws Exception {

		return sdummyRepo.viewDiscountSettings(loc.getLocname(), loc.getLocrefid());

	}

	public StringBuilder viewInvoiceNoInc(IndCompModel loc) throws Exception {

		Integer incid = sdummyRepo.viewSalesDummyId((double) loc.getLocname(), (double) loc.getLocrefid());

		String incno = sdummyRepo.viewSalesDummyIncNo((double) loc.getLocname(), (double) loc.getLocrefid(), incid);

		if (incno == null) {

			incno = "0";
		}
		// StringBuilder incr = new StringBuilder(
		// AutoIncrement.getIncrement01(incno));

		// incr.insert(0, "SLS/DUM");
		StringBuilder incr = new StringBuilder(
				AutoIncrement.getIncrement03("SLS/DUM/", loc.getLocname() + "", loc.getLocrefid() + "", incno));

		return incr;

	}

	public int deleteSalesDummy(IndCompModel loc) throws Exception {
		int saveflag = 0;
		sdummyRepo.deleteSalesDummy(loc.getLocname(), loc.getLocrefid(), loc.getFrmint1());
		saveflag = 1;
		return saveflag;

	}

}
