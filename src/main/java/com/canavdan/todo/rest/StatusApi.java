package com.canavdan.todo.rest;

import com.canavdan.todo.domain.Status;
import com.canavdan.todo.repository.StatusRepository;

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
@RequestMapping("/api/v1/status")
@Slf4j
public class StatusApi {

    @Autowired
    private StatusRepository statusRepository;
    @Autowired
    private MapValidationError mapValidationError;

    @PostMapping("")
    public ResponseEntity<?> createNewStatus(@Valid @RequestBody Status status , BindingResult result){
        ResponseEntity<?> errorMap = mapValidationError.MapValidationService(result);
        if(errorMap!=null) return errorMap;
        statusRepository.save(status);
        return new ResponseEntity<Status>(status, HttpStatus.CREATED);
    }
}
