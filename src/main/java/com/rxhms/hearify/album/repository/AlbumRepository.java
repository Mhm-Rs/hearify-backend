package com.rxhms.hearify.album.repository;

import static com.rxhms.hearify.constants.HearifyConstants.RANDOM_SIZE;

import com.rxhms.hearify.album.business.Album;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface AlbumRepository extends JpaRepository<Album, Integer> {
  List<Album> findAlbumsByArtistId(Integer artistId);

  @Query(value = "SELECT * FROM albums ORDER BY RAND() LIMIT " + RANDOM_SIZE, nativeQuery = true)
  List<Album> findRandomAlbums();
}
