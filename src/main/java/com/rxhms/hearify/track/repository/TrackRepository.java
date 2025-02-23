package com.rxhms.hearify.track.repository;

import static com.rxhms.hearify.constants.HearifyConstants.RANDOM_SIZE;

import com.rxhms.hearify.track.business.Track;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface TrackRepository extends JpaRepository<Track, Integer> {
  List<Track> findTracksByAlbumId(Integer albumId);

  @Query(value = "SELECT * FROM tracks ORDER BY RAND() LIMIT " + RANDOM_SIZE, nativeQuery = true)
  List<Track> findRandomTracks();

  Optional<List<Track>> findTracksByTitleContainsIgnoreCaseOrAlbumNameContainsIgnoreCase(String title, String albumName);
}
