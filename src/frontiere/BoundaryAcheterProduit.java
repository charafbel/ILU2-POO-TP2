package frontiere;

import controleur.ControlAcheterProduit;
import personnages.Gaulois;
import villagegaulois.Etal;


public class BoundaryAcheterProduit {
	private ControlAcheterProduit controlAcheterProduit;

	public BoundaryAcheterProduit(ControlAcheterProduit controlAcheterProduit) {
		this.controlAcheterProduit = controlAcheterProduit;
	}

	public void acheterProduit(String nomAcheteur) {
		if (!controlAcheterProduit.verifierIdentite(nomAcheteur)) {
			System.out.println("Je suis désolé " + nomAcheteur + " il faut être un habitant de notre " +
					"village pour commercer ici");
			return;
		}

		int choix;
		String produit = "";
		int quantite = 0;
		int i = 1;

		produit = Clavier.entrerChaine("Quel produit voulez vous acheter ? : ");
		Gaulois[] vendeurs = controlAcheterProduit.rechercherVendeursParProduit(produit);
		if (vendeurs == null) {
			System.out.println("Désolé, personne ne vend ce produit au marché.");
		} else {
			for (Gaulois g : vendeurs) {
				System.out.println("- " + i + " " + g.getNom());
				i++;
			}
		}

		choix = Clavier.entrerEntier("Chez quel commerçant voulez-vous acheter des fleurs ?");
		String nomVendeur = vendeurs[choix-1].getNom();

		if (!controlAcheterProduit.verifierIdentite(nomVendeur)) {
			System.out.println("Je suis désolé " + nomAcheteur + " il faut être un habitant de notre " +
					"village pour commercer ici");
			return;
		}

		System.out.println(nomAcheteur + " se déplace jusqu'a l'étal du vendeur " + nomVendeur);
		Etal etalvendeur = controlAcheterProduit.rechercherEtal(nomVendeur);
		int quantiteVendeur = etalvendeur.getQuantite();
		quantite = Clavier.entrerEntier("Combien de fleurs voulez vous acheter ? : ");

		if (quantiteVendeur == 0){
			System.out.println(nomAcheteur + " veut acheter " + quantite + " " +  produit +
					", malheureusement il n’y en a plus !”");
		}
		if (Integer.valueOf(quantite) > quantiteVendeur){
			System.out.println(nomAcheteur + " veut acheter " + quantite + " " + produit +
					", malheureusement " + nomVendeur +
					" n’en a plus que" + quantiteVendeur + " "+ nomAcheteur +
					"achète tout le stock " + nomVendeur);
			controlAcheterProduit.acheterProduit(nomVendeur, quantiteVendeur);
		} else {
			System.out.println(nomAcheteur + " achète " + quantite + " " + produit + " à " + nomVendeur);
			controlAcheterProduit.acheterProduit(nomVendeur, Integer.valueOf(quantite));
		}
	}
}