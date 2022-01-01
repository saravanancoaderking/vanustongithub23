
package com.medeil.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.medeil.domain.PurchaseReturn;

@Transactional
@Repository
public interface PurchReturnRepository extends JpaRepository<PurchaseReturn, Long> {

	PurchaseReturn save(PurchaseReturn pr);

	@Query(value = "SELECT distinct PIID, PINO FROM medc_purchase.medc_purchaseinvoice pi\r\n" + 
			"left join medc_purchase.medc_piproduct pip on pip.pirefid =pi.piid  where  pi.LocName=?1 and pi.LocRefID=?2 and pip.prflag != 1 ", nativeQuery = true)
	List viewPurcInvoicesNo(int lcrnm, int lcrid);

	@Query(value = " SELECT PIID, PINO, PIDate, VendorID , DistributorID, DistributorName, DShortName	 FROM medc_purchase.medc_purchaseinvoice pi  join medc_distributor.medc_distributorinformation ds	on pi.VendorID=ds.DistributorID    where    pi.PIID= ?3      and    pi.LocName=?1 and  pi.LocRefID=?2  ", nativeQuery = true)
	List viewPurcInvoice(int lcrnm, int lcrid, int name);

	// selva //Boopalan 220519
	@Query(value = "SELECT    cus.brandname ,pdt.DrugProductRefID ,drg.BatchNo, pdt.PurPrice ,pdt.totalproductprice , pdt.mrp     ,pdt.vat,pdt.sgst,pdt.cgst,pdt.igst     ,pdt.PIRefID  , IFNULL(pdt.TotalQuantity,0)  - IFNULL(pr.prtotqty,0)   as  crntpurcqty,ws.Qty  as crntstkqty,ws. BoxPerStrip ,ws. StripPerTablet     , pdt.PIProductID ,pdt.Discount,pdt.batchno as batch,pdt.gst,pdt.utgst,\r\n" + 
			"			ws.boxqty,ws.stripqty,ws.tabletqty,IFNULL(pdt.boxQuantity,0)  - IFNULL(pr.prboxqty,0)   as  crntboxqty,IFNULL(pdt.stripperbox,0)  - IFNULL(pr.prboxper,0)   as  crntboxper,IFNULL(pdt.quantityperstrip,0)  - IFNULL(pr.prstripper,0)   as  crntstripper,ws.packageunit\r\n" + 
			"      FROM medc_purchase.medc_piproduct  pdt\r\n" + 
			"			inner join medc_productmaster.medc_custproductmaster cus on cus.productdrugid = pdt.DrugProductRefID\r\n" + 
			"			inner join medc_stock.medc_drugbatch drg on drg.batchid=pdt.BatchNo\r\n" + 
			"			left join (SELECT  DrugproductId,BatchRefId,pirefid ,IFNULL(sum(TotalQuantity),0) as prtotqty ,IFNULL(sum(boxQuantity),0) as prboxqty,IFNULL(sum(stripconvstk),0) as prstripper,IFNULL(sum(boxconvstk),0) as prboxper,piprodrefid  FROM  medc_purchasereturn.medc_prproduct  where  LocName=?1 and  LocRefID=?2     group by piprodrefid )  pr   on    pdt.PIProductID=pr.piprodrefid\r\n" + 
			"			left join (SELECT  DrugProductID,Batchno ,Qty,brandname,BoxPerStrip,StripPerTablet,boxqty,stripqty,tabletqty,packageunit FROM  medc_stock.medc_mainstock where  LocName=?1 and  LocRefID=?2  ) ws  on  ws.DrugProductID=pdt.DrugProductRefID   and ws.Batchno=pdt.BatchNo\r\n" + 
			"			where pdt.PiRefID=?3 group by pdt.PIProductID", nativeQuery = true)
	List viewPiProduct(int lcrnm, int lcrid, int name);

	@Query(value = "SELECT IFNULL(MAX(PRID),0) FROM medc_purchasereturn.medc_dirpurchasereturn       where  LocName=?1 and LocRefID=?2 ", nativeQuery = true)
	int viewPrId(Double lcrnm, Double lcrid);

	@Query(value = " SELECT  IFNULL(RIGHT(prno, 7),0)  FROM   medc_purchasereturn.medc_dirpurchasereturn   where  PRID=?3    and    LocName=?1 and LocRefID=?2  ", nativeQuery = true)
	String viewPrIncNo(Double lcrnm, Double lcrid, int id);

	@Query(value = "SELECT pr.prno from medc_purchasereturn.medc_dirpurchasereturn  pr  join ( SELECT   max( PRID ) as maxid FROM   medc_purchasereturn.medc_dirpurchasereturn  where   LocName=?1 and LocRefID=?2  )  prid  on  prid.maxid=pr.PRID  ", nativeQuery = true)
	String viewPrIncMaxNo(Double lcrnm, Double lcrid);

	@Query(value = "SELECT PRID, PRNo,invoiceno,date(prdate),totalitems,totalqty  FROM medc_purchasereturn.medc_dirpurchasereturn         where  LocName=?1 and LocRefID=?2  and   Status!=5  order by  PRID desc ", nativeQuery = true)
	List viewPurchReturnNo(int lcrnm, int lcrid);

	// Boopalan 060519
	@Query(value = "SELECT   ds.DistributorName, pr. PRID,pr. PRNo ,pr. InvoiceNo ,pr. VendorID,pr.totalitems ,pr.totaltaxableamt, pr.totaltaxamt,pr. grandtotal,date(pr.clientcdate),pr.totalsubtotal,pr.roundedoff,totaldiscountamt,date(pr.prdate),coalesce(pr.cashdiscount,0),coalesce(pr.cashdiscountpercent,0) 	FROM medc_purchasereturn.medc_dirpurchasereturn pr 	inner join medc_distributor.medc_distributorinformation ds 	on pr.VendorID=ds.DistributorID    where     pr.PRID=?3    and    pr.LocName=?1 and  pr.LocRefID=?2  order by pr. PRID desc ", nativeQuery = true)
	List viewPurchaseReturn(int lcrnm, int lcrid, int name);

	 // Boopalan (300419),RO (130519)
	@Query(value = "SELECT  cpm.BrandName, pr.PRProductID,pr. PRRefID,pr. drugproductid      ,drb.batchno, pr. UnitPrice ,pr. PurcPRice,pr. MRP, pr. BoxQuantity,pr.StripQuantity ,pr. TabletQuantity,pr. TotalQuantity,pr.unitvat,pr.unitsgst,pr. unitcgst,pr.unitigst,pr. VATAmt  ,pr. SGSTAmt,pr. CGSTAmt,pr. IGSTAmt ,    pr.subtotal, pr.pirefid  , pr.piqty,  IFNULL(pi.TotalQuantity,0) -  IFNULL(pr2.totqty,0) + IFNULL(pr.TotalQuantity,0)   as    crntpiqty ,  ws.Qty+pr.TotalQuantity  as 'crntstkqty',pr.gstflag,pr. boxconvstk,pr.stripconvstk,pr.clientcdate1 , pr.piprodrefid,pr.discount,pr.unitutgst,pr.utgstamt,prp.prno,dist.distributorname,pr.batchrefid,pr.unitgst,pr.gstamt,\r\n" + 
			"ws. BoxPerStrip ,ws. StripPerTablet,ws.boxqty,ws.stripqty,ws.tabletqty,ws.packageunit\r\n" + 
			" FROM medc_purchasereturn.medc_prproduct pr\r\n" + 
			"  inner join medc_purchasereturn.medc_dirpurchasereturn prp on prp.prid=pr.prrefid\r\n" + 
			"  inner join medc_stock.medc_drugbatch drb on drb.batchid=pr.batchrefid\r\n" + 
			"  left join medc_distributor.medc_distributorinformation dist on dist.distributorid=prp.vendorid\r\n" + 
			"  inner join medc_productmaster.medc_custproductmaster cpm on cpm.productdrugid = pr.drugproductid\r\n" + 
			"  left join (SELECT DrugProductRefID,BatchNo,PIRefID,TotalQuantity,PIProductID  from  medc_purchase.medc_piproduct where  LocName=?1 and  LocRefID=?2 )  pi on   pr.piprodrefid= pi.PIProductID\r\n" + 
			"  left join (SELECT DrugproductId ,BatchRefId ,pirefid,sum(TotalQuantity)  as totqty,piprodrefid from  medc_purchasereturn.medc_prproduct  where  LocName=?1 and  LocRefID=?2 group  by piprodrefid )  pr2 on   pr.piprodrefid=pr2.piprodrefid\r\n" + 
			"  left join medc_stock.medc_mainstock  ws on  pr.DrugproductId=ws.DrugProductID  and pr.BatchRefId=ws.Batchno\r\n" + 
			"  where  pr.prrefid =?3 group by  pr.PRProductID", nativeQuery = true)
	List viewPrProduct(int lcrnm, int lcrid, int name);

	// selva

	@Query(value = " SELECT    ws.brandname ,pdt.DrugProductRefID ,pdt.BatchNo,       pdt.UnitPrice,pdt.totalproductprice, pdt.mrp     ,pdt.vat,pdt.sgst,pdt.cgst,pdt.igst      ,pdt.PIRefID , IFNULL(pdt.TotalQuantity,0)  - IFNULL(pr.prtotqty,0)   as  crntpurcqty,ws.Qty  as crntstkqty, pdt. Stripperbox ,pdt. Quantityperstrip    , pdt.PIProductID    FROM  medc_purchase.medc_piproduct  pdt   left join (SELECT  DrugproductId,BatchRefId,pirefid ,IFNULL(sum(TotalQuantity),0) as  prtotqty ,piprodrefid  FROM  medc_purchasereturn.medc_prproduct   where  LocName=?1 and  LocRefID=?2  group by  piprodrefid  )   pr   on    pdt.PIProductID=pr.piprodrefid    left join  (SELECT  DrugProductID,Batchno ,Qty,brandname FROM  medc_stock.medc_mainstock   where  LocName=?1 and  LocRefID=?2  ) ws  on  pdt.DrugProductRefID=ws.DrugProductID  and  pdt.BatchNo=ws.Batchno    where   pdt.PiRefID=?3    group by    pdt.PIProductID  ", nativeQuery = true)
	List viewPrProductRemain(Integer lcrnm, Integer lcrid, Integer name);

	@Query(value = "SELECT  DistributorName   FROM medc_distributor.medc_distributorinformation   where  DistributorID=?1 ", nativeQuery = true)
	String viewDistName(Integer id);

	@Modifying
	@Transactional
	@Query(value = "update   medc_purchasereturn.medc_dirpurchasereturn   set   Status=5   where   PRID=?3   and LocName=?1 and LocRefID=?2  ", nativeQuery = true)
	int deletePurchReturn(Integer lcrnm, Integer lcrid, Integer id);

	/*** Purchase Return Save VendorID ***/ // Boopalan 020519
	@Query(value = " SELECT  db.DistributorID,db.DistributorName,db.country,db.state,db.city,pi.cashdiscount,pi.cashdiscountpercent   FROM (medc_distributor.medc_distributorinformation db, medc_purchase.medc_purchaseinvoice pi)   where  db.DistributorID=pi.vendorid and pi.piid = :id ", nativeQuery = true)
	public List saveVendoridPurchReturn(@Param("id") Integer id);

}
