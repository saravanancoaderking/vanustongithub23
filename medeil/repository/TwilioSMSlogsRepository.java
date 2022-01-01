package com.medeil.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.medeil.domain.TwilioSMSlogs;

@Repository
public interface TwilioSMSlogsRepository extends JpaRepository<TwilioSMSlogs, Long> {

	@Query(value = "SELECT twlid, ACCOUNTSID, AUTHTOKEN, SenderNumber, companyrefid FROM medc_sms.sms_twilio where companyrefid=?1 and status=0", nativeQuery = true)
	List getSMSAccountDetails(Integer companyrefid);

	@Query(value = "SELECT t.smslogid, t.account_sid, t.body, date(t.clientcdate), t.direction, t.fromnumber, t.sid,\r\n"
			+ " t.status, t.tonumber,messagesegments,fms.formname FROM medc_sms.twlsms_logs t\r\n"
			+ "inner join medc_sms.sms_forms fms on fms.formid=t.formid\r\n"
			+ " where t.companyrefid =?1 order by t.smslogid desc ", nativeQuery = true)
	List viewSMSLogscompanywise(Integer companyrefid);
	
	@Query(value = "SELECT t.smslogid, t.account_sid, t.body, date(t.clientcdate), t.direction, t.fromnumber, t.sid,\r\n"
			+ " t.status, t.tonumber,messagesegments,fms.formname FROM medc_sms.twlsms_logs t\r\n"
			+ "inner join medc_sms.sms_forms fms on fms.formid=t.formid\r\n"
			+ " where t.companyrefid =?1 and t.branchrefid=?2 and t.locname=?3 and t.locrefid = ?4 order by t.smslogid desc ", nativeQuery = true)
	List viewSMSLogsshopwise(Integer companyrefid, Integer branchid, Integer locname, Integer locrefid);

	@Query(value = "SELECT fms.formname,count(t.smslogid) total,t.formid FROM medc_sms.twlsms_logs t\r\n"
			+ "left join medc_sms.sms_forms fms on fms.formid = t.formid where companyrefid =?1 group by t.formid", nativeQuery = true)
	List getSmsPieChartFormwise(int companyrefid);

	@Query(value = "SELECT t.smslogid, t.account_sid, t.body, date(t.clientcdate), t.direction, t.fromnumber, t.sid,\r\n"
			+ "t.status, t.tonumber,messagesegments,fms.formname FROM medc_sms.twlsms_logs t\r\n"
			+ "inner join medc_sms.sms_forms fms on fms.formid=t.formid\r\n"
			+ "where t.companyrefid =?1 and t.formid =?2 order by t.smslogid desc", nativeQuery = true)
	List getSmsLogsPieChartFormwise(int companyrefid, int formid);
	
	@Query(value = "SELECT  MONTHNAME(clientcdate) month,YEAR(clientcdate)year,sum(t.messagesegments)totalmessages FROM medc_sms.twlsms_logs t\r\n"
			+ "where t.companyrefid=?1 group by MONTH(clientcdate) order by YEAR(clientcdate) desc,MONTH(clientcdate) desc ", nativeQuery = true)
	List getAllTimeMonthSmsSegments(int companyrefid);

	@Query(value = "SELECT  MONTHNAME(CURRENT_DATE()) month,YEAR(CURRENT_DATE())year,sum(t.messagesegments)totalmessages FROM medc_sms.twlsms_logs t\r\n"
			+ "where t.companyrefid=?1 and Month(clientcdate)=MONTH(CURRENT_DATE())\r\n"
			+ "AND YEAR(clientcdate) = YEAR(CURRENT_DATE()) ", nativeQuery = true)
	List getOneMonthSmsSegments(int companyrefid);

	@Query(value = "SELECT sum(messagesegments) FROM medc_sms.twlsms_logs t where companyrefid =?1", nativeQuery = true)
	List getOverAllSmsSegments(int companyrefid);
	
	@Query(value = "SELECT  MONTHNAME(CURRENT_DATE()) month,YEAR(CURRENT_DATE())year,sum(t.messagesegments)totalmessages FROM medc_sms.twlsms_logs t\r\n"
			+ "where t.companyrefid=?1 and t.branchrefid=?2 and t.locname=?3 and t.locrefid = ?4 and Month(clientcdate)=MONTH(CURRENT_DATE())\r\n"
			+ "AND YEAR(clientcdate) = YEAR(CURRENT_DATE()) ", nativeQuery = true)
	List getshopOneMonthSmsSegments(int companyrefid,int branchid,int locname,int locrefid);

	@Query(value = "SELECT sum(messagesegments) FROM medc_sms.twlsms_logs t where companyrefid =?1 and branchrefid=?2 and locname=?3 and locrefid = ?4", nativeQuery = true)
	List getshopOverAllSmsSegments(int companyrefid,int branchid,int locname,int locrefid);
	
	

}
