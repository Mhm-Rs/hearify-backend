package com.rxhms.hearify.track.business;

import com.rxhms.hearify.artist.business.ArtistMapper;
import com.rxhms.hearify.track.dto.TrackDto;
import com.rxhms.hearify.track.dto.TrackForAlbumDto;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class TrackMapper {

  private final ArtistMapper artistMapper;

  public TrackDto toTrackDto(Track track) {
    return TrackDto.builder()
        .id(track.getId())
        .title(track.getTitle())
        .duration(track.getDuration())
        .artist(artistMapper.toArtistDto(track.getArtist()))
        .cover(track.getAlbum().getCoverImage())
            .trackPlayUrl(track.getTrackPlayUrl())
        .build();
  }

  public TrackForAlbumDto toTrackForAlbumDto(Track track) {
    return TrackForAlbumDto.builder()
        .id(track.getId())
        .title(track.getTitle())
        .duration(track.getDuration())
            .trackPlayUrl(track.getTrackPlayUrl())
        .build();
  }

  public List<TrackDto> toTrackDtoList(List<Track> tracks) {
    return tracks.stream().map(this::toTrackDto).toList();
  }

  public List<TrackForAlbumDto> toTrackForAlbumDtoList(List<Track> tracks) {
    return tracks.stream().map(this::toTrackForAlbumDto).toList();
  }
}
