package com.medeil.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.medeil.domain.Damage_stock;
import com.medeil.domain.Damagestock;

@SuppressWarnings("rawtypes")
@Repository

public interface DamagestockRepository extends JpaRepository<Damagestock, Long> {

	@Query(value = "SELECT pi.piid,(pi.pino) FROM medc_purchase.medc_purchaseinvoice pi\r\n" + 
			"INNER JOIN medc_stock.medc_mainstock ms ON ms.purchinvrefid = pi.piid\r\n" + 
			"WHERE pi.CompanyRefID=:cid AND pi.BranchRefID=:bid AND pi.LocRefID=:locrefid AND pi.LocName=:locname AND ms.damagedestroystatus=0 Order BY pi.piid DESC", nativeQuery = true)
	List getInvoiceinfo(@Param("cid") int cid, @Param("bid") int bid, @Param("locrefid") int locrefid,
			@Param("locname") int locname);

	@Query(value = "SELECT * FROM medc_adminsecurity.medc_locationref", nativeQuery = true)
	List getLocc();

	@Query(value = "SELECT ShopID, ShopName FROM medc_storereg.medc_shopinformation", nativeQuery = true)
	List getshopinfo();

	@Query(value = "SELECT warehouseID,Warehousename FROM medc_warehousereg.medc_warehouseinfo", nativeQuery = true)
	List getwareInfo();

	@Query(value = "SELECT HospitalID, HospitalName FROM medc_hospitalreg.hospitalregistration", nativeQuery = true)
	List gethospInfo();
//Raja Add country state and city for tax concept
	@Query(value = "SELECT p.PIID,DATE_FORMAT(p.PIDate,'%Y-%m-%d')AS PIDate,d.DistributorName,d.MobileNo,p.GrANDTotal,d.DistributorID,d.country,d.state,d.city FROM medc_purchase.medc_purchaseinvoice p\r\n" + 
			"			LEFT JOIN medc_distributor.medc_distributorinformation d ON p.VendorID=d.DistributorID\r\n" + 
			"			WHERE  p.CompanyRefID=:cid AND p.BranchRefID=:bid AND p.LocRefID=:locrefid AND p.LocName=:locname AND p.PIID=:id", nativeQuery = true)
	List invoicedtails(@Param("cid") int cid, @Param("bid") int bid, @Param("locrefid") int locrefid,
			@Param("locname") int locname, @Param("id") int id);

	@Query(value = " SELECT  c.BrandName,m.BatchNo AS batchnumber,ms.ExpiryDate,ms.qty AS currentqty,ms.BoxQty,ms.StripQty,ms.TabletQty,\n" + 
			" ms.purchaseprice,ms.vat,ms.unitgst,ms.unitsgst,ms.unitcgst,ms.unitigst,ms.unitutgst,pi.Discount,c.ProductDrugID,ms.BatchNo,pi.TotalQuantity,COALESCE(dmg.damagedqty,0) FROM medc_stock.medc_mainstock ms\n" + 
			" LEFT JOIN medc_productmaster.medc_custproductmaster c ON ms.DrugProductID=c.ProductDrugID\n" + 
			" LEFT JOIN medc_stock.medc_drugbatch m ON ms.BatchNo=m.BatchID\n" + 
			" LEFT JOIN medc_purchase.medc_piproduct pi ON ms.purchinvrefid =pi.pirefid\n" + 
			" LEFT join (select dmp.damagedqty,dmp.stkproductrefid,dm.invoiceno  from medc_purchasereturn.medc_damagestkproduct dmp inner join medc_purchasereturn.medc_damagestocks dm on damagestkrefid = damagestkid WHERE dmp.companyrefid =:cid AND dmp.locname =:locname AND dmp.locrefid=:locrefid) dmg on dmg.invoiceno = ms.purchinvrefid\n" + 
			" WHERE  ms.CompanyRefID=:cid AND ms.BranchRefID=:bid AND ms.LocRefID=:locrefid AND ms.LocName=:locname AND  ms.purchinvrefid=:id AND damagedestroystatus=0 group by ms.DrugProductID;", nativeQuery = true)
	List pidetails(@Param("cid") int cid, @Param("bid") int bid, @Param("locrefid") int locrefid,@Param("locname") int locname, @Param("id") int id);
	//Save Damage Stock Form DesingRaja
		
	 @Query(value="SELECT COALESCE(MAX(damagestockno),'DAM000000000') FROM medc_purchasereturn.medc_damagestocks WHERE companyrefid=?1 AND branchrefid=?2 AND locname=?3 AND locrefid=?4",nativeQuery = true)
	    String lastPurchasedc(int companyrefid, int branchrfid, int locname , int locrefid);
	
	 @Query(value="SELECT MAX(damagestkid) FROM medc_purchasereturn.medc_damagestocks", nativeQuery = true)
	 Integer getdamagestkid();
	 
	 
	@Query(value = "select Stripperbox,Quantityperstrip from medc_productmaster.medc_custproductmaster where ProductDrugID=:id", nativeQuery = true)
	List damageboxinfo(@Param("id") int id);

	@Query(value = "SELECT Purchasetax FROM medc_fixedsettings.medc_taxsettings WHERE CompanyRefID= :cid and  BranchRefID= :bid and ShopRefID= :shopid", nativeQuery = true)
	List getshopDamTax(@Param("cid") int cid, @Param("bid") int bid, @Param("shopid") int shopid);

	@Query(value = "SELECT Purchasetax FROM medc_fixedsettings.medc_taxsettings WHERE CompanyRefID= :cid and  BranchRefID= :bid and HospitalRefID= :hospitalid", nativeQuery = true)
	List gethospitalDamTax(@Param("cid") int cid, @Param("bid") int bid, @Param("hospitalid") int hospitalid);

	@Query(value = "SELECT Purchasetax FROM medc_fixedsettings.medc_taxsettings WHERE CompanyRefID= :cid and  BranchRefID= :bid and WarehouseRefID= :warehouseid", nativeQuery = true)
	List getwarehouseDamTax(@Param("cid") int cid, @Param("bid") int bid, @Param("warehouseid") int warehouseid);

	@Query(value = "SELECT vat_gst FROM medc_fixedsettings.medc_taxsettings WHERE CompanyRefID= :cid and BranchRefID= :bid and ShopRefID= :shopid", nativeQuery = true)
	List chechshopTaxmaster(@Param("cid") int cid, @Param("bid") int bid, @Param("shopid") int shopid);

	@Query(value = "SELECT vat_gst FROM medc_fixedsettings.medc_taxsettings WHERE CompanyRefID= :cid and BranchRefID= :bid and HospitalRefID= :hospitalid", nativeQuery = true)
	List chechhospitalTaxmaster(@Param("cid") int cid, @Param("bid") int bid, @Param("hospitalid") int hospitalid);

	@Query(value = "SELECT vat_gst FROM medc_fixedsettings.medc_taxsettings WHERE CompanyRefID= :cid and BranchRefID= :bid and WarehouseRefID= :warehouseid", nativeQuery = true)
	List chechwarehouseTaxmaster(@Param("cid") int cid, @Param("bid") int bid, @Param("warehouseid") int warehouseid);

	@Procedure(name = "medc_purchasereturn.pro_damageTable")
	public boolean createDamage_stock(List<Damage_stock> damage_stock) throws Exception;

	/** VIEW PURCHASE INVOICE RECORD **/
	@Query(value = "select s.DamageStkID,s.Damagestockno, s.InvoiceNo,p.PINO, DATE_FORMAT(s.DamageStockDate, '%d-%m-%Y')as DamageStockDate"
			+ ",s.DistName, Round(s.TotalAmount,2)as TotalAmount  FROM medc_purchasereturn.medc_damagestocks s left join medc_purchase.medc_purchaseinvoice p on s.InvoiceNo=p.PIID "
			+ "WHERE s.CompanyRefID= :cid and s.BranchRefID= :bid and s.LocRefID= :locrefid and s.LocName= :locname and s.status=0  order by s.DamageStkID desc", nativeQuery = true)
	List getViewdamage(@Param("cid") int cid, @Param("bid") int bid, @Param("locrefid") int locrefid,
			@Param("locname") int locname);

	/** Edit Damage RECORD **/
	@Query(value = "select d.Damagestockno,p.PINO,d.DamageStockDate,d.InvoiceDate,d.DistName,d.ContactNo,d.Remarks,d.packing,d.TotalAmount,d.VendorID,d.DamageStkID from medc_purchasereturn.medc_damagestocks d,medc_purchase.medc_purchaseinvoice p where d.DamageStkID= :id and d.InvoiceNo=p.PIID and  d.CompanyRefID= :cid and d.BranchRefID= :bid and d.LocRefID= :locrefid and d.LocName= :locname", nativeQuery = true)
	List getEditdamage(@Param("cid") int cid, @Param("bid") int bid, @Param("locrefid") int locrefid,
			@Param("locname") int locname, @Param("id") int id);

	@Query(value = "select p.BrandName,dp.BatchNo,dp.ExpiryDate,dp.TabQty,dp.TabDamagedQty,dp.StripQty,dp.StripDamagedQty,dp.BoxQty,dp.DamagedBoxQty,dp.Qty,dp.DamagedQty,dp.UnitPrice,dp.UnitVat,dp.UnitGst,dp.UnitSGST,dp.UnitCGST,dp.UnitIGST,dp.UnitUTGST,dp.UnitDiscount,dp.SubTotal,dp.Total_Amount,p.ProductDrugID,dp.DmgStkPrdID,dp.BatchNumber from medc_purchasereturn.medc_damagestkproduct dp,medc_productmaster.medc_custproductmaster p where  dp.DamageStkRefID= :id and dp.StkProductRefID=p.ProductDrugID and  dp.CompanyRefID= :cid and dp.BranchRefID= :bid and dp.LocRefID= :locrefid and dp.LocName= :locname", nativeQuery = true)
	List getEditdamagetable(@Param("cid") int cid, @Param("bid") int bid, @Param("locrefid") int locrefid,
			@Param("locname") int locname, @Param("id") int id);

	@Query(value = "SELECT ms.drugproductid,CONCAT(pr.BrandName, '_', pr.GenericNameDosage) as BrandNames FROM medc_stock.medc_mainstock ms\r\n" + 
			"INNER JOIN medc_productmaster.medc_custproductmaster pr ON pr.productdrugid =ms.drugproductid\r\n" + 
			"WHERE pr.BrandName like :val% AND ms.companyrefid =:cid AND ms.branchrefid = :bid AND ms.locname =:locname AND ms.locrefid=:locrefid", nativeQuery = true)
	List getBrandlist(@Param("val") String val, @Param("cid") int cid,@Param("bid") int bid,@Param("locname") int locname,@Param("locrefid") int locrefid);

	@Query(value = "SELECT ms.drugproductid,CONCAT(pr.BrandName, '_', pr.GenericNameDosage) AS BrandNames FROM medc_stock.medc_mainstock ms\r\n" + 
			"INNER JOIN medc_productmaster.medc_custproductmaster pr ON pr.productdrugid = ms.drugproductid\r\n" + 
			"WHERE pr.BrandName like :val% and ms.companyrefid=:cid AND ms.locrefid =:locrefid", nativeQuery = true)
	List getproddetails(@Param("val") String val, @Param("cid") int cid, @Param("locrefid") int locrefid);

	
	
	@Query(value = "SELECT c.BrandName,s.Batchno,s.ExpiryDate,s.Qty,s.BoxQty,s.StripQty,s.TabletQty,s.PurchasePrice\n" + 
			",s.vat,s.unitgst,s.unitsgst,s.unitcgst,s.unitigst,s.unitutgst,s.DrugProductID,s.BatchName,IFNULL(pi.vendorid,0),IFNULL(vi.country,0),IFNULL(vi.state,0),IFNULL(vi.city,0) FROM medc_stock.medc_mainstock s\n" + 
			"LEFT JOIN medc_productmaster.medc_custproductmaster c ON s.DrugProductID=c.ProductDrugID\n" + 
			"LEFT JOIN medc_purchase.medc_purchaseinvoice pi ON pi.piid =s.purchinvrefid\n" + 
			"LEFT JOIN medc_distributor.medc_distributorinformation vi ON vi.distributorid = pi.vendorid\n" + 
			"WHERE  DrugProductID=:productid AND s.CompanyRefID=:cid AND s.BranchRefID=:bid AND s.LocRefID=:locrefid AND s.LocName=:locname", nativeQuery = true)
	List getDatabledata(@Param("productid") int productid, @Param("cid") int cid, @Param("bid") int bid,@Param("locrefid") int locrefid, @Param("locname") int locname);
	
	/** VIEW PURCHASE INVOICE RECORD **/
	@Query(value = "select s.DamageStkID,s.Damagestockno, s.InvoiceNo,p.PINO, DATE_FORMAT(s.DamageStockDate, '%d-%m-%Y')as DamageStockDate,s.DistName, Round(s.TotalAmount,2)as TotalAmount,sh.ShopName  FROM medc_purchasereturn.medc_damagestocks s left join medc_purchase.medc_purchaseinvoice p on s.InvoiceNo=p.PIID left join medc_storereg.medc_shopinformation sh on sh.ShopID=s.LocRefID	WHERE s.CompanyRefID= :cid and s.BranchRefID= :bid and s.ToLocRefID= :locrefid and s.ToLocName= :locname and s.status=0", nativeQuery = true)
	List getViewhqshopdamage(@Param("cid") int cid, @Param("bid") int bid, @Param("locrefid") int locrefid,
			@Param("locname") int locname);
	
	@Query(value = "select s.DamageStkID,s.Damagestockno, s.InvoiceNo,p.PINO, DATE_FORMAT(s.DamageStockDate, '%d-%m-%Y')as DamageStockDate,s.DistName, Round(s.TotalAmount,2)as TotalAmount,wh.Warehousename  FROM medc_purchasereturn.medc_damagestocks s left join medc_purchase.medc_purchaseinvoice p on s.InvoiceNo=p.PIID left join medc_warehousereg.medc_warehouseinfo wh on wh.warehouseID=s.LocRefID	WHERE s.CompanyRefID= :cid and s.BranchRefID= :bid and s.ToLocRefID= :locrefid and s.ToLocName= :locname and s.status=0", nativeQuery = true)
	List getViewhqwarehousedamage(@Param("cid") int cid, @Param("bid") int bid, @Param("locrefid") int locrefid,
			@Param("locname") int locname);
	
	@Query(value = "select s.DamageStkID,s.Damagestockno, s.InvoiceNo,p.PINO, DATE_FORMAT(s.DamageStockDate, '%d-%m-%Y')as DamageStockDate,s.DistName, Round(s.TotalAmount,2)as TotalAmount,hp.HospitalName  FROM medc_purchasereturn.medc_damagestocks s left join medc_purchase.medc_purchaseinvoice p on s.InvoiceNo=p.PIID left join medc_hospitalreg.hospitalregistration hp on hp.HospitalID=s.LocRefID	WHERE s.CompanyRefID= :cid and s.BranchRefID= :bid and s.ToLocRefID= :locrefid and s.ToLocName= :locname and s.status=0", nativeQuery = true)
	List getViewhqhospitaldamage(@Param("cid") int cid, @Param("bid") int bid, @Param("locrefid") int locrefid,
			@Param("locname") int locname);

	/** ViewHQ Damage RECORD **/
	@Query(value = "select d.Damagestockno,p.PINO,d.DamageStockDate,d.InvoiceDate,d.DistName,d.ContactNo,d.Remarks,d.packing,d.TotalAmount,d.VendorID,d.DamageStkID from medc_purchasereturn.medc_damagestocks d left join medc_purchase.medc_purchaseinvoice p on p.PIID=d.InvoiceNo where d.DamageStkID= :id and  d.CompanyRefID= :cid and d.BranchRefID= :bid and d.LocRefID= :locrefid and d.LocName= :locname and d.ToLocName= :locname and d.ToLocRefID= :locrefid", nativeQuery = true)
	List getHqdamage(@Param("cid") int cid, @Param("bid") int bid, @Param("locrefid") int locrefid,
			@Param("locname") int locname, @Param("id") int id);

	@Query(value = "select cu.brandName,dp.BatchNo,dp.ExpiryDate,dp.TabQty,dp.TabDamagedQty,dp.StripQty,dp.StripDamagedQty,dp.BoxQty,dp.DamagedBoxQty,dp.Qty,dp.DamagedQty,dp.UnitPrice,dp.UnitVat,dp.UnitGst,dp.UnitSGST,dp.UnitCGST,dp.UnitIGST,dp.UnitUTGST,dp.UnitDiscount,dp.SubTotal,dp.Total_Amount,dp.DmgStkPrdID,dp.StkProductRefID from medc_purchasereturn.medc_damagestkproduct dp left join medc_purchasereturn.medc_damagestocks d on dp.DamageStkRefID=d.DamageStkID inner join medc_productmaster.medc_custproductmaster cu on cu.ProductDrugID=dp.StkProductRefID where  dp.DamageStkRefID= :id and dp.CompanyRefID= :cid and dp.BranchRefID= :bid and dp.LocRefID= :locrefid and dp.LocName= :locname and d.ToLocName= :locname and d.ToLocRefID= :locrefid", nativeQuery = true)
	List getHqdamagetable(@Param("cid") int cid, @Param("bid") int bid, @Param("locrefid") int locrefid,
			@Param("locname") int locname, @Param("id") int id);

	
	/** DELETE DAMAGE STOCK RECORD **/
	@Modifying
	@Transactional
	@Query(value = "UPDATE medc_purchasereturn.medc_damagestocks da,medc_purchasereturn.medc_damagestkproduct dap SET da.Status='2',dap.Status='2' WHERE da.DamageStkID= :id and dap.DmgStkPrdID= :id", nativeQuery = true)
	public void deleteDamage(@Param("id") int id);
	//
	
}
