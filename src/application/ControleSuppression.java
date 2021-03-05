package application;

import metier.I_Catalogue;

public class ControleSuppression {

	
	public static boolean supprimerProduit(String nom, I_Catalogue catalogue) {

		
		return catalogue.removeProduit(nom);
	}
	
}
