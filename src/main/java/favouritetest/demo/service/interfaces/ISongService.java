package favouritetest.demo.service.interfaces;

import favouritetest.demo.entity.Song;

import java.util.List;

public interface ISongService {

    Song addSong(Song song);
    Song getSong(Long id);
    List<Song> getAllSongs();
    void deleteSong(Long id);

}
