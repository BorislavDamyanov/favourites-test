package favouritetest.demo.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "favourites")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Favourites {



    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToMany
    @JoinTable(name = "favourite_albums",
            joinColumns = @JoinColumn(name = "favourite_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "album_id", referencedColumnName = "id"))
    private Set<Album> albums =new HashSet<>();

    @ManyToMany
    @JoinTable(name = "favourite_artists",
            joinColumns = @JoinColumn(name = "favourite_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "artist_id", referencedColumnName = "id"))
    private Set<Artist> artists =new HashSet<>();


    @ManyToMany
    @JoinTable(name = "favourite_songs",
            joinColumns = @JoinColumn(name = "favourite_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "song_id", referencedColumnName = "id"))
    private Set<Song> songs =new HashSet<>();

    @ManyToMany
    @JoinTable(name = "favourite_genres",
            joinColumns = @JoinColumn(name = "favourite_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "genre_id", referencedColumnName = "id"))
    private Set<Genre> genres =new HashSet<>();



}
