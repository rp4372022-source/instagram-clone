package com.meta.instagram.user.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record UserRegisterRequest(
        @NotNull(message = "username cannot be null")
        @NotBlank(message = "username cannot be blank")
        String userName,
        @NotBlank(message = "password cannot be blank")
        @NotNull(message = "password cannot be null")
        String userPassword,
        @NotBlank(message = "bio cannot be blank")
        @NotNull(message = "bio cannot be null")
        String bio
) {
}
