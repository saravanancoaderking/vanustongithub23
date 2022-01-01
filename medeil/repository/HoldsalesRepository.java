package com.medeil.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.medeil.domain.Appointment;
import com.medeil.domain.HoldSalesInvoiceProducts;
import com.medeil.domain.Holdsalesinvoice;
import com.medeil.domain.SalesDummy;

@SuppressWarnings("rawtypes")
@Repository
//public class HoldsalesRepository {
public interface HoldsalesRepository extends JpaRepository<Holdsalesinvoice, Long>{

	@Query(value = "SELECT ifnull(max(holdbillid),0) as id FROM medc_sales.medc_holdsalesbill ", nativeQuery = true)
	Integer getlastid();
	
	@Query(value = "SELECT holdbillid, salesbillno FROM medc_sales.medc_holdsalesbill\r\n" + 
			"where companyrefid=:cid and branchrefid=:bid and LocName=:locname and LocRefID=:locrefid", nativeQuery = true)
	List viewholdbillslist(@Param("cid") int cid,@Param("bid") int bid,@Param("locname") int locname,@Param("locrefid") int locrefid);

	Holdsalesinvoice findById(int id);
}
