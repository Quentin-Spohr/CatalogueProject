package metier;

import java.text.DecimalFormat;

public class Produit implements I_Produit {

	private int quantiteStock;	
	private String nom;
	private double prixUnitaireHT;
	private double tauxTVA = 0.2;
	
	
	public Produit(String nom, double prixHT, int quantite) {
		this.nom = nom.trim().replace("\t", " ");
		prixUnitaireHT = prixHT;
		quantiteStock = quantite;
	}

	@Override
	public boolean ajouter(int qteAchetee) {
		if (qteAchetee<=0) {
			return false;
		}		
		quantiteStock = quantiteStock + qteAchetee;
		return true;
	}

	@Override
	public boolean enlever(int qteVendue) {
		if (qteVendue<=0) {
			return false;
		}
		quantiteStock = quantiteStock - qteVendue;
		if (quantiteStock<0) {
			quantiteStock=0;
			return false;
		}
		return true;
	}

	@Override
	public double getPrixUnitaireHT() {
		return prixUnitaireHT;
	}

	@Override
	public double getPrixUnitaireTTC() {
		return getPrixUnitaireHT() * (1+tauxTVA);
	}

	@Override
	public double getPrixStockTTC() {
		return getPrixUnitaireTTC() * getQuantite();
	}
	
	@Override
	public String getNom() {
		return nom;
	}

	@Override
	public int getQuantite() {
		return quantiteStock;
	}
	
	@Override
	public String toString() {
		DecimalFormat df = new DecimalFormat("0.00");
		
		String produitToString=""; 
		produitToString=produitToString + (getNom()+" - prix HT : "+df.format(prixUnitaireHT)+" € - prix TTC : "+df.format(getPrixUnitaireTTC())+" € - quantité en stock : "+getQuantite());	
		return produitToString;
	}	

	
}
