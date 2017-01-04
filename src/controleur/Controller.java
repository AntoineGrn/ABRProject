package controleur;

import java.io.*;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import model.ABR;
import model.TabABR;

import javax.swing.table.TableRowSorter;

public class Controller {
	List<Integer> parcoursSuffixe = new ArrayList<Integer>();

	public Controller() {
		
	}

	public List<TabABR> readFileABR(String filename) throws IOException, URISyntaxException {
		BufferedReader br = new BufferedReader(new FileReader(filename));
	    String line = null;
	    List<TabABR> listTab = new ArrayList<TabABR>();
	    while ((line = br.readLine()) != null) {
	    	String[] ligneSpliter = line.split(";");
	    	String debut = ligneSpliter[0].split(":")[0];
	    	String fin = ligneSpliter[0].split(":")[1];
	        String[] suffixe = ligneSpliter[1].split(":");

	        List<Integer> parcoursSuffixe = new ArrayList();
			for(int i = 0; i < suffixe.length; i++) {
	        	parcoursSuffixe.add(Integer.parseInt(suffixe[i]));
	        }

	        TabABR tabr = new TabABR();
	        tabr = this.createTabABR(Integer.parseInt(debut), Integer.parseInt(fin), parcoursSuffixe);
	        listTab.add(tabr);
	    }
	    return listTab;
	}

	public void createFileABR(ABR tabArbre) {
		File f = new File("bin/exemples/figure1.txt");
		try
		{
			FileWriter fw = new FileWriter (f, true);
			fw.write (toStringForWrite(tabArbre));
			fw.write ("\r\n");

			fw.close();
		}
		catch (IOException exception)
		{
			System.out.println ("Erreur lors de la lecture : " + exception.getMessage());
		}
	}

	public void addTABRintoFile(TabABR tabr) {
		File f = new File("bin/exemples/figure1.txt");
		try
		{
			FileWriter fw = new FileWriter (f, true);
			fw.write (toStringTABR(tabr));
			fw.write ("\r\n");

			fw.close();
		}
		catch (IOException exception)
		{
			System.out.println ("Erreur lors de la lecture : " + exception.getMessage());
		}
	}

	public void addListTABRintoNewFile(List<TabABR> listetabr, String nomFichier) {
		File f = new File(nomFichier);
		try
		{
			FileWriter fw = new FileWriter (f, true);
			for (TabABR tabr: listetabr) {
				fw.write (toStringTABR(tabr));
			}
			fw.write ("\r\n");

			fw.close();
		}
		catch (IOException exception)
		{
			System.out.println ("Erreur lors de la lecture : " + exception.getMessage());
		}
	}

	public TabABR createTabABR(int debut, int fin, List<Integer> parcoursSuffixe) {
		TabABR tabr = new TabABR();
		tabr.setFin(fin);
        tabr.setDebut(debut);
        ABR abr = this.createABR(parcoursSuffixe);
        tabr.setArbre(abr);
		System.out.println(this.toStringTABR(tabr));
		return tabr;

	}

	public ABR createABR(List<Integer> parcoursSuffixe) {
		ABR abr = new ABR();
		abr.setRacine(parcoursSuffixe.get(parcoursSuffixe.size()-1));
		if(parcoursSuffixe.size() != 1) {
			List<Integer> inferieur = new ArrayList<Integer>();
			List<Integer> superieur = new ArrayList<Integer>();
			int compteurInferieur = 0;
			int compteurSuperieur = 0;
			for(int index=parcoursSuffixe.size()-1; index >= 0; index--) {
				if (parcoursSuffixe.get(index) < abr.getRacine()) {
					inferieur.add(compteurInferieur, parcoursSuffixe.get(index));
					compteurInferieur++;
				}else if (parcoursSuffixe.get(index) > abr.getRacine()) {
					superieur.add(compteurSuperieur, parcoursSuffixe.get(index));
					compteurSuperieur++;
				}
			}
			Collections.reverse(superieur);
			Collections.reverse(inferieur);
			if (inferieur.size() > 0) {
				ABR abrsag = this.createABR(inferieur);
				abr.setSag(abrsag);
			}else {
				abr.setSag(null);
			}
			if (superieur.size() > 0){
				ABR abrsad = this.createABR(superieur);
				abr.setSad(abrsad);
			}else {
				abr.setSad(null);
			}
		}
		//System.out.println(this.toStringABR(abr));
		return abr;
	}

	public List<Integer> getParcoursSuffixe(ABR abr) {

		if (abr.getSag() != null){
			this.parcoursSuffixe = this.getParcoursSuffixe(abr.getSag());
		}
		if (abr.getSad() != null) {
			this.parcoursSuffixe = this.getParcoursSuffixe(abr.getSad());
		}
		this.parcoursSuffixe.add(abr.getRacine());
		return this.parcoursSuffixe;
	}

	public String toStringForWrite(ABR abr) {
		this.parcoursSuffixe.clear();
		List<Integer> list = this.getParcoursSuffixe(abr);
		System.out.println(list.toString().replace("[", "").replace("]", "").replace(", ",":"));
		int min = list.get(0);
		int max = list.get(0);

		for(Integer i: list) {
			if (i < min) min = i;
			if (i > max) max = i;
		}

		return min + ":" + max + ";" + list.toString().replace("[", "").replace("]", "").replace(", ",":");
	}

	public TabABR createTabrByAbr(ABR abr) {
		TabABR tabr = new TabABR();
		this.parcoursSuffixe.clear();
		List<Integer> list = this.getParcoursSuffixe(abr);
		System.out.println(list.toString().replace("[", "").replace("]", "").replace(", ",":"));
		int min = list.get(0);
		int max = list.get(0);

		for(Integer i: list) {
			if (i < min) min = i;
			if (i > max) max = i;
		}
		tabr.setArbre(abr);
		tabr.setDebut(min);
		tabr.setFin(max);
		return tabr;
	}

	public String toStringListTABR(List<TabABR> listtabr){
		String res = "";
		for (TabABR tabr: listtabr) {
			res = res + this.toStringTABR(tabr) + "\n";
		}
		return res;
	}

	public String toStringTABR(TabABR tabr){
		return tabr.getDebut() + ":" + tabr.getFin() + ";" + this.toStringABR(tabr.getArbre());
	}

	public String toStringABR(ABR abr) {
		String result = "";
		if (abr.getSag() != null){
			result = this.toStringABR(abr.getSag()) + ":";
		}
		if (abr.getSad() != null){
			result = result + this.toStringABR(abr.getSad()) + ":";
		}
		return result + abr.getRacine();
	}

	public void createTABRAleatoire(int n, int m) {
		System.out.println("variable n : " + n + "\nvariable m : " + m);
	}

	public boolean verificationTABR(List<TabABR> listetabr) {
		boolean verifContenuABR = true;
		for (int i = 0; i <= listetabr.size()-1; i++) {
			if(verifContenuABR) {
				int debutTmp = listetabr.get(i).getDebut();
				int finTmp = listetabr.get(i).getFin();

				// verification que le debut de l'intervalle est inférieur à la fin de l'intervalle
				if(debutTmp>finTmp) verifContenuABR = false;

				// verification que tous les elements de l'abr sont contenus dans l'intervalle du tabr
				this.parcoursSuffixe.clear();
				List<Integer> list = this.getParcoursSuffixe(listetabr.get(i).getArbre());
				int min = list.get(0);
				int max = list.get(0);

				for(Integer index: list) {
					if (index < min) min = index;
					if (index > max) max = index;
				}
				if(debutTmp > min || finTmp < max) verifContenuABR = false;

				// verification que tous les intervalles sont dans l'ordre croissant
				if (i != listetabr.size()-1 && finTmp > listetabr.get(i+1).getDebut()) verifContenuABR = false;
			}
		}
		return verifContenuABR;
	}

	public TabABR insertionEntierIntoTabr(int nbr, List<TabABR> listeTabr) {
		boolean intervalleOk = false;
		TabABR res = null;

		for (TabABR tabr: listeTabr) {
			if (nbr <= tabr.getFin() && nbr >= tabr.getDebut()){
				intervalleOk = true;
				ABR newAbr = this.insertionEntierAbr(nbr, tabr.getArbre());
				tabr.setArbre(newAbr);
				System.out.println(this.toStringTABR(tabr));
				res = tabr;
			}
		}
		if (!intervalleOk) System.out.println("Erreur pendant l'insertion, l'élément que vous voulez ajouter n'appartient à aucun intervalle");

		return res;
	}

	private ABR insertionEntierAbr(int nbr, ABR abr) {
		if(nbr < abr.getRacine()) {
			if(abr.getSag() == null) {
				ABR nouvelElem = new ABR(nbr, null, null);
				abr.setSag(nouvelElem);
				System.out.println("Element ajouté avec succès");
			}else {
				insertionEntierAbr(nbr, abr.getSag());
			}
		}
		if(nbr > abr.getRacine()) {
			if(abr.getSad() == null) {
				ABR nouvelElem = new ABR(nbr, null, null);
				abr.setSad(nouvelElem);
				System.out.println("Element ajouté avec succès");
			}else {
				insertionEntierAbr(nbr, abr.getSad());
			}
		}
		if(nbr == abr.getRacine()) {
			System.out.println("Erreur pendant l'insertion, l'élément que vous voulez ajouter existe déjà");
		}
		return abr;
	}

	public List<TabABR> suppressionEntierIntoTabr(int nbr, List<TabABR> liste) {
		boolean intervalleOk = false;
		TabABR res = null;

		for (TabABR tabr: liste) {
			if (nbr <= tabr.getFin() && nbr >= tabr.getDebut()){
				int index = liste.indexOf(tabr);
				intervalleOk = true;
				ABR newAbr = this.suppressionEntierAbr(nbr, tabr.getArbre());
				tabr.setArbre(newAbr);
				System.out.println(this.toStringTABR(tabr));
				liste.set(index, tabr);
			}
		}
		if (!intervalleOk) System.out.println("Erreur pendant la suppression, l'élément que vous voulez supprimer n'appartient à aucun intervalle");

		return null;
	}

	private ABR suppressionEntierAbr(int nbr, ABR abr) {
		boolean nbrExist = this.isElementExist(nbr, abr);
		if (!nbrExist) {
			System.out.println("Erreur pendant la suppression, l'élément que vous voulez supprimer n'existe pas");
			return abr;
		}
		if(nbr < abr.getRacine()) {
			if(abr.getSag() != null) {
				abr.setSag(suppressionEntierAbr(nbr, abr.getSag()));
			}
		}
		if(nbr > abr.getRacine()) {
			if(abr.getSad() != null) {
				abr.setSad(suppressionEntierAbr(nbr, abr.getSad()));
			}
		}
		if(nbr == abr.getRacine()) {
			if(abr.getSag() == null && abr.getSad() != null) {
				abr.setRacine(abr.getSad().getRacine());
				abr.setSag(abr.getSad().getSag());
				abr.setSad(abr.getSad().getSad());
			}
			if(abr.getSad() == null && abr.getSag() != null) {
				abr.setRacine(abr.getSag().getRacine());
				abr.setSag(abr.getSag().getSag());
				abr.setSad(abr.getSag().getSad());
			}
			if(abr.getSag() != null && abr.getSad() != null) {
				int maxValueAbr = this.getMaxValueAbr(abr.getSag());
				suppressionEntierAbr(maxValueAbr, abr.getSag());
				abr.setRacine(maxValueAbr);
			}
			if(abr.getSag() == null && abr.getSad() == null) {
				abr = null;
			}
			System.out.println("Elément supprimé avec succès");
		}
		return abr;
	}

	private boolean isElementExist(int nbr, ABR abr) {
		boolean result = false;
		if(nbr < abr.getRacine()) {
			if(abr.getSag() != null) {
				result = isElementExist(nbr, abr.getSag());
			}
		}
		if(nbr > abr.getRacine()) {
			if(abr.getSad() != null) {
				result = isElementExist(nbr, abr.getSad());
			}
		}
		if(nbr == abr.getRacine()) {
			result = true;
		}
		return result;
	}

	private int getMaxValueAbr(ABR abr) {
		List<Integer> list = this.getParcoursSuffixe(abr);
		int max = list.get(0);
		for(Integer i: list) {
			if (i > max) max = i;
		}
		return max;
	}

	public List<TabABR> fusionCasesTabr(int indice, List<TabABR> liste) {
		TabABR tabABR = liste.get(indice);
		tabABR.setFin(liste.get(indice+1).getFin());
		ABR newArbre = this.fusionAbr(tabABR.getArbre(), liste.get(indice + 1).getArbre());
		tabABR.setArbre(newArbre);
		liste.set(indice, tabABR);
		liste.remove(indice+1);
		return liste;
	}

	public ABR fusionAbr(ABR abr1, ABR abr2) {
		this.parcoursSuffixe.clear();
		List<Integer> list = this.getParcoursSuffixe(abr2);
		Collections.reverse(list);
		for (Integer nbr: list) {
			this.insertionEntierAbr(nbr, abr1);
		}
		return abr1;
	}

	/*
	Retourne un booleen à true si l'arbre est équilibré

	Retourne un booleen à false si l'arbre n'est pas équilibré
	et affiche alors :
	1. la valeur d’un nœud v pour lequel l’équilibre en profondeur n’est pas respecté
	2. la profondeur du sag de v
	3. la profondeur du sad de v.
	Note : par convention, la profondeur d’un arbre vide est égale à -1.
	 */
	public boolean equilibreABR(ABR abr) {
		int profondeurSag;
		int profondeurSad;

		if (abr == null)
			return true;

		 /* Calcul les hauteurs des deux sous arbres */
		profondeurSag = hauteur(abr.getSag());
		profondeurSad = hauteur(abr.getSad());

		if (Math.abs(profondeurSag - profondeurSad) <= 1 && equilibreABR(abr.getSag()) && equilibreABR(abr.getSad())){
			return true;
		}else {
			System.out.println("L'arbre n'est pas équilibré");
			System.out.println("1. Le noeud " + abr.getRacine() + " à une profondeur non conforme");
			System.out.println("2. La profondeur du sag de " + abr.getRacine() + " est de : " + profondeurSag);
			System.out.println("3. La profondeur du sad de " + abr.getRacine() + " est de : " + profondeurSad);
		}

		return false;
	}

	private int hauteur(ABR abr)
	{
		if (abr == null)
			return 0;

        /*
        hauteur = 1 + max entre hauteur de gauche et hauteur de droite)
        */
		int res = 1 + Math.max(hauteur(abr.getSag()), hauteur(abr.getSad()));
		return res;
	}

	public List<TabABR> transformABRtoTABR(ABR abr, int min, int max, List<Integer> listeIntervalle) {
		List<TabABR> listeTabr = new ArrayList<TabABR>();
		for (int i = 0; i <= listeIntervalle.size()-1; i++) {
			if (i == 0) {
				TabABR tabr1 = new TabABR();
				// récupération du parcours suffixe de l'abre
				List<Integer> parcoursSuffixe = this.getParcoursSuffixe(abr);
				Integer indexFin = listeIntervalle.get(i);
				// filtrage sur les valeurs qui ne sont pas dans l'intervalle choisi
				List<Integer> collect = parcoursSuffixe.stream().filter(nombre -> nombre >= min && nombre <= indexFin).collect(Collectors.toList());
				// création du nouvel arbre contenant les valeurs comprises dans l'intervalle choisi
				ABR abr1 = this.createABR(collect);
				// ajout du nouvel arbre au tabr
				tabr1.setArbre(abr1);
				tabr1.setDebut(min);
				tabr1.setFin(listeIntervalle.get(i));
				listeTabr.add(tabr1);
			} else{
				TabABR tabr3 = new TabABR();
				// récupération du parcours suffixe de l'abre
				List<Integer> parcoursSuffixe = this.getParcoursSuffixe(abr);
				Integer indexDebut = listeIntervalle.get(i-1)+1;
				Integer indexFin = listeIntervalle.get(i);
				// filtrage sur les valeurs qui ne sont pas dans l'intervalle choisi
				List<Integer> collect = parcoursSuffixe.stream().filter(nombre -> nombre >= indexDebut && nombre <= indexFin).collect(Collectors.toList());
				// création du nouvel arbre contenant les valeurs comprises dans l'intervalle choisi
				ABR abr3 = this.createABR(collect);
				// ajout du nouvel arbre au tabr
				tabr3.setArbre(abr3);
				tabr3.setDebut(listeIntervalle.get(i-1)+1);
				tabr3.setFin(listeIntervalle.get(i));
				listeTabr.add(tabr3);
			}
			if(i == listeIntervalle.size()-1){
				TabABR tabr2 = new TabABR();
				// récupération du parcours suffixe de l'abre
				List<Integer> parcoursSuffixe = this.getParcoursSuffixe(abr);
				Integer indexDebut = listeIntervalle.get(i)+1;
				// filtrage sur les valeurs qui ne sont pas dans l'intervalle choisi
				List<Integer> collect = parcoursSuffixe.stream().filter(nombre -> nombre >= indexDebut && nombre <= max).collect(Collectors.toList());
				// création du nouvel arbre contenant les valeurs comprises dans l'intervalle choisi
				ABR abr2 = this.createABR(collect);
				// ajout du nouvel arbre au tabr
				tabr2.setArbre(abr2);
				tabr2.setDebut(listeIntervalle.get(i)+1);
				tabr2.setFin(max);
				listeTabr.add(tabr2);
			}
		}
		return listeTabr;
	}

	public TabABR transformTABRtoABR(List<TabABR> tabABRList) {
		TabABR newTabr = new TabABR();
		ABR newAbr = new ABR();
		newTabr.setDebut(tabABRList.get(0).getDebut());
		newTabr.setFin(tabABRList.get(tabABRList.size()-1).getFin());
		for (TabABR tabr: tabABRList) {
			if(tabABRList.indexOf(tabr) == 0){
				newAbr = tabr.getArbre();
			}else {
				newAbr = this.fusionAbr(newAbr, tabr.getArbre());
			}
		}
		newTabr.setArbre(newAbr);
		return newTabr;
	}
}
