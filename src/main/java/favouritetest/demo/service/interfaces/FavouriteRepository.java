package favouritetest.demo.service.interfaces;


import favouritetest.demo.entity.Favourites;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FavouriteRepository extends JpaRepository<Favourites, Long> {
}
