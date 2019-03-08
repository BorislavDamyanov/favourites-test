package favouritetest.demo.service.interfaces;

import favouritetest.demo.entity.Artist;

import java.util.List;

public interface IArtistService {

    Artist addArtist(Artist artist);
    List<Artist> getAllArtists();
    Artist getArtist(Long id);
    void deleteArtist(long id);
}
