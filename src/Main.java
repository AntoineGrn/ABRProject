import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.*;
import java.util.List;

import controleur.Controller;
import model.ABR;
import model.TabABR;

import javax.swing.*;


public class Main extends JFrame{
	public Main(String title) {
		super(title);
		Container con = getContentPane();

		JLabel label1 = new JLabel("Bienvenue sur le programme des arbres binaires de recherche");
		JLabel label2 = new JLabel("Menu");
		JButton button1 = new JButton("1. Fichier vers TABR");
		JButton button2 = new JButton("2. TABR vers fichier");
		JButton button3 = new JButton("3. Afficher TABR");
		JButton button4 = new JButton("4. TABR Aléatoire");
		JButton button5 = new JButton("5. Vérification");
		JButton button6 = new JButton("6. Insertion d'un entier");
		JButton button7 = new JButton("7. Suppression d'un entier");
		JButton button8 = new JButton("8. Fusion de deux cases du TABR");
		JButton button9 = new JButton("9. Equilibre en profondeur ABR");
		JButton button10 = new JButton("10. ABR vers TABR");
		JButton button11 = new JButton("11. TABR vers ABR");

		button1.addActionListener(new TraitementBut1());
		button2.addActionListener(new TraitementBut2());
		button3.addActionListener(new TraitementBut3());
		button4.addActionListener(new TraitementBut4());
		button5.addActionListener(new TraitementBut5());
		button6.addActionListener(new TraitementBut6());
		button7.addActionListener(new TraitementBut7());
		button8.addActionListener(new TraitementBut8());
		button9.addActionListener(new TraitementBut9());
		button10.addActionListener(new TraitementBut10());
		button11.addActionListener(new TraitementBut11());

		JPanel pane1 = new JPanel(new BorderLayout()); /* on peut spécifier le layout à la construction */
		JPanel pane2 = new JPanel(new GridLayout(0, 1));
		JPanel pane3 = new JPanel(new BorderLayout());
		pane1.add(label1, BorderLayout.NORTH);
		pane1.add(pane2, BorderLayout.CENTER);
		pane2.add(label2, BorderLayout.NORTH);
		pane2.add(button1);
		pane2.add(button2);
		pane2.add(button3);
		pane2.add(button4);
		pane2.add(button5);
		pane2.add(button6);
		pane2.add(button7);
		pane2.add(button8);
		pane2.add(button9);
		pane2.add(button10);
		pane2.add(button11);
		pane2.add(pane3, BorderLayout.SOUTH);
		con.add(pane1, BorderLayout.CENTER);

	}


	public class TraitementBut1 implements ActionListener
	{
		/**
		 * obligatoire car test implémente l'interface ActionListener
		 */
		public void actionPerformed(ActionEvent e) {
			Controller myController = new Controller();
			System.out.println("1. Fichier vers TABR");

            CustomFrame1 frame2 = new CustomFrame1("1. Fichier vers TABR");
            String s = (String)JOptionPane.showInputDialog(frame2, "Veuillez saisir l'emplacement du fichier : \nExemple : bin/exemples/figure1.txt ");

			/* 1. fichier vers TABR */
			try {
				List<TabABR> liste = myController.readFileABR(s);
                JOptionPane.showMessageDialog(frame2,
                        myController.toStringListTABR(liste),
                        "Résultat",
                        JOptionPane.PLAIN_MESSAGE);
			} catch (IOException e1) {
				e1.printStackTrace();
			} catch (URISyntaxException e1) {
				e1.printStackTrace();
			}
		}
	}
	public class TraitementBut2 implements ActionListener
	{
		/**
		 * obligatoire car test implémente l'interface ActionListener
		 */
		public void actionPerformed(ActionEvent e)
		{
            Controller myController = new Controller();
            System.out.println("2. TABR vers fichier");

            // création d'un ABR manuellement
            ABR abrSAG = new ABR();
            abrSAG.setRacine(155);
            ABR abrSAD2 = new ABR();
            abrSAD2.setRacine(175);
            abrSAD2.setSad(new ABR(180, null, null));
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

            CustomFrame1 frame2 = new CustomFrame1("2. TABR vers fichier");

            String s = (String)JOptionPane.showInputDialog(frame2, myController.toStringListTABR(listeTabr),"Création d'un TABR manuellement.\n" +
                    "Veuillez saisir l'emplacement du fichier dans lequel vous voulez sauvegarder le TABR : \n" +
                    "Exemple : bin/exemples/figure2.txt ");

			/* 2. TABR vers fichier */

            myController.addListTABRintoNewFile(listeTabr, s);
            JOptionPane.showMessageDialog(frame2,
                    "TABR sauvegardé avec succès",
                    "Résultat",
                    JOptionPane.PLAIN_MESSAGE);

		}
	}
	public class TraitementBut3 implements ActionListener
	{
		/**
		 * obligatoire car test implémente l'interface ActionListener
		 */
		public  void    actionPerformed(ActionEvent e)
		{
            Controller myController = new Controller();
            System.out.println("3. Afficher TABR");

            // création d'un ABR manuellement
            ABR abrSAG = new ABR();
            abrSAG.setRacine(155);
            ABR abrSAD2 = new ABR();
            abrSAD2.setRacine(175);
            abrSAD2.setSad(new ABR(180, null, null));
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

            CustomFrame1 frame2 = new CustomFrame1("3. Afficher TABR");

			/* 3. afficher TABR */
            JOptionPane.showMessageDialog(frame2,
                    myController.toStringABR(arbre),
                    "Résultat (affichage du TABR présent dans le fichier figure2.txt)",
                    JOptionPane.PLAIN_MESSAGE);

		}
	}
	public  class   TraitementBut4 implements   ActionListener
	{
		/**
		 * obligatoire car test implémente l'interface ActionListener
		 */
		public  void    actionPerformed(ActionEvent e)
		{
            Controller myController = new Controller();
            System.out.println("4. Générer TABR aléatoire");

            CustomFrame1 frame2 = new CustomFrame1("4. Générer TABR aléatoire");
            String n = JOptionPane.showInputDialog(frame2, "Veuillez saisir le nombre n représentant le nombre de cases du TABR : ");
            String m = JOptionPane.showInputDialog(frame2, "Veuillez saisir le nombre m représentant le nombre max du TABR : ");

            int nInt = Integer.parseInt(n);
            int mInt = Integer.parseInt(m);
            List<TabABR> tabrAleatoire = myController.createTABRAleatoire(nInt, mInt);
            JOptionPane.showMessageDialog(frame2,
                    myController.toStringListTABR(tabrAleatoire),
                    "Résultat",
                    JOptionPane.PLAIN_MESSAGE);
        }
	}
	public  class   TraitementBut5 implements   ActionListener
	{
		/**
		 * obligatoire car test implémente l'interface ActionListener
		 */
		public  void    actionPerformed(ActionEvent e)
		{
            Controller myController = new Controller();
            System.out.println("5. Vérification TABR");

            CustomFrame1 frame2 = new CustomFrame1("5. Vérification TABR");
            String s = (String)JOptionPane.showInputDialog(frame2, "Veuillez saisir l'emplacement du fichier : \nExemple : bin/exemples/figure1.txt ");

            try {
                List<TabABR> liste = myController.readFileABR(s);
                boolean verif = myController.verificationTABR(liste);
                /* 5. Vérification TABR */
                JOptionPane.showMessageDialog(frame2,
                        verif ? "ABR équilibré" : "ABR non équilibré",
                        "Résultat",
                        JOptionPane.PLAIN_MESSAGE);
            } catch (IOException e1) {
                e1.printStackTrace();
            } catch (URISyntaxException e1) {
                e1.printStackTrace();
            }

		}
	}

    public  class   TraitementBut6 implements   ActionListener
    {
        /**
         * obligatoire car test implémente l'interface ActionListener
         */
        public  void    actionPerformed(ActionEvent e)
        {
            /* 6. Insertion d'un entier dans un TABR */
            Controller myController = new Controller();
            System.out.println("6. Insertion d'un entier dans un TABR");

            CustomFrame1 frame2 = new CustomFrame1("6. Insertion d'un entier dans un TABR");
            int entier = Integer.parseInt(JOptionPane.showInputDialog(frame2, "Veuillez saisir un entier à ajouter : "));
            List<TabABR> liste = null;
            try {
                liste = myController.readFileABR("bin/exemples/figure1.txt");
            } catch (IOException e1) {
                e1.printStackTrace();
            } catch (URISyntaxException e1) {
                e1.printStackTrace();
            }
            TabABR tabr = myController.insertionEntierIntoTabr(entier, liste);

            JOptionPane.showMessageDialog(frame2,
                    myController.toStringTABR(tabr),
                    "Résultat",
                    JOptionPane.PLAIN_MESSAGE);
        }
    }

    public  class   TraitementBut7 implements   ActionListener
    {
        /**
         * obligatoire car test implémente l'interface ActionListener
         */
        public  void    actionPerformed(ActionEvent e)
        {
            /* 7. Suppression d'un entier dans un TABR*/
            Controller myController = new Controller();
            System.out.println("7. Suppression d'un entier dans un TABR");

            CustomFrame1 frame2 = new CustomFrame1("7. Suppression d'un entier dans un TABR");
            int entier = Integer.parseInt(JOptionPane.showInputDialog(frame2, "Veuillez saisir un entier à supprimer : "));
            List<TabABR> liste = null;
            try {
                liste = myController.readFileABR("bin/exemples/figure1.txt");
                List<TabABR> tabrSupp = myController.suppressionEntierIntoTabr(entier, liste);
                String s = myController.toStringListTABR(tabrSupp);
                JOptionPane.showMessageDialog(frame2,
                        s,
                        "Résultat",
                        JOptionPane.PLAIN_MESSAGE);
            } catch (IOException e1) {
                e1.printStackTrace();
            } catch (URISyntaxException e1) {
                e1.printStackTrace();
            }
        }
    }

    public  class   TraitementBut8 implements   ActionListener
    {
        /**
         * obligatoire car test implémente l'interface ActionListener
         */
        public  void    actionPerformed(ActionEvent e)
        {
            /* 8. Fusion de deux cases du TABR*/
            Controller myController = new Controller();
            System.out.println("8. Fusion de deux cases du TABR");

            CustomFrame1 frame2 = new CustomFrame1("8. Fusion de deux cases du TABR");
            int entier = Integer.parseInt(JOptionPane.showInputDialog(frame2, "Veuillez saisir l'indice de la case du TABR à fusionner avec la suivante : "));
            List<TabABR> liste = null;
            try {
                liste = myController.readFileABR("bin/exemples/figure1.txt");
                List<TabABR> tabrFusion = myController.fusionCasesTabr(entier, liste);
                String s = myController.toStringListTABR(tabrFusion);
                JOptionPane.showMessageDialog(frame2,
                        s,
                        "Résultat",
                        JOptionPane.PLAIN_MESSAGE);
            } catch (IOException e1) {
                e1.printStackTrace();
            } catch (URISyntaxException e1) {
                e1.printStackTrace();
            }
        }
    }

    public  class   TraitementBut9 implements   ActionListener
    {
        /**
         * obligatoire car test implémente l'interface ActionListener
         */
        public  void    actionPerformed(ActionEvent e)
        {
            /* 9. Equilibre en profondeur d'un ABR*/
            Controller myController = new Controller();
            System.out.println("9. Equilibre en profondeur d'un ABR");

            // création d'un ABR manuellement
            ABR abrSAG = new ABR();
            abrSAG.setRacine(155);
            ABR abrSAD2 = new ABR();
            abrSAD2.setRacine(175);
            abrSAD2.setSad(new ABR(180, null, null));
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

            CustomFrame1 frame2 = new CustomFrame1("9. Equilibre en profondeur d'un ABR");
            boolean resultEquilibre = myController.equilibreABR(arbre);
            JOptionPane.showMessageDialog(frame2,
                    resultEquilibre ? "L'arbre est équilibré" : "L'arbre n'est pas équilibré",
                    "Résultat",
                    JOptionPane.PLAIN_MESSAGE);

        }
    }

    public  class   TraitementBut10 implements   ActionListener
    {
        /**
         * obligatoire car test implémente l'interface ActionListener
         */
        public  void    actionPerformed(ActionEvent e)
        {
            /* 10. ABR vers TABR*/
            Controller myController = new Controller();
            System.out.println("10. ABR vers TABR");

            CustomFrame1 frame2 = new CustomFrame1("10. ABR vers TABR");

            // la liste d'intervalle doit contenir des valeurs rangées dans l'ordre croissant et compris entre min et max
            List<Integer> listeIntervalle = new ArrayList<>();
            String s1 = JOptionPane.showInputDialog(frame2, "Veuillez saisir les intervalles de la manière suivante : \nExemple : 19;61");
            String[] split = s1.split(";");
            for (String string: split) {
                int i = Integer.parseInt(string);
                listeIntervalle.add(i);
            }
            List<TabABR> liste = null;
            try {
                liste = myController.readFileABR("bin/exemples/figure1.txt");
                List<TabABR> tabrFusion = myController.fusionCasesTabr(1, liste);
                int min = tabrFusion.get(1).getDebut();
                int max = tabrFusion.get(1).getFin();
                List<TabABR> tabABRList = myController.transformABRtoTABR(tabrFusion.get(1).getArbre(), min, max, listeIntervalle);

                String s = myController.toStringListTABR(tabABRList);
                JOptionPane.showMessageDialog(frame2,
                        s,
                        "Résultat",
                        JOptionPane.PLAIN_MESSAGE);
            } catch (IOException e1) {
                e1.printStackTrace();
            } catch (URISyntaxException e1) {
                e1.printStackTrace();
            }
        }
    }

    public  class   TraitementBut11 implements   ActionListener
    {
        /**
         * obligatoire car test implémente l'interface ActionListener
         */
        public  void    actionPerformed(ActionEvent e)
        {
            /* 11. TABR vers ABR*/
            Controller myController = new Controller();
            System.out.println("11. TABR vers ABR");

            CustomFrame1 frame2 = new CustomFrame1("11. TABR vers ABR");
            List<TabABR> liste = null;
            try {
                liste = myController.readFileABR("bin/exemples/figure1.txt");
                TabABR tabrResult = myController.transformTABRtoABR(liste);
                String s = myController.toStringTABR(tabrResult);
                JOptionPane.showMessageDialog(frame2,
                        s,
                        "Résultat",
                        JOptionPane.PLAIN_MESSAGE);
            } catch (IOException e1) {
                e1.printStackTrace();
            } catch (URISyntaxException e1) {
                e1.printStackTrace();
            }
        }
    }

	public static void main (String[] args) throws IOException, URISyntaxException{
		Controller myController = new Controller();
		System.out.println("Bienvenue sur le programme des arbres binaires de recherche \n");

		Main frame = new Main("Arbre Binaire de Recherche");
		frame.setSize(400, 400);
        frame.setVisible(true);

		/*
		2.1 Génération, sauvegarde et affichage des TABRs
		 *//*
		System.out.println("------- 2.1 Génération, sauvegarde et affichage des TABRs ----------");
		System.out.println("------- FICHIER VERS TABR ----------");
		*//* 1. fichier vers TABR *//*
		List<TabABR> liste = myController.readFileABR("bin/exemples/figure1.txt");
		System.out.println("------------------------------------");

		// création d'un ABR manuellement
		ABR abrSAG = new ABR();
		abrSAG.setRacine(155);
		ABR abrSAD2 = new ABR();
		abrSAD2.setRacine(175);
		abrSAD2.setSad(new ABR(180, null, null));
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
		*//* 2. TABR vers fichier *//*
		myController.addListTABRintoNewFile(listeTabr, "bin/exemples/figure2.txt");
		System.out.println("------------------------------------");

		System.out.println("--------- AFFICHER TABR ------------");
		*//* 3. afficher TABR *//*
		String abrToString = myController.toStringABR(arbre);
		System.out.println(abrToString);
		System.out.println("------------------------------------");

		System.out.println("--------- TABR ALEATOIRE -----------");
		*//* 4. TABR aléatoire *//*
		int n = 4;
		int m = 3;
		myController.createTABRAleatoire(n, m);
		System.out.println("------------------------------------");

		System.out.println("--------- VERIFICATION -------------");
		*//* 5. verification TABR *//*
		boolean verif = myController.verificationTABR(liste);
		System.out.println("TABR correct ? " + verif);
		System.out.println("------------------------------------");

		*//*
		2.2 Manipulation des TABRs
		 *//*
		System.out.println("------- 2.1 Génération, sauvegarde et affichage des TABRs ----------");

		System.out.println("--------- INSERTION ENTIER ---------");
		*//* 1. insertion d'un entier *//*
		int nbr = 21;
		TabABR tabr = myController.insertionEntierIntoTabr(nbr, liste);
		System.out.println("------------------------------------");

		System.out.println("-------- SUPPRESSION ENTIER --------");
		*//* 2. suppression d'un entier *//*
		int nbrSupp = 14;
		List<TabABR> tabrSupp = myController.suppressionEntierIntoTabr(nbrSupp, liste);
		System.out.println("------------------------------------");

		System.out.println("---- FUSION DE DEUX CASES TABR -----");
		*//* 3. fusion de deux cases du TABR *//*
		int indice = 1;
		List<TabABR> tabrFusion = myController.fusionCasesTabr(indice, liste);
		System.out.println(myController.toStringListTABR(tabrFusion));
		System.out.println("------------------------------------");

		System.out.println("---- EQUILIBRE EN PROFONDEUR ABR ---");
		*//* 4. équilibre en profondeur d'un ABR *//*
		boolean resultEquilibre = myController.equilibreABR(arbre);
		if (resultEquilibre) {
			System.out.println("L'abre est équilibré");
		}
		System.out.println("------------------------------------");

		System.out.println("----------- ABR VERS TABR ----------");
		*//* 5. ABR vers TABR *//*
		int min = tabrFusion.get(1).getDebut();
		int max = tabrFusion.get(1).getFin();
		// la liste d'intervalle doit contenir des valeurs rangées dans l'ordre croissant et compris entre min et max
		List<Integer> listeIntervalle = new ArrayList<>();
		listeIntervalle.add(tabrFusion.get(1).getDebut()+10);
		listeIntervalle.add(tabrFusion.get(1).getDebut()+50);
		List<TabABR> tabABRList = myController.transformABRtoTABR(tabrFusion.get(1).getArbre(), min, max, listeIntervalle);
		System.out.println(myController.toStringListTABR(tabABRList));
		System.out.println("------------------------------------");

		System.out.println("----------- TABR VERS ABR ----------");
		*//* 6. TABR vers ABR *//*
		TabABR tabrResult = myController.transformTABRtoABR(tabABRList);
		System.out.println(myController.toStringTABR(tabrResult));
		System.out.println("------------------------------------");*/
	}
}
