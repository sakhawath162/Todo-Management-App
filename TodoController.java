package net.javaguides.springboot.controller;

import java.text.SimpleDateFormat;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import net.javaguides.springboot.model.Todo;
import net.javaguides.springboot.service.TodoService;

@Controller
public class TodoController {
	@Autowired
	private TodoService ts;
	
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));
	}
	
	@GetMapping("/")
	public String showTodo(Model model) {
		model.addAttribute("listOfTodo", ts.getAllTodo());
		return "index";
	}
	
	@PostMapping("/saveTodo")
	public String saveTodo(@ModelAttribute("todo") @Validated Todo todo, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
	         return "AddTodo";
	      }
		ts.saveTodo(todo);
		return "redirect:/";
	}
	
	@GetMapping("/showAddForm")
	public String showAddForm(Model model) {
		Todo todo = new Todo();
		model.addAttribute("todo", todo);
		return "AddTodo";
	}
	@GetMapping("/showUpdateForm/{id}")
	public String showUpdateForm(@PathVariable(value="id") int id,Model model) {
		Todo todo = ts.getTodoById(id);
		model.addAttribute("todo", todo);
		return "updateForm";
	}
	@GetMapping("/deleteTodo/{id}")
	public String deleteTodo(@PathVariable(value="id") int id) {
		Todo todo = ts.getTodoById(id);
		ts.deleteTOdo(todo);
		return "redirect:/";
	}

}
