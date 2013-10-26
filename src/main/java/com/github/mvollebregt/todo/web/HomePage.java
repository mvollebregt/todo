package com.github.mvollebregt.todo.web;

import java.util.List;

import org.apache.wicket.request.mapper.parameter.PageParameters;
import org.apache.wicket.spring.injection.annot.SpringBean;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.repeater.Item;
import org.apache.wicket.markup.repeater.data.DataView;
import org.apache.wicket.markup.repeater.data.ListDataProvider;

import com.github.mvollebregt.todo.model.Task;
import com.github.mvollebregt.todo.services.TaskService;

public class HomePage extends WebPage {
	private static final long serialVersionUID = 1L;
	
	@SpringBean
	private TaskService taskService;

	public HomePage(final PageParameters parameters) {
		super(parameters);
		
		List<Task> list = taskService.list();
		
		add(new DataView<Task>("list", new ListDataProvider<Task>(list)) {
			private static final long serialVersionUID = 3875748496308908368L;
			@Override
			protected void populateItem(Item<Task> item) {
				Task task = item.getModelObject();
				item.add(new Label("name", task.getDescription()));
			}
		});
    }
}
