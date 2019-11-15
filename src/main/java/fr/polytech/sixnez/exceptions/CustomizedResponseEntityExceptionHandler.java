package fr.polytech.sixnez.exceptions;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.Instant;
import java.util.Date;

@ControllerAdvice
@RestController
public class CustomizedResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(SNException.class)
    public final ResponseEntity<ErrorDetails>  handleDBException(SNException ex, WebRequest request) {
        ErrorDetails e = new ErrorDetails(Date.from(Instant.now()), ex.getSpecialCode(), ex.getMessage());
        return new ResponseEntity<ErrorDetails>(e, ex.getStatusCode());
    }
}
