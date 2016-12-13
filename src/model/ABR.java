package model;

import java.util.List;

public class ABR {
	private int racine;
	private ABR sag;
	private ABR sad;
	
	public ABR() {
		
	}
	
	public ABR(int racine, ABR sag, ABR sad) {
		super();
		this.racine = racine;
		this.sad = sad;
		this.sag = sag;
	}

	public int getRacine() {
		return racine;
	}

	public void setRacine(int racine) {
		this.racine = racine;
	}

	public ABR getSag() {
		return sag;
	}

	public void setSag(ABR sag) {
		this.sag = sag;
	}

	public ABR getSad() {
		return sad;
	}

	public void setSad(ABR sad) {
		this.sad = sad;
	}
}
