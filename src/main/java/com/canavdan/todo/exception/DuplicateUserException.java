package com.canavdan.todo.exception;

public class DuplicateUserException extends RuntimeException {

    private static final long serialVersionUID = -6391206997652962051L;


    public DuplicateUserException(String string) {
        super(string);
    }
}
