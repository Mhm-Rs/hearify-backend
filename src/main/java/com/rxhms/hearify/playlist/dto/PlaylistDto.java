package com.rxhms.hearify.playlist.dto;

import com.rxhms.hearify.track.dto.TrackDto;
import com.rxhms.hearify.user.dto.UserDto;
import lombok.Builder;

import java.util.List;

@Builder
public record PlaylistDto(Integer id, String name, UserDto user, List<TrackDto> tracks) {}
