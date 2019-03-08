package favouritetest.demo.service.interfaces;

import favouritetest.demo.entity.Genre;

import javax.persistence.GeneratedValue;
import java.util.List;

public interface IGenreService {

    Genre addGenre (Genre genre);
    Genre getGenre(Long id);
    List<Genre> getAllGenres();
    void deleteGenre(Long id);


}
