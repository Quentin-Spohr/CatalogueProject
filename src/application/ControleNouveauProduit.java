package application;

import metier.I_Catalogue;
import metier.I_Produit;

public class ControleNouveauProduit {
	
	/*
	private boolean AjouterProduit(I_Produit produit, I_Catalogue catalogue) {
		return catalogue.addProduit(produit);
	}*/
	
	public static boolean AjouterProduit(String nom, String stringPrixHT, String stringQte, I_Catalogue catalogue) {
		double prixHT=0;
		int qte=0;
		try {
			prixHT = Double.parseDouble(stringPrixHT);
		} catch (Exception e) {
			System.out.print("Il faut entrer un nombre");
		}
		try {
			qte = Integer.parseInt(stringQte);
		} catch (Exception e) {
			System.out.print("il Faut entrer un nombre entier");
		}
		
		return catalogue.addProduit(nom, prixHT, qte);
	}
	
}
