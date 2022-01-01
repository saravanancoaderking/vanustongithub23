package com.medeil.repository;

import java.util.List;

/**
 * @author Mrs.Padmini
 * @author Boopalan Alagesan
 *
 */
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.medeil.domain.NewProduct;

@Repository
public interface NewProductRepository extends JpaRepository<NewProduct, Integer> {
	// NewProduct save(NewProduct si);

	// NewProductQty save(NewProductQty si);
	
//	boolean existsBynewproductnameAndCompanyrefidAndBranchrefidAndLocnameAndLocrefid(String newproductname,int companyid,int branchid,int locname,int locrefid);

	// padmini
	@Query(value = "select nproductid,newprodno from medc_stock.medc_newprodqty  where  companyrefid =?1  and branchrefid =?2 and locname =?3  and locrefid=?4    group by  newprodno", nativeQuery = true)
	List newprno(int compid, int branch, int lcrnm, int lcrid);

	
	// padmini
	@Query(value = "select newproductname,reqqty,remarks,nproductid,newprodno from medc_stock.medc_newprodqty  where  companyrefid =?1  and branchrefid =?2 and locname =?3  and locrefid=?4  and newprodno=?5", nativeQuery = true)
	List newprview(int cid, int bid, int locname, int locrefid, String newprodno);																										//padmini

	// padmini
	@Query(value = "select newprodno,newproductname,reqqty,remarks from medc_stock.medc_newprodqty  where  companyrefid =?1  and branchrefid =?2 and locname =?3  and locrefid=?4 order by newprodno desc ", nativeQuery = true)
	List viewStkNewQtyAll(int cid, int bid, int locname, int locrefid );
	

	// padmini
	@Query(value = "select newproductname,reqqty,remarks,nproductid,newprodno from medc_stock.medc_newprodqty  where  companyrefid =?1  and branchrefid =?2 and locname =?3  and locrefid=?4  and newprodno=?5", nativeQuery = true)
	List viewStk1NewQtyAll(int cid, int bid, int locname, int locrefid, String newprodno);	
	
	//padmini
	@Query(value = "SELECT newproductname  from medc_sales.medc_newproduct WHERE newproductname=:str and companyrefid=:compid and branchrefid=:brnchid and locname=:loc and locrefid=:locref", nativeQuery = true)
	String oneProduct(@Param("str") String str, @Param("compid") int compid, @Param("brnchid") int brnchid,
			@Param("loc") int loc, @Param("locref") int locref);


	boolean existsByBrandnameAndCompanyidAndBranchidAndLocnameAndLocrefid(String brandname, Integer companyid,
			Integer branchid, Integer locname, Integer locrefid);
}
