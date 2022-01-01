package com.medeil.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.medeil.domain.EnableOrDisableSms;

public interface EnableOrDisableSmsRepository extends JpaRepository<EnableOrDisableSms, Long> {
	
	@Query(value = "SELECT s.status FROM medc_sms.sms_enable_disable s where  s.companyid =?1 and s.formid =1", nativeQuery = true)
	List getEnableStatusSalesOrder(int companyrefid);

	@Query(value = "SELECT s.status FROM medc_sms.sms_enable_disable s where  s.companyid =?1 and s.formid =2", nativeQuery = true)
	List getEnableStatusSalesInvoice(int companyrefid);

	@Query(value = "SELECT s.status FROM medc_sms.sms_enable_disable s where  s.companyid =?1 and s.formid =3", nativeQuery = true)
	List getEnableStatusPurchaseOrder(int companyrefid);

	@Query(value = "SELECT s.status FROM medc_sms.sms_enable_disable s where  s.companyid =?1 and s.formid =4", nativeQuery = true)
	List getEnableStatusPurchaseInvoice(int companyrefid);

	@Query(value = "SELECT s.status FROM medc_sms.sms_enable_disable s where  s.companyid =?1 and s.formid =5", nativeQuery = true)
	List getEnableTwoFactorAuthentication(int companyrefid);

	@Query(value = "SELECT s.status FROM medc_sms.sms_enable_disable s where  s.companyid =?1 and s.formid =6", nativeQuery = true)
	List getEnableOTPVerification(int companyrefid);

	@Query(value = "SELECT s.statusid,s.formid,a.formname,s.status FROM medc_sms.sms_enable_disable s,medc_sms.sms_forms a where a.formid=s.formid and companyid =?1", nativeQuery = true)
	List viewEnableStatus(int companyrefid);
	
	@Query(value = "SELECT * FROM medc_sms.sms_forms", nativeQuery = true)
	List viewDefaultSMSForms();
}
