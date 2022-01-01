package com.medeil.service;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;

import javax.imageio.ImageIO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import com.medeil.domain.DeliverChallan;
import com.medeil.domain.GatePass;
import com.medeil.domain.Purchase;
import com.medeil.domain.PurchaseInvoice;
import com.medeil.domain.PurchaseOrder;
import com.medeil.domain.SalesDummy;
import com.medeil.domain.Salesorder;
import com.medeil.domain.Stocks;
import com.medeil.repository.QrcodeRepository;
import com.medeil.repository.SInvoiceRepository;
import com.medeil.repository.StocksRepository;

@SuppressWarnings("rawtypes")
@Service
public class Qrcodeservice {

	@Autowired
	QrcodeRepository qrcodeRepository;
	@Autowired
	StocksRepository stocksRepository;
	@Autowired
	SInvoiceRepository sInvoiceRepository;

	// generate Stock qrcode
	public boolean GenerateStockQrcode(Stocks stocks) throws Exception {
		boolean result = true;
		if (result == true) {
			String random = "QSTK";
			String compFormat = String.format("%03d", stocks.getCompanyrefid());
			String shopFormat = String.format("%03d", stocks.getLocrefid());
			String productFormat = String.format("%05d", stocks.getId());
			// String CompanyName="\n"+"Kamal";
			String lable = random + compFormat + shopFormat + productFormat;
			System.out.println(">>>>>" + lable);
			QRCodeWriter Writer = new QRCodeWriter();
			Writer.encode(lable, BarcodeFormat.QR_CODE, 12, 12);
			BitMatrix bitMatrix = Writer.encode(lable, BarcodeFormat.QR_CODE, stocks.getQrcodewidth(),
					stocks.getQrcodeheight());
			ByteArrayOutputStream pngOutputStream = new ByteArrayOutputStream();
			MatrixToImageWriter.writeToStream(bitMatrix, "PNG", pngOutputStream);
			byte[] qrimg = pngOutputStream.toByteArray();
			ByteArrayInputStream in = new ByteArrayInputStream(qrimg);
			BufferedImage bufferedImage = ImageIO.read(in);
			Graphics graphics = bufferedImage.getGraphics();
			graphics.setColor(java.awt.Color.RED);
			graphics.fillRect(250, 250, 200, 250);
			graphics.setColor(java.awt.Color.RED);
			graphics.setFont(new Font("Arial Black", Font.BOLD, 10));
			graphics.drawString("MRP: " + String.valueOf(stocks.getMrp()), 9, stocks.getQrcodeheight() - 3);
			ByteArrayOutputStream baoss = new ByteArrayOutputStream();
			ImageIO.write(bufferedImage, "png", baoss);
			pngOutputStream.flush();
			byte[] imageInByte = baoss.toByteArray();
			qrcodeRepository.GenerateStockQrcode(stocks.getQrcodeheight(), stocks.getQrcodewidth(), lable, imageInByte,
					stocks.getId());
			result = true;
		} else {
			result = false;

		}
		return result;
	}

	// view Stock qrcode image
	public byte[] getStockQrcodeImageView(Integer stockid) throws Exception {
		return qrcodeRepository.getStockQrcodeImageView(stockid);
	}

	// generate salesinvocie formbarcode
	public boolean GenerateSalesinvoiceQrcode(SalesDummy sinvoice) throws Exception {
		boolean result = true;
		if (result == true) {
			String random = "QSIV";
			String compFormat = String.format("%03d", sinvoice.getCompanyrefid());
			// String shopFormat = String.valueOf(sinvoice.getLocrefid());
			String productFormat = String.format("%05d", sinvoice.getId());
			String lable = random + compFormat + productFormat;
			System.out.println(">>>>>>>>>>>>>>>" + lable);
			QRCodeWriter Writer = new QRCodeWriter();
			Writer.encode(lable, BarcodeFormat.QR_CODE, 12, 12);
			BitMatrix bitMatrix = Writer.encode(lable, BarcodeFormat.QR_CODE, sinvoice.getQrcodewidth(),
					sinvoice.getQrcodeheight());
			ByteArrayOutputStream pngOutputStream = new ByteArrayOutputStream();
			MatrixToImageWriter.writeToStream(bitMatrix, "PNG", pngOutputStream);
			byte[] qrimg = pngOutputStream.toByteArray();
			qrcodeRepository.GenerateSalesinvoiceQrcode(sinvoice.getQrcodeheight(), sinvoice.getQrcodewidth(), lable,
					qrimg, sinvoice.getId(), sinvoice.getQrcodeposition());
			result = true;
		} else {
			result = false;

		}
		return result;
	}

	// view sales invoice qrcode image
	public byte[] getSalesinvQrcodeImage(Integer invoiceid) throws Exception {
		return qrcodeRepository.getSalesinvQrcodeImage(invoiceid);
	}

	// generate purchaseinvocie form qrcode
	public boolean GeneratePurchaseinvoiceQrcode(Purchase purchase) throws Exception {
		boolean result = true;
		if (result == true) {
			String random = "QPIV";
			String compFormat = String.format("%03d", purchase.getCompanyrefid());
			String productFormat = String.format("%05d", purchase.getId());
			String lable = random + compFormat + productFormat;
			System.out.println(">>>>>>>>>>>>>>>" + lable);
			QRCodeWriter Writer = new QRCodeWriter();
			Writer.encode(lable, BarcodeFormat.QR_CODE, 12, 12);
			BitMatrix bitMatrix = Writer.encode(lable, BarcodeFormat.QR_CODE, purchase.getQrcodewidth(),
					purchase.getQrcodeheight());
			ByteArrayOutputStream pngOutputStream = new ByteArrayOutputStream();
			MatrixToImageWriter.writeToStream(bitMatrix, "PNG", pngOutputStream);
			byte[] qrimg = pngOutputStream.toByteArray();
			qrcodeRepository.GeneratePurchaseinvoiceQrcode(purchase.getQrcodeheight(), purchase.getQrcodewidth(), lable,
					qrimg, purchase.getId(), purchase.getQrcodeposition());
			result = true;
		} else {
			result = false;

		}
		return result;
	}

	// view purchase invoice barcode image
	public byte[] getPurchaseinvQrcodeImage(Integer invoiceid) throws Exception {
		return qrcodeRepository.getPurchaseinvQrcodeImage(invoiceid);
	}

	// generate deliverychallan qrcode
	public boolean GenerateDeliverchallanQrcode(DeliverChallan delchallan) throws Exception {
		boolean result = true;
		if (result == true) {
			String random = "QDCH";
			String compFormat = String.format("%03d", delchallan.getCompanyrefid());
			String productFormat = String.format("%05d", delchallan.getId());
			String lable = random + compFormat + productFormat;
			System.out.println(">>>>>>>>>>>>>>>" + lable);
			QRCodeWriter Writer = new QRCodeWriter();
			Writer.encode(lable, BarcodeFormat.QR_CODE, 12, 12);
			BitMatrix bitMatrix = Writer.encode(lable, BarcodeFormat.QR_CODE, delchallan.getQrcodewidth(),
					delchallan.getQrcodeheight());
			ByteArrayOutputStream pngOutputStream = new ByteArrayOutputStream();
			MatrixToImageWriter.writeToStream(bitMatrix, "PNG", pngOutputStream);
			byte[] qrimg = pngOutputStream.toByteArray();
			qrcodeRepository.GenerateDeliverchallanQrcode(delchallan.getQrcodeheight(), delchallan.getQrcodewidth(),
					lable, qrimg, delchallan.getId(), delchallan.getQrcodeposition());
			result = true;
		} else {
			result = false;

		}
		return result;
	}

	// view Deliverchallan qrcode image
	public byte[] getDeliveryChallanQrcodeImage(Integer invoiceid) throws Exception {
		return qrcodeRepository.getDeliveryChallanQrcodeImage(invoiceid);
	}

	// generate gatepass qrcode
	public boolean GenerateGatePassQrcode(GatePass gatepass) throws Exception {
		boolean result = true;
		if (result == true) {
			String random = "QDCH";
			String compFormat = String.format("%03d", gatepass.getCompanyrefid());
			String productFormat = String.format("%05d", gatepass.getId());
			String lable = random + compFormat + productFormat;
			System.out.println(">>>>>>>>>>>>>>>" + lable);
			QRCodeWriter Writer = new QRCodeWriter();
			Writer.encode(lable, BarcodeFormat.QR_CODE, 12, 12);
			BitMatrix bitMatrix = Writer.encode(lable, BarcodeFormat.QR_CODE, gatepass.getQrcodewidth(),
					gatepass.getQrcodeheight());
			ByteArrayOutputStream pngOutputStream = new ByteArrayOutputStream();
			MatrixToImageWriter.writeToStream(bitMatrix, "PNG", pngOutputStream);
			byte[] qrimg = pngOutputStream.toByteArray();
			qrcodeRepository.GenerateGatePassQrcode(gatepass.getQrcodeheight(), gatepass.getQrcodewidth(), lable, qrimg,
					gatepass.getId(), gatepass.getQrcodeposition());
			result = true;
		} else {
			result = false;

		}
		return result;
	}

	// view gatepass qrcode image
	public byte[] getGatePassQrcodeImageView(Integer invoiceid) throws Exception {
		return qrcodeRepository.getGatePassQrcodeImageView(invoiceid);
	}

	// generate Dist wise purchase product qrcode
	public boolean GenerateDistPurchaseProductQrcode(PurchaseInvoice Purchaseproduct) throws Exception {
		boolean result = true;
		if (result == true) {
			String random = "QPIP";
			String compFormat = String.format("%03d", Purchaseproduct.getCompanyrefid());
			String productFormat = String.format("%05d", Purchaseproduct.getId());
			String lable = random + compFormat + productFormat;
			System.out.println(">>>>>>>>>>>>>>>" + lable);
			QRCodeWriter Writer = new QRCodeWriter();
			Writer.encode(lable, BarcodeFormat.QR_CODE, 12, 12);
			BitMatrix bitMatrix = Writer.encode(lable, BarcodeFormat.QR_CODE, Purchaseproduct.getQrcodewidth(),
					Purchaseproduct.getQrcodeheight());
			ByteArrayOutputStream pngOutputStream = new ByteArrayOutputStream();
			MatrixToImageWriter.writeToStream(bitMatrix, "PNG", pngOutputStream);
			byte[] qrimg = pngOutputStream.toByteArray();
			qrcodeRepository.GenerateDistPurchaseProductQrcode(Purchaseproduct.getQrcodeheight(),
					Purchaseproduct.getQrcodewidth(), lable, qrimg, Purchaseproduct.getId());
			result = true;
		} else {
			result = false;

		}
		return result;
	}

	// view purchase produt qrcodeimage
	public byte[] getPurchaseProductQrcodeImageView(Integer invoiceproductid) throws Exception {
		return qrcodeRepository.getPurchaseProductQrcodeImageView(invoiceproductid);
	}

	// generate purchase order qrcode
	public boolean GeneratePurchaseOrderQrcode(PurchaseOrder purchaseorder) throws Exception {
		boolean result = true;
		if (result == true) {
			String random = "QPOR";
			String compFormat = String.format("%03d", purchaseorder.getCompanyrefid());
			String productFormat = String.format("%05d", purchaseorder.getId());
			String lable = random + compFormat + productFormat;
			System.out.println(">>>>>>>>>>>>>>>" + lable);
			QRCodeWriter Writer = new QRCodeWriter();
			Writer.encode(lable, BarcodeFormat.QR_CODE, 12, 12);
			BitMatrix bitMatrix = Writer.encode(lable, BarcodeFormat.QR_CODE, purchaseorder.getQrcodewidth(),
					purchaseorder.getQrcodeheight());
			ByteArrayOutputStream pngOutputStream = new ByteArrayOutputStream();
			MatrixToImageWriter.writeToStream(bitMatrix, "PNG", pngOutputStream);
			byte[] qrimg = pngOutputStream.toByteArray();
			qrcodeRepository.GeneratePurchaseOrderQrcode(purchaseorder.getQrcodeheight(),
					purchaseorder.getQrcodewidth(), lable, qrimg, purchaseorder.getId());
			result = true;
		} else {
			result = false;

		}
		return result;
	}

	// view purchase order qrcodeimage
	public byte[] getPurchaseOrderQrcodeImageView(Integer invoiceid) throws Exception {
		return qrcodeRepository.getPurchaseOrderQrcodeImageView(invoiceid);
	}

	// generate sales order qrcode
	public boolean GenerateSalesOrderQrcode(Salesorder salesorder) throws Exception {
		boolean result = true;
		if (result == true) {
			String random = "QSOR";
			String compFormat = String.format("%03d", salesorder.getCompanyrefid());
			String productFormat = String.format("%05d", salesorder.getId());
			String lable = random + compFormat + productFormat;
			System.out.println(">>>>>>>>>>>>>>>" + lable);
			QRCodeWriter Writer = new QRCodeWriter();
			Writer.encode(lable, BarcodeFormat.QR_CODE, 12, 12);
			BitMatrix bitMatrix = Writer.encode(lable, BarcodeFormat.QR_CODE, salesorder.getQrcodewidth(),
					salesorder.getQrcodeheight());
			ByteArrayOutputStream pngOutputStream = new ByteArrayOutputStream();
			MatrixToImageWriter.writeToStream(bitMatrix, "PNG", pngOutputStream);
			byte[] qrimg = pngOutputStream.toByteArray();
			qrcodeRepository.GenerateSalesOrderQrcode(salesorder.getQrcodeheight(), salesorder.getQrcodewidth(), lable,
					qrimg, salesorder.getId());
			result = true;
		} else {
			result = false;

		}
		return result;
	}

	// view sales order qrcodeimage
	public byte[] getSalesOrderQrcodeImageView(Integer invoiceid) throws Exception {
		return qrcodeRepository.getSalesOrderQrcodeImageView(invoiceid);
	}

}
