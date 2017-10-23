package Graphique;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class FenetreFinPerdu extends JFrame {

	private static final long serialVersionUID = 1L;
	private FenetreJeu fen;

	// Declaration des elements du panel
	private JLabel jl_messagePerdu = new JLabel("Dommage ! Vous avez perdu !");
	private JLabel jl_perdu = new JLabel(new ImageIcon("./img/perdu.png"));
	private JButton jb_rejouer = new JButton("Tentez votre revanche !");
	private JPanel panel_perdu = new JPanel();

	public FenetreFinPerdu(FenetreJeu fen) {

		this.fen = fen;

		this.setTitle("Fin du jeu");
		this.setSize(400, 400);
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.getContentPane().add(panel_perdu);

		// Declaration du layout du panel
		panel_perdu.setLayout(new BorderLayout());

		// Message d'une partie perdue
		this.jl_messagePerdu.setFont(new Font("Bookman Old Style", Font.BOLD, 20));
		this.jl_messagePerdu.setPreferredSize(new Dimension(1, 50));
		this.jl_messagePerdu.setHorizontalAlignment(JLabel.CENTER);
		this.jl_messagePerdu.setVerticalAlignment(JLabel.CENTER);
		this.jl_messagePerdu.setForeground(Color.RED);

		// Image d'une partie perdue
		this.jl_perdu.setHorizontalAlignment(JLabel.CENTER);
		this.jl_perdu.setVerticalAlignment(JLabel.CENTER);

		// Bouton pour rejouer une nouvelle partie
		this.jb_rejouer.setPreferredSize(new Dimension(1, 50));
		this.jb_rejouer.setFont(new Font("Bookman Old Style", Font.BOLD, 15));
		this.jb_rejouer.setForeground(Color.BLUE);
		this.jb_rejouer.addActionListener(new ActionListenerRejouer());

		// Ajout des elements au panel
		this.add(panel_perdu);
		panel_perdu.add(jl_messagePerdu, BorderLayout.NORTH);
		panel_perdu.add(jl_perdu, BorderLayout.CENTER);
		panel_perdu.add(jb_rejouer, BorderLayout.SOUTH);

		// Visibilite de la fenetre
		this.setVisible(true);
	}

	// Evenement sur le bouton rejouer
	class ActionListenerRejouer implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			//Ferme la fenetre de jeu actuek
			fen.dispose();
			//ferme la fenetre perdu
			dispose();
			//Ouvre la fenetre de jeu pour une nouvelle partie
			new FenetreJeu();
		}
	}
}