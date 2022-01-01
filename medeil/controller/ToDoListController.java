package com.medeil.controller;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.medeil.domain.ToDoList;
import com.medeil.service.ToDoListService;

@SuppressWarnings("rawtypes")
@RestController
@RequestMapping("api")
public class ToDoListController {

	private static Logger logger = LogManager.getLogger();

	@Autowired
	private ToDoListService toDoListService;

	@ResponseBody
	@RequestMapping(value = "/saveToDoList", method = RequestMethod.POST)
	public boolean saveToDoList(@RequestBody ToDoList toDoList) throws Exception {

		return toDoListService.saveToDoList(toDoList);
	}

	@ResponseBody
	@RequestMapping(value = "/getData", method = RequestMethod.POST)
	public List getData(@RequestBody ToDoList toDoList) throws Exception {

		return toDoListService.getData(toDoList);
	}

	@ResponseBody
	@RequestMapping(value = "/deleteAll", method = RequestMethod.POST)
	public boolean deleteAllToDos(@RequestBody ToDoList toDoList) throws Exception {

		return this.toDoListService.deleteAllToDos(toDoList);
	}

	@ResponseBody
	@RequestMapping(value = "/deleteOne", method = RequestMethod.POST)
	public boolean deleteOneToDos(@RequestBody ToDoList toDoList) throws Exception {

		return this.toDoListService.deleteOneToDos(toDoList);
	}

}
