package application;

import metier.I_Catalogue;
import presentation.FenetreMessageErreur;

public class ControleAchat {

	public static boolean acheterProduit(String nom, String stringQte, I_Catalogue catalogue) {
		
		int qte=0;
		boolean erreurDansSaisie = false;
		String msgErreurQte = ("Veuillez entrer un nombre entier qui soit positif\n");
		String msgTitreErreurQte = ("Erreur Qte");
		
		try {
			qte = Integer.parseUnsignedInt(stringQte);
		} catch (Exception e) {
			erreurDansSaisie = true;
			System.out.print(msgErreurQte);
			new FenetreMessageErreur(msgTitreErreurQte, msgErreurQte);
		}
		
		if(erreurDansSaisie == false)
			catalogue.acheterStock(nom, qte);
		
		return true;
	}
}