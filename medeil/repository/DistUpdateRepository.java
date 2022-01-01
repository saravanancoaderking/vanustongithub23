package com.medeil.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.medeil.domain.DistributorSelect;

public interface DistUpdateRepository extends JpaRepository<DistributorSelect, Long> {
	
	DistributorSelect save( DistributorSelect stk  );
	
	@Query( value = " SELECT peq.PrcEncProId,peq.DrugProductrefId,peq.creditdays,peq.leadtime,peq.exppoqty   ,peq.exppoprice ,concat(cust.BrandName,'',cust.GenericNameDosage,'',fr.FormulationName) productname ,peq.PrcEncNo,date(peq.clientcdate)    FROM (medc_purchase.medc_priceenquiry peq,medc_productmaster.medc_formulation fr)  left join  ( SELECT BrandName,ProductDrugID,GenericNameDosage,FormulationID   from  medc_productmaster.medc_custproductmaster  where    companyID=?4 )  cust   on   cust.ProductDrugID =peq.DrugProductrefId    where  peq.PriceUpdateFlag=0   and peq.DistSelFlag=0  and peq.Vendorid=?3 and  peq.LocName=?1 and  peq.LocRefID=?2 and cust.FormulationID=fr.FormulationID", nativeQuery = true  )
	List viewPriceEnquiry(  int lcrnm ,int lcrid  ,  int  vid ,Integer  compid  );
	
	
	
	@Modifying
	@Transactional
	@Query( value = " update  medc_purchase.medc_priceenquiry   set  PriceUpdateFlag=1  , DistFinalPrice=?4, distremarks=?5 ,clientmdate=?6 where   PrcEncProId=?3  and LocName=?1 and LocRefID=?2  ", nativeQuery = true  )
	void updatePriceEnquiry(  Double lcrnm ,Double lcrid  ,  Integer  prcid ,Double  price ,String   remarks,String clientmdate);
	
	

}
