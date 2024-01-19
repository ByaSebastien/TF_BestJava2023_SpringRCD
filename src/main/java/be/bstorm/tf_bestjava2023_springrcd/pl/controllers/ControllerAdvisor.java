package be.bstorm.tf_bestjava2023_springrcd.pl.controllers;

import be.bstorm.tf_bestjava2023_springrcd.bll.exceptions.user.UserEmailAlreadyExistException;
import be.bstorm.tf_bestjava2023_springrcd.bll.exceptions.user.UserException;
import be.bstorm.tf_bestjava2023_springrcd.bll.exceptions.user.UserNotFoundException;
import be.bstorm.tf_bestjava2023_springrcd.bll.exceptions.user.UserPasswordException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.List;

@Slf4j
@ControllerAdvice
public class ControllerAdvisor {

    @ExceptionHandler({UserEmailAlreadyExistException.class, UserPasswordException.class})
    public ResponseEntity<String> handleUserEmailAlreadyExistException(UserException e) {
        log.warn(e.toString());
        return ResponseEntity.status(406).body(e.getMessage());
    }

    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<String> handleUserNotFoundException(UserNotFoundException e) {
        log.warn(e.toString());
        return ResponseEntity.status(404).body(e.getMessage());
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<List<String>> hangleMethodArgumentNotValidException(MethodArgumentNotValidException e) {
        List<String> errors =
                e.getBindingResult().getAllErrors()
                        .stream().map(DefaultMessageSourceResolvable::getDefaultMessage)
                        .distinct().toList();
        return ResponseEntity.status(406).body(errors);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Object> handleException(Exception e) {
        log.error(e.toString());
        return ResponseEntity.badRequest().body(e);
    }

}
