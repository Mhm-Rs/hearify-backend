package com.rxhms.hearify.playlist.business;

import com.rxhms.hearify.playlist.dto.PlaylistCreationDto;
import com.rxhms.hearify.playlist.dto.PlaylistDto;
import com.rxhms.hearify.playlist.dto.PlaylistSimplifiedDto;
import com.rxhms.hearify.track.business.TrackMapper;
import com.rxhms.hearify.user.business.UserMapper;
import com.rxhms.hearify.user.business.UserService;
import java.time.LocalDateTime;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class PlaylistMapper {

  private final UserMapper userMapper;
  private final TrackMapper trackMapper;
  private final UserService userService;

  public PlaylistDto toPlaylistDto(Playlist playlist) {
    return PlaylistDto.builder()
        .id(playlist.getId())
        .name(playlist.getName())
        .user(userMapper.toUserDto(playlist.getUser()))
        .tracks(trackMapper.toTrackDtoList(playlist.getTracks()))
        .cover(playlist.getCover())
        .build();
  }

  public PlaylistSimplifiedDto toPlaylistSimplifiedDto(PlaylistSimplified playlist) {
    return PlaylistSimplifiedDto.builder()
        .id(playlist.id())
        .name(playlist.name())
        .userId(playlist.userId())
        .playlistCover(playlist.playlistCover())
        .build();
  }

  public PlaylistSimplified toPlaylistSimplified(Playlist playlist) {
    return PlaylistSimplified.builder()
        .id(playlist.getId())
        .name(playlist.getName())
        .userId(String.valueOf(playlist.getUser().getId()))
        .playlistCover(playlist.getCover())
        .build();
  }

  public List<PlaylistSimplifiedDto> toPlaylistSimplifiedDtoList(List<Playlist> playlists) {
    return playlists.stream()
        .map(this::toPlaylistSimplified)
        .map(this::toPlaylistSimplifiedDto)
        .toList();
  }

  public Playlist fromPlaylistCreationDto(PlaylistCreationDto playlistCreationDto) {
    return Playlist.builder()
        .name(playlistCreationDto.name())
        .createdAt(LocalDateTime.now())
        .id(null)
        .user(userService.getUserById(playlistCreationDto.userId()))
        .build();
  }
}
