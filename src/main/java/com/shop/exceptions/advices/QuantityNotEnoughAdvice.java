package com.shop.exceptions.advices;


import com.shop.domain.dto.ExceptionDTO;
import com.shop.exceptions.QuantityNotEnoughException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class QuantityNotEnoughAdvice {

    @ResponseBody
    @ExceptionHandler({QuantityNotEnoughException.class})
    @ResponseStatus(HttpStatus.NOT_ACCEPTABLE)
    ExceptionDTO cartNotFoundHandler(QuantityNotEnoughException ex) {
        ExceptionDTO exceptionDTO = new ExceptionDTO();
        exceptionDTO.setHttpStatus(HttpStatus.NOT_ACCEPTABLE);
        exceptionDTO.setException_name(ex.getClass().getSimpleName());
        exceptionDTO.setMessage(ex.getMessage());
        return exceptionDTO;
    }
}
