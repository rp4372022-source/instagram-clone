package com.meta.instagram.user.dto;

public record UserProfileResponse(
        long id,
        String userName,
        String bio,
        Long followingCount,
        Long followersCount
) {}
