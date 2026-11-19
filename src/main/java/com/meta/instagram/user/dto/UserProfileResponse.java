package com.meta.instagram.user.dto;

public record UserProfileResponse(
        String userName,
        String bio,
        Long followingCount,
        Long followersCount
) {}
