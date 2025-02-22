package com.rxhms.hearify.playlist.business;

import com.rxhms.hearify.exception.HearifyBadRequestException;
import com.rxhms.hearify.exception.HearifyNotFoundException;
import com.rxhms.hearify.playlist.repository.PlaylistRepository;
import com.rxhms.hearify.track.business.Track;
import com.rxhms.hearify.track.business.TrackService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PlaylistService {

  private final PlaylistRepository playlistRepository;
  private final TrackService trackService;

  private static final String NOT_FOUND_MESSAGE = "The playlist with id {0} could not be found.";
  private static final String ALREADY_EXISTING_TRACK_MESSAGE =
      "The track with id {0} is already in the specified playlist.";
  private static final String ALREADY_EXISTING_PLAYLIST_MESSAGE =
      "This user already has a playlist with the name {0}";
  private static final String NOT_EXISTING_TRACK_MESSAGE =
      "The track with id {0} could not be found inside the specified playlist.";

  public Playlist getPlaylistById(Integer id) {
    return playlistRepository
        .findById(id)
        .orElseThrow(() -> new HearifyNotFoundException(NOT_FOUND_MESSAGE, id));
  }

  public void addTrackToPlaylist(Integer playlistId, Integer trackId) {
    final Playlist playlist = getPlaylistById(playlistId);
    final Track track = trackService.getTrackById(trackId);

    if (playlist.getTracks().contains(track)) {
      throw new HearifyBadRequestException(ALREADY_EXISTING_TRACK_MESSAGE, trackId);
    } else {
      playlist.getTracks().add(track);
      playlistRepository.save(playlist);
    }
  }

  public void removeTrackFromPlaylist(Integer playlistId, Integer trackId) {
    final Playlist playlist = getPlaylistById(playlistId);
    final Track track = trackService.getTrackById(trackId);

    if (!playlist.getTracks().contains(track)) {
      throw new HearifyBadRequestException(NOT_EXISTING_TRACK_MESSAGE, trackId);
    } else {
      playlist.getTracks().remove(track);
      playlistRepository.save(playlist);
    }
  }

  public void deletePlaylistById(Integer playlistId) {
    final Playlist playlist = getPlaylistById(playlistId);
    playlistRepository.delete(playlist);
  }

  public void createPlaylist(Playlist playlist) {
    if (playlistRepository.existsByNameAndUserId(playlist.getName(), playlist.getUser().getId())) {
      throw new HearifyBadRequestException(ALREADY_EXISTING_PLAYLIST_MESSAGE, playlist.getName());
    } else {
      playlistRepository.save(playlist);
    }
  }
}
