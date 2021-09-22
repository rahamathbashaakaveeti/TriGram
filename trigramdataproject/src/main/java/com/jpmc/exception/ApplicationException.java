package com.jpmc.exception;

import com.jpmc.constants.Errors;

/*
 * @author Rahamath Basha Akaveeti
 * @Created 21/09/21
 */

public class ApplicationException extends RuntimeException{

    private String errorCode;
    private String errorMessage;

    public ApplicationException(String errorCode , String errorMessage){
        super(errorMessage);
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;

    }

    public ApplicationException(Errors error){
        super(error.getMessage());
        this.errorCode = error.getCode();
        this.errorMessage = error.getMessage();

    }

    public String getErrorCode() {
        return errorCode;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    @Override
    public String toString() {
        return "ApplicationException{" +
                "errorCode='" + errorCode + '\'' +
                ", errorMessage='" + errorMessage + '\'' +
                '}';
    }
}