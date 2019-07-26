package com.canavdan.todo.service;



import com.canavdan.todo.domain.TodoList;

import java.util.List;
import java.util.Optional;

public interface ITodoListService {

    TodoList saveOrUpdateTodoList(TodoList todoList);
    List<TodoList> findAllTodoList();
    Optional<TodoList> findTodoListById(Long id);
    void deleteTodoList(Long id);
}
