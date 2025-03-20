package controleur;

import villagegaulois.Etal;

public class ControlLibererEtal {
	private ControlTrouverEtalVendeur controlTrouverEtalVendeur;

	public ControlLibererEtal(
			ControlTrouverEtalVendeur controlTrouverEtalVendeur) {
		this.controlTrouverEtalVendeur = controlTrouverEtalVendeur;
	}

	public boolean isVendeur(String nomVendeur) {
		return controlTrouverEtalVendeur.trouverEtalVendeur(nomVendeur) != null;
	}

	/**
	 * 
	 * @param nomVendeur
	 * @return donneesEtal est un tableau de chaine contenant
	 * 		[0] : un boolean indiquant si l'étal est occupé
	 * 		[1] : nom du vendeur
	 * 		[2] : produit vendu
	 * 		[3] : quantité de produit à vendre au début du marché
	 * 		[4] : quantité de produit vendu
	 */
	public String[] libererEtal(String nomVendeur) {
		Etal etalVendeur = controlTrouverEtalVendeur.trouverEtalVendeur(nomVendeur);
		int nul = 0;
		if (etalVendeur == null) {
			nul = 1;
		} else {
			String[] donneesEtal = etalVendeur.etatEtal();
			etalVendeur.libererEtal();
			if (nul == 1) {
				donneesEtal[0] = "false";
			} else {
				donneesEtal[0] = "true";
			}
			return donneesEtal;

		}
		return null;
	}

}
