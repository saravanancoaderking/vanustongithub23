package com.medeil.service;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.medeil.domain.ToDoList;
import com.medeil.repository.ToDoListRepository;

@SuppressWarnings("rawtypes")
@Service
public class ToDoListService {

	@Autowired
	private ToDoListRepository toDoListRepository;

	private static Logger logger = LogManager.getLogger();

	List list = null;

	public boolean saveToDoList(ToDoList toDoList) throws Exception {
		toDoListRepository.save(toDoList);
		return true;
	}

	public List getData(ToDoList toDo) throws Exception {
//		list = null;
//		try {
////			System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>================> Krish");
////			System.out.println("Hm " + toDo.getCompanyrefid() + " " + toDo.getBranchrefid() + " " + toDo.getLocname()
////					+ " " + toDo.getLocrefid());
//			list = this.toDoListRepository.getData(toDo.getCompanyrefid(), toDo.getBranchrefid(), toDo.getLocname(),
//					toDo.getLocrefid());
//		} catch (Exception e) {
//			logger.error("Exception in Method : getData() " + e);
//		}
		return toDoListRepository.getData(toDo.getCompanyrefid(), toDo.getBranchrefid(), toDo.getLocname(),
				toDo.getLocrefid());
	}

	public boolean deleteAllToDos(ToDoList toDo) throws Exception {
//		System.out.println("<<<<<<<<<<<<<<<<<<<<<<<<>>>>>>>>>>>>>>>>>>>>>");
//		System.out.println("Hm " + toDo.getCompanyrefid() + " " + toDo.getBranchrefid() + " " + toDo.getLocname() + " "
//				+ toDo.getLocrefid());
		toDoListRepository.deleteAllToDos(toDo.getCompanyrefid(), toDo.getBranchrefid(), toDo.getLocname(),
				toDo.getLocrefid());
		return true;

	}

	public boolean deleteOneToDos(ToDoList toDo) throws Exception {
		System.out.println("<<<<<<<<<<<<<<<<<<<<<<<<>>>>>>>>>>>>>>>>>>>>>");
//		System.out.println("Hm " + toDo.getCompanyrefid() + " " + toDo.getBranchrefid() + " " + toDo.getLocname() + " "
//				+ toDo.getLocrefid());
		toDoListRepository.deleteOneToDos(toDo.getCompanyrefid(), toDo.getBranchrefid(), toDo.getLocname(),
				toDo.getLocrefid(), toDo.getTopicname());
		return true;

	}

}
