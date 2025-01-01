package com.rxhms.hearify.favorite.dto;

import com.rxhms.hearify.track.dto.TrackDto;
import lombok.Builder;

@Builder
public record FavoriteDto(TrackDto track) {}
