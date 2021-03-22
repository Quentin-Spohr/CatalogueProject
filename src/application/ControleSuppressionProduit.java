package application;

import metier.I_Catalogue;
import presentation.FenetreMessageErreur;
import presentation.FenetreSuppressionProduit;

public class ControleSuppressionProduit {
	
	public static boolean supprimerProduit(String nom, I_Catalogue catalogue) {
		
		int nbreElementComboBox = FenetreSuppressionProduit.combo.getItemCount();
		boolean erreurDansSaisie = false;
		String msgErreurQte = ("Suppression indisponible : Il n'existe plus de produit � supprimer. Veuillez rajouter des produits au pr�alable.\n");
		String msgTitreErreurQte = ("Erreur Suppression Produit");
		
		try {
//			nbreElementComboBox => 0;
		} catch (Exception e) {
			erreurDansSaisie = true;
			System.out.print(msgErreurQte);
			new FenetreMessageErreur(msgTitreErreurQte, msgErreurQte);
		}
		
		if(erreurDansSaisie == false)
			return catalogue.removeProduit(nom);
		
		return true;
	}
}
