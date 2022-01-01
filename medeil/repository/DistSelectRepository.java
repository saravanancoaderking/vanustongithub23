

























package com.medeil.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.medeil.domain.DistributorSelect;

@Repository
public interface DistSelectRepository extends JpaRepository<DistributorSelect, Long> {

	DistributorSelect save( DistributorSelect stk  );

	@Query( value = " SELECT      IFNULL(  max( DistSlctProId  ) ,0  )   FROM     medc_purchase.medc_distselect   where  LocRefID=?2  and  LocName=?1    ", nativeQuery = true  )
	Double viewDistSelectId(  Double lcrnm ,Double lcrid   );
	
	@Query( value = " SELECT      IFNULL(  max( DistSlctId  ) ,0  )   FROM     medc_purchase.medc_distselect   where  LocRefID=?2  and  LocName=?1    ", nativeQuery = true  )
	Double viewDistSelectIdNU(  Double lcrnm ,Double lcrid   );

	@Query( value = "  SELECT  IFNULL( RIGHT( DistSlctNo, 7  ),0  )   FROM      medc_purchase.medc_distselect   where   DistSlctProId=?3   and    LocName=?1 and LocRefID=?2 ", nativeQuery = true  )
	String viewDistSelectIncNo(  Double lcrnm ,Double lcrid  ,  Double id );

	@Query( value = "  SELECT  PrcEncId ,PrcEncNo FROM medc_purchase.medc_priceenquiry  where LocName=?1 and LocRefID=?2   and  DistSelFlag=0  group by   PrcEncId  order by PrcEncId desc ", nativeQuery = true  )
	List viewPriceEnquiryNo(  int lcrnm ,int lcrid ) ;
	@Query( value = "  SELECT  DistSlctId ,DistSlctNo FROM medc_purchase.medc_distselect  where LocName=?1 and LocRefID=?2  and PoFlag=0  group by   DistSlctId   ", nativeQuery = true  )
	List viewDistSelectNo(   int lcrnm ,int lcrid   );

	@Query( value = "SELECT    cust.ProductDrugID , ds.DistributorID , peq.PrcEncId ,ds. DistributorName  ,concat(cust.BrandName,'',cust.GenericNameDosage,'',fr.FormulationName) productname       ,0 ,peq.CreditDays,peq.LeadTime ,peq.ProdWaitingQty, peq.PriceUpdateFlag      ,peq.exppoqty, peq.exppoprice,peq.DistFinalPrice,peq.distremarks,peq.PurchSessionId ,date(peq.clientmdate)  FROM (medc_purchase.medc_priceenquiry  peq,medc_productmaster.medc_formulation fr) left join  (  SELECT DistributorID,DistributorName FROM medc_distributor.medc_distributorinformation  where locrefid=?2  and  LocName=?1  )  ds    on   ds.DistributorID =peq.Vendorid left join  ( SELECT BrandName,ProductDrugID,GenericNameDosage, FormulationID   from  medc_productmaster.medc_custproductmaster  where   companyID=?4 )  cust     on   cust.ProductDrugID =peq.DrugProductrefId   where cust.FormulationID=fr.FormulationID and  peq.PrcEncId= ?3    and    peq.LocName=?1 and peq.LocRefID=?2  ", nativeQuery = true  )
	List viewPriceEnquiry(  int lcrnm ,int lcrid  ,  int pid ,Integer  compid  );

	@Query( value = "    SELECT  dst. DistSlctId ,dst.DistSlctNo,DATE(dst. ClientCDate1  ) , count(*) as  distselprod ,penq.PrcEncNo    ,dst.PoFlag  FROM    medc_purchase.medc_distselect  dst left join  (  SELECT  PrcEncNo,PrcEncId  FROM medc_purchase.medc_priceenquiry   where locrefid=?2  and  LocName=?1  )  penq    on   dst.PrcEnqRefId =penq.PrcEncId     where dst.LocName=?1 and dst.LocRefID=?2   and dst.Status!=5  group  by dst.DistSlctId	order by dst. DistSlctId  ", nativeQuery = true  )
	List viewDistSelectAll(   int lcrnm ,int lcrid   );
	
	
	
	@Query( value = " SELECT  dst. DistSlctId ,dst.DistSlctNo,DATE(dst. ClientCDate1  ) ,ds.DistributorName,cust.BrandName        , dst.exppoqty,dst. exppoprice ,dst.DistFinalPrice ,dst.CreditDays,dst. LeadTime  FROM    medc_purchase.medc_distselect  dst left join  (  SELECT DistributorID,DistributorName FROM medc_distributor.medc_distributorinformation  where locrefid=?2  and  LocName=?1  )  ds    on   ds.DistributorID =dst.Vendorid  left join  ( SELECT BrandName,ProductDrugID   from  medc_productmaster.medc_custproductmaster  where  companyID=?3 )  cust     on   cust.ProductDrugID =dst.DrugProductrefId  where dst.LocName=?1 and dst.LocRefID=?2   and Status!=5  and VendorSlctFlag=1   ", nativeQuery = true  )
	List viewDistSelectNewAll(   int lcrnm ,int lcrid   ,Integer  compid);
	


	@Query( value = " SELECT  cust.BrandName ,ds. DistributorName , dst. distslctno,poflag,dst. distslctproid,          dst. distslctid,  dst. prcenqrefid,  dst. drugproductrefid, dst. batchrefid,dst. prodwaitingqty,       dst. distpreprice,  dst. distfinalprice,  dst. vendorid,  dst. vendorslctflag,dst. distslctno   as  distno        , dst.ClientCDate1  as cldate ,dst.poflag as   orderflag, 0 ,dst.CreditDays,dst.LeadTime      ,dst.exppoqty,dst.exppoprice ,dst.previouspoprice,dst.distremarks    FROM   medc_purchase.medc_distselect  dst   left join  (  SELECT DistributorID,DistributorName FROM medc_distributor.medc_distributorinformation  where locrefid=?2  and  LocName=?1  )  ds    on   ds.DistributorID =dst.Vendorid    left join ( SELECT BrandName,ProductDrugID   from  medc_productmaster.medc_custproductmaster  where     companyID=?4 )  cust     on   cust.ProductDrugID =dst.DrugProductrefId  where   dst.DistSlctId= ?3   and  dst.LocName=?1 and  dst.LocRefID=?2 and dst.VendorSlctFlag=1", nativeQuery = true  )
	List viewDistSelect(   int lcrnm ,int lcrid  , int dst  ,Integer  compid  );
	
	
	
	@Modifying
	@Transactional
	@Query( value = " update  medc_purchase.medc_priceenquiry   set  DistSelFlag=1  where   PrcEncId=?3  and LocName=?1 and LocRefID=?2  ", nativeQuery = true  )
	void updatePriceEnquiry(  Double lcrnm ,Double lcrid  ,  Double  id );

	

}




