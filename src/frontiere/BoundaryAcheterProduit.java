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
		if (!controlAcheterProduit.verifierIdentite(nomAcheteur)){
			System.out.println("Je suis désolé " + nomAcheteur + " il faut être un habitant de notre " +
					"village pour commercer ici");
			return;
		}
		String sortie = "";
		do {
			System.out.println("Veuillez choisir une option :");
			System.out.println("1. Option 1");
			System.out.println("2. Option 2");
			System.out.println("3. Quitter");

			String nomVendeur = "";
			String produit = "";
			String choix = "";
			String quantite = "";
			int i;
			Gaulois Vendeur;
			Etal etalVendeur;


			Clavier.entrerEntier(sortie);
			switch (sortie) {
				case "1":
					System.out.println("Quel produit voulez vous acheter ? : ");
					Clavier.entrerChaine(produit);
					Gaulois[] vendeurs = controlAcheterProduit.rechercherVendeursParProduit(produit);
					if (vendeurs == null) {
						System.out.println("Désolé, personne ne vend ce produit au marché");
						// return;
						// Possibilité de boucle
					}
					System.out.println("Chez quel commerçant voulez-vous acheter des fleurs ?");
					i = 1;
					for (Gaulois g : vendeurs) {
						System.out.println("- " + i + g.getNom());
						i++;
					}
					Clavier.entrerEntier(choix);
					Vendeur = vendeurs[Integer.valueOf(choix)-1];
					if (!controlAcheterProduit.verifierIdentite(Vendeur.getNom())){
						System.out.println("Je suis désolé " + Vendeur.getNom() + " mais il faut être un habitant de notre" +
								" village pour commercer ici");
						// Clavier.entrerEntier(choix);
						// Vendeur = vendeurs[Integer.valueOf(choix)-1];
						// Si on utilise un while on peut boucler et redemander a l'utilisateur de rentrer une autre option.
					}

					nomVendeur = Vendeur.getNom();
					System.out.println(nomAcheteur + " se déplace jusqu'a l'étal du vendeur " + nomVendeur);
					System.out.println("Combien de fleurs voulez vous acheter ? : ");
					Etal etalvendeur = controlAcheterProduit.rechercherEtal(Vendeur);
					int quantiteVendeur = etalvendeur.getQuantite();
					Clavier.entrerEntier(quantite);
					if (quantiteVendeur == 0){
						System.out.println(nomAcheteur + " veut acheter " + quantite + " " +  produit +
								", malheureusement il n’y en a plus !”");
					}
					if (Integer.valueOf(quantite) > quantiteVendeur){
						System.out.println(nomAcheteur + " veut acheter " + quantite + " " + produit +
								", malheureusement " + nomVendeur +
										" n’en a plus que" + quantiteVendeur + " "+ nomAcheteur +
										"achète tout le stock " + nomVendeur);
						// Clavier.entrerEntier(quantite);
						// Même remarque possibilité de boucle.
						controlAcheterProduit.acheterProduit(nomVendeur, quantiteVendeur);
					} else {
						System.out.println(nomAcheteur + " achète " + quantite + " " + produit + " à " + nomVendeur);
						controlAcheterProduit.acheterProduit(nomVendeur, Integer.valueOf(quantite));
					}
					break;
				case "2":
					String[] Marche = controlAcheterProduit.donnerEtatMarche();
					i = 0;
					String quantiteVent = "";
					while (i < Marche.length){
						nomVendeur = Marche[i];
						i++;
						quantiteVent = Marche[i+1];
						i++;
						produit = Marche[i+2];
						i++;
						System.out.println("- " + nomVendeur + " qui vend " + quantiteVent + " " + produit);
					}
					break;
				case "3":
					System.out.println("Au revoir client " + nomAcheteur);
					break;
				default:
					System.out.println("Option non valide, veuillez réessayer");
					break;
			}
		} while (sortie.equals("3"));
	}
}
