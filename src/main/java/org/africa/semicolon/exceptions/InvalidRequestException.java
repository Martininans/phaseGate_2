package org.africa.semicolon.exceptions;

public class InvalidRequestException extends RuntimeException {
    public InvalidRequestException(String invalidRequest) {super(invalidRequest);
    }
}
