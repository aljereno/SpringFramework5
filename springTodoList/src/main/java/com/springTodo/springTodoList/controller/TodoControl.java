package com.springTodo.springTodoList.controller;

import com.springTodo.springTodoList.model.TodoItem;
import com.springTodo.springTodoList.repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;


//Creates a rest endpoint
@RestController
@RequestMapping(value ="/todo")
public class TodoControl{

  @Autowired
  private TodoRepository todoRepo;

  @GetMapping
  public List<TodoItem> findAll(){
    return todoRepo.findAll();
  }

  @PostMapping
  public TodoItem save(@Valid @NotNull @RequestBody TodoItem todoItem){
    return todoRepo.save(todoItem);
  }

  @PutMapping
  public TodoItem update(@Valid @NotNull @RequestBody TodoItem todoItem){
    return todoRepo.save(todoItem);
  }

  @DeleteMapping(value = "/{id}")
  public void delete(@PathVariable Long id){
    todoRepo.deleteById(id);
  }

}
