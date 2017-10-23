package Graphique;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;

import metier.*;

@SuppressWarnings("serial")
public class PanelJoueur extends PanelAdversaire {
	private JPanel grilleJoueur = new JPanel();
	private Jeu jeuJoueur = new Jeu();
	private Plateau plateauJoueur = new Plateau(10);
	private JPanel panel_affichage_haut = new JPanel();
	private JLabel jl_nom_joueur = new JLabel("Votre grille ! ");
	private JLabel jl_bas = new JLabel(" ");

	public PanelJoueur() {
		this.setLayout(new BorderLayout());

		panel_affichage_haut.setLayout(new GridLayout(2, 1));
		panel_affichage_haut.add(jl_nom_joueur);

		jl_nom_joueur.setPreferredSize(new Dimension(100, 33));
		jl_nom_joueur.setHorizontalAlignment(JLabel.CENTER);
		jl_nom_joueur.setVerticalAlignment(JLabel.CENTER);
		jl_nom_joueur.setFont(new Font("Bookman Old Style", Font.BOLD, 25));
		jl_nom_joueur.setForeground(new Color(107, 2, 120));

		this.grilleJoueur.setLayout(new GridLayout(11, 11));

		jl_bas.setPreferredSize(new Dimension(100, 78));

		this.add(panel_affichage_haut, BorderLayout.NORTH);
		this.add(this.grilleJoueur, BorderLayout.CENTER);
		this.add(jl_bas, BorderLayout.SOUTH);

		// G�n�ration du plateau du joueur
		this.plateauJoueur = this.jeuJoueur.genererJeuParDefaut(this.plateauJoueur);
	}

	public JLabel getJl_nom_joueur() {
		return jl_nom_joueur;
	}

	public JPanel getGrilleJoueur() {
		return this.grilleJoueur;
	}

	public void setGrilleJoueur(JPanel grilleJoueur) {
		this.grilleJoueur = grilleJoueur;
	}

	public Jeu getJeuJoueur() {
		return this.jeuJoueur;
	}

	public void setJeuJoueur(Jeu jeuJoueur) {
		this.jeuJoueur = jeuJoueur;
	}

	public Plateau getPlateauJoueur() {
		return this.plateauJoueur;
	}

	public void setPlateauJoueur(Plateau plateauJoueur) {
		this.plateauJoueur = plateauJoueur;
	}
}