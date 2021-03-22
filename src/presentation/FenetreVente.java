package presentation;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import application.ControleVente;
import metier.Catalogue;
import metier.I_Catalogue;

public class FenetreVente extends JFrame implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JButton btVente;
	private JTextField txtQuantite;
	private JComboBox<String> combo;

	public FenetreVente() {
		
		I_Catalogue cat=Catalogue.getCatalogue();
		String[] lesProduits=cat.getNomProduits();
		
		setTitle("Vente");
		setBounds(500, 500, 225, 125);
		Container contentPane = getContentPane();
		contentPane.setLayout(new FlowLayout());
		contentPane.setBackground(Color.LIGHT_GRAY);
		btVente = new JButton("Vente");
		txtQuantite = new JTextField(5);
		txtQuantite.setText("0");

		combo = new JComboBox<String>(lesProduits);
		combo.setPreferredSize(new Dimension(100, 20));
		contentPane.add(new JLabel("Produit"));
		contentPane.add(combo);
		contentPane.add(new JLabel("Quantité vendue"));
		contentPane.add(txtQuantite);
		contentPane.add(btVente);

		btVente.addActionListener(this);
		this.setVisible(true);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btVente) {
			I_Catalogue cat=Catalogue.getCatalogue();
			ControleVente.vendreProduit((String)combo.getSelectedItem(),txtQuantite.getText(),cat);
			this.dispose();
		}
		
	}

}
