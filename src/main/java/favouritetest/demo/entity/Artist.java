package favouritetest.demo.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "artists")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Artist {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String artistName;

    @ManyToMany(mappedBy = "artists", targetEntity = Favourites.class)
    private Set<Favourites> favouriteArtist = new HashSet<>();


}
