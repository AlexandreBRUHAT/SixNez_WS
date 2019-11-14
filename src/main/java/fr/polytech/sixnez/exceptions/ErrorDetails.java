package fr.polytech.sixnez.exceptions;

import java.util.Date;

public class ErrorDetails {
    private Date timestamp;
    private int error;
    private String details;

    public ErrorDetails(Date timestamp, int error, String details) {
        super();
        this.timestamp = timestamp;
        this.error = error;
        this.details = details;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public int getError() {
        return error;
    }

    public String getDetails() {
        return details;
    }
}
