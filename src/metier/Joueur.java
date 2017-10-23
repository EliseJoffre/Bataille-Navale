package metier;

public class Joueur {
	private String nom;
	private int score;

	public Joueur(String nom) {
		this.nom = nom;
		this.score = 0;
	}
	
	public String getNom() {
		return this.nom;
	}
	
	public void setNom(String nom) {
		this.nom = nom;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}
}