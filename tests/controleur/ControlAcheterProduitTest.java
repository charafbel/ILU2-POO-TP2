package controleur;

import personnages.Chef;
import personnages.Druide;
import personnages.Gaulois;
import villagegaulois.Etal;
import villagegaulois.Village;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ControlAcheterProduitTest {

    private ControlAcheterProduit controlAcheterProduit;
    private Village village;
    private ControlVerifierIdentite verifierIdentite;
    private ControlTrouverEtalVendeur trouverEtalVendeur;

    private Chef asterix;
    private Gaulois panoramix;
    private Druide bonemine;
    private Etal etal;


    @BeforeEach
    void setUp() {
        village = new Village("village", 10, 10);

        asterix = new Chef("Asterix", 10, village);
        panoramix = new Gaulois("Panoramix", 5);
        bonemine = new Druide("Bonemine", 8, 1, 7);

        village.setChef(asterix);
        village.ajouterHabitant(panoramix);
        village.installerVendeur(panoramix, "potion", 10);

        verifierIdentite = new ControlVerifierIdentite(village);
        trouverEtalVendeur = new ControlTrouverEtalVendeur(village);
        controlAcheterProduit = new ControlAcheterProduit(verifierIdentite, trouverEtalVendeur, village
        );
    }

    @Test
    void verifierIdentite() {
        village.ajouterHabitant(new Gaulois("Charaf", 10));
        assertTrue(controlAcheterProduit.verifierIdentite("Charaf"));
        assertFalse(controlAcheterProduit.verifierIdentite("Inconnu"));
    }

    @Test
    void rechercherVendeursParProduit() {
        Gaulois[] vendeurs = controlAcheterProduit.rechercherVendeursParProduit("potion");
        assertEquals(1, vendeurs.length);
        assertEquals("Panoramix", vendeurs[0].getNom());
    }

    @Test
    void rechercherEtal() {
        Etal etal = controlAcheterProduit.rechercherEtal("Panoramix");
        assertNotNull(etal);
        assertEquals(10, etal.getQuantite());
    }

    @Test
    void acheterProduit() {
        int achete = controlAcheterProduit.acheterProduit("Panoramix", 4);
        assertEquals(4, achete);

        achete = controlAcheterProduit.acheterProduit("Panoramix", 10);
        assertEquals(6, achete); // car il restait 6 après le premier achat
    }

    @Test
    void donnerEtatMarche() {
        String[] etat = controlAcheterProduit.donnerEtatMarche();
        assertNotNull(etat);
        assertEquals(3, etat.length);
        assertTrue(etat[0].contains("Panoramix"));
        assertTrue(etat[2].contains("potion"));
    }
}