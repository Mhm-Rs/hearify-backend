package com.rxhms.hearify.user.business;

import com.rxhms.hearify.user.dto.UserAuthenticationDto;
import com.rxhms.hearify.user.dto.UserCreationDto;
import com.rxhms.hearify.user.dto.UserDto;
import java.time.LocalDateTime;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {

  public UserDto toUserDto(User user) {
    return UserDto.builder()
        .id(user.getId())
        .username(user.getUsername())
        .email(user.getEmail())
        .profilePic(user.getProfilePic())
        .followers(user.getFollowers())
        .following(user.getFollowing())
        .build();
  }

  public User fromUserCreationDto(UserCreationDto userCreationDto) {
    return User.builder()
        .username(userCreationDto.username())
        .email(userCreationDto.email())
        .passwordHash(userCreationDto.passwordHash())
        .id(null)
        .createdAt(LocalDateTime.now())
        .build();
  }

  public UserAuthentication fromUserAuthenticationDto(UserAuthenticationDto userAuthenticationDto) {
    return UserAuthentication.builder()
        .username(userAuthenticationDto.username())
        .passwordHash(userAuthenticationDto.passwordHash())
        .build();
  }
}
