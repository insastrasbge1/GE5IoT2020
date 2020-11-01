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
public class IncrementeurSynchroTouteLaMethode implements Runnable {

    public static final long NBR_INC = 1000000;

    public int compteur = 0;

    @Override
    public synchronized void run() {
        for (long i = 0; i < IncrementeurSynchroTouteLaMethode.NBR_INC; i++) {
            this.compteur++;
        }
    }

    public static void test() {
        long curTime = System.currentTimeMillis();
        IncrementeurSynchroTouteLaMethode i1 = new IncrementeurSynchroTouteLaMethode();
        int nbrThread = 50;
        Thread[] bosseurs = new Thread[nbrThread];
        for (int i = 0; i < nbrThread; i++) {
            bosseurs[i] = new Thread(i1);
            bosseurs[i].start();
        }
        for (int i = 0; i < nbrThread; i++) {
            ThreadUtils.joinSansInterrupt(bosseurs[i]);
        }
        System.out.println("compteur final : " + i1.compteur
                + "(valeur attendue : " + (nbrThread * NBR_INC));
        System.out.println("temps : " + (System.currentTimeMillis() - curTime));
    }

    public static void main(String[] args) {
        test();
    }

}
