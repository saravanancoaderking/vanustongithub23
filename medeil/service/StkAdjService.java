package com.medeil.service;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.medeil.domain.IndCompModel;
import com.medeil.domain.StockAdjust;
import com.medeil.repository.StkAdjRepository;
import com.medeil.util.AutoIncrement;

@Service
public class StkAdjService {

	private final StkAdjRepository stkadjrepo;

	private final Logger log = LoggerFactory.getLogger(StkAdjService.class);

	@Autowired
	StkAdjService(StkAdjRepository Stkadjrepo) {

		this.stkadjrepo = Stkadjrepo;

	}

	public int saveStockAdjust(List<StockAdjust> stkadj) throws Exception {
		int saveflag = 0;
		StockAdjust stk = stkadj.get(0);

		int incid = stkadjrepo.viewStockAdjId(stk.getLocname(), stk.getLocrefid());

		Integer incidnu = stkadjrepo.viewStockAdjIdNU(stk.getLocname(), stk.getLocrefid());
		String incno = stkadjrepo.viewStockAdjIncNo(stk.getLocname(), stk.getLocrefid(), incid);
		if (incno == null) {

			incno = "0";
		}

		if (incidnu == null) {

			incidnu = 0;

		}

		incidnu += 1;

		for (StockAdjust temp : stkadj) {

			if (temp.getCalcflag() != 1) {
				StringBuilder incr = new StringBuilder(AutoIncrement.getIncrement01(incno));

				incr.insert(0, "STK/ADJ");

				temp.setStkadjno(incr.toString());
				temp.setStkadjid(incidnu);
				stkadjrepo.updateMainstockSave(temp.getLocname(), temp.getLocrefid(), temp.getDrugproductid(),
						temp.getBatchrefid(), temp.getAdjustedstock());

				stkadjrepo.save(temp);

			}

		}
		saveflag = 1;
		return saveflag;

	}

	public int updateStockAdjust(List<StockAdjust> prc) throws Exception {
		int saveflag = 0;
		StockAdjust st = prc.get(0);

		stkadjrepo.updateMainstockEdit(st.getLocname(), st.getLocrefid(), st.getStkadjid());

		for (StockAdjust temp : prc) {
			if (temp.getCalcflag() != 1) {
				if (temp.getDelflag() == true) {
					temp.setStatus(5.0);

				} else {

					temp.setStatus(0.0);
				}

				stkadjrepo.updateMainstockSave(temp.getLocname(), temp.getLocrefid(), temp.getDrugproductid(),
						temp.getBatchrefid(), temp.getAdjustedstock());
				stkadjrepo.save(temp);

			}

		}

		saveflag = 1;
		return saveflag;

	}

	public List viewMainstocks(IndCompModel loc) throws Exception {

		return stkadjrepo.viewMainstocks(loc.getLocname(), loc.getLocrefid(), loc.getFrmstr1());
	}

	public List viewMainstock(IndCompModel loc) throws Exception {

		return stkadjrepo.viewMainstock(loc.getLocname(), loc.getLocrefid(), loc.getFrmint1(), loc.getFrmint2(),
				loc.getCompanyid());
	}

	public List viewStockAdjAll(IndCompModel loc) throws Exception {

		/*
		 * List<IndCompModel> ind46 =new ArrayList<IndCompModel> (); Sheet
		 * datatypeSheet=null; Iterator<Row> iterator = null;
		 * 
		 * 
		 * try {
		 * 
		 * FileInputStream excelFile = new FileInputStream(new File(
		 * "D://files2/customerscustomisation1/cust  change1/saimed25/Masters sai.xlsx"
		 * )); Workbook workbook = new XSSFWorkbook(excelFile); datatypeSheet =
		 * workbook.getSheetAt(0); iterator = datatypeSheet.iterator();
		 * 
		 * 
		 * while (iterator.hasNext()) {
		 * 
		 * 
		 * Row currentRow = iterator.next();
		 * 
		 * Iterator<Cell> cellIterator = currentRow.iterator();
		 * 
		 * IndCompModel ind45 = new IndCompModel();
		 * 
		 * while (cellIterator.hasNext()) {
		 * 
		 * Cell currentCell = cellIterator.next();
		 * 
		 * if (currentCell.getColumnIndex()== 2 && currentCell.getCellTypeEnum() ==
		 * CellType.STRING ) {
		 * 
		 * ind45.setFrmstr1(currentCell.getStringCellValue());
		 * 
		 * 
		 * } else if (currentCell.getColumnIndex()== 3 && currentCell.getCellTypeEnum()
		 * == CellType.STRING) {
		 * 
		 * 
		 * ind45.setFrmstr2(currentCell.getStringCellValue());
		 * 
		 * 
		 * 
		 * }
		 * 
		 * 
		 * }
		 * 
		 * ind46.add(ind45) ;
		 * 
		 * 
		 * System.out.println();
		 * 
		 * } } catch (FileNotFoundException e) { e.printStackTrace(); } catch
		 * (IOException e) { e.printStackTrace(); }
		 */

		return stkadjrepo.viewStockAdjAll(loc.getLocname(), loc.getLocrefid());

	}

	public List viewStockAdjust(IndCompModel loc) throws Exception {

		return stkadjrepo.viewStockAdjust(loc.getLocname(), loc.getLocrefid(), loc.getFrmint1(), loc.getCompanyid());

	}

	public int deleteStockAdj(IndCompModel loc) throws Exception {
		int saveflag = 0;
		stkadjrepo.deleteStockAdj(loc.getLocname(), loc.getLocrefid(), loc.getFrmint1());
		saveflag = 1;
		return saveflag;

	}

	public List viewStockAdjAll57(MultipartFile file) throws Exception {

		List<IndCompModel> ind46 = new ArrayList<IndCompModel>();
		Sheet datatypeSheet = null;
		Iterator<Row> iterator = null;

		try {

			byte[] bytes = file.getBytes();

			File serverFile = new File(
					"D://files2/customerscustomisation1/cust  change1/saimed25/" + file.getOriginalFilename());
			BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(serverFile));

			stream.write(bytes);
			stream.close();

			FileInputStream excelFile = new FileInputStream(serverFile);

			Workbook workbook = new XSSFWorkbook(excelFile);
			datatypeSheet = workbook.getSheetAt(0);
			iterator = datatypeSheet.iterator();

			while (iterator.hasNext()) {

				Row currentRow = iterator.next();

				Iterator<Cell> cellIterator = currentRow.iterator();

				IndCompModel ind45 = new IndCompModel();

				while (cellIterator.hasNext()) {

					Cell currentCell = cellIterator.next();

					if (currentCell.getColumnIndex() == 2 && currentCell.getCellTypeEnum() == CellType.STRING) {

						ind45.setFrmstr1(currentCell.getStringCellValue());

					} else if (currentCell.getColumnIndex() == 3 && currentCell.getCellTypeEnum() == CellType.STRING) {

						ind45.setFrmstr2(currentCell.getStringCellValue());

					}

				}

				ind46.add(ind45);

				System.out.println();

			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			throw new Exception(e);
		} catch (IOException e) {
			e.printStackTrace();
			throw new IOException(e);
		}

		// return stkadjrepo.viewStockAdjAll(loc.getLocrefid(),
		// loc.getLocname());

		return ind46;

	}

}
