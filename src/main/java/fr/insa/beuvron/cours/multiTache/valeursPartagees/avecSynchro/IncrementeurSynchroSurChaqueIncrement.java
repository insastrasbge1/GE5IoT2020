/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.insa.beuvron.cours.multiTache.valeursPartagees.avecSynchro;

import fr.insa.beuvron.cours.multiTache.valeursPartagees.sansSynchro.*;
import fr.insa.beuvron.cours.multiTache.ThreadUtils;

/**
 *
 * @author francois
 */
public class IncrementeurSynchroSurChaqueIncrement implements Runnable {

    public static final long NBR_INC = 1000000;

    public int compteur = 0;

    @Override
    public void run() {
        for (long i = 0; i < IncrementeurSynchroSurChaqueIncrement.NBR_INC; i++) {
            synchronized (this) {
                this.compteur++;
            }
        }
    }

    public static void test() {
        long curTime = System.currentTimeMillis();
        IncrementeurSynchroSurChaqueIncrement i1 = new IncrementeurSynchroSurChaqueIncrement();
        int nbrThread = 50;
        Thread[] bosseurs = new Thread[nbrThread];
        for(int i = 0 ; i < nbrThread ; i ++) {
            bosseurs[i] = new Thread(i1);
            bosseurs[i].start();
        }
        for(int i = 0 ; i < nbrThread ; i ++) {
            ThreadUtils.joinSansInterrupt(bosseurs[i]);
        }
        System.out.println("compteur final : " + i1.compteur
                + "(valeur attendue : " + (2 * NBR_INC));
        System.out.println("temps : " + (System.currentTimeMillis() - curTime));
    }

    public static void main(String[] args) {
        test();
    }

}
