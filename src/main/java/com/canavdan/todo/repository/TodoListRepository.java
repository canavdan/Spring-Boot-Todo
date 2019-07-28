package com.canavdan.todo.repository;

import com.canavdan.todo.domain.TodoList;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface TodoListRepository extends JpaRepository<TodoList,Long> {


    List<TodoList> findAllByMemberId(Long id);
}
