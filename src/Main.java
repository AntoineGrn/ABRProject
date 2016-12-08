import java.io.IOException;
import java.net.URISyntaxException;
import java.util.*;


import controleur.Controller;
import model.ABR;

public class Main {
	
	public static void main (String[] args) throws IOException, URISyntaxException{
		Controller myController = new Controller();
	    System.out.println("Hello World");
	    myController.readFileABR("bin/exemples/figure1.txt");
		List<Integer> parcoursSuffixe = new ArrayList<Integer>();
		parcoursSuffixe.add(11);
		parcoursSuffixe.add(14);
		parcoursSuffixe.add(9);
		ABR abr = new ABR(9, 22, parcoursSuffixe);
		myController.createFileABR(abr);
	}
}
