package com.github.mvollebregt.todo.web;

import org.apache.wicket.model.LoadableDetachableModel;

import com.github.mvollebregt.todo.model.Task;
import com.github.mvollebregt.todo.services.TaskService;

public class TaskModel extends LoadableDetachableModel<Task> {
	
	private static final long serialVersionUID = -6158545408575645211L;
	
	private TaskService service;
	
	private Long id;
		
	public TaskModel(TaskService service, Task task) {
		super(task);
		id = task.getId();
		this.service = service;
	}
		
	@Override
	protected Task load() {
		if (id == null) {
			return new Task();
		} else {
			return service.fetch(id);
		}
	}

}
