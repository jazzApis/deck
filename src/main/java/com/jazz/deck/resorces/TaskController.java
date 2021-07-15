package com.jazz.deck.resorces;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.jazz.deck.exception.DeckException;
import com.jazz.deck.model.TaskModel;

@Repository
public class TaskController {
	
	private static final Logger LOG = LoggerFactory.getLogger(PrinterController.class);
	private static final int TASK_MAX = 16;
	
	private static int taskId = 0;
	private static List<TaskModel> tasks = new ArrayList<>();
	
	public TaskController() {}
	
	public List<TaskModel> get() {
		return tasks;
	}

	public TaskModel get(int taskId) throws DeckException {
		if (taskId >= 0 && taskId < tasks.size()) {
			return tasks.get(taskId);
		}
		throw taskDoesNotExists(taskId);
	}

	public TaskModel remove(int taskId) throws DeckException {
		if (taskId >= 0 && taskId < tasks.size()) {
			return tasks.remove(taskId);
		}
		throw taskDoesNotExists(taskId);
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
		tasks.add(task);
		return task.getTaskId();
	}
	
	private DeckException taskDoesNotExists(int taskId)  {
		DeckException result = new DeckException("Task %s does not exists", taskId);
		LOG.error(result.getMessage());
		return result;
	}

}
