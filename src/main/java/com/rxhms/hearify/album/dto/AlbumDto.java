package com.rxhms.hearify.album.dto;

import com.rxhms.hearify.artist.dto.ArtistDto;
import lombok.Builder;

import java.time.LocalDate;

@Builder
public record AlbumDto(Integer id, String name, LocalDate releaseDate, ArtistDto artist, String coverImage) {}
