package presentation;

import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextArea;

import application.ControleNouveauProduit;

public class FenetreMessageErreur extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JButton btOK;
	private JTextArea labErreur;
	private Container contentPane = getContentPane();

	public FenetreMessageErreur() {
		
		setTitle("Erreur Prix HT");
		setBounds(500, 500, 300, 250);

		contentPane.setBackground(Color.LIGHT_GRAY);
		contentPane.setLayout(null);
		
		btOK = new JButton("OK");
		btOK.setBounds(92, 177, 89, 23);
		contentPane.add(btOK);
		btOK.addActionListener(this);
		
		if (ControleNouveauProduit.BoolErreurPrixHT == true)
		{
			labErreur = new JTextArea(ControleNouveauProduit.ErreurPrixHT);
			labErreur.setLineWrap(true);
			labErreur.setEditable(false);
			labErreur.setBounds(37, 42, 213, 73);
			contentPane.add(labErreur);	
		}
		if (ControleNouveauProduit.BoolErreurQte == true)
		{
			labErreur = new JTextArea(ControleNouveauProduit.ErreurQte);
			labErreur.setLineWrap(true);
			labErreur.setEditable(false);
			labErreur.setBounds(37, 42, 213, 73);
			contentPane.add(labErreur);	
		}
		
		setVisible(true);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btOK) {
			labErreur.setText("");
			contentPane.remove(labErreur);
			this.dispose();
		}
		
	}
	
}
