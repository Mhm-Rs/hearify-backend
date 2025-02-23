package com.rxhms.hearify.track.business;

import com.rxhms.hearify.album.business.Album;
import com.rxhms.hearify.artist.business.Artist;
import com.rxhms.hearify.playlist.business.Playlist;
import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Builder
@Table(name = "tracks")
@NoArgsConstructor
@AllArgsConstructor
public class Track {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  private String title;
  private int duration;

  @ManyToOne
  @JoinColumn(name = "artist_id")
  private Artist artist;

  @ManyToOne
  @JoinColumn(name = "album_id")
  private Album album;

  @ManyToMany(mappedBy = "tracks")
  private List<Playlist> playlists = new ArrayList<>();

  private LocalDateTime createdAt;

  private String trackPlayUrl;
}
