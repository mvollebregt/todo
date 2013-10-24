package com.github.mvollebregt.todo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.mvollebregt.todo.model.Task;
import com.github.mvollebregt.todo.repository.TaskRepository;

@Service
@Transactional
public class TaskService {
	
	@Autowired private TaskRepository taskRepository;

	public List<Task> list() {
		return taskRepository.list();
	}

}
