package com.github.mvollebregt.todo.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;

import com.github.mvollebregt.todo.model.Task;
import com.github.mvollebregt.todo.repository.TaskRepository;

public class DemoDataInitialiser implements ApplicationListener<ContextRefreshedEvent> {
	
	@Autowired private TaskRepository taskRepository;

	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {
		taskRepository.init(new Task("Call your mom"), new Task("Have a nice dinner"), new Task("Learn wicket"));
	}

}
