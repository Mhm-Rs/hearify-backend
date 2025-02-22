package com.rxhms.hearify.album.business;

import lombok.Builder;

@Builder
public record AlbumSimplified(Integer id, String name, String albumCover, String artistName) {}
