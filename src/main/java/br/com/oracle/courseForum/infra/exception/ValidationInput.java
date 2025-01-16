package br.com.oracle.courseForum.infra.exception;

public class ValidationInput extends RuntimeException {
    public ValidationInput(String message) {
        super(message);
    }
}
