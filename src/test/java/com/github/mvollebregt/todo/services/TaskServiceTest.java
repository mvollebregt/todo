package com.github.mvollebregt.todo.services;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.github.mvollebregt.todo.model.Task;
import com.github.mvollebregt.todo.repository.TaskRepository;
import com.github.mvollebregt.todo.services.TaskService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/beans.xml")
@Transactional
public class TaskServiceTest {
	
	@Autowired private TaskService service;
    @Autowired private TaskRepository taskDao;
	
	private Task task = new Task("description");
	private Task anotherTask = new Task("other task description");
	
	@Test
	public void list_singleTask_shouldReturnListWithOneTask() {
		taskDao.init(task);
		List<Task> result = service.list();
		assertEquals(Arrays.asList(task), result);
	}
	
	@Test
	public void list_multipleTasks_shouldReturnListOfAllTasks() {
		taskDao.init(task, anotherTask);
		List<Task> result = service.list();
		assertEquals(Arrays.asList(task, anotherTask), result);
	}

}
