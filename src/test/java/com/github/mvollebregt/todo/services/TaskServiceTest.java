package com.github.mvollebregt.todo.services;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.github.mvollebregt.todo.model.Task;
import com.github.mvollebregt.todo.repository.TaskRepository;
import com.github.mvollebregt.todo.services.TaskService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/beans.xml")
public class TaskServiceTest {
	
	@Autowired private TaskService service;
    @Autowired private TaskRepository taskDao;
	
	private Task task = new Task("description");
	
	@Test
	public void list_shouldReturnListOfAllTasks() {
		taskDao.init(task);
		List<Task> tasks = service.list();
		assertEquals(Arrays.asList(task), tasks);
	}

}
