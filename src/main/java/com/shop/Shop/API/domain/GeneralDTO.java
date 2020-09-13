package com.shop.Shop.API.domain;

import org.springframework.http.HttpStatus;

public class GeneralDTO {
    private String message;
    private HttpStatus status;

    public GeneralDTO() {
    }

    public HttpStatus getStatus() {
        return status;
    }

    public void setHttpStatus(HttpStatus status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
