package com.rxhms.hearify.playlist.repository;

import com.rxhms.hearify.playlist.business.Playlist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PlaylistRepository extends JpaRepository<Playlist, Integer> {
    public List<Playlist> findPlaylistsByUserId(Integer userId);
    public boolean existsByNameAndUserId(final String name, Integer userId);
}

