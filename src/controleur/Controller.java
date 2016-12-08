package controleur;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.net.URISyntaxException;
import model.ABR;


public class Controller {
	
	public Controller() {
		
	}

	public void readFileABR(String filename) throws IOException, URISyntaxException {
		BufferedReader br = new BufferedReader(new FileReader(filename));
	    String line = null;
	    while ((line = br.readLine()) != null) {
	        System.out.println(line);
	    }
	}

	public void createFileABR(ABR tabArbre) {

	}
}
