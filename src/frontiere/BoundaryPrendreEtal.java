package frontiere;

import controleur.ControlPrendreEtal;

public class BoundaryPrendreEtal {
	private ControlPrendreEtal controlPrendreEtal;

	public BoundaryPrendreEtal(ControlPrendreEtal controlChercherEtal) {
		this.controlPrendreEtal = controlChercherEtal;
	}

	public void prendreEtal(String nomVendeur) {
		boolean isVendeurConnu = controlPrendreEtal.verifierIdentite(nomVendeur);
		if (!isVendeurConnu) {
			System.out.println("Je suis désolé" + nomVendeur + "mais il faut être un habitant de notre village pour commercer ici.");
		} else {
			System.out.println("Bonjour " + nomVendeur + " je vais regarder si j'ai un étal de disponnible.");
			if (!controlPrendreEtal.resteEtals()) {
				System.out.println("Je suis désolé" + nomVendeur + "mais il n'y a plus d'etals disponnibles.");
			} else {
				installerVendeur(nomVendeur);
			}
		}
	}

	private void installerVendeur(String nomVendeur) {
		Clavier clavier = new Clavier();
		String produit = "";
		int nbProduit = 0;
		System.out.println("C'est parfait j'ai un étal pour vous");
		System.out.println("J'aurais besoin de quelques renseignements.");
		System.out.println("Quel produit souhaitez vous vendre ? : ");
		clavier.entrerChaine(produit);
		System.out.println("Combien souhaitez vous vendre ? : ");
		clavier.entrerEntier(String.valueOf(nbProduit));
		int numEtal = controlPrendreEtal.prendreEtal(nomVendeur, produit, nbProduit);
		if (numEtal != -1) {
			System.out.println("Le vendeur "+ nomVendeur + "S'est installé a l'étal n°: " + numEtal);
		}
	}
}
