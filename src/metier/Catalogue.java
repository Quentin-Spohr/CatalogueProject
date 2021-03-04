package metier;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Catalogue implements I_Catalogue{
	
	private List<I_Produit> produits;

	public Catalogue() {
		this.produits= new ArrayList<>();
	}

	@Override
	public boolean addProduit(I_Produit produit) {
		if (produit!=null && (produit.getPrixUnitaireHT()> 0) && (produit.getQuantite()>= 0) && !(estDansleCatalogue(produit.getNom()))) {
			produits.add(produit);
			return true;
		}		
		return false;
	}

	@Override
	public boolean addProduit(String nom, double prix, int qte) {
		Produit newProduit = new Produit(nom,prix,qte);
		if(estDansleCatalogue(newProduit.getNom())) {
			return false;
		}
		return addProduit(newProduit);
	}

	@Override
	public int addProduits(List<I_Produit> l) {
		if (l!=null) {
			int compteur=0;
			for (I_Produit produit : l) {
				if(addProduit(produit)) {
					compteur++;
				}
			}
			return compteur;
		}
		return 0;
	}

	@Override
	public boolean removeProduit(String nom) {
		if (estDansleCatalogue(nom)) {
			return produits.remove(getProduitByName(nom));
		}
		return false;
	}

	@Override
	public boolean acheterStock(String nomProduit, int qteAchetee) {
		if (estDansleCatalogue(nomProduit)) {
			if(getProduitByName(nomProduit).ajouter(qteAchetee)) {
				return true;
			}
			return false;
		}
		return false;
	}

	@Override
	public boolean vendreStock(String nomProduit, int qteVendue) {
		if (estDansleCatalogue(nomProduit)) {
			if(getProduitByName(nomProduit).enlever(qteVendue)) {
				return true;
			}
			return false;
		}
		return false;
	}

	@Override
	public String[] getNomProduits() {	
		if (produits.size()!=0) {
			String[] nomsProduits =new String[produits.size()];
			for (int i = 0; i < nomsProduits.length; i++) {
				nomsProduits[i]=produits.get(i).getNom();
			}
			String tmp;
			
			for (int i=0; i < produits.size(); i++) {
	            for (int j=i+1; j < produits.size(); j++) {
	                if (nomsProduits[i].compareTo(nomsProduits[j]) > 0) {
	                    tmp = nomsProduits[i];
	                    nomsProduits[i] = nomsProduits[j];
	                    nomsProduits[j] = tmp;
	                }
	            }
	        }
			return nomsProduits;
		}
		
		else return (new String[0]);
	}

	@Override
	public double getMontantTotalTTC() {
		double montantTotalTTC=0;
		for (I_Produit produit : produits) {
			montantTotalTTC=montantTotalTTC+produit.getPrixStockTTC();
		}
		
		return (double)Math.round(montantTotalTTC*100)/100;
	}

	@Override
	public void clear() {
		produits.clear();	
	}
	
	@Override
	public String toString() {
		DecimalFormat df = new DecimalFormat("0.00");
		String catToString="";
		for (I_Produit produit : produits) {
			catToString=catToString + produit.toString()+"\n";	
		}	
		catToString=catToString + ("\n"+"Montant total TTC du stock : "+df.format(getMontantTotalTTC())+" €");
		return catToString;
	}
	
	public boolean estDansleCatalogue (String nomProduit) {
		boolean estDansleCatalogue =false;
		for (I_Produit produit : produits) {
			if (produit.getNom().equals(nomProduit)) {
				estDansleCatalogue=true;
				break;
			}
		}
		return estDansleCatalogue;
	}
	
	public I_Produit getProduitByName (String nomProduit) {		
		for (I_Produit produit : produits) {
			if (produit.getNom().equals(nomProduit)) {
				return produit;				
			}
		}
		return null;
	}
	
	
	
	
}
