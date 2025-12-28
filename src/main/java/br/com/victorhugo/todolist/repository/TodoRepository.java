package br.com.victorhugo.todolist.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.victorhugo.todolist.entity.Todo;

public interface TodoRepository extends JpaRepository<Todo, Long>{
	
}
