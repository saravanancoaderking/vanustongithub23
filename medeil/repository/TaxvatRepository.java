/**
 * 
 */
package com.medeil.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.medeil.domain.TaxVat;

/**
 * @author Vanuston
 *
 */

@SuppressWarnings("rawtypes")
@Repository
public interface TaxvatRepository extends JpaRepository<TaxVat,Long	> {

}
