package favouritetest.demo.controller;


import favouritetest.demo.entity.Favourites;
import favouritetest.demo.service.interfaces.IFavouritesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
public class FavouritesController {


    @Autowired
    private IFavouritesService favouritesService;

    @GetMapping("/favourites")
    public List<Favourites> retrieveAllFavourites(){
        return favouritesService.getAllFavourites();
    }

    @GetMapping("/favourites/{id}")
    public Favourites retrieveFavourites(@PathVariable("id")Long id){
        return favouritesService.getFavourites(id);
    }

    @DeleteMapping("/favourites/{id}")
    public void deleteFavourites(@PathVariable("id")Long id){
         favouritesService.deleteFavourites(id);

    }

    @PostMapping("/favourites")
    public ResponseEntity saveUser(@RequestBody Favourites favourites){
        Favourites savedFavourites = favouritesService.addFavourites(favourites);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(savedFavourites.getId()).toUri();

        return ResponseEntity.created(location).build();
    }



}
