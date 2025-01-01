package com.rxhms.hearify.album.repository;

import com.rxhms.hearify.album.business.Album;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AlbumRepository extends JpaRepository<Album, Integer> {
    List<Album> findAlbumsByArtistId(Integer artistId);
}

