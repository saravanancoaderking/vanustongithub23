package com.medeil.service;

import java.sql.SQLException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.medeil.domain.IndCompModel;
import com.medeil.domain.Shipping;
import com.medeil.domain.SubTaskTitle;
import com.medeil.domain.UserTask;
import com.medeil.domain.UserTaskComment;
import com.medeil.domain.Userlogin;
import com.medeil.repository.SubTaskTitleRepository;
import com.medeil.repository.UserTaskCommentRepository;
import com.medeil.repository.UserTaskRepository;
import com.medeil.repository.UserloginRepository;

@SuppressWarnings("rawtypes")
@Service
public class UserTaskService {

	@PersistenceContext
	EntityManager em;

	Query query;

	static List tsautoincr;

	private static Logger logger = LogManager.getLogger();

	@Autowired
	private UserTaskRepository userTaskRepository;

	@Autowired
	private SubTaskTitleRepository subTaskTitleRepository;

	@Autowired
	private UserTaskCommentRepository userTaskCommentRepository;

	@Autowired
	private UserloginRepository userloginRepository;

	List list = null;

	// @Transactional
	public boolean saveGroupTaskAssignment(List<UserTask> userTask) {
		try {
//			Integer userid = userTaskRepository.getUserId(userTask.getUserid());
//			Integer assignbydepartid = userTaskRepository.getAssignbydepart(userid);
//			Integer assigntodepartid = userTaskRepository.getAssigntodepart(userTask.getTask_assigned_to());
//			System.out.println(">>>>>>>>>>>>>>>>>>>>>"+"Userid"+userid+"assignbydepartid"+assignbydepartid+"assigntodepartid"+assigntodepartid);
//			if (assignbydepartid>assigntodepartid) {
//				userTask.setTask_assigned_by(userid);

			for (UserTask userTskArr : userTask) {
				getAutoincrement(userTskArr.getCompanyrefid(), userTskArr.getBranchrefid(), userTskArr.getLocname(),
						userTskArr.getLocrefid());
				userTskArr.setTasknumber(tsautoincr.get(0).toString());
				userTaskRepository.save(userTskArr);
			}
			return true;

//			} 
//			else {
//							System.out.println("Your not assign to the upper level ");
//				return false;
//						}

		} catch (Exception cause) {
			logger.error("Exception in (UserTask)Method : saveUserTask() " + cause);
		}
		return false;
	}

	public boolean saveSubTask(List<SubTaskTitle> subTaskTitle) {
		int task_id;
		try {

			for (SubTaskTitle subTaskTitleArr : subTaskTitle) {

				task_id = subTaskTitleRepository.getTaskID(subTaskTitleArr.getCompanyrefid(),
						subTaskTitleArr.getBranchrefid(), subTaskTitleArr.getLocname(), subTaskTitleArr.getLocrefid());
				subTaskTitleArr.setTask_id(task_id);
				subTaskTitleRepository.save(subTaskTitleArr);

			}
			return true;
		}

		catch (Exception e) {
			logger.error("Exception in (saveSubTask)Method : saveSubTask() " + e);
		}

		return false;
	}

	public List viewPendingTask(UserTask utk) {
		System.out.println(
				utk.getCompanyrefid() + "" + utk.getBranchrefid() + " " + utk.getLocname() + "" + utk.getLocrefid());

		return userTaskRepository.viewPendingTask(utk.getCompanyrefid(), utk.getBranchrefid(), utk.getLocname(),
				utk.getLocrefid(), utk.getTask_status_name());

	}

	public boolean updateViewIndividualTask(UserTask userTask) throws Exception {
		Userlogin login=userloginRepository.findById(userTask.getSuserid());
		UserTask task=userTaskRepository.findByEmployeeidAndTasknumber(login.getEmprefid(),userTask.getTasknumber());
		task.setColors(userTask.getColors());
		task.setCompleted_date(userTask.getCompleted_date());
		task.setTask_status_name(userTask.getTask_status_name());
		task.setRemarks(userTask.getRemarks());
		userTaskRepository.save(task);
		return true;
	}

	// @Transactional
	public boolean saveTaskAssignment(UserTask userTask) {
		try {
//				Integer userid = userTaskRepository.getUserId(userTask.getUserid());
//				Integer assignbydepartid = userTaskRepository.getAssignbydepart(userid);
//				Integer assigntodepartid = userTaskRepository.getAssigntodepart(userTask.getTask_assigned_to());
//				System.out.println(">>>>>>>>>>>>>>>>>>>>>"+"Userid"+userid+"assignbydepartid"+assignbydepartid+"assigntodepartid"+assigntodepartid);
//				if (assignbydepartid>assigntodepartid) {
//					userTask.setTask_assigned_by(userid);

			getAutoincrement(userTask.getCompanyrefid(), userTask.getBranchrefid(), userTask.getLocname(),
					userTask.getLocrefid());
			userTask.setTasknumber(tsautoincr.get(0).toString());

			System.out.println("userTask.setTask================> " + userTask.getTasknumber());
			userTaskRepository.save(userTask);
			return true;
//				} 
//				else {
//								System.out.println("Your not assign to the upper level ");
//					return false;
//							}

		} catch (Exception cause) {
			logger.error("Exception in (UserTask)Method : saveUserTask() " + cause);
		}
		return false;
	}

	public boolean saveUserTaskComment(UserTaskComment userTaskComment) {

		userTaskCommentRepository.save(userTaskComment);

		return true;

	}

	public List taskType(int compid, int branchid, int locname, int locrefid) {
		list = null;
		try {
			list = userTaskRepository.taskType(compid, branchid, locname, locrefid);

		} catch (Exception e) {
			logger.error("Exception in Method : taskType() " + e);
		}
		return list;
	}

	public List getTaskTitle(UserTask utk) {
		list = null;
		try {

			list = userTaskRepository.getTaskTitle(utk.getCompanyrefid(), utk.getBranchrefid(), utk.getLocname(),
					utk.getLocrefid());

		} catch (Exception e) {
			logger.error("Exception in Method : getTaskTitle() " + e);
		}
		return list;
	}

	public List getEmployeeDrop(UserTask utk) {
		list = null;
		try {
			System.out.println("getTaskTitle " + utk.getCompanyrefid() + " " + utk.getBranchrefid() + " "
					+ utk.getLocname() + " " + utk.getLocrefid());

			list = userTaskRepository.getEmployeeDrop(utk.getCompanyrefid(), utk.getBranchrefid(), utk.getLocname(),
					utk.getLocrefid(), utk.getDeptid());

		} catch (Exception e) {
			logger.error("Exception in Method : getEmployeeDrop() " + e);
		}
		return list;
	}

	public List getAssignEmployee(int compid, int branchid, int locname, int locrefid, int subdivisionid) {
		list = null;
		try {
			list = userTaskRepository.getAssignEmployee(compid, branchid, locname, locrefid, subdivisionid);

		} catch (Exception e) {
			logger.error("Exception in Method : getAssignEmployee() " + e);
		}
		return list;
	}

	public List getTaskComment(int compid, int branchid, int locname, int locrefid) {

		return userTaskCommentRepository.getTaskComment(compid, branchid, locname, locrefid);
	}

	public List getTaskPriority(int compid, int branchid, int locname, int locrefid) {
		list = null;
		try {
			list = userTaskRepository.getTaskPriority(compid, branchid, locname, locrefid);

		} catch (Exception e) {
			logger.error("Exception in Method : getTaskPriority() " + e);
		}
		return list;
	}

	public List getTaskStatus(int compid, int branchid, int locname, int locrefid) {
		list = null;
		try {
			list = userTaskRepository.getTaskStatus(compid, branchid, locname, locrefid);

		} catch (Exception e) {
			logger.error("Exception in Method : getTaskStatus() " + e);
		}
		return list;
	}

	public List getTaskStatusBar(int compid, int branchid, int locname, int locrefid) {
		list = null;
		try {
			list = userTaskRepository.getTaskStatusBar(compid, branchid, locname, locrefid);

		} catch (Exception e) {
			logger.error("Exception in Method : getTaskStatusBar() " + e);
		}
		return list;
	}

	public List getTaskCount(int compid, int branchid, int locname, int locrefid, int empid) {
		list = null;
		try {
			list = userTaskRepository.getTaskCount(compid, branchid, locname, locrefid, empid);

		} catch (Exception e) {
			logger.error("Exception in Method : getTaskCount() " + e);
		}
		return list;
	}

	public List getTaskPriority(int compid, int branchid, int locname, int locrefid, int empid) {
		list = null;
		try {
			list = userTaskRepository.getTaskPriority(compid, branchid, locname, locrefid, empid);

		} catch (Exception e) {
			logger.error("Exception in Method : getTaskPriority() " + e);
		}
		return list;
	}

	public List getPriorityBar(int compid, int branchid, int locname, int locrefid, int empid) {
		list = null;
		try {
			list = userTaskRepository.getPriorityBar(compid, branchid, locname, locrefid, empid);

		} catch (Exception e) {
			logger.error("Exception in Method : getPriorityBar() " + e);
		}
		return list;
	}

	public List getTaskCompletedBar(int compid, int branchid, int locname, int locrefid, int empid) {
		list = null;
		try {
			list = userTaskRepository.getTaskCompletedBar(compid, branchid, locname, locrefid, empid);

		} catch (Exception e) {
			logger.error("Exception in Method : getPriorityBar() " + e);
		}
		return list;
	}

	public List reviewPeriod(int compid, int branchid, int locname, int locrefid, String period) {
		list = null;

		System.out.println(compid + " " + branchid + " " + locname + " " + locrefid + " " + period);
		try {

			if (period.equals("Weekly")) {
				list = userTaskRepository.revPerWeekly(compid, branchid, locname, locrefid);
				
			} else if (period.equals("Monthly")) {
				list = userTaskRepository.revPerMonthly(compid, branchid, locname, locrefid);
			
			} else if (period.equals("Annually")) {
				list = userTaskRepository.revPerAnnually(compid, branchid, locname, locrefid);
				
			}

		} catch (Exception e) {
			logger.error("Exception in Method : reviewPeriod() " + e);
		}
		System.out.println("List " + list);
		return list;
	}

	public List getEmpInfo(int compid, int branchid, int locname, int locrefid, int taskId) {
		
		System.out.println(compid + " " + branchid + " " + locname + " " + locrefid + " " + taskId);
		list = null;
		try {
			list = userTaskRepository.getEmpInfo(compid, branchid, locname, locrefid, taskId);

		} catch (Exception e) {
			logger.error("Exception in Method : getEmpInfo() " + e);
		}
		return list;
	}
	
	
	public List getNotificationinformation(int compid, int branchid, int locname, int locrefid) {
		list = null;
		try {
			list = userTaskRepository.getNotificationinformation(compid, branchid, locname, locrefid);

		} catch (Exception e) {
			logger.error("Exception in Method : getNotificationinformation() " + e);
		}
		return list;
	}

	public List getTableValues(UserTask utk) {

		System.out.print(utk.getDeptid() +
		// utk.getSubdeptid(),
				utk.getEmployeeid() + utk.getTask_priority_name() + utk.getTask_status_name() + utk.getTask_type_id() +

				// utk.getDivisionid(),
				// utk.getSubdivisionid(),

				utk.getCompanyrefid() + utk.getBranchrefid() + utk.getLocname() + utk.getLocrefid());

		return userTaskRepository.getTableValues(

				utk.getDeptid(),

				// utk.getSubdeptid(),

				utk.getEmployeeid(), utk.getTask_priority_name(), utk.getTask_status_name(), utk.getTask_type_id(),

				// utk.getDivisionid(),
				// utk.getSubdivisionid(),

				utk.getCompanyrefid(), utk.getBranchrefid(), utk.getLocname(), utk.getLocrefid());

	}

	/** METHOD FOR GETTING NEW TASK ASSIGNMENT - AUTOINCREMENT **/

	public void getAutoincrement(Integer cid, Integer bid, Integer locname, Integer locrefid) {
		List val = null;
		try {
			String value = "CALL medc_taskmanagement.pro_usertaskautoincrement(?, ?, ?, ?, ?)";
			query = em.createNativeQuery(value);
			query.setParameter(1, "usertask");
			query.setParameter(2, cid);
			query.setParameter(3, bid);
			query.setParameter(4, locname);
			query.setParameter(5, locrefid);
			val = query.getResultList();
		} catch (Exception e) {
			logger.error("Exception in Method : getAutoIncrement() " + e);
		}

		tsautoincr = val;

	}

	public List viewUserTask(UserTask utk) {
		return userTaskRepository.viewUserTask(utk.getSuserid());

	}

	public List ViewTaskPerformance(UserTask utk) {
		System.out.println(
				utk.getCompanyrefid() + "" + utk.getBranchrefid() + " " + utk.getLocname() + "" + utk.getLocrefid());

		return userTaskRepository.ViewTaskPerformance(utk.getCompanyrefid(), utk.getBranchrefid(), utk.getLocname(),
				utk.getLocrefid());

	}

	public List viewAssignedTask(UserTask utk) {
		return userTaskRepository.viewAssignedTask(utk.getSuserid());

	}

	public List getTaskValues(int compid, int branchid, int locname, int locrefid, int id) {
		list = null;
		try {
			list = userTaskRepository.getTaskValues(compid, branchid, locname, locrefid, id);

		} catch (Exception e) {
			logger.error("Exception in Method : getTaskValues() " + e);
		}
		return list;
	}

	public List dropdownemployee(int compid, int branchid, int locname, int locrefid, int deptrefid) {
		list = null;

		List<String> data = null;
		try {
			data = userTaskRepository.dropdownemployee(compid, branchid, locname, locrefid, deptrefid);
			System.out.println("Datas1 " + data);
			System.out.println(data.size());
		} catch (Exception e) {
			logger.error("Exception in Method : dropdownemployee() " + e);
		}
		return data;
	}

	public List getAssignedBy(int taskid) {
		list = null;
		try {
			list = userTaskRepository.getAssignedBy(taskid);

		} catch (Exception e) {
			logger.error("Exception in Method : getAssignedBy() " + e);
		}
		return list;
	}

	public List getAssignedTo(int taskid) {
		list = null;
		try {
			list = userTaskRepository.getAssignedTo(taskid);

		} catch (Exception e) {
			logger.error("Exception in Method : getAssignedTo() " + e);
		}
		return list;
	}

	public Integer getEmployeeCount() {
		Integer empCount;

		empCount = this.userTaskRepository.getEmployeeCount();

		return empCount;

	}

}
