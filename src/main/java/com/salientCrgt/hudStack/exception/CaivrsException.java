package com.salientCrgt.hudStack.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value=HttpStatus.BAD_REQUEST)
public class CaivrsException extends RuntimeException{

    private static final long serialVersionUID = 1L;

    public CaivrsException(String msg) {
        super(msg);
    }

    public CaivrsException(String msg, Throwable t) {
        super(msg, t);
    }
}
