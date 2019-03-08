package favouritetest.demo.service.interfaces;

import favouritetest.demo.entity.Album;
import lombok.AllArgsConstructor;

import java.util.List;

public interface IAlbumService {

     Album addAlbum(Album album);
     Album getAlbum (Long id);
     List<Album> getAllAlbums();
     void deleteAlbum(Long id);


}
