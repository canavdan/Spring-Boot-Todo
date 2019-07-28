package com.canavdan.todo.repository;

import com.canavdan.todo.domain.TodoDependency;
import com.canavdan.todo.domain.TodoItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TodoDepRepository  extends JpaRepository<TodoDependency,Long> {
    TodoItem getByTodoItem2Id(Long id);

}
