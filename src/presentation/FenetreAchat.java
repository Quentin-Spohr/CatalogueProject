package presentation;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import application.ControleAchat;
import metier.Catalogue;
import metier.I_Catalogue;

public class FenetreAchat extends JFrame implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JButton btAchat;
	private JTextField txtQuantite;
	private JComboBox<String> combo;

	public FenetreAchat() {

		I_Catalogue cat=Catalogue.getCatalogue();
		String[] lesProduits=cat.getNomProduits();
		
		setTitle("Achat");
		setBounds(500, 500, 225, 125);
		Container contentPane = getContentPane();
		contentPane.setLayout(new FlowLayout());
		contentPane.setBackground(Color.LIGHT_GRAY);
		btAchat = new JButton("Achat");
		txtQuantite = new JTextField(5);
		txtQuantite.setText("0");

		combo = new JComboBox<String>(lesProduits);
		combo.setPreferredSize(new Dimension(100, 20));
		contentPane.add(new JLabel("Produit"));
		contentPane.add(combo);
		contentPane.add(new JLabel("Quantité achetée"));
		contentPane.add(txtQuantite);
		contentPane.add(btAchat);

		btAchat.addActionListener(this);

		this.setVisible(true);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btAchat) {
			I_Catalogue cat=Catalogue.getCatalogue();
			ControleAchat.acheterProduit((String)combo.getSelectedItem(),txtQuantite.getText(),cat);
		}
		
		this.dispose();
	}

}
