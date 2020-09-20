package com.shop.domain.dto;

import org.springframework.http.HttpStatus;

public class ExceptionDTO {
    private String exception_name;
    private String message;
    private HttpStatus status;

    public ExceptionDTO() {
    }

    public HttpStatus getStatus() {
        return status;
    }

    public void setHttpStatus(HttpStatus status) {
        this.status = status;
    }

    public String getException_name() {
        return exception_name;
    }

    public void setException_name(String exceptionName) {
        this.exception_name = exceptionName;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
