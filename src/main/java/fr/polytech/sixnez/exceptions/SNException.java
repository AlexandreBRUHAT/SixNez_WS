package fr.polytech.sixnez.exceptions;

import org.springframework.http.HttpStatus;

public class SNException extends RuntimeException {

    private HttpStatus statusCode;
    private int detailledCode;

    public SNException(String error, HttpStatus statusCode, int detailledCode) {
        super(error);
        this.statusCode = statusCode;
        this.detailledCode = detailledCode;
    }

    public HttpStatus getStatusCode() {
        return statusCode;
    }

    public int getDetailledCode() {
        return detailledCode;
    }
}
