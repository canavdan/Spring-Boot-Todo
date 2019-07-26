package com.canavdan.todo.service;

import com.canavdan.todo.domain.TodoItem;
import com.canavdan.todo.domain.TodoList;
import com.canavdan.todo.exception.ResourceNotFoundException;
import com.canavdan.todo.repository.TodoItemRepository;
import com.canavdan.todo.repository.TodoListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class TodoListService implements ITodoListService{
    @Autowired
    private TodoListRepository todoListRepository;

    @Override
    public TodoList saveOrUpdateTodoList(TodoList todoList) {
        return todoListRepository.save(todoList);
    }
    @Transactional(readOnly = true)
    @Override
    public List<TodoList> findAllTodoList() {
        return todoListRepository.findAll();
    }
    @Transactional(readOnly = true)
    @Override
    public Optional<TodoList> findTodoListById(Long id) {
        Optional<TodoList> todoList= todoListRepository.findById(id);
        if(todoList == null)
            throw new ResourceNotFoundException("To-Do List does not exist");
        return todoList;
    }


    @Override
    public void deleteTodoList(Long id) {
    todoListRepository.deleteById(id);
    }
}
