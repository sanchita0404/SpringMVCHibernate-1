package com.toDoList.spring.service;

import com.toDoList.spring.dao.ToDoListDAO;
import com.toDoList.spring.model.Task;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ToDoListServiceImpl implements ToDoListService {
	
	private ToDoListDAO toDoListDao;

	public void setToDoListDao(ToDoListDAO toDoListDao) {
		this.toDoListDao = toDoListDao;
	}

	@Override
	@Transactional
	public void addTask(Task p) {
		this.toDoListDao.addTask(p);
	}

	@Override
	@Transactional
	public void updateTask(Task p) {
		this.toDoListDao.updateTask(p);
	}

	@Override
	@Transactional
	public List<Task> listTasks() {
		return this.toDoListDao.listTasks();
	}

	@Override
	@Transactional
	public Task getTaskById(int id) {
		return this.toDoListDao.getTaskById(id);
	}

	@Override
	@Transactional
	public void removeTask(int id) {
		this.toDoListDao.removeTask(id);
	}

	/*@Override
	@Transactional
	public int getLoginStatus(String userName, String password) {
		return ToDoListDAO.getLoginStatus(userName,password);
	}*/

	/*public void setToDoListDao(String ToDoListDao) {
		toDoListDao = ToDoListDao;
	}

	public String getToDoListDao() {
		return toDoListDao;
	}*/

	/*public void setToDoListService(ToDoListDAOImpl toDoListService) {
		this.toDoListService = toDoListService;
	}

	public ToDoListDAOImpl getToDoListService() {
		return toDoListService;
	}*/
}
