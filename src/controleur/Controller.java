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

import model.ABR;

public class Controller {
	
	public Controller() {
		
	}
	
	
	public void readFileABR(String filename) throws IOException, URISyntaxException {
		BufferedReader br = new BufferedReader(new FileReader("bin/exemples/figure1.txt"));
	    String line = null;
	    while ((line = br.readLine()) != null) {
	        System.out.println(line);
	    }
	}

	public void createFileABR(ABR tabArbre) {

	}
}
