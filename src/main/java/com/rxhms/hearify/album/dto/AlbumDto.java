package com.rxhms.hearify.album.dto;

import com.rxhms.hearify.artist.dto.ArtistDto;
import java.time.LocalDate;
import lombok.Builder;

@Builder
public record AlbumDto(
    Integer id, String name, LocalDate releaseDate, ArtistDto artist, String coverImage) {}
