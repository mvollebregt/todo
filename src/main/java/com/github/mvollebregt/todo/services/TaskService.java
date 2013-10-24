package com.github.mvollebregt.todo.services;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

import com.github.mvollebregt.todo.model.Task;

@Service
public class TaskService {

	public List<Task> list() {
		return Arrays.asList(new Task("description"));
	}

}
