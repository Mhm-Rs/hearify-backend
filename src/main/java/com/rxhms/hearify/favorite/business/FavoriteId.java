package com.rxhms.hearify.favorite.business;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Embeddable
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class FavoriteId {
  private Integer user_id;
  private Integer track_id;
}
