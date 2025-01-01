package com.rxhms.hearify.user;

import com.rxhms.hearify.favorite.business.FavoriteMapper;
import com.rxhms.hearify.favorite.business.FavoriteService;
import com.rxhms.hearify.favorite.dto.FavoriteDto;
import com.rxhms.hearify.playlist.business.PlaylistMapper;
import com.rxhms.hearify.playlist.dto.PlaylistDto;
import com.rxhms.hearify.track.dto.TrackManipulationDto;
import com.rxhms.hearify.user.business.UserMapper;
import com.rxhms.hearify.user.business.UserService;
import com.rxhms.hearify.user.dto.UserCreationDto;
import com.rxhms.hearify.user.dto.UserDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/api/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;
    private final UserMapper userMapper;
    private final FavoriteService favoriteService;
    private final FavoriteMapper favoriteMapper;
    private final PlaylistMapper playlistMapper;

    @GetMapping("/{id}")
    public ResponseEntity<UserDto> getUserById(@PathVariable Integer id) {
        return ResponseEntity.ok(userMapper.toUserDto(userService.getUserById(id)));
    }

    @PostMapping
    public ResponseEntity<Void> createUser(@Validated @RequestBody UserCreationDto userCreationDto) {
        userService.createUser(userMapper.fromUserCreationDto(userCreationDto));
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUserById(@PathVariable Integer id) {
        userService.deleteUserById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/{id}/playlists")
    public ResponseEntity<List<PlaylistDto>> getUserPlaylists(@PathVariable Integer id) {
        return ResponseEntity.ok(playlistMapper.toPlaylistDtoList(userService.getUserPlaylists(id)));
    }

    @GetMapping("/{id}/favorites")
    public ResponseEntity<List<FavoriteDto>> getUserFavorites(@PathVariable Integer id) {
        return ResponseEntity.ok(favoriteMapper.toFavoriteDtoList(favoriteService.getUserFavorites(id)));
    }

    @PostMapping("/{userId}/favorites")
    public ResponseEntity<Void> addTrackToFavorites(@PathVariable Integer userId, @RequestBody TrackManipulationDto trackManipulationDto) {
        favoriteService.addTrackToFavorites(userId, trackManipulationDto.trackId());
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @DeleteMapping("/{userId}/favorites/{trackId}")
    public ResponseEntity<Void> removeTrackFromFavorites(@PathVariable Integer userId, @PathVariable Integer trackId) {
        favoriteService.removeTrackFromFavorites(userId, trackId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
