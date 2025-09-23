package com.back.domain.member.dto;

import jakarta.validation.constraints.NotBlank;

public class LoginFormDto {
    @NotBlank
    private String email;
    @NotBlank
    private String nickname;
    @NotBlank
    private String password;
}
