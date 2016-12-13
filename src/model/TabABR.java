package model;

public class TabABR {
	private int debut;
	private int fin;
	private ABR arbre;

	public TabABR(int debut, int fin, ABR arbre) {
		this.debut = debut;
		this.fin = fin;
		this.arbre = arbre;
	}

	public int getDebut() {
		return debut;
	}

	public void setDebut(int debut) {
		this.debut = debut;
	}

	public int getFin() {
		return fin;
	}

	public void setFin(int fin) {
		this.fin = fin;
	}

	public ABR getArbre() {
		return arbre;
	}

	public void setArbre(ABR arbre) {
		this.arbre = arbre;
	}
}
