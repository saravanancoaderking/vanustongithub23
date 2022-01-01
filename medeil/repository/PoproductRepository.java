package com.medeil.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.medeil.domain.PoProduct;


@Repository
public interface PoproductRepository extends JpaRepository<PoProduct, Integer>{

	Optional<PoProduct> findByPorefidAndDrugproductrefid(Integer refpoid, Integer drugproductrefid);

}
