package com.rxhms.hearify.album;

import com.rxhms.hearify.album.business.AlbumMapper;
import com.rxhms.hearify.album.business.AlbumService;
import com.rxhms.hearify.album.dto.AlbumDto;
import com.rxhms.hearify.track.business.TrackMapper;
import com.rxhms.hearify.track.dto.TrackDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/api/albums")
@RequiredArgsConstructor
public class AlbumController {

    private final AlbumService albumService;
    private final AlbumMapper albumMapper;
    private final TrackMapper trackMapper;

    @GetMapping("/{id}")
    public ResponseEntity<AlbumDto> getAlbumById(@PathVariable Integer id) {
        return ResponseEntity.ok(albumMapper.toAlbumDto(albumService.getAlbumById(id)));
    }

    @GetMapping("/{id}/tracks")
    public ResponseEntity<List<TrackDto>> getAlbumTracks(@PathVariable Integer id) {
        return ResponseEntity.ok(trackMapper.toTrackDtoList(albumService.getAlbumTracks(id)));
    }

}
