package application;

import metier.I_Catalogue;
import presentation.FenetreMessageErreur;
//import metier.I_Produit;

public class ControleNouveauProduit {
	
	/*
	private boolean AjouterProduit(I_Produit produit, I_Catalogue catalogue) {
		return catalogue.addProduit(produit);
	}*/
	public static String ErreurPrixHT = ("Veuillez entrer un nombre respectant la forme suivante : X.XX\n");
	public static String ErreurQte = ("Veuillez entrer un nombre entier\n");
	public static boolean BoolErreurPrixHT = false;
	public static boolean BoolErreurQte = false;

	public static boolean AjouterProduit(String nom, String stringPrixHT, String stringQte, I_Catalogue catalogue) {
		double prixHT=0;
		int Qte=0;
		try {
			prixHT = Double.parseDouble(stringPrixHT);
		} catch (Exception e) {
//			String erreur = ("Il faut entrer un nombre\n");				//Ancienne méthode message erreur
			BoolErreurPrixHT = true;
			System.out.print(ErreurPrixHT);
			new FenetreMessageErreur();
		}
		try {
			Qte = Integer.parseInt(stringQte);
		} catch (Exception e) {
			BoolErreurQte = true;
			System.out.print(ErreurQte);
			new FenetreMessageErreur();
		}
		
		return catalogue.addProduit(nom, prixHT, Qte);
	}

}
