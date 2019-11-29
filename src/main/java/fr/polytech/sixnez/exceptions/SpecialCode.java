package fr.polytech.sixnez.exceptions;

public enum SpecialCode {

    LOGIN_BAD_CREDENTIALS(0),
    LOGIN_USERNAME_ALREADY_EXISTS(1),
    FILM_NOT_FOUND(20),
    ACTOR_NOT_FOUND(30);

    private int value;

    private SpecialCode(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
