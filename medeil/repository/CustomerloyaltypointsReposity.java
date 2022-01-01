package com.medeil.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.medeil.domain.Customerloyaltypoints;

@SuppressWarnings("rawtypes")
@Repository

public interface CustomerloyaltypointsReposity extends JpaRepository<Customerloyaltypoints, Long> {

	boolean existsByCustrefid(int intValue);

	Customerloyaltypoints findByCustrefid(int intValue);

}
