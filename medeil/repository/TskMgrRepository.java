package com.medeil.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.medeil.domain.TaskManager;


@Repository
public interface TskMgrRepository    extends JpaRepository<TaskManager, Long>{

	
	TaskManager save(TaskManager   tm);
	
	
	@Query( value = " SELECT IFNULL(  max( StkExpAutID  ) ,0  )      FROM   medc_stock.medc_stockexpiry      where  LocName=?1 and LocRefID=?2  ", nativeQuery = true  )
	Integer viewTskMgrId(   Double lcrnm ,Double lcrid   );
	
	
	@Query( value = " SELECT IFNULL(  max( StkExpID  ) ,0  )      FROM   medc_stock.medc_stockexpiry      where  LocName=?1 and LocRefID=?2  ", nativeQuery = true  )
	Integer viewTskMgrIdNU(  Double lcrnm ,Double lcrid  );
	

	@Query( value = "  SELECT     IFNULL( RIGHT( stkexpno, 7  ),0  )    FROM    medc_stock.medc_stockexpiry  where  StkExpAutID=?3    and    LocName=?1 and LocRefID=?2 ", nativeQuery = true  )
	String viewTskMgrIncNo(  Double lcrnm ,Double lcrid  ,  Integer id  );
	
	
	@Query( value = "    SELECT StkExpID, StkExpNo ,DATE( ClientCDate1  ) FROM medc_stock.medc_stockexpiry   where  LocName=?1 and LocRefID=?2  and   Status!=5   group  by   StkExpID ;  ", nativeQuery = true  )
	List viewTskMgrAll(   int lcrnm ,int lcrid    );
	


	@Query( value = " SELECT  stp.StkExpNo , DATE( stp.ClientCDate1  ), cust.BrandName  , stp. stkexpautid, stp. stkexpid,     stp. drugproductid, stp. batchrefid,stp. expirydate, stp. actualstockqty ,stp. expboxqty        , stp.  expstripqty,stp.  exptabqty , stp. expstockqty, stp. stkexpno  , stp.  boxconvstk        , stp. stripconvstk   , stp.ClientCDate1  as  cldate   FROM   medc_stock.medc_stockexpiry  stp  	left join  ( SELECT BrandName,ProductDrugID   from  medc_productmaster.medc_custproductmaster  where  ((LocName=?1 and  LocRefID=?2) || (companyID=?4)) )  cust    on   cust.ProductDrugID =stp.drugproductid     where   stp.StkExpID= ?3    and    stp.LocName=?1 and  stp.LocRefID=?2  and  stp.Status!=5   ", nativeQuery = true  )
	List viewTskMgr(  int lcrnm ,int lcrid  ,  int  stk  ,Integer  compid  );
	
	
	@Query(value = "SELECT   EmployeeID,EmpFirstName     FROM  medc_employee.medc_employeedetails     where  LocName=?1 and LocRefID=?2   and Status!=5  ", nativeQuery = true)
	List viewEmployees(int lcrnm, int lcrid );
	
	
	
	
	
	@Modifying
	@Transactional
	@Query( value = "update   medc_stock.medc_stockexpiry   set   Status=5   where   StkExpID=?3  and   LocName=?1 and LocRefID=?2  ", nativeQuery = true  )
	int deleteTskMgr(   int lcrnm ,int lcrid  , int id );
	
	
	
	
	
}
