package com.project.appointment.utils.HandlerExceptions;

import com.project.appointment.persistence.CitaRepository;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;
@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {

    private final Log LOGGER = LogFactory.getLog(RestExceptionHandler.class);

    @ExceptionHandler
    protected ResponseEntity<ErrorResponse> handleException(NoSuchElementException exc){
        HttpStatus httpStatus = HttpStatus.BAD_REQUEST;
        LOGGER.info(exc.getStackTrace().toString());
        return buildResponseEntity(httpStatus, exc);
    }

    @ExceptionHandler
    protected ResponseEntity<ErrorResponse> handleException(DuplicateKeyException exc){
        HttpStatus httpStatus = HttpStatus.BAD_REQUEST;
        LOGGER.info(exc.getStackTrace().toString());
        return buildResponseEntity(httpStatus, exc);
    }

    @ExceptionHandler
    protected ResponseEntity<ErrorResponse> handleException(IllegalArgumentException exc){
        HttpStatus httpStatus = HttpStatus.BAD_REQUEST;
        LOGGER.info(exc.getStackTrace().toString());
        return buildResponseEntity(httpStatus, exc);
    }

    @ExceptionHandler
    protected ResponseEntity<ErrorResponse> handleException(InvalidDataException exc){
        HttpStatus httpStatus = HttpStatus.BAD_REQUEST;
        List<String> errors = exc.getResult().getFieldErrors().stream().map(FieldError::getDefaultMessage)
                .collect(Collectors.toList());
        LOGGER.info(exc.getStackTrace().toString());
        return buildResponseEntity(httpStatus, new RuntimeException("La data enviada es invalida"), errors);
    }

    @ExceptionHandler
    protected ResponseEntity<ErrorResponse> handleException(Exception exc){
        HttpStatus httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
        LOGGER.info(exc.getStackTrace().toString());
        return buildResponseEntity(httpStatus, new RuntimeException("Se presento un problema, intente mas tarde"));
    }

    private ResponseEntity<ErrorResponse> buildResponseEntity(HttpStatus httpStatus, Exception e){
        return buildResponseEntity(httpStatus, e, null);
    }
    private ResponseEntity<ErrorResponse> buildResponseEntity(HttpStatus httpStatus, Exception e, List<String> errors){
        ErrorResponse errorResponse = new ErrorResponse();
        errorResponse.setMessage(e.getMessage());
        errorResponse.setStatus(httpStatus.value());
        errorResponse.setTimeStamp(LocalDateTime.now());
        errorResponse.setErrors(errors);
        return new ResponseEntity<>(errorResponse, httpStatus);
    }
}
