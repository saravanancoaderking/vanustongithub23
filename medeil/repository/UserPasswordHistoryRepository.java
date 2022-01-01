package com.medeil.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.medeil.domain.UserPasswordHistory;

@SuppressWarnings("rawtypes")
@Repository

public interface UserPasswordHistoryRepository extends JpaRepository<UserPasswordHistory, Long> {

	boolean existsByPatronAndHist(int patron, String hist);

}
