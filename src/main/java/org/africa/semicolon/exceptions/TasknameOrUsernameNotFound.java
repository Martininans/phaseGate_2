package org.africa.semicolon.exceptions;

public class TasknameOrUsernameNotFound extends RuntimeException{
    public TasknameOrUsernameNotFound(String message) {
        super(message);
    }
}
