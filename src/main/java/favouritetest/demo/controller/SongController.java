package favouritetest.demo.controller;


import favouritetest.demo.entity.Song;
import favouritetest.demo.service.interfaces.ISongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
public class SongController {

    @Autowired
    private ISongService songService;


    @GetMapping("/songs")
    public List<Song> retrieveAllSongs(){
        return songService.getAllSongs();
    }

    @GetMapping("/songs/{id}")
    public Song getSong(@PathVariable("id")Long id){
        return songService.getSong(id);
    }

    @DeleteMapping("/songs/{id}")
    public void removeSong(@PathVariable("id")Long id){
        songService.deleteSong(id);
    }

    @PostMapping("/songs")
    public ResponseEntity addSong(@RequestBody Song song){
        Song savedSong = songService.addSong(song);

        URI location  = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(savedSong.getId()).toUri();
       return ResponseEntity.created(location).build();
    }

}
