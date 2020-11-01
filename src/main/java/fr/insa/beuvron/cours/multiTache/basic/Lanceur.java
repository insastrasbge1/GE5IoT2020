/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.insa.beuvron.cours.multiTache.basic;

/**
 *
 * @author francois
 */
public class Lanceur {
    
    public static void lance(int nbrThread,long nbrIter){
        
        Bosseur[] bosseurs = new Bosseur[nbrThread];
        for(int i = 0 ; i < nbrThread ; i ++) {
            bosseurs[i] = new Bosseur(nbrIter);
            bosseurs[i].start();
        }
        
        for(int i = 0 ; i < nbrThread ; i ++) {
            try {
            bosseurs[i].join();
            } catch (InterruptedException ex) {
                throw new Error("ne dois pas arriver",ex);
            }
        }
    }
    
    public static void main(String[] args) {
        lance(5,100000);
        System.out.println("tout est fini");
    }
    
}
