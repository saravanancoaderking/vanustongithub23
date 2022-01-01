package com.medeil.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.medeil.domain.HoldSalesInvoiceProducts;
import com.medeil.domain.Holdsalesinvoice;

@SuppressWarnings("rawtypes")
@Repository
public interface HoldSalesProductsRepository  extends JpaRepository<HoldSalesInvoiceProducts, Long> {
	
	List<HoldSalesInvoiceProducts> findBySalesrefid(int id);

}
