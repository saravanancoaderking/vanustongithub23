package com.medeil.repository;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.medeil.domain.Stocks;

@SuppressWarnings("rawtypes")
@Repository
public interface StocksRepository extends JpaRepository<Stocks, Long> {

	@Query(value = "SELECT pr.ProductDrugID,CONCAT(pr.BrandName,'_',pr.GenericNameDosage) as BrandName FROM medc_productmaster.medc_custproductmaster pr "
			+ "WHERE pr.BrandName LIKE :product% and companyID= :cid ORDER BY pr.BrandName", nativeQuery = true)
	List getStockProduct(@Param("product") String product, @Param("cid") int cid);

	@Query(value = "SELECT GenericNameDosage,mrp,ifnull(vat,0),ifnull(cgst,0),ifnull(utgst,0),ifnull(igst,0),ifnull(sgst,0) FROM medc_productmaster.medc_custproductmaster WHERE ProductDrugID= :id", nativeQuery = true)
	List getProDosage(@Param("id") int id);

	@Query(value = "SELECT fr.FormulationID,fr.FormulationName FROM medc_productmaster.medc_formulation fr "
			+ "INNER JOIN  medc_productmaster.medc_custproductmaster  pr ON fr.FormulationID=pr.FormulationID WHERE pr.ProductDrugID= :id", nativeQuery = true)
	List getProFormulation(@Param("id") int id);

	/*
	 * @Query(value =
	 * "SELECT pr.BrandName,CONCAT(pr.GenericNameDosage,coalesce(pr.UOM,'')) as DosageValue,fr.FormulationName,bh.Batchno,st.BoxPerStrip,"
	 * +
	 * "st.StripPerTablet,st.BoxQty,st.StripQty,st.TabletQty,st.Qty,st.FreeTotalQty,DATE_FORMAT(st.ExpiryDate,'%Y-%m-%d') as Expiry,st.MRP,st.PurchasePrice,"
	 * +
	 * "st.SellingPrice, st.Margin,st.MarginAmt,st.StockID,DATEDIFF(now(),st.StockDate) as dates,pr.ProductDrugID FROM medc_stock.medc_mainstock st "
	 * +
	 * "INNER JOIN medc_productmaster.medc_custproductmaster pr ON pr.ProductDrugID=st.DrugProductID	"
	 * +
	 * "INNER JOIN  medc_productmaster.medc_formulation  fr ON fr.FormulationID=st.FormulationID "
	 * + "INNER JOIN  medc_stock.medc_drugbatch bh ON bh.BatchID=st.batchno " +
	 * "WHERE st.Status=0 and bh.status=0 and st.CompanyRefID= :cid and st.LocRefID= :locrefid and st.LocName= :locname ORDER BY st.StockID"
	 * , nativeQuery = true) List viewStocks(@Param("cid") int
	 * cid, @Param("locrefid") int locrefid, @Param("locname") int locname);
	 */
	// Boopalan 04062019
	@Query(value = "SELECT pr.BrandName,st.dosageid,fr.FormulationName,bh.Batchno,st.BoxPerStrip,\r\n"
			+ "st.StripPerTablet,st.BoxQty,st.StripQty,st.TabletQty,st.Qty,st.FreeTotalQty,DATE_FORMAT(st.ExpiryDate,'%Y-%m-%d') as Expiry,st.MRP,st.PurchasePrice,\r\n"
			+ "st.SellingPrice, st.Margin,st.MarginAmt,st.StockID,st.ageingtime,pr.ProductDrugID, ses.no_days,ses.no_month,ses.no_year,st.damageqty FROM medc_stock.medc_mainstock st\r\n"
			+ "INNER JOIN medc_productmaster.medc_custproductmaster pr ON pr.ProductDrugID=st.DrugProductID\r\n"
			+ "INNER JOIN  medc_productmaster.medc_formulation  fr ON fr.FormulationID=st.FormulationID\r\n"
			+ "INNER JOIN  medc_stock.medc_drugbatch bh ON bh.BatchID=st.batchno\r\n"
			+ "LEFT JOIN medc_stock.medc_shortexpsettings ses ON ses.locrefid=st.locrefid\r\n"
			+ "WHERE st.Status=0 and bh.status=0 and st.CompanyRefID=:cid and st.branchrefid =:bid and st.LocRefID=:locrefid and st.LocName=:locname and "
			+ "IF((SELECT SUM(hh.qty) FROM medc_stock.medc_mainstock hh WHERE hh.DrugProductID =st.DrugProductID)>0,st.qty,st.Qty>=0) ORDER BY st.StockID desc \n#page\n",

			countQuery = "select count(StockID) FROM medc_stock.medc_mainstock st\r\n"
					+ "INNER JOIN medc_productmaster.medc_custproductmaster pr ON pr.ProductDrugID=st.DrugProductID\r\n"
					+ "INNER JOIN  medc_productmaster.medc_formulation  fr ON fr.FormulationID=st.FormulationID\r\n"
					+ "INNER JOIN  medc_stock.medc_drugbatch bh ON bh.BatchID=st.batchno\r\n"
					+ "LEFT JOIN medc_stock.medc_shortexpsettings ses ON ses.locrefid=st.locrefid\r\n"
					+ "WHERE st.Status=0 and bh.status=0 and st.CompanyRefID=:cid and st.branchrefid =:bid and st.LocRefID=:locrefid and st.LocName=:locname "
					+ "and IF((SELECT SUM(hh.qty) FROM medc_stock.medc_mainstock hh WHERE hh.DrugProductID =st.DrugProductID)>0,st.qty,st.Qty>=0) ORDER BY st.StockID", nativeQuery = true)
	Page viewStocks(@Param("cid") int cid, @Param("bid") int bid, @Param("locrefid") int locrefid,
			@Param("locname") int locname, @Param("page") Pageable page);

	// Puthiran 270220 search stockproducts
	@Query(value = "SELECT pr.BrandName,st.dosageid,fr.FormulationName,bh.Batchno,st.BoxPerStrip,"
			+ "st.StripPerTablet,st.BoxQty,st.StripQty,st.TabletQty,st.Qty,st.FreeTotalQty,DATE_FORMAT(st.ExpiryDate,'%Y-%m-%d') as Expiry,st.MRP,st.PurchasePrice,"
			+ "st.SellingPrice, st.Margin,st.MarginAmt,st.StockID,st.ageingtime,pr.ProductDrugID,st.damageqty FROM medc_stock.medc_mainstock st "
			+ "INNER JOIN medc_productmaster.medc_custproductmaster pr ON pr.ProductDrugID=st.DrugProductID	"
			+ "INNER JOIN  medc_productmaster.medc_formulation  fr ON fr.FormulationID=st.FormulationID "
			+ "INNER JOIN  medc_stock.medc_drugbatch bh ON bh.BatchID=st.batchno "
			+ "WHERE st.Status=0 and bh.status=0 and st.CompanyRefID= :cid and st.branchrefid = :bid and st.LocRefID= :locrefid and st.LocName= :locname and pr.brandname like :searchvalue% "
			+ "and IF((SELECT SUM(hh.qty) FROM medc_stock.medc_mainstock hh WHERE hh.DrugProductID =st.DrugProductID)>0,st.qty,st.Qty>=0) ORDER BY st.StockID desc \n#page\n",

			countQuery = "select count(StockID) FROM medc_stock.medc_mainstock st "
					+ "INNER JOIN medc_productmaster.medc_custproductmaster pr ON pr.ProductDrugID=st.DrugProductID	"
					+ "INNER JOIN  medc_productmaster.medc_formulation  fr ON fr.FormulationID=st.FormulationID "
					+ "INNER JOIN  medc_stock.medc_drugbatch bh ON bh.BatchID=st.batchno "
					+ "WHERE st.Status=0 and bh.status=0 and st.CompanyRefID= :cid and st.branchrefid = :bid and st.LocRefID= :locrefid and st.LocName= :locname and pr.brandname like :searchvalue% "
					+ "and IF((SELECT SUM(hh.qty) FROM medc_stock.medc_mainstock hh WHERE hh.DrugProductID =st.DrugProductID)>0,st.qty,st.Qty>=0) ORDER BY st.StockID", nativeQuery = true)
	Page searchstockproduct(@Param("cid") int cid, @Param("bid") int bid, @Param("locrefid") int locrefid,
			@Param("locname") int locname, @Param("searchvalue") String searchvalue, @Param("page") Pageable page);

	// Puthiran 270220 search stockformulations
	@Query(value = "SELECT pr.BrandName,st.dosageid,fr.FormulationName,bh.Batchno,st.BoxPerStrip,"
			+ "st.StripPerTablet,st.BoxQty,st.StripQty,st.TabletQty,st.Qty,st.FreeTotalQty,DATE_FORMAT(st.ExpiryDate,'%Y-%m-%d') as Expiry,st.MRP,st.PurchasePrice,"
			+ "st.SellingPrice, st.Margin,st.MarginAmt,st.StockID,st.ageingtime,pr.ProductDrugID,st.damageqty FROM medc_stock.medc_mainstock st "
			+ "INNER JOIN medc_productmaster.medc_custproductmaster pr ON pr.ProductDrugID=st.DrugProductID	"
			+ "INNER JOIN  medc_productmaster.medc_formulation  fr ON fr.FormulationID=st.FormulationID "
			+ "INNER JOIN  medc_stock.medc_drugbatch bh ON bh.BatchID=st.batchno "
			+ "WHERE st.Status=0 and bh.status=0 and st.CompanyRefID=:cid and st.branchrefid=:bid and st.LocRefID=:locrefid and st.LocName=:locname and fr.FormulationName like :searchvalue% "
			+ "and IF((SELECT SUM(hh.qty) FROM medc_stock.medc_mainstock hh WHERE hh.DrugProductID =st.DrugProductID)>0,st.qty,st.Qty>=0) ORDER BY st.StockID desc \n#page\n",

			countQuery = "select count(StockID) FROM medc_stock.medc_mainstock st "
					+ "INNER JOIN medc_productmaster.medc_custproductmaster pr ON pr.ProductDrugID=st.DrugProductID	"
					+ "INNER JOIN  medc_productmaster.medc_formulation  fr ON fr.FormulationID=st.FormulationID "
					+ "INNER JOIN  medc_stock.medc_drugbatch bh ON bh.BatchID=st.batchno "
					+ "WHERE st.Status=0 and bh.status=0 and st.CompanyRefID= :cid and st.branchrefid = :bid and st.LocRefID= :locrefid and st.LocName= :locname and fr.FormulationName like :searchvalue% "
					+ "and IF((SELECT SUM(hh.qty) FROM medc_stock.medc_mainstock hh WHERE hh.DrugProductID =st.DrugProductID)>0,st.qty,st.Qty>=0) ORDER BY st.StockID", nativeQuery = true)
	Page searchstockformulation(@Param("cid") int cid, @Param("bid") int bid, @Param("locrefid") int locrefid,
			@Param("locname") int locname, @Param("searchvalue") String searchvalue, @Param("page") Pageable page);

	/*** Edit Stock ***/
	Stocks findById(int id);
	
	@Query(value = "SELECT cp.brandname FROM medc_productmaster.medc_custproductmaster cp\r\n" + 
			"where cp.productdrugid=:drugid", nativeQuery = true)
	List getstockdrugname(@Param("drugid") int drugid);

	@Query(value = "SELECT BatchNo FROM medc_stock.medc_drugbatch WHERE BatchID= :id", nativeQuery = true)
	List editStockdos(@Param("id") int id);

	@Query(value = "SELECT fr.FormulationID,fr.FormulationName FROM medc_productmaster.medc_formulation fr "
			+ "INNER JOIN  medc_stock.medc_mainstock  pr ON fr.FormulationID=pr.FormulationID WHERE pr.FormulationID= :id  GROUP BY pr.FormulationID", nativeQuery = true)
	List editStockForm(@Param("id") int id);

	@Query(value = "SELECT StockID,unitsgst FROM medc_stock.medc_mainstock  WHERE stockid= :id", nativeQuery = true)
	List editSgst(@Param("id") int id);

	@Query(value = "SELECT StockID,unitcgst FROM medc_stock.medc_mainstock  WHERE stockid= :id", nativeQuery = true)
	List editCgst(@Param("id") int id);

	@Query(value = "SELECT StockID,unitigst FROM medc_stock.medc_mainstock  WHERE stockid= :id", nativeQuery = true)
	List editIgst(@Param("id") int id);

	@Query(value = "SELECT StockID,unitutgst FROM medc_stock.medc_mainstock  WHERE stockid= :id", nativeQuery = true)
	List editUtgst(@Param("id") int id);

	@Query(value = "SELECT StockID,unitgst FROM medc_stock.medc_mainstock  WHERE stockid= :id", nativeQuery = true)
	List editGst(@Param("id") int id);

	@Query(value = "SELECT StockID,vat FROM medc_stock.medc_mainstock  WHERE stockid= :id", nativeQuery = true)
	List editVat(@Param("id") int id);

	@Modifying
	@Transactional
	@Query(value = "UPDATE  medc_stock.medc_mainstock SET Status=2 WHERE StockID= :id", nativeQuery = true)
	Integer deleteStock(@Param("id") int id);

	@Modifying
	@Transactional
	@Query(value = "UPDATE  medc_stock.medc_mainstock SET AgeingTime = AgeingTime+1", nativeQuery = true)
	void stockEntryAge();

	@Modifying
	@Transactional
	@Query(value = "update medc_stock.medc_mainstock set manufdateage = DATEDIFF(now(),manufactureddate)", nativeQuery = true)
	void manufDateAge();

	@Modifying
	@Transactional
	@Query(value = "update medc_stock.medc_mainstock set expiryage = DATEDIFF(expirydate,now())", nativeQuery = true)
	void ExpiryAge();

	// Boopalan
	@Query(value = "select coalesce(sum(m.ReceiveTotalQty),0) FROM medc_stock.medc_stkrecproduct m inner join (select max(clientcdate)lastdate,DrugProductRefID,locname,locrefid FROM medc_stock.medc_stkrecproduct  where DrugProductRefID =?5 and CompanyRefID=?1 and BranchRefID =?2 and locname =?3 and locrefid =?4 )mn on mn.lastdate = m.clientcdate where  m.CompanyRefID=?1 and m.BranchRefID =?2 and m.locname =?3 and m.locrefid =?4 and m.DrugProductRefID =?5 ", nativeQuery = true)
	Integer getLastReceivedQty(Integer compid, Integer branchid, Integer locname, Integer locrefid,
			Integer drugproductrefid);

	// Boopalan 250919 mainstock , minimum stock update
	@Modifying
	@Transactional
	@Query(value = "update medc_stock.medc_minimumstock set status = 5 where CompanyRefID=?1 and BranchRefID=?2 and LocName=?3 and LocRefID =?4  and drugproductid =?5 ", nativeQuery = true)
	void updateMinimumStock(Integer compid, Integer branchid, Integer locname, Integer locrefid,
			Integer drugproductrefid);

	// Boopalan 250919 mainstock , minimum stock update
	@Modifying
	@Transactional
	@Query(value = "update medc_stock.medc_mainstock set ministkrefid = 0 where CompanyRefID=?1 and BranchRefID=?2 and LocName=?3 and LocRefID =?4  and drugproductid =?5 ", nativeQuery = true)
	void ministkrefid(Integer compid, Integer branchid, Integer locname, Integer locrefid, Integer drugproductrefid);

	// DesingRaja
	@Query(value = "SELECT ms.drugproductid, CONCAT(cpm.brandname,' ',cpm.genericnamedosage) DrugName ,cm.categoryname, scm.subcategoryname,sch.schedulename,sch.scheduleid FROM medc_stock.medc_mainstock ms\r\n"
			+ "INNER JOIN medc_productmaster.medc_custproductmaster cpm ON cpm.productdrugid = ms.DrugProductID\r\n"
			+ "LEFT JOIN medc_productmaster.medc_categorymaster cm ON cm.categoryid = cpm.categoryid\r\n"
			+ "LEFT JOIN medc_productmaster.medc_subcategorymaster scm ON scm.subcategoryid = cpm.subcategoryid\r\n"
			+ "LEFT JOIN medc_productmaster.medc_schedule sch ON sch.scheduleid = cpm.schudletype\r\n"
			+ "WHERE ms.companyrefid =?1 AND ms.branchrefid =?2 AND ms.locname =?3 AND ms.locrefid =?4", nativeQuery = true)
	List getscheduledata(Integer compid, Integer branchid, Integer locname, Integer locrefid);

	// DesingRaja
	@Modifying
	@Transactional
	@Query(value = "update medc_productmaster.medc_custproductmaster set schudletype =:scheduleid where productdrugid =:productid", nativeQuery = true)
	void editschld(@Param("scheduleid") Integer scheduleid, @Param("productid") Integer productid);

	boolean existsById(Integer id);

	@Query(value = "SELECT totalquantity FROM medc_purchase.medc_piproduct where pirefid =?1 and drugproductrefid =?2 and batchno =?3", nativeQuery = true)
	String getinvproductqty(int invid, int drugid, String batchno);

	List<Stocks> findByCompanyrefidAndBranchrefidAndLocnameAndLocrefid(Integer cid, Integer bid, Integer lname,
			Integer lrefid);

	@Query(value = "Select vendorid from medc_purchase.medc_piproduct pipro\r\n"
			+ "inner join medc_purchase.medc_purchaseinvoice pi on pi.piid = pipro.pirefid where pipro.drugproductrefid = ?1 and pi.companyrefid =?2 and pi.branchrefid =?3 and pi.locname =?4 and pi.locrefid =?5 order by pipro.piproductid desc limit 1", nativeQuery = true)
	Integer getlastvendorid(Integer drugproductid, Integer companyrefid, Integer branchrefid, Integer locname,
			Integer locrefid);

	@Query(value = "select IFNULL(max(DATEDIFF(pi.pidate,po.podate)),0) as leadtime,IFNULL(avg(DATEDIFF(pi.pidate,po.podate)),0) as avgleadtime,IFNULL(min(DATEDIFF(pi.pidate,po.podate)),0) as minleadtime from medc_purchase.medc_purchaseinvoice pi\r\n"
			+ "inner join medc_distributor.medc_distributorinformation di on pi.vendorid=di.distributorid\r\n"
			+ "left join medc_purchase.medc_purchaseorder po on po.poid = pi.refpoid\r\n"
			+ "where di.distributorid=?1 and pi.companyrefid=?2  and pi.branchrefid=?3 and pi.locname=?4 and pi.locrefid=?5 order by pi.piid desc limit 10", nativeQuery = true)
	List<Object[]> getLeadtime(Integer venid, Integer companyrefid, Integer branchrefid, Integer locname,
			Integer locrefid);

	@Query(value = "SELECT IFNULL(max(indvqty),0) as maxqty,IFNULL(avg(indvqty),0) as avaqty,IFNULL(min(indvqty),0) as minqty,ADDDATE(curdate(), INTERVAL -7 DAY) as lastweekendate FROM medc_sales.medc_salesbill where drugproductid =?1 and ADDDATE(curdate(), INTERVAL -7 DAY) and companyrefid = ?2 and branchrefid = ?3 and locname = ?4 and locrefid =?5", nativeQuery = true)
	List<Object[]> getMaxsalesstk(Integer drugproductid, Integer companyrefid, Integer branchrefid, Integer locname,
			Integer locrefid);

	// Stocks Update from Damage forms Raja
	Stocks findByDrugproductidAndBatchnoAndCompanyrefidAndLocrefid(Integer drugproductid, String batchid,
			Integer compid, Integer locrefid);

	List<Stocks> findByDrugproductidAndCompanyrefidAndBranchrefidAndLocnameAndLocrefid(Integer drugproductrefid,
			Integer compid, Integer branchid, Integer locname, Integer locrefid);

	Stocks findByDrugproductidAndBatchnoAndCompanyrefidAndBranchrefidAndLocnameAndLocrefid(Integer stkproductrefid,
			String valueOf, Integer companyrefid, Integer branchrefid, Integer locname, Integer locrefid);

	Optional<Stocks> findByPurchinvrefidAndDrugproductidAndCompanyrefidAndLocrefidAndLocname(Integer pirefid,
			Integer drugproductrefid, Integer companyrefid, Integer locrefid, Integer locname);

	@Query(value = "SELECT COALESCE((qty*unitprice),0) FROM medc_stock.medc_mainstock where stockid =?1", nativeQuery = true)
	Double getClosingStock(Integer id);

	@Query(value = "SELECT ms.batchno,db.batchno AS batchname FROM medc_stock.medc_mainstock ms\n"
			+ "INNER JOIN medc_stock.medc_drugbatch db ON db.batchid =ms.batchno\n"
			+ "WHERE ms.companyrefid=?1 AND ms.branchrefid=?2 AND ms.locname=?3 AND ms.locrefid=?4", nativeQuery = true)
	List getbatch(Integer cid, Integer bid, Integer lname, Integer lrefid);
}
