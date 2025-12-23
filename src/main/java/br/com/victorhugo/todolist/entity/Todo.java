package br.com.victorhugo.todolist.entity;

import br.com.victorhugo.todolist.enums.TaskPriority;
import br.com.victorhugo.todolist.enums.TaskStatus;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
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
	
	@Enumerated(EnumType.STRING)
	@Column(nullable = false)
	private TaskStatus status;

	@Enumerated(EnumType.STRING)
	@Column(nullable = false)
	private TaskPriority priority;
	
	public Todo() {}
	
	public Todo(String name, String description, TaskPriority priority) {
		this.name = name;
		this.description = description;
		this.status = TaskStatus.PENDING;
		this.priority = priority;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setStatus(TaskStatus status) {
		this.status = status;
	}

	public void setPriority(TaskPriority priority) {
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

	public TaskStatus getStatus() {
		return status;
	}

	public TaskPriority getPriority() {
		return priority;
	}
}
