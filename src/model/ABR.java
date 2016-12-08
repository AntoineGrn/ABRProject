package model;

public class ABR {
    private int debut;
    private int fin;
    private  int[] parcoursSuffixe;

    public ABR(int debut, int fin, int[] parcoursSuffixe) {
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
}
