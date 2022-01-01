/**
 * 
 */
package com.medeil.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.medeil.domain.Prescdigiproduct;

/**
 * @author www
 *
 */


@SuppressWarnings("rawtypes")
@Repository
public interface PrescdigiproRepository  extends JpaRepository<Prescdigiproduct, Long> {
	
	

	

}
