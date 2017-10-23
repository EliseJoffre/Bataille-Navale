package Graphique;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class FenetreJeu extends JFrame {

	private static final long serialVersionUID = 1L;

	// Declaration des composants
	private JMenuBar menu = new JMenuBar();
	private JMenuItem nouvellePartie = new JMenuItem("Nouvelle partie");
	private JMenuItem aide = new JMenuItem("Aide");
	private JMenuItem quitter = new JMenuItem("Quitter");

	public FenetreJeu() {

		this.setLayout(new BorderLayout());
		this.setTitle("Bataille Navale");
		this.setSize(1420, 640);
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.getContentPane().add(new PanelJeu(this), BorderLayout.CENTER);

		// Menu
		this.menu.setForeground(Color.DARK_GRAY);
		this.menu.setPreferredSize(new Dimension(20, 28));

		// Ajout des items au menu
		this.menu.add(this.nouvellePartie);
		this.menu.add(this.aide);
		this.menu.add(this.quitter);
		this.aide.setFont(new Font("Bookman Old Style", Font.PLAIN, 20));
		this.nouvellePartie.setFont(new Font("Bookman Old Style", Font.PLAIN, 20));
		this.quitter.setFont(new Font("Bookman Old Style", Font.PLAIN, 20));

		// Ajout des composants au panel
		this.add(menu, BorderLayout.NORTH);

		// Evenement sur l'item nouvelle partie
		this.nouvellePartie.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// Masque la fenetre
				dispose();

				// Ouvre une nouvelle fenetre de jeu
				new FenetreJeu();
			}
		});

		// Evenement sur l'item aide
		this.aide.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// Ouvre une nouvelle fenetre d'aide
				new FenetreAide();
			}
		});

		// Evenement sur l'item quitter
		this.quitter.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// Arrete definitivement le jeu
				System.exit(0);
			}
		});
		this.setVisible(true);
	}

}