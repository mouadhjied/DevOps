package tn.esprit.testboutique.Services;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import tn.esprit.testboutique.Entities.*;
import tn.esprit.testboutique.Repositories.BoutiqueRepository;
import tn.esprit.testboutique.Repositories.CentreCommercialRepository;
import tn.esprit.testboutique.Repositories.ClientRepository;

import java.util.List;

@Service
@AllArgsConstructor
@Slf4j
public class TestBoutiqueServices implements ITestBoutiqueServices {
    BoutiqueRepository boutiqueRepository ;
    CentreCommercialRepository centreCommercialRepository ;
    ClientRepository clientRepository ;
    @Override
    public void ajoutCentre(CentreCommercial centreCommercial){
        centreCommercialRepository.save(centreCommercial);
    }

    @Override
     public void ajouterEtaffecterListeboutique(List<Boutique> lb, Long idCentre){
         CentreCommercial centreCommercial = centreCommercialRepository.findById(idCentre).orElse(null);
         for (Boutique boutique : lb) {
             boutique.setCentreCommercial(centreCommercial);
         }
         boutiqueRepository.saveAll(lb);
     }
    @Override
     public void ajouterEtAffecterClientBoutiques(Client client, List<Long> idBoutiques){
        List<Boutique> boutiques = boutiqueRepository.findAllById(idBoutiques);
        client.setBoutiques(boutiques);
        clientRepository.save(client);
    }
    @Override
    public List<Client> listedeClients(Long idBoutique){
        return clientRepository.findByBoutiquesIdBoutique(idBoutique);

    }
    @Override
    public List<Boutique> listedeBoutiques(Long idCentre){
        return boutiqueRepository.findByCentreCommercialIdCentre(idCentre);
    }
    @Override
    public List<Client> listeDeClientsParCategorie(Categorie categorie){
        return clientRepository.findByBoutiquesCategorie(categorie);
    }
    @Scheduled(fixedDelay = 30000)
    void nbreClientParGenre() {
        int nbrFeminin = clientRepository.getClientByGenre(Genre.FEMININ);
        int nbrMasculin = clientRepository.getClientByGenre(Genre.MASCULIN);
        log.info("Nombre des clients Feminins : " + nbrFeminin);
        log.info("Nombre des clients Masculins : " + nbrMasculin);
    }


}


