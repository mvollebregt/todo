package com.github.mvollebregt.todo.repository;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.github.mvollebregt.todo.model.Task;

@Repository
public class TaskRepository {
	
	@Autowired
	private SessionFactory sessionFactory;

	@Transactional
	public void init(Task... tasks) {
		for (Task task: tasks) {
			sessionFactory.getCurrentSession().persist(task);
		}
	}

	@SuppressWarnings("unchecked")
	public List<Task> list() {
		return sessionFactory.getCurrentSession().createCriteria(Task.class).list();
	}

	public void save(Task task) {
		sessionFactory.getCurrentSession().saveOrUpdate(task);		
	}

}
