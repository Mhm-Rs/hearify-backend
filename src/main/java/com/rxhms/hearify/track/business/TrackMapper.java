package com.rxhms.hearify.track.business;

import com.rxhms.hearify.album.business.AlbumMapper;
import com.rxhms.hearify.artist.business.ArtistMapper;
import com.rxhms.hearify.track.dto.TrackDto;
import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class TrackMapper {

  private final AlbumMapper albumMapper;
  private final ArtistMapper artistMapper;

  public TrackDto toTrackDto(Track track) {
    return TrackDto.builder()
        .id(track.getId())
        .title(track.getTitle())
        .duration(track.getDuration())
        .album(albumMapper.toAlbumDto(track.getAlbum()))
        .artist(artistMapper.toArtistDto(track.getArtist()))
        .build();
  }

  public List<TrackDto> toTrackDtoList(List<Track> tracks) {
    return tracks.stream().map(this::toTrackDto).collect(Collectors.toList());
  }
}
