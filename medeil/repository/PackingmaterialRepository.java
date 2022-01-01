package com.medeil.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.medeil.domain.PackingMaterial;

public interface PackingmaterialRepository extends JpaRepository<PackingMaterial, Long> {

}
