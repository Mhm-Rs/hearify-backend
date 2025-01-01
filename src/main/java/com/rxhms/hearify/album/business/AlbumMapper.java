package com.rxhms.hearify.album.business;

import com.rxhms.hearify.album.dto.AlbumDto;
import com.rxhms.hearify.artist.business.ArtistMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class AlbumMapper {

  private final ArtistMapper artistMapper;

  public AlbumDto toAlbumDto(Album album) {
    return AlbumDto.builder()
        .id(album.getId())
        .name(album.getName())
        .coverImage(album.getCoverImage())
        .artist(artistMapper.toArtistDto(album.getArtist()))
        .releaseDate(album.getReleaseDate())
        .build();
  }

  public List<AlbumDto> toAlbumDtoList(List<Album> albums) {
    return albums.stream().map(this::toAlbumDto).toList();
  }
}
