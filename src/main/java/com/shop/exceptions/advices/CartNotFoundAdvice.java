package com.shop.exceptions.advices;

import com.shop.domain.dto.ExceptionDTO;
import com.shop.exceptions.CartNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@ControllerAdvice
@RestController
public class CartNotFoundAdvice {

    @ExceptionHandler(CartNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    ExceptionDTO cartNotFoundHandler(CartNotFoundException ex) {
        ExceptionDTO exceptionDTO = new ExceptionDTO();
        exceptionDTO.setHttpStatus(HttpStatus.NOT_FOUND);
        exceptionDTO.setException_name(ex.getClass().getSimpleName());
        exceptionDTO.setMessage(ex.getMessage());
        return exceptionDTO;
    }



}
