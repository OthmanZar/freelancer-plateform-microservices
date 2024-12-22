package com.freelance.coins.handler;

import com.freelance.coins.exceptions.BusinessException;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;

import static org.springframework.http.HttpStatus.BAD_REQUEST;

@RestControllerAdvice
public class GlobalExceptionHandler {

   @ExceptionHandler(BusinessException.class)
   public ResponseEntity<String> handle(BusinessException exp) {
       return ResponseEntity
                .status(BAD_REQUEST)
                .body(exp.getMessage());
   }


    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorResponse> handleMethodArgumentNotValidException(MethodArgumentNotValidException exp) {
        var errors = new HashMap<String, String>();
        exp.getBindingResult().getAllErrors()
                .forEach(error -> {
                    var fieldName = ((FieldError) error).getField();
                    var errorMessage = error.getDefaultMessage();
                    errors.put(fieldName, errorMessage);
                });

        return ResponseEntity
                .status(BAD_REQUEST)
                .body(new ErrorResponse(errors));
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<String> handleHttpMessageNotReadableException(HttpMessageNotReadableException ex) {

        if (ex.getCause() != null && ex.getCause().getCause() != null &&
                ex.getCause().getCause() instanceof IllegalArgumentException) {

            String message = ex.getCause().getCause().getMessage();
            if (message.contains("not one of the values accepted for Enum class")) {
                return new ResponseEntity<>("Invalid experience type value. Accepted values are: Intermediate, Beginner, Advanced.", BAD_REQUEST);
            }
        }


        return new ResponseEntity<>("Invalid input. Please check your request data.", BAD_REQUEST);
    }
}
