package com.medeil.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.medeil.domain.Shipping;
import com.medeil.domain.ShippingDetail;

@SuppressWarnings("rawtypes")
@Repository

public interface ShippingDetailRepository extends JpaRepository<ShippingDetail, Long>{

}
