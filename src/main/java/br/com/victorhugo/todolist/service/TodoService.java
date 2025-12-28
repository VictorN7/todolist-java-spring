package br.com.victorhugo.todolist.service;
import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.victorhugo.todolist.entity.Todo;
import br.com.victorhugo.todolist.exception.ResourceNotFoundException;
import br.com.victorhugo.todolist.repository.TodoRepository;

@Transactional
@Service
public class TodoService {
	
	private final TodoRepository todoRepository;
	
	public TodoService(TodoRepository todoRepository) {
		this.todoRepository = todoRepository;
	}

	public List<Todo> create(Todo todo){
		todoRepository.save(todo);
		return list();
	}
	
	public List<Todo> list(){ 
		Sort sort = Sort.by("priority").descending().and(Sort.by("name").ascending());
		return todoRepository.findAll(sort); 
	}
	
	public List<Todo> update(Long id, Todo todo){
		
		Todo entity = findByIdOrThrow(id);
		
		entity.setName(todo.getName());
		entity.setPriority(todo.getPriority());
		entity.setDescription(todo.getDescription());
		entity.setStatus(todo.getStatus());
		
		todoRepository.save(entity);
		return list();
	}
	
	public List<Todo> delete(Long id){
		
		Todo entity = findByIdOrThrow(id);
		todoRepository.delete(entity);
		return list();		
	}
	
	private Todo findByIdOrThrow(Long id) {
		
		Todo entity = todoRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Todo id "+id+" não foi encontrado"));
		return entity;
	}
}