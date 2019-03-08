package favouritetest.demo.controller;


import favouritetest.demo.entity.Genre;
import favouritetest.demo.service.interfaces.IGenreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
public class GenreController {

    @Autowired
    private IGenreService genreService;


    @GetMapping("/genres")
    public List<Genre> retrieveAllGenres(){
        return genreService.getAllGenres();
    }

    @GetMapping("/genres/{id}")
    public Genre retrieveGenre(@PathVariable("id")Long id){
        return genreService.getGenre(id);
    }

    @DeleteMapping("/genres/{id}")
    public void deleteGenre(@PathVariable("id")Long id){
         genreService.deleteGenre(id);
    }

    @PostMapping("/genres")
    public ResponseEntity saveUser(@RequestBody Genre genre){
        Genre savedGenre = genreService.addGenre(genre);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(savedGenre.getId()).toUri();

        return ResponseEntity.created(location).build();
    }
}
