package com.medeil.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.medeil.domain.VanustonVerticals;

@Repository
public interface VanustonVerticalsRepository extends JpaRepository<VanustonVerticals, Integer> {

}
