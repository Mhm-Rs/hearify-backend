package com.rxhms.hearify.artist.business;

import com.rxhms.hearify.album.business.Album;
import com.rxhms.hearify.album.business.AlbumMapper;
import com.rxhms.hearify.album.dto.AlbumDto;
import com.rxhms.hearify.album.repository.AlbumRepository;
import com.rxhms.hearify.artist.repository.ArtistRepository;
import com.rxhms.hearify.exception.HearifyNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ArtistService {

    private final ArtistRepository artistRepository;
    private final AlbumRepository albumRepository;
    private final AlbumMapper albumMapper;

    private static final String NOT_FOUND_MESSAGE = "The artist with id {0} could not be found.";

    public Artist getArtistById(Integer id) {
        return artistRepository.findById(id).orElseThrow(() -> new HearifyNotFoundException(NOT_FOUND_MESSAGE, id));
    }

    public List<Album> getAlbumsByArtist(Integer artistId) {
        final Artist artist = getArtistById(artistId);
        return albumRepository.findAlbumsByArtistId(artist.getId());
    }

}
