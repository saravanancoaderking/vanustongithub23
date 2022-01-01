/**
 * 
 */
package com.medeil.service;

import java.awt.image.BufferedImage;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.ParameterMode;
import javax.persistence.PersistenceContext;
import javax.persistence.StoredProcedureQuery;

import org.apache.commons.io.output.ByteArrayOutputStream;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.json.JSONObject;
import org.krysalis.barcode4j.impl.code128.Code128Bean;
import org.krysalis.barcode4j.output.bitmap.BitmapCanvasProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.oned.Code128Writer;
import com.google.zxing.qrcode.QRCodeWriter;
import com.medeil.domain.Barqrsettings;
import com.medeil.domain.Distributor;
import com.medeil.domain.Stocks;
import com.medeil.repository.Barqrrepository;
import com.medeil.repository.DistributorRepository;
import com.medeil.repository.StocksRepository;

/**
 * @author Ajith Kumar
 *
 */
@SuppressWarnings("rawtypes")
@Service
public class StocksService {
	@Autowired
	private StocksRepository repository;

	@Autowired
	private Barqrrepository barqrrepository;

	@Autowired
	private DistributorRepository distrepo;

	@PersistenceContext
	private EntityManager em;

	private static Logger logger = LogManager.getLogger();

	public List getStockProduct(String product, Integer cid, Integer bid, Integer locrefid, Integer locname)
			throws Exception {
		return repository.getStockProduct(product, cid);
	}

	public List getProDosage(Integer id) throws Exception {
		return repository.getProDosage(id);
	}

	public List getProFormulation(Integer id) throws Exception {
		return repository.getProFormulation(id);
	}

	public boolean updateStock(Stocks stocks) throws Exception {
		boolean reFlag = false;
		try {
			if (!stocks.equals("") || !stocks.equals(null)) {
				repository.updateMinimumStock(stocks.getCompanyrefid(), stocks.getBranchrefid(), stocks.getLocname(),
						stocks.getLocrefid(), stocks.getDrugproductid());
				repository.ministkrefid(stocks.getCompanyrefid(), stocks.getBranchrefid(), stocks.getLocname(),
						stocks.getLocrefid(), stocks.getDrugproductid());
				repository.save(stocks);
				reFlag = true;
			} else {
				reFlag = false;
			}
		} catch (Exception e) {
			logger.error("Exception in Method : updateStock() " + e);
			e.printStackTrace();
			// throw new Exception(e);
		}
		return reFlag;
	}

	// Boopalan 04062019
	public Page viewStock(Integer cid, Integer bid, Integer locrefid, Integer locname, Integer pageno, Integer size)
			throws Exception {

		// Page page = null;
		// try {
		Pageable paging = PageRequest.of(pageno, size);
		return repository.viewStocks(cid, bid, locrefid, locname, paging);
		// System.out.println(page.getTotalPages());
		// } catch (Exception ex) {
		// logger.error("Exception in Method : viewStocks() : " + ex);
		// }

		// return page;
	}

	// Boopalan 04062019
	public Page searchstockitems(Integer cid, Integer bid, Integer locrefid, Integer locname, Integer searchindex,
			String searchvalue, Integer pageno, Integer size) throws Exception {

		Page page = null;

		if (searchindex == 1) {

			try {
				Pageable paging = PageRequest.of(pageno, size);
				page = repository.searchstockproduct(cid, bid, locrefid, locname, searchvalue, paging);
			} catch (Exception ex) {
				logger.error("Exception in Method : viewStocks : " + ex);
				throw new Exception(ex);
			}

		} else if (searchindex == 2) {

			try {
				Pageable paging = PageRequest.of(pageno, size);
				page = repository.searchstockformulation(cid, bid, locrefid, locname, searchvalue, paging);
			} catch (Exception ex) {
				logger.error("Exception in Method : viewStocks : " + ex);
				throw new Exception(ex);
			}

		}
		return page;

	}

	/*** Stock Edit **/

	public Stocks editStockinfo(Integer id) throws Exception {
		return repository.findById(id);
	}

	public List getstockdrugname(Integer drugid) throws Exception {
		return repository.getstockdrugname(drugid);
	}
	
	public List editStockdos(Integer id) throws Exception {
		Stocks st = repository.findById(id);
		return repository.editStockdos(Integer.parseInt(st.getBatchno()));
	}

	public List editStockForm(Integer id) throws Exception {
		Stocks st = repository.findById(id);
		return repository.editStockForm(st.getFormulationid());
	}

	public List editSgst(Integer id) throws Exception {
		return repository.editSgst(id);
	}

	public List editCgst(Integer id) throws Exception {
		return repository.editCgst(id);
	}

	public List editIgst(Integer id) throws Exception {
		return repository.editIgst(id);
	}

	public List editUtgst(Integer id) throws Exception {
		return repository.editUtgst(id);
	}

	public List editGst(Integer id) throws Exception {
		return repository.editGst(id);
	}

	public List editVat(Integer id) throws Exception {
		return repository.editVat(id);
	}

	public Integer deleteStock(Integer id) throws Exception {
		return repository.deleteStock(id);
	}

	public boolean saveStock(Stocks stocks) { // throws Exception
		boolean reFlag = false;

		// Boopalan050719
		Integer lastqty = repository.getLastReceivedQty(stocks.getCompanyrefid(), stocks.getBranchrefid(),
				stocks.getLocname(), stocks.getLocrefid(), stocks.getDrugproductid());
		System.out.println("Boopalan Lastreceivedqty" + lastqty);
		System.out.println(stocks.getLastreceivedqty());
		stocks.setLastreceivedqty(lastqty);
		repository.updateMinimumStock(stocks.getCompanyrefid(), stocks.getBranchrefid(), stocks.getLocname(),
				stocks.getLocrefid(), stocks.getDrugproductid());
		try {
			// Ajith Lablegenerate
			String random = RandomStringUtils.randomAlphabetic(3).toUpperCase();
			String compFormat = String.format("%03d", stocks.getCompanyrefid());
			String shopFormat = String.format("%03d", stocks.getLocrefid());
			String productFormat = String.format("%06d", stocks.getDrugproductid());
			String lable = random + compFormat + shopFormat + productFormat;

			// Ajith Barcodegenerate
			Code128Bean code128 = new Code128Bean();
			code128.setHeight(15f);
			code128.setModuleWidth(0.3);
			code128.setQuietZone(10);
			code128.doQuietZone(true);
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			BitmapCanvasProvider canvas = new BitmapCanvasProvider(baos, "image/x-png", 300,
					BufferedImage.TYPE_BYTE_BINARY, false, 0);
			code128.generateBarcode(canvas, lable);
			canvas.finish();

			BitMatrix bitMatrix2 = new Code128Writer().encode(lable, BarcodeFormat.CODE_128, stocks.getBarcodewidth(),
					stocks.getBarcodeheight());
			MatrixToImageWriter.writeToStream(bitMatrix2, "png", baos);
			byte[] barimg = baos.toByteArray();

			// Ajith Qrcodegenerate
			QRCodeWriter Writer = new QRCodeWriter();
			BitMatrix bitMatrix = Writer.encode(lable, BarcodeFormat.QR_CODE, stocks.getQrcodewidth(),
					stocks.getQrcodeheight());
			ByteArrayOutputStream pngOutputStream = new ByteArrayOutputStream();
			MatrixToImageWriter.writeToStream(bitMatrix, "PNG", pngOutputStream);
			byte[] qrimg = pngOutputStream.toByteArray();

			StoredProcedureQuery sp = em.createStoredProcedureQuery("medc_stock.pro_stockInverd");
			sp.registerStoredProcedureParameter("racknos", String.class, ParameterMode.IN);
			sp.registerStoredProcedureParameter("shelfnos", String.class, ParameterMode.IN);
			sp.registerStoredProcedureParameter("coldstorages", String.class, ParameterMode.IN);
			sp.registerStoredProcedureParameter("drugproids", Integer.class, ParameterMode.IN);
			sp.registerStoredProcedureParameter("formulationids", Integer.class, ParameterMode.IN);
			sp.registerStoredProcedureParameter("dosageids", String.class, ParameterMode.IN);
			sp.registerStoredProcedureParameter("expirydates", String.class, ParameterMode.IN);
			sp.registerStoredProcedureParameter("bthnos", String.class, ParameterMode.IN);
			sp.registerStoredProcedureParameter("minqtys", Double.class, ParameterMode.IN);
			sp.registerStoredProcedureParameter("boxperstrips", Double.class, ParameterMode.IN);
			sp.registerStoredProcedureParameter("strippertablets", Double.class, ParameterMode.IN);
			sp.registerStoredProcedureParameter("totalquantitys", Double.class, ParameterMode.IN);
			sp.registerStoredProcedureParameter("boxqtys", Double.class, ParameterMode.IN);
			sp.registerStoredProcedureParameter("tabletqtys", Double.class, ParameterMode.IN);
			sp.registerStoredProcedureParameter("stripqtys", Double.class, ParameterMode.IN);
			sp.registerStoredProcedureParameter("freeboxqtys", Double.class, ParameterMode.IN);
			sp.registerStoredProcedureParameter("freestripqtys", Double.class, ParameterMode.IN);
			sp.registerStoredProcedureParameter("freetabletqtys", Double.class, ParameterMode.IN);
			sp.registerStoredProcedureParameter("freetotalqtys", Double.class, ParameterMode.IN);
			sp.registerStoredProcedureParameter("sellingprices", Double.class, ParameterMode.IN);
			sp.registerStoredProcedureParameter("purchaseprices", Double.class, ParameterMode.IN);
			sp.registerStoredProcedureParameter("mrps", Double.class, ParameterMode.IN);
			sp.registerStoredProcedureParameter("wholesellingprices", Double.class, ParameterMode.IN);
			sp.registerStoredProcedureParameter("retailersellingprices", Double.class, ParameterMode.IN);
			sp.registerStoredProcedureParameter("unitsgsts", Double.class, ParameterMode.IN);
			sp.registerStoredProcedureParameter("unitcgsts", Double.class, ParameterMode.IN);
			sp.registerStoredProcedureParameter("unitigsts", Double.class, ParameterMode.IN);
			sp.registerStoredProcedureParameter("unitutgsts", Double.class, ParameterMode.IN);
			sp.registerStoredProcedureParameter("unitgsts", Double.class, ParameterMode.IN);
			sp.registerStoredProcedureParameter("vats", Double.class, ParameterMode.IN);
			sp.registerStoredProcedureParameter("margins", Double.class, ParameterMode.IN);
			sp.registerStoredProcedureParameter("marginamounts", Double.class, ParameterMode.IN);
			sp.registerStoredProcedureParameter("companyrefids", Integer.class, ParameterMode.IN);
			sp.registerStoredProcedureParameter("branchrefids", Integer.class, ParameterMode.IN);
			sp.registerStoredProcedureParameter("locrefids", Integer.class, ParameterMode.IN);
			sp.registerStoredProcedureParameter("locnames", Integer.class, ParameterMode.IN);
			sp.registerStoredProcedureParameter("clientcdates", String.class, ParameterMode.IN);
			sp.registerStoredProcedureParameter("manufactureddates", String.class, ParameterMode.IN);// Boopalan
			sp.registerStoredProcedureParameter("unitprices", Double.class, ParameterMode.IN);// Boopalan
			sp.registerStoredProcedureParameter("barcodelables", String.class, ParameterMode.IN);
			sp.registerStoredProcedureParameter("barcodeimages", byte[].class, ParameterMode.IN);
			sp.registerStoredProcedureParameter("barcodeweights", Integer.class, ParameterMode.IN);
			sp.registerStoredProcedureParameter("barcodeheights", Integer.class, ParameterMode.IN);
			sp.registerStoredProcedureParameter("qrcodelables", String.class, ParameterMode.IN);
			sp.registerStoredProcedureParameter("qrcodeimages", byte[].class, ParameterMode.IN);
			sp.registerStoredProcedureParameter("qrcodeweights", Integer.class, ParameterMode.IN);
			sp.registerStoredProcedureParameter("qrcodeheights", Integer.class, ParameterMode.IN);
			sp.registerStoredProcedureParameter("packageunits", String.class, ParameterMode.IN);
			sp.registerStoredProcedureParameter("flag", Integer.class, ParameterMode.OUT);
			sp.setParameter("racknos", stocks.getRackno());
			sp.setParameter("shelfnos", stocks.getShelfno());
			sp.setParameter("coldstorages", stocks.getColdstorage());
			sp.setParameter("drugproids", stocks.getDrugproductid());
			sp.setParameter("formulationids", stocks.getFormulationid());
			sp.setParameter("dosageids", stocks.getDosageid());
			sp.setParameter("expirydates", stocks.getExpirydate());
			sp.setParameter("bthnos", stocks.getBatchno());
			sp.setParameter("minqtys", stocks.getMinqty());
			sp.setParameter("boxperstrips", stocks.getBoxperstrip());
			sp.setParameter("strippertablets", stocks.getStrippertablet());
			sp.setParameter("totalquantitys", stocks.getQty());
			sp.setParameter("boxqtys", stocks.getBoxqty());
			sp.setParameter("tabletqtys", stocks.getTabletqty());
			sp.setParameter("stripqtys", stocks.getStripqty());
			sp.setParameter("freeboxqtys", stocks.getFreeboxqty());
			sp.setParameter("freestripqtys", stocks.getFreestripqty());
			sp.setParameter("freetabletqtys", stocks.getFreetabletqty());
			sp.setParameter("freetotalqtys", stocks.getFreetotalqty());
			sp.setParameter("sellingprices", stocks.getSellingprice());
			sp.setParameter("purchaseprices", stocks.getPurchaseprice());
			sp.setParameter("mrps", stocks.getMrp());
			sp.setParameter("wholesellingprices", stocks.getWholesellingprice());
			sp.setParameter("retailersellingprices", stocks.getRetailersellingprice());
			sp.setParameter("unitsgsts", stocks.getUnitsgst());
			sp.setParameter("unitcgsts", stocks.getUnitcgst());
			sp.setParameter("unitigsts", stocks.getUnitigst());
			sp.setParameter("unitutgsts", stocks.getUnitutgst());
			sp.setParameter("unitgsts", stocks.getUnitgst());
			sp.setParameter("vats", stocks.getVat());
			sp.setParameter("margins", stocks.getMargin());
			sp.setParameter("marginamounts", stocks.getMarginamt());
			sp.setParameter("companyrefids", stocks.getCompanyrefid());
			sp.setParameter("branchrefids", stocks.getBranchrefid());
			sp.setParameter("locrefids", stocks.getLocrefid());
			sp.setParameter("locnames", stocks.getLocname());
			sp.setParameter("clientcdates", stocks.getClientcdate());
			sp.setParameter("manufactureddates", stocks.getManufactureddate());// Boopalan
			sp.setParameter("unitprices", stocks.getUnitprice());// Boopalan
			sp.setParameter("barcodelables", lable);
			sp.setParameter("barcodeimages", barimg);
			sp.setParameter("barcodeweights", stocks.getBarcodewidth());
			sp.setParameter("barcodeheights", stocks.getBarcodeheight());
			sp.setParameter("qrcodelables", lable);
			sp.setParameter("qrcodeimages", qrimg);
			sp.setParameter("qrcodeweights", stocks.getQrcodewidth());
			sp.setParameter("qrcodeheights", stocks.getQrcodeheight());
			sp.setParameter("packageunits", stocks.getPackageunit());
			sp.execute();
			Integer val = (Integer) sp.getOutputParameterValue("flag");
			if (val == 1 || val == 2) {
				reFlag = true;
			}
		} catch (Exception e) {
			logger.error("Exception in Method : saveStock() " + e);
			e.printStackTrace();
			// throw new Exception(e);
		}
		return reFlag;
	}

	// puthiran for barqr settings
	public boolean savebarqrsettings(Barqrsettings barqrsettings) throws Exception {
		// try {
		barqrrepository.save(barqrsettings);
		return true;
		// } catch (Exception e) {
		// e.printStackTrace();
		// }
		// return false;
	}

	//// view print settings
	public List viewbarqrsettings(int companyid, int branchid, int locname, int locrefid) throws Exception {
		// List<Object> list=new ArrayList<>();
		// try {
		return barqrrepository.viewbarqrsettings(companyid, branchid, locname, locrefid);
		// } catch (Exception e) {
		// e.printStackTrace();
		// }
		// return null;
	}

	public byte[] getQrcodeImage(Integer stockid) throws Exception {
		return barqrrepository.getQrcodeImage(stockid);
	}

	// for Schedule List
	// Desing Raja
	public List getschdldata(Integer comid, Integer branchid, Integer locname, Integer locrefid) throws Exception {

		System.out.println("Scheld service");
		return repository.getscheduledata(comid, branchid, locname, locrefid);
	}

	public boolean editschedule(Integer scheduleid, Integer productid) throws Exception {
		boolean flag = false;

//		try {
//			System.out.println("Schedule service1");
		repository.editschld(scheduleid, productid);
		flag = true;
		return flag;

//		} catch (Exception e) {
//			logger.error("Exception in Method : editschedule() " + e);
//			e.printStackTrace();
//		}
//		System.out.println("Schedule service4");
//		return flag;

	}

	public void updateminiQuantity(Integer cid, Integer bid, Integer lname, Integer lrefid) {
		List<Stocks> stocks = repository.findByCompanyrefidAndBranchrefidAndLocnameAndLocrefid(cid, bid, lname, lrefid);
		for (Stocks dt : stocks) {
			Integer venid = repository.getlastvendorid(dt.getDrugproductid(), dt.getCompanyrefid(), dt.getBranchrefid(),
					dt.getLocname(), dt.getLocrefid());
			List<Object[]> maxconsumpstk = repository.getMaxsalesstk(dt.getDrugproductid(), dt.getCompanyrefid(),
					dt.getBranchrefid(), dt.getLocname(), dt.getLocrefid());

			List<Object[]> leadtmeavg = repository.getLeadtime(venid, dt.getCompanyrefid(), dt.getBranchrefid(),
					dt.getLocname(), dt.getLocrefid());

			for (Object[] x : maxconsumpstk) {
				for (Object[] x1 : leadtmeavg) {
					String maxconsmp = (String) x[0];
					String maxleadtme = String.valueOf((BigInteger) x1[0]);
					String minleadtme = String.valueOf((BigInteger) x1[2]);
					if (venid == null) {
						Double intval = Double.parseDouble(maxconsmp);
						Integer intval1 = Integer.parseInt(maxleadtme);
						Integer reorderlvl = (intval.intValue() * intval1);
						dt.setReorderlvl(reorderlvl);
						Double avgconsmp = (Double) x[1];
						String avgleadtme = String.valueOf((BigDecimal) x1[1]);
						Double intval3 = Double.parseDouble(avgleadtme);
						Integer avglvl = (avgconsmp.intValue() * intval3.intValue());
						Double minqty = Double.valueOf((reorderlvl.intValue() - avglvl.intValue()));
						dt.setMinqty(minqty);
						repository.save(dt);
					} else {
						Distributor distributor = distrepo.findById(venid);
						distributor.setMaxleadtime(maxleadtme);
						distributor.setMinleadtime(minleadtme);
						Double intval = Double.parseDouble(maxconsmp);
						Integer intval1 = Integer.parseInt(maxleadtme);
						Integer reorderlvl = (intval.intValue() * intval1);
						dt.setReorderlvl(reorderlvl);
						Double avgconsmp = (Double) x[1];
						String avgleadtme = String.valueOf((BigDecimal) x1[1]);
						Double intval3 = Double.parseDouble(avgleadtme);
						Integer avglvl = (avgconsmp.intValue() * intval3.intValue());
						Double minqty = Double.valueOf((reorderlvl.intValue() - avglvl.intValue()));
						dt.setMinqty(minqty);
						repository.save(dt);
						distrepo.save(distributor);
					}

				}

			}
		}
	}

	public List getbatchno(Integer cid, Integer bid, Integer lname, Integer lrefid) {
		return repository.getbatch(cid, bid, lname, lrefid);
	}

}
