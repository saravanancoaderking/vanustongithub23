
package com.medeil.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.medeil.domain.DistributortProd;

@Repository
public interface DistProdRepository extends JpaRepository<DistributortProd, Integer> {

	// Boopalan 270619
	@Query(value = "SELECT DistributorID,DistributorName  FROM medc_distributor.medc_distributorinformation     where  companyrefid = ?1  ", nativeQuery = true)
	List viewDistributors(int companyrefid);

	@Query(value = "select ProductDrugID, concat(BrandName,' ',ifnull(genericnamedosage,'1mg')) from medc_productmaster.medc_custproductmaster  where  BrandName like  ?3%   and     ((LocName=?1 and  LocRefID=?2) || (companyID=?4))  ORDER BY BrandName LIMIT 10", nativeQuery = true)
	List viewCustProducts(int lcrnm, int lcrid, String name, Integer compid);

	@Query(value = " select cust.ProductDrugID ,concat(cust.BrandName,' ',ifnull(cust.genericnamedosage,'1mg'),' ',ifnull(fu.formulationname,'tab')) as BrandName ,cust.Quantity,MRP ,  dp.DrugPrdID   FROM   medc_productmaster.medc_custproductmaster cust  inner join medc_productmaster.medc_formulation fu on fu.formulationid=cust.formulationid  left join   ( SELECT DrugPrdID FROM medc_distributor.medc_distproduct    where  DistRefID =?2   )   dp on   cust.ProductDrugID  = dp.DrugPrdID  where  ProductDrugID=?1  and  companyID=?3  ", nativeQuery = true)
	List viewCustProduct(int pr, int dist, Integer compid);

	@Query(value = " SELECT  IFNULL( MAX( DistprdID ),0 )   FROM   medc_distributor.medc_distproduct     where  LocName=?1 and LocRefID=?2  ", nativeQuery = true)
	Double viewDistProductId(Double lcrnm, Double lcrid);

	@Query(value = " SELECT  IFNULL( MAX( DistprdLocID ),0 )   FROM   medc_distributor.medc_distproduct     where  LocName=?1 and LocRefID=?2  ", nativeQuery = true)
	Double viewDistProductIdNU(Double lcrnm, Double lcrid);

	@Query(value = " SELECT  IFNULL( RIGHT( DistprodNo, 7 ),0 )   FROM   medc_distributor.medc_distproduct   where  DistprdID=?3  and     LocName=?1 and LocRefID=?2  ", nativeQuery = true)
	String viewDistProductIncNo(Double lcrnm, Double lcrid, Double id);

	/*
	 * // Boopalan 020519
	 * 
	 * @Query( value =
	 * " SELECT dp.DistprdID,dp.DistRefID,dp.DrugPrdID,dp.MasterPrice,      dp.DistPrice,cst.BrandName ,dist.DistributorName,dp.DistprodNo   FROM medc_distributor.medc_distproduct dp   left join ( SELECT  ProductDrugID ,BrandName  from medc_productmaster.medc_custproductmaster  where ((LocName=?1 and  LocRefID=?2) || (companyID=?4))  ) cst on  cst.ProductDrugID=dp.DrugPrdID     left join (  SELECT DistributorID,DistributorName FROM medc_distributor.medc_distributorinformation  where locrefid=?2  and  LocName=?1 ) dist  on dp.DistRefID=dist.DistributorID    where  dp.DistRefID=?3   and     dp. LocName=?1 and dp.LocRefID=?2  "
	 * , nativeQuery = true ) List viewDistProdWhole( int lcrnm, int lcrid ,int name
	 * ,Integer compid );
	 */

	// Boopalan 020519
	@Query(value = " SELECT dp.DistprdID,dp.DistRefID,dp.DrugPrdID,dp.MasterPrice,dp.DistPrice,concat(cst.BrandName,'',ifnull(cst.genericnamedosage,'1mg'),'',ifnull(fo.formulationname,'Tablet'))  as prodname  ,dist.DistributorName,dp.DistprodNo,dp.remarks,phm.pcompanyname FROM medc_distributor.medc_distproduct dp   left join ( SELECT  ProductDrugID ,BrandName,genericnamedosage, formulationid, pharmacompanyid  from medc_productmaster.medc_custproductmaster  where companyID=?1  ) cst on  cst.ProductDrugID=dp.DrugPrdID   inner join medc_productmaster.medc_formulation fo on fo.formulationid=cst.formulationid      left join (  SELECT DistributorID,DistributorName FROM medc_distributor.medc_distributorinformation  where companyrefid=?1 ) dist  on dp.DistRefID=dist.DistributorID left join medc_pharmacompany.medc_pharmacompanies phm on phm.pcompanyid=cst.pharmacompanyid  where  dp.DistRefID=?2   and     dp.companyRefID=?1  ", nativeQuery = true)
	List viewDistProdWhole(Integer compid, Integer distid);

	@Query(value = "    SELECT DistprdLocID, DistprodNo ,DATE( ClientCDate1 )  FROM medc_distributor.medc_distproduct  dp where  LocName=?1 and LocRefID=?2  and Status!=5 group  by   DistprdLocID   order by  DistprdLocID desc;  ", nativeQuery = true)
	List viewDistProdAll(int lcrnm, int lcrid);

	@Query(value = " SELECT dp.DistprodNo as DistprodNonew ,DATE( dp.ClientCDate1 ) ,dp.DistprdID,dp.DistRefID,dp.DrugPrdID,            dp.MasterPrice,dp.DistPrice,cst.BrandName ,dist.DistributorName,dp.ProdDelFlag      ,dp.ClientCDate1  as cldate ,dp.creditdays,dp.leadtime ,dp.distprdlocid   FROM medc_distributor.medc_distproduct dp   left join ( SELECT  ProductDrugID ,BrandName  from medc_productmaster.medc_custproductmaster  where ((LocName=?1 and  LocRefID=?2) || (companyID=?4)) ) cst on  cst.ProductDrugID=dp.DrugPrdID     left join (  SELECT DistributorID,DistributorName FROM medc_distributor.medc_distributorinformation  where locrefid=?2  and  LocName=?1 ) dist  on dp.DistRefID=dist.DistributorID    where  dp.distprdlocid=?3   and dp.LocRefID=?2 and   dp. LocName=?1 ", nativeQuery = true)
	List viewDistProd(int lcrnm, int lcrid, int dst, Integer compid);

	@Query(value = "  SELECT   PCompanyID,PCompanyName   FROM medc_pharmacompany.medc_pharmacompanies     where  LocName=?1 and LocRefID=?2 and    Status!=5  ", nativeQuery = true)
	List viewPhCompanies(int lcrnm, int lcrid);

	@Query(value = "select ProductDrugID ,BrandName ,Quantity,MRP   FROM   medc_productmaster.medc_custproductmaster  where  PharmaCompanyID=?3  and     ((LocName=?1 and  LocRefID=?2) || (companyID=?4))     limit 700  ", nativeQuery = true)
	List viewProductPhComp(int lcrnm, int lcrid, int i, Integer compid);

	@Query(value = " SELECT count(*) FROM medc_distributor.medc_distproduct   where  distrefid=?1  and drugprdid=?2  ", nativeQuery = true)
	Integer checkDistProd(Double dist, int drg);

	@Modifying
	@Transactional
	@Query(value = " update  medc_distributor.medc_distproduct   set ProdDelFlag=?4  where   DistprdID=?3  and    LocName=?1 and LocRefID=?2  ", nativeQuery = true)
	void updateDistProdDelFlag(Double lcrnm, Double lcrid, int id, Boolean id1);

	@Modifying
	@Transactional
	@Query(value = "update   medc_distributor.medc_distproduct  set   Status=5  where  DistprdID=?3 and  LocName=?1 and LocRefID=?2  ", nativeQuery = true)
	int deleteDistProd(int lcrnm, int lcrid, int name);

}
