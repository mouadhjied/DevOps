package tn.esprit.testboutique.Controllers;

import jakarta.websocket.server.PathParam;
import org.springframework.web.bind.annotation.*;
import tn.esprit.testboutique.Entities.Boutique;
import tn.esprit.testboutique.Entities.Categorie;
import tn.esprit.testboutique.Entities.CentreCommercial;
import tn.esprit.testboutique.Entities.Client;
import tn.esprit.testboutique.Services.TestBoutiqueServices;

import java.util.List;

@RestController
@RequestMapping("boutique")
public class TestBoutiqueControllers {

    TestBoutiqueServices testBoutiqueServices ;

    public TestBoutiqueControllers(TestBoutiqueServices testBoutiqueServices) {
        this.testBoutiqueServices = testBoutiqueServices;
    }

    @PostMapping("/add-centre")
    public void ajoutCentre(@RequestBody CentreCommercial centre) {
        testBoutiqueServices.ajoutCentre(centre);
    }

    @PostMapping("/add-listeBoutique/{idCentre}")
    void ajouterEtaffecterListeboutique(@RequestBody List<Boutique> lb, @PathVariable("idCentre") Long idCentre) {
        testBoutiqueServices.ajouterEtaffecterListeboutique(lb, idCentre);
    }

    @PostMapping("/add-Client")
    public void ajouterEtAffecterClientBoutiques(@RequestBody Client client, @RequestParam(value="idBoutiques") List<Long> idBoutiques) {
        testBoutiqueServices.ajouterEtAffecterClientBoutiques(client, idBoutiques);
    }
    @GetMapping("/list-clients/{idBoutique}")
    public List<Client> listedeClients(@PathVariable("idBoutique") Long idBoutique){
       return testBoutiqueServices.listedeClients(idBoutique) ;
    }

    @GetMapping("/list-boutiques/{idCentre}")
    public List<Boutique> listedeBoutiques(@PathVariable ("idCentre") Long idCentre){
        return testBoutiqueServices.listedeBoutiques(idCentre);
    }
    @GetMapping("/liste-clientParCategorie/{categorie}")
    List<Client> listeDeClientsParCategorie(@PathVariable("categorie") Categorie categorie){
        return testBoutiqueServices.listeDeClientsParCategorie(categorie);
    }
}
