package favouritetest.demo.service.implementations;


import favouritetest.demo.entity.Favourites;
import favouritetest.demo.service.interfaces.FavouriteRepository;
import favouritetest.demo.service.interfaces.IFavouritesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FavouriteServiceImpl implements IFavouritesService {

    @Autowired
    private FavouriteRepository favouriteRepository;

    @Override
    public Favourites addFavourites(Favourites favourites) {
        return favouriteRepository.save(favourites);
    }

    @Override
    public Favourites getFavourites(Long id) {
        return favouriteRepository.getOne(id);
    }

    @Override
    public List<Favourites> getAllFavourites() {
        return favouriteRepository.findAll();
    }

    @Override
    public void deleteFavourites(Long id) {
        favouriteRepository.deleteById(id);
    }
}
