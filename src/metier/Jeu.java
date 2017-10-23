package metier;

import java.util.ArrayList;
import java.util.List;

import metier.Case;
import metier.CoupException;
import metier.Bateau;
import metier.Plateau;

public class Jeu {
	private List<Case> coupsJoues = new ArrayList<Case>();
	private List<Case> caseTouchee = new ArrayList<Case>();

	List<Bateau> listeB = new ArrayList<Bateau>();
	Bateau porte_avions = new Bateau(5);
	Bateau croiseur = new Bateau(4);
	Bateau contre_torpilleur = new Bateau(2);
	Bateau sous_marin = new Bateau(3);
	Bateau torpilleur = new Bateau(3);
	Bateau bateau = new Bateau(2);

	public void jouer(int x, int y, Plateau p) throws CoupException {
		// Controle que le coup soit permis
		this.getCoupAutorise(x, y);
		Bateau b = p.jouerCoup(x, y, p);

		// Actualise la liste des coups joues
		Case ca = new Case(x, y);
		this.coupsJoues.add(ca);
		// Actualise la liste des cases touchees
		if (p.getTouche()) {
			int i = 0;
			ca.setEstTouche(true);
			this.caseTouchee.add(ca);

			// Cherche si le bateau entier est touche
			for (Case c : b.getCases()) {
				if (c.getEstTouche()) {
					i++;
					if (i == b.getTaille()) {
						b.setEstCoule(true);
					}
				}
			}
		} else
			System.out.println("Dommage, essayes encore");
	}

	private void getCoupAutorise(int x, int y) throws CoupException {
		if (x >= 10 || y >= 10) {
			throw new CoupException("Les coordonnees sont trop grandes");
		}
		if (x < 0 || y < 0) {
			throw new CoupException("Les coordonnees ne peuvent pas etre negatives");
		}
		if (coupsJoues.contains(new Case(x, y))) {
			throw new CoupException("Deja joue !");
		}
	}

	public Plateau genererJeuParDefaut(Plateau p) {
		listeB.add(porte_avions);
		listeB.add(croiseur);
		listeB.add(contre_torpilleur);
		listeB.add(sous_marin);
		listeB.add(torpilleur);
		listeB.add(bateau);
		p.randomiserPlacement(listeB, p);

		return p;
	}

	public Bateau getCroiseur() {
		return croiseur;
	}

	public Bateau getContre_torpilleur() {
		return contre_torpilleur;
	}

	public Bateau getSous_marin() {
		return sous_marin;
	}

	public Bateau getTorpilleur() {
		return torpilleur;
	}

	public Bateau getBateau() {
		return bateau;
	}

	public Bateau getPorte_avions() {
		return porte_avions;
	}

	public List<Case> getCoupsJoues() {
		return this.coupsJoues;
	}

	public void setCoupsJoues(List<Case> coupsJoues) {
		this.coupsJoues = coupsJoues;
	}

	public List<Case> getCaseTouchee() {
		return this.caseTouchee;
	}

	public void setCaseTouchee(List<Case> caseTouchee) {
		this.caseTouchee = caseTouchee;
	}
}