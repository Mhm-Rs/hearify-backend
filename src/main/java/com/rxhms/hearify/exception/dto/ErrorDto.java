package com.rxhms.hearify.exception.dto;

import lombok.Builder;

@Builder
public record ErrorDto(String error, String errorDescription) {}
