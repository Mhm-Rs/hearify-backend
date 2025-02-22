package com.rxhms.hearify.playlist.business;

import lombok.Builder;

@Builder
public record PlaylistSimplified(Integer id, String name, String userId, String playlistCover) {}
