package com.dillo.hireme.exceptions;

public class UserNotFoundException extends RuntimeException {
    private final Long id;
    public UserNotFoundException(Long id) {
        super("User not found with ID: " + id);
        this.id = id;
    }

    public Long getId() {
        return id;
    }

}