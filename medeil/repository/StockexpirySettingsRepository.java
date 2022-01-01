package com.medeil.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.medeil.domain.Shortexpirysettings;



//DesingRaja
@SuppressWarnings("rawtypes")
@Repository
public interface StockexpirySettingsRepository extends JpaRepository<Shortexpirysettings,Long> {

	Shortexpirysettings findByUserid(int intValue);

	
	@Query(value = "SELECT COUNT(se.locrefid) FROM medc_stock.medc_shortexpsettings se WHERE se.locrefid=:locid" ,nativeQuery =true)
	Integer checkvalue(@Param("locid") Integer locid);
	
	@Query(value="SELECT ms.drugproductid,cpm.brandname,cpm.genericnamedosage,gm.genericname,ms.Batchname,ms.expirydate,ms.qty FROM medc_stock.medc_mainstock ms\r\n" + 
			"    INNER JOIN medc_productmaster.medc_custproductmaster cpm ON cpm.productdrugid = ms.DrugProductID\r\n" + 
			"    INNER JOIN medc_productmaster.medc_genericmaster gm ON gm.genericid = cpm.genericid\r\n" + 
			"    INNER JOIN medc_stock.medc_shortexpsettings se ON se.locrefid = ms.locrefid\r\n" + 
			"    WHERE ms.CompanyRefID=:comid AND ms.BranchRefID=:branchid AND ms.LocName=:locname AND ms.LocRefID=:locrefid AND ms.ExpiryDate between curdate() and DATE_ADD(curdate(),INTERVAL se.no_days day) and ms.Qty>0 order by cpm.BrandName",nativeQuery=true)
	List getexpdataday(@Param("comid") Integer comid,@Param("branchid") Integer branchid,@Param("locname") Integer locname,@Param("locrefid") Integer locrefid);

	
	@Query(value="SELECT ms.drugproductid,cpm.brandname,cpm.genericnamedosage,gm.genericname,ms.Batchno,ms.expirydate,ms.qty FROM medc_stock.medc_mainstock ms\r\n" + 
			"    INNER JOIN medc_productmaster.medc_custproductmaster cpm ON cpm.productdrugid = ms.DrugProductID\r\n" + 
			"    INNER JOIN medc_productmaster.medc_genericmaster gm ON gm.genericid = cpm.genericid\r\n" + 
			"    INNER JOIN medc_stock.medc_shortexpsettings se ON se.locrefid = ms.locrefid\r\n" + 
		    "    WHERE ms.CompanyRefID=:comid AND ms.BranchRefID=:branchid AND ms.LocName=:locname AND ms.LocRefID=:locrefid AND ms.ExpiryDate between curdate() and DATE_ADD(curdate(),INTERVAL se.no_month month) and ms.Qty>0 order by cpm.BrandName",nativeQuery=true)
	List getexpdatamonth(@Param("comid") Integer comid,@Param("branchid") Integer branchid,@Param("locname") Integer locname,@Param("locrefid") Integer locrefid);
	
	@Query(value="SELECT ms.drugproductid,cpm.brandname,cpm.genericnamedosage,gm.genericname,ms.Batchno,ms.expirydate,ms.qty FROM medc_stock.medc_mainstock ms\r\n" + 
			"    INNER JOIN medc_productmaster.medc_custproductmaster cpm ON cpm.productdrugid = ms.DrugProductID\r\n" + 
			"    INNER JOIN medc_productmaster.medc_genericmaster gm ON gm.genericid = cpm.genericid\r\n" + 
			"    INNER JOIN medc_stock.medc_shortexpsettings se ON se.locrefid = ms.locrefid\r\n" + 
			"    WHERE ms.CompanyRefID=:comid AND ms.BranchRefID=:branchid AND ms.LocName=:locname AND ms.LocRefID=:locrefid AND ms.ExpiryDate between curdate() and DATE_ADD(curdate(),INTERVAL se.no_year year) and ms.Qty>0 order by cpm.BrandName",nativeQuery=true)
	List getexpdatayear(@Param("comid") Integer comid,@Param("branchid") Integer branchid,@Param("locname") Integer locname,@Param("locrefid") Integer locrefid);

	//Raja D
	@Query(value="SELECT no_days FROM medc_stock.medc_shortexpsettings WHERE companyrefid=:comid AND branchrefid=:branchid AND locname=:locname AND locrefid =:locrefid",nativeQuery=true)
	Integer getnoofdays(@Param("comid") Integer comid,@Param("branchid") Integer branchid,@Param("locname") Integer locname,@Param("locrefid") Integer locrefid);

	@Query(value="SELECT no_month FROM medc_stock.medc_shortexpsettings WHERE companyrefid=:comid AND branchrefid=:branchid AND locname=:locname AND locrefid =:locrefid",nativeQuery=true)
	Integer getnoofmonth(@Param("comid") Integer comid,@Param("branchid") Integer branchid,@Param("locname") Integer locname,@Param("locrefid") Integer locrefid);

	
	@Query(value="SELECT no_year FROM medc_stock.medc_shortexpsettings WHERE companyrefid=:comid AND branchrefid=:branchid AND locname=:locname AND locrefid =:locrefid",nativeQuery=true)
	Integer getnoofyear(@Param("comid") Integer comid,@Param("branchid") Integer branchid,@Param("locname") Integer locname,@Param("locrefid") Integer locrefid);

	
	

}
