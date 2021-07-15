package com.jazz.deck.model;

public class TaskModel {
	
	private Integer taskId;
	private String title;
	private String text;
	
	public TaskModel() {}
	
	public TaskModel(Integer taskId, String title, String text) {
		setTaskId(taskId);
		setTitle(title != null ? title : "Task #" + taskId);
		setText(text);
	}
	
	public Integer getTaskId() {
		return taskId;
	}
	public void setTaskId(Integer taskId) {
		this.taskId = taskId;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	
	@Override
	public String toString() {
		return "TaskModel [taskId=" + taskId + ", title=" + title + ", text=" + text + "]";
	}
}
