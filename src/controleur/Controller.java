package controleur;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import model.ABR;

public class Controller {
	List<Integer> parcoursSuffixe = new ArrayList<>();
	
	public Controller() {
		
	}

	/*public void readFileABR(String filename) throws IOException, URISyntaxException {
		BufferedReader br = new BufferedReader(new FileReader(filename));
	    String line = null;
	    while ((line = br.readLine()) != null) {
	    	String[] ligneSpliter = line.split(";");
	    	String debut = ligneSpliter[0].split(":")[0];
	    	String fin = ligneSpliter[0].split(":")[1];
	        String[] suffixe = ligneSpliter[1].split(":");
	        
	        ABR abr = new ABR();
	        abr.setDebut(Integer.parseInt(debut));
	        abr.setFin(Integer.parseInt(fin));
	        
	        List<Integer> parcoursSuffixe = new ArrayList();
			for(int i = 0; i < suffixe.length; i++) {
	        	parcoursSuffixe.add(Integer.parseInt(suffixe[i]));
	        }
	        abr.setParcoursSuffixe(parcoursSuffixe);
	    }
	}*/

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

	/*public void displayTABR(TabABR tableauABR) {
		for(Iterator iterator = tableauABR.getListeABR().iterator(); iterator.hasNext(); ) {
			System.out.println(iterator);
		}
	}*/

	public List<Integer> getParcoursSuffixe(ABR abr) {

		if (abr.getSag() != null){
			this.parcoursSuffixe = getParcoursSuffixe(abr.getSag());
		}
		if (abr.getSad() != null) {
			this.parcoursSuffixe = getParcoursSuffixe(abr.getSad());
		}
		this.parcoursSuffixe.add(abr.getRacine());

		return parcoursSuffixe;
	}

	public String toStringForWrite(ABR abr) {
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
}
