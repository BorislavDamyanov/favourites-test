package favouritetest.demo.controller;


import favouritetest.demo.entity.Album;
import favouritetest.demo.service.interfaces.IAlbumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
public class AlbumController {

    @Autowired
    private IAlbumService albumService;

    @GetMapping("/albums")
    public List<Album> retrieveAllAlbums(){
        return albumService.getAllAlbums();
    }

    @GetMapping("/albums/{id}")
    public Album retrieveAlbum(@PathVariable("id")Long id){
        return albumService.getAlbum(id);
    }

    @DeleteMapping("/albums/{id}")
    public void removeAlbum(@PathVariable("id")Long id){
         albumService.deleteAlbum(id);
    }


    @PostMapping(value = "/albums")
    public ResponseEntity addAlbum(@RequestBody Album album){
        Album savedAlbum = albumService.addAlbum(album);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(savedAlbum.getId()).toUri();

        return ResponseEntity.created(location).build();
    }


}
