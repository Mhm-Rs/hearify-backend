package com.rxhms.hearify.artist.dto;

import lombok.Builder;

@Builder
public record ArtistDto(Integer id, String name, String bio, String coverImage) {}
