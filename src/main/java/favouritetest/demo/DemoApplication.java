package favouritetest.demo;

import favouritetest.demo.entity.*;
import favouritetest.demo.repository.AlbumRepository;
import favouritetest.demo.repository.ArtistRepository;
import favouritetest.demo.repository.GenreRepository;
import favouritetest.demo.repository.SongRepository;
import favouritetest.demo.service.interfaces.FavouriteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.lang.model.type.ArrayType;
import java.util.HashSet;
import java.util.Set;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner {

    @Autowired
    private FavouriteRepository favouriteRepository;

    @Autowired
    private AlbumRepository albumRepository;

    @Autowired
    private ArtistRepository artistRepository;

    @Autowired
    private SongRepository songRepository;

    @Autowired
    private GenreRepository genreRepository;


    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {


        Album album1 = new Album();
        album1.setAlbumName("FirstAlbum");
        albumRepository.save(album1);

        Album album2 = new Album();
        album2.setAlbumName("SecondAlbum");
        albumRepository.save(album2);

        Album album3 = new Album();
        album3.setAlbumName("ThirdAlbum");
        albumRepository.save(album3);




        Set<Album> albums = new HashSet<>();
        albums.add(album1);
        albums.add(album2);
        albums.add(album3);





        Artist artist1 = new Artist();
        artist1.setArtistName("Nirvana");
        artistRepository.save(artist1);


        Artist artist2 = new Artist();
        artist2.setArtistName("Pearl Jam");
        artistRepository.save(artist2);


        Artist artist3 = new Artist();
        artist3.setArtistName("RedHotChill");
        artistRepository.save(artist3);

        Set<Artist> artists = new HashSet<>();
        artists.add(artist1);
        artists.add(artist2);
        artists.add(artist3);






        Song song1 = new Song();
        song1.setSongName("nevermind");
        songRepository.save(song1);


        Song song2 = new Song();
        song2.setSongName("Even flow");
        songRepository.save(song2);

        Song song3 = new Song();
        song3.setSongName("The chilly ");
        songRepository.save(song3);

        Set<Song> songs = new HashSet<>();
        songs.add(song1);
        songs.add(song2);
        songs.add(song3);


        Genre genre1 = new Genre();
        genre1.setGenreName("Rock");
        genreRepository.save(genre1);


        Genre genre2 = new Genre();
        genre2.setGenreName("Grunge");
        genreRepository.save(genre2);


        Genre genre3 = new Genre();
        genre3.setGenreName("Rock");
        genreRepository.save(genre3);


        Set<Genre> genres = new HashSet<>();
        genres.add(genre1);
        genres.add(genre2);
        genres.add(genre3);



        Favourites favourites1 = new Favourites();
        favourites1.setAlbums(albums);
        favourites1.setArtists(artists);
        favourites1.setGenres(genres);
        favourites1.setSongs(songs);

        favouriteRepository.save(favourites1);



    }
}
