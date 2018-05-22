package com.toDoList.spring.dao;

import java.util.ArrayList;
import java.util.List;

import com.toDoList.spring.model.Task;
import com.toDoList.spring.model.User;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

@Repository
public class ToDoListDAOImpl implements ToDoListDAO {
	
	private static final Logger logger = LoggerFactory.getLogger(ToDoListDAOImpl.class);

	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sf){
		this.sessionFactory = sf;
	}

	@Override
	public void addTask(Task t) {
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(t);
		logger.info("Task saved successfully, Task Details="+t);
	}

	@Override
	public void updateTask(Task t) {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(t);
		logger.info("Task updated successfully, Task Details="+t);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Task> listTasks() {
			Session session = this.sessionFactory.getCurrentSession();
		List<Task> taskList = session.createQuery("from Task").list();
		for(Task p : taskList){
			logger.info("Task List::"+p);
		}
		return taskList;
	}

	@Override
	public Task getTaskById(int id) {
		Session session = this.sessionFactory.getCurrentSession();		
		Task t = (Task) session.load(Task.class, new Integer(id));
		logger.info("Person loaded successfully, Person details="+t);
		return t;
	}

	@Override
	public void removeTask(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		Task p = (Task) session.load(Task.class, new Integer(id));
		if(null != p){
			session.delete(p);
		}
		logger.info("Person deleted successfully, person details="+p);
	}



}
