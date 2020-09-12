package com.shop.Shop.API.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class CartNotFoundAdvice {

    @ResponseBody
    @ExceptionHandler({CartNotFoundException.class})
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String cartNotFoundHandler(CartNotFoundException ex){
        return ex.getMessage();
    }

}
