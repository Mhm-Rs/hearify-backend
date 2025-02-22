package com.rxhms.hearify.user.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Builder;

@Builder
public record UserCreationDto(
    @NotBlank(message = "Username cannot be empty") @Size(min = 3, max = 30, message = "Username must be between 3 and 30 characters") String username,
    @NotBlank(message = "Email cannot be empty") @Email(message = "Email should be valid") String email,
    @NotBlank(message = "Password cannot be empty") @Size(min = 8, message = "Password must be at least 8 characters long") @Pattern(
            regexp = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=]).{8,20}$",
            message =
                "Password must include a digit, an uppercase, a lowercase, and a special character")
        String passwordHash) {}
