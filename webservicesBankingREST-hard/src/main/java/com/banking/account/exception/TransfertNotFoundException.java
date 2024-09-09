package com.banking.account.exception;

import java.io.Serial;

public class TransfertNotFoundException extends RuntimeException{
    @Serial
    private static final long serialVersionUID = 2;

    public TransfertNotFoundException(String message){
        super(message);
    }
}
