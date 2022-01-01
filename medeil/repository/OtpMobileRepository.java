package com.medeil.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.medeil.domain.OtpMobile;

@SuppressWarnings("rawtypes")
@Repository

public interface OtpMobileRepository extends JpaRepository<OtpMobile, Long> {

	boolean existsByUsernameAndMobilenumberAndOtp(String username, String mobileno, int otp);

	OtpMobile findByUsernameAndMobilenumberAndOtp(String username, String mobileno, int otp);

	boolean existsByUsername(String username);

	List<OtpMobile> findByUsername(String username);

}
