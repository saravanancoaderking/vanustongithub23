/**
 * 
 */
package com.medeil.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.medeil.domain.Journal;

/**
 * @author www
 *
 */
@SuppressWarnings("rawtypes")
@Repository
public interface PurcjournalRepo extends JpaRepository<Journal, Long>, PurcRepository {

}
