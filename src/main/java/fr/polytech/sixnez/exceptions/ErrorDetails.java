package fr.polytech.sixnez.exceptions;

import java.util.Date;

public class ErrorDetails {
    private Date timestamp;
    private int code;
    private String details;

    public ErrorDetails(Date timestamp, SpecialCode code, String details) {
        super();
        this.timestamp = timestamp;
        this.code = code.getValue();
        this.details = details;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public int getSpecialCode() {
        return code;
    }

    public String getDetails() {
        return details;
    }
}
