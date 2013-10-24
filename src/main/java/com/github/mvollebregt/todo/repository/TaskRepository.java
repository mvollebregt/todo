package com.github.mvollebregt.todo.repository;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.github.mvollebregt.todo.model.Task;

@Repository
public class TaskRepository {
	
	private List<Task> tasks;

	public void init(Task... tasks) {
		this.tasks = Arrays.asList(tasks);		
	}

	public List<Task> list() {
		return tasks;
	}

}
