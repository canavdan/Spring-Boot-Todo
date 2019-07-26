package com.canavdan.todo.rest;


import com.canavdan.todo.domain.TodoList;
import com.canavdan.todo.service.ITodoListService;
import com.canavdan.todo.validation.MapValidationError;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/todolist")
@Slf4j
public class TodoListApi {

    @Autowired
    private ITodoListService todoListService;
    @Autowired
    private MapValidationError mapValidationError;

    @GetMapping("/all")
    public ResponseEntity<?> getAllTodos(){
        List<TodoList> todoList =todoListService.findAllTodoList();
        return new ResponseEntity<List<TodoList>>(todoList, HttpStatus.OK);
    }
    @GetMapping("/{todoListId]")
    public  ResponseEntity<?> getTodoListById(@PathVariable Long id){
        Optional<TodoList> todoList =todoListService.findTodoListById(id);
        if (todoList == null) {
            return new ResponseEntity<TodoList>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<Optional<TodoList>>(todoList,HttpStatus.OK);
    }

    @PostMapping("")
    public ResponseEntity<?> createNewTodoList(@Valid @RequestBody TodoList todoList, BindingResult result){
        ResponseEntity<?> errorMap = mapValidationError.MapValidationService(result);
        if(errorMap!=null) return errorMap;
        todoListService.saveOrUpdateTodoList(todoList);
        return new ResponseEntity<TodoList>(todoList, HttpStatus.CREATED);
    }

    @DeleteMapping("/{todoListId]")
    public ResponseEntity<?> deleteTodoListById(@PathVariable Long id){
        todoListService.deleteTodoList(id);
        return new ResponseEntity<String>("Todo Item with ID '"+ id +"' was deleted",HttpStatus.OK);
    }
}
