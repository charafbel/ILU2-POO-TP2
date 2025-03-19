package frontiere;

import controleur.ControlAfficherMarche;

public class BoundaryAfficherMarche {
	private ControlAfficherMarche controlAfficherMarche;

	public BoundaryAfficherMarche(ControlAfficherMarche controlAfficherMarche) {
		this.controlAfficherMarche = controlAfficherMarche;
	}

	public void afficherMarche(String nomAcheteur) {
		String[] infosMarche = controlAfficherMarche.donnerEtatMarche();
		int i = 0;
		String vendeur;
		String quantite;
		String produit;
		if (infosMarche.length == 0){
			System.out.println("Le marché est vide revenez plus tard.");
		} else {
			System.out.println(nomAcheteur + "Vous trouverez au marché : ");
			do {
				vendeur = infosMarche[i];
				i++;
				quantite = infosMarche[i];
				i++;
				produit = infosMarche[i];
				i++;
				System.out.println("- " + vendeur +
						" qui vend : " + quantite + " " + produit);

			} while (i < infosMarche.length);
		}

	}
}
