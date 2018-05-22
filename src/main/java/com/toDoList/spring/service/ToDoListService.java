package com.toDoList.spring.service;

import com.toDoList.spring.model.Task;

import java.util.List;

public interface ToDoListService {

	public void addTask(Task p);
	public void updateTask(Task p);
	public List<Task> listTasks();
	public Task getTaskById(int id);
	public void removeTask(int id);

	/*public int getLoginStatus(String userName, String password);*/
}
