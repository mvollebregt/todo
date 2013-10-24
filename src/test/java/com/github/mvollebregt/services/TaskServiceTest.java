package com.github.mvollebregt.services;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.github.mvollebregt.model.Task;

public class TaskServiceTest {
	
	private TaskService service;

	private MockTaskDao taskDao;
	
	@Test
	public void list_shouldReturnListOfAllTasks() {
		Task task = new Task("description");
		taskDao.init(task);
		List<Task> tasks = service.list();
		assertEquals(tasks, new ArrayList<Task>(task));
	}

}
