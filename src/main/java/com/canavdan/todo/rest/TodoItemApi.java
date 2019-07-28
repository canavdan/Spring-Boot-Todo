package com.canavdan.todo.rest;

import com.canavdan.todo.domain.TodoItem;
import com.canavdan.todo.domain.TodoList;
import com.canavdan.todo.repository.TodoDepRepository;
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
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/todoitem")
@Slf4j
@CrossOrigin
public class TodoItemApi {

    @Autowired
    private ITodoItemService todoItemService;
    @Autowired
    private MapValidationError mapValidationError;
    @Autowired
    private TodoDepRepository todoDepRepository;

    @GetMapping("/all")
    public  ResponseEntity<?> getAllTodos(){
        List<TodoItem> todoItemList =todoItemService.findAllTodoItems();
        return new ResponseEntity<List<TodoItem>>(todoItemList,HttpStatus.OK);
    }
    @GetMapping("/{todoId}")
    public  ResponseEntity<?> getTodoById(@PathVariable Long todoId){
        TodoItem todoItem =todoItemService.findTodoItemById(todoId);
        if (todoItem == null) {
            return new ResponseEntity<TodoItem>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<TodoItem>(todoItem,HttpStatus.OK);
    }

    @PostMapping("")
    public ResponseEntity<?> createNewTodoItem(@Valid @RequestBody TodoItem todoItem, BindingResult result){
        ResponseEntity<?> errorMap = mapValidationError.MapValidationService(result);
        if(errorMap!=null) return errorMap;
        todoDepRepository.save(todoItem,getTodoById(todoItem.getId()));
        todoItemService.saveOrUpdateTodoItem(todoItem);
        return new ResponseEntity<TodoItem>(todoItem, HttpStatus.CREATED);
    }

    @DeleteMapping("/{todoItemId}")
    public ResponseEntity<?> deleteTodoItemById(@PathVariable Long todoItemId){
        if(todoDepRepository.getByTodoItem2Id(todoItemId) ==null)
            return new ResponseEntity<String>("To-Do list has dependency on another dependency",HttpStatus.NOT_FOUND);
        todoItemService.deleteTodoItem(todoItemId);
        return new ResponseEntity<String>("Todo Item with ID '"+ todoItemId +"' was deleted",HttpStatus.OK);
    }

    @GetMapping("/all/{todoListId}")
    public  ResponseEntity<?> findAllByTodoListId(@PathVariable Long todoListId){
        List<TodoItem> todoItem =todoItemService.findAllByTodoListId(todoListId);
        if (todoItem == null) {
            return new ResponseEntity<TodoList>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<List<TodoItem>>(todoItem,HttpStatus.OK);
    }

}
