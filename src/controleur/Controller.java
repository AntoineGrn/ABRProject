package controleur;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import model.ABR;

public class Controller {
	
	public Controller() {
		
	}
	
	
	public void readFileABR(String filename) throws IOException, URISyntaxException {
		BufferedReader br = new BufferedReader(new FileReader("bin/exemples/figure1.txt"));
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
	}

	public void createFileABR(ABR tabArbre) {

	}
}
