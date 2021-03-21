package application;

import metier.I_Catalogue;

public class ControleVente {

	public static boolean vendreProduit(String nom, String stringQte, I_Catalogue catalogue) {
		int qte=0;
		try {
			qte = Integer.parseInt(stringQte);
		} catch (Exception e) {
			System.out.print("il Faut entrer un nombre entier");
		}
		//récupere quantité du produit dans catalogue
		//catalogue.getProduitByName();
		catalogue.vendreStock(nom, qte);
		return true;
	}
}
