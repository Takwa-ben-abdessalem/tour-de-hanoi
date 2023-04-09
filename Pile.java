/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fawez_takwa_gte1_projet_module;
public class Pile {
    private int tailleMax; // Taille maximale
    private int sommet = -1; // Sommet du tableau
    private int[] tab;
    // Constructeur: crée une pile vide de taille maximale donnée
    public Pile(int max) {
        tailleMax = max;
        sommet = -1;
        tab = new int[tailleMax];
    }
    public int[] getTab() {
        return tab;
    }
    /**
     * Teste si une pile est vide
     */
    public boolean EstVide() {
        return (sommet == -1);
    }
/**
 * Empiler
 */
public void Empiler(int v) {
        if (sommet == tailleMax - 1) {
            System.out.println("Impossible d'empiler: la pile est pleine");
        }
        sommet++;
        tab[sommet] = v;
    }
public void Empilement_depart() { 
        for (int i = 0; i < tailleMax; i++) {
            this.Empiler(tailleMax-i);
        }
    }
 /**
     * Dépiler
     */
    public void Depiler() {
        if (EstVide()) {
            System.out.println("la pile est vide");
        }
        sommet--;
    }
    // Affichage du tableau
    void Afficher() {
        System.out.print("[");
        for (int i = 0; i <= sommet ; i++) {
            System.out.print(tab[i]);
            if (i < sommet ) {
                System.out.print("-");
            }
        }
        System.out.println("]\n");
    }
     /**
     * Retourne la valeur du sommet
     */
    public int sommet() {
        if (EstVide()) {
            System.out.println("la pile est vide");
        }
        return (tab[sommet]);
    }
  }