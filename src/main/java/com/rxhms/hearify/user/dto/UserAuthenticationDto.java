package com.rxhms.hearify.user.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Builder;

@Builder
public record UserAuthenticationDto(@NotBlank (message = "Username cannot be empty")
                               @Size(min = 3, max = 30, message = "Username must be between 3 and 30 characters")
                               String username,


                                    @NotBlank(message = "Password hash cannot be empty")
                               @Size(min = 8, message = "Password hash must be at least 8 characters long")
                               String passwordHash) {}
