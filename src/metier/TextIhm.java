package metier;

import java.util.Scanner;

public class TextIhm {

	private Jeu jJoueur = new Jeu();
	private Jeu jAdversaire = new Jeu();
	private Plateau pJoueur = new Plateau(10);
	private Plateau pAdversaire = new Plateau(10);
	private Joueur joueur = new Joueur("Joueur");
	// private Joueur adversaire = new Joueur("Adversaire");
	private int choix;
	private String coord = "";

	Scanner scChoix = new Scanner(System.in);
	Scanner scCoord = new Scanner(System.in);

	public TextIhm() {
		// Génération du plateau du joueur
		this.pJoueur = this.jJoueur.genererJeuParDefaut(this.pJoueur);
		// Affichage de la grille du joueur
		Grille(this.pJoueur, this.jJoueur);

		// Génération du plateau de l'adversaire
		this.pAdversaire = this.jAdversaire.genererJeuParDefaut(this.pAdversaire);
		// Affichage de la grille de l'adversaire
		Grille(this.pAdversaire, this.jAdversaire);

		// Tant que le joueur ne veut pas quitter
		while (this.choix != 4) {
			menu();

			// Afficher le plateau des 2 joueurs
			if (this.choix == 1)
				afficherPlateau();
			// Saisir des coordonnées
			if (this.choix == 2)
				saisirCoordonnees();
			// Afficher les scores
			if (this.choix == 3)
				afficherScore();
			// Si le joueur a perdu
			if (this.pAdversaire.getCasesOccupees().equals(this.jJoueur.getCaseTouchee())) {
				System.out.println("PERDU !!!");
				this.choix = 4;
			}
			// Si le joueur a gagné
			if (this.pAdversaire.getCasesOccupees().equals(this.jAdversaire.getCaseTouchee())) {
				System.out.println("GAGNE !!!");
				this.choix = 4;
			}
		}
	}

	public void Grille(Plateau p, Jeu j) {
		int[][] grille = new int[p.getTaille()][p.getTaille()];
		Case c = new Case(0, 0);
		String ligne = " ";

		System.out.println("  0 1 2 3 4 5 6 7 8 9");
		for (int i = 0; i < grille.length; i++) {
			ligne = i + " ";
			for (int l = 0; l < grille[i].length; l++) {
				c = new Case(i, l);
				if (j.getCaseTouchee().contains(c)) {
					ligne = ligne + "3 ";
				} else {
					if (j.getCoupsJoues().contains(c)) {
						ligne = ligne + "2 ";
					} else {
						if (p.getCasesOccupees().contains(c)) {
							ligne = ligne + "1 ";
						} else {
							ligne = ligne + "0 ";
						}
					}
				}
			}
			System.out.println(ligne);
		}
		System.out.println("\n*****************************************************************\n");
	}

	private void afficherPlateau() {
		Grille(this.pJoueur, this.jJoueur);
		Grille(this.pAdversaire, this.jAdversaire);
	}

	private void saisirCoordonnees() {
		// Adversaire joue aléatoirement
		try {
			jouerAdv();
		} catch (CoupException e) {
			System.out.println("Erreur");
		}

		System.out.println("Saisissez les coordonnées du bateau séparés par une virgule");
		this.coord = scCoord.nextLine();

		// Le joueur saisie des coordonnées
		try {
			jouer();
		} catch (CoupException e) {
			System.out.println("Erreur");
		}
	}

	private void afficherScore() {
		afficherScore(this.jJoueur);
		afficherScore(this.jAdversaire);
	}

	private void jouer() throws CoupException {
		String[] coords = coord.split(",");
		int coordX = Integer.parseInt(coords[0]);
		int coordY = Integer.parseInt(coords[1]);
		System.out.println("Coup joué : " + coordX + " - " + coordY);
		try {
			jAdversaire.jouer(coordX, coordY, this.pAdversaire);
		} catch (CoupException e) {
			System.out.println("Ce coup n'est pas autorisé !");
		}
	}

	private void jouerAdv() throws CoupException {
		int coordX = (int) (Math.random() * this.pJoueur.getTaille());
		int coordY = (int) (Math.random() * this.pJoueur.getTaille());
		System.out.println("Coup joués : " + coordX + " - " + coordY);
		try {
			jJoueur.jouer(coordX, coordY, this.pJoueur);
		} catch (CoupException e) {
			System.out.println("Les coordonnées ne sont pas valides");
		}
	}

	private void afficherScore(Jeu j) {
		System.out.println("*****************************************************************");
		System.out.println("Votre score : " + joueur.getScore());
		System.out.println("*****************************************************************\n");
	}

	public void menu() {
		System.out.println("");
		System.out.println("1) Afficher le plateau");
		System.out.println("2) Rentrer des coordonnées");
		System.out.println("3) Afficher le score");
		System.out.println("4) Quitter le jeu");
		System.out.println("Veuillez saisir votre choix");
		choix = scChoix.nextInt();
		System.out.println("*****************************************************************");
	}

	public static void main(String[] args) {
		new TextIhm();
	}
}