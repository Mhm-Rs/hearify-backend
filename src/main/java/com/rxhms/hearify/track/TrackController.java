package com.rxhms.hearify.track;

import com.rxhms.hearify.constants.HearifyConstants;
import com.rxhms.hearify.track.business.TrackMapper;
import com.rxhms.hearify.track.business.TrackService;
import com.rxhms.hearify.track.dto.TrackDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/api/tracks")
@CrossOrigin(origins = "*")
@RequiredArgsConstructor
@Tag(name = "Track")
public class TrackController {

  private final TrackService trackService;
  private final TrackMapper trackMapper;

  private static final String TRACK_RETRIEVED = "Track retrieved";

  @GetMapping("/{id}")
  @Operation(summary = "Retrieve a track by its id")
  @ApiResponse(responseCode = "200", description = TRACK_RETRIEVED)
  @ApiResponse(responseCode = "500", description = HearifyConstants.INTERNAL_SERVER_ERROR)
  public ResponseEntity<TrackDto> getTrackById(@PathVariable Integer id) {
    return ResponseEntity.ok(trackMapper.toTrackDto(trackService.getTrackById(id)));
  }

  @GetMapping("/random")
  @Operation(summary = "Retrieve a constant number of random tracks")
  @ApiResponse(responseCode = "200", description = TRACK_RETRIEVED)
  @ApiResponse(responseCode = "500", description = HearifyConstants.INTERNAL_SERVER_ERROR)
  public ResponseEntity<List<TrackDto>> getRandomTracks() {
    return ResponseEntity.ok(trackMapper.toTrackDtoList(trackService.getRandomTracks()));
  }

  @GetMapping("/search")
  @Operation(summary = "Retrieve a list of tracks based on a search query")
  @ApiResponse(responseCode = "200", description = TRACK_RETRIEVED)
  @ApiResponse(responseCode = "500", description = HearifyConstants.INTERNAL_SERVER_ERROR)
  public ResponseEntity<List<TrackDto>> searchTracks(@RequestParam String query) {
    return ResponseEntity.ok(trackMapper.toTrackDtoList(trackService.searchTracks(query)));
  }
}
