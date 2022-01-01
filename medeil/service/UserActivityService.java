
package com.medeil.service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.medeil.domain.UserActivity;
import com.medeil.repository.UserActivityRepository;

@Service

public class UserActivityService {

	private static Logger logger = LogManager.getLogger();
	@PersistenceContext
	private EntityManager manager;

	@PersistenceContext
	EntityManager em;

	Query query;

	@Autowired
	private UserActivityRepository userActivityRepository;

	public boolean saveUserActivity(UserActivity userActivity) throws Exception {
		Boolean saveflag = false;
		// try {
		String time1 = userActivity.getPstarttime();
		String time2 = userActivity.getPendtime();
		SimpleDateFormat format = new SimpleDateFormat("HH:mm:ss");
		Date date1 = format.parse(time1);
		Date date2 = format.parse(time2);
		long difference = date2.getTime() - date1.getTime();
		long seconds = (difference / 1000);

		long p1 = seconds % 60; // seconds
		long p2 = seconds / 60; // minutes
		long p3 = p2 % 60;
		p2 = p2 / 60;
		userActivity.setFormsessiontime(p2 + ":" + p3 + ":" + p1);
		userActivityRepository.save(userActivity);
		saveflag = true;
		// } catch (Exception ex) {
		// logger.error("Exception in (saveUserActivity)Method : saveUserActivity() " +
		// ex);

		// }
		return saveflag;

	}

	public List getClientActivity(UserActivity userActivity) throws Exception {
		// List list = null;
		// try {

		return userActivityRepository.getClientActivity(userActivity.getCompanyrefid(), userActivity.getBranchrefid(),
				userActivity.getLocname(), userActivity.getLocrefid());

		// } catch (Exception eh) {
		// logger.error("Exception in Method : getClientActivity() " + eh);
		// }
		// return list;
	}

	public List getClientMonitoring(UserActivity userActivity) throws Exception {
		// List list = null;
		// try {

		return userActivityRepository.getClientMonitoring(userActivity.getCompanyrefid(), userActivity.getBranchrefid(),
				userActivity.getLocname(), userActivity.getLocrefid());

		// } catch (Exception eh) {
		// logger.error("Exception in Method : getClientMonitoring() " + eh);
		// }
		// return list;
	}

	public List getuserAudit(UserActivity userActivity) throws Exception {
		// List list = null;
		// try {

		return userActivityRepository.getuserAudit(userActivity.getCompanyrefid(), userActivity.getBranchrefid(),
				userActivity.getLocname(), userActivity.getLocrefid());

		// } catch (Exception eh) {
		// logger.error("Exception in Method : getuserAudit() " + eh);
		// }
		// return list;
	}

	public List getEmployeeTracking(UserActivity userActivity) throws Exception {
		// List list = null;
		// try {

		return userActivityRepository.getEmployeeTracking(userActivity.getCompanyrefid(), userActivity.getBranchrefid(),
				userActivity.getLocname(), userActivity.getLocrefid());

		// } catch (Exception eh) {
		// logger.error("Exception in Method : getEmployeeTracking() " + eh);
		// }
		// return list;
	}

	public List getTaskStatus(int compid, int brnchid, int locname, int locrefid, int getTaskStatus) throws Exception {
		return userActivityRepository.getTaskStatus(compid, brnchid, locname, locrefid, getTaskStatus);
	}

}
