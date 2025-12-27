package br.com.victorhugo.todolist.controller;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.victorhugo.todolist.entity.Todo;
import br.com.victorhugo.todolist.service.TodoService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/todos")
public class TodoController {
	
	private final TodoService todoService; 
	
	public TodoController(TodoService todoService) {
		this.todoService = todoService;
	}
	
	@PostMapping
	public ResponseEntity<List<Todo>> create(@RequestBody @Valid Todo todo){
		return ResponseEntity.status(HttpStatus.CREATED).body(todoService.create(todo));
	}
	
	@GetMapping
	public ResponseEntity<List<Todo>> list(){
		return ResponseEntity.ok(todoService.list());
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<List<Todo>> update(@PathVariable Long id, @RequestBody @Valid Todo todo){
		return ResponseEntity.ok(todoService.update(id, todo));
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<List<Todo>> delete(@PathVariable Long id){
		return ResponseEntity.ok(todoService.delete(id));
	}
}
