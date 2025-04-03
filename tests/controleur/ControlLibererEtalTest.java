package controleur;

import personnages.Chef;
import personnages.Gaulois;
import villagegaulois.Etal;
import villagegaulois.Village;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ControlLibererEtalTest {

    private ControlLibererEtal controlLibererEtal;
    private ControlTrouverEtalVendeur controlTrouverEtalVendeur;
    private Village village;
    private Etal etal;

    @BeforeEach
    void setUp() {
        // Initialisation du village avec des paramètres fictifs
        village = new Village("Namek", 15, 10);
        village.setChef(new Chef("Karim", 1, village));
        // Initialisation de ControlTrouverEtalVendeur et ControlLibererEtal
        controlTrouverEtalVendeur = new ControlTrouverEtalVendeur(village);
        controlLibererEtal = new ControlLibererEtal(controlTrouverEtalVendeur);

        // Initialisation d'un étal
        etal = new Etal();
        // Ajouter un vendeur fictif avec un étal dans le village
        Gaulois gaulois = new Gaulois("Vegeta", 9000);
        village.ajouterHabitant(gaulois);
        etal.occuperEtal(gaulois, "Senzu", 1000);
    }

    @Test
    void testVendeurExistence() {
        String vendeurNom = "Vegeta";
        boolean result = controlLibererEtal.isVendeur(vendeurNom);
        assertTrue(result, "Le vendeur devrait exister");
    }

    @Test
    void testKakarot() {
        String vendeurNom = "Kakarot";
        boolean result = controlLibererEtal.isVendeur(vendeurNom);
        assertFalse(result, "Le vendeur ne devrait pas exister");
    }

    @Test
    void testLibererEtalWithExistingVendeur() {
        String vendeurNom = "Vegeta";
        String[] result = controlLibererEtal.libererEtal(vendeurNom);
        assertNotNull(result, "Les données de l'étal ne devraient pas être nulles");
        assertEquals("true", result[0], "L'étal devrait être marqué comme occupé");
        assertEquals(vendeurNom, result[1], "Le nom du vendeur devrait correspondre");
    }

    @Test
    void testLibererEtalWithInexistantVendeur() {
        // Arrange
        String vendeurNom = "Kakarot";

        // Act
        String[] result = controlLibererEtal.libererEtal(vendeurNom);

        // Assert
        assertNull(result, "Les données devraient être nulles si l'étal n'existe pas");
    }
}