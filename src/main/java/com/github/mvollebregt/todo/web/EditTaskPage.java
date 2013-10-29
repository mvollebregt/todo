package com.github.mvollebregt.todo.web;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.form.Button;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.markup.html.panel.FeedbackPanel;
import org.apache.wicket.model.CompoundPropertyModel;
import org.apache.wicket.spring.injection.annot.SpringBean;

import com.github.mvollebregt.todo.model.Task;
import com.github.mvollebregt.todo.services.TaskService;

@SuppressWarnings("serial")
public class EditTaskPage extends WebPage {

	@SpringBean
	private TaskService taskService;

	public EditTaskPage(final Task task) {
		// TODO: make task detachable?
		// TODO: use HibernateObjectModel?
		add(new FeedbackPanel("feedback"));
		Form<Task> form = new Form<>("form", new CompoundPropertyModel<Task>(task));
		add(form);
		form.add(new TextField<Task>("description").setRequired(true));
		form.add(new Button("submit") {
			@Override
			public void onSubmit() {
				taskService.save(task);
				info("Task was saved");
			}
		});
	}

}
