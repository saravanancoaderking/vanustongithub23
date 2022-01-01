package com.medeil.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.medeil.domain.TwilioAccount;

public interface TwilioAccountRepository extends JpaRepository<TwilioAccount, Long> {

}
