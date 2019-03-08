package favouritetest.demo.service.implementations;


import favouritetest.demo.entity.Genre;
import favouritetest.demo.repository.GenreRepository;
import favouritetest.demo.service.interfaces.IGenreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GenreServiceImpl implements IGenreService {

    @Autowired
    private GenreRepository genreRepository;



    @Override
    public Genre addGenre(Genre genre) {
        return genreRepository.save(genre);
    }

    @Override
    public Genre getGenre(Long id) {
        return genreRepository.getOne(id);
    }

    @Override
    public List<Genre> getAllGenres() {
        return genreRepository.findAll();
    }

    @Override
    public void deleteGenre(Long id) {
        genreRepository.deleteById(id);
    }
}
