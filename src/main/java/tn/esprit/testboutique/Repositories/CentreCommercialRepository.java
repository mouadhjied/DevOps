package tn.esprit.testboutique.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.testboutique.Entities.CentreCommercial;
import tn.esprit.testboutique.Entities.Client;

public interface CentreCommercialRepository extends JpaRepository<CentreCommercial,Long> {
}
