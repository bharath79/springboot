package com.vinay.microservice.exception;

import com.vinay.microservice.model.ExceptionMessage;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class RestResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

//  Custom Exception
    @ExceptionHandler(EmployeeNotFoundException.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ExceptionMessage employeeNotFoundException(EmployeeNotFoundException exception) {
        ExceptionMessage exceptionMessage = new ExceptionMessage(HttpStatus.NOT_FOUND, exception.getMessage());
        return exceptionMessage;
    }

    //    Generic Exception
    @ExceptionHandler(Exception.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ExceptionMessage genericExceptionHandler(Exception exception) {
        ExceptionMessage exceptionMessage = new ExceptionMessage(HttpStatus.INTERNAL_SERVER_ERROR, exception.getMessage());
        return exceptionMessage;
    }
}
