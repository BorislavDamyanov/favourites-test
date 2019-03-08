package favouritetest.demo.service.implementations;


import favouritetest.demo.entity.Song;
import favouritetest.demo.repository.SongRepository;
import favouritetest.demo.service.interfaces.ISongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SongServiceImpl implements ISongService {


    @Autowired
    private SongRepository songRepository;

    @Override
    public Song addSong(Song song) {
        return songRepository.save(song);
    }

    @Override
    public Song getSong(Long id) {
        return songRepository.getOne(id);
    }

    @Override
    public List<Song> getAllSongs() {
        return songRepository.findAll();
    }

    @Override
    public void deleteSong(Long id) {
        songRepository.deleteById(id);
    }
}
