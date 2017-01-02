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
		TabABR newtabr = myController.createTabrByAbr(arbre);
		ArrayList<TabABR> listeTabr = new ArrayList<TabABR>();
		listeTabr.add(newtabr);

		System.out.println("--------- TABR VERS FICHIER --------");
		/* 2. TABR vers fichier */
		myController.addListTABRintoNewFile(listeTabr, "bin/exemples/figure2.txt");
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

		System.out.println("--------- INSERTION ENTIER ---------");
		/* 1. insertion d'un entier */
		int nbr = 21;
		TabABR tabr = myController.insertionEntierIntoTabr(nbr, liste);
		System.out.println("------------------------------------");

		System.out.println("-------- SUPPRESSION ENTIER --------");
		/* 2. suppression d'un entier */
		int nbrSupp = 15;
		List<TabABR> tabrSupp = myController.suppressionEntierIntoTabr(nbrSupp, liste);
		System.out.println("------------------------------------");

		System.out.println("---- FUSION DE DEUX CASES TABR -----");
		/* 3. fusion de deux cases du TABR */
		int indice = 1;
		List<TabABR> tabrFusion = myController.fusionCasesTabr(indice, liste);
		System.out.println(myController.toStringListTABR(tabrFusion));
		System.out.println("------------------------------------");

		System.out.println("---- EQUILIBRE EN PROFONDEUR ABR ---");
		/* 3. équilibre en profondeur d'un ABR */
		ABR abrEquilibre = myController.equilibreABR(arbre);
		System.out.println(myController.toStringABR(abrEquilibre));
		System.out.println("------------------------------------");

		System.out.println("----------- ABR VERS TABR ----------");
		/* 4. ABR vers TABR */

		System.out.println("------------------------------------");

		System.out.println("----------- TABR VERS ABR ----------");
		/* 5. TABR vers ABR */

		System.out.println("------------------------------------");
	}
}
