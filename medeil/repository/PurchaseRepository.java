package com.medeil.repository;

import java.util.List;
import java.util.Map;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.medeil.domain.Purchase;
import com.medeil.domain.PurchaseInvoice;

/**
 * @author Ajith Kumar
 *
 */
@SuppressWarnings("rawtypes")
@Repository
public interface PurchaseRepository extends JpaRepository<Purchase, Long>, PurcRepository {

	@Query(value = "SELECT DistributorID,DistributorName FROM medc_distributor.medc_distributorinformation Where CompanyRefID= :cid and BranchRefID= :bid and LocRefID= :locrefid and LocName=1 and status=0", nativeQuery = true)
	List getshopDistributor(@Param("cid") int cid, @Param("bid") int bid, @Param("locrefid") int locrefid);

	@Query(value = "SELECT DistributorID,DistributorName FROM medc_distributor.medc_distributorinformation Where CompanyRefID= :cid and BranchRefID= :bid and LocRefID= :locrefid and LocName=2 and status=0", nativeQuery = true)
	List getwareDistributor(@Param("cid") int cid, @Param("bid") int bid, @Param("locrefid") int locrefid);

	@Query(value = "SELECT DistributorID,DistributorName FROM medc_distributor.medc_distributorinformation Where CompanyRefID= :cid and BranchRefID= :bid and LocRefID= :locrefid and LocName=3 and status=0", nativeQuery = true)
	List gethospDistributor(@Param("cid") int cid, @Param("bid") int bid, @Param("locrefid") int locrefid);

	@Query(value = "SELECT distributorid,Distributorname,Dlno,GSTno,Address1,country,state,city FROM medc_distributor.medc_distributorinformation WHERE  DistributorID= :distid", nativeQuery = true)
	List getDistvalues(@Param("distid") int distid);

	@Query(value = "SELECT pr.ProductDrugID,CONCAT(pr.BrandName, '_',ifnull(pr.GenericNameDosage,'1mg'), '_',ifnull(fo.formulationname,'Tablet')) as BrandNames,phr.pshortname,phr.pcompanyname FROM medc_productmaster.medc_custproductmaster pr inner join medc_productmaster.medc_formulation fo on fo.formulationid=pr.formulationid"
			+ " left join medc_pharmacompany.medc_pharmacompanies phr on pcompanyid = pr.pharmacompanyid WHERE pr.BrandName like :val% and pr.companyID =:cid", nativeQuery = true)
	List getBrandlist(@Param("val") String val, @Param("cid") int cid);

	@Query(value = "SELECT pr.ProductDrugID,pr.BrandName,fr.FormulationName,CONCAT(pr.GenericNameDosage,coalesce(pr.UOM,''))as DosageValue,ph.pshortname,pr.VAT,pr.CGST,pr.SGST,COALESCE(pr.MRP,0),pr.GST,pr.GenericNameDosage,pr.FormulationID,pr.PharmaCompanyID as mfg,pr.IGST,pr.UTGST,coalesce(stk.mrp,0),coalesce(stk.sellingprice,0)\r\n" + 
			"			FROM medc_productmaster.medc_custproductmaster pr\r\n" + 
			"      left join medc_productmaster.medc_formulation fr on fr.FormulationID=pr.FormulationID\r\n" + 
			"      left join medc_pharmacompany.medc_pharmacompanies ph on ph.pcompanyid = pr.pharmacompanyid\r\n" + 
			"      left join medc_stock.medc_mainstock stk on stk.drugproductid = pr.productdrugid\r\n" + 
			"			WHERE pr.ProductDrugID= :productid and companyID= :cid group by pr.productdrugid", nativeQuery = true)
	List getPitabledata(@Param("productid") int productid, @Param("cid") int cid);

	@Query(value = "SELECT ProductDrugID FROM medc_productmaster.medc_custproductmaster WHERE BrandName= :data GROUP BY BrandName", nativeQuery = true)
	Integer getProductid(@Param("data") String data);

	@Query(value = "SELECT MAX(PIID) as PIID  FROM medc_purchase.medc_purchaseinvoice WHERE CompanyRefID= ?1 and BranchRefID=?2  and  LocName=?3  and LocRefID= ?4", nativeQuery = true)
	List<Integer> getPIID(Integer companyrefid, Integer branchrefid, Integer locname, Integer locrefid);
	//	Integer getPIID(@Param("cid") int cid, @Param("bid") int bid, @Param("locrefid") int locrefid,
//			@Param("locname") int locname);

	@Query(value = "SELECT Stripperbox,Quantityperstrip FROM medc_productmaster.medc_custproductmaster WHERE ProductDrugID= :id", nativeQuery = true)
	List getpurQuantity(@Param("id") int id);

	/** VIEW PURCHASE INVOICE RECORD **/
	@Query(value = "SELECT pi.PIID, pi.VendorInvoiceNo, di.DistributorName,DATE_FORMAT(pi.PIDate, '%d-%m-%Y') as PIDate,ROUND(pi.TotalProduct,2) as TotalProduct, pi.grandtotal,pi.PINO FROM medc_purchase.medc_purchaseinvoice pi,medc_distributor.medc_distributorinformation di "
			+ "WHERE pi.VendorID=di.DistributorID and pi.Status=0 and pi.CompanyRefID= :cid and pi.BranchRefID= :bid and pi.LocName= :locname and pi.LocRefID= :locrefid ORDER BY pi.PIID desc", nativeQuery = true)
	List getViewinvoice(@Param("cid") int cid, @Param("bid") int bid, @Param("locrefid") int locrefid,
			@Param("locname") int locname);

	/** EDIT PURCHASE INVOICE RECORD **/ // Boopalan 150419
	@Query(value = "SELECT pi.PIProductID,pi.PIRefID,pi.DrugProductRefID,concat(pr.BrandName,IFNULL(pr.GenericNameDosage,'-'),'',IFNULL(fr.FormulationName,'-'))  productname, fr.FormulationName,CONCAT(pr.GenericNameDosage,coalesce(pr.UOM,''))as DosageValue,pr.PharmaCompanyID as mfg,pi.BoxQuantity,\r\n" + 
			"			pi.StripQuantity, pi.TabletQuantity, pi.TotalQuantity,pi.Discount,pi.DiscountAmt, pi.VAT,\r\n" + 
			"			pi.VATAmt, pi.GST, pi.GSTAmt, pi.SGST, pi.SGSTAmt, pi.CGST, pi.CGSTAmt, pi.IGST, pi.IGSTAmt,pi.TotalProductPrice,\r\n" + 
			"			ph.pshortname, pb.BatchNo, pi.DosageID, pi.PurPrice,pi.SalesDiscount,pi.FormulationID,\r\n" + 
			"			pi.FreeBoxQty,pi.FreeStripQty,pi.FreeTabletQty,pi.FreeTotalQty, pi.MRP,\r\n" + 
			"			pi.ExpiryDate,pi.UTGST,pi.UTGSTAmt,pi.stripperbox,pi.quantityperstrip,pi.sellingprice,coalesce(hsn.hsncode,'NA'),hsn.hsnid,pi.unitprice,pi.packageunit FROM medc_purchase.medc_piproduct pi\r\n" + 
			"      inner join medc_productmaster.medc_custproductmaster pr on pi.DrugProductRefID=pr.ProductDrugID\r\n" + 
			"      left join medc_productmaster.medc_formulation fr on pi.FormulationID=fr.FormulationID\r\n" + 
			"      inner join medc_pharmacompany.medc_pharmacompanies ph on ph.pcompanyid = pr.PharmaCompanyID\r\n" + 
			"      left join medc_stock.medc_drugbatch pb on pb.batchid=pi.batchno\r\n" + 
			"      left join medc_productmaster.medc_hsncodemaster hsn on hsn.hsnid = pr.hsnid\r\n" +
			"			WHERE PIRefID=:id and pi.Status=0", nativeQuery = true)
	List getEditpurchase(@Param("id") int id);

	@Query(value = "SELECT ps.PIID,ps.PINO,DATE_FORMAT(ps.PIDate, '%Y-%m-%d') as PIDate,ps.VendorID,ps.VendorInvoiceNo,ps.DeliveryType,d.Dlno,d.GSTno,d.Address1,"
			+ "ps.ItemAmt,ps.TotalProduct,ps.TotalDiscount,ps.Roundoff,ps.CashDiscount,ps.TaxableAmt,ps.TotalTaxAmt,ps.TotalMargin,ps.TotalFreeQty,ps.VATAmt,ps.GSTAmt, ps.CGSTAmt, ps.SGSTAmt, ps.IGSTAmt,ps.UTGSTAmt,ps.TotalQuantity,ps.CompanyRefID,ps.BranchRefID,ps.LocName,ps.LocRefID,ps.grandtotal,ps.refpoid,ps.cashdiscountpercent FROM  medc_purchase.medc_purchaseinvoice ps,medc_purchase.medc_piproduct pi,medc_distributor.medc_distributorinformation d "
			+ "WHERE ps.PIID=pi.PIRefID and ps.VendorID=d.DistributorID and pi.PIRefID= :id GROUP BY pi.PIRefID", nativeQuery = true)
	List getEditpurcMaintance(@Param("id") int id);

	/** DELETE PURCHASE INVOICE RECORD **/
	@Modifying
	@Transactional
	@Query(value = "UPDATE medc_purchase.medc_purchaseinvoice pm,medc_purchase.medc_piproduct pi SET pm.Status='2',pi.Status='2' WHERE pm.PIID= :id and pi.PIREFID= :id", nativeQuery = true)
	public void deletePurchaseinvoice(@Param("id") int id);

	/**
	 * START MAPPING ONE REPOSITORY TO ANOTHER REPOSITORY (STORED PROCEDURE)
	 **/
	@Procedure(name = "medc_purchase.pro_purchaseInvoice")
	public boolean createRecord(Purchase purchase) throws Exception;

	@Procedure(name = "medc_purchase.pro_purcInvoice")
	public boolean createPurcinvoice(List<PurchaseInvoice> purchaseinvoice) throws Exception;

	@Procedure(name = "medc_purchase.pro_purchaseInvoice")
	public boolean updateRecord(Purchase purchase) throws Exception;

	@Procedure(name = "medc_purchase.pro_purcInvoice")
	public boolean updatePurcinvoice(List<PurchaseInvoice> purchaseinvoice) throws Exception;

	/** END **/
	/*
	 * @Query(value =
	 * "SELECT POID,PONO FROM medc_purchase.medc_purchaseorder WHERE Status=0 and CompanyRefID= :cid and BranchRefID= :bid and LocName= :locname and LocRefid= :locrefid  order by poid desc"
	 * , nativeQuery = true) List getPurchaseOrder(@Param("cid") int
	 * cid, @Param("bid") int bid, @Param("locrefid") int locrefid,
	 * 
	 * @Param("locname") int locname);
	 */

	/** END **/
	@Query(value = "SELECT distinct po.POID,po.PONO FROM medc_purchase.medc_purchaseorder po inner join medc_purchase.medc_poproduct pop on pop.porefid=po.poid  WHERE pop.Status=0 and pop.piflag=0 and po.CompanyRefID= :cid and po.BranchRefID= :bid and po.LocName= :locname and po.LocRefid= :locrefid  order by po.POID desc", nativeQuery = true)
	List getPurchaseOrder(@Param("cid") int cid, @Param("bid") int bid, @Param("locrefid") int locrefid,
			@Param("locname") int locname);

@Query(value = "SELECT pr.ProductDrugID,concat(pr.BrandName,'',IFNULL(pr.GenericNameDosage,'-'),'',IFNULL(fr.FormulationName,'-')) productname,fr.FormulationName,CONCAT(pr.GenericNameDosage,coalesce(pr.UOM,''))as DosageValue,\r\n" + 
		"		   ph.pshortname,coalesce(stk.MRP,0),pr.FormulationID,pr.PharmaCompanyID as mfg,po.BoxQuantity,po.StripQuantity,po.TabletQuantity,\r\n" + 
		"		   coalesce(po.UnitPrice,0),po.Discount,pr.VAT,pr.GST,pr.SGST,pr.CGST,pr.IGST,pr.UTGST,'NA',0,coalesce(hsn.hsncode,'NA'),hsn.hsnid,po.stripperbox,po.quantityperstrip,po.totalquantity,coalesce(stk.sellingprice,0),po.packageunit FROM  medc_purchase.medc_poproduct po\r\n" + 
		"		   inner join medc_productmaster.medc_custproductmaster pr on pr.ProductDrugID=po.DrugProductRefID\r\n" + 
		"		   left join medc_productmaster.medc_formulation fr on fr.FormulationID  = pr.FormulationID\r\n" + 
		"		   left join medc_productmaster.medc_hsncodemaster hsn on hsn.hsnid = pr.hsnid\r\n" + 
		"		   left join medc_pharmacompany.medc_pharmacompanies  ph on ph.pcompanyid  = pr.PharmaCompanyID\r\n" + 
		"       left join medc_stock.medc_mainstock stk on stk.drugproductid = pr.productdrugid WHERE po.PORefID=:pid group by pr.productdrugid", nativeQuery = true)
	List getPurchaseOrdertable(@Param("pid") int pid);


	/** Purchase Tax **/
	@Query(value = "SELECT Purchasetax FROM medc_fixedsettings.medc_taxsettings WHERE CompanyRefID= :cid and  BranchRefID= :bid and ShopRefID= :locrefid", nativeQuery = true)
	List getshopPurTax(@Param("cid") int cid, @Param("bid") int bid, @Param("locrefid") int locrefid);

	@Query(value = "SELECT Purchasetax FROM medc_fixedsettings.medc_taxsettings WHERE CompanyRefID= :cid and  BranchRefID= :bid and WarehouseRefID= :locrefid", nativeQuery = true)
	List getwarePurTax(@Param("cid") int cid, @Param("bid") int bid, @Param("locrefid") int locrefid);

	@Query(value = "SELECT Purchasetax FROM medc_fixedsettings.medc_taxsettings WHERE CompanyRefID= :cid and  BranchRefID= :bid and HospitalRefID= :locrefid", nativeQuery = true)
	List gethospPurTax(@Param("cid") int cid, @Param("bid") int bid, @Param("locrefid") int locrefid);

	@Query(value = "SELECT vat_gst,cgst,sgst,igst,ugst FROM medc_fixedsettings.medc_taxsettings WHERE CompanyRefID= :cid and BranchRefID= :bid and ShopRefID= :locrefid", nativeQuery = true)
	List chechshopTaxmaster(@Param("cid") int cid, @Param("bid") int bid, @Param("locrefid") int locrefid);

	@Query(value = "SELECT vat_gst FROM medc_fixedsettings.medc_taxsettings WHERE CompanyRefID= :cid and BranchRefID= :bid and WarehouseRefID= :locrefid", nativeQuery = true)
	List chechwareTaxmaster(@Param("cid") int cid, @Param("bid") int bid, @Param("locrefid") int locrefid);

	@Query(value = "SELECT vat_gst FROM medc_fixedsettings.medc_taxsettings WHERE CompanyRefID= :cid and BranchRefID= :bid and HospitalRefID= :locrefid", nativeQuery = true)
	List chechhospTaxmaster(@Param("cid") int cid, @Param("bid") int bid, @Param("locrefid") int locrefid);

	@Query(value = "SELECT di.distributorid,di.Distributorname,di.Dlno,di.GSTno,di.Address1,di.country,di.state,di.city FROM medc_purchase.medc_purchaseorder po\r\n" + 
			"			inner join medc_distributor.medc_distributorinformation di on di.distributorid=po.vendorid where po.poid=:pid group by distributorname", nativeQuery = true)
	List getdistrepo(@Param("pid") int pid);

	/** PURCHASE INVOICE LIST **/ // Boopalan 090419
	@Query(value = "SELECT PIID, PINO FROM medc_purchase.medc_purchaseinvoice  WHERE Status=0 and CompanyRefID= :cid and BranchRefID= :bid and LocName= :locname and LocRefid= :locrefid", nativeQuery = true)
	List getPurchaseInvoiceList(@Param("cid") int cid, @Param("bid") int bid, @Param("locname") int locname,
			@Param("locrefid") int locrefid);

	/** GET EDIT POID PURCHASE INVOICE **/ // Boopalan 230519
	@Query(value = "SELECT m.poid,m.pono FROM medc_purchase.medc_purchaseorder m inner join medc_purchase.medc_purchaseinvoice pi on pi.refpoid = m.poid where m.Status=0 and piid=:piids", nativeQuery = true)
	List getpoidpi(@Param("piids") int piids);

	@Query(value = "SELECT   IFNULL(  max( piid ) ,0 )  FROM   medc_purchase.medc_purchaseinvoice   where   LocName=?1 and LocRefID=?2", nativeQuery = true)
	int viewPurchaseInvoiceId(Double lcrnm, Double lcrid);
	
	@Query(value = "select pi.pino from medc_purchase.medc_purchaseinvoice pi join(select max(piid) as maxid from medc_purchase.medc_purchaseinvoice where LocName=?1 and LocRefID=?2) pid on pid.maxid = pi.piid ", nativeQuery = true)
	String viewPurchaseInvoiceMaxNo(Double lcrnm, Double lcrid);
	
	@Query(value = "SELECT distributorname FROM medc_distributor.medc_distributorinformation where distributorid =?1", nativeQuery = true)
	String viewCustName(Integer id);
	
	
	 @Query(value="Select coalesce(MAX(pino),'PIV000000000') from medc_purchase.medc_purchaseinvoice where companyrefid=?1 and branchrefid=?2 and locname=?3 and locrefid=?4",nativeQuery = true)
	String lastPurchaseInvoice(Integer companyrefid, Integer branchrefid, Integer locname, Integer locrefid);

	@Query(value = "SELECT dcid,dist_dcno,dist_invno FROM medc_stock.medc_deliverchallan where companyrefid =?1 and branchrefid =?2 and locname =?3 and locrefid =?4 and poid =?5", nativeQuery = true)
	 List getdistdc(Integer cmpid, Integer brnchid, Integer lname, Integer lrefid, Integer poid);

	@Query(value = "SELECT pr.ProductDrugID,concat(pr.BrandName,'',IFNULL(pr.GenericNameDosage,'-'),'',IFNULL(fr.FormulationName,'-')) productname,fr.FormulationName,CONCAT(pr.GenericNameDosage,coalesce(pr.UOM,''))as DosageValue,ph.pshortname,coalesce(stk.MRP,0),pr.FormulationID,\r\n" + 
			"			pr.PharmaCompanyID as mfg,dcpro.BoxQty,dcpro.StripQty,dcpro.TabQty,coalesce(po.UnitPrice,0),po.Discount,pr.VAT,pr.GST,pr.SGST,pr.CGST,pr.IGST,pr.UTGST,date(dcpro.expirydate),dcpro.batchname,coalesce(hsn.hsncode,'NA'),hsn.hsnid,dcpro.stripperbox,dcpro.quantityperstrip,dcpro.totalqty,\r\n" + 
			"      coalesce(stk.sellingprice,0),dcpro.packageunit\r\n" + 
			"			from medc_stock.medc_dchallanproduct dcpro\r\n" + 
			"			inner join medc_productmaster.medc_custproductmaster pr on pr.ProductDrugID = dcpro.drugproductrefid\r\n" + 
			"			inner join medc_purchase.medc_poproduct po on po.porefid = dcpro.poid\r\n" + 
			"			inner join medc_productmaster.medc_formulation fr on fr.FormulationID = pr.FormulationID\r\n" + 
			"			left join medc_productmaster.medc_hsncodemaster hsn on hsn.hsnid = pr.hsnid\r\n" + 
			"			left join medc_pharmacompany.medc_pharmacompanies ph on ph.pcompanyid = pr.PharmaCompanyID\r\n" + 
			"      left join  medc_stock.medc_mainstock stk on stk.drugproductid = pr.productdrugid where dcpro.poid =?1 and dcpro.dcrefid =?2 group by pr.productdrugid",nativeQuery = true)
	List getdcproducts(Integer poid, Integer dcrefid);

	
	@Query(value = "SELECT hsnid,hsncode,gst FROM medc_productmaster.medc_hsncodemaster where chapter = 30", nativeQuery = true)
	List getHsncodelist();

	
	//Map getPurjournal(Integer cmpid, Integer brnchid, Integer lname, Integer lrefid, Integer invoiceno);	
}
