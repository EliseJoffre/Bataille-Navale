package metier;

import metier.Case;
import java.util.ArrayList;
import java.util.List;

public class Bateau {
	private int taille;
	private List<Case> cases;
	private boolean estCoule;

	public Bateau(int taille) {
		this.taille = taille;
		cases = new ArrayList<Case>();
		this.estCoule = false;
	}

	public int getTaille() {
		return this.taille;
	}

	public void setTaille(int taille) {
		this.taille = taille;
	}

	public List<Case> getCases() {
		return this.cases;
	}

	public void setCases(List<Case> cases) {
		this.cases = cases;
	}

	public boolean getEstCoule() {
		return this.estCoule;
	}

	public void setEstCoule(boolean estCoule) {
		this.estCoule = estCoule;
	}

	@Override
	public String toString() {
		return "Bateau :[taille=" + this.taille + ", estCoule=" + this.estCoule + "]";
	}

}