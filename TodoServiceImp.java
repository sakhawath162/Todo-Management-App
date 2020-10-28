package net.javaguides.springboot.service;



import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;


import net.javaguides.springboot.model.Todo;
import net.javaguides.springboot.repository.TodoRepository;

@Service
public class TodoServiceImp implements TodoService {
	@Autowired
	private TodoRepository tr;

	@Override
	public void saveTodo(Todo todo) {
		tr.save(todo);
	}

	@Override
	public List<Todo> getAllTodo() {
		return tr.findAll();
	}

	@Override
	public Todo getTodoById(int id) {
		Optional<Todo> optional = tr.findById(id);
		Todo todo = null;
		if(optional.isPresent()){
			todo = optional.get();
		}else {
			throw new RuntimeException("No users found for id: " + id);
		}
		return todo;
		
	}

	@Override
	public void deleteTOdo(Todo todo) {
		tr.delete(todo);
		
	}
	
}



