package com.medeil.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.medeil.domain.Performaprd;

@SuppressWarnings("rawtypes")
@Repository

public interface Performaproductrepository  extends JpaRepository<Performaprd, Long>{

	@Query(value = "SELECT *  FROM medc_sales.medc_sales.medc_performproduct   where  CompanyRefID=?1  and  BranchRefID=?2 and LocName=?3  and LocRefID=?4",nativeQuery = true)
	List paitentProformaproductView(Integer cid, Integer bid, Integer lname, Integer lrid);

	@Query(value = "SELECT   max(  SalesBillID  )  FROM  medc_sales.medc_performinvoice ", nativeQuery = true)
	int viewSalesDummyId();
}
