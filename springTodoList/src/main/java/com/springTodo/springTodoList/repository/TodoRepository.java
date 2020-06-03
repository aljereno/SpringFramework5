package com.springTodo.springTodoList.repository;

import com.springTodo.springTodoList.model.TodoItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TodoRepository extends JpaRepository<TodoItem, Long> {
}
