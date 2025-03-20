package controleur;

import personnages.Gaulois;
import villagegaulois.Village;
import villagegaulois.Etal;


public class ControlAcheterProduit {
	private Village village;
	private ControlTrouverEtalVendeur controlTrouverEtalVendeur;
	private ControlVerifierIdentite controlVerifierIdentite;

	public ControlAcheterProduit(ControlVerifierIdentite controlVerifierIdentite,
			ControlTrouverEtalVendeur controlTrouverEtalVendeur,
			Village village) {
		this.village = village;
		this.controlVerifierIdentite = controlVerifierIdentite;
		this.controlTrouverEtalVendeur = controlTrouverEtalVendeur;
	}

	public boolean verifierIdentite(String nomClient){
		return controlVerifierIdentite.verifierIdentite(nomClient);
	}

	public Gaulois[] rechercherVendeursParProduit(String produit){
		return village.rechercherVendeursProduit(produit);
	}

	public Etal rechercherEtal(String nomVendeur){
		Gaulois vendeur = village.trouverHabitant(nomVendeur);
		return village.rechercherEtal(vendeur);
	}

	public Integer acheterProduit(String nomVendeur, int quantite){
		Gaulois vendeur = village.trouverHabitant(nomVendeur);
		Etal etal = village.rechercherEtal(vendeur);
		if (quantite > etal.getQuantite()){
			return etal.getQuantite();
		} else {
			etal.acheterProduit(quantite);
		}
		return quantite;
	}

	public String[] donnerEtatMarche(){
		return village.donnerEtatMarche();
	}

}
