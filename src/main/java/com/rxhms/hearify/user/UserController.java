package com.rxhms.hearify.user;

import com.rxhms.hearify.constants.HearifyConstants;
import com.rxhms.hearify.favorite.business.FavoriteMapper;
import com.rxhms.hearify.favorite.business.FavoriteService;
import com.rxhms.hearify.favorite.dto.FavoriteDto;
import com.rxhms.hearify.playlist.business.PlaylistMapper;
import com.rxhms.hearify.playlist.dto.PlaylistDto;
import com.rxhms.hearify.track.dto.TrackManipulationDto;
import com.rxhms.hearify.user.business.UserMapper;
import com.rxhms.hearify.user.business.UserService;
import com.rxhms.hearify.user.dto.UserAuthenticationDto;
import com.rxhms.hearify.user.dto.UserCreationDto;
import com.rxhms.hearify.user.dto.UserDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/api/users")
@Tag(name = "User")
@CrossOrigin(origins = "*")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;
    private final UserMapper userMapper;
    private final FavoriteService favoriteService;
    private final FavoriteMapper favoriteMapper;
    private final PlaylistMapper playlistMapper;

    private static final String USER_RETRIEVED = "User retrieved successfully";
    private static final String USER_AUTHENTICATED = "User authenticated successfully";
    private static final String USER_CREATED = "User created successfully";
    private static final String USER_DELETED = "User deleted successfully";
    private static final String PLAYLISTS_RETRIEVED = "Playlists retrieved successfully";
    private static final String FAVORITES_RETRIEVED = "Favorites retrieved successfully";
    private static final String FAVORITE_ADDED = "Favorite added successfully";
    private static final String FAVORITE_REMOVED = "Favorite removed successfully";

    @GetMapping("/{id}")
    @Operation(summary = "Retrieve a user by their id")
    @ApiResponse(responseCode = "200", description = USER_RETRIEVED)
    @ApiResponse(responseCode = "500", description = HearifyConstants.INTERNAL_SERVER_ERROR)
    public ResponseEntity<UserDto> getUserById(@PathVariable Integer id) {
        return ResponseEntity.ok(userMapper.toUserDto(userService.getUserById(id)));
    }

    @PostMapping
    @Operation(summary = "Add a new user to database")
    @ApiResponse(responseCode = "201", description = USER_CREATED)
    @ApiResponse(responseCode = "500", description = HearifyConstants.INTERNAL_SERVER_ERROR)
    public ResponseEntity<Void> createUser(@Validated @RequestBody UserCreationDto userCreationDto) {
        userService.createUser(userMapper.fromUserCreationDto(userCreationDto));
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PostMapping("/auth")
    @Operation(summary = "Authenticate user and returns their data")
    @ApiResponse(responseCode = "200", description = USER_AUTHENTICATED)
    @ApiResponse(responseCode = "500", description = HearifyConstants.INTERNAL_SERVER_ERROR)
    public ResponseEntity<UserDto> authenticateUser(@Validated @RequestBody UserAuthenticationDto userAuthenticationDto) {
        return ResponseEntity.ok(userMapper.toUserDto(userService.authenticateUser(userMapper.fromUserAuthenticationDto(userAuthenticationDto))));
    }


    @DeleteMapping("/{id}")
    @Operation(summary = "Find user by id and delete")
    @ApiResponse(responseCode = "204", description = USER_DELETED)
    @ApiResponse(responseCode = "500", description = HearifyConstants.INTERNAL_SERVER_ERROR)
    public ResponseEntity<Void> deleteUserById(@PathVariable Integer id) {
        userService.deleteUserById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/{id}/playlists")
    @Operation(summary = "Retrieve all playlists of a user")
    @ApiResponse(responseCode = "200", description = PLAYLISTS_RETRIEVED)
    @ApiResponse(responseCode = "500", description = HearifyConstants.INTERNAL_SERVER_ERROR)
    public ResponseEntity<List<PlaylistDto>> getUserPlaylists(@PathVariable Integer id) {
        return ResponseEntity.ok(playlistMapper.toPlaylistDtoList(userService.getUserPlaylists(id)));
    }

    @GetMapping("/{id}/favorites")
    @Operation(summary = "Retrieve all favorite songs of a user")
    @ApiResponse(responseCode = "200", description = FAVORITES_RETRIEVED)
    @ApiResponse(responseCode = "500", description = HearifyConstants.INTERNAL_SERVER_ERROR)
    public ResponseEntity<List<FavoriteDto>> getUserFavorites(@PathVariable Integer id) {
        return ResponseEntity.ok(favoriteMapper.toFavoriteDtoList(favoriteService.getUserFavorites(id)));
    }

    @PostMapping("/{userId}/favorites")
    @Operation(summary = "Add a track to the favorites of a user")
    @ApiResponse(responseCode = "201", description = FAVORITE_ADDED)
    @ApiResponse(responseCode = "500", description = HearifyConstants.INTERNAL_SERVER_ERROR)
    public ResponseEntity<Void> addTrackToFavorites(@PathVariable Integer userId, @RequestBody TrackManipulationDto trackManipulationDto) {
        favoriteService.addTrackToFavorites(userId, trackManipulationDto.trackId());
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @DeleteMapping("/{userId}/favorites/{trackId}")
    @Operation(summary = "Remove a track from the favorites of a user")
    @ApiResponse(responseCode = "204", description = FAVORITE_REMOVED)
    @ApiResponse(responseCode = "500", description = HearifyConstants.INTERNAL_SERVER_ERROR)
    public ResponseEntity<Void> removeTrackFromFavorites(@PathVariable Integer userId, @PathVariable Integer trackId) {
        favoriteService.removeTrackFromFavorites(userId, trackId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
