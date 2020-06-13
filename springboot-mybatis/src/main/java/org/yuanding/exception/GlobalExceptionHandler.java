package org.yuanding.exception;

import org.springframework.dao.DuplicateKeyException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;


@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(value = DuplicateKeyException.class)
    public ResponseEntity<Object> DuplicateKeyExceptionHandler(WebRequest request, Exception ex) {
        return this.handleException(HttpStatus.INTERNAL_SERVER_ERROR, Error.USER_EMAIL_EXISTS, request,ex);
    }

    @ExceptionHandler(value = Exception.class)
    public ResponseEntity<Object> OtherExceptionHandler(WebRequest request, Exception ex) {
        return handleException(HttpStatus.INTERNAL_SERVER_ERROR, Error.SERVER_INTERVAL_ERROR, request, ex);
    }


    private ResponseEntity<Object> handleException(Error error, WebRequest request, Exception ex) {
        return this.handleException(HttpStatus.OK, error, request, ex);
    }

    private ResponseEntity<Object> handleException(HttpStatus status, Error error, WebRequest request, Exception ex) {
        HttpHeaders headers = new HttpHeaders();
        return handleExceptionInternal(ex, error, headers, status, request);
    }
}

