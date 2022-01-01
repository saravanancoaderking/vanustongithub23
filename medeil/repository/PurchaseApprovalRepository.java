/**
 * 
 */
package com.medeil.repository;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.medeil.domain.PurchaseApproval;

/**
 * @author AjithKumar
 *
 */
@SuppressWarnings("rawtypes")
@Repository
public interface PurchaseApprovalRepository extends JpaRepository<PurchaseApproval, Long> {

	@Query(value = "SELECT distinct po.piid,po.pino FROM medc_purchase.medc_purchaseinvoice po\r\n"
			+ "    		INNER JOIN medc_purchase.medc_piproduct pop ON pop.pirefid = po.piid\r\n"
			+ "    		WHERE  pop.paflag =0 AND po.companyrefid=:cid AND po.branchrefid=:bid AND po.locname =:locname AND po.locrefid=:locrefid order by PIID desc", nativeQuery = true)
	List getPurcinvoiceno(@Param("cid") int cid, @Param("bid") int bid, @Param("locrefid") int locrefid,
			@Param("locname") int locname);

	@Query(value = "SELECT pi.DrugProductRefID,concat(pr.BrandName,'',pr.GenericNameDosage,'',fr.FormulationName) productname, IFNULL((po.BoxQuantity - pi.BoxQuantity),0),pi.StripQuantity,pi.TabletQuantity,pi.TotalQuantity,pi.UnitPrice,pi.Discount,pi.VAT,pi.GST,pi.SGST,pi.CGST,pi.IGST,pi.UTGST,dp.Batchno,pi.PurPrice,pi.SalesDiscount,pi.MRP,pi.FormulationID,pi.DosageID,pi.ExpiryDate,pi.FreeBoxQty,pi.FreeStripQty,pi.FreeTabletQty,pi.FreeTotalQty,pi.VATAmt,pi.GSTAmt,pi.SGSTAmt,pi.CGSTAmt,pi.IGSTAmt,pi.UTGSTAmt,dp.Batchid,coalesce(stk.approvalqty,0),coalesce(stk.damageqty,0),coalesce(stk.penddingqty,0),shelfno,rackno,pi.stripperbox,pi.quantityperstrip,coalesce(pi.sellingprice,0),pi.packageunit from medc_purchase.medc_piproduct pi\r\n" + 
			"INNER JOIN medc_productmaster.medc_custproductmaster pr on pr.ProductDrugID=pi.DrugProductRefID\r\n" + 
			"inner join medc_stock.medc_drugbatch dp on dp.batchid = pi.batchno\r\n" + 
			"left join medc_purchase.medc_purchaseinvoice piv on piv.piid = pi.PIRefID\r\n" + 
			"left join medc_purchase.medc_poproduct po on po.PORefID = piv.Refpoid\r\n" + 
			"inner join medc_productmaster.medc_formulation fr on pr.FormulationID=fr.FormulationID\r\n" + 
			"left join medc_stock.medc_mainstock stk on stk.batchno = dp.batchid and pi.pirefid=stk.PurchInvRefID\r\n" + 
			"where pi.pirefid =:id and pi.paflag =0 group by dp.Batchid", nativeQuery = true)
	List getPurcApprovaldata(@Param("id") int id);

	@Modifying
	@Transactional
	@Query(value = "update medc_purchase.medc_piproduct  set paflag = 1  where  companyrefid =?1 and branchrefid=?2 and  locname=?3 and locrefid=?4 and pirefid =?5 and drugproductrefid =?6 and batchno =?7 ", nativeQuery = true)
	int updatepurstatus(int comp, int branch, int locname, int locrefid, int purcid, int drugid, String batchno);

	@Query(value = "SELECT stockid FROM medc_stock.medc_mainstock where drugproductid =?1 and batchno =?2", nativeQuery = true)
	Integer getStockid(Integer drugproductid, String batchno);

	@Query(value = "Select coalesce(MAX(PurcApprovalNo),'PAN000000000') from medc_stock.medc_purchaseapproval where companyrefid=?1 and branchrefid=?2 and locname=?3 and locrefid=?4", nativeQuery = true)
	String lastPurchaseApp(Integer companyrefid, Integer branchrefid, Integer locname, Integer locrefid);

	@Query(value = "SELECT MAX(purcapprovalID) FROM medc_stock.medc_purchaseapproval", nativeQuery = true)
	Integer getPurchasAppID();

	@Query(value = "SELECT   IFNULL(  max( purcapprovalID ) ,0 )  FROM   medc_stock.medc_purchaseapproval   where   LocName=?1 and LocRefID=?2", nativeQuery = true)
	int viewPurchaseAppId(Double locname, Double locrefid);

	@Query(value = "select PurcApprovalNo from medc_stock.medc_purchaseapproval order by purcapprovalID desc limit 1", nativeQuery = true)
	String viewPurchaseAppMaxNo(Double locname, Double locrefid);

	@Query(value = "SELECT distributorname FROM medc_distributor.medc_distributorinformation where distributorid =?1", nativeQuery = true)
	String viewCustName(Integer personid);

	@Query(value = "SELECT di.distributorid,di.Distributorname,di.Dlno,di.GSTno,di.Address1,di.country,di.state,di.city FROM medc_distributor.medc_distributorinformation di\r\n"
			+ "inner join medc_purchase.medc_purchaseinvoice p on p.vendorid = di.distributorid where piid =?1", nativeQuery = true)
	List getVendordetails(Integer id);

	@Query(value = "SELECT pa.PurcApprovalno,date(PurcApprovalDate),pi.pino FROM medc_stock.medc_purchaseapproval pa\r\n"
			+ "inner join medc_purchase.medc_purchaseinvoice pi on pi.piid = pa.purchaseinvrefid where  pa.locname =?1 and pa.locrefid =?2", nativeQuery = true)
	ArrayList getPurchaseduelist(Integer lname, Integer lrefid);
}
