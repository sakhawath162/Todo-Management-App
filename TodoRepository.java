package net.javaguides.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import net.javaguides.springboot.model.Todo;

@Repository
public interface TodoRepository extends JpaRepository<Todo, Integer>{
	

}
