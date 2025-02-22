package com.rxhms.hearify.artist;

import com.rxhms.hearify.album.business.AlbumMapper;
import com.rxhms.hearify.album.dto.AlbumDto;
import com.rxhms.hearify.artist.business.ArtistMapper;
import com.rxhms.hearify.artist.business.ArtistService;
import com.rxhms.hearify.artist.dto.ArtistDto;
import com.rxhms.hearify.constants.HearifyConstants;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/v1/api/artists")
@Tag(name = "Artist")
@RequiredArgsConstructor
public class ArtistController {

  private final ArtistService artistService;
  private final ArtistMapper artistMapper;
  private final AlbumMapper albumMapper;

  private static final String ARTIST_RETRIEVED = "Artist retrieved";
  private static final String ALBUMS_RETRIEVED = "Albums retrieved";

  @GetMapping("/{id}")
  @Operation(summary = "Retrieve an artist by their id")
  @ApiResponse(responseCode = "200", description = ARTIST_RETRIEVED)
  @ApiResponse(responseCode = "500", description = HearifyConstants.INTERNAL_SERVER_ERROR)
  public ResponseEntity<ArtistDto> getArtistById(@PathVariable Integer id) {
    return ResponseEntity.ok(artistMapper.toArtistDto(artistService.getArtistById(id)));
  }

  @GetMapping("/{id}/albums")
  @Operation(summary = "Retrieve the albums of an artist by their id")
  @ApiResponse(responseCode = "200", description = ALBUMS_RETRIEVED)
  @ApiResponse(responseCode = "500", description = HearifyConstants.INTERNAL_SERVER_ERROR)
  public ResponseEntity<List<AlbumDto>> getAlbumsByArtistId(@PathVariable Integer id) {
    return ResponseEntity.ok(albumMapper.toAlbumDtoList(artistService.getAlbumsByArtist(id)));
  }
}
