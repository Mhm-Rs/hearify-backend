package com.rxhms.hearify.playlist;

import com.rxhms.hearify.constants.HearifyConstants;
import com.rxhms.hearify.playlist.business.PlaylistMapper;
import com.rxhms.hearify.playlist.business.PlaylistService;
import com.rxhms.hearify.playlist.dto.PlaylistCreationDto;
import com.rxhms.hearify.playlist.dto.PlaylistDto;
import com.rxhms.hearify.track.dto.TrackManipulationDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/api/playlists")
@CrossOrigin(origins = "*")
@RequiredArgsConstructor
@Tag(name = "Playlist")
public class PlaylistController {

  private final PlaylistService playlistService;
  private final PlaylistMapper playlistMapper;

  private static final String PLAYLIST_RETRIEVED = "Playlist retrieved";
  private static final String TRACK_ADDED = "Track added";
  private static final String TRACK_REMOVED = "Track removed";
  private static final String PLAYLIST_CREATED = "Playlist created";
  private static final String PLAYLIST_DELETED = "Playlist deleted";

  @GetMapping("/{id}")
  @Operation(summary = "Retrieve a playlist by its id")
  @ApiResponse(responseCode = "200", description = PLAYLIST_RETRIEVED)
  @ApiResponse(responseCode = "500", description = HearifyConstants.INTERNAL_SERVER_ERROR)
  public ResponseEntity<PlaylistDto> getPlaylistById(@PathVariable Integer id) {
    return ResponseEntity.ok(playlistMapper.toPlaylistDto(playlistService.getPlaylistById(id)));
  }

  @PostMapping("/{playlistId}/tracks")
  @Operation(summary = "Add a track to a playlist")
  @ApiResponse(responseCode = "201", description = TRACK_ADDED)
  @ApiResponse(responseCode = "500", description = HearifyConstants.INTERNAL_SERVER_ERROR)
  public ResponseEntity<Void> addTrackToPlaylist(
      @PathVariable Integer playlistId, @RequestBody TrackManipulationDto trackManipulationDto) {
    playlistService.addTrackToPlaylist(playlistId, trackManipulationDto.trackId());
    return new ResponseEntity<>(HttpStatus.CREATED);
  }

  @DeleteMapping("/{playlistId}/tracks/{trackId}")
  @Operation(summary = "Remove a track from a playlist")
  @ApiResponse(responseCode = "204", description = TRACK_REMOVED)
  @ApiResponse(responseCode = "500", description = HearifyConstants.INTERNAL_SERVER_ERROR)
  public ResponseEntity<Void> removeTrackFromPlaylist(
      @PathVariable Integer playlistId, @PathVariable Integer trackId) {
    playlistService.removeTrackFromPlaylist(playlistId, trackId);
    return new ResponseEntity<>(HttpStatus.NO_CONTENT);
  }

  @PostMapping
  @Operation(summary = "Add a new playlist to database")
  @ApiResponse(responseCode = "201", description = PLAYLIST_CREATED)
  @ApiResponse(responseCode = "500", description = HearifyConstants.INTERNAL_SERVER_ERROR)
  public ResponseEntity<Void> createPlaylist(
      @RequestBody @Validated PlaylistCreationDto playlistCreationDto) {
    playlistService.createPlaylist(playlistMapper.fromPlaylistCreationDto(playlistCreationDto));
    return new ResponseEntity<>(HttpStatus.CREATED);
  }

  @DeleteMapping("/{playlistId}")
  @Operation(summary = "Remove a playlist from database")
  @ApiResponse(responseCode = "204", description = PLAYLIST_DELETED)
  @ApiResponse(responseCode = "500", description = HearifyConstants.INTERNAL_SERVER_ERROR)
  public ResponseEntity<Void> deletePlaylist(@PathVariable Integer playlistId) {
    playlistService.deletePlaylistById(playlistId);
    return new ResponseEntity<>(HttpStatus.NO_CONTENT);
  }
}
