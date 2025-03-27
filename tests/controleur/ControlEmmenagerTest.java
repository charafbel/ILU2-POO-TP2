package controleur;

import personnages.Druide;
import personnages.Gaulois;
import villagegaulois.Village;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ControlEmmenagerTest {

    private ControlEmmenager controlEmmenager;
    private Village village;

    @BeforeEach
    void setUp() {
        village = new Village("Village des irréductibles", 10, 5);
        controlEmmenager = new ControlEmmenager(village);
    }

    @Test
    void isHabitant() {
        assertFalse(controlEmmenager.isHabitant("Panoramix"));

        controlEmmenager.ajouterGaulois("Astérix", 6);
        assertTrue(controlEmmenager.isHabitant("Astérix"));
    }

    @Test
    void ajouterDruide() {
        controlEmmenager.ajouterDruide("Panoramix", 5, 1, 3);

        // Vérifie que le druide est bien ajouté
        assertTrue(controlEmmenager.isHabitant("Panoramix"));

        // Vérifie que c'est bien un Druide
        assertTrue(village.trouverHabitant("Panoramix") instanceof Druide);
    }

    @Test
    void ajouterGaulois() {
        controlEmmenager.ajouterGaulois("Obélix", 10);

        assertTrue(controlEmmenager.isHabitant("Obélix"));
        assertTrue(village.trouverHabitant("Obélix") instanceof Gaulois);
    }
}