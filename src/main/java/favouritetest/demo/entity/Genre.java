package favouritetest.demo.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "genres")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Genre {

    @Id
    @GeneratedValue
    private Long id;

    private String genreName;

    @ManyToMany(mappedBy = "genres", targetEntity = Favourites.class)
    private Set<Favourites> favouriteGenres = new HashSet<>();
}
