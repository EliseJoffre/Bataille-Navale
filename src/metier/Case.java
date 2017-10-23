package metier;

public class Case {
	private int posX;
	private int posY;
	private boolean estTouche;

	public Case(int posX, int posY) {
		this.posX = posX;
		this.posY = posY;
		this.estTouche = false;
	}

	public int getPosX() {
		return posX;
	}

	public void setPosX(int posX) {
		this.posX = posX;
	}

	public int getPosY() {
		return posY;
	}

	public void setPosY(int posY) {
		this.posY = posY;
	}

	public boolean getEstTouche() {
		return estTouche;
	}

	public void setEstTouche(boolean estTouche) {
		this.estTouche = estTouche;
	}

	@Override
	public int hashCode() {
		int result = 1;
		result = 31 * result + this.posX;
		result = 31 * result + this.posY;
		return result;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o == null) {
			return false;
		}
		if (!(o instanceof Case)) {
			return false;
		}
		Case autre = (Case) o;
		if (this.posX != autre.posX) {
			return false;
		}
		if (this.posY != autre.posY) {
			return false;
		}
		return true;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Case [posX=");
		builder.append(posX);
		builder.append(", posY=");
		builder.append(posY);
		builder.append(", estTouche=");
		builder.append(estTouche);
		builder.append("]");
		return builder.toString();
	}

}