package br.com.victorhugo.todolist;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.web.reactive.server.WebTestClient;


import br.com.victorhugo.todolist.entity.Todo;
import br.com.victorhugo.todolist.enums.TaskPriority;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
class TodolistApplicationTests {

	@Autowired
	private WebTestClient webTestClient;
	
	
	@Test
	void testeCreatTodoSucess() {
		var todo = new Todo("todo 1", "desc todo 1", TaskPriority.LOW);
		
		webTestClient.post().uri("/todos").bodyValue(todo).exchange()
		.expectStatus().isOk().expectBody().jsonPath("$").isArray()
		.jsonPath("$.length()").isEqualTo(1) 
		.jsonPath("$[0].name").isEqualTo(todo.getName())
		.jsonPath("$[0].description").isEqualTo(todo.getDescription())
		.jsonPath("$[0].completed").isEqualTo(todo.getStatus())
		.jsonPath("$[0].priority").isEqualTo(todo.getPriority());
		
	}
	
	@Test
	void testeCreatTodoFailure() {
		
		webTestClient
			.post()
			.uri("/todos")
			.bodyValue(new Todo("","", TaskPriority.LOW))
			.exchange()
			.expectStatus().isBadRequest();
	}

}
