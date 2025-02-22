package com.rxhms.hearify.track.business;

import com.rxhms.hearify.exception.HearifyNotFoundException;
import com.rxhms.hearify.track.repository.TrackRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TrackService {

  private final TrackRepository trackRepository;
  private static final String NOT_FOUND_MESSAGE = "The track with id {0} could not be found.";

  public Track getTrackById(Integer id) {
    return trackRepository
        .findById(id)
        .orElseThrow(() -> new HearifyNotFoundException(NOT_FOUND_MESSAGE, id));
  }

  public List<Track> getRandomTracks() {
    return trackRepository.findRandomTracks();
  }
}
