package org.africa.semicolon.exceptions;

public class UsernameOrTaskNameNotFoundException extends RuntimeException{
    public UsernameOrTaskNameNotFoundException(String message) {
        super(message);
    }
}
