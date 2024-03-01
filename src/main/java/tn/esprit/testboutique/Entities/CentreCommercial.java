package tn.esprit.testboutique.Entities;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.io.Serializable;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class CentreCommercial implements Serializable {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    Long idCentre;
    String nomCentre;
    String adresseCentre ;
    String login ;
    String Password ;
    @OneToMany(mappedBy = "centreCommercial", cascade = CascadeType.ALL)
    Set<Boutique>boutiques ;
    @ManyToMany
    Set<Client> clients ;
}
