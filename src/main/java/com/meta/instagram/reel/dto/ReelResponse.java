package com.meta.instagram.reel.dto;

public record ReelResponse(
        String userName,
        String reelCaption,
        String reelURL,
        Long likesCount
) {
}
