package model;

import java.util.List;

public class ABR {
	private int debut;
	private int fin;
	private List<Integer> parcoursSuffixe;
	
	public ABR() {
		
	}
	
	public ABR(int debut, int fin, List<Integer> parcoursSuffixe) {
		super();
		this.debut = debut;
		this.fin = fin;
		this.parcoursSuffixe = parcoursSuffixe;
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

	public List<Integer> getParcoursSuffixe() {
		return parcoursSuffixe;
	}

	public void setParcoursSuffixe(List<Integer> parcoursSuffixe) {
		this.parcoursSuffixe = parcoursSuffixe;
	}

	@Override
	public String toString() {
		return "ABR [debut=" + debut + ", fin=" + fin + ", parcoursSuffixe="
				+ parcoursSuffixe + "]";
	}

}
