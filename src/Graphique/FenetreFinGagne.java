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

public class FenetreFinGagne extends JFrame {

	private static final long serialVersionUID = 1L;

	// Declaration des elements du panel
	private JLabel jl_messageGagne = new JLabel("Felicitations ! Vous avez gagne !");
	private JLabel jl_gagne = new JLabel(new ImageIcon("./img/gagne.png"));
	private JButton jb_rejouer = new JButton("Une autre partie ?!");
	private JPanel panel_gagne = new JPanel();
	private FenetreJeu fen;

	public FenetreFinGagne(FenetreJeu fen) {
		this.fen = fen;

		this.setTitle("Fin du jeu");
		this.setSize(400, 400);
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.getContentPane().add(panel_gagne);

		// Declaration du layout du panel
		panel_gagne.setLayout(new BorderLayout());

		// Message d'une partie gagnee
		this.jl_messageGagne.setFont(new Font("Bookman Old Style", Font.BOLD, 20));
		this.jl_messageGagne.setPreferredSize(new Dimension(1, 50));
		this.jl_messageGagne.setHorizontalAlignment(JLabel.CENTER);
		this.jl_messageGagne.setVerticalAlignment(JLabel.CENTER);
		this.jl_messageGagne.setForeground(Color.RED);

		// Image d'une partie gagnee
		this.jl_gagne.setHorizontalAlignment(JLabel.CENTER);
		this.jl_gagne.setVerticalAlignment(JLabel.CENTER);

		// Bouton pour rejouer une nouvelle partie
		this.jb_rejouer.setPreferredSize(new Dimension(1, 50));
		this.jb_rejouer.setFont(new Font("Bookman Old Style", Font.BOLD, 15));
		this.jb_rejouer.setForeground(Color.BLUE);
		this.jb_rejouer.addActionListener(new ActionListenerRejouer());

		// Ajout des elements au panel
		panel_gagne.add(jl_messageGagne, BorderLayout.NORTH);
		panel_gagne.add(jl_gagne, BorderLayout.CENTER);
		panel_gagne.add(jb_rejouer, BorderLayout.SOUTH);

		// Visibilite de la fenetre
		this.setVisible(true);
	}

	// Evenement sur le bouton rejouer
	class ActionListenerRejouer implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			fen.dispose();
			dispose();
			new FenetreJeu();
		}
	}
}