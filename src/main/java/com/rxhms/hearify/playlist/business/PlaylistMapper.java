package com.rxhms.hearify.playlist.business;

import com.rxhms.hearify.playlist.dto.PlaylistCreationDto;
import com.rxhms.hearify.playlist.dto.PlaylistDto;
import com.rxhms.hearify.track.business.TrackMapper;
import com.rxhms.hearify.user.business.UserMapper;
import com.rxhms.hearify.user.business.UserService;
import com.rxhms.hearify.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

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
        .build();
  }

  public List<PlaylistDto> toPlaylistDtoList(List<Playlist> playlists) {
    return playlists.stream().map(this::toPlaylistDto).toList();
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
