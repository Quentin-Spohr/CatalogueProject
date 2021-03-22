package application;

import metier.I_Catalogue;
import presentation.FenetreMessageErreur;
//import metier.I_Produit;

public class ControleNouveauProduit {
	
	/*
	private boolean AjouterProduit(I_Produit produit, I_Catalogue catalogue) {
		return catalogue.addProduit(produit);
	}*/

	public static boolean AjouterProduit(String nom, String stringPrixHT, String stringQte, I_Catalogue catalogue) {
		
		double prixHT=0;
		int qte=0;
		
		boolean erreurDansSaisie = false;
		String msgErreurPrixHT = ("Veuillez entrer un nombre respectant la forme suivante : X.XX\n");
		String msgErreurQte = ("Veuillez entrer un nombre entier qui soit positif\n");
		String msgTitreErreurPrixHT = ("Erreur Prix HT");
		String msgTitreErreurQte = ("Erreur Qte");
		
		try {
			prixHT = Double.parseDouble(stringPrixHT);
		} catch (Exception e) {
//			String erreur = ("Il faut entrer un nombre\n");				//Ancienne méthode message erreur

			erreurDansSaisie = true;
			System.out.print(msgErreurPrixHT);
			new FenetreMessageErreur(msgTitreErreurPrixHT, msgErreurPrixHT);
			
//			System.out.print(prixHT+"\n");
//			System.out.print(Qte+"\n");
//			System.out.print("catch1\n");
		}
		try {
			qte = Integer.parseUnsignedInt(stringQte);
		} catch (Exception e) {
			erreurDansSaisie = true;
			System.out.print(msgErreurQte);
			new FenetreMessageErreur(msgTitreErreurQte, msgErreurQte);
			
//			System.out.print(prixHT+"\n");
//			System.out.print(Qte+"\n");
//			System.out.print("catch2\n");
		}
		
//		System.out.print("après\n");
		
		if(erreurDansSaisie == false)
			return catalogue.addProduit(nom, prixHT, qte);
		
		return false;
	}

}
