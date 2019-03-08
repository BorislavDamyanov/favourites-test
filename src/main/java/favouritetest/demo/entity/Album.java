package favouritetest.demo.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "albums")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Album {



    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    private String albumName;

    @ManyToMany(mappedBy = "albums", targetEntity = Favourites.class)
    private Set<Favourites> favouriteAlbums = new HashSet<>();





}
