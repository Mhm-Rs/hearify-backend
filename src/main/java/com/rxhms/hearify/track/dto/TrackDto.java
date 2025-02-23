package com.rxhms.hearify.track.dto;

import com.rxhms.hearify.artist.dto.ArtistDto;
import lombok.Builder;

@Builder
public record TrackDto(Integer id, String title, int duration, ArtistDto artist, String cover, String trackPlayUrl) {}
