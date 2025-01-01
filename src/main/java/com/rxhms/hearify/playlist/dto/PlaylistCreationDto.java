package com.rxhms.hearify.playlist.dto;

import jakarta.validation.constraints.*;
import lombok.Builder;

@Builder
public record PlaylistCreationDto(@NotBlank (message = "Name cannot be empty")
                               @Size(min = 1, max = 50, message = "Name must be between 1 and 50 characters")
                               String name, @NotNull(message = "UserId cannot be null") Integer userId) {}
