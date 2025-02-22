package com.rxhms.hearify.album.business;

import com.rxhms.hearify.album.repository.AlbumRepository;
import com.rxhms.hearify.exception.HearifyNotFoundException;
import com.rxhms.hearify.track.business.Track;
import com.rxhms.hearify.track.repository.TrackRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AlbumService {

  private final AlbumRepository albumRepository;
  private final TrackRepository trackRepository;
  private static final String NOT_FOUND_MESSAGE = "The artist with id {0} could not be found.";

  public Album getAlbumById(Integer id) {
    return albumRepository
        .findById(id)
        .orElseThrow(() -> new HearifyNotFoundException(NOT_FOUND_MESSAGE, id));
  }

  public List<Track> getAlbumTracks(Integer albumId) {
    return trackRepository.findTracksByAlbumId(albumId);
  }
}
