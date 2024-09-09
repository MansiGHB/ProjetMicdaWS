package com.banking.account.exception;

import java.io.Serial;

public class BalanceNotFoundException extends RuntimeException{
    @Serial
    private static final long serialVersionUID = 1;

    public BalanceNotFoundException(String message){
        super(message);
    }
}
