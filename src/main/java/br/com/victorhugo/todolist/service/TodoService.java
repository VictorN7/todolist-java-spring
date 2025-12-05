package br.com.victorhugo.todolist.service;
import java.util.List;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import br.com.victorhugo.todolist.entity.Todo;
import br.com.victorhugo.todolist.repository.TodoRepository;

@Service
public class TodoService {
	
	private TodoRepository todoRepository;
	
	public TodoService(TodoRepository todoRepository) {
		this.todoRepository = todoRepository;
	}

	@PostMapping
	public List<Todo> create(@RequestBody Todo todo){
		todoRepository.save(todo);
		return list();
	}
	
	@GetMapping
	public List<Todo> list(){
		Sort sort = Sort.by("prioridade").descending().and(Sort.by("nome").ascending());
		return todoRepository.findAll(sort);
	}
	
	@PutMapping
	public List<Todo> update(@RequestBody Todo todo){
		todoRepository.save(todo);
		return list();
	}
	
	@DeleteMapping("{id}")
	public List<Todo> delete(@PathVariable("id") Long id){
		todoRepository.deleteById(id);;
		return list();		
	}
}