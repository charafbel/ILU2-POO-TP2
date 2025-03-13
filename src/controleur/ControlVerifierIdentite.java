package controleur;

import personnages.Chef;
import personnages.Gaulois;
import villagegaulois.Village;

public class ControlVerifierIdentite {
	private Village village;

	public ControlVerifierIdentite(Village village) {
		this.village = village;
	}

	public boolean verifierIdentite(String nomVendeur) {
		return village.trouverHabitant(nomVendeur) != null;
	}
}

