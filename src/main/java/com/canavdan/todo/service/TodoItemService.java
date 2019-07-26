package com.canavdan.todo.service;

import com.canavdan.todo.domain.TodoItem;
import com.canavdan.todo.exception.ResourceNotFoundException;
import com.canavdan.todo.repository.TodoItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class TodoItemService implements ITodoItemService {

    @Autowired
    private TodoItemRepository todoItemRepository;

    @Override
    @Transactional
    public TodoItem saveOrUpdateTodoItem(TodoItem todoItem) {
        return todoItemRepository.save(todoItem);
    }
    @Transactional( readOnly = true )
    @Override
    public List<TodoItem> findAllTodoItems() {
        return todoItemRepository.findAll();
    }
    @Transactional( readOnly = true )
    @Override
    public TodoItem findTodoItemById(Long id) {
    Optional<TodoItem> todoItem= todoItemRepository.findById(id);
        if(todoItem == null)
            throw new ResourceNotFoundException("To-Do Item does not exist");
        return todoItemRepository.getOne(id);
    }

    @Override
    public void deleteTodoItem(Long id) {
        todoItemRepository.deleteById(id);
    }
}
