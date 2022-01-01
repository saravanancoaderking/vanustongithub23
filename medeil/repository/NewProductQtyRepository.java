package com.medeil.repository;

import java.util.List;

/**
 * @author Mrs.Padmini
 * @author Boopalan Alagesan
 *
 */
import javax.transaction.Transactional;

import org.springframework.data.repository.query.Param;
/**
 * @author Boopalan Alagesan
 * @author Mrs.Padmini
 *
 */
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.medeil.domain.NewProductQty;

@Repository
public interface NewProductQtyRepository extends JpaRepository<NewProductQty, Long> {

	@Modifying
	@Transactional
	@Query(value = "update medc_stock.medc_newprodqty m ,medc_sales.medc_newproduct n  set n.gridcolor = 1 , n.stockentryflag = 1 where  m.nprefid=n.productid and n.companyrefid =?1 and n.branchrefid=?2 and  n.locname=?3 and n.locrefid=?4 and n.productid =?5 ", nativeQuery = true)
	void gridColorNewProduct(int comp, int branch, int locname, int locrefid, int newproductid);

	@Modifying
	@Transactional
	@Query(value = "update medc_stock.medc_newprodqty  set updateflag = 1 where   companyrefid =?1 and branchrefid=?2 and  locname=?3 and locrefid=?4 and nproductid=?5 ;", nativeQuery = true)
	List updatenewproduct(int comp, int branch, int locname, int locrefid, int id);

	@Modifying
	@Transactional
	@Query(value = "delete from  medc_stock.medc_newprodqty   where   companyrefid = :comp and branchrefid= :branch and  locname= :locname and locrefid= :locrefid and newprodno= :newprodno", nativeQuery = true)
	void newprodelete(@Param("comp") int comp, @Param("branch") int branch, @Param("locname") int locname,
			@Param("locrefid") int locrefid, @Param("newprodno") String newprodno);


	@Query(value = "SELECT productid FROM medc_sales.medc_newproduct  where  newproductname= :newname and companyrefid= :comp and branchrefid= :branch and  locname= :locname and locrefid= :locref ", nativeQuery = true)
	Integer getnewproductrefid(@Param("newname") String newname, @Param("comp") int comp, @Param("branch") int branch,
			@Param("locname") int locname, @Param("locref") int locref);

}
