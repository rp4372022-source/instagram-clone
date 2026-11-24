package com.meta.instagram.reel.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record AddNewReelRequest(
    @NotNull(message = "name cannot be null")
    @NotBlank(message = "name cannot be blank")
    String userName,
    @NotNull(message = "password cannot be blank")
    @NotBlank(message = "password cannot be blank")
    String password,
    String bio
) {
}
