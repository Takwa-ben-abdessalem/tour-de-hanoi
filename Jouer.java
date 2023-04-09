package fawez_takwa_gte1_projet_module;
import static fawez_takwa_gte1_projet_module.Jeux.best_score;
import static fawez_takwa_gte1_projet_module.Jeux.deplacer_Pile;
import static fawez_takwa_gte1_projet_module.Jeux.ecrire;
import static fawez_takwa_gte1_projet_module.Jeux.hanoi;
import static fawez_takwa_gte1_projet_module.Jeux.islike;
import java.util.Scanner;
public class Jouer {
    public static void main(String[] argv) {
        int dep = 0;
        Scanner sc = new Scanner(System.in);
        System.out.println("Veuillez entrer votre nom :");
        String nom = sc.nextLine();
        Scanner mc = new Scanner(System.in);
        System.out.println(" Bonjour " + nom + " nous represontons ce jeu développé par Fawez Saafi et Takwa Ben Abdesslam mais avant de commencer nous vous rappelons des règles du jeu \n"
                + "On ne peut déplacer plus d'un disque à la fois. \n"
                + "On ne peut placer un disque que sur un autre disque plus grand que lui ou sur un emplacement vide. \n"
                + "Amusez-vous \n");
               System.out.println("veillez saisir le niveau de jeu ");
        int n = mc.nextInt();
        System.out.println("Vous avez saisi : " + n); 
        int score = 0;
        Pile A = new Pile(n);
        Pile B = new Pile(n);
        Pile C = new Pile(n);
        Pile aux = new Pile(n);
        A.Empilement_depart();
        aux.Empilement_depart();
        A.Afficher();
        B.Afficher();
        C.Afficher();
        boolean verif = true;
        while (verif) {
            deplacer_Pile(A, B, C);
            System.out.print("si vous voulez continuer le jeux taper ENTRER \n si vous voulez avoir la solution tapez 2 \n si vous voulez quitter le jeu"
                    + " tapez 3 ");
            Scanner ml = new Scanner(System.in);
            String choix = ml.nextLine();
            if (islike(aux, C) == true) {
                verif = false;
            }
            if ("2".equals(choix)) {
                hanoi(n, "A", "B", "C");
                System.out.println("don't give up try again !!! ");
                System.exit(0);
            }
            if ("3".equals(choix)) {
                System.exit(0);
            }
            dep++;
        }
        if (islike(aux, C) == true) {
            score = n * 100;
            if (dep == (2 ^ n - 1)) { //gagnez le jeux avec un nombre de deplacement minimal
                System.out.println("Bravo ! vous avez gagnez le jeux avec un nombre de deplacements minimal");
                score = score + 200;
            }
            System.out.println("felicitation vous avez gagnez le jeux votre score est : " + score);
            ecrire(nom,score) ;
            best_score(nom) ; 
        }
    }
}