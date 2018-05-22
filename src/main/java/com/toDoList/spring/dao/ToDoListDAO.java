package com.toDoList.spring.dao;

import com.toDoList.spring.model.Task;

import java.util.List;

public interface ToDoListDAO {

	public void addTask(Task t);
	public void updateTask(Task t);
	public List<Task> listTasks();
	public Task getTaskById(int id);
	public void removeTask(int id);
}
