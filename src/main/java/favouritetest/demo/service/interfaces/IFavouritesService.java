package favouritetest.demo.service.interfaces;

import favouritetest.demo.entity.Favourites;

import java.util.List;

public interface IFavouritesService {


    Favourites addFavourites(Favourites favourites);
    Favourites getFavourites(Long id);
    List<Favourites> getAllFavourites();
    void deleteFavourites(Long id);


}
