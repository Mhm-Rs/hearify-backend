package com.rxhms.hearify.playlist.repository;

import com.rxhms.hearify.playlist.business.Playlist;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlaylistRepository extends JpaRepository<Playlist, Integer> {
  public List<Playlist> findPlaylistsByUserId(Integer userId);

  public boolean existsByNameAndUserId(final String name, Integer userId);
}
