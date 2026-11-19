package com.meta.instagram.user.dto;

public record UserRegisterRequest(
        String userName,
        String userPassword,
        String bio
) {
}
