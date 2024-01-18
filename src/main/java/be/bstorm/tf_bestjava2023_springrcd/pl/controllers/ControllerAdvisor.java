package be.bstorm.tf_bestjava2023_springrcd.pl.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ControllerAdvisor {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Object> handleException(Exception e){

        return ResponseEntity.badRequest().body(e.getMessage());
    }
}
