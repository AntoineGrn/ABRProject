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
		//myController.createFileABR(abr);
		/*ABR abrSAG = new ABR();
		abrSAG.setRacine(55);
		ABR abrSAD2 = new ABR();
		abrSAD2.setRacine(75);
		ABR abrSAD3 = new ABR();
		abrSAD3.setRacine(63);
		ABR abrSAD = new ABR();
		abrSAD.setRacine(62);
		abrSAD.setSag(abrSAD3);
		abrSAD.setSad(abrSAD2);

		ABR arbre = new ABR();
		arbre.setRacine(60);
		arbre.setSag(abrSAG);
		arbre.setSad(abrSAD);*/
		//List<Integer> parcours = myController.getParcoursSuffixe(arbre);
		//System.out.println(parcours.toString());

		//myController.createFileABR(arbre);
	}
}
