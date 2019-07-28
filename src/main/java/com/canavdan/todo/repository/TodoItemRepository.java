package com.canavdan.todo.repository;

import com.canavdan.todo.domain.TodoItem;
import com.canavdan.todo.domain.TodoList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TodoItemRepository extends JpaRepository<TodoItem,Long> {
    List<TodoItem> findAllByTodoListId(Long id);
}
