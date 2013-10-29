package com.github.mvollebregt.todo.web;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;

import com.github.mvollebregt.todo.model.Task;

@SuppressWarnings("serial")
public class EditTaskPage extends WebPage {

	public EditTaskPage(Task task) {
		add(new Label("description", task.getDescription()));
	}

}
