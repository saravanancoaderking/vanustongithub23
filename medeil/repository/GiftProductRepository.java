package com.medeil.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.medeil.domain.Giftproduct;

@Repository
public interface GiftProductRepository extends JpaRepository<Giftproduct, Long> {



	boolean existsByCompanyrefidAndGiftproductname(Integer comid, String gproductname);

}
