/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.insa.beuvron.cours.multiTache.exo7;

import fr.insa.beuvron.cours.multiTache.ThreadUtils;

/**
 *
 * @author francois
 */
public class RunAsRunnable {

    public static void test(int nbrThread, long nc) {
        long curTime = System.currentTimeMillis();
        Thread[] bosseurs = new Thread[nbrThread];
        AsRunnable[] run = new AsRunnable[nbrThread];
        for (int i = 0; i < nbrThread; i++) {
            run[i] = new AsRunnable(nc);
            bosseurs[i] = new Thread(run[i]);
            bosseurs[i].start();
        }
        long valFinale = 0;
        for (int i = 0; i < nbrThread; i++) {
            ThreadUtils.joinSansInterrupt(bosseurs[i]);
            valFinale = run[i].getResultat() + valFinale;
        }
        System.out.println("compteur final : " + valFinale
                + "(valeur attendue : " + (nbrThread * nc));
        System.out.println("temps : " + (System.currentTimeMillis() - curTime));
    }

    public static void main(String[] args) {
        test(50, 100000);
    }

}
