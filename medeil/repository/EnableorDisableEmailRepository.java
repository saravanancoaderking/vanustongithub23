package com.medeil.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.medeil.domain.EnableorDisableEmail;

public interface EnableorDisableEmailRepository extends JpaRepository<EnableorDisableEmail, Long> {
	
	@Query(value = "SELECT s.statusid,s.formid,a.formname,s.status FROM medc_email.email_enable_disable s,medc_sms.sms_forms a where a.formid=s.formid and companyid =?1", nativeQuery = true)
	List viewEmailEnableStatus(int companyrefid);
	
	@Query(value = "SELECT s.status FROM medc_email.email_enable_disable s where  s.companyid =?1 and s.formid =2", nativeQuery = true)
	List getEmailEnableStatusSalesInvoice(int companyrefid);

}
