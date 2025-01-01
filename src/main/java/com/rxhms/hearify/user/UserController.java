package com.rxhms.hearify.user;

import com.rxhms.hearify.playlist.business.PlaylistMapper;
import com.rxhms.hearify.playlist.dto.PlaylistDto;
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
}
