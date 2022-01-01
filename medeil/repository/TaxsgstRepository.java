/**
 * 
 */
package com.medeil.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.medeil.domain.TaxSgst;

/**
 * @author Vanuston
 *
 */
@SuppressWarnings("rawtypes")
@Repository
public interface TaxsgstRepository extends JpaRepository<TaxSgst,Long>{

}
