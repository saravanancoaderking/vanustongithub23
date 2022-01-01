package com.medeil.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.medeil.domain.Journal;
import com.medeil.domain.Journal1;

@Transactional
@Repository
public interface DebitRepository1  extends JpaRepository<Journal1, Long> {
	
	Journal1 save(Journal1 sj);

}
