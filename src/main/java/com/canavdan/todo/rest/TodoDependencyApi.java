package com.canavdan.todo.rest;

import com.canavdan.todo.domain.TodoDependency;
import com.canavdan.todo.domain.TodoItem;
import com.canavdan.todo.repository.TodoDepRepository;
import com.canavdan.todo.service.ITodoItemService;
import com.canavdan.todo.validation.MapValidationError;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/v1/tododependency")
@Slf4j
public class TodoDependencyApi {

    @Autowired
    private TodoDepRepository todoDepRepository;
    @Autowired
    private MapValidationError mapValidationError;

    @PostMapping("")
    public ResponseEntity<?> addDependencyBetweenTodoItems(@Valid @RequestBody TodoDependency todoDependency, BindingResult result){
        ResponseEntity<?> errorMap = mapValidationError.MapValidationService(result);
        if(errorMap!=null) return errorMap;
        todoDepRepository.save(todoDependency);
        return new ResponseEntity<TodoDependency>(todoDependency, HttpStatus.CREATED);
    }
}
