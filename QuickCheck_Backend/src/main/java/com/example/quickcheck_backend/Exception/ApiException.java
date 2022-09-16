package com.example.quickcheck_backend.Exception;

public class ApiException extends RuntimeException{
    public ApiException(String message) {
        super(message);
    }
}
