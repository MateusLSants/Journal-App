package com.dev.backend.handler;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.dev.backend.exception.BadRequestException;
import com.dev.backend.exception.BadRequestExceptionDetails;
import com.dev.backend.exception.ValidationExceptionDetails;


@ControllerAdvice
public class RestExceptionHandler {
    @ExceptionHandler(BadRequestException.class)
    public ResponseEntity<BadRequestExceptionDetails> heandlerBadRequestException(BadRequestException badRequestException) {
        return new ResponseEntity<>(
            BadRequestExceptionDetails.builder()
                    .timeStamp(LocalDateTime.now())
                    .status(HttpStatus.BAD_REQUEST.value())
                    .title("Bad Request Exception, Check the documentation")
                    .details(badRequestException.getMessage())
                    .developerMessage(badRequestException.getClass().getName())
                    .build(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ValidationExceptionDetails> heandlerMethodArgumentNotValidException(MethodArgumentNotValidException exception) {
        List<FieldError> fieldsErrors = exception.getBindingResult().getFieldErrors();
        
        String fields = fieldsErrors.stream().map(FieldError::getField).collect(Collectors.joining(", "));
        String fieldMessage = fieldsErrors.stream().map(FieldError::getDefaultMessage).collect(Collectors.joining(", "));
        return new ResponseEntity<>(
            ValidationExceptionDetails.builder()
            .timeStamp(LocalDateTime.now())
            .status(HttpStatus.BAD_REQUEST.value())
            .title("Bad Request Exception, Invalid Fields")
            .details(exception.getMessage())
            .developerMessage(exception.getClass().getName())
            .fields(fields)
            .fieldsMessage(fieldMessage)
            .build(), HttpStatus.BAD_REQUEST);

    }
}
