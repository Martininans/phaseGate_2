package org.africa.semicolon.exceptions;

public class IncorrectUsernameOrPasswordException extends RuntimeException {

    public IncorrectUsernameOrPasswordException(String message) {
        super(message);
    }
}
