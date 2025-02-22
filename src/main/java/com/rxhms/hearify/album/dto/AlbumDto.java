package com.rxhms.hearify.album.dto;

import com.rxhms.hearify.artist.dto.ArtistDto;
import com.rxhms.hearify.track.dto.TrackForAlbumDto;
import java.time.LocalDate;
import java.util.List;
import lombok.Builder;

@Builder
public record AlbumDto(
    Integer id,
    String name,
    LocalDate releaseDate,
    ArtistDto artist,
    String cover,
    Integer saves,
    List<TrackForAlbumDto> tracks) {}
