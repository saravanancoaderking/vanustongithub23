package com.medeil.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.medeil.domain.StockIn;

@SuppressWarnings("rawtypes")
public interface StockInRepository extends CrudRepository<StockIn, Long>{

	
	@Query(value = "SELECT * FROM medc_globalsettings.medc_taxsgstmaster;", nativeQuery = true)
    List sgst();
	
	@Query(value = "SELECT * FROM medc_globalsettings.medc_taxcgstmaster;", nativeQuery = true)
    List cgst();
	
	@Query(value = "SELECT * FROM medc_globalsettings.medc_taxigstmaster;", nativeQuery = true)
    List igst();
	
	@Query(value = "SELECT * FROM medc_globalsettings.medc_taxutgstmaster;", nativeQuery = true)
    List utgst();
	
	@Query(value = "SELECT * FROM medc_globalsettings.medc_taxgstmaster;", nativeQuery = true)
    List gst();
	
	@Query(value = "SELECT * FROM medc_globalsettings.medc_taxvatmaster;", nativeQuery = true)
    List vat();
}
