package com.rxhms.hearify.user.business;

import lombok.Builder;

@Builder
public record UserAuthentication(String username, String passwordHash) {}
