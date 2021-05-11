package com.javaSchool.eCare.config.domain;

public class NoSuchRoleException extends RuntimeException {
    public NoSuchRoleException(String message) {
        super(message);
    }
}
