package Graphique;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class PanelAffichage extends JPanel {

	// Declaration des composants
	private JLabel jl_intro = new JLabel(" Bienvenue sur le jeu de la bataille navale !\n");

	private JPanel panel_commentaire = new JPanel();

	private JLabel jl_commentaire_joueur = new JLabel("Actions du joueur");
	private JLabel jl_commentaire_image_joueur = new JLabel(new ImageIcon("./img/joueur.png"));
	private JLabel jl_commentaire_emotion_joueur = new JLabel(new ImageIcon("./img/bonnechance.png"));
	private JPanel panel_commentaire_joueur = new JPanel();
	private JLabel jl_image_joueur = new JLabel(new ImageIcon("./img/joueur2.png"));

	private JPanel panel_commentaire_adversaire = new JPanel();
	private JLabel jl_commentaire_image_adversaire = new JLabel(new ImageIcon("./img/ordinateur.png"));
	private JLabel jl_commentaire_emotion_adversaire = new JLabel(new ImageIcon("./img/bonnechance.png"));
	private JLabel jl_commentaire_adversaire = new JLabel("Actions de l'ordinateur");
	private JLabel jl_commentaire_center = new JLabel(new ImageIcon("./img/image_accueil_jeu.png"));
	private JLabel jl_image_adversaire = new JLabel(new ImageIcon("./img/ordinateur2.png"));

	private JLabel jl_image_droite = new JLabel(new ImageIcon("./img/image_explosion.png"));
	private JLabel jl_image_gauche = new JLabel(new ImageIcon("./img/image_bateau.png"));

	private JPanel panel_south = new JPanel();

	private JLabel jl_score_joueur = new JLabel("0");
	private JLabel jl_tiret = new JLabel("-");
	private JLabel jl_score_adversaire = new JLabel("0");

	public PanelAffichage() {

		// Declaration du layout du panel
		this.setLayout(new BorderLayout());

		this.jl_tiret.setHorizontalAlignment(JLabel.CENTER);
		this.jl_intro.setFont(new Font("Bookman Old Style", Font.BOLD, 20));
		this.jl_intro.setPreferredSize(new Dimension(100, 60));
		this.jl_intro.setHorizontalAlignment(JLabel.CENTER);

		this.jl_commentaire_joueur.setFont(new Font("Bookman Old Style", Font.BOLD, 12));
		this.jl_commentaire_joueur.setHorizontalAlignment(JLabel.CENTER);
		this.jl_commentaire_joueur.setForeground(Color.BLUE);
		this.jl_commentaire_joueur.setPreferredSize(new Dimension(100, 55));
		this.jl_image_joueur.setHorizontalAlignment(JLabel.CENTER);

		this.jl_commentaire_adversaire.setHorizontalAlignment(JLabel.CENTER);
		this.jl_commentaire_adversaire.setFont(new Font("Bookman Old Style", Font.BOLD, 12));
		this.jl_commentaire_adversaire.setForeground(Color.RED);
		this.jl_commentaire_adversaire.setPreferredSize(new Dimension(100, 55));
		this.jl_image_adversaire.setHorizontalAlignment(JLabel.CENTER);

		this.panel_south.setPreferredSize(new Dimension(100, 85));
		this.panel_south.setLayout(new GridLayout(1, 5));
		this.panel_south.add(this.jl_image_joueur);
		this.panel_south.add(this.jl_score_joueur);
		this.panel_south.add(this.jl_tiret);
		this.panel_south.add(this.jl_score_adversaire);
		this.panel_south.add(this.jl_image_adversaire);

		this.jl_score_joueur.setHorizontalAlignment(JLabel.CENTER);
		this.jl_score_joueur.setFont(new Font("Bookman Old Style", Font.PLAIN, 50));
		this.jl_score_joueur.setForeground(Color.BLUE);

		this.jl_score_adversaire.setHorizontalAlignment(JLabel.CENTER);
		this.jl_score_adversaire.setForeground(Color.RED);
		this.jl_score_adversaire.setFont(new Font("Bookman Old Style", Font.PLAIN, 50));

		jl_tiret.setFont(new Font("Bookman Old Style", Font.PLAIN, 70));

		this.add(this.jl_intro, BorderLayout.NORTH);
		this.add(this.panel_commentaire, BorderLayout.CENTER);
		this.add(this.panel_south, BorderLayout.SOUTH);

		this.panel_commentaire.setLayout(new BorderLayout());
		this.panel_commentaire.add(this.panel_commentaire_joueur, BorderLayout.NORTH);
		this.panel_commentaire.add(this.jl_image_gauche, BorderLayout.WEST);
		this.panel_commentaire.add(this.jl_image_droite, BorderLayout.EAST);
		this.panel_commentaire.add(this.jl_commentaire_center, BorderLayout.CENTER);
		this.panel_commentaire.add(this.panel_commentaire_adversaire, BorderLayout.SOUTH);

		this.panel_commentaire_joueur.setLayout(new BorderLayout());
		this.panel_commentaire_joueur.add(this.jl_commentaire_image_joueur, BorderLayout.WEST);
		this.panel_commentaire_joueur.add(this.jl_commentaire_joueur, BorderLayout.CENTER);
		this.panel_commentaire_joueur.add(this.jl_commentaire_emotion_joueur, BorderLayout.EAST);

		this.panel_commentaire_adversaire.setLayout(new BorderLayout());
		this.panel_commentaire_adversaire.add(this.jl_commentaire_image_adversaire, BorderLayout.WEST);
		this.panel_commentaire_adversaire.add(this.jl_commentaire_adversaire, BorderLayout.CENTER);
		this.panel_commentaire_adversaire.add(this.jl_commentaire_emotion_adversaire, BorderLayout.EAST);

	}

	public JLabel getJl_score_joueur() {
		return this.jl_score_joueur;
	}

	public JLabel getJl_score_adversaire() {
		return this.jl_score_adversaire;
	}

	public JLabel getJl_commentaire_emotion_joueur() {
		return this.jl_commentaire_emotion_joueur;
	}

	public JLabel getJl_commentaire_emotion_adversaire() {
		return this.jl_commentaire_emotion_adversaire;
	}

	public JLabel getJl_commentaire_joueur() {
		return this.jl_commentaire_joueur;
	}

	public JLabel getJl_commentaire_adversaire() {
		return this.jl_commentaire_adversaire;
	}

	public JLabel getJl_commentaire_center() {
		return this.jl_commentaire_center;
	}

}