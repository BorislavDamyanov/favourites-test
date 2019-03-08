package favouritetest.demo.service.implementations;

import favouritetest.demo.entity.Album;
import favouritetest.demo.repository.AlbumRepository;
import favouritetest.demo.service.interfaces.IAlbumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class AlbumServiceImpl implements IAlbumService {

    @Autowired
    private AlbumRepository albumRepository;



    @Override
    public Album addAlbum(Album album) {
        return albumRepository.save(album);
    }

    @Override
    public Album getAlbum(Long id) {
        return albumRepository.getOne(id);
    }

    @Override
    public List<Album> getAllAlbums() {
        return albumRepository.findAll();
    }

    @Override
    public void deleteAlbum(Long id) {
        albumRepository.deleteById(id);
    }
}
