package com.maxima.avaliacao.handler;

import com.maxima.avaliacao.exceptions.DataAlreadyExistsException;
import com.maxima.avaliacao.exceptions.DataNotFoundException;
import com.maxima.avaliacao.exceptions.ExceptionResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.time.Instant;
import java.time.LocalDate;
import java.util.Date;

@ControllerAdvice
public class ResourceExceptionHandler {

    @ExceptionHandler(DataNotFoundException.class)
    public ResponseEntity<ExceptionResponse> dataNotFoundException(DataNotFoundException e, HttpServletRequest request) {
        String error = "Dado não encontrado";
        HttpStatus status = HttpStatus.NOT_FOUND;
        ExceptionResponse err = new ExceptionResponse(LocalDate.now(), error, e.getMessage(), request.getRequestURI());
        return ResponseEntity.status(status).body(err);
    }

    @ExceptionHandler(DataAlreadyExistsException.class)
    public ResponseEntity<ExceptionResponse> dataAlreadyExistsException(DataAlreadyExistsException e, HttpServletRequest request) {
        String error = "Dado já cadastrado";
        HttpStatus status = HttpStatus.BAD_REQUEST;
        ExceptionResponse err = new ExceptionResponse(LocalDate.now(), error, e.getMessage(), request.getRequestURI());
        return ResponseEntity.status(status).body(err);
    }
}
