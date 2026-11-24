package com.meta.instagram.reel.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record AddNewReelRequest(
    @NotNull(message = "name cannot be null")
    @NotBlank(message = "name cannot be blank")
    String userName,
    @NotNull(message = "caption cannot be blank")
    @NotBlank(message = "caption cannot be blank")
    String caption
) {
}
