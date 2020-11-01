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
public class Bosseur extends Thread {
    
    private long nbrIter;
    
    public Bosseur(long nbrIter) {
        this.nbrIter = nbrIter;
    }
    
    @Override
    public void run() {
        for(long i = 0 ; i < this.nbrIter ;i++) {
            Math.cos(1.0);
        }
        System.out.println("fini T");
    }
    
}
