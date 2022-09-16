package com.example.quickcheck_backend.Advice;

import com.example.quickcheck_backend.DTO.ApiResponse;
import com.example.quickcheck_backend.Exception.ApiException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;

public class ControllersAdvise {

    @ExceptionHandler(value = ApiException.class)
    public ResponseEntity apiException(ApiException apiException){
        return ResponseEntity.status(400).body(new ApiResponse(apiException.getMessage(),400));
    }

    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    public ResponseEntity methodArgumentNotValidException(MethodArgumentNotValidException methodArgumentNotValidException){
        String message=methodArgumentNotValidException.getFieldError().getDefaultMessage();
        return ResponseEntity.status(400).body(new ApiResponse(message,400));
    }

    @ExceptionHandler(value = DataIntegrityViolationException.class)
    public ResponseEntity dataIntegrityViolation(DataIntegrityViolationException dataIntegrityViolationException){
        String message=dataIntegrityViolationException.getRootCause().getMessage();
        return ResponseEntity.status(400).body(new ApiResponse(message,400));
    }

    @ExceptionHandler(value = HttpRequestMethodNotSupportedException.class)
    public ResponseEntity httpRequestMethodNotSupported(HttpRequestMethodNotSupportedException error){
        return ResponseEntity.status(400).body(new ApiResponse(error.getMessage(),400));
    }

    @ExceptionHandler(value = Exception.class)
    public ResponseEntity exception(Exception exception){
        exception.printStackTrace();
        return ResponseEntity.status(500).body(new ApiResponse("Server Error",500));
    }
}
