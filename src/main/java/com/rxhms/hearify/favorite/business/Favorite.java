package com.rxhms.hearify.favorite.business;

import com.rxhms.hearify.track.business.Track;
import com.rxhms.hearify.user.business.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Builder
@Table(name = "favorites")
@NoArgsConstructor
@AllArgsConstructor
public class Favorite {

  @EmbeddedId private FavoriteId id;

  @ManyToOne
  @MapsId("user")
  @JoinColumn(name = "user_id", referencedColumnName = "id")
  private User user;

  @ManyToOne
  @MapsId("track")
  @JoinColumn(name = "track_id", referencedColumnName = "id")
  private Track track;
}
