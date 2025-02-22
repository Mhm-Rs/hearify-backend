package com.rxhms.hearify.artist.repository;

import static com.rxhms.hearify.constants.HearifyConstants.RANDOM_SIZE;

import com.rxhms.hearify.artist.business.Artist;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ArtistRepository extends JpaRepository<Artist, Integer> {
  @Query(value = "SELECT * FROM artists ORDER BY RAND() LIMIT " + RANDOM_SIZE, nativeQuery = true)
  List<Artist> findRandomArtists();
}
