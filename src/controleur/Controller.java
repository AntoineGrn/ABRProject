package controleur;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Controller {
	
	public Controller() {
		
	}
	
	
	public void readFileABR(String filename) throws IOException, URISyntaxException {
		URI file = new URI(filename);
		Path path = Paths.get(file);
		InputStream in = Files.newInputStream(path, null);
		BufferedReader reader = new BufferedReader(new InputStreamReader(in));
	    String line = null;
	    while ((line = reader.readLine()) != null) {
	        System.out.println(line);
	    }
	}

	public void createFileABR(ABR tabArbre) {

	}
}
