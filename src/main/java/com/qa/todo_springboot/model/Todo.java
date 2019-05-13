package com.qa.todo_springboot.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Todo {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private String taskDesc;
	private boolean taskDone;
	
	public Todo() {
		
	}
	
	public Todo(String taskDesc) {
		this.id = getId();
		this.taskDesc = taskDesc;
		this.taskDone = false;
	}

	public Long getId() {
		return id;
	}

	public String getTaskDesc() {
		return taskDesc;
	}

	public void setTaskDesc(String taskDesc) {
		this.taskDesc = taskDesc;
	}

	public boolean getTaskDone() {
		return taskDone;
	}

	public void setTaskDone(boolean taskDone) {
		this.taskDone = taskDone;
	}
}
