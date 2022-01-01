
package com.medeil.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.medeil.domain.PriceEnquiry;

@Repository
public interface PriceEnquiryRepository extends JpaRepository<PriceEnquiry, Long> {

	PriceEnquiry save(PriceEnquiry dt);

	@Query(value = " SELECT Distinct(ps.PurcSessionID),ps.PurcSessionNo FROM medc_purchase.medc_purchasesession ps inner join medc_purchase.medc_purcsessionproduct psp on psp.purcsessionrefid=ps.purcsessionid  where  ps.LocRefID=?2  and     ps.LocName=?1  and psp.peflag=0  order by ps.PurcSessionID desc; ", nativeQuery = true)
	List viewPurchSession(int lcrnm, int lcrid);

	@Query(value = "  SELECT  concat(pdt.BrandName,'',pdt.genericnamedosage,'',f.formulationname) productname,ps.PurcsessionRefID,ps.DrugProductID,ps.TotalQty,ps.indreqqty   ,ps.stktransapprqty,ps.stktransrejqty     FROM (medc_purchase.medc_purcsessionproduct ps,medc_productmaster.medc_formulation f)	left  join (SELECT BrandName,ProductDrugID,formulationid,genericnamedosage   from  medc_productmaster.medc_custproductmaster  where   ((LocName=?1 and  LocRefID=?2) || (companyID=?4)))  pdt on         ps.DrugProductID=pdt.ProductDrugID  where     ps.PurcsessionRefID=?3 and ps.peflag=0  and  f.formulationid=pdt.formulationid ", nativeQuery = true)
	List viewPurchSessionProd(int lcrnm, int lcrid, int sid, Integer compid);

	/*
	 * @Query(value =
	 * " SELECT  dist.DistributorID, dist.DistributorName, dprod.DrugPrdID ,dprod.MasterPrice, dist.creditdays      ,dist.leadtime ,pi2.UnitPrice   FROM  medc_distributor.medc_distproduct  dprod 	left join (  SELECT pip.DrugProductRefID,pi.VendorID ,max(pi.CreatedDate),pip.UnitPrice   FROM medc_purchase.medc_purchaseinvoice pi  left join ( SELECT * from  medc_purchase.medc_piproduct     )pip  on pi.PIID=pip.PIRefID  where pi. LocName=1 and pi.LocRefID=1    group  by  pip.DrugProductRefID,pi.VendorID   ) pi2  on pi2.DrugProductRefID=dprod.DrugPrdID  and pi2.VendorID=dprod.distrefid 	left join ( SELECT DistributorID,DistributorName,creditdays,leadtime  FROM medc_distributor.medc_distributorinformation ) dist  on dist.DistributorID=dprod.distrefid  	where  dprod.DrugPrdID= ?3     and    dprod.LocName=?1 and  dprod.LocRefID=?2  group  by   dprod.DrugPrdID   ,dprod.distrefid  "
	 * , nativeQuery = true) List viewProdWiseDist(int lcrnm, int lcrid, int drg);
	 */

	// pi2.UnitPrice //Boopalan 030719
	/*@Query(value = " SELECT  dist.DistributorID, dist.DistributorName, dprod.DrugPrdID ,dprod.MasterPrice, dist.creditdays      ,dist.leadtime , Coalesce(pd.previouspoprice,0) as prevprice ,pd.abc  FROM  medc_distributor.medc_distproduct  dprod 	left join (  SELECT pip.DrugProductRefID,pi.VendorID ,max(pi.CreatedDate),pip.UnitPrice   FROM medc_purchase.medc_purchaseinvoice pi  left join ( SELECT * from  medc_purchase.medc_piproduct     )pip  on pi.PIID=pip.PIRefID  where pi. LocName=1 and pi.LocRefID=1    group  by  pip.DrugProductRefID,pi.VendorID   ) pi2  on pi2.DrugProductRefID=dprod.DrugPrdID  and pi2.VendorID=dprod.distrefid 	left join ( SELECT DistributorID,DistributorName,creditdays,leadtime,`status`  FROM medc_distributor.medc_distributorinformation ) dist  on dist.DistributorID=dprod.distrefid inner join medc_purchase.medc_distselect pd on pd.vendorid = dist.DistributorID  	where  dprod.DrugPrdID= ?3     and    dprod.LocName=?1 and  dprod.LocRefID=?2 and dist.status=0  group  by   dprod.DrugPrdID   ,dprod.distrefid  ", nativeQuery = true)
	List viewProdWiseDist(int lcrnm, int lcrid, int drg);*/
	
	@Query(value = " SELECT  dist.DistributorID, dist.DistributorName, dprod.DrugPrdID ,dprod.MasterPrice, dist.creditdays      ,dist.leadtime , Coalesce(pd.previouspoprice,0) as prevprice ,ms.abc,pd.abc as dsabc,dprod.distprice  FROM  medc_distributor.medc_distproduct  dprod   left join (SELECT mst.abc,mst.drugproductid  FROM medc_stock.medc_mainstock mst WHERE mst.locname=?1 and mst.locrefid=?2 and mst.drugproductid=?3)  ms on ms.drugproductid=dprod.DrugPrdID   left join (SELECT pip.DrugProductRefID,pi.VendorID ,max(pi.CreatedDate),pip.UnitPrice   FROM medc_purchase.medc_purchaseinvoice pi  left join ( SELECT * from  medc_purchase.medc_piproduct     )pip  on pi.PIID=pip.PIRefID  where pi. LocName=?1 and pi.LocRefID=?2   group  by  pip.DrugProductRefID,pi.VendorID   ) pi2  on pi2.DrugProductRefID=dprod.DrugPrdID  and pi2.VendorID=dprod.distrefid   left join ( SELECT DistributorID,DistributorName,creditdays,leadtime,`status`  FROM medc_distributor.medc_distributorinformation ) dist  on dist.DistributorID=dprod.distrefid left join medc_purchase.medc_distselect pd on pd.vendorid = dist.DistributorID    where  dprod.DrugPrdID=?3    and    dprod.LocName=?1 and  dprod.LocRefID=?2 and dist.status=0  group  by   dprod.DrugPrdID   ,dprod.distrefid  ", nativeQuery = true)
	List viewProdWiseDist(int lcrnm, int lcrid, int drg);

	@Query(value = " SELECT    IFNULL( max(PrcEncProId) ,0)    FROM  medc_purchase.medc_priceenquiry      where  LocName=?1 and LocRefID=?2   ", nativeQuery = true)
	Double viewPrcEncId(Double lcrnm, Double lcrid);

	@Query(value = " SELECT    IFNULL( max(PrcEncId) ,0)    FROM  medc_purchase.medc_priceenquiry      where  LocName=?1 and LocRefID=?2   ", nativeQuery = true)
	Double viewPrcEncIdNU(Double lcrnm, Double lcrid);

	@Query(value = "  SELECT   IFNULL(RIGHT(prcencno, 7),0)    FROM  medc_purchase.medc_priceenquiry  where  PrcEncProId=?3     and    LocName=?1 and LocRefID=?2  ", nativeQuery = true)
	String viewPrcEncIncNo(Double lcrnm, Double lcrid, Double id);

	@Query(value = "  SELECT   penq.PrcEncId,penq.prcencno,DATE(penq.ClientCDate1), count(*) as  penqprod ,ps.PurcSessionNo,penq.DistSelFlag  FROM medc_purchase.medc_priceenquiry  penq  left join medc_purchase.medc_purchasesession   ps on  penq.PurchSessionId=ps.PurcSessionID  where    penq.LocName=?1 and  penq.LocRefID=?2 and  penq.Status!=5    group  by PrcEncId   ", nativeQuery = true)
	List viewPriceEnquiryAll(int lcrnm, int lcrid);

	@Query(value = "  SELECT  penq.PrcEncId,penq.prcencno,DATE(penq.ClientCDate1) ,ds.DistributorName,cust.BrandName        , penq.exppoqty,penq. exppoprice ,penq.DistFinalPrice ,penq.CreditDays,penq. LeadTime   ,penq. PriceUpdateFlag  FROM    medc_purchase.medc_priceenquiry  penq left join  (  SELECT DistributorID,DistributorName FROM medc_distributor.medc_distributorinformation  where locrefid=?2  and  LocName=?1  )  ds  on   ds.DistributorID =penq.Vendorid  left join  ( SELECT BrandName,ProductDrugID   from  medc_productmaster.medc_custproductmaster  where  companyID=?3 )  cust on   cust.ProductDrugID =penq.DrugProductrefId  where penq.LocName=?1 and penq.LocRefID=?2   and Status!=5  and DistSelFlag=1   ", nativeQuery = true)
	List viewPriceEnquiryNewAll(int lcrnm, int lcrid, Integer compid);

	@Query(value = "SELECT  pe. prcencno,DATE(pe.ClientCDate1), cust.ProductDrugID , pe.prodwaitingqty  ,ds. DistributorName        ,cust.BrandName , pe.ClientCDate1   as cldate,pe.CreditDays,pe.LeadTime      ,pe.exppoqty,pe.exppoprice ,pe.previouspoprice,pe.remarks,pe.abc    ,pe.distprodrank,pe.indreqqty,pe.stktransapprqty,pe.stktransrejqty  FROM medc_purchase.medc_priceenquiry  pe  	left join  ( SELECT DistributorID,DistributorName FROM medc_distributor.medc_distributorinformation  where locrefid=?2  and  LocName=?1)  ds    on   ds.DistributorID =pe.Vendorid    left join (SELECT BrandName,ProductDrugID   from  medc_productmaster.medc_custproductmaster  where    companyID=?4)  cust     on   cust.ProductDrugID =pe.DrugProductrefId     where   pe.PrcEncId= ?3    and    pe.LocName=?1 and pe.LocRefID=?2  ", nativeQuery = true)
	List viewPriceEnquiryProd(int lcrnm, int lcrid, int pid, Integer compid);

	@Modifying
	@Transactional
	@Query(value = " update  medc_purchase.medc_purchasesession   set    PrcEnqFlag=1  where   PurcSessionID=?3  and LocName=?1 and LocRefID=?2  ", nativeQuery = true)
	void updatePurcSession(Double lcrnm, Double lcrid, Double id);

	// selva

	@Query(value = "SELECT    ds.DistributorID ,ds. DistributorName  FROM medc_purchase.medc_priceenquiry  peq "
			+ "left join  (  SELECT DistributorID,DistributorName FROM medc_distributor.medc_distributorinformation)  ds "
			+ "    on   ds.DistributorID =peq.Vendorid "
			+ "left join  ( SELECT BrandName,ProductDrugID   from  medc_productmaster.medc_custproductmaster "
			+ "where   ((locName=:locname and  locRefID=:locrefid) || (companyID=:compid)) )  cust     on   cust.ProductDrugID =peq.DrugProductrefId "
			+ "      left join  (  SELECT DistRefID, DrugPrdID,DistPrice,CreditDays,LeadTime FROM medc_distributor.medc_distproduct "
			+ "       where locrefid=:locrefid  and  locName=:locname   group  by DistRefID, DrugPrdID  )  dp    on   dp.DistRefID =peq.Vendorid "
			+ "         and   dp.DrugPrdID =peq.DrugProductrefId   where  peq.BranchRefID=:branchid     and    LocName=:locname and locRefID=:locrefid group by peq.Vendorid ", nativeQuery = true)
	List getDisPriceEnq(@Param("compid") int compid, @Param("branchid") int branchid, @Param("locname") int locname,
			@Param("locrefid") int locrefid);

	@Query(value = "SELECT date(ClientCDate) as date FROM medc_purchase.medc_priceenquiry m where CompanyRefID =:compid and BranchRefID =:branchid and LocName =:locname and LocRefID =:locrefid and Vendorid =:vendorid group by date(ClientCDate)", nativeQuery = true)
	List getDate(@Param("compid") int compid, @Param("branchid") int branchid, @Param("locname") int locname,
			@Param("locrefid") int locrefid, @Param("vendorid") int vendorid);

	@Query(value = "SELECT    peq.PrcEncNo ,cust.BrandName, "
			+ "peq.exppoqty,peq.exppoprice,dp.DistPrice,ds.distributorid  FROM medc_purchase.medc_priceenquiry  peq "
			+ "left join  (  SELECT DistributorID,DistributorName FROM medc_distributor.medc_distributorinformation  where locrefid=:locrefid  and  LocName=:locname  )  ds "
			+ "    on   ds.DistributorID =peq.Vendorid "
			+ "left join  ( SELECT BrandName,ProductDrugID   from  medc_productmaster.medc_custproductmaster "
			+ "where   ((locName=:locname and  locRefID=:locrefid) || (companyID=:compid)) )  cust     on   cust.ProductDrugID =peq.DrugProductrefId "
			+ "      left join  (  SELECT DistRefID, DrugPrdID,DistPrice,CreditDays,LeadTime FROM medc_distributor.medc_distproduct "
			+ "       where locrefid=:locrefid  and  locName=:locname   group  by DistRefID, DrugPrdID  )  dp    on   dp.DistRefID =peq.Vendorid "
			+ "         and   dp.DrugPrdID =peq.DrugProductrefId   where  peq.BranchRefID=:branchid and LocName=:locname and locRefID=:locrefid and peq.Vendorid=:vendorid and date(ClientCDate)=:cdate  order by peq.PrcEncNo desc", nativeQuery = true)
	List getDistProd(@Param("compid") int compid, @Param("branchid") int branchid, @Param("locname") int locname,
			@Param("locrefid") int locrefid, @Param("vendorid") int vendorid, @Param("cdate") String cdate);

	@Modifying
	@Transactional
	@Query(value = " update medc_purchase.medc_purcsessionproduct set peflag =1 where  companyrefid=?1 and branchrefid=?2 and locname=?3 and locrefid=?4 and purcsessionrefid=?5 and DrugProductID=?6   ", nativeQuery = true)
	void updatepsflag(int comp, int branch, double locname, double locerefid, double purcid, double drugid);

	@Query(value = " SELECT disp.distprice  FROM medc_distributor.medc_distproduct disp WHERE disp.CompanyRefID=?1 and disp.LocName=?2 and  disp.LocRefID=?3 and disp.DrugPrdID=?4 and disp.status=0 and disp.distprice!=?5 ", nativeQuery = true)
	List viewDistPreviousPrice(Integer companyid, Integer locname, Integer locrefid, int distributorid, String price);

}
