import java.io.IOException;
import java.net.URISyntaxException;
import controleur.Controller;

public class Main {
	
	public static void main (String[] args) throws IOException, URISyntaxException{
		Controller myController = new Controller();
	    System.out.println("Hello World");
	    myController.readFileABR("./exemples.figure1.txt");
	}
}
