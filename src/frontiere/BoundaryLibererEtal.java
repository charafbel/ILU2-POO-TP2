package frontiere;

import controleur.ControlLibererEtal;

public class BoundaryLibererEtal {
	private ControlLibererEtal controlLibererEtal;

	public BoundaryLibererEtal(ControlLibererEtal controlLibererEtal) {
		this.controlLibererEtal = controlLibererEtal;
	}

	public void libererEtal(String nomVendeur) {
		boolean isvendeur = controlLibererEtal.isVendeur(nomVendeur);
		if (!isvendeur) {
			System.out.println("Mais vous n'êtes pas inscrit sur notre marché aujourd'hui.");
		} else {
			String[] etalOccupe = controlLibererEtal.libererEtal(nomVendeur);
			if (etalOccupe != null) {
				String produit = etalOccupe[2];
				String quantiteInitiale = etalOccupe[3];
				String quantiteVendue = etalOccupe[4];
				System.out.println("Vous avez vendu " + quantiteVendue + " sur " + quantiteInitiale +
						" " + produit);
			}
			System.out.println("Au revoir " + nomVendeur);
		}
	}

}
