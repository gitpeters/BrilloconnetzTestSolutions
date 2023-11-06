package com.peters.user_validation;

public class ValidateUserInput {
    private boolean isValid;
    private String message;
    private String jwt;

    public ValidateUserInput(boolean isValid, String message) {
        this.isValid = isValid;
        this.message = message;
    }

    public ValidateUserInput(boolean isValid, String message, String jwt) {
        this.isValid = isValid;
        this.message = message;
        this.jwt = jwt;
    }

    public boolean isValid() {
        return isValid;
    }

    public String getMessage() {
        return message;
    }

    public String getJwt() {
        return jwt;
    }

    @Override
    public String toString() {
        return "ValidateUserInput{" +
                "isValid=" + isValid +
                ", message='" + message + '\'' +
                ", jwt='" + jwt + '\'' +
                '}';
    }
}



