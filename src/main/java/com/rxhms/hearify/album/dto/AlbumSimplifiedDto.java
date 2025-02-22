package com.rxhms.hearify.album.dto;

import lombok.Builder;

@Builder
public record AlbumSimplifiedDto(Integer id, String name, String albumCover, String artistName) {}
