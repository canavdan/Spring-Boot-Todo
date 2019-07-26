package com.canavdan.todo.repository;

import com.canavdan.todo.domain.TodoList;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TodoListRepository extends JpaRepository<TodoList,Long> {



}
