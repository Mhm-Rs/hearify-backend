package com.rxhms.hearify.track;

import com.rxhms.hearify.track.business.TrackMapper;
import com.rxhms.hearify.track.business.TrackService;
import com.rxhms.hearify.track.dto.TrackDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/api/tracks")
@RequiredArgsConstructor
public class TrackController {

    private final TrackService trackService;
    private final TrackMapper trackMapper;

    @GetMapping("/{id}")
    public ResponseEntity<TrackDto> getTrackById(@PathVariable Integer id) {
        return ResponseEntity.ok(trackMapper.toTrackDto(trackService.getTrackById(id)));
    }

}
