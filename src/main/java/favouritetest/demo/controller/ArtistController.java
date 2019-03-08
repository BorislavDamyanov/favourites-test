package favouritetest.demo.controller;


import favouritetest.demo.entity.Artist;
import favouritetest.demo.service.interfaces.IArtistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
public class ArtistController {

    @Autowired
    private IArtistService artistService;

    @GetMapping("/artists")
    public List<Artist> retrieveAllArtist(){
        return artistService.getAllArtists();
    }

    @GetMapping("/artists/{id}")
    public Artist retrieveArtist(@PathVariable("id")Long id){
        return artistService.getArtist(id);
    }

    @DeleteMapping("/artists/{id}")
    public void removeArtist(@PathVariable("id")Long id){
        artistService.deleteArtist(id);
    }

    @PostMapping
    public ResponseEntity addArtist(@RequestBody Artist artist){
        Artist savedArtist = artistService.addArtist(artist);


        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}") .buildAndExpand(savedArtist.getId()).toUri();

        return ResponseEntity.created(location).build();
    }
}
