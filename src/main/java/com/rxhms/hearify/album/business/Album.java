package com.rxhms.hearify.album.business;

import com.rxhms.hearify.artist.business.Artist;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
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

  @ManyToOne
  @JoinColumn(name = "artist_id")
  private Artist artist;
  private String coverImage;
  private LocalDateTime createdAt;
}
