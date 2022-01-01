package com.medeil.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.medeil.domain.Hsn_md;

@Repository
public interface HsnmdRepository extends JpaRepository<Hsn_md,Integer> {
	
//	Hsn_md save(List<Hsn_md> hsnmd);

//	boolean save(HsnBean hsnbean);
	
}
