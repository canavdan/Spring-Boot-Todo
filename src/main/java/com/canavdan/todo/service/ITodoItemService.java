package com.canavdan.todo.service;

import com.canavdan.todo.domain.TodoItem;
import com.canavdan.todo.domain.TodoList;

import java.util.List;
import java.util.Optional;

public interface ITodoItemService {
    TodoItem saveOrUpdateTodoItem(TodoItem todoItem);
    List<TodoItem> findAllTodoItems();
    TodoItem findTodoItemById(Long id);
    void deleteTodoItem(Long id);
    List<TodoItem> findAllByTodoListId(Long id);
}
