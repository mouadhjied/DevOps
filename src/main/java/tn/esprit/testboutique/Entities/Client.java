package tn.esprit.testboutique.Entities;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.io.Serializable;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Client implements Serializable{
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    Long idClient;
    String nomClient;
    @Enumerated(EnumType.STRING)
    Genre genre;
    @ManyToMany
    List<Boutique> boutiques ;
}
