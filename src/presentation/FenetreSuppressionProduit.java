package presentation;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import application.ControleNouveauProduit;
import application.ControleSuppression;
import metier.Catalogue;
import metier.I_Catalogue;

public class FenetreSuppressionProduit extends JFrame implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JButton btSupprimer;
	private JComboBox<String> combo;
	
	public FenetreSuppressionProduit() {
		
		I_Catalogue cat=Catalogue.getCatalogue();
		String[] lesProduits=cat.getNomProduits();
		
		setTitle("Suppression produit");
		setBounds(500, 500, 200, 105);
		Container contentPane = getContentPane();
		contentPane.setLayout(new FlowLayout());
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
		I_Catalogue cat=Catalogue.getCatalogue();
		if (e.getSource() == btSupprimer) {
			ControleSuppression.supprimerProduit((String)combo.getSelectedItem(), cat);
		}
		
		this.dispose();
	}

}
