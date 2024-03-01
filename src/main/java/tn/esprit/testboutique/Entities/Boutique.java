package tn.esprit.testboutique.Entities;
import com.fasterxml.jackson.annotation.JsonIgnore;
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
public class Boutique implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long idBoutique;
    String nomBoutique;
    @Enumerated(EnumType.STRING)
    Categorie categorie;
    @JsonIgnore
    @ManyToOne
    CentreCommercial centreCommercial;
    @JsonIgnore
    @ManyToMany
    List<Client> clients;
}

