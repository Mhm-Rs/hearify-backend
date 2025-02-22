package com.rxhms.hearify.album.business;

import com.rxhms.hearify.artist.business.Artist;
import com.rxhms.hearify.track.business.Track;
import jakarta.persistence.*;
import java.time.LocalDate;
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
@Table(name = "albums")
@NoArgsConstructor
@AllArgsConstructor
public class Album {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  private String name;
  private LocalDate releaseDate;
  private Integer saves;

  @ManyToOne
  @JoinColumn(name = "artist_id")
  private Artist artist;

  @OneToMany(mappedBy = "album", cascade = CascadeType.ALL)
  private List<Track> tracks = new ArrayList<>();

  private String coverImage;
  private LocalDateTime createdAt;
}
