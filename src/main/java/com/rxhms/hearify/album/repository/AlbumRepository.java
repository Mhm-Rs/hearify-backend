package com.rxhms.hearify.album.repository;

import com.rxhms.hearify.album.business.Album;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AlbumRepository extends JpaRepository<Album, Integer> {
  List<Album> findAlbumsByArtistId(Integer artistId);
}
