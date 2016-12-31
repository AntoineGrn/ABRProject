import java.io.IOException;
import java.net.URISyntaxException;
import java.util.*;
import controleur.Controller;
import model.ABR;
import model.TabABR;

public class Main {
	
	public static void main (String[] args) throws IOException, URISyntaxException{
		Controller myController = new Controller();
	    System.out.println("Bienvenue sur le programme des arbres binaires de recherche \n");
		/*
		2.1 Génération, sauvegarde et affichage des TABRs
		 */
		System.out.println("------- 2.1 Génération, sauvegarde et affichage des TABRs ----------");
		System.out.println("------- FICHIER VERS TABR ----------");
		/* 1. fichier vers TABR */
		List<TabABR> liste = myController.readFileABR("bin/exemples/figure1.txt");
		System.out.println("------------------------------------");

		// création d'un ABR manuellement
		ABR abrSAG = new ABR();
		abrSAG.setRacine(155);
		ABR abrSAD2 = new ABR();
		abrSAD2.setRacine(175);
		ABR abrSAD3 = new ABR();
		abrSAD3.setRacine(161);
		ABR abrSAD = new ABR();
		abrSAD.setRacine(162);
		abrSAD.setSag(abrSAD3);
		abrSAD.setSad(abrSAD2);

		ABR arbre = new ABR();
		arbre.setRacine(160);
		arbre.setSag(abrSAG);
		arbre.setSad(abrSAD);

		System.out.println("--------- TABR VERS FICHIER --------");
		/* 2. TABR vers fichier */
		myController.createFileABR(arbre);
		System.out.println("------------------------------------");

		System.out.println("--------- AFFICHER TABR ------------");
		/* 3. afficher TABR */
		String abrToString = myController.toStringABR(arbre);
		System.out.println(abrToString);
		System.out.println("------------------------------------");

		System.out.println("--------- TABR ALEATOIRE -----------");
		/* 4. TABR aléatoire */
		int n = 4;
		int m = 3;
		myController.createTABRAleatoire(n, m);
		System.out.println("------------------------------------");

		System.out.println("--------- VERIFICATION -------------");
		/* 5. verification TABR */
		boolean verif = myController.verificationTABR(liste);
		System.out.println("TABR correct ? " + verif);
		System.out.println("------------------------------------");

		/*
		2.2 Manipulation des TABRs
		 */
		System.out.println("------- 2.1 Génération, sauvegarde et affichage des TABRs ----------");

		System.out.println("--------- INSERTION ENTIER -------------");
		/* 1. insertion d'un entier */
		int nbr = 21;
		TabABR tabr = myController.insertionEntierIntoTabr(nbr, liste);
		//myController.addTABRintoFile(tabr);
		System.out.println("------------------------------------");
	}
}
