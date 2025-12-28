package br.com.victorhugo.todolist;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.webmvc.test.autoconfigure.AutoConfigureMockMvc;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import com.fasterxml.jackson.databind.ObjectMapper;
import br.com.victorhugo.todolist.entity.Todo;
import br.com.victorhugo.todolist.enums.TaskPriority;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
@ActiveProfiles("test")
class TodolistApplicationTests {

    @Autowired
    private MockMvc mockMvc;

    ObjectMapper objectMapper = new ObjectMapper();

    @Test
    void testeCreateTodoSuccess() throws Exception {
        Todo todo = new Todo("todo 1", "desc todo 1", TaskPriority.LOW);

        mockMvc.perform(
                post("/todos")
                    .contentType("application/json")
                    .content(objectMapper.writeValueAsString(todo))
            )
            .andExpect(status().isCreated())
            .andExpect(jsonPath("$").isArray())
            .andExpect(jsonPath("$.length()").value(1))
            .andExpect(jsonPath("$[0].name").value(todo.getName()))
            .andExpect(jsonPath("$[0].description").value(todo.getDescription()))
            .andExpect(jsonPath("$[0].priority").value(todo.getPriority().toString()));
    }

    @Test
    void testeCreateTodoFailure() throws Exception {
        Todo todo = new Todo("", "", TaskPriority.LOW);

        mockMvc.perform(
                post("/todos")
                    .contentType("application/json")
                    .content(objectMapper.writeValueAsString(todo))
            )
            .andExpect(status().isBadRequest());
    }
}
