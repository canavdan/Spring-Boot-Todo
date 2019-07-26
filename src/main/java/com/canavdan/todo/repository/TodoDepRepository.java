package com.canavdan.todo.repository;

import com.canavdan.todo.domain.TodoDependency;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TodoDepRepository  extends JpaRepository<TodoDependency,Long> {
}
