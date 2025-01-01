package com.rxhms.hearify.playlist;

import com.rxhms.hearify.playlist.business.PlaylistMapper;
import com.rxhms.hearify.playlist.business.PlaylistService;
import com.rxhms.hearify.playlist.dto.PlaylistCreationDto;
import com.rxhms.hearify.playlist.dto.PlaylistDto;
import com.rxhms.hearify.track.dto.TrackManipulationDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/api/playlists")
@RequiredArgsConstructor
public class PlaylistController {

    private final PlaylistService playlistService;
    private final PlaylistMapper playlistMapper;

    @GetMapping("/{id}")
    public ResponseEntity<PlaylistDto> getPlaylistById(@PathVariable Integer id) {
        return ResponseEntity.ok(playlistMapper.toPlaylistDto(playlistService.getPlaylistById(id)));
    }

    @PostMapping("/{playlistId}/tracks")
    public ResponseEntity<Void> addTrackToPlaylist(@PathVariable Integer playlistId, @RequestBody TrackManipulationDto trackManipulationDto) {
        playlistService.addTrackToPlaylist(playlistId, trackManipulationDto.trackId());
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @DeleteMapping("/{playlistId}/tracks/{trackId}")
    public ResponseEntity<Void> removeTrackFromPlaylist(@PathVariable Integer playlistId, @PathVariable Integer trackId) {
        playlistService.removeTrackFromPlaylist(playlistId, trackId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PostMapping
    public ResponseEntity<Void> createPlaylist(@RequestBody @Validated PlaylistCreationDto playlistCreationDto) {
        playlistService.createPlaylist(playlistMapper.fromPlaylistCreationDto(playlistCreationDto));
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @DeleteMapping("/{playlistId}")
    public ResponseEntity<Void> deletePlaylist(@PathVariable Integer playlistId) {
        playlistService.deletePlaylistById(playlistId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }


}
