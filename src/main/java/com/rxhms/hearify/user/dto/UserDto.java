package com.rxhms.hearify.user.dto;

import lombok.Builder;

@Builder
public record UserDto(Integer id, String username, String email) {}
