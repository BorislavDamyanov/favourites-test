package favouritetest.demo.service.implementations;


import favouritetest.demo.entity.Artist;
import favouritetest.demo.repository.ArtistRepository;
import favouritetest.demo.service.interfaces.IArtistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArtistServiceImpl implements IArtistService {

    @Autowired
    private ArtistRepository artistRepository;

    @Override
    public Artist addArtist(Artist artist) {
        return artistRepository.save(artist);
    }

    @Override
    public List<Artist> getAllArtists() {
        return artistRepository.findAll();
    }

    @Override
    public Artist getArtist(Long id) {
        return artistRepository.getOne(id);
    }

    @Override
    public void deleteArtist(long id) {
        artistRepository.deleteById(id);
    }
}
