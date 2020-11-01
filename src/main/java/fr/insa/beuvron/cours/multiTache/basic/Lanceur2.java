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
public class Lanceur2 {

    public static void lance(int nbrThread, long nbrIter) {

        Thread[] bosseurs = new Thread[nbrThread];
        for (int i = 0; i < nbrThread; i++) {
            bosseurs[i] = new Thread(new Runnable() {
                @Override
                public void run() {
                    for (long i = 0; i < nbrIter; i++) {
                        Math.cos(1.0);
                    }
                    System.out.println("fini T");
                }
            });
            bosseurs[i].start();
        }

        for (int i = 0; i < nbrThread; i++) {
            try {
                bosseurs[i].join();
            } catch (InterruptedException ex) {
                throw new Error("ne dois pas arriver", ex);
            }
        }
    }

    public static void main(String[] args) {
        lance(5, 100000);
        System.out.println("tout est fini");
    }

}
