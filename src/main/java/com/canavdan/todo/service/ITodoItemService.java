package com.canavdan.todo.service;

import com.canavdan.todo.domain.TodoItem;

import java.util.List;

public interface ITodoItemService {
    TodoItem saveOrUpdateTodoItem(TodoItem todoItem);
    List<TodoItem> findAllTodoItems();
    TodoItem findTodoItemById(Long id);
    void deleteTodoItem(Long id);
}
