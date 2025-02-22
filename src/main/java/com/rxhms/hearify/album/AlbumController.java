package com.rxhms.hearify.album;

import com.rxhms.hearify.album.business.AlbumMapper;
import com.rxhms.hearify.album.business.AlbumService;
import com.rxhms.hearify.album.dto.AlbumDto;
import com.rxhms.hearify.constants.HearifyConstants;
import com.rxhms.hearify.track.business.TrackMapper;
import com.rxhms.hearify.track.dto.TrackDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/api/albums")
@CrossOrigin(origins = "*")
@Tag(name = "Album")
@RequiredArgsConstructor
public class AlbumController {

  private final AlbumService albumService;
  private final AlbumMapper albumMapper;
  private final TrackMapper trackMapper;

  private static final String ALBUM_RETRIEVED = "Album retrieved";
  private static final String ALBUM_TRACKS_RETRIEVED = "Album tracks retrieved";

  @GetMapping("/{id}")
  @Operation(summary = "Retrieve an album by its id")
  @ApiResponse(responseCode = "200", description = ALBUM_RETRIEVED)
  @ApiResponse(responseCode = "500", description = HearifyConstants.INTERNAL_SERVER_ERROR)
  public ResponseEntity<AlbumDto> getAlbumById(@PathVariable Integer id) {
    return ResponseEntity.ok(albumMapper.toAlbumDto(albumService.getAlbumById(id)));
  }

  @GetMapping("/{id}/tracks")
  @Operation(summary = "Retrieve the tracks of an album by its id")
  @ApiResponse(responseCode = "200", description = ALBUM_TRACKS_RETRIEVED)
  @ApiResponse(responseCode = "500", description = HearifyConstants.INTERNAL_SERVER_ERROR)
  public ResponseEntity<List<TrackDto>> getAlbumTracks(@PathVariable Integer id) {
    return ResponseEntity.ok(trackMapper.toTrackDtoList(albumService.getAlbumTracks(id)));
  }
}
