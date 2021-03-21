package presentation;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import metier.Catalogue;
import metier.I_Catalogue;


public class FenetrePrincipale extends JFrame implements ActionListener,WindowListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JButton btAfficher;
	private JButton btNouveauProduit;
	private JButton btSupprimerProduit;
//	private JButton btNouvelleCategorie;
//	private JButton btSupprimerCategorie;
	private JButton btAchat;
	private JButton btVente;
	private JButton btQuitter;

	
	public FenetrePrincipale() {

		setTitle("Exercice Produits");
		setBounds(500, 500, 320, 250);
		Container contentPane = getContentPane();
		contentPane.setBackground(Color.LIGHT_GRAY);
		contentPane.setLayout(new FlowLayout());
		
		JPanel panAffichage = new JPanel();
		panAffichage.setBackground(Color.LIGHT_GRAY);
		
		JPanel panNouveauSupprimerProduit = new JPanel();
		panNouveauSupprimerProduit.setBackground(Color.LIGHT_GRAY);
		
//		JPanel panNouveauSupprimerCategorie = new JPanel();
		
		JPanel panAchatVente = new JPanel();
		panAchatVente.setBackground(Color.LIGHT_GRAY);
		
		JPanel panQuitter = new JPanel();
		panQuitter.setBackground(Color.LIGHT_GRAY);

		btAfficher = new JButton("Quantités en stock");
		btNouveauProduit = new JButton("Nouveau Produit");
		btSupprimerProduit = new JButton("Supprimer Produit");
//		btNouvelleCategorie = new JButton("Nouvelle Categorie");
//		btSupprimerCategorie = new JButton("Supprimer Categorie");
		btAchat = new JButton("Achat Produits");
		btVente = new JButton("Vente Produits");
		btQuitter = new JButton("Quitter");
		
		panAffichage.add(btAfficher);
		panNouveauSupprimerProduit.add(btNouveauProduit); 
		panNouveauSupprimerProduit.add(btSupprimerProduit);
//		panNouveauSupprimerCategorie.add(btNouvelleCategorie); 
//		panNouveauSupprimerCategorie.add(btSupprimerCategorie);
		panAchatVente.add(btAchat); 
		panAchatVente.add(btVente);  
		panQuitter.add(btQuitter);

		contentPane.add(panAffichage);
//		contentPane.add(panNouveauSupprimerCategorie);
		contentPane.add(panNouveauSupprimerProduit);
		contentPane.add(panAchatVente);
		contentPane.add(panQuitter);

		btAfficher.addActionListener(this);
		btNouveauProduit.addActionListener(this);
		btSupprimerProduit.addActionListener(this);
//		btNouvelleCategorie.addActionListener(this);
//		btSupprimerCategorie.addActionListener(this);
		btAchat.addActionListener(this);
		btVente.addActionListener(this);
		btQuitter.addActionListener(this);
		
		addWindowListener(this);
		setVisible(true);
	}

	public void actionPerformed(ActionEvent e) {

/* tabProduits permet de tester le fonctionnement des fenêtres avec un tableau de noms de produits "en dur"
   Quand l'application fonctionnera, il faudra bien sur récuperer les noms des produits dans le Catalogue */
		//On peut déclarer le catalogue ici. PAR CONTRE, il ne faut pas déclarer les ajouts de produit ici.......
		/*
		I_Catalogue cat=Catalogue.getCatalogue();
		cat.addProduit("Treets", 10, 1);
		cat.addProduit("Mars", 2, 5);
		cat.addProduit("Coca", 1, 15);
		cat.addProduit("Crayon", 7, 2);
		cat.addProduit("Bepis", 3, 1);
		*/
		I_Catalogue cat=Catalogue.getCatalogue();
/* Même chose pour tabCategories (partie 4) */ 		
//		String[] tabCategories = new String[] {"Bio", "Luxe" };
		
		if (e.getSource() == btAfficher)
			new FenetreAffichage(cat.toString());
		if (e.getSource() == btNouveauProduit)
//			new FenetreNouveauProduit(tabCategories);
			new FenetreNouveauProduit();
		if (e.getSource() == btSupprimerProduit)
			new FenetreSuppressionProduit();
//		if (e.getSource() == btNouvelleCategorie)
//			new FenetreNouvelleCategorie();
//		if (e.getSource() == btSupprimerCategorie)
//			new FenetreSuppressionCategorie(tabCategories);
		if (e.getSource() == btAchat)
			new FenetreAchat();
		if (e.getSource() == btVente)
			new FenetreVente();
		if (e.getSource() == btQuitter){
			System.out.println("Au revoir\n");
			System.exit(0);
		}	
	}

	public void windowClosing(WindowEvent arg0) {
		System.out.println("\nAu revoir\n");
		System.exit(0);
	}

	public void windowActivated(WindowEvent arg0) {}
	public void windowClosed(WindowEvent arg0) {}
	public void windowDeactivated(WindowEvent arg0) {}
	public void windowDeiconified(WindowEvent arg0) {}
	public void windowIconified(WindowEvent arg0) {}
	public void windowOpened(WindowEvent arg0) {}

	
	
	public static void main(String[] args) {
		new FenetrePrincipale();
				
		//...Mais plutôt là. C'est pour eviter que le "cat.addProduit" ne se déclenche à chaque fois que l'on revient sur la fenétre principale,
		//je te laisse tester la différence des 2 méthodes de déclaration "catalogue+produit" en testant la fenétre "supprimer produit" si tu ne vois ce que je veux dire.
		/*
		I_Catalogue cat=Catalogue.getCatalogue();
		cat.addProduit("Treets", 10, 1);
		cat.addProduit("Mars", 2, 5);
		cat.addProduit("Coca", 1, 15);
		cat.addProduit("Crayon", 7, 2);
		cat.addProduit("Bepis", 3, 1);
		*/
	}

}
