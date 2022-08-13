package com.erick.dsmeta.exceptions;

public class SaleException extends RuntimeException {

    public SaleException(Throwable throwable) {
        super(throwable);
    }

    public SaleException(String msg) {
        super(msg);
    }

}
