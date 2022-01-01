package com.medeil.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.medeil.domain.Barqrsettings;

@Repository
public interface Barqrrepository extends JpaRepository<Barqrsettings, Long> {
	
	@Query(value = "SELECT b.barqrid,b.barcodeheight,b.barcodewidth,b.qrcodeheight,b.qrcodewidth FROM medc_settings.barqr_settings b\r\n" + 
			"where companyid =?1 and branchid=?2 and locname =?3 and locrefid =?4", nativeQuery = true)
	List viewbarqrsettings(int companyid,int branchid,int locname,int locrefid);
	
	//Qrcode Image View
	@Query(value = "SELECT qrcodeimage from medc_stock.medc_mainstock WHERE StockID=?1", nativeQuery = true)
	byte[] getQrcodeImage(Integer stockid);
}
