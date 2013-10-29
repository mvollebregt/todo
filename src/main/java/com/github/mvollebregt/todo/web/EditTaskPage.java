package com.github.mvollebregt.todo.web;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.form.Button;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.model.PropertyModel;
import org.apache.wicket.spring.injection.annot.SpringBean;

import com.github.mvollebregt.todo.model.Task;
import com.github.mvollebregt.todo.services.TaskService;

@SuppressWarnings("serial")
public class EditTaskPage extends WebPage {

	@SpringBean
	private TaskService taskService;

	public EditTaskPage(final Task task) {
		Form<Task> form = new Form<>("form");
		add(form);
		form.add(new TextField<Task>("description", new PropertyModel<Task>(task, "description")));
		form.add(new Button("submit") {
			@Override
			public void onSubmit() {
				taskService.save(task);
			}
		});
	}

}
