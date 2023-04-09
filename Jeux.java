package fawez_takwa_gte1_projet_module;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author 21658
 */
public class Jeux {
    private static String[] arg;
    /* saisir la position a deplacé */
    public static String saisir(String str) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Veuillez saisir la position de " + str + "   : \n ");
        String dep = sc.nextLine();
        return (dep);
    }
    /* verifier les conditions du Tour de Hanoi*/
    public static boolean verif(Pile P1, Pile P2) {
        if (P2.EstVide()) {
            return (true);
        } else if (P2.sommet() > P1.sommet()) {
            return (true);
        } else {
            return (false);
        }
    }
    /* deplacer l'anneau de position A vers la position B */
    public static void deplacer(Pile A, Pile B) {
        if (verif(A, B)) {
            B.Empiler(A.sommet());
            A.Depiler();
        } else {
            System.out.print("imposible de faire ca");
        }
    }
    /* deplacer l'anneau tout en respecatnt les regles du tour de hanoi */
    public static void deplacer_Pile(Pile A, Pile B, Pile C) {
        String dep = saisir("depart");
        String arr = saisir("arrivé");
        if ("A".equals(dep)) {
            if ("B".equals(arr)) {
                deplacer(A, B);
            }
            if ("C".equals(arr)) {
                deplacer(A, C);
            }
        }
        if ("B".equals(dep)) {
            if ("A".equals(arr)) {
                deplacer(B, A);
            }
            if ("C".equals(arr)) {
                deplacer(B, C);
            }
        }
        if ("C".equals(dep)) {
            if ("B".equals(arr)) {
                deplacer(C, B);
            }
            if ("A".equals(arr)) {
                deplacer(C, A);
            }
        }
        System.out.println("la Tour A");
        A.Afficher();
        System.out.println("la Tour B");
        B.Afficher();
        System.out.println("la tour C");
        C.Afficher();
    }
    /* simulation du tour de hanoi */
    public static void hanoi(int n, String from, String temp, String to) {
        if (n == 0) {
            return;
        }
        hanoi(n - 1, from, to, temp);
        System.out.println("Bougez le disque " + n + " de " + from + " à " + to);
        hanoi(n - 1, temp, from, to);
    }
    public static boolean islike(Pile P1, Pile P2) {
        boolean verif = true;
        int i = 0;
        while ((verif) && (i < P1.getTab().length)) {
            for (int j = 0; j < P2.getTab().length; j++) {
                if (P2.getTab()[i] != P1.getTab()[j]) {
                    verif = false;
                } else {
                    i++;
                }
            }
        }
        return (verif);
    }
    public static void ecrire(String name, int score) {
        FileWriter file = null;
        try {
            file = new FileWriter(name + ".txt", true);
            file.write(score + "\n");
            file.close();
        } catch (IOException ex) {
            Logger.getLogger(BWframe.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                file.close();
            } catch (IOException ex) {
                Logger.getLogger(BWframe.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    public static void best_score(String str) {
        try {
            Scanner file = new Scanner(new File(str + ".txt"));
            int largest = file.nextInt();
            while (file.hasNextInt()) {
                int number = file.nextInt();
                if (number > largest) {
                    largest = number;
                }
            }
            file.close();
            System.out.println("the best score is : " + largest);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}