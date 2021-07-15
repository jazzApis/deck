package com.jazz.deck.resorces;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jazz.deck.exception.DeckException;
import com.jazz.deck.model.TaskModel;

@Repository
public class TaskController {
	
	private static final Logger LOG = LoggerFactory.getLogger(PrinterController.class);
	private static final int TASK_MAX = 16;
	
	private static int taskId = 0;
	private static List<TaskModel> tasks = new ArrayList<>();
	
    @Autowired
    private PrinterController printerController;
	
	public TaskController() {}
	
	public List<TaskModel> get() {
		return tasks;
	}

	public TaskModel get(Integer taskId) throws DeckException {
		return tasks.stream()
				.filter(task -> task.getTaskId() == taskId)
				.findFirst()
				.orElse(null);		
	}

	public TaskModel getFirst() throws DeckException {
		return tasks.size() > 0 ? tasks.get(0) : null;
	}

	public Boolean remove(int taskId) throws DeckException {
		return remove(get(taskId));
	}

	public Boolean remove(TaskModel task) throws DeckException {
		return task == null ? false : tasks.remove(task);
	}

	public int add(String title, String text) throws DeckException {
		TaskModel task = new TaskModel(taskId++, title, text);
		return add(task);
	}

	public int add(TaskModel task) throws DeckException {
		LOG.debug("Add task " + task.getTitle());
		if (tasks.size() > TASK_MAX) {
			throw new DeckException("To many tasks, try later");
		}
		task.setPrinter(printerController.getSelected().getCode());
		tasks.add(task);
		return task.getTaskId();
	}
	
	private Integer find(Integer taskId) throws DeckException {
		return IntStream.range(0, tasks.size())
				.filter(idx-> tasks.get(idx).getTaskId() == taskId)
				.findFirst()
				.getAsInt();		
	}
}
