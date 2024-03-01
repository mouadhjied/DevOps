package tn.esprit.testboutique.Services;

import tn.esprit.testboutique.Entities.Boutique;
import tn.esprit.testboutique.Entities.Categorie;
import tn.esprit.testboutique.Entities.CentreCommercial;
import tn.esprit.testboutique.Entities.Client;

import java.util.List;

public interface ITestBoutiqueServices {
    void ajoutCentre (CentreCommercial centreCommercial);

    void ajouterEtaffecterListeboutique (List<Boutique> lb, Long idCentre);

    void ajouterEtAffecterClientBoutiques(Client client, List<Long> idBoutiques);


    List<Client> listedeClients(Long idBoutique);

    List<Boutique> listedeBoutiques(Long idCentre);

    List<Client> listeDeClientsParCategorie(Categorie categorie);
}
