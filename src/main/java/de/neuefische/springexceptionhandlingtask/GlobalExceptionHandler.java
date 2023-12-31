package de.neuefische.springexceptionhandlingtask;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;
import java.util.NoSuchElementException;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(NoSuchElementException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ErrorMessage handleNoSuchElementException(NoSuchElementException exception) {
        LocalDateTime timestamp = LocalDateTime.now();
        return new ErrorMessage(exception.getMessage(), timestamp);
    }

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ErrorMessage handleUnexpectedError(Exception exception) {
        LocalDateTime timestamp = LocalDateTime.now();
        return new ErrorMessage("An unexpected error: " + exception.getMessage(), timestamp);
    }

}
