package controleur;

import java.io.*;
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
		File f = new File("bin/exemples/figure1.txt");
		try
		{
			FileWriter fw = new FileWriter (f);
			fw.write (tabArbre.toString());
			fw.write ("\r\n");

			fw.close();
		}
		catch (IOException exception)
		{
			System.out.println ("Erreur lors de la lecture : " + exception.getMessage());
		}
	}
}
