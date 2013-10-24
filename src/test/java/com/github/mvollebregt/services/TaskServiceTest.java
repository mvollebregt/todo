package com.github.mvollebregt.services;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

import com.github.mvollebregt.data.TaskDao;
import com.github.mvollebregt.model.Task;

public class TaskServiceTest {
	
	private TaskService service;

	private TaskDao taskDao;
	
	private Task task = new Task("description");
	
	@Test
	public void list_shouldReturnListOfAllTasks() {
		taskDao.init(task);
		List<Task> tasks = service.list();
		assertEquals(tasks, Arrays.asList(task));
	}

}
