package presentation;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class FenetreAffichage extends JFrame implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JButton btOK;
	
	public FenetreAffichage(String texte) {

		setTitle("Affichage");
		setBounds(500, 500, 450, 250);
		JPanel panHaut = new JPanel();
		JPanel panBas = new JPanel();
		panHaut.setLayout(new BorderLayout());
		panHaut.setBackground(Color.LIGHT_GRAY);
		panBas.setLayout(new FlowLayout());
		panBas.setBackground(Color.LIGHT_GRAY);
		
		JTextArea jtaSortie = new JTextArea(texte,10,5);
		jtaSortie.setEditable(false);
		jtaSortie.setBackground(Color.LIGHT_GRAY);
		btOK = new JButton("Quitter");
		
		
		Container contentPane = getContentPane();
		contentPane.setLayout(new BorderLayout());
		contentPane.setBackground(Color.LIGHT_GRAY);
		
		panHaut.add(jtaSortie);
		panBas.add(btOK);

		contentPane.add(panHaut,"North");
		contentPane.add(panBas, "South");
		btOK.addActionListener(this);

		this.setVisible(true);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */
	public void actionPerformed(ActionEvent e) {
		this.dispose();
	}

}
