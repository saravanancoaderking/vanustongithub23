/**
 * 
 */
package com.medeil.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.medeil.domain.Taxtype;
/**
 * @author Vanuston
 *
 */
@SuppressWarnings("rawtypes")
@Repository
public interface TaxtypeRepository extends JpaRepository<Taxtype, Long> {

}
