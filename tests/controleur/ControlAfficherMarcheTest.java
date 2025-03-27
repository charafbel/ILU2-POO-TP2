package controleur;

import personnages.Gaulois;
import villagegaulois.Village;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ControlAfficherMarcheTest {

    private ControlAfficherMarche controlAfficherMarche;
    private Village village;

    @BeforeEach
    void setUp() {
        village = new Village("village", 10, 10);

        // Ajout d'habitants
        Gaulois panoramix = new Gaulois("Panoramix", 5);
        Gaulois youcef = new Gaulois("youcef", 4);
        village.ajouterHabitant(panoramix);
        village.ajouterHabitant(youcef);
        village.installerVendeur(panoramix, "potion", 5);
        village.installerVendeur(youcef, "poisson", 10);
        controlAfficherMarche = new ControlAfficherMarche(village);
    }

    @Test
    void donnerInfosMarche() {
        String[] infos = controlAfficherMarche.donnerInfosMarche();
        assertNotNull(infos);
        assertEquals(6, infos.length);

        assertTrue(infos[0].contains("Panoramix"));
        assertTrue(infos[1].contains("5"));
        assertTrue(infos[2].contains("potion"));

        assertTrue(infos[3].contains("youcef"));
        assertTrue(infos[4].contains("10"));
        assertTrue(infos[5].contains("poisson"));
    }
}