package com.medeil.service;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.medeil.domain.Usersession;
import com.medeil.repository.UsersessionRepository;

@Service
public class UsersessionService {

	@Autowired
	private UsersessionRepository usersessionRepository;
	private static Logger logger = LogManager.getLogger();

	public boolean saveUsertime(Usersession usersession) throws Exception {
		Boolean saveflag = false;
		// try {
		String time1 = usersession.getLogintime();
		String time2 = usersession.getLogouttime();
		SimpleDateFormat format = new SimpleDateFormat("HH:mm:ss");
		Date date1 = format.parse(time1);
		Date date2 = format.parse(time2);
		long difference = date2.getTime() - date1.getTime();
		long seconds = (difference / 1000);

		long p1 = seconds % 60; // seconds
		long p2 = seconds / 60; // minutes
		long p3 = p2 % 60;
		p2 = p2 / 60;
		usersession.setSessiontime(p2 + ":" + p3 + ":" + p1);
		usersessionRepository.save(usersession);
		saveflag = true;
		// } catch (Exception ex) {
		// logger.error("Exception in (usersession)Method : saveUsertime() " + ex);

		// }
		return saveflag;
	}

}
