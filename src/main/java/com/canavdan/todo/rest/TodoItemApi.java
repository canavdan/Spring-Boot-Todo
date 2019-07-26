package com.canavdan.todo.rest;

import com.canavdan.todo.domain.TodoItem;
import com.canavdan.todo.service.ITodoItemService;
import com.canavdan.todo.validation.MapValidationError;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v1/todoitem")
@Slf4j
public class TodoItemApi {

    @Autowired
    private ITodoItemService todoItemService;
    @Autowired
    private MapValidationError mapValidationError;


    @GetMapping("/all")
    public  ResponseEntity<?> getAllTodos(){
        List<TodoItem> todoItemList =todoItemService.findAllTodoItems();
        return new ResponseEntity<List<TodoItem>>(todoItemList,HttpStatus.OK);
    }
    @GetMapping("/{todoId]")
    public  ResponseEntity<?> getTodoById(@PathVariable Long id){
        TodoItem todoItem =todoItemService.findTodoItemById(id);
        if (todoItem == null) {
            return new ResponseEntity<TodoItem>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<TodoItem>(todoItem,HttpStatus.OK);
    }

    @PostMapping("")
    public ResponseEntity<?> createNewTodoItem(@Valid @RequestBody TodoItem todoItem, BindingResult result){
        ResponseEntity<?> errorMap = mapValidationError.MapValidationService(result);
        if(errorMap!=null) return errorMap;
        todoItemService.saveOrUpdateTodoItem(todoItem);
        return new ResponseEntity<TodoItem>(todoItem, HttpStatus.CREATED);
    }

    @DeleteMapping("/{todoItemId]")
    public ResponseEntity<?> deleteTodoItemById(@PathVariable Long id){
        todoItemService.deleteTodoItem(id);
        return new ResponseEntity<String>("Todo Item with ID '"+ id +"' was deleted",HttpStatus.OK);
    }




}
