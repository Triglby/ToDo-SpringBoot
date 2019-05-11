package com.qa.todo_springboot.repository;

import org.springframework.data.repository.CrudRepository;

import com.qa.todo_springboot.model.Todo;

public interface TodoRepository extends CrudRepository<Todo, Long>{

}
