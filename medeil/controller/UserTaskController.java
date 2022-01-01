package com.medeil.controller;

import java.util.Date;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.medeil.domain.IndCompModel;
import com.medeil.domain.Shipping;
import com.medeil.domain.SubTaskTitle;
import com.medeil.domain.UserTask;
import com.medeil.domain.UserTaskComment;
import com.medeil.service.UserTaskService;

/**
 * @author Kishore
 *
 */

@SuppressWarnings("rawtypes")
@RestController
@RequestMapping("api")
public class UserTaskController {

	boolean schedule;
	boolean manual = true;
	@Autowired
	private UserTaskService userTaskService;

	private static Logger logger = LogManager.getLogger();

	@Transactional
	@PostMapping(value = "/saveGroupTaskAssignment")
	public boolean saveGroupTaskAssignment(@RequestBody List<UserTask> userTask) throws Exception {

		return userTaskService.saveGroupTaskAssignment(userTask);
	}

	@Transactional
	@PostMapping(value = "/saveSubTask")
	public boolean saveSubTask(@RequestBody List<SubTaskTitle> subTaskTitle) throws Exception {

		return userTaskService.saveSubTask(subTaskTitle);
	}

	@PostMapping(value = "/updateViewIndividualTask")
	public boolean updateViewIndividualTask(@RequestBody UserTask userTask) throws Exception {

		return userTaskService.updateViewIndividualTask(userTask);
	}

	@ResponseBody
	@RequestMapping(value = "/saveTaskAssignment", method = RequestMethod.POST)
	public boolean saveTaskAssignment(@RequestBody UserTask userTask) throws Exception {

		return userTaskService.saveTaskAssignment(userTask);
	}

	@ResponseBody
	@RequestMapping(value = "/viewPendingTask", method = RequestMethod.POST)
	public List viewPendingTask(@RequestBody UserTask userTask) throws Exception {

		return userTaskService.viewPendingTask(userTask);
	}

	@ResponseBody
	@RequestMapping(value = "/saveUserTaskComment", method = RequestMethod.POST)
	public boolean saveUserTaskComment(@RequestBody UserTaskComment userTaskComment) throws Exception {

		return userTaskService.saveUserTaskComment(userTaskComment);
	}

	@GetMapping(value = "/taskType/{compid}/{branchid}/{locname}/{locrefid}")
	public List taskType(@PathVariable Integer compid, @PathVariable Integer branchid, @PathVariable Integer locname,
			@PathVariable Integer locrefid) {
		return userTaskService.taskType(compid, branchid, locname, locrefid);
	}

	@GetMapping(value = "/getAssignEmployee/{compid}/{branchid}/{locname}/{locrefid}/{subdivisionid}")
	public List getAssignEmployee(@PathVariable Integer compid, @PathVariable Integer branchid,
			@PathVariable Integer locname, @PathVariable Integer locrefid, @PathVariable Integer subdivisionid) {
		return userTaskService.getAssignEmployee(compid, branchid, locname, locrefid, subdivisionid);
	}

	@GetMapping(value = "/getTaskPriority/{compid}/{branchid}/{locname}/{locrefid}")
	public List getTaskPriority(@PathVariable Integer compid, @PathVariable Integer branchid,
			@PathVariable Integer locname, @PathVariable Integer locrefid) {

		return userTaskService.getTaskPriority(compid, branchid, locname, locrefid);

	}

	@GetMapping(value = "/getTaskStatus/{compid}/{branchid}/{locname}/{locrefid}")
	public List getTaskStatus(@PathVariable Integer compid, @PathVariable Integer branchid,
			@PathVariable Integer locname, @PathVariable Integer locrefid) {

		return userTaskService.getTaskStatus(compid, branchid, locname, locrefid);

	}

	@GetMapping(value = "/getTaskStatusBar/{compid}/{branchid}/{locname}/{locrefid}")
	public List getTaskStatusBar(@PathVariable Integer compid, @PathVariable Integer branchid,
			@PathVariable Integer locname, @PathVariable Integer locrefid) {

		return userTaskService.getTaskStatusBar(compid, branchid, locname, locrefid);

	}

	@GetMapping(value = "/getTaskCount/{compid}/{branchid}/{locname}/{locrefid}/{empid}")
	public List getTaskCount(@PathVariable Integer compid, @PathVariable Integer branchid,
			@PathVariable Integer locname, @PathVariable Integer locrefid, @PathVariable Integer empid) {

		return userTaskService.getTaskCount(compid, branchid, locname, locrefid, empid);
	}

	@GetMapping(value = "/getPriority/{compid}/{branchid}/{locname}/{locrefid}/{empid}")
	public List getTaskPriority(@PathVariable Integer compid, @PathVariable Integer branchid,
			@PathVariable Integer locname, @PathVariable Integer locrefid, @PathVariable Integer empid) {

		return userTaskService.getTaskPriority(compid, branchid, locname, locrefid, empid);
	}

	@GetMapping(value = "/getPriorityBar/{compid}/{branchid}/{locname}/{locrefid}/{empid}")
	public List getPriorityBar(@PathVariable Integer compid, @PathVariable Integer branchid,
			@PathVariable Integer locname, @PathVariable Integer locrefid, @PathVariable Integer empid) {

		return userTaskService.getPriorityBar(compid, branchid, locname, locrefid, empid);
	}

	@GetMapping(value = "/getTskCompleteBar/{compid}/{branchid}/{locname}/{locrefid}/{empid}")
	public List getTaskCompletedBar(@PathVariable Integer compid, @PathVariable Integer branchid,
			@PathVariable Integer locname, @PathVariable Integer locrefid, @PathVariable Integer empid) {

		return userTaskService.getTaskCompletedBar(compid, branchid, locname, locrefid, empid);
	}

	@GetMapping(value = "/getNotificationinformation/{compid}/{branchid}/{locname}/{locrefid}")
	public List getNotificationinformation(@PathVariable Integer compid, @PathVariable Integer branchid,
			@PathVariable Integer locname, @PathVariable Integer locrefid) {

		return userTaskService.getNotificationinformation(compid, branchid, locname, locrefid);
	}

	@GetMapping(value = "/getTaskComment/{compid}/{branchid}/{locname}/{locrefid}")
	public List getTaskComment(@PathVariable Integer compid, @PathVariable Integer branchid,
			@PathVariable Integer locname, @PathVariable Integer locrefid) {

		return userTaskService.getTaskComment(compid, branchid, locname, locrefid);

	}

	@ResponseBody
	@RequestMapping(value = "/getTableValues", method = RequestMethod.POST)
	public List getTableValues(@RequestBody UserTask utk) {

		return userTaskService.getTableValues(utk);

	}

	@PostMapping(value = "/viewUserTask")
	public List viewUserTask(@RequestBody UserTask utk) throws Exception {

		return userTaskService.viewUserTask(utk);
	}

	@PostMapping(value = "/ViewTaskPerformance")
	public List ViewTaskPerformance(@RequestBody UserTask utk) throws Exception {

		return userTaskService.ViewTaskPerformance(utk);
	}

	@GetMapping(value = "/reviewPeriod/{compid}/{branchid}/{locname}/{locrefid}/{period}")
	public List reviewPeriod(@PathVariable Integer compid, @PathVariable Integer branchid,
			@PathVariable Integer locname, @PathVariable Integer locrefid, @PathVariable String period) {

		return userTaskService.reviewPeriod(compid, branchid, locname, locrefid, period);
	}

	@GetMapping(value = "/getEmpInfo/{compid}/{branchid}/{locname}/{locrefid}/{taskId}")
	public List getEmpInfo(@PathVariable Integer compid, @PathVariable Integer branchid, @PathVariable Integer locname,
			@PathVariable Integer locrefid, @PathVariable Integer taskId) {

		return userTaskService.getEmpInfo(compid, branchid, locname, locrefid, taskId);
	}

	@PostMapping(value = "/viewAssignedTask")
	public List viewAssignedTask(@RequestBody UserTask utk) throws Exception {
		return userTaskService.viewAssignedTask(utk);

	}

	@GetMapping(value = "/getTaskValues/{compid}/{branchid}/{locname}/{locrefid}/{id}")
	public List getTaskValues(@PathVariable Integer compid, @PathVariable Integer branchid,
			@PathVariable Integer locname, @PathVariable Integer locrefid, @PathVariable Integer id) {
		return userTaskService.getTaskValues(compid, branchid, locname, locrefid, id);
	}

	@GetMapping(value = "/dropdownemployee/{compid}/{branchid}/{locname}/{locrefid}/{deptrefid}")
	public List dropdownemployee(@PathVariable Integer compid, @PathVariable Integer branchid,
			@PathVariable Integer locname, @PathVariable Integer locrefid, @PathVariable Integer deptrefid) {
		return userTaskService.dropdownemployee(compid, branchid, locname, locrefid, deptrefid);
	}

	@ResponseBody
	@RequestMapping(value = "/getTaskTitle", method = RequestMethod.POST)
	public List getTaskTitle(@RequestBody UserTask utk) throws Exception {

		return userTaskService.getTaskTitle(utk);

	}

	@ResponseBody
	@RequestMapping(value = "/getEmployeeDrop", method = RequestMethod.POST)
	public List getEmployeeDrop(@RequestBody UserTask utk) throws Exception {

		return userTaskService.getEmployeeDrop(utk);

	}

	@GetMapping(value = "/getAssignedBy/{taskid}")
	public List getAssignedBy(@PathVariable Integer taskid) {
		return userTaskService.getAssignedBy(taskid);
	}

	@GetMapping(value = "/getAssignedTo/{taskid}")
	public List getAssignedTo(@PathVariable Integer taskid) {
		return userTaskService.getAssignedTo(taskid);
	}

//	password : f8dcb902-86bd-45b9-9f02-a3b6e8c7e87c

//	@Scheduled(fixedDelay =  2000L)
//	void someJod() throws InterruptedException {
//		System.out.println("Now is " + new Date());
//		Thread.sleep(1000L);
//	}

//	@Scheduled(cron = "0 42 10 ? * MON-FRI")
//	void someJod() throws InterruptedException {
//		System.out.println("Now is " + new Date() + " Hi Kishore");
//		Thread.sleep(1000L);
//	}

//	@GetMapping(value = "/manualProcess/{manual}")
//	public void manualProcess(@PathVariable("manual") boolean manual) {
//		System.out.println("======================> Maunual Received " + manual);
//		this.manual = manual;
//	}

//	@Scheduled(fixedDelay = 2000L)
//	@Scheduled(cron = "0 * 00-18 ? * MON-FRI,SUN")
//	void morning930clkScheduler() {
//		if (this.manual) {
//			Integer empCount;
//			empCount = this.userTaskService.getEmployeeCount();
//			System.out.println("empCount" + " " + empCount);
//		}
//	}

}
