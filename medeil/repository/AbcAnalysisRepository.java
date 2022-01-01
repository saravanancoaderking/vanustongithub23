package com.medeil.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.medeil.domain.Drug;

/**
 * 
 * @author Boopalan Alagesan
 * @Date 03-09-2019
 *
 */
@Repository
public interface AbcAnalysisRepository extends JpaRepository<Drug, Long> {

	@Query(value = "SELECT CompanyRefID, branchrefid, locname, locrefid FROM medc_abcanalysis.medc_shopslist where id =?1", nativeQuery = true)
	Integer[][] shopsiterator(int id);

	@Query(value = "SELECT count(id) FROM medc_abcanalysis.medc_shopslist", nativeQuery = true)
	int counts();

}
