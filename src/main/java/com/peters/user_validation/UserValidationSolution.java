package com.peters.user_validation;


import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Pattern;

public class UserValidationSolution {
    public static void main(String[] args) {

        Scanner userInput = new Scanner(System.in);
        System.out.print("Enter Username: ");
        String username = userInput.nextLine();

        System.out.print("Enter Email: ");
        String email = userInput.nextLine();

        System.out.print("Enter Password: ");
        String password = userInput.nextLine();

        System.out.print("Enter Date of Birth (yyyy-MM-dd): ");
        String dateOfBirth = userInput.nextLine();

        ValidateUserInput returnBooleanValidationResult = validateUser(username, email, password, dateOfBirth);
        ValidateUserInput returnJWTToken = validateUserWithJwt(username, email, password, dateOfBirth);

        if (returnJWTToken.isValid()) {
            System.out.println(returnJWTToken);
        } else {
            System.out.println("Validation failed with the following errors:");
            System.out.println(returnJWTToken);
        }
        // Close the scanner when done
        userInput.close();
    }


    private static ValidateUserInput validateUser(String username, String email, String password, String dateOfBirth) {
        Map<String, String> validationErrors = new HashMap<>();

        // Username validation
        if (username.isEmpty() || username.length() < 4) {
            validationErrors.put("\nUsername", "not empty and minimum 4 characters");
        }

        // Email validation
        if (email.isEmpty() || !isValidEmail(email)) {
            validationErrors.put("\nEmail", "not empty and must be a valid email address");
        }

        // Password validation
        if (password.isEmpty() || !isValidPassword(password)) {
            validationErrors.put("\nPassword", "not empty and must be a strong password");
        }

        // Date of Birth validation
        if (dateOfBirth.isEmpty() || !isValidDateOfBirth(dateOfBirth)) {
            validationErrors.put("\nDate of Birth", "not empty and should be 16 years or greater");
        }

        if (validationErrors.isEmpty()) {
            return new ValidateUserInput(true, "Validation passed");
        } else {
            StringBuilder errorMessage = new StringBuilder();
            for (Map.Entry<String, String> entry : validationErrors.entrySet()) {
                errorMessage.append(entry.getKey()).append(": ").append(entry.getValue()).append(", ");
            }
            return new ValidateUserInput(false, errorMessage.substring(0, errorMessage.length() - 2));
        }
    }
    private static ValidateUserInput validateUserWithJwt(String username, String email, String password, String dateOfBirth) {
        Map<String, String> validationErrors = new HashMap<>();

        // Username validation
        if (username.isEmpty() || username.length() < 4) {
            validationErrors.put("\nUsername", "not empty and minimum 4 characters");
        }

        // Email validation
        if (email.isEmpty() || !isValidEmail(email)) {
            validationErrors.put("\nEmail", "not empty and must be a valid email address");
        }

        // Password validation
        if (password.isEmpty() || !isValidPassword(password)) {
            validationErrors.put("\nPassword", "not empty and must be a strong password");
        }

        // Date of Birth validation
        if (dateOfBirth.isEmpty() || !isValidDateOfBirth(dateOfBirth)) {
            validationErrors.put("\nDate of Birth", "not empty and should be 16 years or greater");
        }

        if (validationErrors.isEmpty()) {
            String jwt = generateJWT(username);
            return new ValidateUserInput(true, "Validation passed", jwt);
        } else {
            StringBuilder errorMessage = new StringBuilder();
            for (Map.Entry<String, String> entry : validationErrors.entrySet()) {
                errorMessage.append(entry.getKey()).append(": ").append(entry.getValue()).append(", ");
            }
            return new ValidateUserInput(false, errorMessage.substring(0, errorMessage.length() - 2), null);
        }
    }
    private static boolean isValidDateOfBirth(String dateOfBirth) {
        try {
            // Define the expected date format
            DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

            // Parse the date of birth using the specified format
            LocalDate dob = LocalDate.parse(dateOfBirth, dateFormatter);

            // Calculate the age based on the provided date of birth
            Period age = Period.between(dob, LocalDate.now());

            // Check if the age is at least 16 years or greater
            return age.getYears() >= 16;
        } catch (DateTimeParseException e) {
            // Handle parsing errors if the date format is invalid
            return false;
        }
    }

    private static boolean isValidPassword(String password) {
        // Password should have at least 1 upper case, 1 special character, 1 number, and be at least 8 characters long
        String passwordRegex = "^(?=.*[A-Z])(?=.*[!@#$%^&*])(?=.*[0-9]).{8,}$";
        return Pattern.compile(passwordRegex).matcher(password).matches();
    }

    private static boolean isValidEmail(String email) {
        String emailRegex = "^[A-Za-z0-9+_.-]+@(.+)$";
        return Pattern.compile(emailRegex).matcher(email).matches();
    }

    public static String generateJWT(String username) {
        Date now = new Date();
        Date expirationDate = new Date(now.getTime() + 3600000); // 1 hour expiration
        String secretKey = "secretsecretsecretsecretsecretsecretsecretsecretsecretsecretsecretsecretsecretsecretsecretsecretsecretsecretsecretsecret";

        return Jwts.builder()
                .setSubject(username)
                .setIssuedAt(now)
                .setExpiration(expirationDate)
                .signWith(SignatureAlgorithm.HS256, secretKey)
                .compact();
    }


}
