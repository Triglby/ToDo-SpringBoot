package com.qa.todo_springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.qa.todo_springboot.model.Todo;
import com.qa.todo_springboot.repository.TodoRepository;

@RestController
public class TodoController {

	@Autowired
	private TodoRepository todoRepository;
	
	//GET
	@RequestMapping(value = "api", method = RequestMethod.GET)
	public Iterable<Todo> list() {
		return todoRepository.findAll();
	}
	
	//POST
	@RequestMapping(value = "api", method = RequestMethod.POST)
	public String createTodo(@RequestBody Todo todo) {
		todoRepository.save(todo);
		return "added to list";
	}
	
	//PUT
	@RequestMapping(value = "api/{id}", method = RequestMethod.PUT)
	public String updateTodo(@PathVariable("id") long id) {
		Todo todo = todoRepository.findById(id).get();
		todo.setTaskDone(!todo.getTaskDone());
		todoRepository.save(todo);
		return "task updated";
	}
	
	//DELETE
	@RequestMapping(value = "api/{id}", method = RequestMethod.DELETE)
	public String deleteTodo(@PathVariable("id") long id) {
		todoRepository.deleteById(id);
		return "task deleted";
	}
	
}
