package Graphique;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import metier.*;

public class PanelAdversaire extends JPanel {

	private static final long serialVersionUID = 1L;

	private JPanel grilleAdversaire = new JPanel();
	private Jeu jeuAdversaire = new Jeu();
	private Plateau plateauAdversaire = new Plateau(10);
	private JPanel panel_affichage_haut = new JPanel();
	private JLabel jl_nom_joueur = new JLabel("									Grille de l'ordinateur !");
	private JLabel jl_bas = new JLabel(" ");

	public PanelAdversaire() {

		// Declaration du layout du panel
		this.setLayout(new BorderLayout());

		// Nom du joueur
		this.jl_nom_joueur.setPreferredSize(new Dimension(100, 33));
		this.jl_bas.setPreferredSize(new Dimension(100, 78));
		this.jl_nom_joueur.setHorizontalAlignment(JLabel.CENTER);
		this.jl_nom_joueur.setFont(new Font("Bookman Old Style", Font.BOLD, 25));
		this.jl_nom_joueur.setForeground(new Color(107, 2, 120));

		// Declaration du layout du panel du haut
		this.panel_affichage_haut.setLayout(new GridLayout(2, 1));

		// Ajout des composants au panel du haut
		this.panel_affichage_haut.add(this.jl_nom_joueur);

		// Ajout des composants au panel
		this.add(this.jl_bas, BorderLayout.SOUTH);
		this.add(this.grilleAdversaire, BorderLayout.CENTER);
		this.add(this.panel_affichage_haut, BorderLayout.NORTH);

		// Definition de la grille de l'adversaire
		this.grilleAdversaire.setLayout(new GridLayout(11, 11));

		// Generation du plateau du joueur
		this.plateauAdversaire = this.jeuAdversaire.genererJeuParDefaut(this.plateauAdversaire);
	}

	// Getteur de la grille de l'adversaire
	public JPanel getGrilleAdversaire() {
		return this.grilleAdversaire;
	}

	// Getteur du plateau de l'adversaire
	public Plateau getPlateauAdversaire() {
		return this.plateauAdversaire;
	}

	// Getteur du jeu de l'adversaire
	public Jeu getJeuAdversaire() {
		return this.jeuAdversaire;
	}

}