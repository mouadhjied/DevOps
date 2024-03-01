package tn.esprit.testboutique.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.testboutique.Entities.Boutique;
import tn.esprit.testboutique.Entities.CentreCommercial;

import java.util.List;

public interface BoutiqueRepository extends JpaRepository<Boutique,Long> {
    List<Boutique> findByCentreCommercialIdCentre(Long idCentre);
}
