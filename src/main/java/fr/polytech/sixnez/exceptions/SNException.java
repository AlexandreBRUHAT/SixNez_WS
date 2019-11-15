package fr.polytech.sixnez.exceptions;

import org.springframework.http.HttpStatus;

public class SNException extends RuntimeException {

    private HttpStatus statusCode;
    private SpecialCode specialCode;

    public SNException(String error, HttpStatus statusCode, SpecialCode code) {
        super(error);
        this.statusCode = statusCode;
        this.specialCode = code;
    }

    public HttpStatus getStatusCode() {
        return statusCode;
    }

    public SpecialCode getSpecialCode() {
        return specialCode;
    }
}
