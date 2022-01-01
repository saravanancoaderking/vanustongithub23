/**
 * 
 */
package com.medeil.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.medeil.domain.TaxIgst;

/**
 * @author Vanuston
 *
 */
@SuppressWarnings("rawtypes")
@Repository
public interface TaxigstRepository extends JpaRepository<TaxIgst, Long> {

}
