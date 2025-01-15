package br.com.oracle.courseForum.infra.exception;

import org.apache.coyote.BadRequestException;

public class ValidationInput extends RuntimeException {
    public ValidationInput(String message) {
        super(message);
    }
}
