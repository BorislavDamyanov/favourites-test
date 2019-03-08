package favouritetest.demo.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "songs")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Song {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String songName;

    @ManyToMany(mappedBy = "songs", targetEntity = Favourites.class)
    private Set<Favourites> favouriteSongs = new HashSet<>();


}
