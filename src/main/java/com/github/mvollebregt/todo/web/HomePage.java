package com.github.mvollebregt.todo.web;

import java.util.List;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.markup.html.list.ListItem;
import org.apache.wicket.markup.html.list.PageableListView;
import org.apache.wicket.markup.html.navigation.paging.PagingNavigator;
import org.apache.wicket.request.mapper.parameter.PageParameters;
import org.apache.wicket.spring.injection.annot.SpringBean;

import com.github.mvollebregt.todo.model.Task;
import com.github.mvollebregt.todo.services.TaskService;

@SuppressWarnings("serial")
public class HomePage extends WebPage {
	private static final long serialVersionUID = 1L;
	
	@SpringBean
	private TaskService taskService;

	public HomePage(final PageParameters parameters) {
		super(parameters);
		
		List<Task> list = taskService.list();
		
		PageableListView<Task> listView = new PageableListView<Task>("list", list, 2) {
			@Override
			protected void populateItem(ListItem<Task> item) {
				final Task task = item.getModelObject();
				item.add( new Link<Task>("link", item.getModel()) {
					@Override
					public void onClick() {
						setResponsePage(new EditTaskPage(task));
					}
				}.add(new Label("description", task.getDescription())));
			}
		};
		
		add(new Link<Task>("create-link") {
			@Override
			public void onClick() {
				setResponsePage(new EditTaskPage(new Task()));
			}
		});
		add(listView);
		add(new PagingNavigator("navigator", listView));
    }
}
