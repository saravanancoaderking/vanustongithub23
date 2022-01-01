package com.medeil.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.medeil.domain.PickList;


@Repository
public interface PickListRepository   extends JpaRepository<PickList, Long>{

	
	PickList save(PickList  pck);
	
	
	
	@Query( value = " SELECT IFNULL(  max( PicklistAutoID  ) ,0  )      FROM   medc_stock.medc_wrhpicklist      where  LocName=?1 and LocRefID=?2  ", nativeQuery = true  )
	Integer viewPickListId(   Double lcrnm ,Double lcrid   );
	
	
	@Query( value = " SELECT IFNULL(  max( PicklistID  ) ,0  )      FROM   medc_stock.medc_wrhpicklist      where  LocName=?1 and LocRefID=?2  ", nativeQuery = true  )
	Integer viewPickListIdNU(  Double lcrnm ,Double lcrid  );
	

	@Query( value = "  SELECT     IFNULL( RIGHT( picklistno, 7  ),0  )    FROM    medc_stock.medc_wrhpicklist  where  PicklistAutoID=?3    and    LocName=?1 and LocRefID=?2 ", nativeQuery = true  )
	String viewPickListIncNo(  Double lcrnm ,Double lcrid  ,  Integer id  );
	
	
	@Query( value = "    SELECT PicklistID, picklistno ,DATE( ClientCDate1  ) FROM medc_stock.medc_wrhpicklist   where  LocName=?1 and LocRefID=?2  and   Status!=5   group  by   PicklistID ;  ", nativeQuery = true  )
	List viewPickListAll(   int lcrnm ,int lcrid    );
	


	@Query( value = "SELECT cust. brandname, pk.picklistautoid,pk. picklistid,pk. picklistno,pk. putawayrefid,pk. drugproductrefid,pk. batchrefid ,pk.availqty,pk. boxqty,pk. stripqty,pk. tabqty ,pk. Qty  ,pk. boxconvstk,pk. stripconvstk,pk. blockno,pk. rackno,pk. clientcdate1  FROM   medc_stock.medc_wrhpicklist   pk  	left join  ( SELECT BrandName,ProductDrugID   from  medc_productmaster.medc_custproductmaster  where  ((LocName=?1 and  LocRefID=?2) || (companyID=?4)) )  cust    on   cust.ProductDrugID =pk.drugproductrefid     where  pk. picklistid= ?3    and    pk.LocName=?1 and  pk.LocRefID=?2  and  pk.Status!=5    ", nativeQuery = true  )
	List viewPickList(  int lcrnm ,int lcrid  ,  int  stk  ,Integer  compid  );
	
	
	
	
	@Query(value = "   SELECT   DrugProductRefID  ,brandname, BatchRefID,PutawayAutoID   FROM medc_stock.medc_wrhputaway   where  BrandName like  ?3%  and   LocName=?1 and  LocRefID=?2   and   qty<1   group  by   DrugProductRefID   ORDER BY BrandName LIMIT 10", nativeQuery = true)
	List viewCustProducts(int lcrnm, int lcrid,String name  );

	@Query(value = " SELECT brandname ,DrugProductRefID, BatchRefID ,boxqty,stripqty,tabqty,qty ,PutawayAutoID   FROM medc_stock.medc_wrhputaway  where   LocName=?1 and  LocRefID=?2   and   PutawayAutoID=?3 ", nativeQuery = true)
	List viewCustProduct(int lcrnm, int lcrid,int pt );
	
	
	@Query(value = "SELECT   EmployeeID,EmpFirstName     FROM  medc_employee.medc_employeedetails     where  LocName=?1 and LocRefID=?2   and Status!=5  ", nativeQuery = true)
	List viewEmployees(int lcrnm, int lcrid );
	

	@Query( value = "  SELECT PatientID, PatientFirstName  FROM medc_patientreg.medc_patientbasicinfo      where  LocName=?1 and LocRefID=?2  and   Status!=5 ", nativeQuery = true )
	List viewCustomers(  int lcrnm, int lcrid  );
	
	
	
	
	
	
	
	
	
	@Modifying
	@Transactional
	@Query( value = "update   medc_stock.medc_stockexpiry   set   Status=5   where   StkExpID=?3  and   LocName=?1 and LocRefID=?2  ", nativeQuery = true  )
	int deletePickList(   int lcrnm ,int lcrid  , int id );
	
	
}
