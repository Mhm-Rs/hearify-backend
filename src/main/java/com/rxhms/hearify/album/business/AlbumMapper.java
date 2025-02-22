package com.rxhms.hearify.album.business;

import com.rxhms.hearify.album.dto.AlbumDto;
import com.rxhms.hearify.album.dto.AlbumSimplifiedDto;
import com.rxhms.hearify.artist.business.ArtistMapper;
import com.rxhms.hearify.track.business.TrackMapper;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class AlbumMapper {

  private final ArtistMapper artistMapper;
  private final TrackMapper trackMapper;

  public AlbumDto toAlbumDto(Album album) {
    return AlbumDto.builder()
        .id(album.getId())
        .name(album.getName())
        .cover(album.getCoverImage())
        .artist(artistMapper.toArtistDto(album.getArtist()))
        .releaseDate(album.getReleaseDate())
        .saves(album.getSaves())
        .tracks(trackMapper.toTrackForAlbumDtoList(album.getTracks()))
        .build();
  }

  public AlbumSimplified toAlbumSimplified(Album album) {
    return AlbumSimplified.builder()
        .id(album.getId())
        .name(album.getName())
        .albumCover(album.getCoverImage())
        .artistName(album.getArtist().getName())
        .build();
  }

  public AlbumSimplifiedDto toAlbumSimplifiedDto(AlbumSimplified album) {
    return AlbumSimplifiedDto.builder()
        .id(album.id())
        .name(album.name())
        .albumCover(album.albumCover())
        .artistName(album.artistName())
        .build();
  }

  public List<AlbumSimplifiedDto> toAlbumSimplifiedDtoList(List<Album> albums) {
    return albums.stream().map(this::toAlbumSimplified).map(this::toAlbumSimplifiedDto).toList();
  }

  public List<AlbumDto> toAlbumDtoList(List<Album> albums) {
    return albums.stream().map(this::toAlbumDto).toList();
  }
}
