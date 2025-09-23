package com.back.domain.post.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;

@Getter
public class PostWriteDto {
    @NotBlank
    private String title;
    @NotBlank
    private String description;
}
