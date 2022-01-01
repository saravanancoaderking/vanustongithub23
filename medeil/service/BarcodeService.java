package com.medeil.service;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import javax.imageio.ImageIO;
import javax.persistence.EntityManager;
import javax.persistence.ParameterMode;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.StoredProcedureQuery;
import org.apache.commons.lang3.RandomStringUtils;
import org.krysalis.barcode4j.impl.code128.Code128Bean;
import org.krysalis.barcode4j.output.bitmap.BitmapCanvasProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.oned.Code128Writer;
import com.medeil.domain.Barcode;
import com.medeil.domain.DeliverChallan;
import com.medeil.domain.GatePass;
import com.medeil.domain.Purchase;
import com.medeil.domain.PurchaseInvoice;
import com.medeil.domain.PurchaseOrder;
import com.medeil.domain.SalesDummy;
import com.medeil.domain.Salesorder;
import com.medeil.domain.Stocks;
import com.medeil.repository.BarcodeRepository;
import com.medeil.repository.SInvoiceRepository;
import com.medeil.repository.StocksRepository;

@SuppressWarnings("rawtypes")
@Service
public class BarcodeService {

	@PersistenceContext
	private EntityManager manager;

	@PersistenceContext
	EntityManager em;

	Query query;
	@Autowired
	BarcodeRepository barcodeRepository;
	@Autowired
	StocksRepository stocksRepository;
	@Autowired
	SInvoiceRepository sInvoiceRepository;


	public boolean saveBarcode(Barcode barcode) throws Exception {
		boolean flag = false;
		try {
			StoredProcedureQuery storedProcedure = manager.createStoredProcedureQuery("medc_productmaster.pro_barcode");
			storedProcedure.registerStoredProcedureParameter("pcode", Integer.class, ParameterMode.IN);
			storedProcedure.registerStoredProcedureParameter("mfbarcode", String.class, ParameterMode.IN);
			storedProcedure.registerStoredProcedureParameter("spcode", String.class, ParameterMode.IN);
			storedProcedure.registerStoredProcedureParameter("compid", Integer.class, ParameterMode.IN);
			storedProcedure.registerStoredProcedureParameter("branchid", Integer.class, ParameterMode.IN);
			storedProcedure.registerStoredProcedureParameter("locname", Integer.class, ParameterMode.IN);
			storedProcedure.registerStoredProcedureParameter("locrefid", Integer.class, ParameterMode.IN);
			storedProcedure.registerStoredProcedureParameter("functionality", String.class, ParameterMode.IN);
			storedProcedure.registerStoredProcedureParameter("flag", Integer.class, ParameterMode.OUT);
			storedProcedure.setParameter("pcode", barcode.getProduct());
			storedProcedure.setParameter("mfbarcode", barcode.getMfbarcode());
			storedProcedure.setParameter("spcode", barcode.getSpcode());
			storedProcedure.setParameter("compid", barcode.getCompanyid());
			storedProcedure.setParameter("branchid", barcode.getBranchid());
			storedProcedure.setParameter("locname", barcode.getLocname());
			storedProcedure.setParameter("locrefid", barcode.getLocrefid());
			storedProcedure.setParameter("functionality", "save");
			storedProcedure.execute();
			Integer a = (Integer) storedProcedure.getOutputParameterValue("flag");
			if (a == 1) {
				flag = true;
			}
		} catch (Exception e) {
			System.out.println("SaveBarcode" + e);
			throw new Exception(e);

		}
		return flag;
	}

	public List getSuperProduct(String str)throws Exception {
		return barcodeRepository.getSuperProduct(str);
	}

	public List getBarcode(String barcode) throws Exception{
		return barcodeRepository.getBarcode(barcode);
	}

	public List getProduct(String str, int compid, int branchid, int locname, int locrefid) throws Exception{
		return barcodeRepository.getProduct(str, compid);
	}

	public List getSuperViewBarcodeProduct()throws Exception {
		return barcodeRepository.getSuperViewBarcodeProduct();
	}

	public List getViewBarcodeProduct(int compid, int branchid, int locname, int locrefid)throws Exception {
		return barcodeRepository.getViewBarcodeProduct(compid);
	}

	public boolean isProductExist(int cid, String pname) {
		Integer chk = barcodeRepository.isProductExist(cid, pname);
		System.out.println("checking  " + chk);
		if (chk == 0) {
			return true;
		}
		return false;
	}
	
	//puthiran 14/07/2020 get stock no by search
	public List searchstockitembyvalue(int cid, int bid, int locname, int locrefid, String searchvalue)throws Exception {
		//try {

			return barcodeRepository.searchstockitembyvalue(cid, bid, locname, locrefid,searchvalue);
		//} catch (Exception e) {
			//e.printStackTrace();
//		}
	//	return null;
	}
	
	public List searchstockitemall(int cid, int bid, int locname, int locrefid)throws Exception {
		//try {

			return barcodeRepository.searchstockitemall(cid, bid, locname, locrefid);
		//} catch (Exception e) {
		//	e.printStackTrace();
		//}
		//return null;
	}
	
	//date wise search stock
	public List datewisestockitem(int cid, int bid, int locname, int locrefid, String date)throws Exception {
	//	try {

			return barcodeRepository.datewisestockitem(cid, bid, locname, locrefid,date);
	//	} catch (Exception e) {
	//		e.printStackTrace();
	//	}
	//	return null;
	}

	//generate Stock Barcode
	public boolean GenerateStockBarcode(Stocks stocks) throws Exception {
		boolean result = true;
		if (result==true) {
			String random = "BSTK";
			String compFormat = String.format("%03d", stocks.getCompanyrefid());
			String shopFormat = String.format("%03d", stocks.getLocrefid());
			String productFormat = String.format("%05d", stocks.getId());
			//String CompanyName="\n"+"Kamal";
			String lable=random+compFormat+shopFormat+productFormat;
			System.out.println(">>>>>"+lable);
			Code128Bean code128 = new Code128Bean();
			code128.setHeight(15f);
			code128.setModuleWidth(0.3);
			code128.setQuietZone(10);
			code128.doQuietZone(true);
			//code128.setFontName("Puthiran");
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			BitmapCanvasProvider canvas = new BitmapCanvasProvider(baos, "image/x-png",300, BufferedImage.TYPE_BYTE_BINARY, false, 0);
			//canvas.deviceCenteredText("Puthiran", 1, 1, 1, "Montserrat", 12);
			code128.generateBarcode(canvas,lable);
			canvas.finish();
			BitMatrix bitMatrix2= new Code128Writer().encode(lable, BarcodeFormat.CODE_128, stocks.getBarcodewidth(),stocks.getBarcodeheight());
		    MatrixToImageWriter.writeToStream(bitMatrix2, "png", baos);
		    byte[] barimg=baos.toByteArray();
		    ByteArrayInputStream in = new ByteArrayInputStream(barimg);
		    BufferedImage bufferedImage = ImageIO.read(in);
		    Graphics graphics = bufferedImage.getGraphics();
	        graphics.setColor(java.awt.Color.RED);
	        graphics.fillRect(250, 250, 200, 250);
	        graphics.setColor(java.awt.Color.RED);
	        graphics.setFont(new Font("Arial Black", Font.BOLD, 16));
	        Graphics2D g2d = (Graphics2D) graphics;
	        AffineTransform at = new AffineTransform();
	        AffineTransform defaultAt = g2d.getTransform();
	        at.rotate(- Math.PI / 2);
	        g2d.setTransform(at);
	        g2d.drawString(stocks.getBrandname(), -130, 110);
	        AffineTransform at2 = AffineTransform.getQuadrantRotateInstance(1);
	        g2d.setTransform(at2);
	        g2d.drawString(stocks.getShopname(),5, -680);
	        g2d.setTransform(defaultAt);
	        graphics.drawString("MRP: "+String.valueOf(stocks.getMrp()), 565, 155);
	        ByteArrayOutputStream baoss = new ByteArrayOutputStream();
	        ImageIO.write( bufferedImage, "png", baoss );
	        baos.flush();
	        byte[] imageInByte = baoss.toByteArray();
	        baos.close();
		    barcodeRepository.GenerateStockBarcode(stocks.getBarcodeheight(), stocks.getBarcodewidth(), lable, imageInByte,stocks.getId());
		    result=true;
		} else {
		    result=false;

		}
			return result;
	}
	
	//view Stock barcode image
	public byte[] getStockBarcodeImage(Integer stockid) throws Exception{
		return barcodeRepository.getStockBarcodeImage(stockid);
	}
	
	
	//get salesinvoice nos
	public List getsalesinvoiceno(int cid, int bid, int locname, int locrefid) throws Exception{
	//	try {

			return barcodeRepository.getsalesinvoiceno(cid, bid, locname, locrefid);
	//	} catch (Exception e) {
	//		e.printStackTrace();
	//	}
	//	return null;
	}
	
	//generate salesinvocie formbarcode
	public boolean GenerateSalesinvoiceBarcode(SalesDummy sinvoice) throws Exception {
		boolean result = true;
		if (result==true) {
			String random = "BSIV";
			String compFormat = String.format("%03d", sinvoice.getCompanyrefid());
			//String shopFormat = String.valueOf(sinvoice.getLocrefid());
			String productFormat = String.format("%05d", sinvoice.getId());
			String lable=random+compFormat+productFormat;
			System.out.println(">>>>>>>>>>>>>>>"+lable);
			Code128Bean code128 = new Code128Bean();
			code128.setHeight(15f);
			code128.setModuleWidth(0.3);
			code128.setQuietZone(10);
			code128.doQuietZone(true);
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			BitmapCanvasProvider canvas = new BitmapCanvasProvider(baos, "image/x-png",300, BufferedImage.TYPE_BYTE_BINARY, false, 0);
			code128.generateBarcode(canvas, lable);
			canvas.finish();
			BitMatrix bitMatrix2= new Code128Writer().encode(lable, BarcodeFormat.CODE_128, sinvoice.getBarcodewidth(),sinvoice.getBarcodeheight());
		    MatrixToImageWriter.writeToStream(bitMatrix2, "png", baos);
		    byte[] barimg=baos.toByteArray();
		    barcodeRepository.GenerateSalesinvoiceBarcode(sinvoice.getBarcodeheight(), sinvoice.getBarcodewidth(), lable, barimg,sinvoice.getId(), sinvoice.getBarcodeposition());
		    result=true;
		}else {
		    result=false;

		}
			return result;
	}

	//view sales invoice barcoe image
	public byte[] getSalesinvBarcodeImage(Integer invoiceid)throws Exception {
		return barcodeRepository.getSalesinvBarcodeImage(invoiceid);
	}
	
	
	//get purchaseinvoice nos
	public List getpurchaseinvoiceno(int cid, int bid, int locname, int locrefid)throws Exception {
	//	try {
			return barcodeRepository.getpurchaseinvoiceno(cid, bid, locname, locrefid);
	//	} catch (Exception e) {
	//			e.printStackTrace();
	//	}
	//		return null;
	}
	
	//generate purchaseinvocie formbarcode
	public boolean GeneratePurchaseinvoiceBarcode(Purchase purchase) throws Exception {
		boolean result = true;
		if (result==true) {
			String random = "BPIV";
			String compFormat = String.format("%03d", purchase.getCompanyrefid());
			String productFormat = String.format("%05d", purchase.getId());
			String lable=random+compFormat+productFormat;
			System.out.println(">>>>>>>>>>>>>>>"+lable);
			Code128Bean code128 = new Code128Bean();
			code128.setHeight(15f);
			code128.setModuleWidth(0.3);
			code128.setQuietZone(10);
			code128.doQuietZone(true);
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			BitmapCanvasProvider canvas = new BitmapCanvasProvider(baos, "image/x-png",350, BufferedImage.TYPE_BYTE_BINARY, false, 0);
			code128.setCodeset(123);
			code128.generateBarcode(canvas, lable);
			canvas.finish();
			BitMatrix bitMatrix2= new Code128Writer().encode(lable, BarcodeFormat.CODE_128, purchase.getBarcodewidth(),purchase.getBarcodeheight());
		    MatrixToImageWriter.writeToStream(bitMatrix2, "png", baos);
		    byte[] barimg=baos.toByteArray();
		    barcodeRepository.GeneratePurchaseinvoiceBarcode(purchase.getBarcodeheight(), purchase.getBarcodewidth(), lable, barimg,purchase.getId(),purchase.getBarcodeposition());
		    result=true;
		}else {
		    result=false;

		}
			return result;
	}
	
	//view purchase invoice barcode image
	public byte[] getPurchaseinvBarcodeImage(Integer invoiceid)throws Exception {
		return barcodeRepository.getPurchaseinvBarcodeImage(invoiceid);
	}
	
	
	//get deliverchallan no's
	public List getdeliverychallanno(int cid, int bid, int locname, int locrefid)throws Exception {
//		try {

			return barcodeRepository.getdeliverychallanno(cid, bid, locname, locrefid);
	//	} catch (Exception e) {
	//		e.printStackTrace();
	//	}
	//	return null;
	}
	
	//generate deliverychallan barcode
	public boolean GenerateDeliverchallanBarcode(DeliverChallan delchallan) throws Exception {
		boolean result = true;
		if (result==true) {
			String random = "BDCH";
			String compFormat = String.format("%03d", delchallan.getCompanyrefid());
			String productFormat = String.format("%05d", delchallan.getId());
			String lable=random+compFormat+productFormat;
			System.out.println(">>>>>>>>>>>>>>>"+lable);
			Code128Bean code128 = new Code128Bean();
			code128.setHeight(15f);
			code128.setModuleWidth(0.3);
			code128.setQuietZone(10);
			code128.doQuietZone(true);
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			BitmapCanvasProvider canvas = new BitmapCanvasProvider(baos, "image/x-png",300, BufferedImage.TYPE_BYTE_BINARY, false, 0);
			code128.generateBarcode(canvas, lable);
			canvas.finish();
			BitMatrix bitMatrix2= new Code128Writer().encode(lable, BarcodeFormat.CODE_128, delchallan.getBarcodewidth(),delchallan.getBarcodeheight());
		    MatrixToImageWriter.writeToStream(bitMatrix2, "png", baos);
		    byte[] barimg=baos.toByteArray();
		    barcodeRepository.GenerateDeliverchallanBarcode(delchallan.getBarcodeheight(), delchallan.getBarcodewidth(), lable, barimg,delchallan.getId(),delchallan.getBarcodeposition());
		    result=true;
		}else {
		    result=false;

		}
			return result;
	}
	
	//view Deliverchallan barcode image
	public byte[] getDeliveryChallanBarcodeImage(Integer invoiceid) {
		return barcodeRepository.getDeliveryChallanBarcodeImage(invoiceid);
	}
	
	//get gatepass no's
	public List getgatepassno(int cid, int bid, int locname, int locrefid)throws Exception {
	//	try {

			return barcodeRepository.getgatepassno(cid, bid, locname, locrefid);
	//	} catch (Exception e) {
	//		e.printStackTrace();
	//	}
	//	return null;
	}
	
	//generate gatepass barcode
	public boolean GenerateGatePassBarcode(GatePass gatepass) throws Exception {
		boolean result = true;
		if (result==true) {
			String random = "BGTP";
			String compFormat = String.format("%03d", gatepass.getCompanyrefid());
			String productFormat = String.format("%05d", gatepass.getId());
			String lable=random+compFormat+productFormat;
			System.out.println(">>>>>>>>>>>>>>>"+lable);
			Code128Bean code128 = new Code128Bean();
			code128.setHeight(15f);
			code128.setModuleWidth(0.3);
			code128.setQuietZone(10);
			code128.doQuietZone(true);
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			BitmapCanvasProvider canvas = new BitmapCanvasProvider(baos, "image/x-png",300, BufferedImage.TYPE_BYTE_BINARY, false, 0);
			code128.generateBarcode(canvas, lable);
			canvas.finish();
			BitMatrix bitMatrix2= new Code128Writer().encode(lable, BarcodeFormat.CODE_128, gatepass.getBarcodewidth(),gatepass.getBarcodeheight());
		    MatrixToImageWriter.writeToStream(bitMatrix2, "png", baos);
		    byte[] barimg=baos.toByteArray();
		    barcodeRepository.GenerateGatePassBarcode(gatepass.getBarcodeheight(), gatepass.getBarcodewidth(), lable, barimg,gatepass.getId(),gatepass.getBarcodeposition());
		    result=true;
		}else {
		    result=false;

		}
			return result;
	}
	
	//view gatepass barcode image
	public byte[] getGatePassBarcodeImageView(Integer invoiceid) {
		return barcodeRepository.getGatePassBarcodeImageView(invoiceid);
	}
	
	
	//get distributors for barcode generate
	public List getbarcodeDistributors(int cid, int bid, int locname, int locrefid)throws Exception {
	//	try {
			return barcodeRepository.getbarcodeDistributors(cid, bid, locname, locrefid);
	//	} catch (Exception e) {
	//			e.printStackTrace();
	//	}
	//		return null;
	}
	
	
	//distributor purchase invoice
	public List getdistributorpurchaseinvoice(int cid, int bid, int locname, int locrefid,int distributorid)throws Exception {
	//	try {
			return barcodeRepository.getdistributorpurchaseinvoice(cid, bid, locname, locrefid, distributorid);
	//	} catch (Exception e) {
	//			e.printStackTrace();
	//	}
	//		return null;
	}
	
	//distributor purchase invoice products
	public List getdistributorpurchaseinvoiceproducts(int purchaseinvocieid)throws Exception {
	//	try {
			return barcodeRepository.getdistributorpurchaseinvoiceproducts(purchaseinvocieid);
	//	} catch (Exception e) {
	//			e.printStackTrace();
	//	}
	//		return null;
	}
	
	//generate Dist wise purchase product barcode
	public boolean GenerateDistPurchaseProductBarcode(PurchaseInvoice Purchaseproduct) throws Exception {
		boolean result = true;
		if (result==true) {
			String random = "BPIP";
			String compFormat = String.format("%03d", Purchaseproduct.getCompanyrefid());
			String productFormat = String.format("%05d", Purchaseproduct.getId());
			String lable=random+compFormat+productFormat;
			System.out.println(">>>>>>>>>>>>>>>"+lable);
			Code128Bean code128 = new Code128Bean();
			code128.setHeight(15f);
			code128.setModuleWidth(0.3);
			code128.setQuietZone(10);
			code128.doQuietZone(true);
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			BitmapCanvasProvider canvas = new BitmapCanvasProvider(baos, "image/x-png",300, BufferedImage.TYPE_BYTE_BINARY, false, 0);
			code128.generateBarcode(canvas, lable);
			canvas.finish();
			BitMatrix bitMatrix2= new Code128Writer().encode(lable, BarcodeFormat.CODE_128, Purchaseproduct.getBarcodewidth(),Purchaseproduct.getBarcodeheight());
		    MatrixToImageWriter.writeToStream(bitMatrix2, "png", baos);
		    byte[] barimg=baos.toByteArray();
		    barcodeRepository.GenerateDistPurchaseProductBarcode(Purchaseproduct.getBarcodeheight(), Purchaseproduct.getBarcodewidth(), lable, barimg,Purchaseproduct.getId());
		    result=true;
		}else {
		    result=false;

		}
			return result;
	}
	
	//view purchase produt barcodeimage
	public byte[] getPurchaseProductBarcodeImageView(Integer invoiceproductid) {
		return barcodeRepository.getPurchaseProductBarcodeImageView(invoiceproductid);
	}
	
	//get purchase orders no for generate
	public List getbarpurchaseorderdetails(int cid, int bid, int locname, int locrefid)throws Exception {
	//	try {
			return barcodeRepository.getbarpurchaseorderdetails(cid, bid, locname, locrefid);
	//	} catch (Exception e) {
	//			e.printStackTrace();
	//	}
	//		return null;
	}
	
	//generate purchase order barcode
	public boolean GeneratePurchaseOrderBarcode(PurchaseOrder purchaseorder) throws Exception {
		boolean result = true;
		if (result==true) {
			String random = "BPOR";
			String compFormat = String.format("%03d", purchaseorder.getCompanyrefid());
			String productFormat = String.format("%05d", purchaseorder.getId());
			String lable=random+compFormat+productFormat;
			System.out.println(">>>>>>>>>>>>>>>"+lable);
			Code128Bean code128 = new Code128Bean();
			code128.setHeight(15f);
			code128.setModuleWidth(0.3);
			code128.setQuietZone(10);
			code128.doQuietZone(true);
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			BitmapCanvasProvider canvas = new BitmapCanvasProvider(baos, "image/x-png",300, BufferedImage.TYPE_BYTE_BINARY, false, 0);
			code128.generateBarcode(canvas, lable);
			canvas.finish();
			BitMatrix bitMatrix2= new Code128Writer().encode(lable, BarcodeFormat.CODE_128, purchaseorder.getBarcodewidth(),purchaseorder.getBarcodeheight());
		    MatrixToImageWriter.writeToStream(bitMatrix2, "png", baos);
		    byte[] barimg=baos.toByteArray();
		    barcodeRepository.GeneratePurchseOrderBarcode(purchaseorder.getBarcodeheight(), purchaseorder.getBarcodewidth(), lable, barimg,purchaseorder.getId());
		    result=true;
		}else {
		    result=false;

		}
			return result;
	}
	
	//view purchase order barcodeimage
	public byte[] getPurchaseOrderBarcodeImageView(Integer invoiceid) {
		return barcodeRepository.getPurchaseOrderBarcodeImageView(invoiceid);
	}
	
	//get sales orders no for generate
	public List getbarsalesorderdetails(int cid, int bid, int locname, int locrefid)throws Exception {
	//	try {
			return barcodeRepository.getbarsalesorderdetails(cid, bid, locname, locrefid);
	//	} catch (Exception e) {
	//			e.printStackTrace();
	//	}
	//		return null;
	}
	
	//generate sales order barcode
	public boolean GenerateSalesOrderBarcode(Salesorder salesorder) throws Exception {
		boolean result = true;
		if (result==true) {
			String random = "BSOR";
			String compFormat = String.format("%03d", salesorder.getCompanyrefid());
			String productFormat = String.format("%05d", salesorder.getId());
			String lable=random+compFormat+productFormat;
			System.out.println(">>>>>>>>>>>>>>>"+lable);
			Code128Bean code128 = new Code128Bean();
			code128.setHeight(15f);
			code128.setModuleWidth(0.3);
			code128.setQuietZone(10);
			code128.doQuietZone(true);
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			BitmapCanvasProvider canvas = new BitmapCanvasProvider(baos, "image/x-png",300, BufferedImage.TYPE_BYTE_BINARY, false, 0);
			code128.generateBarcode(canvas, lable);
			canvas.finish();
			BitMatrix bitMatrix2= new Code128Writer().encode(lable, BarcodeFormat.CODE_128, salesorder.getBarcodewidth(),salesorder.getBarcodeheight());
		    MatrixToImageWriter.writeToStream(bitMatrix2, "png", baos);
		    byte[] barimg=baos.toByteArray();
		    barcodeRepository.GenerateSalesOrderBarcode(salesorder.getBarcodeheight(), salesorder.getBarcodewidth(), lable, barimg,salesorder.getId());
		    result=true;
		}else {
		    result=false;

		}
			return result;
	}
	
	//view sales order barcodeimage
	public byte[] getSalesOrderBarcodeImageView(Integer invoiceid) {
		return barcodeRepository.getSalesOrderBarcodeImageView(invoiceid);
	}
	

	
	

	
	
	
	



}
