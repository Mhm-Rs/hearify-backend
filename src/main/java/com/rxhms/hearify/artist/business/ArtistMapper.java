package com.rxhms.hearify.artist.business;

import com.rxhms.hearify.artist.dto.ArtistDto;
import org.springframework.stereotype.Component;

@Component
public class ArtistMapper {

  public ArtistDto toArtistDto(Artist artist) {
    return ArtistDto.builder()
        .id(artist.getId())
        .name(artist.getName())
        .bio(artist.getBio())
        .coverImage(artist.getCoverImage())
        .build();
  }
}
