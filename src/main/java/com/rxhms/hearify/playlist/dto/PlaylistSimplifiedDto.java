package com.rxhms.hearify.playlist.dto;

import lombok.Builder;

@Builder
public record PlaylistSimplifiedDto(Integer id, String name, String userId, String playlistCover) {}
