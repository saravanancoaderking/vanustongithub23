/**
 * 
 */
package com.medeil.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.medeil.domain.TaxUtgst;

/**
 * @author Vanuston
 *
 */
@SuppressWarnings("rawtypes")
@Repository
public interface TaxutgstRepository extends JpaRepository<TaxUtgst, Long> {

}
