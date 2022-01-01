package com.medeil.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.medeil.domain.ProductMap;


public interface ProdMapRepository extends JpaRepository<ProductMap, Long> {
	
	
	ProductMap save(ProductMap pr);
	
	@Query(value = "select ProductDrugID, BrandName "
			+ "from medc_productmaster.medc_custproductmaster"
			+ " where  BrandName like  ?1%   and     LocName=?2 and LocRefID=?3  ORDER BY BrandName LIMIT 10", nativeQuery = true)
	List viewCustProducts(String name ,int lcrid ,int lcrnm);

	@Query(value = "select ProductDrugID ,BrandName ,Quantity,MRP "
			+ "  FROM   medc_productmaster.medc_custproductmaster "
			+ " where  ProductDrugID=?1  and     LocName=?2 and LocRefID=?3  ", nativeQuery = true)
	List viewCustProduct(int i,int lcrid ,int lcrnm);
	
	
	
	@Query(value = "select ProductDrugID1, BrandName1 "
			+ "from medc_productmaster.medc_custproductmaster1"
			+ " where  BrandName1 like  ?1%   and     LocName=?2 and LocRefID=?3  ORDER BY BrandName1 LIMIT 10", nativeQuery = true)
	List viewCustProducts1(String name ,int lcrid ,int lcrnm);

	@Query(value = "select ProductDrugID1 ,BrandName1 ,Quantity,MRP "
			+ "  FROM   medc_productmaster.medc_custproductmaster "
			+ " where  ProductDrugID1=?1  and     LocName=?2 and LocRefID=?3  ", nativeQuery = true)
	List viewCustProduct1(int i,int lcrid ,int lcrnm);
	
	
	
	
	@Query(value = " SELECT IFNULL( max(ProdMapAutoId) ,0)    FROM   medc_productmaster.medc_productmapping     where  LocName=?1 and LocRefID=?2  ", nativeQuery = true)
	Double viewProdMapId(Double lcrid, Double lcrnm);

	
	@Query(value = " SELECT IFNULL( max(ProdMapId) ,0)    FROM   medc_productmaster.medc_productmapping     where  LocName=?1 and LocRefID=?2  ", nativeQuery = true)
	Double viewProdMapIdNU(Double lcrid, Double lcrnm);
	
	
	@Query(value = "  SELECT     IFNULL(RIGHT(prodmapno, 7),0)    FROM    medc_productmaster.medc_productmapping   where  ProdMapAutoId=?1    and    LocName=?2 and LocRefID=?3 ", nativeQuery = true)
	String viewProdMapIncNo(Double id,  Double lcrid, Double lcrnm);
	
	
	
	
	@Query(value = "    SELECT  ProdMapId, prodmapno, DATE(ClientCDate1) FROM medc_productmaster.medc_productmapping   where  LocName=?1 and LocRefID=?2  and   Status!=5  group  by   ProdMapId ;  ", nativeQuery = true)
	List viewProdMapAll(int lcrid, int lcrnm);
	


	@Query(value = "  SELECT  pr.prodmapno as prodmapnonew ,DATE(pr.ClientCDate1), pr. prodmapautoid,pr.prodmapid,pr. productdrugid,pr. brandname ,pr. productdrugid1,pr. brandname1,pr. prodmapno ,pr. createdby , pr.ClientCDate1  as cldate  FROM medc_productmaster.medc_productmapping   pr  where  ProdMapId=?1 and  LocName=?2 and LocRefID=?3 ", nativeQuery = true)
	List viewProdMap(int  id, int lcrid, int lcrnm);
	
	
	
	@Query(value = "  SELECT  pr.prodmapno as prodmapnonew , pr.ClientCDate1, pr. prodmapautoid,pr.prodmapid,pr. productdrugid,pr. brandname ,pr. productdrugid1,pr. brandname1,pr. prodmapno ,pr. createdby,pr. locname,pr. locrefid   FROM medc_productmaster.medc_productmapping   pr  where  ProdMapId=?1 and  LocName=?2 and LocRefID=?3 ", nativeQuery = true)
	List   updateProductMaster(int  id, int lcrid, int lcrnm);
	
	

}