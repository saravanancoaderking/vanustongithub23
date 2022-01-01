package com.medeil.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.medeil.domain.UserActivity;
import com.medeil.service.UserActivityService;

@SuppressWarnings("rawtypes")
@RestController
@RequestMapping("/api/User")
public class UserActivityController {

	@Autowired
	private UserActivityService userActivityService;

	@ResponseBody
	@RequestMapping(value = "/saveUserActivity")
	public boolean saveUserActivity(@RequestBody UserActivity userActivity) throws Exception {
		return userActivityService.saveUserActivity(userActivity);
	}

	@ResponseBody
	@RequestMapping(value = "/ClientActivity")
	public List getClientActivity(@RequestBody UserActivity userActivity) throws Exception {
		return userActivityService.getClientActivity(userActivity);
	}

	@ResponseBody
	@RequestMapping(value = "/ClientMonitoring")
	public List getClientMonitoring(@RequestBody UserActivity userActivity) throws Exception {
		return userActivityService.getClientMonitoring(userActivity);
	}

	@ResponseBody
	@RequestMapping(value = "/userAudit")
	public List getuserAudit(@RequestBody UserActivity userActivity) throws Exception {
		return userActivityService.getuserAudit(userActivity);
	}

	@ResponseBody
	@RequestMapping(value = "/EmployeeTracking")
	public List getEmployeeTracking(@RequestBody UserActivity userActivity) throws Exception {
		return userActivityService.getEmployeeTracking(userActivity);
	}

	@GetMapping(value = "/TaskStatus/{compid}/{branchid}/{locname}/{locrefid}/{taskstatus}")
	public List getTaskStatus(@PathVariable Integer compid, @PathVariable Integer branchid,
			@PathVariable Integer locname, @PathVariable Integer locrefid, @PathVariable Integer taskstatus)
			throws Exception {
		return userActivityService.getTaskStatus(compid, branchid, locname, locrefid, taskstatus);
	}

}