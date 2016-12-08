package model;

public class ABR {
	private int debut;
	private int fin;
	private int[] parcoursSuffixe;
	
	public ABR() {
		
	}
	
	public ABR(int debut, int fin, int[] parcoursSuffixe) {
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
	public int[] getParcoursSuffixe() {
		return parcoursSuffixe;
	}
	public void setParcoursSuffixe(int[] parcoursSuffixe) {
		this.parcoursSuffixe = parcoursSuffixe;
	}

	public String toString() {
		return  debut
				+ ":"
				+ fin
				+ ";"
				+ (parcoursSuffixe != null ? arrayToString(parcoursSuffixe,
						parcoursSuffixe.length) : null);
	}

	private String arrayToString(Object array, int len) {
		StringBuffer buffer = new StringBuffer();
		for (int i = 0; i < len; i++) {
			if (i > 0)
				buffer.append(":");
			if (array instanceof int[])
				buffer.append(((int[]) array)[i]);
		}
		return buffer.toString();
	}
}
