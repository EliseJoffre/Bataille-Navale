package metier;

import java.util.ArrayList;
import java.util.List;

public class Plateau {
	private int taille;
	private List<Bateau> listeBat;
	private List<Case> casesOccupees;
	private boolean[][] coupsJoues;
	private boolean caseTouchee;

	public Plateau(int taille) {
		if (taille <= 0) {
			throw new IllegalArgumentException("La taille du plateau ne peut pas être nulle ni négative ! ");
		}
		if (taille > 10) {
			throw new IllegalArgumentException("La taille du plateau ne peut pas être supérieure à 10 !");
		}
		this.taille = taille;
		this.listeBat = new ArrayList<Bateau>();
		this.casesOccupees = new ArrayList<Case>();
		this.coupsJoues = new boolean[100][100];
		this.caseTouchee = false;
	}

	// Place un bateau en horizontal
	private List<Case> randomizeHorizontal(Bateau b, Plateau p) {
		int nbCaseBateau = 0;
		boolean estPlace = false;
		int randomX = 0;
		int randomY = 0;
		List<Case> casesBat = new ArrayList<Case>();

		do {
			randomX = (int) (Math.random() * this.taille);
			randomY = (int) (Math.random() * (this.taille - b.getTaille()));
		} while (randomX == 0 || randomY == 0 || p.casesOccupees.contains(new Case(randomX, randomY))
				|| p.casesOccupees.contains(new Case(randomX, randomY + 1))
				|| p.casesOccupees.contains(new Case(randomX, randomY + b.getTaille() - 1)));
		casesBat.add(new Case(randomX, randomY));
		p.casesOccupees.add(new Case(randomX, randomY));

		while (!estPlace) {

			while (nbCaseBateau < b.getTaille() - 1 && b.getTaille() > 1) {
				randomY++;
				casesBat.add(new Case(randomX, randomY));
				p.casesOccupees.add(new Case(randomX, randomY));
				nbCaseBateau++;
			}
			if (nbCaseBateau == b.getTaille() - 1) {
				estPlace = true;
			}
		}
		return casesBat;
	}

	// Place un bateau en vertical
	private List<Case> randomizeVertical(Bateau b, Plateau p) {
		int nbCaseBateau = 0;
		boolean estPlace = false;
		int randomX = 0;
		int randomY = 0;
		List<Case> casesBat = new ArrayList<Case>();

		do {
			randomX = (int) (Math.random() * (this.taille - b.getTaille()));
			randomY = (int) (Math.random() * this.taille);
		} while (randomX == 0 || randomY == 0 || p.casesOccupees.contains(new Case(randomX, randomY))
				|| p.casesOccupees.contains(new Case(randomX + 1, randomY))
				|| p.casesOccupees.contains(new Case(randomX + 2, randomY))
				|| p.casesOccupees.contains(new Case(randomX + b.getTaille() - 1, randomY)));
		casesBat.add(new Case(randomX, randomY));
		p.casesOccupees.add(new Case(randomX, randomY));

		while (!estPlace) {

			while (nbCaseBateau < b.getTaille() - 1 && b.getTaille() > 1) {
				randomX++;
				casesBat.add(new Case(randomX, randomY));
				p.casesOccupees.add(new Case(randomX, randomY));
				nbCaseBateau++;
			}
			if (nbCaseBateau == b.getTaille() - 1) {
				estPlace = true;
			}
		}
		return casesBat;
	}

	// Place une liste de bateaux de manières aléatoire
	public void randomiserPlacement(List<Bateau> listeB, Plateau p) {
		int placer = 0;
		for (Bateau bat : listeB) {
			List<Case> cases = new ArrayList<Case>();
			if (placer == 0) {
				cases = randomizeHorizontal(bat, p);
				placer = 1;
			} else {
				cases = randomizeVertical(bat, p);
				placer = 0;
			}
			bat.setCases(cases);
			listeBat.add(bat);
		}
	}

	public Bateau jouerCoup(int x, int y, Plateau p) {
		List<Case> casesTouche = new ArrayList<Case>();
		Bateau bateauTouche = new Bateau(1);
		caseTouchee = false;
		// Si le coup n'a pas déjà été joué
		if (!coupsJoues[x][y]) {

			// On demande à la liste des bateaux qui a été touché
			for (Bateau b : p.getListeBat()) {
				List<Case> cases = b.getCases();
				for (Case c : cases) {
					if (!(casesTouche.contains(c)) && c.getPosX() == x && c.getPosY() == y) {
						c.setEstTouche(true);
						casesTouche.add(c);
						bateauTouche = b;
						caseTouchee = true;
					}
				}

			}
			coupsJoues[x][y] = true;
		}
		return bateauTouche;
	}

	public int getTaille() {
		return this.taille;
	}

	public void setTaille(int taille) {
		this.taille = taille;
	}

	public List<Bateau> getListeBat() {
		return listeBat;
	}

	public void setListeBat(List<Bateau> listeBat) {
		this.listeBat = listeBat;
	}

	public List<Case> getCasesOccupees() {
		return casesOccupees;
	}

	public void setCasesOccupees(List<Case> casesOccupees) {
		this.casesOccupees = casesOccupees;
	}

	public boolean getTouche() {
		return this.caseTouchee;
	}

	public void setTouche(boolean touche) {
		this.caseTouchee = touche;
	}

}