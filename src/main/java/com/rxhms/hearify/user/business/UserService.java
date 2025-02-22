package com.rxhms.hearify.user.business;

import com.rxhms.hearify.exception.HearifyBadRequestException;
import com.rxhms.hearify.exception.HearifyNotFoundException;
import com.rxhms.hearify.playlist.business.Playlist;
import com.rxhms.hearify.playlist.repository.PlaylistRepository;
import com.rxhms.hearify.user.repository.UserRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

  private final UserRepository userRepository;
  private static final String NOT_FOUND_MESSAGE = "The user with id {0} could not be found.";
  private static final String ALREADY_EXISTING_EMAIL_MESSAGE =
      "An user with the email {0} already exists.";
  private static final String NOT_AUTHENTICATED_MESSAGE =
      "The provided username or password is invalid.";
  private final PlaylistRepository playlistRepository;

  public User getUserById(Integer id) {
    return userRepository
        .findById(id)
        .orElseThrow(() -> new HearifyNotFoundException(NOT_FOUND_MESSAGE, id));
  }

  public void createUser(User user) {
    if (userRepository.existsByEmail(user.getEmail())) {
      throw new HearifyBadRequestException(ALREADY_EXISTING_EMAIL_MESSAGE, user.getEmail());
    } else {
      userRepository.save(user);
    }
  }

  public void deleteUserById(Integer id) {
    if (!userRepository.existsById(id)) {
      throw new HearifyNotFoundException(NOT_FOUND_MESSAGE, id);
    } else {
      userRepository.deleteById(id);
    }
  }

  public List<Playlist> getUserPlaylists(final Integer userId) {
    final User user = getUserById(userId);
    return playlistRepository.findPlaylistsByUserId(user.getId());
  }

  public User authenticateUser(UserAuthentication userAuthentication) {
    return userRepository
        .findByUsernameAndPasswordHash(
            userAuthentication.username(), userAuthentication.passwordHash())
        .orElseThrow(() -> new HearifyNotFoundException(NOT_AUTHENTICATED_MESSAGE));
  }
}
