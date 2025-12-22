package br.com.victorhugo.todolist.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
@Table(name ="todos")
public class Todo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id; 
	
	@NotBlank
	@Size(max = 100)
	private String name;

	@NotBlank
	@Size(max = 255)
	private String description; 
	
	private Boolean completed;
	
	@Min(1)
	@Max(3)
	private Integer priority;
	
	public Todo() {}
	
	public Todo(String name, String description, Boolean completed, Integer priority) {
		this.name = name;
		this.description = description;
		this.completed = completed;
		this.priority = priority;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setCompleted(Boolean completed) {
		this.completed = completed;
	}

	public void setPriority(Integer priority) {
		this.priority = priority;
	}

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getDescription() {
		return description;
	}

	public Boolean getCompleted() {
		return completed;
	}

	public Integer getPriority() {
		return priority;
	}
}
