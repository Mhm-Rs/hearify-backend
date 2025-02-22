package com.rxhms.hearify.artist.business;

import com.rxhms.hearify.artist.dto.ArtistDto;
import java.util.List;
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

  public List<ArtistDto> toArtistDtoList(List<Artist> artists) {
    return artists.stream().map(this::toArtistDto).toList();
  }
}
