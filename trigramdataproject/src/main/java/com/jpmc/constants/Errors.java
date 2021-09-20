package com.jpmc.constants;

public enum Errors {

    INVALID_NUMBER_OF_WORDS("INVALID_NUMBER_OF_WORDS", "Invalid Number of words");

    private final String code;
    private final String message;

    Errors(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public String getCode() {
    	return code;
    }
    
    public String getMessage() {
    	return message;
    }

    @Override
    public String toString() {
        return "Errors{" +
                "errorCode='" + code + '\'' +
                ", errorMessage='" + message + '\'' +
                '}';
    }
}
