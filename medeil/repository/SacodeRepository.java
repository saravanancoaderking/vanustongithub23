package com.medeil.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.medeil.domain.Sacode;

@Repository
public interface SacodeRepository extends JpaRepository<Sacode, Integer> {

	Sacode findBySaccode(Integer saccode);

	Sacode findBySacsubcode1(String sacsubcode1);


}
