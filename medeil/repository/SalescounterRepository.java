package com.medeil.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.medeil.domain.Salescounter;

@SuppressWarnings("rawtypes")
@Repository
public interface SalescounterRepository extends JpaRepository<Salescounter, Long> {
	
	@Query(value = "SELECT emprefid,customername FROM medc_adminsecurity.medc_userlogin\r\n" + 
			"inner join medc_adminsecurity.medc_adduser ad on ad.suserrefid = suserid where suserid = ?1", nativeQuery = true)
	List employeedetails(Integer userid);
	
	@Query(value = "SELECT op.openregid,op.employeeid,op.counterid,op.logintime,(op.openbalance + op.additionalamount) as opentotal FROM medc_open_close_register.medc_openregister op\r\n" + 
			"where op.suserid= ?1 and op.logintime >=?2", nativeQuery = true)
	List employeeopenregisterdetails(Integer userid,String logintime);
	
	@Query(value = "SELECT cashmanageid,cashform,cashtype,paytype,payamount,paydetails,distributorname,loyaltyamount,giftamount,dueamount,DATE_FORMAT(createddate,'%d/%m/%Y'),cast(clientcdate as time) as cltime,\r\n" + 
			"(SELECT sum(mm.payamount) FROM medc_open_close_register.medc_cashmanage mm where mm.suserrefid=?1 and mm.clientcdate > ?2 and mm.cashtype=1),(SELECT sum(mm.payamount) FROM medc_open_close_register.medc_cashmanage mm where mm.suserrefid=?1 and mm.clientcdate > ?2 and mm.cashtype=2)\r\n" + 
			"FROM medc_open_close_register.medc_cashmanage m where suserrefid= ?1 and clientcdate >= ?2", nativeQuery = true)
	List employeetransdetails(Integer userid, String logintime);

	@Query(value = "SELECT op.openregid,op.employeeid,ad.customername,op.counterid,date(op.logintime) as opdate"
			+ ",cast(op.logintime as time) as optime,op.openbalance,op.additionalamount,op.openregdetails FROM medc_open_close_register.medc_openregister op\r\n" + 
			"left join medc_adminsecurity.medc_adduser ad on ad.suserrefid = op.suserid\r\n" + 
			"where op.companyid=?1 and op.branchid=?2 and op.locname=?3 and op.locrefid=?4 order by op.openregid desc", nativeQuery = true)
	List openregisterdetails(Integer compid, Integer branchid, Integer locname, Integer locrefid);
	
	@Query(value = "SELECT cl.closeregid,cl.suserid,cl.employeeid,ad.customername,cl.counterid,date(cl.logintime),cast(cl.logintime as time) as cllogintime,date(cl.logouttime),cast(cl.logouttime as time) as clogouttime,\r\n" + 
			"cl.transactamt,cl.closedbalance,cl.differenceamt,cl.closeregdetails,cl.logintime,cast(cl.clientcdate as time) as createdate,cl.openbalance FROM medc_open_close_register.medc_closeregister cl\r\n" + 
			"left join medc_adminsecurity.medc_adduser ad on ad.suserrefid = cl.suserid\r\n" + 
			"where cl.companyid=?1 and cl.branchid=?2 and cl.locname=?3 and cl.locrefid=?4 order by cl.closeregid desc", nativeQuery = true)
	List closeregisterdetails(Integer compid, Integer branchid, Integer locname, Integer locrefid);
	
	@Query(value = "SELECT cashmanageid,cashform,cashtype,paytype,payamount,paydetails,distributorname,loyaltyamount,giftamount,dueamount,DATE_FORMAT(clientcdate,'%d/%m/%Y'),cast(clientcdate as time) as entrytime\r\n" + 
			"FROM medc_open_close_register.medc_cashmanage where suserrefid=?1 and clientcdate >=?2 and time(clientcdate) <=?3", nativeQuery = true)
	List GetCashMovements(Integer userid, String logintime, String logouttime);

	@Query(value = "select (SELECT sum(mm.payamount) FROM medc_open_close_register.medc_cashmanage mm where mm.suserrefid=?1 and mm.cashform='Add Cash' and mm.clientcdate >=?2),\r\n" + 
			"(SELECT sum(cm.payamount) FROM medc_open_close_register.medc_cashmanage cm where cm.suserrefid=?1 and cm.cashform='Remove Cash' and cm.clientcdate >=?2)\r\n" + 
			"FROM medc_open_close_register.medc_cashmanage where suserrefid=?1 and clientcdate >=?2 limit 1;", nativeQuery = true)
	List GetAddRemoveCashtotal(Integer userid, String logintime);

}
