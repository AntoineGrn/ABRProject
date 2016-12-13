package controleur;

import java.io.*;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import model.ABR;
import model.TabABR;

public class Controller {

	public Controller() {
		
	}

	public void readFileABR(String filename) throws IOException, URISyntaxException {
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
	}

	public void createFileABR(ABR tabArbre) {
		File f = new File("bin/exemples/figure1.txt");
		try
		{
			FileWriter fw = new FileWriter (f, true);
			System.out.println(tabArbre.toString());
			fw.write (tabArbre.toString());
			fw.write ("\r\n");

			fw.close();
		}
		catch (IOException exception)
		{
			System.out.println ("Erreur lors de la lecture : " + exception.getMessage());
		}
	}

	public void displayTABR(TabABR tableauABR) {
		/*for(Iterator iterator = tableauABR.getListeABR().iterator(); iterator.hasNext(); ) {
			System.out.println(iterator);
		}*/
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
			for(int index=parcoursSuffixe.size()-1; index >= 0; index--) {
				if (parcoursSuffixe.get(index) < abr.getRacine()) {
					inferieur.add(parcoursSuffixe.get(index));
				}else if (parcoursSuffixe.get(index) > abr.getRacine()) {
					superieur.add(parcoursSuffixe.get(index));
				}
			}
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
}
