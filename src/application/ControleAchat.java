package application;

import metier.I_Catalogue;

public class ControleAchat {

	public static boolean acheterProduit(String nom, String stringQte, I_Catalogue catalogue) {
		int qte=0;
		try {
			qte = Integer.parseInt(stringQte);
		} catch (Exception e) {
			System.out.print("il Faut entrer un nombre entier");
		}
		catalogue.acheterStock(nom, qte);
		return true;
	}
}
