package presentation;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import application.ControleNouveauProduit;
import metier.Catalogue;
import metier.I_Catalogue;

public class FenetreNouveauProduit extends JFrame implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField txtPrixHT;
	private JTextField txtNom;
	private JTextField txtQte;
//	private JComboBox<String> combo;
	private JButton btValider;

//	public FenetreNouveauProduit(String[] lesCategories) {
	public FenetreNouveauProduit() {
		getContentPane().setBackground(Color.LIGHT_GRAY);	

		
		setTitle("Création Produit");
		setBounds(500, 500, 300, 250);
		Container contentPane = getContentPane();
		getContentPane().setLayout(null);

		JLabel labNom = new JLabel("Nom produit");
		labNom.setBounds(99, 9, 70, 14);
		contentPane.add(labNom);
		txtNom = new JTextField(15);
		txtNom.setBounds(73, 34, 126, 20);
		contentPane.add(txtNom);
		
		JLabel labPrixHT = new JLabel("Prix Hors Taxe");
		labPrixHT.setBounds(99, 65, 85, 14);
		contentPane.add(labPrixHT);
		txtPrixHT = new JTextField(15);
		txtPrixHT.setBounds(73, 90, 126, 20);
		contentPane.add(txtPrixHT);
		
		JLabel labQte = new JLabel("Quantité en stock");
		labQte.setBounds(99, 121, 100, 14);
		contentPane.add(labQte);
//		JLabel labCategorie = new JLabel("Categorie");

//		combo = new JComboBox<String>(lesCategories);
//		combo.setPreferredSize(new Dimension(100, 20));
//		contentPane.add(labCategorie);
//		contentPane.add(combo);

		
		btValider = new JButton("Valider");
		btValider.setBounds(99, 177, 85, 23);
		contentPane.add(btValider);
		txtQte = new JTextField(15);
		txtQte.setBounds(73, 146, 126, 20);
		contentPane.add(txtQte);

		btValider.addActionListener(this);
		setVisible(true);
	}

	public void actionPerformed(ActionEvent e) {
		I_Catalogue cat=Catalogue.getCatalogue();
		if (e.getSource() == btValider) {
			ControleNouveauProduit.AjouterProduit(txtNom.getText(), txtPrixHT.getText(), txtQte.getText(),cat);
		}
		this.dispose();
	}

}