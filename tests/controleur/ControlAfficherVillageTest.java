package controleur;

import personnages.Chef;
import personnages.Gaulois;
import villagegaulois.Village;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ControlAfficherVillageTest {

    private ControlAfficherVillage controlAfficherVillage;
    private Village village;

    @BeforeEach
    void setUp() {
        village = new Village("Village des irréductibles", 10, 5);
        controlAfficherVillage = new ControlAfficherVillage(village);
        village.setChef(new Chef("youcef", 10, village));
        // Ajout de quelques habitants
        village.ajouterHabitant(new Gaulois("Astérix", 6));
        village.ajouterHabitant(new Gaulois("Obélix", 8));
        village.ajouterHabitant(new Gaulois("Abraracourcix", 5));
    }

    @Test
    void donnerNomsVillageois() {
        String[] noms = controlAfficherVillage.donnerNomsVillageois();
        assertNotNull(noms);
        assertEquals(4, noms.length);
        assertTrue(noms[0].equals("youcef"));
        assertTrue(noms[1].equals("Astérix"));
        assertTrue(noms[2].equals("Obélix"));
        assertTrue(noms[3].equals("Abraracourcix"));
    }

    @Test
    void donnerNomVillage() {
        String nom = controlAfficherVillage.donnerNomVillage();
        assertEquals("Village des irréductibles", nom);
    }

    @Test
    void donnerNbEtals() {
        int nbEtals = controlAfficherVillage.donnerNbEtals();
        assertEquals(5, nbEtals);
    }
}