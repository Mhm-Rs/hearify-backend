package com.rxhms.hearify.playlist.business;

import com.rxhms.hearify.track.business.Track;
import com.rxhms.hearify.user.business.User;
import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Builder
@Data
@Table(name = "playlists")
@NoArgsConstructor
@AllArgsConstructor
public class Playlist {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  private String name;

  @ManyToOne
  @JoinColumn(name = "user_id")
  private User user;

  @ManyToMany
  @JoinTable(
      name = "playlist_tracks",
      joinColumns = @JoinColumn(name = "playlist_id"),
      inverseJoinColumns = @JoinColumn(name = "track_id"))
  private List<Track> tracks = new ArrayList<>();

  private LocalDateTime createdAt;
}
