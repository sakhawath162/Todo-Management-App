package net.javaguides.springboot.service;

import java.util.List;

import org.springframework.stereotype.Service;

import net.javaguides.springboot.model.Todo;


@Service
public interface TodoService {
	void saveTodo(Todo todo);
	List<Todo> getAllTodo();
	Todo getTodoById(int id);
	void deleteTOdo(Todo todo);
}
