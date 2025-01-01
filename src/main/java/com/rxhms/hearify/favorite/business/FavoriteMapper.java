package com.rxhms.hearify.favorite.business;

import com.rxhms.hearify.favorite.dto.FavoriteDto;
import java.util.List;

import com.rxhms.hearify.track.business.TrackMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class FavoriteMapper {

    private final TrackMapper trackMapper;

    public FavoriteDto toFavoriteDto(Favorite favorite) {
        return FavoriteDto.builder()
                        .track(trackMapper.toTrackDto(favorite.getTrack()))
                        // we don't map userDto and id to avoid redundancy (favorites is only called for a user)
                        .build();
    }

    public List<FavoriteDto> toFavoriteDtoList(List<Favorite> favorites) {
        return favorites.stream().map(this::toFavoriteDto).toList();
    }
}
