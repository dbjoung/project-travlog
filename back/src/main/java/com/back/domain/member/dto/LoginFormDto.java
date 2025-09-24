package com.back.domain.member.dto;

import com.back.domain.member.entity.Member;
import jakarta.validation.constraints.NotBlank;

public record LoginFormDto (
        @NotBlank String email,
        @NotBlank String nickname,
        @NotBlank String password
) {
    public LoginFormDto(Member member) {
        this(member.getEmail(), member.getNickname(), member.getPassword());
    }
}

