package application;

import metier.I_Catalogue;
import presentation.FenetreMessageErreur;
import presentation.FenetreSuppressionProduit;

public class ControleSuppressionProduit {
	
	public static boolean supprimerProduit(String nom, I_Catalogue catalogue) {
		
		int nbreElementComboBox = FenetreSuppressionProduit.combo.getItemCount();
		String msgErreurQte = ("Suppression indisponible : Il n'existe plus de produit à supprimer. Veuillez rajouter des produits au préalable.\n");
		String msgTitreErreurQte = ("Erreur Suppression Produit");
		
		if(nbreElementComboBox == 0)
		{
			System.out.print(msgErreurQte);
			new FenetreMessageErreur(msgTitreErreurQte, msgErreurQte);
			return false;
		}
		
		return catalogue.removeProduit(nom);
	}
}
