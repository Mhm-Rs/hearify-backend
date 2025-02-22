package com.rxhms.hearify.artist.repository;

import com.rxhms.hearify.artist.business.Artist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ArtistRepository extends JpaRepository<Artist, Integer> {
  boolean existsByName(String name);
}
