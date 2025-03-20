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

	public Etal rechercherEtal(Gaulois vendeur) {
		return village.rechercherEtal(vendeur);
	}

	public boolean acheterProduit(Gaulois vendeur, int quantite){
		Etal etal = village.rechercherEtal(vendeur);
		if (quantite > etal.getQuantite()){
			return false;
		} else {
			etal.acheterProduit(quantite);
		}
		return true;
	}

	public String[] donnerEtatMarche(){
		return village.donnerEtatMarche();
	}

}
