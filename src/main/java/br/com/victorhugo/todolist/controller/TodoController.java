package br.com.victorhugo.todolist.controller;

import java.util.List;

import org.springframework.web.bind.annotation.RestController;

import br.com.victorhugo.todolist.entity.Todo;
import br.com.victorhugo.todolist.service.TodoService;

public class TodoController {
	
	private TodoService todoService; 
	
	public TodoController(TodoService todoService) {
		this.todoService = todoService;
	}

	@RestController("fdfdf")
	public List<Todo> create(Todo todo){
		return todoService.create(todo);
	}
	
	public List<Todo> list(){
		return todoService.list();
	}
		
	public List<Todo> update(Todo todo){
		return todoService.update(todo);
	}
	
	public List<Todo> delete(Long id){
		return todoService.delete(id);	
	}
	

}
