package com.parkinglot.exceptions;

public class NoAvailablePositionException extends RuntimeException {

    @Override
    public String getMessage() {
        return "No available position.";
    }
}
