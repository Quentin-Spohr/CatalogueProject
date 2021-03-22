package presentation;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import application.ControleSuppressionProduit;
import metier.Catalogue;
import metier.I_Catalogue;

public class FenetreSuppressionProduit extends JFrame implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JButton btSupprimer;
	public static JComboBox<String> combo;
	
	public FenetreSuppressionProduit() {
		
		I_Catalogue cat=Catalogue.getCatalogue();
		String[] lesProduits=cat.getNomProduits();
		
		setTitle("Suppression produit");
		setBounds(500, 500, 300, 100);
		Container contentPane = getContentPane();
		contentPane.setLayout(new FlowLayout());
		contentPane.setBackground(Color.LIGHT_GRAY);
		btSupprimer = new JButton("Supprimer");

		combo = new JComboBox<String>(lesProduits);
		combo.setPreferredSize(new Dimension(100, 20));
		contentPane.add(new JLabel("Produit"));
		contentPane.add(combo);
		contentPane.add(btSupprimer);

		btSupprimer.addActionListener(this);

		this.setVisible(true);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btSupprimer) {
			I_Catalogue cat=Catalogue.getCatalogue();
			ControleSuppressionProduit.supprimerProduit((String)combo.getSelectedItem(), cat);
			this.dispose();
		}
	}

}
