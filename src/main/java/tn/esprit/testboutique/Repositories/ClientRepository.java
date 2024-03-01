package tn.esprit.testboutique.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import tn.esprit.testboutique.Entities.Categorie;
import tn.esprit.testboutique.Entities.Client;
import tn.esprit.testboutique.Entities.Genre;

import java.util.List;

public interface ClientRepository extends JpaRepository<Client,Long> {

    List<Client> findByBoutiquesIdBoutique(Long idBoutique);

    List<Client> findByBoutiquesCategorie(Categorie categorie);

    @Query(" select count(c) from Client c where c.genre=:genre")
    int getClientByGenre(@Param("genre") Genre genre);
}
