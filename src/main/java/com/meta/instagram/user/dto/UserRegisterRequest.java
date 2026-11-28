package com.meta.instagram.user.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record UserRegisterRequest(
        @NotNull(message = "username cannot be null")
        @NotBlank(message = "username cannot be blank")
        String userName,
        @NotBlank(message = "password cannot be blank")
        @NotNull(message = "password cannot be null")
        String userPassword,
        @Size(max = 150, message = "bio cannot exceed 150 characters") //instagram standard
        String bio
) {
}
