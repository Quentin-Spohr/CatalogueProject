package presentation;

import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;

import application.ControleNouveauProduit;

import javax.swing.JButton;

public class FenetreNouveauProduitErreurPrixHT extends JFrame implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JButton btOK;

	public FenetreNouveauProduitErreurPrixHT() {
		
		setTitle("Erreur Prix HT");
		setBounds(500, 500, 300, 250);
		Container contentPane = getContentPane();
		contentPane.setBackground(Color.LIGHT_GRAY);
		contentPane.setLayout(null);
		
		btOK = new JButton("OK");
		btOK.setBounds(92, 177, 89, 23);
		contentPane.add(btOK);
		btOK.addActionListener(this);
		
		JLabel labPrixHTErreur = new JLabel(ControleNouveauProduit.ErreurPrixHT);
		labPrixHTErreur.setBounds(37, 42, 213, 73);
		contentPane.add(labPrixHTErreur);	
		
		setVisible(true);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btOK) {
			this.dispose();
		}
		
	}
}
