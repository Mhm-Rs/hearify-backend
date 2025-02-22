package com.rxhms.hearify.track.dto;

import lombok.Builder;

@Builder
public record TrackForAlbumDto(Integer id, String title, int duration) {}
