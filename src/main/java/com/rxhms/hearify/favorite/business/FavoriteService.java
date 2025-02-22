package com.rxhms.hearify.favorite.business;

import com.rxhms.hearify.exception.HearifyBadRequestException;
import com.rxhms.hearify.favorite.repository.FavoriteRepository;
import com.rxhms.hearify.track.business.Track;
import com.rxhms.hearify.track.business.TrackService;
import com.rxhms.hearify.user.business.User;
import com.rxhms.hearify.user.business.UserService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class FavoriteService {

  private final UserService userService;
  private final TrackService trackService;
  private final FavoriteRepository favoriteRepository;

  private static final String ALREADY_FAVORITE_MESSAGE =
      "The track with id {0} is already a favorite for the specified user";
  private static final String NOT_FAVORITE_MESSAGE =
      "The track with id {0} is not a favorite for the specified user";

  public List<Favorite> getUserFavorites(Integer userId) {
    final User user = userService.getUserById(userId);
    return user.getFavorites();
  }

  public void addTrackToFavorites(Integer userId, Integer trackId) {
    final User user = userService.getUserById(userId);
    final Track track = trackService.getTrackById(trackId);

    final FavoriteId favoriteId = new FavoriteId(user.getId(), track.getId());
    if (favoriteRepository.existsById(favoriteId)) {
      throw new HearifyBadRequestException(ALREADY_FAVORITE_MESSAGE, favoriteId.getTrack_id());
    } else {
      final Favorite favorite = Favorite.builder().id(favoriteId).user(user).track(track).build();
      favoriteRepository.save(favorite);
    }
  }

  public void removeTrackFromFavorites(Integer userId, Integer trackId) {
    final User user = userService.getUserById(userId);
    final Track track = trackService.getTrackById(trackId);

    final FavoriteId favoriteId = new FavoriteId(user.getId(), track.getId());
    if (!favoriteRepository.existsById(favoriteId)) {
      throw new HearifyBadRequestException(NOT_FAVORITE_MESSAGE, favoriteId.getTrack_id());
    } else {
      favoriteRepository.deleteById(favoriteId);
    }
  }
}
