package com.rxhms.hearify.artist;

import com.rxhms.hearify.album.business.AlbumMapper;
import com.rxhms.hearify.album.dto.AlbumDto;
import com.rxhms.hearify.artist.business.ArtistMapper;
import com.rxhms.hearify.artist.business.ArtistService;
import com.rxhms.hearify.artist.dto.ArtistDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/api/artists")
@RequiredArgsConstructor
public class ArtistController {

    private final ArtistService artistService;
    private final ArtistMapper artistMapper;
    private final AlbumMapper albumMapper;

    @GetMapping("/{id}")
    public ResponseEntity<ArtistDto> getArtistById(@PathVariable Integer id) {
        return ResponseEntity.ok(artistMapper.toArtistDto(artistService.getArtistById(id)));
    }

    @GetMapping("/{id}/albums")
    public ResponseEntity<List<AlbumDto>> getAlbumsByArtistId(@PathVariable Integer id) {
        return ResponseEntity.ok(albumMapper.toAlbumDtoList(artistService.getAlbumsByArtist(id)));
    }

}
