package com.rxhms.hearify.user.business;

import com.rxhms.hearify.favorite.business.Favorite;
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
@Table(name = "users")
@NoArgsConstructor
@AllArgsConstructor
public class User {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  private String username;
  private String email;
  private String passwordHash;
  private String profilePic;
  private Integer followers;
  private Integer following;

  @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
  private List<Favorite> favorites = new ArrayList<>();

  private LocalDateTime createdAt;
}
