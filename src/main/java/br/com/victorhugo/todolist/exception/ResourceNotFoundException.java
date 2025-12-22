package br.com.victorhugo.todolist.exception;

public class ResourceNotFoundException extends RuntimeException{

	private static final long serialVersionUID = 1L;

	//Objeto da requisição não existe
	public ResourceNotFoundException(String message) {
		super(message);
	}
	
}
